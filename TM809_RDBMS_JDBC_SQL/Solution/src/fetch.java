import java.io.*;
import java.sql.*;
class fetch 
{
    public static void main(String args[])throws IOException
    
    {
        DataInputStream ds=new DataInputStream(System.in);
        System.out.println("enter empid whose details to be fetched");
        String eno=ds.readLine();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt=con.createStatement();
            String q1="select* from emp_reg where e_id='"+eno+"'";
            ResultSet rs=stmt.executeQuery(q1);
            if(rs.next())
            {
                System.out.println("the no is"+rs.getInt(1));
                System.out.println("the name is"+rs.getString(2));
                System.out.println("the contact no is"+rs.getString(3));
                
               
            }
            else
            {
             System.out.println("not found");
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
    

