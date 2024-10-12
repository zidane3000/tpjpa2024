package kahoot.dto;

import kahoot.domain.Kahoot;

public class KahootDTO {
    private long id;
    private String titre;
    private long createurId;
    private Kahoot.Type type;
    private int pin;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public long getCreateurId() {
        return createurId;
    }

    public void setCreateurId(long createurId) {
        this.createurId = createurId;
    }
    public Kahoot.Type getType() {return type;}

    public void setType(Kahoot.Type type) {this.type = type;}
    public int getPin() {return pin;}
    public void setPin(int pin) {this.pin = pin;}
}
