package com.br.bruna;

import com.br.bruna.entities.Product;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.br.bruna.Service.ProductService.createProductList;


public class CrunchifyFindDuplicateCSV {

    public  void main(String[] argv) {
         var crunchifyCSVFile = this.getClass().getClassLoader().getResource("NewProducts.csv");

        BufferedReader crunchifyBufferReader = null;
        String crunchifyLine = "";

        HashSet<String> crunchifyAllLines = new HashSet<>();

        try {
            crunchifyBufferReader = new BufferedReader(new FileReader(crunchifyCSVFile.getFile()));
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

    public  boolean crunchifyIsNullOrEmpty(String crunchifyString) {
        if (crunchifyString != null && !crunchifyString.trim().isEmpty())
            return false;
        return true;
    }

    public  void writeNewFile(String line) {
        var path = this.getClass().getClassLoader().getResource("UpdateProducts.csv");

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(path.getFile(), true))) {
            csvWriter.newLine();
            csvWriter.write(line);


        } catch (
                IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public  void updatedList() {
        var tempPath = this.getClass().getClassLoader().getResource("UpdateProducts.csv");
        var path = this.getClass().getClassLoader().getResource("NewProducts.csv");
        try (BufferedReader csvReader = new BufferedReader(new FileReader(path.getFile()))) {
            String row = csvReader.readLine();
            List<Product> product = new ArrayList<>();

            while (row != null) {
                String[] data = row.split(",");
                Product productList = createProductList(data);
                product.add(productList);
                row = csvReader.readLine();
            }

            FileChannel sourceChannel = new FileInputStream(tempPath.getFile()).getChannel();
            FileChannel destChannel = new FileOutputStream(path.getFile()).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            sourceChannel.close();
            destChannel.close();

            File editFile = new File(tempPath.getFile());
            editFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}