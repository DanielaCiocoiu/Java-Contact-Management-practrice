package contact.management;

import static contact.management.Constante.identificareNumarFix;
import java.io.Serializable;

public  class NrFix extends NrTel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fix;

    public NrFix(String fix, String tip) throws Exception {
        super(fix, tip);

        if ((numar == null) && (numar.length() > 10) && (numar.length() == 0) && (identificareNumarFix != "02")) {
            throw new IllegalArgumentException("Nr de telefon invalid");

        }
        this.fix = fix;
        this.tip = tip;
    }

    public String getNrFix() {
        return fix;
    }

    public void setNrFix(String nrFix) {
        this.fix = fix;
    }

    public String getTip() {
        return tip;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    @Override
    public boolean equals(NrTel fix) {
        boolean egal = true;
        if (this.numar.compareTo(fix.numar) != 0) {
            egal = false;
        }
        return egal;
    }

    public String toString() {
        return this.tip + " " + this.fix;
    }

    

}
