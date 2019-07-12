package models;

import java.sql.Date;

public class ProductDto implements BaseDto {
    private int id;
    private String name;
    private String description;
    private float price;
    private int quantity;
    private Date start_date;
    private Date end_date;
    private String created_by;

    public ProductDto() {

    }
    public ProductDto(int id,String name,String description,float price,int quantity,Date start_date,Date end_date,String created_by) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_by = created_by;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        created_by = created_by;
    }
}
