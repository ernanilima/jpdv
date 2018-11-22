package br.com.ernanilima.jpdv.Util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Classe utilizada para formatar conteudos
 *
 * @author Ernani Lima
 */
public class Format {

    /**
     * Formata o numero da linha do produto inserido, 3 digitos
     */
    public static final DecimalFormat formatProductRowIndex = new DecimalFormat("000");

    /**
     * Formata o numero do codigo de barras do produto, 14 digitos
     */
    public static final DecimalFormat formatBarcode = new DecimalFormat("0000000000000");

    /**
     * Formata a quantidade do produto, 3 casas decimais
     */
    public static final DecimalFormat formatQty = new DecimalFormat("##0.000");

    /**
     * Formata valores monetarios com o padrao do Brasil
     */
    public static final NumberFormat brCurrencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    /**
     * Formata a data para o padrao americano
     */
    public static final DateFormat DFDATE = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Formata a hora no padrao 24 horas
     */
    public static final DateFormat DFTIME = new SimpleDateFormat("HH:mm:ss");

}
