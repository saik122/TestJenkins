//package ApplicationDemo.demo.repo;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class MyDriver {
//
//        private static final String URL = "jdbc:mysql://localhost:3306/ovaledgedb";
//        private static final String USERNAME = "root";
//        private static final String PASSWORD = "0valEdge!";
//        private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
//
//        static {
//            try {
//                Class.forName(DRIVER_CLASS_NAME);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException("MySQL Driver not found.", e);
//            }
//        }
//
//        public static Connection getConnection() throws SQLException {
//            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        }
//    }
//
//
