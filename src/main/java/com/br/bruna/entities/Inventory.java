package com.br.bruna.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static void main(String... args) {
        List<Product> products = readInventoryFromCSV();
        System.out.println("Código | Código de barras |  série | nome | descrição | categoria | valor bruto | impostos (%) | data de fabricação | data de validade | cor | material | quantidade");
        System.out.println();
        for (int i = 1; i < products.toArray().length; i++) {
            System.out.println((i + " - ") + products.get(i));
            System.out.println();
        }
    }


    private static List<Product> readInventoryFromCSV() {
        List<Product> products = new ArrayList<>();


        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\mostruario_fabrica.csv";

        try (BufferedReader csvReader = new BufferedReader(new FileReader(path))) {
            String row = csvReader.readLine();


            while (row != null) {
                String[] data = row.split(",");

                Product inventory = createInventory(data);
                products.add(inventory);
                row = csvReader.readLine();

            }

        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
        return products;

    }

    private static Product createInventory(String[] metadata) {
        Product product = new Product(metadata[0], metadata[1], metadata[2],
                metadata[3], metadata[4], metadata[5], metadata[6], metadata[7], metadata[8], metadata[9], metadata[10], metadata[11], 2);
        return product;
    }
}


