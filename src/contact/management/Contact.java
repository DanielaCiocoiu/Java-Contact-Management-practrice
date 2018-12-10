package contact.management;

import java.io.Serializable;

public class Contact implements Serializable{

    private String nume;
    private String prenume;
    private NrTel telefon;
     private String CNP;

    public Contact(String nume, String prenume,  String CNP, NrTel telefon) {
        if ((nume == null) && (nume.length() <= 2)) {
            throw new IllegalArgumentException("Nume invalid");
        }
        if ((prenume == null) && (prenume.length() <= 2)) {
            throw new IllegalArgumentException("Prenume invalid");
        }

        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this. telefon = telefon;

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public NrTel getTelefon() {
        return telefon;
    }

    public void setTelefon(NrTel numarTelefon) {
        this.telefon = numarTelefon;
    }



    public boolean equals(Contact c)
  {
    boolean egali = true;
    if (this.nume.compareToIgnoreCase(c.nume) != 0) {
      egali = false;
    }
    if (this.prenume.compareToIgnoreCase(c.prenume)!= 0) {
      egali = false;
    }
    if (!this.CNP.equals(c.CNP)) {
      egali = false;
    }
    if (!this.telefon.equals(c.telefon)) {
      egali = false;
    }
    return egali;
  }
    @Override
    public String toString() {
        return "Contact{" + "nume=" + nume + ", prenume=" + prenume + ", dataNasterii=" + CNP + ", nrTel=" + telefon + '}';
    }

}
