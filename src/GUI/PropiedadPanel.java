/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.JugadorEspeculador;
import civitas.TituloPropiedad;
/**
 *
 * @author juliocamposrodriguez
 */
public class PropiedadPanel extends javax.swing.JPanel {
    
    TituloPropiedad tituloPropiedad;

    /**
     * Creates new form PropiedadPanel
     */
    public PropiedadPanel() {
        initComponents();
    }
    
    public void setPropiedad(TituloPropiedad titulo){
        tituloPropiedad = titulo;
        
        texto_nombre.setText(tituloPropiedad.getNombre());
        
        texto_casas.setText(Integer.toString(tituloPropiedad.getNumCasas()));
        
        texto_hoteles.setText(Integer.toString(tituloPropiedad.getNumHoteles()));
        
        if (tituloPropiedad.getHipotecado())
            texto_hipotecado.setText("Si");
        else
            texto_hipotecado.setText("No");
        
        
        
        repaint();
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
        casas = new javax.swing.JLabel();
        hoteles = new javax.swing.JLabel();
        hipotecado = new javax.swing.JLabel();
        texto_nombre = new javax.swing.JTextField();
        texto_casas = new javax.swing.JTextField();
        texto_hoteles = new javax.swing.JTextField();
        texto_hipotecado = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();

        nombre.setText("Nombre");
        nombre.setEnabled(false);

        casas.setText("Nº casas");
        casas.setEnabled(false);

        hoteles.setText("Nº Hoteles");
        hoteles.setEnabled(false);

        hipotecado.setText("Hipotecado");
        hipotecado.setEnabled(false);

        texto_nombre.setText("jTextField1");
        texto_nombre.setEnabled(false);

        texto_casas.setText("jTextField2");
        texto_casas.setEnabled(false);

        texto_hoteles.setText("jTextField3");
        texto_hoteles.setEnabled(false);

        texto_hipotecado.setText("jTextField4");
        texto_hipotecado.setEnabled(false);

        titulo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Propiedad");
        titulo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hipotecado)
                            .addComponent(hoteles)
                            .addComponent(casas)
                            .addComponent(nombre))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_casas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_hoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_hipotecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(texto_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(casas)
                    .addComponent(texto_casas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoteles)
                    .addComponent(texto_hoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hipotecado)
                    .addComponent(texto_hipotecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel casas;
    private javax.swing.JLabel hipotecado;
    private javax.swing.JLabel hoteles;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField texto_casas;
    private javax.swing.JTextField texto_hipotecado;
    private javax.swing.JTextField texto_hoteles;
    private javax.swing.JTextField texto_nombre;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
