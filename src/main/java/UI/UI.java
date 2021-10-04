package UI;


import Data.Commands;
import Data.DatabaseInitializer;
import Data.types.Product;

import static spark.Spark.*;

public class UI {


    public static void main(String[] args) {

        //Executing the database initialization commands
        DatabaseInitializer.databaseInitializer();

        //For this, since I am using Intellij community, I can not afford professional
        //There is no Springboot plugin that makes it easy to create a connection with React
        //So after some time looking for an alternative I found Spark! - said Jaime with excruciating pain cos he was super confused and would have rather used Node.js and React since he knows how to connect it to a MongoDB
        //Here it will run a server on the port 9090, and I am leaving the routes for some of the commands.
            port(9090);

            get("/Products", (req, res) -> Commands.selectAllProducts());

            get("/Products/name", (req, res) -> Commands.sortByNameSQLQuery());

            get("/Products/category/:number", (req,res) ->
                    Commands.categoryFilter(Integer.parseInt(req.params(":number"))));


            //Here it deletes the product but for some reason instead of writing the return string,
            //it decides it fits better to write an error 500, but  works, so it is a feature now!
            get("/Products/deleteItemByID/:number", (req,res) -> {
                        Commands.deleteProductByID(Integer.parseInt(req.params(":number")));
                        return "Product with ID " + Integer.parseInt(req.params(":number")) + " deleted";
                    }
            );
            get("/Products/deleteItemByName/:name", (req,res) -> {
                        Commands.deleteProductByName(req.params(":name"));
                        return "Product with ID " + req.params(":name") + " deleted";
                    }
            );
            //Not finished, but it should insert a product without a problem
            //Assuming you create a Product object here

            post("/Products/insert", (req, res) ->{
                    Commands.insertProduct(new Product());
                    return "";
                });

            //Not finished, but it should update a product without a problem
            //Assuming you create a Product object here
            post("/Product/updateProductByName/:name", (req, res) ->{
                Commands.updateProductByName(req.params(":name"), new Product());
                return "";
            });

            post("/Product/updateProductByID/:number", (req, res) ->{
                Commands.updateProductByID(Integer.parseInt(req.params(":number")), new Product());
                return "";
            });



        }



}
