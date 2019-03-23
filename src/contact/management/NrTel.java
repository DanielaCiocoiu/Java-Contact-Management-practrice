package contact.management;

import java.io.Serializable;

public  class NrTel implements Serializable {

    private static final long serialVersionUID = 1L;

    public String numar;
    public String tip;

    public NrTel(String numar, String tip) {
//        if ((numar == null) && (numar.length() > 11) && (numar.length() != 0)) {
//            throw new IllegalArgumentException("Nr de telefon invalid");
//        }
        this.numar = numar;
        this.tip = tip;
    }

    public boolean equals(NrTel tel) {
        boolean egal = true;
        if (this.numar.compareTo(tel.numar) != 0) {
            egal = false;
        }
        return egal;
    }

    public String toString() {
        return this.tip + " " + this.numar;
    }

}
