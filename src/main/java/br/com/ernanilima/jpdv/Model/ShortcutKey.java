package br.com.ernanilima.jpdv.Model;

import java.util.List;

/**
 * Model de teclas de atalho do PDV
 *
 * @author Ernani Lima
 */
public class ShortcutKey {

    private int id;
    private String description;
    private int keyCode;
    private String keyText;
    private List<ShortcutKey> lsShortcutKeys;

    // Construtor vazio
    public ShortcutKey() {}

    /**
     * @return int - ID da tecla de atalho
     */
    public int getId() {
        return id;
    }

    /**
     * @param id int - ID da tecla de atalho
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String - Descricao da tecla de atalho
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description String - Descricao da tecla de atalho
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return int - KeyCode da tecla de atalho
     */
    public int getKeyCode() {
        return keyCode;
    }

    /**
     * @param keyCode int - Keycode da tecla de atalho
     */
    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * @return String - KeyText da tecla de atalho
     */
    public String getKeyText() {
        return keyText;
    }

    /**
     * @param keyText String - KeyText da tecla de atalho
     */
    public void setKeyText(String keyText) {
        this.keyText = keyText;
    }

    /**
     * @return List - Lista de teclas de atalho
     */
    public List<ShortcutKey> getLsShortcutKeys() {
        return lsShortcutKeys;
    }

    /**
     * @param lsShortcutKeys List<{@link ShortcutKey} - Lista de teclas de atalho
     */
    public void setLsShortcutKeys(List<ShortcutKey> lsShortcutKeys) {
        this.lsShortcutKeys = lsShortcutKeys;
    }
}
