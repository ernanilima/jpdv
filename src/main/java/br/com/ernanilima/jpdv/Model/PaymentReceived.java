package br.com.ernanilima.jpdv.Model;

/**
 * Model de pagamento recebido.
 *
 * @author Ernani Lima
 */
public class PaymentReceived {

    // Variaveis de pagamento recebido
    private double value;
    private Payment mPayment;

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
     * @return {@link Payment} - Model de forma de pagamento
     */
    public Payment getmPayment() {
        return mPayment;
    }

    /**
     * @param mPayment {@link Payment} - Model de forma de pagamento
     */
    public void setmPayment(Payment mPayment) {
        this.mPayment = mPayment;
    }
}
