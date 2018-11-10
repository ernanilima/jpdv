package br.com.ernanilima.jpdv.Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Classe com metodos para gerenciar campos de texto
 *
 * @author Ernani Lima
 */
public class FieldManager {

    /**
     * Filtro para permitir apenas numeros.
     */
    public static class FieldFilterInt extends PlainDocument {
        /** Numero de caracteres permitidos */
        private int numberOfCharacters;

        /**
         * Faz com que campo de texto aceite apenas numeros.
         * A variavel {@link #numberOfCharacters} permite
         * definir a quantidade maxima de caracteres aceitos
         *
         * @param numberOfCharacters int - Quantidade de caracteres permitidos
         */
        public FieldFilterInt(int numberOfCharacters) {
            this.numberOfCharacters = numberOfCharacters;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if ((getLength() + str.length()) <= numberOfCharacters) {
                super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
            }
        }

        @Override
        public void replace(int offs, int length, String str, AttributeSet a) throws BadLocationException {
            super.replace(offs, length, str.replaceAll("[^0-9]", ""), a);
        }
    }
}
