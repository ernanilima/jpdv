package br.com.ernanilima.jpdv.Model.Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Indice com as opcoes do painel do admin (fiscal de caixa)
 *
 * @author Ernani Lima
 */
public enum AdminOptions {

    SALE_SCREEN(0, "Ir para a tela de vendas."),
    OPENING(1, "Abertura de caixa PDV."),
    DEPOSIT(2, "Reforço de caixa (suprimento)."),
    WITHDRAWAL(3, "Retirada de caixa (sangria).");

    private static final List<String> OPTIONS;
    private final int index;
    private final String option;

    static {
        OPTIONS = new ArrayList<>();
        for (AdminOptions adminOptions:AdminOptions.values()) {
            OPTIONS.add(adminOptions.option);
        }
    }

    /**
     * Construtor
     * @param index int - ID da opcao do painel do admin
     * @param option String - Descricao da opcao do painel do admin
     */
    AdminOptions(int index, String option) {
        this.index = index;
        this.option = option;
    }

    /**
     * @return int - da opcao do painel do admin
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return List - Lista com as opcoes do painel do admin
     */
    public static List<String> getValues() {
        return Collections.unmodifiableList(OPTIONS);
    }
}
