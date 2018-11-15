package br.com.ernanilima.jpdv.View.Enum;

/**
 * Enumeradores de CardLayout utilizado no PDV
 *
 * @author Ernani Lima
 */
public enum CardLayoutPDV {

    /**
     * Seleciona "tela de login"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setStartCardL(String)}
     */
    CARD_PDV("cardPDV"),

    /**
     * Seleciona "tela de vendas"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setStartCardL(String)}
     */
    CARD_LOGIN("cardLogin"),

    /**
     * Seleciona "tela de venda"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setSaleCardL(String)}
     */
    CARD_VENDA("cardPDVVenda"),

    /**
     * Seleciona "tela de troco"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setSaleCardL(String)}
     */
    CARD_TROCO("cardPDVTroco"),

    /**
     * Seleciona "tela de itens vendidos"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setSaleCardL(String)}
     */
    CARD_ITENS("cardPDVItens"),

    /**
     * Seleciona "tela de busca"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setSaleCardL(String)}
     */
    CARD_BUSCAR("cardPDVBuscar"),

    /**
     * Seleciona "painel de valores dos produtos"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setValueCardL(String)}
     */
    CARD_VALOR_PRODUTO("cardValProduto"),

    /**
     * Seleciona "painel de valores do cupom"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setValueCardL(String)}
     */
    CARD_VALOR_CUPOM("cardValCupom"),

    /**
     * Seleciona "painel de formas de pagamento"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setLogoCardL(String)}
     */
    CARD_FPAGAMENTO("cardFormasPagamento"),

    /**
     * Seleciona "painel de logo"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setLogoCardL(String)}
     */
    CARD_LOGO("cardLogo"),

    /**
     * Seleciona "painel para aplicar desconto"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setLogoCardL(String)}
     */
    CARD_DESCONTO("cardDesconto"),

    /**
     * Seleciona "painel de botons touch"
     * Utilizado em {@link br.com.ernanilima.jpdv.View.IViewPDV#setLogoCardL(String)}
     */
    CARD_BOTONS_TOUCH("cardBtnTouch");

    private String nameCardLayout;

    /**
     * @param nameCardLayout String - CardLayout selecionado
     */
    private CardLayoutPDV(String nameCardLayout) {
        this.nameCardLayout = nameCardLayout;
    }

    /**
     * @return String - Nome do CardLayout selecionado
     */
    public String getNameCardLayout() {
        return nameCardLayout;
    }
}