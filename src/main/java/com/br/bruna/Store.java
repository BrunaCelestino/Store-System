package com.br.bruna;
import com.br.bruna.Service.ProductService;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Store {
    private  static ProductService productService;
    public static void main(String[] args) {
        productService = new ProductService();
        showMenu();
        getOption();


    }

    public static void showMenu() {
        System.out.println("Bem vindo!");
        System.out.println(" __________________________________________________________________");
        System.out.println("|                                                                  |");
        System.out.println("|                1 - Adicionar Novo Produto                        |");
        System.out.println("|                2 - Editar Produto                                |");
        System.out.println("|                3 - Excluir Produto                               |");
        System.out.println("|                4 - Importar Mostruário da Fábrica                |");
        System.out.println("|                5 - Sair                                          |");
        System.out.println(" __________________________________________________________________");
    }
    public static void getOption() {

        Scanner input = new Scanner(System.in);
        try {

            System.out.println("Qual operação você deseja realizar? Digite o número correspondente.");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Caso queira cancelar, a qualquer momento, digite 'SAIR'");
                    System.out.println("Digite o nome do produto:");
                    String name = input.next();
                    name += input.nextLine();
                    name = checkIfCancel(name);

                    System.out.println("Digite o preço do produto:");
                    String price = input.next();
                    price = checkIfCancel(price);

                    System.out.println("Digite a quantidade do produto em estoque:");
                    int quantity = input.nextInt();
                    quantity = checkIfCancel(quantity);
                    System.out.println("Digite a categoria do produto:");
                    String category = input.next();
                    category = checkIfCancel(category);


                    productService.registerNewProductInfo(name, price, quantity, category.toUpperCase());
                    System.out.println("Novo produto adicionado com sucesso!");
                    System.out.println();
                    main(null);



                    break;
                case 2:
                    System.out.println("Aqui está a lista de nossos produtos:");
                    productService.main();
                    System.out.println("Caso queira cancelar, a qualquer momento, digite 'SAIR'");
                    getEditInformation();
                    System.out.println("Produto editado com sucesso!");
                    main(null);

                    break;
                case 3:
                    System.out.println("Aqui está a lista de nossos produtos:");
                    productService.main();
                    System.out.println("Caso queira cancelar, a qualquer momento, digite 'SAIR'");
                    getProductToDelete();
                    main(null);
                    break;

                case 4:
                    productService.addInventoryToProductList();
                    System.out.println();
                    main(null);
                    break;
                case 5:
                    finishSystem();

                    break;
                default:
                    System.err.println("Digite uma opção válida.");
                    main(null);
                    break;
            }


        } catch (InputMismatchException e) {
            System.err.println("Digite um número.");
            main(null);

        }

    }

    public static void finishSystem() {
        System.out.flush();
        System.out.println("Até mais!");
        CrunchifyFindDuplicateCSV.main(null);
        System.exit(0);
    }


    public static String checkIfCancel(String input){
        if(input.equalsIgnoreCase("SAIR")) {
            main(null);
        } else {
            return input;
        }

        return input;
    }

    public static int checkIfCancel(int input){
        String newInput = String.valueOf(input);
        if(newInput.equalsIgnoreCase("SAIR")) {
            main(null);
        } else {
            return parseInt(newInput);
        }

        return parseInt(newInput);
    }

    public static void getEditInformation() {
        Scanner input = new Scanner(System.in);

        System.out.println("Qual produto deseja editar? Digite o número correspondente");
        int productToEdit = input.nextInt();
        productToEdit = checkIfCancel(productToEdit);

        if(productToEdit == 0) {
            System.out.println("Produto não encontrado");
            main(null);
        }



        System.out.println("Informe o campo que deseja editar:");
        System.out.println(" 1 - Nome");
        System.out.println(" 2 - Preço");
        System.out.println(" 3 - Quantidade");
        System.out.println(" 4 - Categoria");
        System.out.println(" 5 - Descrição");
        int editionOption = input.nextInt();
        editionOption = checkIfCancel(editionOption);
        getEditOption(editionOption, productToEdit);

    }

    public static void getProductToDelete() {
        Scanner input = new Scanner(System.in);
        ProductService productService = new ProductService();
        System.out.println("Qual produto deseja deletar? Digite o número correspondente");
        int productToDelete = input.nextInt();
        productToDelete = checkIfCancel(productToDelete);
        System.out.println("Confirma deletar o produto: " + productToDelete + "?");
        System.out.println("Digite:");
        System.out.println("1 - SIM   | 2 - NÃO");
        int confirmation = input.nextInt();

        if(confirmation == 1) {
            productService.deleteProduct(productToDelete);
            System.out.println("Produto deletado com sucesso!");

        } else {
            main(null);
        }
    }

    public static void getEditOption(int editionOption, int productToEdit){
        Scanner input = new Scanner(System.in);
        String editInformation = null;
        ProductService productService = new ProductService();

        switch (editionOption) {
            case 1:
                System.out.println("Informe o novo nome:");
                editInformation = input.next();
                editInformation += input.nextLine();
                editInformation = checkIfCancel(editInformation);
                break;
            case 2:
                System.out.println("Informe o novo preço:");
                editInformation = input.next();
                editInformation += input.nextLine();
                editInformation = checkIfCancel(editInformation);
                break;
            case 3:
                System.out.println("Informe a nova quantidade:");
                editInformation = input.next();
                editInformation = checkIfCancel(editInformation);
                break;
            case 4:
                System.out.println("Informe a nova categoria:");
                editInformation = input.next();
                editInformation += input.nextLine();
                editInformation = checkIfCancel(editInformation);
                break;
            case 5:
                System.out.println("Informe a nova descrição:");
                editInformation = input.next();
                editInformation += input.nextLine();
                editInformation = checkIfCancel(editInformation);
                break;
            default:
                System.out.println("Opção Inválida");
                main(null);

        }

        productService.editProduct(productToEdit, editionOption, editInformation);
    }


}

