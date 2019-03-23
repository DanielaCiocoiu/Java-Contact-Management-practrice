package Design;

import contact.management.CarteDeTelefon;
import contact.management.Constante;
import contact.management.Contact;
import contact.management.NrTel;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.regex.Matcher;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    CarteDeTelefon agenda;
    Contact contact_de_sters;
    public File fisier;
    int randSelectat;

    String[] columnNames = {"Nr. Crt", "Nume", "Prenume", "CNP", "Telefon"};
    DefaultTableModel model1 = new DefaultTableModel(this.columnNames, 0) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private boolean shareware = true;

    final ImageIcon[] slide = {new ImageIcon("poze/image (1).jpg"), new ImageIcon("poze/image (2).jpg"), new ImageIcon("poze/image (3).jpg"), new ImageIcon("poze/image (4).jpg"), new ImageIcon("poze/image (5).jpg")};
    Thread salvareFisier = new Thread() {
        @Override
        public void run() {

            for (int i = 0; i < 5; i %= 5) {
                try {
                    Thread.sleep(300000L);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Salvarea automata a esuat!", "Eroare", 0);
                }
                FileOutputStream fos2 = null;
                try {
                    fos2 = new FileOutputStream(GUI.this.fisier);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Salvarea automata a esuat!", "Eroare", 0);
                }
                ObjectOutputStream oos2 = null;
                try {
                    oos2 = new ObjectOutputStream(fos2);
                    oos2.writeObject(GUI.this.agenda);
                    oos2.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Salvarea automata a esuat!", "Eroare", 0);
                }
            }
        }
    };

    public boolean getShareware() {
        return this.shareware;
    }

    public JButton getjButonRevenire() {
        return jButonRevenire;
    }

    public JLabel getjLabelInfo() {
        return jLabelInfo;
    }

    public void setShareware(boolean modShareware) {
        this.shareware = modShareware;
    }

    public Contact getContactSelectat()  {
        randSelectat = this.jTableAgenda.getSelectedRow();
        Contact c1 = new Contact(
                (String) this.jTableAgenda.getValueAt(this.randSelectat, 1),
                (String) this.jTableAgenda.getValueAt(this.randSelectat, 2),
                (String) this.jTableAgenda.getValueAt(this.randSelectat, 3),
                new NrTel((String) this.jTableAgenda.getValueAt(this.randSelectat, 4), "Mobil"));

        ListIterator iterator3 = agenda.listIterator();
        while (iterator3.hasNext()) {
            if (((Contact) iterator3.next()).equals(c1)) {
                c1.setTelefon(new NrTel(c1.getTelefon().numar,
                        ((Contact) iterator3.previous()).getTelefon().tip));
                iterator3.next();
            }
        }
        return c1;
    }

    public void populareTabel(ArrayList lista) {
        int i = 1;
        this.model1.setRowCount(0);
        ListIterator iterator1 = lista.listIterator();
        while (iterator1.hasNext()) {
            Contact c = (Contact) iterator1.next();
            String[] rowData = {Integer.toString(i), c.getNume(), c.getPrenume(), c.getCNP(), c.getTelefon().numar};
            this.model1.addRow(rowData);
            i++;
        }
    }

    public GUI(CarteDeTelefon cdt) {
        initComponents();

        jDialogInregistrare.setTitle("Inregistrare aplicatie");
        jDialogModificare.setTitle("Modificare abonat");
        jDialogCautare.setTitle("Cautare abonat");

        this.agenda = cdt;
        setLocation(Constante.DIMENSIUNE_ECRAN.width / 2 - getWidth() / 2, Constante.DIMENSIUNE_ECRAN.height / 2 - getHeight() / 2);
        Runnable bannere = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < GUI.this.slide.length; i %= 4) {
                    GUI.this.jLabelBanner.setIcon(GUI.this.slide[i]);
                    i++;
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        Thread slideshow = new Thread(bannere);
        slideshow.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc = new javax.swing.JFileChooser();
        jDialogAdaugare = new javax.swing.JDialog();
        jNume = new javax.swing.JLabel();
        jPrenume = new javax.swing.JLabel();
        tfNume = new javax.swing.JTextField();
        tfPrenume = new javax.swing.JTextField();
        bAdauga = new javax.swing.JButton();
        jCNP = new javax.swing.JLabel();
        bIesire = new javax.swing.JButton();
        jNrTelefon = new javax.swing.JLabel();
        jComboBoxTip1 = new javax.swing.JComboBox<>();
        tfTelefon = new javax.swing.JTextField();
        tfCNP = new javax.swing.JTextField();
        jDialogInregistrare = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jButonActivare = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButtonOk = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jPas = new javax.swing.JPasswordField();
        jDialogModificare = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNume2 = new javax.swing.JTextField();
        jTextFieldPrenume2 = new javax.swing.JTextField();
        jTextFieldCNP2 = new javax.swing.JTextField();
        jTextFieldTelefon2 = new javax.swing.JTextField();
        jComboBoxTip2 = new javax.swing.JComboBox<>();
        jButonModificaModificare = new javax.swing.JButton();
        jButonIesireModificare = new javax.swing.JButton();
        jDialogCautare = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jRadioButtonNume = new javax.swing.JRadioButton();
        jRadioButtonPrenume = new javax.swing.JRadioButton();
        jRadioButtonCNP = new javax.swing.JRadioButton();
        jRadioButtonTelefon = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCautat = new javax.swing.JTextField();
        jButonCautaCautare = new javax.swing.JButton();
        jButonIesireCautare = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bAdaugaContact = new javax.swing.JButton();
        bStergeContact = new javax.swing.JButton();
        bEditareContact = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jLabelRezultateleCautarii = new javax.swing.JLabel();
        jLabelBanner = new javax.swing.JLabel();
        jButonCauta = new javax.swing.JButton();
        jLabelInfo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButonRevenire = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuAfisare = new javax.swing.JMenu();
        jOpen = new javax.swing.JMenuItem();
        jSave = new javax.swing.JMenuItem();
        jIesire = new javax.swing.JMenuItem();
        jMenuAjutor = new javax.swing.JMenu();
        jInregistrare = new javax.swing.JMenuItem();
        jDespre = new javax.swing.JMenuItem();

        jNume.setText("Nume");

        jPrenume.setText("Prenume");

        bAdauga.setText("Adauga");
        bAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaActionPerformed(evt);
            }
        });

        jCNP.setText("CNP");

        bIesire.setText("Iesire");
        bIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIesireActionPerformed(evt);
            }
        });

        jNrTelefon.setText("Telefon");

        jComboBoxTip1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fix", "Mobil" }));

        javax.swing.GroupLayout jDialogAdaugareLayout = new javax.swing.GroupLayout(jDialogAdaugare.getContentPane());
        jDialogAdaugare.getContentPane().setLayout(jDialogAdaugareLayout);
        jDialogAdaugareLayout.setHorizontalGroup(
            jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogAdaugareLayout.createSequentialGroup()
                        .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNrTelefon)
                            .addComponent(jCNP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                                .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jComboBoxTip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfCNP, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogAdaugareLayout.createSequentialGroup()
                        .addComponent(jPrenume)
                        .addContainerGap())))
            .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(bAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(bIesire, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jNume, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNume, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialogAdaugareLayout.setVerticalGroup(
            jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jNume))
                    .addComponent(tfNume, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPrenume)
                    .addComponent(tfPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCNP)
                    .addComponent(tfCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jNrTelefon))
                    .addGroup(jDialogAdaugareLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxTip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jDialogAdaugareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bIesire, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jDialogInregistrare.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Introduceti codul unic de inregistrare");
        jDialogInregistrare.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 27, 282, 62));

        jButonActivare.setText("Activare");
        jButonActivare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonActivareActionPerformed(evt);
            }
        });
        jDialogInregistrare.getContentPane().add(jButonActivare, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 236, 50));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Inregistrarea aplicatiei ofera in plus urmatoarele facilitati:\n  -  Deschidere,\n  -  Inchidere din bara de meniu,\n  -  dezactivarea banner-ului din partea inferioara a ferestrei principale\n ");
        jScrollPane4.setViewportView(jTextArea2);

        jDialogInregistrare.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 493, 149));

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });
        jDialogInregistrare.getContentPane().add(jButtonOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 112, 42));
        jDialogInregistrare.getContentPane().add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 501, 143, 36));
        jDialogInregistrare.getContentPane().add(jPas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 212, 50));

        jDialogModificare.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Nume");
        jDialogModificare.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 35, -1, -1));

        jLabel5.setText("Prenume");
        jDialogModificare.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 86, -1, -1));

        jLabel6.setText("CNP");
        jDialogModificare.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, -1, -1));

        jLabel7.setText("Telefon");
        jDialogModificare.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 207, -1, -1));
        jDialogModificare.getContentPane().add(jTextFieldNume2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 35, 147, -1));
        jDialogModificare.getContentPane().add(jTextFieldPrenume2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 83, 147, -1));
        jDialogModificare.getContentPane().add(jTextFieldCNP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 137, 147, -1));
        jDialogModificare.getContentPane().add(jTextFieldTelefon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 204, 147, -1));

        jComboBoxTip2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fix", "Mobil" }));
        jDialogModificare.getContentPane().add(jComboBoxTip2, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 203, -1, -1));

        jButonModificaModificare.setText("Modifica");
        jButonModificaModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonModificaModificareActionPerformed(evt);
            }
        });
        jDialogModificare.getContentPane().add(jButonModificaModificare, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 255, -1, -1));

        jButonIesireModificare.setText("Iesire");
        jButonIesireModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonIesireModificareActionPerformed(evt);
            }
        });
        jDialogModificare.getContentPane().add(jButonIesireModificare, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 255, -1, -1));

        jLabel8.setText("Cauta dupa ");

        jRadioButtonNume.setText("Nume");

        jRadioButtonPrenume.setText("Prenume");

        jRadioButtonCNP.setText("CNP");

        jRadioButtonTelefon.setText("Telefon");

        jLabel9.setText("Introduce secventa cautata");

        jTextFieldCautat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCautatActionPerformed(evt);
            }
        });

        jButonCautaCautare.setText("Cauta");
        jButonCautaCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonCautaCautareActionPerformed(evt);
            }
        });

        jButonIesireCautare.setText("Iesire");
        jButonIesireCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonIesireCautareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogCautareLayout = new javax.swing.GroupLayout(jDialogCautare.getContentPane());
        jDialogCautare.getContentPane().setLayout(jDialogCautareLayout);
        jDialogCautareLayout.setHorizontalGroup(
            jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCautareLayout.createSequentialGroup()
                .addGroup(jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(jRadioButtonNume))
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jRadioButtonPrenume))
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jRadioButtonCNP))
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jRadioButtonTelefon))
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogCautareLayout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(jTextFieldCautat, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButonCautaCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jButonIesireCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDialogCautareLayout.setVerticalGroup(
            jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCautareLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonNume))
                .addGap(38, 38, 38)
                .addComponent(jRadioButtonPrenume)
                .addGap(36, 36, 36)
                .addComponent(jRadioButtonCNP)
                .addGap(39, 39, 39)
                .addComponent(jRadioButtonTelefon)
                .addGap(78, 78, 78)
                .addGroup(jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogCautareLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jTextFieldCautat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jDialogCautareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButonCautaCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButonIesireCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda de contacte");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bAdaugaContact.setBackground(new java.awt.Color(255, 204, 204));
        bAdaugaContact.setText("Adauga contact");
        bAdaugaContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaContactActionPerformed(evt);
            }
        });
        jPanel1.add(bAdaugaContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 484, -1, -1));

        bStergeContact.setBackground(new java.awt.Color(255, 204, 204));
        bStergeContact.setText("Sterge contact selectat");
        bStergeContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergeContactActionPerformed(evt);
            }
        });
        jPanel1.add(bStergeContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 484, -1, -1));

        bEditareContact.setBackground(new java.awt.Color(255, 204, 204));
        bEditareContact.setText("Editeaza contact selectat");
        bEditareContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditareContactActionPerformed(evt);
            }
        });
        jPanel1.add(bEditareContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 484, 230, -1));

        jTableAgenda.setAutoCreateRowSorter(true);
        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nr crt", "Nume", "Prenume", "CNP", "Telefon"
            }
        ));
        jTableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMouseClicked(evt);
            }
        });
        jTableAgenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableAgendaKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(jTableAgenda);
        //this.jTabelAgenda.setAutoCreateRowSorter(true);
        //this.jTabelAgenda.setToolTipText("Lista contacte");

        jPanel1.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 980, 262));

        jLabelRezultateleCautarii.setText("Rezultatele cautarii");
        jPanel1.add(jLabelRezultateleCautarii, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 57, -1, -1));
        jPanel1.add(jLabelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 558, 869, 131));

        jButonCauta.setBackground(new java.awt.Color(255, 204, 204));
        jButonCauta.setText("Cauta");
        jButonCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonCautaActionPerformed(evt);
            }
        });
        jPanel1.add(jButonCauta, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 484, 212, -1));

        jLabelInfo.setText("Lista contacte");
        jPanel1.add(jLabelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 127, 132, -1));

        jButonRevenire.setBackground(new java.awt.Color(255, 204, 204));
        jButonRevenire.setText("Revenire lista completa");
        jButonRevenire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonRevenireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButonRevenire, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButonRevenire)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 86, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Inregistrare");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 270, 30));

        jMenuBar.setBackground(new java.awt.Color(255, 204, 204));

        jMenuAfisare.setText("Fisiere");

        jOpen.setText("Deschidere");
        jOpen.setEnabled(false);
        jOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOpenActionPerformed(evt);
            }
        });
        jMenuAfisare.add(jOpen);

        jSave.setText("Salvare");
        jSave.setEnabled(false);
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });
        jMenuAfisare.add(jSave);

        jIesire.setText("Iesire");
        jIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIesireActionPerformed(evt);
            }
        });
        jMenuAfisare.add(jIesire);

        jMenuBar.add(jMenuAfisare);

        jMenuAjutor.setText("Ajutor");

        jInregistrare.setText("Inregistrare");
        jInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInregistrareActionPerformed(evt);
            }
        });
        jMenuAjutor.add(jInregistrare);

        jDespre.setText("Despre");
        jDespre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDespreActionPerformed(evt);
            }
        });
        jMenuAjutor.add(jDespre);

        jMenuBar.add(jMenuAjutor);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void bAdaugaContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaContactActionPerformed
        jDialogAdaugare.setTitle("Adaugare abonat");
        jDialogAdaugare.setModal(true);
        jDialogAdaugare.pack();
        jDialogAdaugare.setLocationRelativeTo(null);
        jDialogAdaugare.setVisible(true);

    }//GEN-LAST:event_bAdaugaContactActionPerformed


    private void bAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaActionPerformed
              
        
        Matcher mNume = Constante.PATTERN_NUME.matcher(this.tfNume.getText());
        Matcher mPrenume = Constante.PATTERN_PRENUME.matcher(this.tfPrenume.getText());
        Matcher mCNP = Constante.PATTERN_CNP.matcher(this.tfCNP.getText());
        Matcher mTelefon = Constante.PATTERN_TELEFON_MOBIL.matcher(this.tfTelefon.getText());

        if (this.jComboBoxTip1.getSelectedItem() == "Fix") {
            mTelefon = Constante.PATTERN_TELEFON_FIX.matcher(this.tfTelefon.getText());
        }
        boolean m1 = mNume.matches();
        boolean m2 = mPrenume.matches();
        boolean m3 = mCNP.matches();
        boolean m4 = mTelefon.matches();
        if (m1 == true) {
            if (m2 == true) {
                if (m3 == true) {
                    if (m4 == true) {
                                Contact ct = new Contact(this.tfNume.getText(),
                                this.tfPrenume.getText(),
                                this.tfCNP.getText(),
                                new NrTel(this.tfTelefon.getText(), (String) this.jComboBoxTip1.getSelectedItem()));

                        ListIterator iterator2 = this.agenda.listIterator();
                        boolean mai_este = false;
                        while (iterator2.hasNext()) {
                            if (((Contact) iterator2.next()).equals(ct)) {
                                mai_este = true;
                            }
                        }
                        if (mai_este) {
                            JOptionPane.showMessageDialog(this.jDialogAdaugare, "Contact deja existent in agenda!");
                        } else {
                            this.agenda.add(ct);
                            jButonRevenire.setVisible(false);
                            jLabelInfo.setText("Lista contacte:");
                            populareTabel(this.agenda);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this.jDialogAdaugare, "Numar de telefon incorect!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.jDialogAdaugare, "CNP incorect!");
                }

            } else {
                JOptionPane.showMessageDialog(this.jDialogAdaugare, "Prenume incorect!");
            }
        } else {
            JOptionPane.showMessageDialog(this.jDialogAdaugare, "Nume incorect!");
        }

    }//GEN-LAST:event_bAdaugaActionPerformed


    private void bIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIesireActionPerformed

        this.jDialogAdaugare.dispose();
    }//GEN-LAST:event_bIesireActionPerformed

    private void jOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOpenActionPerformed

        JFileChooser fc = new JFileChooser();
        int rezultat = fc.showOpenDialog(this);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fc.getSelectedFile()));
            try {
                this.agenda = ((CarteDeTelefon) ois.readObject());
                ois.close();
                this.jButonRevenire.setVisible(false);

                this.jLabelInfo.setText("Lista contacte:");
                populareTabel(this.agenda);
            } catch (ClassNotFoundException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Fisier invalid!", "Eroare 1", 0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Fisier invalid!", "Eroare 2", 0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fisier invalid!", "Eroare 3", 0);
        }


    }//GEN-LAST:event_jOpenActionPerformed

    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed
        JFileChooser fc = new JFileChooser();
        int rezultat = fc.showSaveDialog(this);
        FileOutputStream fos = null;
        if (rezultat == 0) {
            try {
                fos = new FileOutputStream(fc.getSelectedFile());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Fisier invalid!", "Eroare", 0);
            }
            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.agenda);
                oos.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Eroare de scriere!", "Eroare", 0);
            }
        }


    }//GEN-LAST:event_jSaveActionPerformed

    private void jIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIesireActionPerformed
        int reply = JOptionPane.showConfirmDialog(GUI.this,
                "Doriti sa iesiti din aplicatie?",
                "Iesire",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            return;
        }
    }//GEN-LAST:event_jIesireActionPerformed

    private void jDespreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDespreActionPerformed

        JOptionPane.showMessageDialog(null, " Agenda administrare contacte  \n IDE folosit: NetBeans 8.2", "Despre", 1);

    }//GEN-LAST:event_jDespreActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jTableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMouseClicked

        if (evt.getClickCount() == 2) {
            this.randSelectat = jTableAgenda.getSelectedRow();
            if (this.randSelectat == -1) {
                JOptionPane.showMessageDialog(this, "Nu ati selectat niciun contact!");
            } else {
                try {
                    Contact un_contact = getContactSelectat();
                    this.jTextFieldNume2.setText(un_contact.getNume());
                    if ((un_contact.getNume() == null) && (un_contact.getNume().length() <= 2)) {

                    }
                    this.jTextFieldPrenume2.setText(un_contact.getPrenume());
                    if ((un_contact.getPrenume() == null) && (un_contact.getPrenume().length() <= 2)) {

                    }
                    this.jTextFieldCNP2.setText(un_contact.getCNP());
                    this.jTextFieldTelefon2.setText(un_contact.getTelefon().numar);
                    this.jComboBoxTip2.setSelectedItem(un_contact.getTelefon().tip);
                } catch (Exception ex) {
                    throw new IllegalArgumentException("Nume invalid");
                }
                this.jDialogModificare.pack();
                this.jDialogModificare.setLocationRelativeTo(this);
                this.jDialogModificare.setVisible(true);

            }
        }
    }//GEN-LAST:event_jTableAgendaMouseClicked

    private void jTableAgendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableAgendaKeyPressed
        if (evt.getKeyCode() == 127) {
            randSelectat = jTableAgenda.getSelectedRow();
            if (randSelectat == -1) {
                JOptionPane.showMessageDialog(this, "Nu ati selectat contact!");
            } else if (JOptionPane.showConfirmDialog(this, "Doriti sa stergeti contactul?", "Confirmare stergere", 0, 3) == 0) {

                
                    Contact contact_de_sters = getContactSelectat();

                    ListIterator iterator5 = agenda.listIterator();
                    while (iterator5.hasNext()) {
                        if (((Contact) iterator5.next()).equals(contact_de_sters)) {
                            iterator5.remove();
                        }
                    }
                
                jButonRevenire.setVisible(false);

                jLabelInfo.setText("Lista contacte");
                populareTabel(agenda);

            }
        }
    }//GEN-LAST:event_jTableAgendaKeyPressed

    @SuppressWarnings("unchecked")
    private void jButonModificaModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonModificaModificareActionPerformed
        Matcher mNume = Constante.PATTERN_NUME.matcher(this.jTextFieldNume2.getText());
        Matcher mPrenume = Constante.PATTERN_PRENUME.matcher(this.jTextFieldPrenume2.getText());
        Matcher mCNP = Constante.PATTERN_CNP.matcher(this.jTextFieldCNP2.getText());
        Matcher mTelefon = Constante.PATTERN_TELEFON_MOBIL.matcher(this.jTextFieldTelefon2.getText());
        if (this.jComboBoxTip2.getSelectedItem() == "Fix") {
            mTelefon = Constante.PATTERN_TELEFON_FIX.matcher(this.jTextFieldTelefon2.getText());
        }
        boolean m1 = mNume.matches();
        boolean m2 = mPrenume.matches();
        boolean m3 = mCNP.matches();
        boolean m4 = mTelefon.matches();
        if (m1 == true) {
            if (m2 == true) {
                if (m3 == true) {
                    if (m4 == true) {
                        ListIterator iterator4 = this.agenda.listIterator();
                        while (iterator4.hasNext()) {
                            
                                if (((Contact) iterator4.next()).equals(getContactSelectat())) {
                                 Contact ct = new Contact(this.jTextFieldNume2.getText(), jTextFieldPrenume2.getText(), jTextFieldCNP2.getText(), new NrTel(jTextFieldTelefon2.getText(), (String) jComboBoxTip2.getSelectedItem()));
                                    iterator4.set(ct);
                               
                        }
                        }
                        jButonRevenire.setVisible(false);
                        jLabelInfo.setText("Lista contacte");
                        populareTabel(agenda);
                        jDialogModificare.dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(jDialogModificare, "Numar de telefon incorect!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.jDialogModificare, "CNP incorect!");
                }
            } else {
                JOptionPane.showMessageDialog(jDialogModificare, "Prenume incorect!");
            }
        } else {
            JOptionPane.showMessageDialog(jDialogModificare, "Nume incorect!");
        }
    }//GEN-LAST:event_jButonModificaModificareActionPerformed

    private void jButonCautaCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonCautaCautareActionPerformed
        ArrayList listaRezultate = new ArrayList();
        if (jTextFieldCautat.getText().length() == 0) {
            JOptionPane.showMessageDialog(this.jDialogCautare, "Filtrare dupa: ");
        } else {
            String criteriu;
            if (jRadioButtonNume.isSelected()) {
                criteriu = "Nume";
            } else {
                if (jRadioButtonPrenume.isSelected()) {
                    criteriu = "Prenume";
                } else {
                    if (jRadioButtonCNP.isSelected()) {
                        criteriu = "CNP";
                    } else {
                        criteriu = "Telefon";
                    }
                }
            }
            ListIterator iterator3 = this.agenda.listIterator();
            while (iterator3.hasNext()) {
                Contact ct = (Contact) iterator3.next();
                if ((criteriu == "Nume")
                        && (ct.getNume().contains(this.jTextFieldCautat.getText()))) {
                    listaRezultate.add(ct);
                }
                if ((criteriu == "Prenume")
                        && (ct.getPrenume().contains(this.jTextFieldCautat.getText()))) {
                    listaRezultate.add(ct);
                }
                if ((criteriu == "CNP")
                        && (ct.getCNP().contains(this.jTextFieldCautat.getText()))) {
                    listaRezultate.add(ct);
                }
                if ((criteriu == "Telefon")
                        && (ct.getTelefon().numar.contains(this.jTextFieldCautat.getText()))) {
                    listaRezultate.add(ct);
                }
            }
            if (listaRezultate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nici un rezultat");
            } else {
                jLabelInfo.setText("Rezultatele cautarii:");

                jButonRevenire.setVisible(true);
                populareTabel(listaRezultate);
                jDialogCautare.dispose();
            }
        }
    }//GEN-LAST:event_jButonCautaCautareActionPerformed

    private void jButonIesireCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonIesireCautareActionPerformed
        this.jDialogCautare.dispose();
    }//GEN-LAST:event_jButonIesireCautareActionPerformed

    private void bStergeContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStergeContactActionPerformed
        randSelectat = jTableAgenda.getSelectedRow();
        if (randSelectat == -1) {
            JOptionPane.showMessageDialog(this, "Nu ati selectat contact de sters!");
        } else if (JOptionPane.showConfirmDialog(this, "Doriti sa stergeti acest contact?", "Confirmare stergere", 0, 3) == 0) {

            try {
                Contact contact_de_sters = getContactSelectat();
                ListIterator iterator5 = this.agenda.listIterator();
                while (iterator5.hasNext()) {
                    if (((Contact) iterator5.next()).equals(contact_de_sters)) {
                        iterator5.remove();
                    }
                }

            } catch (Exception ex) {
                throw new IllegalArgumentException("Contact invalid");
            }
            jButonRevenire.setVisible(false);
            jLabelInfo.setText("Lista abonati");
            populareTabel(this.agenda);
        }
    }//GEN-LAST:event_bStergeContactActionPerformed

    private void jButonCautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonCautaActionPerformed
        this.jDialogCautare.pack();
        this.jDialogCautare.setLocationRelativeTo(this);
        this.jDialogCautare.setVisible(true);
    }//GEN-LAST:event_jButonCautaActionPerformed

    private void bEditareContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditareContactActionPerformed
        this.randSelectat = this.jTableAgenda.getSelectedRow();
        if (randSelectat == -1) {
            JOptionPane.showMessageDialog(this, "Nu ati selectat niciun contact!");
        } else {

            try {
                Contact un_contact = getContactSelectat();

                jTextFieldNume2.setText(un_contact.getNume());
                jTextFieldPrenume2.setText(un_contact.getPrenume());
                jTextFieldCNP2.setText(un_contact.getCNP());
                jTextFieldTelefon2.setText(un_contact.getTelefon().numar);
                jComboBoxTip2.setSelectedItem(un_contact.getTelefon().tip);
            } catch (Exception ex) {
                throw new IllegalArgumentException("Contact invalid");
            }
            jDialogModificare.pack();
            jDialogModificare.setLocationRelativeTo(this);
            jDialogModificare.setVisible(true);
        }
    }//GEN-LAST:event_bEditareContactActionPerformed

    private void jButonIesireModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonIesireModificareActionPerformed
        this.jDialogModificare.dispose();
    }//GEN-LAST:event_jButonIesireModificareActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        this.jDialogInregistrare.dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButonActivareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonActivareActionPerformed

        char[] input = this.jPas.getPassword();
        if (codOk(input)) {
            setShareware(false);
            jLabelStatus.setText("Ok inregistrare!");
            jButonActivare.setEnabled(false);
            jOpen.setEnabled(true);
            jSave.setEnabled(true);
            jInregistrare.setEnabled(false);
            jLabelBanner.setVisible(false);
        } else {
            jLabelStatus.setText("Cod gresit");
        }
    }//GEN-LAST:event_jButonActivareActionPerformed

    private void jInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInregistrareActionPerformed
        jDialogInregistrare.pack();
        jDialogInregistrare.setLocationRelativeTo(this);
        jDialogInregistrare.setVisible(true);
    }//GEN-LAST:event_jInregistrareActionPerformed

    private void jTextFieldCautatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCautatActionPerformed

    }//GEN-LAST:event_jTextFieldCautatActionPerformed

    private void jButonRevenireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonRevenireActionPerformed
        this.jButonRevenire.setVisible(false);
        this.jLabelInfo.setText("Lista contacte:");
        populareTabel(this.agenda);
    }//GEN-LAST:event_jButonRevenireActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jInregistrareActionPerformed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean codOk(char[] input) {
        boolean isCorrect = true;
        if (input.length != Constante.COD_CORECT.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals(input, Constante.COD_CORECT);
        }
        return isCorrect;
    }

    public static void main(String args[]) {

        JFrame f = new JFrame("Agenda de contacte");

        f.setTitle("Agenda de contacte");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.pack();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            CarteDeTelefon agenda = new CarteDeTelefon();
            GUI gui = new GUI(agenda);
            Splash s = new Splash("poze/contactmanagement.jpg", gui, 4000);
            //s.setVisible(true);
        });

    }

    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdauga;
    private javax.swing.JButton bAdaugaContact;
    private javax.swing.JButton bEditareContact;
    private javax.swing.JButton bIesire;
    private javax.swing.JButton bStergeContact;
    private javax.swing.JFileChooser fc;
    private javax.swing.JButton jButonActivare;
    private javax.swing.JButton jButonCauta;
    private javax.swing.JButton jButonCautaCautare;
    private javax.swing.JButton jButonIesireCautare;
    private javax.swing.JButton jButonIesireModificare;
    private javax.swing.JButton jButonModificaModificare;
    private javax.swing.JButton jButonRevenire;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jCNP;
    private javax.swing.JComboBox<String> jComboBoxTip1;
    private javax.swing.JComboBox<String> jComboBoxTip2;
    private javax.swing.JMenuItem jDespre;
    private javax.swing.JDialog jDialogAdaugare;
    private javax.swing.JDialog jDialogCautare;
    private javax.swing.JDialog jDialogInregistrare;
    private javax.swing.JDialog jDialogModificare;
    private javax.swing.JMenuItem jIesire;
    private javax.swing.JMenuItem jInregistrare;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBanner;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelRezultateleCautarii;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JMenu jMenuAfisare;
    private javax.swing.JMenu jMenuAjutor;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JLabel jNrTelefon;
    private javax.swing.JLabel jNume;
    private javax.swing.JMenuItem jOpen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPas;
    private javax.swing.JLabel jPrenume;
    private javax.swing.JRadioButton jRadioButtonCNP;
    private javax.swing.JRadioButton jRadioButtonNume;
    private javax.swing.JRadioButton jRadioButtonPrenume;
    private javax.swing.JRadioButton jRadioButtonTelefon;
    private javax.swing.JMenuItem jSave;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAgenda;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldCNP2;
    private javax.swing.JTextField jTextFieldCautat;
    private javax.swing.JTextField jTextFieldNume2;
    private javax.swing.JTextField jTextFieldPrenume2;
    private javax.swing.JTextField jTextFieldTelefon2;
    private javax.swing.JTextField tfCNP;
    private javax.swing.JTextField tfNume;
    private javax.swing.JTextField tfPrenume;
    private javax.swing.JTextField tfTelefon;
    // End of variables declaration//GEN-END:variables

}
