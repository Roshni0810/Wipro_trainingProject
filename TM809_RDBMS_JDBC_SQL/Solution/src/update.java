import java.io.*;
import java.sql.*;
class update 
{
    public static void main(String args[])throws IOException
    
    {
        DataInputStream ds=new DataInputStream(System.in);
        System.out.println("enter empid where contact number is to be updated");
        String eno=ds.readLine();
        System.out.println("enter new contact number");
        String ncno=ds.readLine();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt=con.createStatement();
            String q1="update emp_reg set e_cno='"+ncno +"'where e_id='"+eno+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                System.out.println("update success");
               
            }
            else
            {
             System.out.println("insert unsuccessful");
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
