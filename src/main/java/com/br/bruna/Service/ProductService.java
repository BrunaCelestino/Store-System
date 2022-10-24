package com.br.bruna.Service;
import com.br.bruna.entities.Product;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductService {

    public void main(String... args) {
        List<Product> products = this.readProductsListFromCSV();


        System.out.println("Código | Código de barras |  série | nome | descrição | categoria | valor bruto | impostos (%) | data de fabricação | data de validade | cor | material | quantidade");
        System.out.println();


        for (int i = 1; i < products.toArray().length; i++) {
            System.out.println((i + " - ") + products.get(i));
            System.out.println();
        }
    }

    public ProductService() {
    }

    private List<Product> readProductsListFromCSV() {
        List<Product> products = new ArrayList<>();
//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";
        final var file =  getClass().getClassLoader().getResource("NewProducts.csv");

        try (BufferedReader csvReader = new BufferedReader(new FileReader(file.getFile()))){
            String row = csvReader.readLine();

            while (row != null) {
                String[] data = row.split(",");

                Product productList = createProductList(data);


                products.add(productList);
                row = csvReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
        return products;

    }

    public static Product createProductList(String[] metadata) {
        return new Product(metadata[0], metadata[1], metadata[2],
                metadata[3], metadata[4], metadata[5], metadata[6], metadata[7], metadata[8], metadata[9], metadata[10], metadata[11], 2);
    }

    public  String generateDate(Date date) {

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(date);
    }

    public  String generateRandomNumber() {

        return String.valueOf(Math.random() * 100).replace(".", "");
    }

    public static String generateRandomAlphaNumericString() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public void registerNewProductInfo(String name, String price, int quantity, String category) {

        String description = "produto " + name + " se enquadra como um item de " + category;

        Date date = new Date();
        Product product = new Product(generateRandomAlphaNumericString(), generateRandomNumber(), "1/2022", name, description, category, price, "5", generateDate(date), generateDate(date), "n/a", "n/a", quantity);
        this.addNewProduct(product);


    }

    public void addToList(Product product) {


//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";
        final var file = this.getClass().getClassLoader().getResource("NewProducts.csv");
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(file.getFile(), true))) {


            csvWriter.write(product.getCode() + "," + product.getBarCode() + "," + product.getSerie() + "," + product.getName() + "," + product.getDescription() + "," + product.getCategory() + "," + product.getPrice() + "," + product.getTaxes() + "," + product.getFabrication() + "," + product.getExpirationDate() + "," + product.getColor() + "," + product.getMaterial() + "," + product.getQuantity()
            );
            csvWriter.newLine();


        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }

    }

    public  void addNewProduct(Product product) {


//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";
        final var file =  this.getClass().getClassLoader().getResource("NewProducts.csv");


        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(file.getFile(), true))) {


            csvWriter.write(product.getCode() + "," + product.getBarCode() + "," + product.getSerie() + "," + product.getName() + "," + product.getDescription() + "," + product.getCategory() + "," + product.getPrice() + "," + product.getTaxes() + "," + product.getFabrication() + "," + product.getExpirationDate() + "," + product.getColor() + "," + product.getMaterial() + "," + product.getQuantity()
            );
            csvWriter.newLine();


        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }

    }

    public  void editList(Product product) {


//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\EditProducts.csv";
        final var file =  this.getClass().getClassLoader().getResource("EditProducts.csv");


        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(file.getFile(), true))) {


            csvWriter.write(product.getCode() + "," + product.getBarCode() + "," + product.getSerie() + "," + product.getName() + "," + product.getDescription() + "," + product.getCategory() + "," + product.getPrice() + "," + product.getTaxes() + "," + product.getFabrication() + "," + product.getExpirationDate() + "," + product.getColor() + "," + product.getMaterial() + "," + product.getQuantity()
            );
            csvWriter.newLine();

        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }

    }

    public  void deleteList(Product product) {


//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\EditProducts.csv";
        final var file = this.getClass().getClassLoader().getResource("EditProducts.csv");

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(file.getFile(), true))) {


            csvWriter.write(product.getCode() + "," + product.getBarCode() + "," + product.getSerie() + "," + product.getName() + "," + product.getDescription() + "," + product.getCategory() + "," + product.getPrice() + "," + product.getTaxes() + "," + product.getFabrication() + "," + product.getExpirationDate() + "," + product.getColor() + "," + product.getMaterial() + "," + product.getQuantity()
            );


        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }

    }


    public  void editProduct(int input, int field, String information) {
//        String tempPath = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\EditProducts.csv";
//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";

        final var tempFile =  this.getClass().getClassLoader().getResource("EditProducts.csv");
        final var file =  this.getClass().getClassLoader().getResource("NewProducts.csv");

        try (BufferedReader csvReader = new BufferedReader(new FileReader(file.getFile()))) {
            String row = csvReader.readLine();
            List<Product> product = new ArrayList<>();
            while (row != null) {
                String[] data = row.split(",");
                Product productList = createProductList(data);
                product.add(productList);
                row = csvReader.readLine();
            }

            for (int i = 0; i < product.toArray().length; i++) {
                if(input > product.toArray().length){
                    System.out.println("Produto não encontrado!");
                    System.exit(0);
                }
                if (i == input) {

                    switch (field) {
                        case 1:
                            product.get(input).setName(information);
                            break;
                        case 2:
                            product.get(input).setPrice(information);
                            break;
                        case 3:
                            product.get(input).setQuantity(Integer.parseInt(information));
                            break;
                        case 4:
                            product.get(input).setCategory(information.toUpperCase());
                            break;
                        case 5:
                            product.get(input).setDescription(information);
                            break;
                        default:
                            System.out.println("Categoria não encontrada!");
                            System.exit(0);
                            break;
                    }

                }
                editList(product.get(i));

            }

            FileChannel sourceChannel = new FileInputStream(tempFile.getFile()).getChannel();
            FileChannel destChannel = new FileOutputStream(file.getFile()).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            sourceChannel.close();
            destChannel.close();

            File editFile = new File(tempFile.getFile());
            editFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public  void deleteProduct(int productNumber) {
//        String tempPath = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\EditProducts.csv";
//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";

        final var tempFile =  this.getClass().getClassLoader().getResource("EditProducts.csv");
        final var file =  this.getClass().getClassLoader().getResource("NewProducts.csv");
        try (BufferedReader csvReader = new BufferedReader(new FileReader(file.getFile()))) {
            String row = csvReader.readLine();
            List<Product> product = new ArrayList<>();
            while (row != null) {
                String[] data = row.split(",");
                Product productList = createProductList(data);
                product.add(productList);
                row = csvReader.readLine();
            }

            if (productNumber >= product.toArray().length) {
                System.out.println("Produto não encontrado!");
                System.out.println("Até mais!");
                System.exit(1);
            }
            for (int i = 0; i < product.toArray().length; i++) {
                if (i == productNumber) {
                    product.remove(product.get(productNumber));

                }


                if (productNumber == (product.toArray().length)) {
                    product.add(product.get(1));
                }

                deleteList(product.get(i));
            }

            FileChannel sourceChannel = new FileInputStream(tempFile.getFile()).getChannel();
            FileChannel destChannel = new FileOutputStream(file.getFile()).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            sourceChannel.close();
            destChannel.close();

            File editFile = new File(tempFile.getFile());
            editFile.deleteOnExit();

        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public void addInventoryToProductList() {
        List<Product> products = new ArrayList<>();
//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\mostruario_fabrica.csv";
        final var file =  this.getClass().getClassLoader().getResource("mostruario_fabrica.csv");
        try (BufferedReader csvReader = new BufferedReader(new FileReader(file.getFile()))) {
            String row = csvReader.readLine();

            while (row != null) {
                String[] data = row.split(",");
                Product productList = createProductList(data);
                products.add(productList);
                row = csvReader.readLine();
            }

            for (int i = 1; i < products.toArray().length; i++) {
                this.addToList(products.get(i));


            }
            System.out.println("Mostruário importado com sucesso!");
            System.out.println("Nova lista:");
            main();
            System.out.println();
            System.out.println("O valor final de cada produto é:");
            calculateFinalValue();
        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }


    }

    public  void calculateFinalValue() {
        List<Product> products = new ArrayList<>();
//        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\newProducts.csv";
        final var file =  this.getClass().getClassLoader().getResource("NewProducts.csv");
        try (BufferedReader csvReader = new BufferedReader(new FileReader(file.getFile()))) {
            String row = csvReader.readLine();

            while (row != null) {
                String[] data = row.split(",");
                Product productList = createProductList(data);
                products.add(productList);
                row = csvReader.readLine();
            }

            for (int i = 1; i < products.toArray().length; i++) {

                double finalValue = (Double.parseDouble(products.get(i).getPrice().replace("\"", "")) + Double.parseDouble((products.get(i).getTaxes().replace("\"", "")))) * 1.45;
                System.out.printf("Produto: %s, valor final:  %.2f", products.get(i).getName(), finalValue);
                System.out.println();


            }

        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }

    }
}


