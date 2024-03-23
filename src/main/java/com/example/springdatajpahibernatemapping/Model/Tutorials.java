package com.example.springdatajpahibernatemapping.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="Product")
public class Tutorials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="imagepath")
    private String imagepath;

    @Column(name="Price")
    private int price;

    @Column(name="Quantity")
    private int quantity;

    public Tutorials(String name, String description, String imagepath, int price, int quantity)
    {
        this.name=name;
        this.description=description;
        this.imagepath=imagepath;
        this.price=price;
        this.quantity=quantity;
    }
    public Tutorials(){}

    public String toString()
    {

        return "Tutorial[Id="+id+",Tutorial name="+name+",Tutorial description="+description+",Tutorial imagePath="+imagepath+",Tutorial price="+price+",Tutorial quantity="+quantity+"]";
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
