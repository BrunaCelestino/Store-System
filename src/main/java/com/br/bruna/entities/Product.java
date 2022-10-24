package com.br.bruna.entities;

public class Product {

    String code;
    String barCode;
    String serie;
    String name;
    String description;

    String category;

    String price;
    String taxes;

    String fabrication;

    String expirationDate;



    String color;

    String material;

    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String code, String barCode, String serie, String name, String description, String category, String price, String taxes, String fabrication, String expirationDate, String color, String material, int quantity) {
        this.code = code;
        this.barCode = barCode;
        this.serie = serie;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.taxes = taxes;
        this.fabrication = fabrication;
        this.expirationDate = expirationDate;
        this.color = color;
        this.material = material;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }


    public String getBarCode() {
        return barCode;
    }


    public String getSerie() {
        return serie;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTaxes() {
        return taxes;
    }


    public String getFabrication() {
        return fabrication;
    }


    public String getExpirationDate() {
        return expirationDate;
    }


    public String getColor() {
        return color;
    }


    public String getMaterial() {
        return material;
    }


    @Override
    public String toString() {
        return

                " código: '" + code + '\'' +
                        " código de barras: '" + barCode + '\'' +
                        " série: ' " + serie + '\'' +
                        " nome: '" + name + '\'' +
                        " descrição: '" + description +  '\'' +
                        "  categoria: '" + category + '\'' +
                        "  preço: '" + price + '\'' +


                        " impostos: '" + taxes +  '\'' +
                        " Data de fabricação: '" + fabrication +  '\'' +
                        " Data de validade: '" + expirationDate +  '\'' +
                        " Cor: '" + color +  '\'' +
                        " Material: '" + material +  '\'' +
                        " Quantidade: '" + quantity + '\'';
    }
}

