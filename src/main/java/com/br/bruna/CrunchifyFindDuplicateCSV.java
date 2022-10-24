package com.br.bruna;

import com.br.bruna.entities.Product;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.br.bruna.Service.ProductService.createProductList;


public class CrunchifyFindDuplicateCSV {
    public static void main(String[] argv) {
        String crunchifyCSVFile = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";

        BufferedReader crunchifyBufferReader = null;
        String crunchifyLine = "";

        HashSet<String> crunchifyAllLines = new HashSet<>();

        try {
            crunchifyBufferReader = new BufferedReader(new FileReader(crunchifyCSVFile));
            int repeatLines =0;
            while ((crunchifyLine = crunchifyBufferReader.readLine()) != null) {
                if (crunchifyAllLines.add(crunchifyLine)) {
                    writeNewFile(crunchifyLine);
                    updatedList();

                } else if (!crunchifyIsNullOrEmpty(crunchifyLine)) {
                   repeatLines++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (crunchifyBufferReader != null) {
                try {
                    crunchifyBufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean crunchifyIsNullOrEmpty(String crunchifyString) {
        if (crunchifyString != null && !crunchifyString.trim().isEmpty())
            return false;
        return true;
    }

    public static void writeNewFile(String line) {
        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\UpdateProducts.csv";
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path, true))) {
            csvWriter.newLine();
            csvWriter.write(line);


        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public static void updatedList() {
        String tempPath = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\UpdateProducts.csv";
        String path = "C:\\Users\\Luis Felipe\\Desktop\\desafio-backend-modulo1\\src\\NewProducts.csv";
        try (BufferedReader csvReader = new BufferedReader(new FileReader(path))) {
            String row = csvReader.readLine();
            List<Product> product = new ArrayList<>();

            while (row != null) {
                String[] data = row.split(",");
                Product productList = createProductList(data);
                product.add(productList);
                row = csvReader.readLine();
            }

            FileChannel sourceChannel = new FileInputStream(tempPath).getChannel();
            FileChannel destChannel = new FileOutputStream(path).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            sourceChannel.close();
            destChannel.close();

            File editFile = new File(tempPath);
            editFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}