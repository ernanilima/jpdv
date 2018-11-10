package br.com.ernanilima.jpdv.Model;

import javax.swing.ImageIcon;

/**
 * Classe de getters com o caminho de cada icone personalizado do sistema
 *
 * @author Ernani Lima
 */
public class Icons {

    //Caminho interno da aplicacao contendo cada imagem de icone
    private final ImageIcon error = new ImageIcon(getClass().getResource("/icons/error_icon.png"));
    private final ImageIcon alert = new ImageIcon(getClass().getResource("/icons/alert_icon.png"));
    private final ImageIcon okay = new ImageIcon(getClass().getResource("/icons/okay_icon.png"));
    private final ImageIcon question = new ImageIcon(getClass().getResource("/icons/question_icon.png"));

    // Construtor vazio
    public Icons() {}

    /**
     * @return ImageIcon - Icone de erro
     */
    public ImageIcon getIconError() {
        return error;
    }

    /**
     * @return ImageIcon - Icone de alerta
     */
    public ImageIcon getIconAlert() {
        return alert;
    }

    /**
     * @return ImageIcon - Icone de ok
     */
    public ImageIcon getIconOkay() {
        return okay;
    }

    /**
     * @return ImageIcon - Icone de questionamento (?)
     */
    public ImageIcon getIconQuestion() {
        return question;
    }
}