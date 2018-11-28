package br.com.ernanilima.jpdv.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Cria os bancos de dados NoSQL SQLite utilizado pelo PDV
 * Insere valores padroes em cada um dos bancos de dados
 * Banco de dados a ser criado: dbjpdv.db
 * Banco de dados a ser criado: parame.db
 *
 * @author Ernani Lima
 */
public class CreateDatabaseSQLite extends ConnectionSQLite {

    /**
     * Executa o metodo que verifica se o banco de dados ja existe
     */
    public static void createDB() {
        checkDB();
    }

    /**
     * Verifica a existencia dos bancos de dados NoSQL SQLite
     * Se nao existir -> cria arquivo SQlite, cria tabelas e insere os valores padroes
     * Se existir -> limpa todas as tabelas e insere os valores padroes
     */
    private static void checkDB() {
        if (!DB_JPDV.exists()) {
            createTablesPDV();
            insertPDV();
        } else {
            cleanTablesPDV();
            insertPDV();
        }

        if (!DB_JPDV_PARAME.exists()) {
            createTablesPARAME();
            insertPARAME();
        } else {
            cleanTablesPARAME();
            insertPARAME();
        }
    }

    /**
     * Cria tabela de produtos e de vendas realizadas no PDV.
     * Tabelas "produtos", "vendpdv" e "vpropdv".
     * Tabelas serao criadas no banco de dados "dbjpdv.db"
     */
    private static void createTablesPDV() {
        Connection conn = null;
        try {
            conn = openConnection();
            Statement st = conn.createStatement();

            String sqlPro = "CREATE TABLE IF NOT EXISTS produtos (" // Tabela com os produtos disponiveis para venda
                    + "cod_pro      INT UNIQUE NOT NULL PRIMARY KEY, " // Codigo do produto
                    + "desc_pro     STRING (200) NOT NULL, " // Descricao do produto
                    + "desc_procp   STRING (150) NOT NULL, " // Descricao do produto para cupom
                    + "cod_un_medida    INT NOT NULL, " // Codigo da unidade de medida
                    + "desc_un_medida    STRING (50), " // Abreveacao da unidade de medida
                    + "cod_bar      STRING (50) UNIQUE NOT NULL, " // Codigo de barras do produto
                    + "prec_vend    DOUBLE (10,2) NOT NULL, " // Preco de venda do produto
                    + "prec_prom    DOUBLE (10,2)) "; // Preco promocional do produto
            st.execute(sqlPro);
            System.out.println("CRIOU TABELA PRODUTOS");

            String sqlVend = "CREATE TABLE IF NOT EXISTS vendpdv (" // Tabela que grava informacoes do cupom
                    + "cod_filial INT NOT NULL, " // Codigo da Filial onde o PDV esta
                    + "cod_pdv INT NOT NULL, " // Numero do PDV
                    + "cod_cupom INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " // Numero do cupom vendido
                    + "cod_pag01  INT NOT NULL, " // Codigo da forma de pagamento 1 utilizada
                    + "val_fpg01  DOUBLE (10, 2) NOT NULL, " // Valor da forma de pagamento 1 utilizada
                    + "cod_pag02  INT, " // Codigo da forma de pagamento 2 utilizada
                    + "val_fpg02  DOUBLE (10, 2), " // Valor da forma de pagamento 2 utilizada
                    + "cod_pag03  INT, " // Codigo da forma de pagamento 3 utilizada
                    + "val_fpg03  DOUBLE (10, 2), " // Valor da forma de pagamento 3 utilizada
                    + "cup_total  DOUBLE (10, 2) NOT NULL, " // Valor total do cupom
                    + "cup_desconto  DOUBLE (10, 2), " // Valor total de desconto aplicado no cupom
                    + "cod_ope     INT            NOT NULL, " // Codigo do operador do PDV
                    + "cod_sup     INT, " // Codigo do supervisor
                    + "cup_canc    BOOLEAN, " // True caso o cupom seja cancelado
                    + "data_data   DATE           NOT NULL, " // Data da venda
                    + "data_hora   TIME           NOT NULL, " // Hora da venda
                    + "vend_status BOOLEAN, " // True caso a venda ja esteja sincronizada com o servidor
                    + "cod_mesa INT)"; // Codigo da mesa do estabelecimento
            st.execute(sqlVend);
            System.out.println("CRIOU TABELA VENDPDV");

            String sqlProVend = "CREATE TABLE IF NOT EXISTS vpropdv (" // Tabela que grava produtos por cupom
                    + "cod_filial INT NOT NULL, " // Codigo da Filial onde o PDV esta
                    + "cod_pdv INT NOT NULL, " // Numero do PDV
                    + "cod_cupom INT NOT NULL, " // Numero do cupom vendido
                    + "cod_pro INT NOT NULL, " // Codigo do produto vendido
                    + "desc_pro STRING (200) NOT NULL, " // Descricao do produto vendido
                    + "cod_bar STRING (50) NOT NULL, " // Codigo de barras do produto vendido
                    + "cod_un_medida INT NOT NULL, " // Codigo da unidade de medida do produto vendio
                    + "desc_un_medida STRING (50), " // Descricao da unidade de medida do produto vendido
                    + "qtd_vend    DOUBLE (10, 2) NOT NULL, " // Quantidade do produto vendido
                    + "prec_vend   DOUBLE (10, 2) NOT NULL, " // Preco de venda do produto
                    + "desconto    DOUBLE (10, 2), " // Total de desconto no produto
                    + "prec_total  DOUBLE (10, 2) NOT NULL, " // Preco total do produto (quantidade * preco de venda)
                    + "cod_ope     INT            NOT NULL, " // Codigo do operador que vendeu a mercadoria
                    + "cod_sup     INT, " // Codigo do supervisor em caso de desconto ou cancelamento
                    + "pro_canc    BOOLEAN, " // True para produtos cancelados
                    + "data_data   DATE           NOT NULL, " // Data da venda
                    + "data_hora   TIME           NOT NULL, " // Hora da venda
                    + "vend_status BOOLEAN, " // True caso a venda ja esteja sincronizada com o servidor
                    + "cod_mesa INT)"; // Codigo da mesa do estabelecimento
            st.execute(sqlProVend);
            System.out.println("CRIOU TABELA VPROPDV");
        } catch (SQLException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM DBJPDV: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO COM ARQUIVO DBJPDV: " + e);
        } finally {
            closeSQLite(conn);
        }
    }

    /**
     * Cria tabelas de parametros do PDV.
     * Tabelas "forpag", "tabuser" e "tclatalho".
     * Tabelas seram criadas no banco de dados "parame.db"
     */
    private static void createTablesPARAME() {
        Connection conn = null;
        try {
            conn = openConnectionParame();
            Statement st = conn.createStatement();

            String sqlForPag = "CREATE TABLE IF NOT EXISTS forpag (" // Tabela com as formas de pagamento
                    + "cod_fpag  INT          UNIQUE NOT NULL PRIMARY KEY, " // Codigo da forma de pagamento
                    + "desc_fpag STRING (100) NOT NULL)"; // Descricao da forma de pagamento
            st.execute(sqlForPag);
            System.out.println("CRIOU TABELA FORPAG");

            String sqlUser = "CREATE TABLE IF NOT EXISTS tabuser (" // Tabela com os dados de usuarios do PDV
                    + "user_id    INT (11)      UNIQUE NOT NULL PRIMARY KEY, " // Codigo do usuario
                    + "user_nome  VARCHAR (100) NOT NULL, " // Nome do usuario
                    + "user_senha VARCHAR (255) NOT NULL, " // Senha do usuario
                    + "user_nivel INT (11)      NOT NULL)"; // Nivel de acesso do usuario
            st.execute(sqlUser);
            System.out.println("CRIOU TABELA TABUSER");

            String sqlTcl = "CREATE TABLE IF NOT EXISTS tclatalho (" // Tabela com as teclas de atalho do PDV
                    + "id          INT          PRIMARY KEY, " // ID do atalho
                    + "desc_atalho VARCHAR (40) NOT NULL UNIQUE, " // Descricao do atalho
                    + "codtcl      INT, " // KeyCode da tecla de atalho
                    + "tecla       VARCHAR (10))"; // Tecla de atalho
            st.execute(sqlTcl);
            System.out.println("CRIOU TABELA TCLATALHO");
        } catch (SQLException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO COM ARQUIVO PARAME: " + e);
        } finally {
            closeSQLite(conn);
        }
    }

    /**
     * Insere produtos disponiveis para realizar vendas no PDV.
     * Banco de dados "dbjpdv.db"
     * Produtos serao inseridos na tabela "produtos"
     */
    private static void insertPDV() {
        Connection conn = null;
        try {
            conn = openConnection();
            Statement st = conn.createStatement();

            String sqlPro = "INSERT INTO produtos (cod_pro, desc_pro, desc_procp, cod_un_medida, desc_un_medida, cod_bar, prec_vend, prec_prom) VALUES (4, 'PIZZA DE CALABRESA M', 'PIZZA DE CALABRESA M', 1, 'UN', 7894, 45.0, 0.0);"
                    + "INSERT INTO produtos (cod_pro, desc_pro, desc_procp, cod_un_medida, desc_un_medida, cod_bar, prec_vend, prec_prom) VALUES (5, 'HAMBURGUER DE COSTELA', 'HAMBURGUER DE COSTELA', 1, 'UN', 7895, 25.0, 0.0);"
                    + "INSERT INTO produtos (cod_pro, desc_pro, desc_procp, cod_un_medida, desc_un_medida, cod_bar, prec_vend, prec_prom) VALUES (6, 'COCA COLA 600ML', 'COCA COLA 600ML', 1, 'UN', 7896, 9.0, 0.0);";
            st.executeUpdate(sqlPro);
            System.out.println("INSERIU PRODUTOS");
        } catch (SQLException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM DBJPDV: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO COM ARQUIVO DBJPDV: " + e);
        } finally {
            closeSQLite(conn);
        }
    }

    /**
     * Insere formas de pagamento, usuarios e parametros padroes do PDV.
     * Banco de dados "parame.db"
     * Formas de Pagamento serao inseridas na tabela "forpag"
     * Usuarios serao inseridos na tebela "tabuser"
     * Teclas de Atalho serao inseridas na tabela "tclatalho"
     */
    private static void insertPARAME() {
        Connection conn = null;
        try {
            conn = openConnectionParame();
            Statement st = conn.createStatement();

            String sqlForPag = "INSERT INTO forpag (cod_fpag, desc_fpag) VALUES (1, 'DINHEIRO');"
                    + "INSERT INTO forpag (cod_fpag, desc_fpag) VALUES (2, 'CARTAO DEBITO');"
                    + "INSERT INTO forpag (cod_fpag, desc_fpag) VALUES (3, 'CARTAO CREDITO');";
            st.executeUpdate(sqlForPag);
            System.out.println("INSERIU FORMAS DE PAGAMENTO");

            String sqlUser = "INSERT INTO tabuser (user_id, user_nome, user_senha, user_nivel) VALUES (1, 'OPERADOR', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', 1);"
                    + "INSERT INTO tabuser (user_id, user_nome, user_senha, user_nivel) VALUES (2, 'FISCAL DE CAIXA', 'D4735E3A265E16EEE03F59718B9B5D03019C07D8B6C51F90DA3A666EEC13AB35', 2);"
                    + "INSERT INTO tabuser (user_id, user_nome, user_senha, user_nivel) VALUES (3, 'GERENTE', '4E07408562BEDB8B60CE05C1DECFE3AD16B72230967DE01F640B7E4729B49FCE', 3);";
            st.executeUpdate(sqlUser);
            System.out.println("INSERIU USUARIOS");

            String sqlTcl = "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (1, 'Totalizar Venda', 84, 'T');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (2, 'Pag. Dinheiro', 113, 'F2');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (3, 'Pag. Cartão Deb', 114, 'F3');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (4, 'Pag. Cartão Cred', 115, 'F4');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (5, 'Pag. Carteira Cliente', 116, 'F5');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (6, 'ad1', 90, 'Z');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (7, 'ad2', 0, '');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (8, 'ad3', 0, '');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (9, 'ad4', 0, '');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (10, 'ad5', 0, '');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (11, 'Desconto Sub. Total', 109, '-');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (12, 'Desconto no Item', 109, '-');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (13, 'Cancelar Cupom Atual', 89, 'Y');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (14, 'Cancelar Ultimo Cupom', 85, 'U');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (15, 'Cancelar Item Generico', 73, 'I');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (16, 'Cancelar Ultimo Item', 79, 'O');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (17, 'Quantidade', 81, 'Q');"
                    + "INSERT INTO tclatalho (id, desc_atalho, codtcl, tecla) VALUES (18, 'Repetir Ultimo Item', 82, 'R');";
            st.executeUpdate(sqlTcl);
            System.out.println("INSERIU TECLAS DE ATALHO");
        } catch (SQLException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO COM ARQUIVO PARAME: " + e);
        } finally {
            closeSQLite(conn);
        }
    }

    /**
     * Limpa todas as tabelas do banco de dados "dbjpdv.db"
     */
    private static void cleanTablesPDV() {
        Connection conn = null;
        Statement st;
        String sql = "DELETE FROM produtos;"
                + "DELETE FROM vendpdv;"
                + "DELETE FROM vpropdv;";
        try {
            conn = openConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("LIMPOU TABELAS DBPDV");
        } catch (SQLException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM DBJPDV: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO COM ARQUIVO DBJPDV: " + e);
        } finally {
            closeSQLite(conn);
        }
    }

    /**
     * Limpa todas as tabelas do banco de dados "parame.db"
     */
    private static void cleanTablesPARAME() {
        Connection conn = null;
        Statement st;
        String sql = "DELETE FROM forpag;"
                + "DELETE FROM tabuser;"
                + "DELETE FROM tclatalho;";
        try {
            conn = openConnectionParame();
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("LIMPOU TABELAS PARAME");
        } catch (SQLException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO COM ARQUIVO PARAME: " + e);
        }
    }
}