# Sistema de Gerenciamento de Finanças Pessoais Web (SGFP-Web)

Projeto em desenvolvimento. Tecnologias aplicadas: Java, Java Spring Boot, MySQL, MySqlConnector, HTML, CSS, Javascript, JQuery, Hibernate, Thymeleaf, Maven.

Software que busca auxiliar no controle de suas despesas. Possui funcionalidades como: conexão com banco de dados, tabela de despesas, filtro, cadastro e remoção de despesas, notificações.

Feito por Eduardo Bitencourt da Silva.

# Como utilizar este sistema?

### Siga os seguintes passos:

1. Deve-se cumprir os seguintes pré-requisitos

    * Ter Java JDK 17 ou superior instalado na sua máquina;
  
    * Ter MySQL (ou outro banco compatível) instalado e rodando como serviço;
  
    * NetBeans ou IDE de sua preferência (opcional).

2. Configurar o banco de dados

    * Abra o MySQL Workbench ou linha de comando;
  
    * Execute o script ```sgfpweb.sql```;
    
    * O script irá gerar o banco de dados sgfpweb e dois usuários pré-configurados: *admin* e *user*. O usuário "*admin*" possui permissões específicas de criar, deletar e configurar a categoria de despesas;
    o usuário "*user*" poderá somente visualizar despesas já cadastradas e ser notificado sobre as mesmas.

3. Configurar a aplicação

    * Verifique o arquivo ```application.properties```;
    
    * Ajuste as variáveis ```spring.datasource.url```, ```spring.datasource.username``` e ```spring.datasource.password``` conforme a configuração do banco de dados instalado na sua máquina.

4. Executar a aplicação

    * Execute por meio do NetBeans, IDE de sua preferência ou pelo próprio Maven (na linha de comando).

5. Acessando e utilizando o sistema

    * Abra o navegador;
  
    * Digite ```http://localhost:8080```;
  
    * Faça login usando um dos usuários já configurados no banco. O nome de usuário e a senha são iguais ao tipo de conta: use admin/admin para o administrador e user/user para o usuário comum.

### Detalhe sobre as notificações: 
* As notificações de despesas são exibidas no navegador ao permanecer na página onde foram configuradas, sendo necessário manter a página aberta para recebê-las.
