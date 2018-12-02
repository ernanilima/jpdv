package br.com.ernanilima.jpdv.Model;

/**
 * Model de pagamento recebido.
 *
 * @author Ernani Lima
 */
public class PaymentReceived {

    // Variaveis de pagamento recebido
    private double value;
    private PaymentMethod mPayment;

    // Construtor vazio
    public PaymentReceived() {}

    /**
     * @return double - Valor pago
     */
    public double getValue() {
        return value;
    }

    /**
     * Atribui o valor pago na variavel {@link #value}
     * @param value double - Valor pago
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return {@link PaymentMethod} - Model de forma de pagamento
     */
    public PaymentMethod getmPayment() {
        return mPayment;
    }

    /**
     * @param mPayment {@link PaymentMethod} - Model de forma de pagamento
     */
    public void setmPayment(PaymentMethod mPayment) {
        this.mPayment = mPayment;
    }
}
