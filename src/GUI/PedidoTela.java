
package GUI;

import Beans.ClienteBeans;
import Beans.PedidoBeans;
import Controller.ClienteController;
import Controller.PedidoController;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class PedidoTela extends javax.swing.JInternalFrame {

    MaskFormatter formatoTel;
    SimpleDateFormat formatoData;
    Date dataAtual;
    ClienteBeans clienteB;
    ClienteController clienteC;
    PedidoController pedidoC;
    PedidoBeans pedidoB;
    DefaultTableModel modelo;
    List<String> lista;
    List<String> listaDeItens;
    DecimalFormat formatoDecimal;
    int idFuncionario;
    SimpleDateFormat formatoHora;
    
    public PedidoTela(int idFuncionario) {
        initComponents();
        habilitarCampos(false);
        modelo = (DefaultTableModel)tabela.getModel();
        lista = new ArrayList<>();
        listaDeItens = new ArrayList<>();
        clienteB = new ClienteBeans();
        clienteC = new ClienteController();
        
        pedidoB = new PedidoBeans();
        pedidoC = new PedidoController();
        
        painelPai.setEnabledAt(1, false);
        
        formatoDecimal = new DecimalFormat("0.00");
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.idFuncionario = idFuncionario;
        
        dataAtual = new Date();
        formatoData = new SimpleDateFormat("yyyy-MM-dd");
        formatoHora = new SimpleDateFormat("HH:mm:ss");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPai = new javax.swing.JTabbedPane();
        painelCliente = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        cbClientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        try {
            formatoTel = new MaskFormatter("(##) #####-####");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo personalizado", "Erro", 0);
        }
        txtTel = new JFormattedTextField(formatoTel);
        jLabel6 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnPedido = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        painelPedido = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtItem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbItens = new javax.swing.JComboBox<>();
        btnValor = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnFecharPedido = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pesquise um Cliente ao Lado" }));
        cbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Id");

        txtId.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Rua");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Bairro");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Telefone");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Data");

        txtData.setEditable(false);

        btnPedido.setText("Pedido");
        btnPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                .addComponent(btnPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFechar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(26, 26, 26)
                                        .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(painelClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))))))
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPedido)
                    .addComponent(btnFechar))
                .addGap(27, 27, 27))
        );

        painelPai.addTab("Cliente", painelCliente);

        jLabel7.setText("Item");

        txtNomeCliente.setEditable(false);
        txtNomeCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtItemKeyReleased(evt);
            }
        });

        jLabel8.setText("Selecionar");

        cbItens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busque um Item ao Lado" }));
        cbItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbItensActionPerformed(evt);
            }
        });

        btnValor.setText("Valor");
        btnValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValorActionPerformed(evt);
            }
        });

        jLabel27.setText("Valor");

        txtValor.setEditable(false);

        txtQuantidade.setText("1");
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        jLabel28.setText("Quantidade");

        txtIdPedido.setEditable(false);

        jLabel29.setText("Id");

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemover.setText("-");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel30.setText("Total do Pedido");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Item", "Descrição", "Valor Unitário", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela);

        btnFecharPedido.setText("Fechar");
        btnFecharPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharPedidoActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPedidoLayout = new javax.swing.GroupLayout(painelPedido);
        painelPedido.setLayout(painelPedidoLayout);
        painelPedidoLayout.setHorizontalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFecharPedido)
                .addGap(20, 20, 20))
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeCliente)
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPedidoLayout.createSequentialGroup()
                                .addComponent(btnValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbItens, 0, 219, Short.MAX_VALUE))
                            .addGroup(painelPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        painelPedidoLayout.setVerticalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValor)
                    .addComponent(jLabel27)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnRemover)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFecharPedido)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        painelPai.addTab("Pedido", painelPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPai)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPai, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        cbClientes.removeAllItems();
        lista.clear();
        String Pesquisa = JOptionPane.showInputDialog(null, "Digite o Nome do Cliente", "Pesquisar", 3);
        clienteC.controlePesquisa(Pesquisa, lista);
        for(String i: lista){
            cbClientes.addItem(i);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientesActionPerformed
        if(!(cbClientes.getSelectedItem() == null)){
            String cod = cbClientes.getSelectedItem().toString();
            cod = cod.substring(0, cod.indexOf(" "));
            clienteB = clienteC.controlePreencherCampos(Integer.parseInt(cod));
            txtId.setText(clienteB.getId() + "");
            txtNome.setText(clienteB.getNome());
            txtRua.setText(clienteB.getRua());
            txtBairro.setText(clienteB.getBairro());
            txtTel.setText(clienteB.getTelefone());
            txtData.setText(clienteB.getDataCad());
        }
    }//GEN-LAST:event_cbClientesActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        painelPai.setEnabledAt(1, true);
        painelPai.setEnabledAt(0, false);
        painelPai.setSelectedIndex(1);
        txtNomeCliente.setText(txtNome.getText());
        btnFinalizar.setEnabled(false);
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemKeyReleased
        txtValor.setText("");
        cbItens.removeAllItems();
        listaDeItens.clear();
        pedidoC.controleDeItens(txtItem.getText(), listaDeItens);
        for(String i: listaDeItens){
            cbItens.addItem(i);
        }
    }//GEN-LAST:event_txtItemKeyReleased

    private void cbItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbItensActionPerformed
        txtValor.setText("");
        txtQuantidade.setText("1");
    }//GEN-LAST:event_cbItensActionPerformed

    private void btnValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValorActionPerformed
        txtValor.setText(pedidoC.controleDeValor(cbItens.getSelectedItem().toString()) + "");
        txtIdPedido.setText(pedidoC.controleDeCodigo(cbItens.getSelectedItem().toString()) + "");
    }//GEN-LAST:event_btnValorActionPerformed

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost
        
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(pedidoC.verificaItens(txtValor.getText(), txtQuantidade.getText(), txtIdPedido.getText(), cbItens.getSelectedItem().toString())){
            double total = Double.parseDouble(txtValor.getText()) * Integer.parseInt(txtQuantidade.getText());
            modelo.addRow(new Object[]{txtIdPedido.getText(), cbItens.getSelectedItem(), txtValor.getText(), txtQuantidade.getText(), total});
            limparCampos();
            calcularTotal();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        modelo.removeRow(tabela.getSelectedRow());
        calcularTotal();

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPedidoActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharPedidoActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        popularBeans();
        pedidoC.controleDePedido(txtId.getText(), idFuncionario + "", txtTotal.getText(), tabela.getRowCount(), pedidoB);
        limparFinalizar();
    }//GEN-LAST:event_btnFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFecharPedido;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnValor;
    private javax.swing.JComboBox<String> cbClientes;
    private javax.swing.JComboBox<String> cbItens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JTabbedPane painelPai;
    private javax.swing.JPanel painelPedido;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeCliente;
    public static javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

final void habilitarCampos(boolean valor){
    txtId.setEnabled(valor);
    txtRua.setEnabled(valor);
    txtBairro.setEnabled(valor);
    txtNome.setEnabled(valor);
    txtTel.setEnabled(valor);
    txtData.setEnabled(valor);
    }

final void limparCampos(){
    txtItem.setText("");
    txtQuantidade.setText("1");
    cbItens.removeAllItems();
    txtValor.setText("");
}

final void calcularTotal(){
    double totalPedido = 0;
    for(int i = 0; i < tabela.getRowCount();i++){
        totalPedido += Double.parseDouble(modelo.getValueAt(i, 4).toString());   
    }
    if(totalPedido > 0){
        btnFinalizar.setEnabled(true);
    }
   //Resolver erro de formatação do valor total do pedido
    txtTotal.setText(formatoDecimal.format(totalPedido).replace('.',','));
}

final void popularBeans(){
    dataAtual = new Date();
    pedidoB.setIdCliente(Integer.parseInt(txtId.getText()));
    pedidoB.setIdFuncionario(idFuncionario);
    pedidoB.setIdEntregador(1);
    pedidoB.setData(formatoData.format(dataAtual));
    pedidoB.setHora(formatoHora.format(dataAtual));
    pedidoB.setStatus("Pedido Aberto");
    pedidoB.setValor(Double.parseDouble(txtTotal.getText().replace(',','.')));
    for(int i = 0; i < tabela.getRowCount();i++){
        pedidoB.setIdCardapio(Integer.parseInt(modelo.getValueAt(i,0).toString()));
        pedidoB.setQuantidade(Integer.parseInt(modelo.getValueAt(i,3).toString()));
        }
    }

final void limparFinalizar(){
    txtTotal.setText("");
    txtIdPedido.setText("");
    btnFinalizar.setEnabled(false);
    modelo.setNumRows(0);
}

}


