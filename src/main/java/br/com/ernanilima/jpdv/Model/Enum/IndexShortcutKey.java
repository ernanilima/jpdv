package br.com.ernanilima.jpdv.Model.Enum;

/**
 * Enumeradores com Index das teclas de atalho da lista armazenada
 * no Model {@link br.com.ernanilima.jpdv.Model.ShortcutKey}
 *
 * @author Ernani Lima
 */
public enum IndexShortcutKey {

    /**
     * Os enumeradores abaixo representao apenas o index onde se encontra o KeyCode
     * da tecla de atalho que esta querendo utilizar.
     */

    /** Totalizar venda */
    TOTALIZE(0),

    /** Pagamento em Dinheiro */
    PAYMENT_MONEY(1),

    /** Pagamento com Cartao de Credito */
    PAYMENT_CREDIT_CARD(2),

    /** Pagamento com Cartao de Debito */
    PAYMENT_DEBIT_CARD(3),

    /** Atalho adicionaL a ser definido */
    ADDITIONAL1(5),
    /** Atalho adicionaL a ser definido */
    ADDITIONAL2(6),
    /** Atalho adicionaL a ser definido */
    ADDITIONAL3(7),
    /** Atalho adicionaL a ser definido */
    ADDITIONAL4(8),
    /** Atalho adicionaL a ser definido */
    ADDITIONAL5(9),

    /** Desconto na venda */
    DISCOUNT_ON_SALE(10),

    /** Desconto no produto */
    DISCOUNT_ON_PRODUCT(11),

    /** Cancelar venda atual */
    CANCEL_CURRENT_SALE(12),

    /** Cancelar ultima venda */
    CANCEL_LAST_SALE(13),

    /** Cancelar qualquer produto */
    CANCEL_GENERIC_PRODUCT(14),

    /** Cancelar ultimo produto */
    CANCEL_LAST_PRODUCT(15),

    /** Informar a quantidade do produto */
    QUANTITY(16),

    /** Repetir o ultimo produto */
    REPEAT_LAST_PRODUCT(17);

    private int id;

    /**
     * @param id int - Tecla de atalho selecionada
     */
    IndexShortcutKey(int id) {
        this.id = id;
    }

    /**
     * @return int - Codigo da tecla de atalho armazenada no banco de dados
     */
    public int getId() {
        return id;
    }
}
