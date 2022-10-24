package com.br.bruna;
import com.br.bruna.Service.ProductService;
import org.junit.Test;


public class UnitTest {

    ProductService productService = new ProductService();
    public static void main(String[] args) {

    }

    @Test
    public void addProductTest(){
        productService.registerNewProductInfo("Sofá", "300", 2, "CASA");
    }

@Test
    public void editProductTest(){
    productService.editProduct(1, 1, "Cama");

    }

    @Test
    public void deleteProductTest(){
        productService.deleteProduct(2);

    }

    @Test
    public void importInventoryTest(){
        productService.addInventoryToProductList();

    }


}
