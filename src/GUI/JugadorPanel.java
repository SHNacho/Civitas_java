/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.Jugador;
import civitas.JugadorEspeculador;
import civitas.TituloPropiedad;
import java.util.ArrayList;

/**
 *
 * @author juliocamposrodriguez
 */
public class JugadorPanel extends javax.swing.JPanel {

    /**
     * Creates new form JugadorPanel
     */
    
    private Jugador jugador;
    
    public JugadorPanel() {
        initComponents();
    }
    
    public void setJugador(Jugador otro){
    
        jugador = otro;
        
        texto_nombre.setText(jugador.getNombre());
        
        texto_saldo.setText(Float.toString(jugador.getSaldo()));
        
        if (jugador.isEncarcelado())
            texto_encarcelado.setText("Si");
        else
            texto_encarcelado.setText("No");
        
        if (jugador instanceof JugadorEspeculador)
            texto_especulador.setText("Si");
        else
            texto_especulador.setText("No");
        
        repaint();
        
        rellenaPropiedades(jugador.getPropiedades());
    }
    
    public void rellenaPropiedades(ArrayList<TituloPropiedad> lista){
        propiedades.removeAll();
        
        for(TituloPropiedad t : lista){
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
            
            propiedades.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
        }
        
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        saldo = new javax.swing.JLabel();
        encarcelado = new javax.swing.JLabel();
        especulador = new javax.swing.JLabel();
        texto_nombre = new javax.swing.JTextField();
        texto_saldo = new javax.swing.JTextField();
        texto_encarcelado = new javax.swing.JTextField();
        texto_especulador = new javax.swing.JTextField();
        propiedades = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();

        nombre.setText("Nombre");
        nombre.setEnabled(false);

        saldo.setText("Saldo");
        saldo.setEnabled(false);

        encarcelado.setText("Encarcelado");
        encarcelado.setEnabled(false);

        especulador.setText("Especulador");
        especulador.setEnabled(false);

        texto_nombre.setText("jTextField1");
        texto_nombre.setEnabled(false);
        texto_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_nombreActionPerformed(evt);
            }
        });

        texto_saldo.setText("jTextField1");
        texto_saldo.setEnabled(false);

        texto_encarcelado.setText("jTextField1");
        texto_encarcelado.setEnabled(false);
        texto_encarcelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_encarceladoActionPerformed(evt);
            }
        });

        texto_especulador.setText("jTextField1");
        texto_especulador.setEnabled(false);

        titulo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        titulo.setText("Jugador actual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre)
                            .addComponent(saldo)
                            .addComponent(encarcelado)
                            .addComponent(especulador))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_encarcelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_especulador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(propiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre)
                            .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saldo)
                            .addComponent(texto_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(encarcelado)
                            .addComponent(texto_encarcelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(especulador)
                            .addComponent(texto_especulador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(propiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void texto_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_nombreActionPerformed

    private void texto_encarceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_encarceladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_encarceladoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel encarcelado;
    private javax.swing.JLabel especulador;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel propiedades;
    private javax.swing.JLabel saldo;
    private javax.swing.JTextField texto_encarcelado;
    private javax.swing.JTextField texto_especulador;
    private javax.swing.JTextField texto_nombre;
    private javax.swing.JTextField texto_saldo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
