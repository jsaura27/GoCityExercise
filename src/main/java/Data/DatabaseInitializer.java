package Data;

import Data.types.Category;
import Data.types.Product;

import java.sql.*;
import java.util.List;

public class DatabaseInitializer {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/potato"; //it is necessary to be called potato for scientific purposes

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";


    public static void databaseInitializer(){
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute the queries

            //By creating a connection it automatically creates the database if it didn't exist previously
            //And if the tables exist, for confidentiality purposes towards my testing unoriginal and moronic names all tables will be destroyed beforehand
            //The tables will be created again and filled with the products and categories provided

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet res = dbm.getTables(null, null, "PRODUCTS", null);
            if(res.next()){
                System.out.println("Delete data in Products ");
                stmt = conn.createStatement();
                sql =  "DROP TABLE PRODUCTS ";
                stmt.executeUpdate(sql);
                System.out.println("Data in table CATEGORIES deleted");

                res = dbm.getTables(null, null, "CATEGORIES", null);
                if(res.next()){
                    System.out.println("Delete data in category ");
                    stmt = conn.createStatement();
                    sql =  "DROP TABLE CATEGORIES ";
                    stmt.executeUpdate(sql);
                    System.out.println("Data in table CATEGORIES deleted");
                }
            }

            System.out.println("Creating category table");
            stmt = conn.createStatement();
            sql =  "CREATE TABLE CATEGORIES " +
                    "(CATEGORY_ID IDENTITY NOT NULL PRIMARY KEY, " +
                    " CATEGORY_NAME VARCHAR(255))";
            stmt.executeUpdate(sql);
            System.out.println("Created table CATEGORIES");


            System.out.println("Input category data");
            List<Category> categories = CSVReader.categoryReader();
            for(int i = 1; i<=categories.size();i++){
                stmt = conn.createStatement();
                sql =  "INSERT INTO CATEGORIES (CATEGORY_NAME)" +
                        "VALUES ('" +categories.get(i-1).name+"') " ;
                stmt.executeUpdate(sql);
            }

            System.out.println("Inserted CATEGORIES data");


            System.out.println("Creating Products table");

            stmt = conn.createStatement();
            sql =  "CREATE TABLE   PRODUCTS " +
                    "(PRODUCT_ID IDENTITY NOT NULL PRIMARY KEY, " +
                    " NAME VARCHAR(255), " +
                    " DESCRIPTION VARCHAR(255), " +
                    " CATEGORY_ID INTEGER not NULL, " +
                    " CREATION_DATE DATE, " +
                    " UPDATE_DATE DATE, " +
                    " LAST_PURCHASED_DATE DATE, " +
                    //" PRIMARY KEY (PRODUCT_ID )," +
                    " FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(CATEGORY_ID))";
            stmt.executeUpdate(sql);
            System.out.println("Created Products table...");

            List<Product> productListFromCSV = CSVReader.productReader();

            for(int i = 0; i<productListFromCSV.size();i++){
                stmt = conn.createStatement();
                sql =  "INSERT INTO PRODUCTS (NAME,DESCRIPTION, CATEGORY_ID, CREATION_DATE, UPDATE_DATE, LAST_PURCHASED_DATE)" +
                        "VALUES ("+
                        " '" + productListFromCSV.get(i).name + "'," +
                        " '" + productListFromCSV.get(i).description + "'," +
                        productListFromCSV.get(i).category_id + ", " +
                        " '" + productListFromCSV.get(i).creation_date + "'," +
                        " '" + productListFromCSV.get(i).update_date + "'," +
                        " '" + productListFromCSV.get(i).last_purchased_date + "')";
                stmt.execute(sql);
            }


            System.out.println("Inserted Products data");
            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }

    //All of this is a database Initializer, to make sure that the tables have all the products you sent on the csv
    //And not all the testing elements added or updated...

}