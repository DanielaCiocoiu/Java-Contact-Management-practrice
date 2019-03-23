package contact.management;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFormattedTextField;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L;
    public String dataNasterii;
    public Date(String dataNasterii) {
        this.dataNasterii = dataNasterii;
        if (dataNasterii != ("DD.MM.YYYY")) {
            throw new IllegalArgumentException("Data nasterii invalidaaa");
        }
    }

    public String getDataNasterii() {
        return dataNasterii;
    }
    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }
 
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD.MM.YYYY");
//
//    LocalDate loc = LocalDate.parse(dataNasterii, formatter);

    @Override
    public String toString() {
        return "Date{" + "dataNasterii=" + dataNasterii + '}';
    }

    public boolean equals(Date dat)
  {
    boolean egal = true;
    if (this.dataNasterii.compareTo(dat.dataNasterii) != 0) {
      egal = false;
    }
    return egal;
  }

}
