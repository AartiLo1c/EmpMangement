/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyEmpMgmtApp.dbutil;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
             conn=DriverManager.getConnection("jdbc:oracle:thin:@//UltraInstinct/xe","system","aarti");
       
        JOptionPane.showMessageDialog(null,"connected successfully");
    }
    catch(Exception e)
    
    {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,"cannot connect to db");
    
    }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null,"Disconnected successfully!!");
        }
            catch(Exception e)
                    {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"not disconnected successfully");
                    }
            
        }
    }

