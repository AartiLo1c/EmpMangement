
package MyEmpMgmtApp.dao;

import MyEmpMgmtApp.dbutil.DBConnection;
import MyEmpMgmtApp.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EmpDao {
    
    public static boolean addEmp(EmpPojo obj)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into emp values(?,?,?)");
        ps.setInt(1,obj.getEmpno());
        ps.setString(2,obj.getEname());
        ps.setDouble(3,obj.getSal());
        int count=ps.executeUpdate();
         if(count>0)
            return true;
        else 
            return false;
        
        
    }
    
public static ArrayList<EmpPojo> getAllemp() throws SQLException
{
Connection conn=DBConnection.getConnection();
Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("select * from emp");
ArrayList<EmpPojo> empList=new ArrayList<>();
while(rs.next())
{
int eno=rs.getInt(1);
String ename=rs.getString(2);
double sal=rs.getDouble(3);
EmpPojo obj=new EmpPojo(eno,ename,sal);
empList.add(obj);
}
return empList;
}
public static EmpPojo findEmpById(int eno)throws SQLException
{
    Connection conn=DBConnection.getConnection();
PreparedStatement ps=conn.prepareStatement("select * from emp where eno=?");
ps.setInt(1,eno);
ResultSet rs=ps.executeQuery();
EmpPojo e=null;
if(rs.next())
{
    e=new EmpPojo();
    e.setEname(rs.getString(2));
    e.setSal(rs.getDouble(3));
    e.setEmpno(eno);
}
return e;
}
  public static boolean updateEmp(EmpPojo obj)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update emp set ename=?,sal=?where eno=?");
    
        ps.setString(1,obj.getEname());
        ps.setDouble(2,obj.getSal());
        ps.setInt(3,obj.getEmpno());
        int count=ps.executeUpdate();
        if(count>0)
            return true;
        else 
            return false;
        
    }
  public static boolean deleteEmp(int id)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from emp where eno=?");
        ps.setInt(1,id);
       
        int count=ps.executeUpdate();
        if(count>0)
            return true;
        else 
            return false;
  
}
}