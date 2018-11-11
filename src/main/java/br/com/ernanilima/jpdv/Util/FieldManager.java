package br.com.ernanilima.jpdv.Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.util.regex.Pattern;

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
                super.insertString(offs, str, a);
            }
        }

        @Override
        public void replace(int offs, int length, String str, AttributeSet a) throws BadLocationException {
            super.replace(offs, length, str.replaceAll("[^0-9]", ""), a);
        }
    }

    /**
     * Permitir apenas numeros e um ponto(.)
     */
    public static class FieldFilterDouble extends PlainDocument {
        /** Numero de caracteres permitidos */
        private int numberOfCharacters;

        /**
         * Faz com que campo de texto aceite apenas numeros e um ponto(.)
         * A variavel {@link #numberOfCharacters} permite
         * definir a quantidade maxima de caracteres aceitos
         *
         * @param numberOfCharacters int - Quantidade de caracteres permitidos
         */
        public FieldFilterDouble(int numberOfCharacters) {
            this.numberOfCharacters = numberOfCharacters;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if ((getLength() + str.length()) <= numberOfCharacters) {
                String currentString = getText(0, getLength());
                Pattern pattern;
                boolean currentDouble = currentString.contains(".");

                if (currentDouble) {
                    // Executa se ja for double
                    pattern = Pattern.compile("[0-9]");
                } else {
                    // Executa se ainda nao for double
                    pattern = Pattern.compile("[0-9|.]");
                }

                if (pattern.matcher(str).matches()) {
                    super.insertString(offs, str, a);
                }
            }
        }

        @Override
        public void replace(int offs, int length, String str, AttributeSet a) throws BadLocationException {
            super.replace(offs, length, str.replaceAll("[^0-9|^.|^,]", "").replace(",", "."), a);
        }
    }
}
