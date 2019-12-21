
import com.jcraft.jsch.Session;
import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static Connection DBConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://cs320project-1.duckdns.org/cs320DB";
        String user = "app";
        int port = 3306;
        String pass = "passpass";

        try {

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
//        catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
        return conn;
    }

    protected static void Update_table(JTable UserTable) {
        try {
            ResultSet rs = null;
            PreparedStatement pst = null;

            String sql = "select email,name from users";
            pst = Frame.conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            UserTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    protected static void Update_tableItem(JTable UserTable) {
        try {
            ResultSet rs = null;
            PreparedStatement pst = null;

            String sql = "select item_id,item_name,stock from Item";
            pst = Frame.conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            UserTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void getUsers(Connection conn) {

        String sql = "SELECT email,name FROM users";

        try {
            PreparedStatement getUsers = conn.prepareStatement(sql);

            getUsersSet = getUsers.executeQuery();

            while (getUsersSet.next()) {
                String username = getUsersSet.getString("email");
                String fname = getUsersSet.getString("name");

            }
            //  Frame.UserTable.setModel(DbUtils.resultSetToTableModel(getUsersSet));

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public static void getUserData(Connection conn, String username) {

        String sql = "Select C.email,C.name From users C WHERE C.email ='" + username + "'";

        try {
            PreparedStatement getUsers = conn.prepareStatement(sql);

            getUsersData = getUsers.executeQuery();

            while (getUsersData.next()) {
                String username1 = getUsersData.getString("email");
                String fname = getUsersData.getString("name");
                UserEdit.userphoneLabel.setText("Name and Surname : " + fname);
                UserEdit.adresLabel.setText("Email : " + username1);

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public static void AddItem(String itemName, String itemDesc, int stock, float price, int category, Connection conn, String photo) throws SQLException {
        AddItem(itemName, itemDesc, stock, price, category, conn, photo, true);
    }

    private static void AddItem(String itemName, String itemDesc, int stock, float price, int category, Connection conn, String photo, boolean shouldExec) throws SQLException {

        String addItem = "INSERT INTO Item (item_name,item_desc,stock,price,photo,category) VALUES (?,?,?,?,?,?)";

        PreparedStatement item = conn.prepareStatement(addItem, Statement.RETURN_GENERATED_KEYS);

        item.setString(1, itemName);
        item.setString(2, itemDesc);
        item.setInt(3, stock);
        item.setFloat(4, price);
        item.setString(5, photo);
        item.setInt(6, category);

        if (shouldExec) {
          //  item.executeUpdate();
        }

    }

    public static void AddItemBatch(ArrayList<ArrayList<String>> items, int startID) {
        String addItem = "INSERT INTO Item (item_name,item_desc,stock,price,photo,category) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement itemAdd = Frame.conn.prepareStatement(addItem);
            Frame.conn.setAutoCommit(false);
            for (ArrayList<String> item : items) {
                String itemName = item.get(0);
                System.out.println(itemName+" itemname");
                String itemDesc = item.get(2);
                System.out.println(itemDesc+"desc");
                int stock = (int)Float.parseFloat(item.get(3));
                System.out.println(stock+"stcok");
                float price = Float.parseFloat(item.get(4));
                System.out.println(price+"price");
                int category = (int)Float.parseFloat(item.get(1));
                System.out.println(category+"cat");
                String photo = "" + (startID++) + ".jpg";
                itemAdd.setString(1, itemName);
                itemAdd.setString(2, itemDesc);
                itemAdd.setInt(3, stock);
                itemAdd.setFloat(4, price);
                itemAdd.setString(5, photo);
                itemAdd.setInt(6, category);

                itemAdd.addBatch();
                itemAdd.executeBatch();
            }
            Frame.conn.commit();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getSQLState());
            try {
                Frame.conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SQLUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void UpdateStock(String itemname, int newstock, int currentstock, Connection conn) {
        int finalStock = newstock + currentstock;

        String updateS = "UPDATE Item SET stock = '" + finalStock + "' WHERE item_name = '" + itemname + "'";
        try {
            PreparedStatement all = conn.prepareStatement(updateS);
            all.execute();
            conn.commit();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public static int currenid(Connection conn) {
        String sql = "SELECT MAX(I.item_id) as maxid from Item I";

        try {
            PreparedStatement getItem = conn.prepareStatement(sql);

            getItemData = getItem.executeQuery();
            getItemData.last();
            int last = getItemData.getRow();
//        System.out.println("ttt " +getItemData.getRow());

            if (last != 0) {
                getItemData.beforeFirst();
                while (getItemData.next()) {
                    tmp = getItemData.getInt("maxid");
                    System.out.println("here " + tmp);
                }
            } else {
                tmp = 0;
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return tmp;

    }

    public static void getItemData(Connection conn, String username) {

        String sql = "Select C.category,C.item_desc,C.price From Item C WHERE C.item_name ='" + username + "'";

        try {
            PreparedStatement getItem = conn.prepareStatement(sql);

            getItemData = getItem.executeQuery();

            while (getItemData.next()) {
                String category = getItemData.getString("category");
                String desc = getItemData.getString("item_desc");
                String price = getItemData.getString("price");
                ItemShow.ItemDesc.setText("Item description : " + desc);
                ItemShow.Category.setText("Category number : " + category);
                ItemShow.Price.setText("Item price : " + price);

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public static void uploadImageWithStartID(ArrayList<ArrayList<String>> items, int startID) {
        for (ArrayList<String> item : items) {
            try {
                File file = new File(URLDecoder.decode(item.get(5), "UTF-8"));
                File renFile = new File(""+startID++ + ".jpg");
                file.renameTo(renFile);

                System.out.println("beofre copy");
                System.out.println("file.path = " + file.toPath());
                System.out.println("renfile.topath =" + renFile.getPath());
                Files.copy(file.toPath(), renFile.toPath());
                System.out.println("after copy");

                String path = "/Volumes/GoogleDrive/My Drive/NetBeansProjects/TestProject320cs/ssh_key.txt";

                String remoteB = "/var/www/static.buildpc.software/public/photos/";
                String local = "" + renFile.toPath();
                System.out.println("renpath = " + renFile.getAbsolutePath());
                String fileName = "" + renFile.getName();

                String user = "dozpinar";
                String host = "buildpc.software";
                int port = 22;

                String keyPassword = null;

                Session session = SendFile.createSession(user, host, port, path, keyPassword);
                SendFile.copyLocalToRemote(session, local, remoteB, fileName);
                renFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static int tmp;
}
