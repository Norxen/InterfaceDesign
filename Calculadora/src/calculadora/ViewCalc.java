/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculadora;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author norxe
 */
public class ViewCalc extends javax.swing.JFrame {

    private boolean hasAPoint = true;
    private boolean hasToBeClear = true;
    
    ModelCalc modelo;
    
    public ViewCalc() {
        initComponents();
        modelo = new ModelCalc();
        //Iniciar el componente JFframe en la parte central de la pantalla 
        //y darle un tamaño inicial.
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        this.setSize(size.width/4, size.height/2);
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setMinimumSize(new Dimension(300, 400));
        
        //Configurar los Keybindings de cada boton respectivamente.
        ConfigureKeyBindings();
    }
    
    private void ConfigureKeyBindings() {
        setKeyBindingForButton(jButton0, 
                KeyStroke.getKeyStroke("0"), "0");
        setKeyBindingForButton(jButton0, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "0");
        setKeyBindingForButton(jButton1, 
                KeyStroke.getKeyStroke("1"), "1");
        setKeyBindingForButton(jButton1, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "1");
        setKeyBindingForButton(jButton2, 
                KeyStroke.getKeyStroke("2"), "2");
        setKeyBindingForButton(jButton2, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "2");
        setKeyBindingForButton(jButton3, 
                KeyStroke.getKeyStroke("3"), "3");
        setKeyBindingForButton(jButton3, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "3");
        setKeyBindingForButton(jButton4, 
                KeyStroke.getKeyStroke("4"), "4");
        setKeyBindingForButton(jButton4, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "4");
        setKeyBindingForButton(jButton5, 
                KeyStroke.getKeyStroke("5"), "5");
        setKeyBindingForButton(jButton5, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "5");
        setKeyBindingForButton(jButton6, 
                KeyStroke.getKeyStroke("6"), "6");
        setKeyBindingForButton(jButton6, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "6");
        setKeyBindingForButton(jButton7, 
                KeyStroke.getKeyStroke("7"), "7");
        setKeyBindingForButton(jButton7, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "7");
        setKeyBindingForButton(jButton8, 
                KeyStroke.getKeyStroke("8"), "8");
        setKeyBindingForButton(jButton8, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "8");
        setKeyBindingForButton(jButton9, 
                KeyStroke.getKeyStroke("9"), "9");
        setKeyBindingForButton(jButton9, 
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "9");
        //ADD
        setKeyBindingForButton(jButtonAdd, 
                KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "add");
        setKeyBindingForButton(jButtonAdd, 
                KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "add");
        //SUBSTRACT
        setKeyBindingForButton(jButtonSubstract, 
                KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "sub");
        setKeyBindingForButton(jButtonSubstract, 
                KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "sub");
        //MULTIPLY
        setKeyBindingForButton(jButtonMultiply, 
                KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "mul");
        setKeyBindingForButton(jButtonMultiply, 
                KeyStroke.getKeyStroke(KeyEvent.VK_ASTERISK, 0), "mul");
        setKeyBindingForButton(jButtonMultiply, 
                KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.SHIFT_DOWN_MASK), "mul");
        //DIVIDE
        setKeyBindingForButton(jButtonDivide, 
                KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "div");
        setKeyBindingForButton(jButtonDivide, 
                KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "div");
        setKeyBindingForButton(jButtonDivide, 
                KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.SHIFT_DOWN_MASK), "div");
        //COMMA
        setKeyBindingForButton(jButtonComa, 
                KeyStroke.getKeyStroke(KeyEvent.VK_COLON, 0), "comma");
        setKeyBindingForButton(jButtonComa, 
                KeyStroke.getKeyStroke(KeyEvent.VK_COMMA, 0), "comma");
        setKeyBindingForButton(jButtonComa, 
                KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), "comma");
    }
    
    private void setKeyBindingForButton(JButton button, KeyStroke key, String mapKey) {
        button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(key, mapKey);
        button.getActionMap().put(mapKey, new AbstractAction(){
            @Override public void actionPerformed(ActionEvent ae) {
            button.doClick();
            }
        });
    }
    
    private void addDigitOrComma(String text) {
        if(hasToBeClear){
            jTextField1.setText("");
            hasToBeClear = false;
            hasAPoint = false;
        }
        
        jTextField1.setText(jTextField1.getText() + text);
    }
    
    private void askForOperation(CalcOperation operation) {
        
        try{
            double num = Double.parseDouble(jTextField1.getText());
            
            if(modelo.getOperation() == CalcOperation.NONE){
                modelo.setResultado(num);
            }else{
                modelo.calculate(num);
            }
            
            jTextField1.setText("" + modelo.getResultado());
            
        }catch(NumberFormatException e) {
            jTextField1.setText("Err");
            modelo.setResultado(0);
        }
        
        hasToBeClear = true;
        hasAPoint = true;
        modelo.setOperation(operation);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButtonComa = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonSubstract = new javax.swing.JButton();
        jButtonMultiply = new javax.swing.JButton();
        jButtonDivide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(300, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTextField1.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.setKeymap(null);
        jTextField1.setMaximumSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jTextField1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton1.setText("1");
        jButton1.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton2.setText("2");
        jButton2.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton3.setText("3");
        jButton3.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton3, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton4.setText("4");
        jButton4.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton4, gridBagConstraints);

        jButton5.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton5.setText("5");
        jButton5.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton5, gridBagConstraints);

        jButton6.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton6.setText("6");
        jButton6.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton6, gridBagConstraints);

        jButton7.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton7.setText("7");
        jButton7.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton7, gridBagConstraints);

        jButton8.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton8.setText("8");
        jButton8.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton8, gridBagConstraints);

        jButton9.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton9.setText("9");
        jButton9.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton9, gridBagConstraints);

        jButton0.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButton0.setText("0");
        jButton0.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton0, gridBagConstraints);

        jButtonComa.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButtonComa.setText(",");
        jButtonComa.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonComa, gridBagConstraints);

        jButtonAdd.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButtonAdd.setText("+");
        jButtonAdd.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonAdd, gridBagConstraints);

        jButtonSubstract.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButtonSubstract.setText("-");
        jButtonSubstract.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonSubstract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubstractActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonSubstract, gridBagConstraints);

        jButtonMultiply.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButtonMultiply.setText("*");
        jButtonMultiply.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiplyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonMultiply, gridBagConstraints);

        jButtonDivide.setFont(new java.awt.Font("Rubik", 0, 12)); // NOI18N
        jButtonDivide.setText("/");
        jButtonDivide.setMinimumSize(new java.awt.Dimension(50, 50));
        jButtonDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDivideActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButtonDivide, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("0");
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButtonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComaActionPerformed
        // TODO add your handling code here:
        if(!hasAPoint){
            addDigitOrComma(".");
            hasAPoint = true;
        }
    }//GEN-LAST:event_jButtonComaActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        askForOperation(CalcOperation.ADDITION);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSubstractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubstractActionPerformed
        // TODO add your handling code here:
        askForOperation(CalcOperation.SUBSTRACTION);
    }//GEN-LAST:event_jButtonSubstractActionPerformed

    private void jButtonMultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiplyActionPerformed
        // TODO add your handling code here:
        askForOperation(CalcOperation.MULTIPLICATION);
    }//GEN-LAST:event_jButtonMultiplyActionPerformed

    private void jButtonDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDivideActionPerformed
        // TODO add your handling code here:
        askForOperation(CalcOperation.DIVISION);
    }//GEN-LAST:event_jButtonDivideActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("1");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("2");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("3");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("4");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("5");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("6");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("7");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("8");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        addDigitOrComma("9");
    }//GEN-LAST:event_jButton9ActionPerformed

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
                if ("CDE".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonComa;
    private javax.swing.JButton jButtonDivide;
    private javax.swing.JButton jButtonMultiply;
    private javax.swing.JButton jButtonSubstract;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
