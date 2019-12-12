import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denizcan
 */
public class SQLUtilities {
    
    public static ResultSet getUsersSet;
    public static ResultSet getUsersData;
    protected static ResultSet getItemData;
    public static Connection DBConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://cs320project-1.duckdns.org/cs320DB";
        String user = "app";
        int port = 3306;
        String pass = "passpass";
       
        
        try{
            
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
                    
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
//        catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
        return conn;
    }
    protected static void Update_table(JTable UserTable){
        try{
            ResultSet rs = null;
            PreparedStatement pst = null;
            
            
            String sql ="select username,first_name,last_name from Customer";
            pst=Frame.conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            UserTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e );
        }
    }
    protected static void Update_tableItem(JTable UserTable){
        try{
            ResultSet rs = null;
            PreparedStatement pst = null;
            
            
            String sql ="select item_id,item_name,stock from Item";
            pst=Frame.conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            UserTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e );
        }
    }
    
    public static void getUsers(Connection conn){
        
        
        
        String sql = "SELECT username,first_name FROM Customer";
        
        try{
        PreparedStatement getUsers = conn.prepareStatement(sql);
        
        getUsersSet = getUsers.executeQuery();
       
        
        while (getUsersSet.next()){
            String username = getUsersSet.getString("username");
            String fname = getUsersSet.getString("first_name");
            
            
        }
      //  Frame.UserTable.setModel(DbUtils.resultSetToTableModel(getUsersSet));
        
        }catch(SQLException ex){
             System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       
       
        
        

    }
    public static void getUserData(Connection conn, String username){
        
       
        
       String sql="Select C.phone,C.caddress From Customer C WHERE C.username ='"+username+"'";
        
        try{
        PreparedStatement getUsers = conn.prepareStatement(sql);
        
        getUsersData = getUsers.executeQuery();
       
        
        while (getUsersData.next()){
            String username1 = getUsersData.getString("phone");
            String fname = getUsersData.getString("caddress");
            UserEdit.userphoneLabel.setText("Phone number : "+username1);
            UserEdit.adresLabel.setText("Address : "+fname);
             
            
        }
     
        
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        
       
    
    
    }

      public static void AddItem(String itemName,String itemDesc,int stock,float price,int category,Connection conn,String photo) throws SQLException{
          
          String addItem = "INSERT INTO Item (item_name,item_desc,stock,price,photo,category) VALUES (?,?,?,?,?,?)";
                        
                        PreparedStatement item_id = Frame.conn.prepareStatement(addItem, Statement.RETURN_GENERATED_KEYS);
                        
                        item_id.setString(1, itemName);
                        item_id.setString(2, itemDesc);
                        item_id.setInt(3,stock);
                        item_id.setFloat(4, price);
                        item_id.setString(5, photo);
                        item_id.setInt(6,category);
                       
                        item_id.addBatch();
                        item_id.executeBatch();
          
          
      }
      
      public static void UpdateStock(String itemname,int newstock,int currentstock, Connection conn){
           int finalStock=newstock+currentstock;
         
          String updateS ="UPDATE Item SET stock = '"+finalStock+"' WHERE item_name = '"+itemname+"'";
          try{
          PreparedStatement all = conn.prepareStatement(updateS);
          all.execute();
          conn.commit();
          
          }catch(SQLException ex){
              System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
          }
          
      }
      
      
      
      
      
      
   public static int currenid(Connection conn){
       String sql="SELECT AUTO_INCREMENT\n" +
"FROM information_schema.tables\n" +
"WHERE table_name = 'table_name";
       
       try{
        PreparedStatement getItem = conn.prepareStatement(sql);
        
        
        getItemData = getItem.executeQuery();
        
        
        while(getItemData.next()){
            tmp = getItemData.getInt("id");
        }
        
       
            

      
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       
       return tmp;
       
   }
     
public static void getItemData(Connection conn, String username){
       
        
        
       String sql="Select C.category,C.item_desc,C.price From Item C WHERE C.item_name ='"+username+"'";
        
        try{
        PreparedStatement getItem = conn.prepareStatement(sql);
        
        getItemData = getItem.executeQuery();
       
        
        while (getItemData.next()){
            String category = getItemData.getString("category");
            String desc = getItemData.getString("item_desc");
            String price = getItemData.getString("price");
            ItemShow.ItemDesc.setText("Item description : "+desc);
            ItemShow.Category.setText("Category number : "+category);
            ItemShow.Price.setText("Item price : "+ price);
            

            
        }
     
        
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        
        
    
    
    }
    protected static int tmp;
}
