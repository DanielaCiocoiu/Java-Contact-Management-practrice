package contact.management;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.regex.Pattern;

public class Constante {

    public static final Dimension DIMENSIUNE_ECRAN = Toolkit.getDefaultToolkit().getScreenSize();
    public static final Dimension DIMENSIUNE_FEREASTRA = new Dimension(800, 600);
    public static final String DIRECTOR_POZE = "poze";
    public static final char[] COD_CORECT = {'1', '1', '1'};
    public static final Pattern PATTERN_NUME = Pattern.compile("[A-Z]('[A-Z])?([a-z])+");
    public static final Pattern PATTERN_PRENUME = Pattern.compile("(\\b([A-Z])([a-z])+([ -])?)+");
    //public static final Pattern PATTERN_DATANASTERII = Pattern.compile("DD.MM.YYYY");
     public static final Pattern PATTERN_CNP = Pattern.compile("[01]([0-9]){12}");
    public static final Pattern PATTERN_TELEFON_MOBIL = Pattern.compile("07([0-9]){8}");
    public static final Pattern PATTERN_TELEFON_FIX = Pattern.compile("0[2-3]([0-9]){8}");
    public static final String identificareNumarFix = "02";
    public static final String identificareNumarMobil = "07";
}
