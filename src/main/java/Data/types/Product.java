package Data.types;

import java.time.LocalDate;

public class Product {

    public int product_id;
    public String name;
    public String description;
    public int category_id;
    public LocalDate creation_date;
    public LocalDate update_date;
    public LocalDate last_purchased_date;

    public Product() {
    }

    public Product(int product_id, String name, String description, int category_id, LocalDate creation_date, LocalDate update_date, LocalDate last_purchased_date) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
        this.creation_date = creation_date;
        this.update_date = update_date;
        this.last_purchased_date = last_purchased_date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDate getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDate update_date) {
        this.update_date = update_date;
    }

    public LocalDate getLast_purchased_date() {
        return last_purchased_date;
    }

    public void setLast_purchased_date(LocalDate last_purchased_date) {
        this.last_purchased_date = last_purchased_date;
    }

    public String toString(){

        return "Product_ID = " + this.product_id +
                ", Name = " + this.name +
                ", Description = " + this.description ;
//                ", Category_ID = " + this.category_id +
//                ", Creation_Date = " + this.creation_date +
//                ", Update_Date = " + this.update_date +
//                ", Last_Purchased_Date = " + this.last_purchased_date + System.lineSeparator();
    }
}
