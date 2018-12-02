package br.com.ernanilima.jpdv.Connection;

import java.io.File;
import java.sql.*;

/**
 * Classe de conexao com banco de dados NoSQL SQLite.
 * Bacos de dados: "dbjpdv.db" e "parame.db"
 *
 * @author Ernani Lima
 */
public class ConnectionSQLite {

    /** Arquivo SQLite dbjpdv.db armazena os produtos e vedas realizadas */
    static final File DB_JPDV = new File("dbjpdv.db");

    /** Arquivo SQLite parame.db armazena os parametros no pdv */
    static final File DB_JPDV_PARAME = new File("parame.db");


    /** Driver de conexao para o banco de dados SQLite */
    private static final String DRIVER = "org.sqlite.JDBC";


    /** Caminho para o banco de dados dbjpdv.db */
    private static final String PATH_DB = "jdbc:sqlite:" + DB_JPDV.getPath();

    /** Caminho para o banco de dados parame.db */
    private static final String PATH_DB_PARAME = "jdbc:sqlite:" + DB_JPDV_PARAME.getPath();

    /**
     * Responsavel por abrir a conexao com o banco de dados que armazena os produtos e vendas do PDV.
     * Banco de dados "dbjpdv.db" SQLite
     * @return Connection - Conexao com banco de dados dbjpdv.db
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(PATH_DB);
    }

    /**
     * Responsavel por abrir a conexao com o banco de dados que armazena os parametros de PDV.
     * Banco de dados "parame.db" SQLite
     * @return Connection - Conexao com banco de dados parame.db
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection openConnectionParame() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(PATH_DB_PARAME);
    }

    /**
     * Fecha Connection
     * @param conn - Connection para fechar
     */
    public static void closeSQLite(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fecha Connection e PreparedStatement
     * @param conn - Connection para fechar
     * @param pst - PreparedStatement para fechar
     */
    public static void closeSQLite(Connection conn, PreparedStatement pst) {
        closeSQLite(conn);
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fecha Connection, PreparedStatement e ResultSet
     * @param conn - Connection para fechar
     * @param pst - PreparedStatement para fechar
     * @param rs - ResultSet para fechar
     */
    public static void closeSQLite(Connection conn, PreparedStatement pst, ResultSet rs) {
        closeSQLite(conn, pst);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
