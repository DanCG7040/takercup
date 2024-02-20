/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gestor;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smitt
 */
public class Torneo extends javax.swing.JFrame {
    public static final String url = "jdbc:mysql://localhost:3306/real_takercup2022";
    public static final String user = "root";
    public static final String password = "admin";

    DefaultTableModel modelo;
    
    public Torneo() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("puntaje");
        modelo.addColumn("ganados");
        
        mostrarDatos();
        
    }
   public void mostrarDatos(){
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conexion = DriverManager.getConnection(url, user, password);
        String sql = "SELECT id, nombre, puntaje, ganados FROM puntaje ORDER BY puntaje DESC";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();

        // Limpiar los datos de la tabla antes de agregar nuevos
        modelo.setRowCount(0);

        while (rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int puntaje = rs.getInt("puntaje");
            int ganados = rs.getInt("ganados");

            modelo.addRow(new Object[]{id, nombre, puntaje, ganados});
        }
        jtDatos.setModel(modelo);
    } catch (SQLException ex) {
        System.out.println("Error en la conexión a la base de datos: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar recursos: " + ex.getMessage());
        }
    }
}

    public Connection getConnection(){
        Connection conexion = null;
        try {
            //Class.forName("com".mysql.jdbc.Driver);
            conexion = (Connection) DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null,"Bienvenido");
            mostrarDatos();
                    
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"error");
        }
        return conexion;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        vistaIngreso = new javax.swing.JPanel();
        consultaT = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        puntaje = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTPuntaje = new javax.swing.JTextField();
        jTid = new javax.swing.JTextField();
        conectar = new javax.swing.JButton();
        ganados = new javax.swing.JLabel();
        jTGanados = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTEliminar = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        contenedor.setBackground(new java.awt.Color(0, 0, 0));
        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vistaIngreso.setBackground((new Color (255,255,255,1)));

        consultaT.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        consultaT.setForeground(new java.awt.Color(255, 255, 255));
        consultaT.setText("Consulta Real_Takercup");

        id.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("id:");

        nombre.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("nombre :");

        puntaje.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        puntaje.setForeground(new java.awt.Color(255, 255, 255));
        puntaje.setText("puntaje :");

        conectar.setBackground(new java.awt.Color(0, 0, 0));
        conectar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        conectar.setForeground(new java.awt.Color(255, 255, 255));
        conectar.setText("Agregar");
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });

        ganados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ganados.setForeground(new java.awt.Color(255, 255, 255));
        ganados.setText("Juegos Ganados :");

        jTGanados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTGanadosActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        actualizar.setBackground(new java.awt.Color(0, 0, 0));
        actualizar.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        actualizar.setForeground(new java.awt.Color(255, 255, 255));
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaIngresoLayout = new javax.swing.GroupLayout(vistaIngreso);
        vistaIngreso.setLayout(vistaIngresoLayout);
        vistaIngresoLayout.setHorizontalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consultaT, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(vistaIngresoLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTid))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vistaIngresoLayout.createSequentialGroup()
                                    .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(puntaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTPuntaje, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(jTNombre))))
                            .addGroup(vistaIngresoLayout.createSequentialGroup()
                                .addComponent(ganados)
                                .addGap(30, 30, 30)
                                .addComponent(jTGanados, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addComponent(conectar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        vistaIngresoLayout.setVerticalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(consultaT, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ganados)
                    .addComponent(jTGanados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conectar)
                    .addComponent(actualizar))
                .addGap(18, 18, 18)
                .addComponent(jTEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        contenedor.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 910, 460));

        vistaDatos.setBackground(new java.awt.Color(0, 102, 51));

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nombre", "puntaje", "juegos ganados"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        titulo.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Datos puntaje");
        titulo.setToolTipText("");

        javax.swing.GroupLayout vistaDatosLayout = new javax.swing.GroupLayout(vistaDatos);
        vistaDatos.setLayout(vistaDatosLayout);
        vistaDatosLayout.setHorizontalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaDatosLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        vistaDatosLayout.setVerticalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contenedor.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 460));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos.imagenes/taker.jpeg"))); // NOI18N
        contenedor.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 861, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
       Connection conexion = getConnection();
       PreparedStatement ps = null;
       String sql= "insert into puntaje(id,nombre,puntaje, ganados)  value (?,?,?,?);";
        try {
           ps =  conexion.prepareStatement(sql);
           ps.setString(1, jTid.getText());
           ps.setString(2, jTNombre.getText());
           ps.setString(3, jTPuntaje.getText());
            ps.setString(4, jTGanados.getText());
           ps.executeUpdate();
           conexion.close();
           JOptionPane.showMessageDialog(null, "registro guardado");
           mostrarDatos();
           
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }//GEN-LAST:event_conectarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DriverManager.getConnection(url, user, password);
        String sql = "DELETE FROM puntaje WHERE id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, jTEliminar.getText());
        int rowsAffected = stmt.executeUpdate();
        System.out.println(rowsAffected + " filas eliminadas.");
        
        // Luego de eliminar, actualiza la tabla para reflejar los cambios
        mostrarDatos();

    } catch (SQLException e) {
        System.err.println("Error al eliminar filas: " + e.getMessage());
    } finally {
        // Cerrar los recursos
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTGanadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTGanadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTGanadosActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
   Connection conexion = null;
    PreparedStatement ps = null;
    StringBuilder sql = new StringBuilder("UPDATE puntaje SET ");

    try {
        conexion = getConnection();
        
        // Variables para saber si se ha añadido algún campo a la consulta
        boolean hayCampo = false;

        // Comprobar y añadir campos que se van a actualizar
        if (!jTNombre.getText().isEmpty()) {
            sql.append("nombre = ?");
            hayCampo = true;
        }
        if (!jTPuntaje.getText().isEmpty()) {
            if (hayCampo) sql.append(", ");
            sql.append("puntaje = ?");
            hayCampo = true;
        }
        if (!jTGanados.getText().isEmpty()) {
            if (hayCampo) sql.append(", ");
            sql.append("ganados = ?");
        }

        // Añadir condición WHERE
        sql.append(" WHERE id = ?");
        
        ps = conexion.prepareStatement(sql.toString());

        // Índice para saber en qué posición del PreparedStatement va cada parámetro
        int index = 1;

        // Asignar los valores a la consulta
        if (!jTNombre.getText().isEmpty()) {
            ps.setString(index++, jTNombre.getText());
        }
        if (!jTPuntaje.getText().isEmpty()) {
            ps.setString(index++, jTPuntaje.getText());
        }
        if (!jTGanados.getText().isEmpty()) {
            ps.setString(index++, jTGanados.getText());
        }
        ps.setString(index, jTid.getText());

        int rowsAffected = ps.executeUpdate();
        System.out.println(rowsAffected + " filas actualizadas.");
        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
        mostrarDatos();
    } catch (SQLException e) {
        System.err.println("Error al actualizar los datos: " + e.getMessage());
    } finally {
        // Cerrar la conexión y el PreparedStatement
        try {
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            System.err.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }

    }//GEN-LAST:event_actualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Torneo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton conectar;
    private javax.swing.JLabel consultaT;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel ganados;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTEliminar;
    private javax.swing.JTextField jTGanados;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPuntaje;
    private javax.swing.JTextField jTid;
    private javax.swing.JTable jtDatos;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel puntaje;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
