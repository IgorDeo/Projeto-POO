/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilitarios.FundoTela;
import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.ImageIcon;


/**
 *
 * @author igord
 */
public class Principal extends javax.swing.JFrame {

    FundoTela telaPrincipal;
    ClienteTela clienteTela;
    FuncionarioTela funcionarioTela;
    EntregadorTela entregadorTela;
    CardapioTela cardapioTela;
    PedidoTela pedidoTela;
    
    public Principal() {
        initComponents();
        //setExtendedState(JFrame.MAXIMIZED_BOTH); //Essa linha faz com que a tela inicie no tamanho do monitor utilizado
        setLayout(new GridLayout());
        telaPrincipal = new FundoTela("/Icones/background_inicial.jpg");
        getContentPane().add(telaPrincipal);
        
        ImageIcon icone = new ImageIcon(getClass().getResource("/Icones/ico_cardapio.png"));
        setIconImage(icone.getImage());
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuClientes = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenuItem();
        menuCardapio = new javax.swing.JMenuItem();
        menuEntregador = new javax.swing.JMenuItem();
        menuCaixa = new javax.swing.JMenu();
        menuPedidos = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurante ID-VT");
        setPreferredSize(new java.awt.Dimension(1600, 1000));
        setResizable(false);

        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/inserir-32.png"))); // NOI18N
        menuCadastro.setText("Cadastro");

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_clientes.png"))); // NOI18N
        menuClientes.setText("Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });
        menuCadastro.add(menuClientes);

        menuFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_func.png"))); // NOI18N
        menuFuncionarios.setText("Funcionários");
        menuFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionariosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuFuncionarios);

        menuCardapio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_cardapio.png"))); // NOI18N
        menuCardapio.setText("Cardápio");
        menuCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCardapioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCardapio);

        menuEntregador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_boy.png"))); // NOI18N
        menuEntregador.setText("Entregador");
        menuEntregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEntregadorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuEntregador);

        jMenuBar1.add(menuCadastro);

        menuCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_caixa.png"))); // NOI18N
        menuCaixa.setText("Caixa");

        menuPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_pedidos.png"))); // NOI18N
        menuPedidos.setText("Pedidos");
        menuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPedidosActionPerformed(evt);
            }
        });
        menuCaixa.add(menuPedidos);

        jMenuBar1.add(menuCaixa);

        menuRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_rel.png"))); // NOI18N
        menuRelatorios.setText("Relatórios");
        jMenuBar1.add(menuRelatorios);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_sair.png"))); // NOI18N
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        clienteTela = new ClienteTela();
        telaPrincipal.add(clienteTela);
        clienteTela.setVisible(true);
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionariosActionPerformed
        funcionarioTela = new FuncionarioTela();
        telaPrincipal.add(funcionarioTela);
        funcionarioTela.setVisible(true);
    }//GEN-LAST:event_menuFuncionariosActionPerformed

    private void menuEntregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEntregadorActionPerformed
        entregadorTela = new EntregadorTela();
        telaPrincipal.add(entregadorTela);
        entregadorTela.setVisible(true);
    }//GEN-LAST:event_menuEntregadorActionPerformed

    private void menuCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCardapioActionPerformed
        cardapioTela = new CardapioTela();
        telaPrincipal.add(cardapioTela);
        cardapioTela.setVisible(true);
    }//GEN-LAST:event_menuCardapioActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        dispose();
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidosActionPerformed
        pedidoTela = new PedidoTela();
        telaPrincipal.add(pedidoTela);
        pedidoTela.setVisible(true);
    }//GEN-LAST:event_menuPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCaixa;
    private javax.swing.JMenuItem menuCardapio;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuEntregador;
    private javax.swing.JMenuItem menuFuncionarios;
    private javax.swing.JMenuItem menuPedidos;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
