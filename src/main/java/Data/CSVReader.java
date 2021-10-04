package Data;

import Data.types.Category;
import Data.types.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    //path variables
    static private final String PRODUCTS_REFERENCE_FILE = "resources/products.csv";
    static private final String CATEGORIES_REFERENCE_FILE = "resources/categories.csv";
    static private final String SEPARATOR_COLON = ";";
    static private final String SEPARATOR_COMA = ",";


    //This next 2 methods are to get the elements of the csv where all the information for products and categories are
    static public List<Category> categoryReader() throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(CATEGORIES_REFERENCE_FILE));
        String row;
        List<Category> dataList = new ArrayList<>();

        row = csvReader.readLine();
        while ((row = csvReader.readLine()) != null){
            Category data = new Category();
            String[] datas = row.split(SEPARATOR_COMA);

            data.setCategory_id(Integer.parseInt(datas[0]));
            data.setName(datas[1]);
            dataList.add(data);

        }
        return dataList;
    }
    static public List<Product> productReader() throws IOException {
        //File reader and a list to add all the data of the file
        BufferedReader csvReader = new BufferedReader(new FileReader(PRODUCTS_REFERENCE_FILE));
        String row;
        List<Product> dataList = new ArrayList<>();

        row = csvReader.readLine();
        while ((row = csvReader.readLine()) != null){

            Product data = new Product();
            //I separate the row data by a separator, a coma in this case and add all the data in the class
            String[] datas = row.split(SEPARATOR_COLON);

            data.setProduct_id(Integer.parseInt(datas[0]));
            data.setName(datas[1]);
            data.setDescription(datas[2]);
            data.setCategory_id(Integer.parseInt(datas[3]));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            //Since some dates had just one number for the month, I had to use this to add a 0
            //to make all the dates the same length after getting rid of the 0:01 that was not necessary
            String[] creationDate = datas[4].split(" ");
            if(creationDate[0].length() == 9){
                creationDate[0] = "0"+ creationDate[0];
            }
            data.setCreation_date(LocalDate.parse(creationDate[0], formatter));

            creationDate = datas[5].split(" ");
            if(creationDate[0].length() == 9){
                creationDate[0] = "0"+ creationDate[0];
            }
            data.setUpdate_date(LocalDate.parse(creationDate[0], formatter));

            creationDate = datas[6].split(" ");
            if(creationDate[0].length() == 9){
                creationDate[0] = "0"+ creationDate[0];
            }
            data.setLast_purchased_date(LocalDate.parse(creationDate[0], formatter));

            dataList.add(data);

        }
        return dataList;

    }
}
