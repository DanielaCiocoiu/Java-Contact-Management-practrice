package contact.management;

import static contact.management.Constante.identificareNumarMobil;
import java.io.Serializable;

public class NrMobil implements Serializable{

    private String mobil;
    public String tip;

    public NrMobil(String mobil, String tip) throws Exception {
        super();

        if ((mobil == null) && (mobil.length() > 10) && (mobil.length() == 0) && (identificareNumarMobil != "07")) {
            throw new IllegalArgumentException("Nr de telefon invalid");

        }
        this.mobil = mobil;
        this.tip = tip;
    }

    public String getNrFix() {
        return mobil;
    }

    public void setNrFix(String nrFix) {
        this.mobil = mobil;
    }

    public String getTip() {
        return tip;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public boolean equals(NrTel mobil) {
        boolean egal = true;
        if (this.mobil.compareTo(mobil.numar) != 0) {
            egal = false;
        }
        return egal;
    }

    public int compareTo(Object o) {
        NrMobil n = (NrMobil) o;
        return mobil.compareTo(n.mobil);
    }

    @Override
    public String toString() {
        return this.tip + " " + this.mobil;
    }
}
