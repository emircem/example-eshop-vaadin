package cz.jiripinkas.example.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ItemDto implements Serializable {

   private static final long serialVersionUID = 1L;

   private Integer id;

   @NotNull(message = "Name cannot be empty!")
   private String name = "";

   private String description = "";

   @Min(value = 1, message = "Price must not be zero!")
   private double price;

   public ItemDto() {
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
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

}