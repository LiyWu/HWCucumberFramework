package interviewPrepare;

import java.sql.*;

public class SQLQuery {

    public static void main(String[] args) throws SQLException {
        //1. 起driver

        try {
            //MySQL upgrade to 8.0
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //2. 建立连接
        String alphaDB_url=  "jdbc:mysql://db01.crm-alpha.com:3306/";
        String conStrg = alphaDB_url+"um_svg_business"+"?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
        Connection g_connect = DriverManager.getConnection(conStrg, "this.alphaUser", "this.alphaPass");

       //3.  create statement
        Statement stt = g_connect.createStatement();

       // 4. 发sql
        ResultSet rl = stt.executeQuery("select * from tb_mt4_user");
        //jsonarray = formatResult(rl);
        //5. c处理结果，关闭连接
        rl.close();
        stt.close();
    }
}
