package DataBase;

import java.sql.*;

public class TestDB {
    Connection con;
    Statement st;

    TestDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@54.89.59.114:49161:XE",
                    "test", "test");

            if (con != null) {
                System.out.println("Connected!");


                st = con.createStatement();
                String query1 = "select * from emp";
                ResultSet rs = st.executeQuery(query1);


                ResultSetMetaData data = rs.getMetaData();
                int colNum = data.getColumnCount();
                while (rs.next()) {
//                    System.out.println("sdfsdf");
//                    System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
//
                    for (int i = 1; i <= colNum; ++i) {
                        System.out.print(data.getColumnName(i) + ": " + rs.getString(i));
                    }
                    System.out.println();
                    System.out.println("=====");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new TestDB();
    }
}
