package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {

    public static void main(String[] args) {
        //JDBC接口
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/?";
            conn = DriverManager.getConnection(url,"root","caijunze");
            String sql = "select * from user.user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("编号：" +rs.getInt("id") +
                        ",  姓名：" +rs.getString("username"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null){
                    rs.close();
                    rs = null;
                }
                if (ps != null){
                    ps.close();
                    ps = null;
                }
                if (conn != null){
                    conn.close();
                    conn = null;
                }
            }catch (Exception e){

            }
        }
    }

}
