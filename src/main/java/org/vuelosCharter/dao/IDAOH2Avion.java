package org.vuelosCharter.dao;

import org.vuelosCharter.models.Avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IDAOH2Avion implements IDAO<Avion>{


    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
    private static final String SQL_CREATE_TABLA = "DROP TABLE IF EXISTS AVIONES;"+
    "CREATE TABLE AVIONES (MARCA VARCHAR(100) NOT NULL, MODELO VARCHAR(100) NOT NULL, MATRICULA VARCHAR(100) NOT NULL, ENTRADA_EN_SERVICIO DATE NOT NULL, ID INT AUTO_INCREMENT PRIMARY KEY)";

    private static final String SQL_REGISTRAR_AVION ="INSERT INTO AVIONES (MARCA, MODELO, MATRICULA, ENTRADA_EN_SERVICIO) VALUES(?,?,?,?)";



    public static void crearTablas(){
        Connection connection=null;
        try {
            connection=getConnection();
            Statement statement=connection.createStatement();
            statement.execute(SQL_CREATE_TABLA);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public Avion registrarAvion(Avion avion) {

        Connection connection=null;
        try{
            connection=getConnection();
            PreparedStatement ps_registrarAvion= connection.prepareStatement(SQL_REGISTRAR_AVION, Statement.RETURN_GENERATED_KEYS);
            ps_registrarAvion.setString(1, avion.getMarca());
            ps_registrarAvion.setString(2, avion.getModelo());
            ps_registrarAvion.setString(3, avion.getMatricula());
            ps_registrarAvion.setDate(4, Date.valueOf(avion.getEntradaEnServicio()));
            ps_registrarAvion.execute();
            ResultSet rs = ps_registrarAvion.getGeneratedKeys();
            while (rs.next()){
                avion.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return avion;
    }

    @Override
    public Avion traerAvion(Integer id) {
        Connection connection=null;
        Avion avion=null;
        try {
            connection=getConnection();
            PreparedStatement ps_select=connection.prepareStatement("SELECT * FROM AVIONES WHERE ID=?");
            ps_select.setInt(1,id);
            ResultSet rs= ps_select.executeQuery();
            while (rs.next()){
            avion = new Avion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getInt(5));}
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return avion;
    }

    @Override
    public void darDeBajaAvion(Integer id) {
        Connection connection = null;
        try {
            connection=getConnection();
            PreparedStatement ps_delete = connection.prepareStatement("DELETE FROM AVIONES WHERE ID =?");
            ps_delete.setInt(1,id);
            ps_delete.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Avion> visualizarTodaLaFlota() {
        Connection connection=null;
        Avion avion =null;
        List<Avion> aviones=new ArrayList<>();
        try {
            connection=getConnection();
            Statement stmt=connection.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM AVIONES");
            while (rs.next()){
                avion=new Avion(rs.getString("MARCA"), rs.getString("MODELO"), rs.getString("MATRICULA"), rs.getDate("ENTRADA_EN_SERVICIO").toLocalDate(), rs.getInt("ID"));
            aviones.add(avion);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return aviones;
    }
}
