/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenlab10p2_heydenalfonsoaldanavarela_22111098;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author heyde
 */
public class jJuego extends javax.swing.JFrame implements Runnable{

    private ArrayList<Personaje> per = new ArrayList<Personaje>();
    private Random rand;
    private boolean pausa = true;
    int contador = 0;
    
    
    public jJuego() {
        initComponents();
        // enabled a true
        jtree.setEnabled(true);
        
        // crear los personajes
        per.add(new Personaje('B', "Jack", 5000, 5000));
        per.add(new Personaje('M', "Ciber Errol", 30000, 500));
        
        // cargar combobox
        cargarCBCarros();
        cargarJTree();
    }

    // HILOS
    public void run()
    {
        
        while(pausa == false)
        {
            // VERIFICA SI SIGUIEN VIVOS.
            if(jpjack.getValue() <= 0)
            {
                this.hide();
                jpjack.setValue(0);
                jpciber.setValue(0);
                jfLose l = new jfLose();
                l.setVisible(true);
                // jtree.setEnabled(true);
            }
            if(jpciber.getValue() <= 0)
            {
                jpjack.setValue(0);
                jpciber.setValue(0);
                jfWin l = new jfWin();
                l.setVisible(true);
                // jtree.setEnabled(true);
            }
            // PELEAN
            if(contador == 2)
            {
                jpjack.setValue(jpjack.getValue() - Integer.parseInt(ataqueciber.getText()));
                contador = 0;
            }
            jpciber.setValue(jpciber.getValue() - Integer.parseInt(ataquejack.getText()));
            contador++;
            
            try
            {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("LABEL MURIO :(");
            }
        }
    }
    private int ataqueMalvado()
    {
        rand = new Random();
        int ataque = rand.nextInt(400) + 300;
        return ataque;
    }
    
    private int vidaMalvado()
    {
        rand = new Random();
        int vida = rand.nextInt(4000) + 1000;
        return vida;
    }
    
    private int ranAtaqueExtra()
    {
        rand = new Random();
        int ataque = rand.nextInt(Integer.parseInt(tataque.getText()));
        return ataque;
    }
    
    private int ranVidasExtra(int vida)
    {
        rand = new Random();
        int vidas = rand.nextInt(vida);
        return vidas;
    }
    
    private int ranSalto()
    {
        rand = new Random();
        int salto = rand.nextInt(100);
        return salto;
    }
    
    // recargar trenoode
    public void cargarJTree()
    {
        DefaultTreeModel tree = (DefaultTreeModel)jtree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getRoot();
        
        root.removeAllChildren();
        try(RandomAccessFile ref2 = new RandomAccessFile("carritos.cars", "rw"))
        {
            ref2.seek(0);
            while(ref2.getFilePointer() < ref2.length())
            {
                ref2.skipBytes(20);
                ref2.readDouble();
                ref2.readInt();
                
                String nombre = "";
                for (int i = 0; i < 50; i++) 
                {
                    nombre += ref2.readChar();
                }
                // carros.add(nombre);
                
                               
                root.add(new DefaultMutableTreeNode(nombre));
                System.out.println(nombre);
                
                ref2.readInt();
                ref2.readInt();
                ref2.readInt();
                ref2.readInt();
            }
            
            // llena el combobox
            // cbcarros.setModel(new DefaultComboBoxModel(carros.toArray()));
            tree.reload();
        } catch (FileNotFoundException ef) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nNo se encontró el archivo carritos.cars");
        } catch (IOException ei) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nCuidado, error en lectura y escritura de datos");
        }
    }
    
    // recargar combobox carros
    public void cargarCBCarros()
    {
        try(RandomAccessFile ref2 = new RandomAccessFile("carritos.cars", "rw"))
        {
            ref2.seek(0);
            while(ref2.getFilePointer() < ref2.length())
            {
                ref2.skipBytes(20);
                ref2.readDouble();
                ref2.readInt();
                
                String nombre = "";
                for (int i = 0; i < 50; i++) 
                {
                    nombre += ref2.readChar();
                }
                // carros.add(nombre);
                
                cbcarros.addItem(nombre);
                System.out.println(nombre);
                
                ref2.readInt();
                ref2.readInt();
                ref2.readInt();
                ref2.readInt();
            }
            
            // llena el combobox
            // cbcarros.setModel(new DefaultComboBoxModel(carros.toArray()));
            
        } catch (FileNotFoundException ef) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nNo se encontró el archivo carritos.cars");
        } catch (IOException ei) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nCuidado, error en lectura y escritura de datos");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtree = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jpjack = new javax.swing.JProgressBar();
        jpciber = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ataquejack = new javax.swing.JLabel();
        vidajack = new javax.swing.JLabel();
        vidaciber = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ataqueciber = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tnombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tvida = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tvelocidad = new javax.swing.JTextField();
        tataque = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tderrape = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        bcrear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbtipos = new javax.swing.JComboBox<>();
        cbcarros = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        beliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 48)); // NOI18N
        jLabel1.setText("J a c k   3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 51, 102), new java.awt.Color(255, 153, 153), new java.awt.Color(51, 0, 0), new java.awt.Color(102, 0, 0)), javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51))));
        jTabbedPane1.setForeground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jtree.setBackground(new java.awt.Color(0, 102, 102));
        jtree.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Carros");
        jtree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtree);

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("J a c k");

        jpjack.setBackground(new java.awt.Color(0, 255, 51));

        jpciber.setBackground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("C i b e r   E r r o l");

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setText("E M P E Z A R");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 0));
        jButton2.setText("P A U S A R");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Ataque Jack: ");

        jLabel5.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Vida restante Jack:");

        ataquejack.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        ataquejack.setForeground(new java.awt.Color(0, 153, 0));
        ataquejack.setText("- - . - -");

        vidajack.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        vidajack.setForeground(new java.awt.Color(0, 153, 0));
        vidajack.setText("- - . - -");

        vidaciber.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        vidaciber.setForeground(new java.awt.Color(153, 0, 0));
        vidaciber.setText("- - . - -");

        jLabel9.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Vida restante Ciber:");

        jLabel10.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Ataque Ciber Errol :");

        ataqueciber.setFont(new java.awt.Font("Gabriola", 1, 18)); // NOI18N
        ataqueciber.setForeground(new java.awt.Color(153, 0, 0));
        ataqueciber.setText("- - . - -");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(vidajack))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(46, 46, 46)
                                .addComponent(ataquejack)))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vidaciber))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(34, 34, 34)
                                .addComponent(ataqueciber))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jpjack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(jpciber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpjack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpciber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ataquejack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(vidajack)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ataqueciber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(vidaciber))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Juego   ", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("N o m b r e");

        tnombre.setBackground(new java.awt.Color(204, 204, 204));
        tnombre.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        tnombre.setForeground(new java.awt.Color(0, 0, 0));
        tnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        jLabel13.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("V i d a");

        tvida.setBackground(new java.awt.Color(204, 204, 204));
        tvida.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        tvida.setForeground(new java.awt.Color(0, 0, 0));
        tvida.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        jLabel14.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("V e l o c i d a d");

        tvelocidad.setBackground(new java.awt.Color(204, 204, 204));
        tvelocidad.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        tvelocidad.setForeground(new java.awt.Color(0, 0, 0));
        tvelocidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        tataque.setBackground(new java.awt.Color(204, 204, 204));
        tataque.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        tataque.setForeground(new java.awt.Color(0, 0, 0));
        tataque.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        jLabel15.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("A t a q u e");

        tderrape.setBackground(new java.awt.Color(204, 204, 204));
        tderrape.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        tderrape.setForeground(new java.awt.Color(0, 0, 0));
        tderrape.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        jLabel16.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("C a r r o  a  e l i m i n a r");

        bcrear.setBackground(new java.awt.Color(255, 153, 153));
        bcrear.setFont(new java.awt.Font("Gabriola", 0, 14)); // NOI18N
        bcrear.setForeground(new java.awt.Color(102, 0, 0));
        bcrear.setText("C R E A R");
        bcrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bcrearMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("T i p o");

        cbtipos.setBackground(new java.awt.Color(204, 204, 204));
        cbtipos.setFont(new java.awt.Font("Gabriola", 0, 14)); // NOI18N
        cbtipos.setForeground(new java.awt.Color(0, 0, 0));
        cbtipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Belico", "Ataque", "Salto", "Malvado" }));
        cbtipos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        cbcarros.setBackground(new java.awt.Color(204, 204, 204));
        cbcarros.setFont(new java.awt.Font("Gabriola", 0, 14)); // NOI18N
        cbcarros.setForeground(new java.awt.Color(51, 51, 51));
        cbcarros.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), new java.awt.Color(153, 153, 153)));

        jLabel18.setFont(new java.awt.Font("Gabriola", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("D e r r a p e");

        beliminar.setBackground(new java.awt.Color(255, 153, 153));
        beliminar.setFont(new java.awt.Font("Gabriola", 0, 14)); // NOI18N
        beliminar.setForeground(new java.awt.Color(102, 0, 0));
        beliminar.setText("E L I M I N A R");
        beliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                beliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bcrear, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tvelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tataque, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel15)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel16)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel13)))
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tvida, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                        .addComponent(tderrape, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                        .addComponent(cbtipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbcarros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(99, 99, 99))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tvida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tvelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbtipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tataque, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tderrape, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(bcrear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbcarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Carros   ", jPanel9);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     * BOTON PARA CREAR REGISTROS EN ARCHIVO BINARIO
    */
    private void bcrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcrearMouseClicked
        try(RandomAccessFile ref = new RandomAccessFile("carritos.cars", "rw"))
        {
            // --------------------------------------------------- //
            // para skip: 20 + 8 + 4 + 100 + (4x4) = 148
            // tipo (String)
            StringBuffer ab = new StringBuffer(cbtipos.getSelectedItem().toString());
            ab.setLength(10);
            ref.writeChars(ab.toString());
            // velocidad (Double)
            ref.writeDouble(Double.valueOf(tvelocidad.getText()));
            // porcentaje derrape (int)
            ref.writeInt(Integer.parseInt(tderrape.getText()));
            // nombre del carro (String)
            StringBuffer ab2 = new StringBuffer(tnombre.getText());
            ab2.setLength(50);
            ref.writeChars(ab2.toString());
            // Salto de metros extra (int)
            if(cbtipos.getSelectedItem().toString().equals("Salto"))
                ref.writeInt(ranSalto());
            else
                ref.writeInt(0);
            // ataque normal (int)
            if(cbtipos.getSelectedItem().toString().equals("Malvado"))
                ref.writeInt(ataqueMalvado());
            else
                ref.writeInt(Integer.parseInt(tataque.getText()));
            // ataque extra (int)
            if(cbtipos.getSelectedItem().toString().equals("Ataque"))
                ref.writeInt(ranAtaqueExtra());
            else
                ref.writeInt(0);
            // Vida (con todo y extra
            if(cbtipos.getSelectedItem().toString().equals("Malvado"))
                ref.writeInt(vidaMalvado());
            else if(cbtipos.getSelectedItem().toString().equals("Belico"))
                ref.writeInt(ranVidasExtra(Integer.parseInt(tvida.getText())));
            else
                ref.writeInt(0);
            
            
            JOptionPane.showMessageDialog(this, "Carro creado correctamente");
            // ----------------------------------------------------- ..
        } catch (FileNotFoundException ef) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nNo se encontró el archivo carritos.cars");
        } catch (IOException ei) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nArchivo corrupto o fallo en lectura y escritura de datos");
        }
        
        // limpiar
        tnombre.setText("");
        tvelocidad.setText("");
        tvida.setText("");
        tataque.setText("");
        tderrape.setText("");
        
        // recargar cb
        cargarCBCarros();
        cargarJTree();
    }//GEN-LAST:event_bcrearMouseClicked

    private void beliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseClicked
        // TODO add your handling code here:
        try(RandomAccessFile ref3 = new RandomAccessFile("carritos.cars", "rw"))
        {
            // --------------------------------------------------- //
            // para skip: 20 + 8 + 4 + 100 + (4x4) = 148
            // tipo (String)
            ref3.seek(0);
            long pos = 0;
            while(ref3.getFilePointer() < ref3.length())
            {
                pos = ref3.getFilePointer();
                ref3.skipBytes(20);
                ref3.readDouble();
                ref3.readInt();
                
                String nombre = "";
                for (int i = 0; i < 50; i++) 
                {
                    nombre += ref3.readChar();
                }
                
                if(nombre.equals(cbcarros.getSelectedItem().toString()))
                {
                    StringBuffer ab2 = new StringBuffer("");
                    ab2.setLength(10);
                    
                    ref3.writeChars(ab2.toString());
                    ref3.writeDouble(0);
                    ref3.writeInt(0);
                    
                    ab2.setLength(50);
                    
                    ref3.writeChars(ab2.toString());
                    ref3.writeInt(0);
                    ref3.writeInt(0);
                    ref3.writeInt(0);
                    ref3.writeInt(0);
                    JOptionPane.showMessageDialog(this, "Carro eliminado correctamente");
                    cbcarros.removeItem(nombre);
                }
                
                ref3.readInt();
                ref3.readInt();
                ref3.readInt();
                ref3.readInt();
            }
            
            // ----------------------------------------------------- ..
        } catch (FileNotFoundException ef) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nNo se encontró el archivo carritos.cars");
        } catch (IOException ei) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nArchivo corrupto o fallo en lectura y escritura de datos");
        }
        cargarJTree();
    }//GEN-LAST:event_beliminarMouseClicked

    
    private void jtreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtreeMouseClicked
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)jtree.getSelectionPath().getLastPathComponent();
       
        String elemento = root.getUserObject().toString();
        // extraer vida y ataque con el carro
        double ataque = 0; 
        double vida = 0;
        
        try(RandomAccessFile ref2 = new RandomAccessFile("carritos.cars", "rw"))
        {
            ref2.seek(0);
            long pos = 0;
            while(ref2.getFilePointer() < ref2.length())
            {
                pos = ref2.getFilePointer();
                ref2.skipBytes(20);
                ref2.readDouble();
                ref2.readInt();
                
                String nombre = "";
                for (int i = 0; i < 50; i++) 
                {
                    nombre += ref2.readChar();
                }
               
                int a1 = ref2.readInt();
                int a2 = ref2.readInt();
                int v1 = ref2.readInt();
                int v2 = ref2.readInt();
                
                if(nombre.equals(elemento))
                {
                    ataque = a1 + a2 + per.get(0).getAtaque();
                    ataquejack.setText(String.valueOf(ataque));
                    vida = v1 + v2 + per.get(0).getVida();
                    vidajack.setText(String.valueOf(vida));
                    // setea la vida de jack
                    jpjack.setMaximum((int)vida);
                    jpjack.setValue((int)vida);
                    // setea la vida del villano
                    jpciber.setMaximum((int)per.get(1).getVida());
                    jpciber.setValue((int)per.get(1).getVida());
                    break;
                }
            }
            
            // llena el combobox
            // cbcarros.setModel(new DefaultComboBoxModel(carros.toArray()));
            
        } catch (FileNotFoundException ef) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nNo se encontró el archivo carritos.cars");
        } catch (IOException ei) {
            JOptionPane.showMessageDialog(this, "ERROR:\n\nCuidado, error en lectura y escritura de datos");
        }
    }//GEN-LAST:event_jtreeMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        pausa = false;
        jtree.setEnabled(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        pausa = true;
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueciber;
    private javax.swing.JLabel ataquejack;
    private javax.swing.JButton bcrear;
    private javax.swing.JButton beliminar;
    private javax.swing.JComboBox<String> cbcarros;
    private javax.swing.JComboBox<String> cbtipos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JProgressBar jpciber;
    private javax.swing.JProgressBar jpjack;
    private javax.swing.JTree jtree;
    private javax.swing.JTextField tataque;
    private javax.swing.JTextField tderrape;
    private javax.swing.JTextField tnombre;
    private javax.swing.JTextField tvelocidad;
    private javax.swing.JTextField tvida;
    private javax.swing.JLabel vidaciber;
    private javax.swing.JLabel vidajack;
    // End of variables declaration//GEN-END:variables
}
