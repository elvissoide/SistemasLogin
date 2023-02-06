package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCrud {
    Conexiondb conectar = new Conexiondb();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public void eliminar(int id){
        String sql = "DELETE FROM usuarios WHERE idusuarios="+id;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public int actualizar(Usuario u){
        String sql = "UPDATE usuarios SET nombreusuarios=?, apellidousuarios=?, celularusuarios=?," +
                "correousuarios=? WHERE idusuarios=?";
        int r = 0;
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getTelefono());
            ps.setString(4, u.getCorreo());
            ps.setInt(5, u.getId());
            r = ps.executeUpdate();
            if (r == 1){
                return 1;
            } else{
                return 0;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }
    public List listar(){
        List<Usuario>datos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario p = new Usuario();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                p.setTelefono(rs.getString(4));
                p.setCorreo(rs.getString(5));
                datos.add(p);
            }
            con.close();
            ps.close();
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return datos;
    }

    public int agregar(Usuario usuario){
        String sql = "INSERT INTO usuarios VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.executeUpdate();
            con.close();
            ps.close();
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
