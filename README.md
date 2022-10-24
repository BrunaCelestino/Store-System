#   DESAFIO DO MÓDULO 1

## Descrição

Esse repositório conta com uma aplicação simples, que gerencia o inventário de uma loja. 
Através dessa aplicação, o usuário pode adicionar produtos, editá-los, excluí-los e importar o mostruário de fábrica com produtos já cadastrados, tendo acesso ao valor final de cada produto na lista da loja.


## Funcionalidades


Para iniciar a aplicação pela linha de comando, basta digitar "java Store" no terminal.
Ao iniciar, o usuário terá acesso ao menu principal:

![menu](/assets/menu.png)  






### Adicionar um novo produto

Ao escolher a opção 1, o usuário poderá fornecer as seguintes informações sobre o produto:
nome, preço, quantidade em estoque e categoria.

Ao todo, um produto conta com 13 campos. sendo eles:

- Código;
- Código de Barras;
- Número de série;
- Nome;
- Descrição;
- Categoria;
- Preço;
- Imposto;
- Data de fabricação;
- Data de validade;
- Cor;
- Material;
- Quantidade.

As demais informações são preenchidas automaticamente pelo sistema.
O usuário pode, a qualquer momento durante o cadastro de um produto, cancelar a operação. Basta digitar "SAIR", e será redirecionado para o menu principal.
Ao fim do cadastro, o produto é inserido ao arquivo **NewProducts.csv**, o usuário é informado se a operação foi bem sucedida e redirecionado para o menu.

### Editar um produto

Ao escolher a opção 2, o usuário terá acesso a todos os produtos cadastrados na loja, Em uma lista enumerada, o mesmo poderá escolher qual deseja editar:

<br>

![productList](/assets/productList.png)


Ao informar o número do produto a ser modificado, o usuário será direcionado ao menu secundário, onde poderá escolher qual das informações sobre o produto deseja editar.


![submenu](/assets/submenu.png)


<br>

Ao informar a opção númerica, o usuário poderá fornecer o novo dado. Caso queira cancelar a operação, basta digitar "SAIR". Ao fim da operação, retornará ao menu principal.

### Excluir um  produto

Ao escolher a opção 3, o usuário terá acesso a todos os produtos cadastrados na loja, Em uma lista enumerada, o mesmo poderá escolher qual deseja excluir:


![deletelist](/assets/deletelist.png)


<br>

Ao escolher o produto, será necessário que o usuário confirme se deseja prosseguir com a operação. Caso confirme, o produto será deletado e o usuário redirecionado ao menu principal.


![confirmdelete](/assets/confirmdelete.png)


<br>

### Importar mostruário de fábrica

Ao escolher a opção 4, o usuário importará o mostruário de fábrica, o adicionando a lista de produtos. Além disso, terá acesso ao valor final de cada produto, e da lista atualizada.


![importInventory](/assets/importInventory.png)


<br>


![finalvalue](/assets/finalvalue.png)


<br>

Ao fim da importação, o usuário será redirecionado ao menu principal.

### Encerrar a aplicação

Ao escolher a opção 5, o usuário poderá encerrar a aplicação.
Em qualquer outro momento, ao digitar "SAIR", será redirecionado ao menu principal, onde poderá escolher a opção de deixar permanentemente o programa.


![leave](/assets/leave.png)


<br>

#### Verificando duplicidades

Caso o usuário queria se certificar que a lista de produtos não contém itens repetidos, pode utilizar a funcionalidade extra que verifica e elimina duplicidades. Basta rodar, pela linha de comando: **java CrunchifyFindDuplicateCSV**.

#### Testes Unitários

Para a realização dos testes unitários das principais funcionalidades, foi utilizada a dependência **JUnit**.

#### Dependências

- JUnit;




---------------------------------------------------------------------
  
  



``Bruna Massuchini``

<br>