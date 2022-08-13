package com.example.persona.Servicio.persona;


import com.example.persona.Servicio.modelo.BeanPersona;
import com.example.persona.Utils.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoPersona {


    public boolean registrarPersona(BeanPersona persona) {

        try (Connection con = conexion.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into persona(nombre,surname,curp,cumple) values (?,?,?,?)")
            ) {
                pstm.setString(1, persona.getNombre());
                pstm.setString(2, persona.getSurname());
                pstm.setString(3, persona.getCurp());
                pstm.setString(4, persona.getCumple());


                return pstm.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //funcional
    public static List<BeanPersona> getTodosPersonas() {
        List<BeanPersona> list = new ArrayList<BeanPersona>();
        try {
            Connection con=conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from persona");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BeanPersona e = new BeanPersona();
                e.setId_persona(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setSurname(rs.getString("surname"));
                e.setCurp(rs.getString("curp"));
                e.setCumple(rs.getString("cumple"));
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void main(String[] args) {
        System.out.println(DaoPersona.getTodosPersonas());

    }

}
