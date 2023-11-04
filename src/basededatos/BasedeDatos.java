/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

/*
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aitor García Curado
 */
public class BasedeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marco m = new Marco();

    }

}

class Marco extends JFrame implements ActionListener {

    private JPanel paneltdepto;
    private JPanel panelfoto;
    private JPanel paneltemple;
    private JPanel paneltcentr;
    private JPanel panelmostrar;
    private JTabbedPane pestanas;

    JButton botonInsertar = new JButton("Insertar");
    JButton botonMod = new JButton("Modificar");
    JButton botonBorr = new JButton("Borrar");

    JButton botonInsertardepto = new JButton("Insertar");
    JButton botonModdepto = new JButton("Modificar");
    JButton botonBorrdepto = new JButton("Borrar");

    JButton botonInsertarcentr = new JButton("Insertar");
    JButton botonModcentr = new JButton("Modificar");
    JButton botonBorrcentr = new JButton("Borrar");

    JLabel leyenda1 = new JLabel("NOTA: La fecha debe introducirse con el siguiente formato: año-mes-día 00:00:00");
    JLabel leyenda2 = new JLabel("NOTA : El tipo de director solo puede ser P o F                                       ");

    JLabel labelnumce2 = new JLabel("Número Centro");
    JTextField numce2 = new JTextField(20);

    JLabel labelnomce = new JLabel("Nombre Centro");
    JTextField nomce = new JTextField(20);

    JLabel labeldirce = new JLabel("Dirección Centro");
    JTextField dirce = new JTextField(20);

    JLabel labelnumem = new JLabel("Número Empleado");
    JTextField numem = new JTextField(20);

    JLabel labelnumde = new JLabel("Numero departamento");
    JTextField numde = new JTextField(20);

    JLabel labelnumde2 = new JLabel("Numero departamento");
    JTextField numde2 = new JTextField(20);

    JLabel labelnomem = new JLabel("Nombre Empleado");
    JTextField nomem = new JTextField(20);

    JLabel labelfecna = new JLabel("Fecha Nacimiento");
    JTextField fecna = new JTextField(20);

    JLabel labelfecin = new JLabel("Fecha Entrada");
    JTextField fecin = new JTextField(20);

    JLabel labelextel = new JLabel("Telefono");
    JTextField extel = new JTextField(20);

    JLabel labelsalar = new JLabel("Salario");
    JTextField salar = new JTextField(20);

    JLabel labelcomis = new JLabel("Comision");
    JTextField comis = new JTextField(20);

    JLabel labelnumhi = new JLabel("Numero Hijos");
    JTextField numhi = new JTextField(20);

    JLabel labelnumce = new JLabel("Numero Centro");
    JTextField numce = new JTextField(20);

    JLabel labeldirec = new JLabel("Numero Director");
    JTextField direc = new JTextField(20);

    JLabel labeltidir = new JLabel("Tipo Director");
    JTextField tidir = new JTextField(20);

    JLabel labelpresu = new JLabel("Presupuesto");
    JTextField presu = new JTextField(20);

    JLabel labeldepde = new JLabel("Depende De");
    JTextField depde = new JTextField(20);

    JLabel labelnomde = new JLabel("Nombre Departamento");
    JTextField nomde = new JTextField(20);

    public Marco() {

        try {
      // Establecer el estilo Nimbus
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException |
             IllegalAccessException | UnsupportedLookAndFeelException e) {
      // Manejar cualquier excepción
      e.printStackTrace();
    }
     

        paneltdepto = new JPanel();
        panelfoto = new JPanel();
        panelmostrar = new JPanel();
        paneltemple = new JPanel();
        paneltcentr = new JPanel();
        pestanas = new JTabbedPane();
        pestanas.addTab("Tabla Empleados", paneltemple);
        pestanas.addTab("Tabla Departamentos", paneltdepto);
        pestanas.addTab("Tabla Centros", paneltcentr);
        pestanas.addTab("Mostrar tablas", panelmostrar);
        pestanas.addTab("Modelo Relacional", panelfoto);
        add(pestanas);
        // Establecer el tamaño del marco
        setSize(650, 550);
        setResizable(false);
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcular la posición del marco en el centro de la pantalla
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establecer la posición del marco
        setLocation(x, y);

        //CREACION PANEL RELACIONAL
        ImageIcon imagen = new ImageIcon("Captura.PNG");
        Image imagenEscalada = imagen.getImage().getScaledInstance(645, 500, Image.SCALE_SMOOTH);
        ImageIcon imagenNueva = new ImageIcon(imagenEscalada);
        JLabel etiquetaImagen = new JLabel(imagenNueva);

        panelfoto.add(etiquetaImagen);

        //CREACION DE LA PESTAÑA TEMPLE
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panelL = new JPanel();
        paneltemple.add(panel1, BorderLayout.NORTH);
        paneltemple.add(panel2, BorderLayout.CENTER);
        paneltemple.add(panelL, BorderLayout.SOUTH);

        // Agregar etiquetas y campos de texto al panel de empleados
        panel1.add(labelnumem);
        panel1.add(numem);
        panel1.add(labelnumde);
        panel1.add(numde);
        panel1.add(labelnomem);
        panel1.add(nomem);
        panel1.add(labelfecna);
        panel1.add(fecna);
        panel1.add(labelfecin);
        panel1.add(fecin);
        panel1.add(labelextel);
        panel1.add(extel);
        panel1.add(labelsalar);
        panel1.add(salar);
        panel1.add(labelcomis);
        panel1.add(comis);
        panel1.add(labelnumhi);
        panel1.add(numhi);
        panel1.setLayout(new GridLayout(9, 2));

        panel2.add(botonInsertar);
        panel2.add(botonMod);
        panel2.add(botonBorr);
        panelL.add(leyenda1);
        panel1.setBorder(new EmptyBorder(5, 20, 20, 20));
        panel2.setBorder(new EmptyBorder(5, 20, 20, 20));

        botonInsertar.addActionListener(this);
        botonMod.addActionListener(this);
        botonBorr.addActionListener(this);

        //CREACION DE LA PESTAÑA TDEPTO
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panelL2 = new JPanel();
        paneltdepto.add(panel3, BorderLayout.NORTH);
        paneltdepto.add(panel4, BorderLayout.CENTER);
        paneltdepto.add(panelL2, BorderLayout.SOUTH);

        panel3.add(labelnumde2);
        panel3.add(numde2);
        panel3.add(labelnumce);
        panel3.add(numce);
        panel3.add(labeldirec);
        panel3.add(direc);
        panel3.add(labeltidir);
        panel3.add(tidir);
        panel3.add(labelpresu);
        panel3.add(presu);
        panel3.add(labeldepde);
        panel3.add(depde);
        panel3.add(labelnomde);
        panel3.add(nomde);

        panel3.setLayout(new GridLayout(7, 2));
        panel4.add(botonInsertardepto);

        panel4.add(botonModdepto);

        panel4.add(botonBorrdepto);
        panelL2.add(leyenda2);
        panel3.setBorder(new EmptyBorder(5, 20, 20, 20));
        panel4.setBorder(new EmptyBorder(5, 20, 20, 20));

        botonInsertardepto.addActionListener(this);
        botonModdepto.addActionListener(this);
        botonBorrdepto.addActionListener(this);

        //CREACION DE LA PESTAÑA TCENTR
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        paneltcentr.add(panel5, BorderLayout.NORTH);
        paneltcentr.add(panel6, BorderLayout.CENTER);

        panel5.add(labelnumce2);
        panel5.add(numce2);
        panel5.add(labelnomce);
        panel5.add(nomce);
        panel5.add(labeldirce);
        panel5.add(dirce);

        panel5.setLayout(new GridLayout(3, 2));
        panel6.add(botonInsertarcentr);
        panel6.add(botonModcentr);
        panel6.add(botonBorrcentr);

        panel5.setBorder(new EmptyBorder(5, 20, 20, 20));
        panel6.setBorder(new EmptyBorder(5, 20, 20, 20));

        botonInsertarcentr.addActionListener(this);
        botonModcentr.addActionListener(this);
        botonBorrcentr.addActionListener(this);

        //CREANDO EL PANEL MOSTRARTABLAS
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();

        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panel11 = new JPanel();
        panelmostrar.add(panel7);
        JComboBox<String> opcionesMostrar = new JComboBox<String>();//boton con varias opciones
        opcionesMostrar.addItem("Empleados");
        opcionesMostrar.addItem("Departamentos");
        opcionesMostrar.addItem("Centros");
        //panel7.setLayout(new FlowLayout());

        panel7.add(opcionesMostrar);
        //creacion de las filas y columnas
        String[] columnas = {"Número Empleado", "Número Departamento", "Fecha Nacimiento", "Fecha Entrada", "Teléfono", "Salario", "Comisión", "Número Hijos", "Nombre Empleado"};
        Object[][] datos = {};

        String[] columnas2 = {"Número Departamento", "Número Centro", "Director", "Tipo Director", "Presupuesto", "Depende de", "Nombre Departamento"};
        Object[][] datos2 = {};

        String[] columnas3 = {"Número Centro", "Nombre Centro", "Dirección"};
        Object[][] datos3 = {};
        
        //Creacion de las tablas usando las filas y columnas anteriores
        JTable tablaEmpleados = new JTable(new DefaultTableModel(datos, columnas));
        JTable tablaDepartamento = new JTable(new DefaultTableModel(datos2, columnas2));
        JTable tablaCentros = new JTable(new DefaultTableModel(datos3, columnas3));
        //se añaden las tablas al scrollpane para poder bajar cuando esta sea mayor de lo que se puede mostrar
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        JScrollPane scrollPanedepto = new JScrollPane(tablaDepartamento);
        JScrollPane scrollPanecentr = new JScrollPane(tablaCentros);
        //añadimos los scrollpane
        panel9.add(scrollPane);
        panel10.add(scrollPanedepto);
        panel11.add(scrollPanecentr);
        panel7.add(panel8, BorderLayout.NORTH);
        panel7.add(panel9, BorderLayout.SOUTH);
        panel7.add(panel10, BorderLayout.SOUTH);
        panel7.add(panel11, BorderLayout.SOUTH);
        panel10.setVisible(false);
        panel11.setVisible(false);

        //accion para las distintas opciones
        opcionesMostrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) opcionesMostrar.getSelectedItem();
                switch (opcionSeleccionada) {
                    case "Departamentos":
                try {
                        Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");//conecta con la base de datos trascortarde

                        Statement stmt = cn.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM tdepto");//realiza un select a toda la tabla para mostrarla

                        // Recorrer los registros y agregarlos a la tabla
                        DefaultTableModel model = (DefaultTableModel) tablaDepartamento.getModel();
                        model.setRowCount(0);
                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getInt("numde"), rs.getInt("numce"), rs.getInt("direc"), rs.getString("tidir"), rs.getDouble("presu"), rs.getInt("depde"), rs.getString("nomde")});
                        }
                        //se hace visible el panel que se vaya a usar
                        panel9.setVisible(false);
                        panel11.setVisible(false);
                        panel10.setVisible(true);

                    } catch (Exception i) {
                        System.out.println(i);
                    }
                    break;
                    case "Empleados":
                try {
                        Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                        Statement stmt = cn.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM temple");

                        // Recorrer los registros y agregarlos a la tabla
                        DefaultTableModel model = (DefaultTableModel) tablaEmpleados.getModel();
                        model.setRowCount(0);
                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getInt("numem"), rs.getInt("numde"), rs.getInt("extel"), rs.getString("fecna"), rs.getString("fecin"), rs.getDouble("salar"), rs.getDouble("comis"), rs.getInt("numhi"), rs.getString("nomem")});
                        }
                        panel10.setVisible(false);
                        panel11.setVisible(false);
                        panel9.setVisible(true);

                    } catch (Exception i) {
                        System.out.println(i);
                    }
                    break;
                    case "Centros":
                try {
                        Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                        Statement stmt = cn.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM tcentr");

                        // Recorrer los registros y agregarlos a la tabla
                        DefaultTableModel model = (DefaultTableModel) tablaCentros.getModel();
                        model.setRowCount(0);
                        while (rs.next()) {
                            model.addRow(new Object[]{rs.getInt("numce"), rs.getString("nomce"), rs.getString("dirce")});
                        }
                        panel10.setVisible(false);
                        panel9.setVisible(false);
                        panel11.setVisible(true);

                    } catch (Exception i) {
                        System.out.println(i);
                    }
                    break;
                }
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //INSERTAR DE TEMPLE
        if (source == botonInsertar) {

            try {
                Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");
                //PreparedStatement pst = (PreparedStatement) cn.prepareStatement("insert into trascortarde.temple values(?,?,?,?,?,?,?,?,?)");
                Statement prueba = cn.createStatement();
                String query = "insert into temple values(" + numem.getText().trim() + "," + numde.getText().trim() + "," + extel.getText().trim() + ",'" + fecna.getText().trim() + "','" + fecin.getText().trim() + "'," + salar.getText().trim() + "," + comis.getText().trim() + "," + numhi.getText().trim() + ",'" + nomem.getText().trim() + "')";

                numem.setText("");
                numde.setText("");
                extel.setText("");
                fecna.setText("");
                fecin.setText("");
                salar.setText("");
                comis.setText("");
                numhi.setText("");
                nomem.setText("");

                prueba.executeQuery(query);
                cn.close();
                prueba.close();
            } catch (Exception i) {
                JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

            }
            //MODIFICAR DE TEMPLE
        } else if (source == botonMod) {

            try {
                Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                Statement prueba = cn.createStatement();
                String query = "update temple set numde=" + numde.getText().trim() + ",extel=" + extel.getText().trim() + ",fecna='" + fecna.getText().trim() + "',fecin='" + fecin.getText().trim() + "',salar=" + salar.getText().trim() + ",comis=" + comis.getText().trim() + ",numhi=" + numhi.getText().trim() + ",nomem='" + nomem.getText().trim() + "' where numem=" + numem.getText().trim();

                numem.setText("");
                numde.setText("");
                extel.setText("");
                fecna.setText("");
                fecin.setText("");
                salar.setText("");
                comis.setText("");
                numhi.setText("");
                nomem.setText("");

                prueba.executeQuery(query);
                cn.close();
                prueba.close();
            } catch (Exception i) {
                JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

            }
            //BORRAR DE TEMPLE
        } else if (source == botonBorr) {

            if (!numem.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where numem=" + numem.getText().trim();

                    numem.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!numde.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where numde=" + numde.getText().trim();

                    numde.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!extel.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where extel=" + extel.getText().trim();

                    extel.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }

            } else if (!salar.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where salar=" + salar.getText().trim();

                    salar.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!nomem.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where nomem=" + "'" + nomem.getText().trim() + "'";

                    nomem.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }

            } else if (!fecin.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where fecin=" + "'" + fecin.getText().trim() + "'";

                    fecin.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!fecna.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where fecna=" + "'" + fecna.getText().trim() + "'";

                    fecna.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!comis.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where comis=" + comis.getText().trim();

                    comis.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!numhi.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from temple where numhi=" + numhi.getText().trim();

                    numhi.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }

            }
            //INSERTAR DE DEPTO
        } else if (source == botonInsertardepto) {

            try {
                Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                Statement prueba = cn.createStatement();
                String query = "insert into tdepto values(" + numde2.getText().trim() + "," + numce.getText().trim() + "," + direc.getText().trim() + ",'" + tidir.getText().trim() + "'," + presu.getText().trim() + "," + depde.getText().trim() + ",'" + nomde.getText().trim() + "')";

                numde2.setText("");
                numce.setText("");
                direc.setText("");
                tidir.setText("");
                presu.setText("");
                depde.setText("");
                nomde.setText("");

                prueba.executeQuery(query);
                cn.close();
                prueba.close();
            } catch (Exception i) {
                JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

            }
            //MODIFICAR TDEPTO
        } else if (source == botonModdepto) {

            try {
                Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                Statement prueba = cn.createStatement();
                String query = "update tdepto set numce=" + numce.getText().trim() + ",direc=" + direc.getText().trim() + ",tidir='" + tidir.getText().trim() + "',presu=" + presu.getText().trim() + ",depde=" + depde.getText().trim() + ",nomde='" + nomde.getText().trim() + "' where numde=" + numde2.getText().trim();

                numde2.setText("");
                numce.setText("");
                direc.setText("");
                tidir.setText("");
                presu.setText("");
                depde.setText("");
                nomde.setText("");

                prueba.executeQuery(query);
                cn.close();
                prueba.close();
            } catch (Exception i) {
                JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

            }
            //BORRAR TDEPTO
        } else if (source == botonBorrdepto) {

            if (!numde2.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where numde=" + numde2.getText().trim();

                    numde2.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!numce.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where numce=" + numce.getText().trim();

                    numce.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!direc.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where direc=" + direc.getText().trim();

                    direc.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!tidir.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where tidir='" + numce.getText().trim() + "'";

                    tidir.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!presu.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where presu=" + presu.getText().trim();

                    presu.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!depde.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where depde=" + depde.getText().trim();

                    depde.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!nomde.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tdepto where nomde='" + nomde.getText().trim() + "'";

                    nomde.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            }
            //INSERTAR TCENTR
        } else if (source == botonInsertarcentr) {

            try {
                Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                Statement prueba = cn.createStatement();
                String query = "insert into tcentr values(" + numce2.getText().trim() + ",'" + nomce.getText().trim() + "','" + dirce.getText().trim() + "')";

                numce2.setText("");
                nomce.setText("");
                dirce.setText("");

                prueba.executeQuery(query);
                cn.close();
                prueba.close();
            } catch (Exception i) {
                JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

            }
            //MODIFICAR TCENTR
        } else if (source == botonModcentr) {

            try {
                Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                Statement prueba = cn.createStatement();
                String query = "update tcentr set nomce='" + nomce.getText().trim() + "',dirce='" + dirce.getText().trim() + "' where numce=" + numce2.getText().trim();

                numce2.setText("");
                dirce.setText("");
                nomce.setText("");

                prueba.executeQuery(query);
                cn.close();
                prueba.close();
            } catch (Exception i) {
                JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

            }
            //BORRAR TCENTR
        } else if (source == botonBorrcentr) {

            if (!numce2.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tcentr where numce=" + numce2.getText().trim();

                    numce2.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!nomce.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tcentr where nomce='" + nomce.getText().trim() + "'";

                    nomce.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            } else if (!dirce.getText().trim().isEmpty()) {
                try {
                    Connection cn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/trascortarde", "root", "");

                    Statement prueba = cn.createStatement();
                    String query = "delete from tcentr where dirce='" + dirce.getText().trim() + "'";

                    dirce.setText("");

                    prueba.executeQuery(query);
                    cn.close();
                    prueba.close();
                } catch (Exception i) {
                    JOptionPane.showMessageDialog(null, "Error: " + i.getMessage(), "Error al insertar datos", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }

}
