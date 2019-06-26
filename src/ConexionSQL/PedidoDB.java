package ConexionSQL;

import ClasesPrincipales.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDB {
    public ArrayList<Pedido> listaPedido(){
        ArrayList<Pedido> listaPedidos = new ArrayList();
        try{
            Connection cnx = DatabaseConnect.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("     SELECT IDPEDIDO,FECHA,CANTIDAD,OBSERVACION,PRODUCTO,SEDE FROM PEDIDO ORDER BY 1    ");
            while(rs.next()){
                Pedido ped = new Pedido(rs.getInt("IDPEDIDO"),rs.getString("FECHA"),rs.getInt("CANTIDAD"),rs.getString("OBSERVACION"),rs.getString("PRODUCTO"),rs.getString("SEDE"));
                listaPedidos.add(ped);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en el listado");
        }
        return listaPedidos;
    }
    public void insertarPedido(String fecha,int cantidad,String observacion, String producto,String sede){
        try{
            Connection cnx = DatabaseConnect.getConnection();
            PreparedStatement pst = null;
            //String sql = "INSERT INTO PEDIDO VALUES(sq_pedido.nextval,?,?,?,?,?)";
            //String sql = "sp_agregarpedido(sq_pedido.nextval,?,?,?,?,?)";
            String sql = "  begin\n sp_agregarpedido('"+fecha+"',"+cantidad+",'"+observacion+"','"+producto+"','"+sede+"'); \n end;";
            pst = cnx.prepareStatement(sql);
            /**pst.setString(1, fecha);
            pst.setInt(2, cantidad);
            pst.setString(3, observacion);
            pst.setString(4, producto);
            pst.setString(5, sede);**/
            pst.executeQuery();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en el insert");
        }
    }
    public void modificarPedido(int indice,String fecha,int cantidad,String observacion,String producto, String sede) {
        try{
            Connection cnx = DatabaseConnect.getConnection();
            PreparedStatement pst = cnx.prepareStatement("  begin\n sp_modificarpedido("+indice+","+"'"+fecha+"'"+","+cantidad+","+"'"+observacion+"'"+","+"'"+producto+"'"+","+"'"+sede+"'"+"); \n end;     ");
                                                         //" begin\n SP_UPDATEOBJETO("+id_o+","+"'"+nomb+"'"+","+precio+","+stock+");\n end;"
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en modificar");
        }
    }
}