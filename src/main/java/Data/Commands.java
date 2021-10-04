package Data;

import Data.types.Product;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commands {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/potato";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";


    //Method to select all products from the database
    public static List<Product> selectAllProducts() {

        Connection conn = null;
        Statement stmt = null;
        List<Product> productList = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute the query to select all the products from the table products

            stmt = conn.createStatement();
            String sql = "SELECT * FROM PRODUCTS";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name

                int id  = rs.getInt("PRODUCT_ID");
                String name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                int category_id = rs.getInt("CATEGORY_ID");
                Date creationDate = rs.getDate("CREATION_DATE");
                LocalDate localCreationDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(creationDate) );
                Date updateDate = rs.getDate("UPDATE_DATE");
                LocalDate localUpdateDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(updateDate) );
                Date lastPurchaseDate = rs.getDate("LAST_PURCHASED_DATE");
                LocalDate localLastPurchaseDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(lastPurchaseDate) );

                Product product = new Product();
                product.setProduct_id(id);
                product.setName(name);
                product.setDescription(description);
                product.setCategory_id(category_id);
                product.setCreation_date(localCreationDate);
                product.setUpdate_date(localUpdateDate);
                product.setLast_purchased_date(localLastPurchaseDate);

//                // Display values
//                System.out.println("ID: " + id);
//                System.out.println("Name: " + name);
//                System.out.println("Description: " + description);
//                System.out.println("Category_ID: " + category_id);
//                System.out.println("CreationDate: " + creationDate);
//                System.out.println("UpdateDate: " + updateDate);
//                System.out.println("LastPurchaseDate: " + lastPurchaseDate);

                productList.add(product);

            }

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try

        return productList;
    }

    //Using the order by SQL command I can easily order everything by name
    public static List<Product> sortByNameSQLQuery() {

        Connection conn = null;
        Statement stmt = null;
        List<Product> productList = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "SELECT * FROM PRODUCTS ORDER BY NAME ";
            ResultSet rs = stmt.executeQuery(sql);

        // STEP 4: Extract data from result set
        while(rs.next()) {
            // Retrieve by column name

            int id  = rs.getInt("PRODUCT_ID");
            String name = rs.getString("NAME");
            String description = rs.getString("DESCRIPTION");
            int category_id = rs.getInt("CATEGORY_ID");
            Date creationDate = rs.getDate("CREATION_DATE");
            LocalDate localCreationDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(creationDate) );
            Date updateDate = rs.getDate("UPDATE_DATE");
            LocalDate localupdateDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(updateDate) );
            Date lastPurchaseDate = rs.getDate("LAST_PURCHASED_DATE");
            LocalDate localLastPurchaseDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(lastPurchaseDate) );

            Product product = new Product();
            product.setProduct_id(id);
            product.setName(name);
            product.setDescription(description);
            product.setCategory_id(category_id);
            product.setCreation_date(localCreationDate);
            product.setUpdate_date(localupdateDate);
            product.setLast_purchased_date(localLastPurchaseDate);

            productList.add(product);


        }
            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try

        return productList;

    }

    //Command to filter by category, the category_ID it is gotten from the rest call
    public static List<Product> categoryFilter(int category) {

        Connection conn = null;
        Statement stmt = null;
        List<Product> productList = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "SELECT * FROM PRODUCTS WHERE Category_ID =" + category;
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name

                int id  = rs.getInt("PRODUCT_ID");
                String name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                int category_id = rs.getInt("CATEGORY_ID");
                Date creationDate = rs.getDate("CREATION_DATE");
                LocalDate localCreationDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(creationDate) );
                Date updateDate = rs.getDate("UPDATE_DATE");
                LocalDate localupdateDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(updateDate) );
                Date lastPurchaseDate = rs.getDate("LAST_PURCHASED_DATE");
                LocalDate localLastPurchaseDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(lastPurchaseDate) );

                Product product = new Product();
                product.setProduct_id(id);
                product.setName(name);
                product.setDescription(description);
                product.setCategory_id(category_id);
                product.setCreation_date(localCreationDate);
                product.setUpdate_date(localupdateDate);
                product.setLast_purchased_date(localLastPurchaseDate);

                productList.add(product);


            }
            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try

        return productList;

    }


    //SQL command to update an element from the products table by an ID
    public static void updateProductByID(int id, Product product) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "UPDATE PRODUCTS SET NAME = '"+ product.name +
                    "',DESCRIPTION='"+ product.description +
                    "', UPDATE_DATE='"+ LocalDate.now() +
                    "' WHERE Product_ID =" + id;
            stmt.execute(sql);


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try

    }

    //Same as the previous one but by name
    public static void updateProductByName(String name, Product product) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "UPDATE PRODUCTS SET NAME = '"+ product.name +
                    "',DESCRIPTION='"+ product.description +
                    "', UPDATE_DATE='"+ LocalDate.now() +
                    "' WHERE NAME ='" + name +"'";
            stmt.execute(sql);


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try



    }


    //Deletion of an element of the products table by name
    public static void deleteProductByName(String name) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "DELETE FROM PRODUCTS WHERE NAME = '"+ name +"'";
            stmt.execute(sql);


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try


    }

    //Surprise surprise, the same as the one before but by ID
    public static void deleteProductByID(int id) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = "+ id ;
            stmt.execute(sql);


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try

    }

    //SQL Command to insert a product on the table
    public static void insertProduct(Product product) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query

            stmt = conn.createStatement();
            String sql =  "INSERT INTO PRODUCTS (NAME,DESCRIPTION, CATEGORY_ID, CREATION_DATE, UPDATE_DATE, LAST_PURCHASED_DATE)" +
                    "VALUES ("+
                    " '" + product.name + "'," +
                    " '" + product.description + "'," +
                    product.category_id + ", " +
                    " '" + product.creation_date + "'," +
                    " '" + product.update_date + "'," +
                    " '" + product.last_purchased_date + "')";
            stmt.execute(sql);

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
                se2.printStackTrace();
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try

    }


}
