
package com.digipets.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.digipets.controller.TutorController;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class CadastrarClienteView extends javax.swing.JFrame {

	public CadastrarClienteView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarClienteView.class.getResource("/imagens/animal-care.png")));
		new JFrame();
		initComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	} 
                        
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTFNome = new javax.swing.JTextField();
		jTFCpf = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTFEndereco = new javax.swing.JTextField();
		jBTNCadastrar = new javax.swing.JButton();
		jBTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();

				jTFNome.setText(null);
				jTFEndereco.setText(null);
				jTFCpf.setText(null);

			}
		});
		jBTNVoltar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jLabel1.setText("Nome:");

		jLabel2.setText("CPF:");

		jLabel3.setText("Endereço");

		jBTNCadastrar.setIcon(new ImageIcon(CadastrarClienteView.class.getResource("/imagens/salvar.png"))); // NOI18N
		jBTNCadastrar.setText("Salvar");

		jBTNVoltar.setIcon(new ImageIcon(CadastrarClienteView.class.getResource("/imagens/de-volta.png"))); // NOI18N
		jBTNVoltar.setText("Voltar");
		jBTNVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBTNVoltarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(32, 32, 32)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1)
								.addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(jBTNCadastrar)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jBTNVoltar)))
								.addComponent(jLabel2)
								.addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 50, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(13, 13, 13)
						.addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jBTNCadastrar)
								.addComponent(jBTNVoltar))
						.addContainerGap(50, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();
	}// </editor-fold>                        

	private void jBTNVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                           
		CadastrarClienteView.this.dispose();
		HomeView frame = new HomeView();
		frame.setVisible(true);
	}

	public void cadastrarCliente() {
		boolean sucesso;
		try {
			new TutorController();
			String nome = jTFNome.getText();
			String endereco = jTFEndereco.getText();
			String cpf =jTFCpf.getText();
			sucesso = TutorController.cadastrarCliente(nome,cpf, endereco);
			System.out.println(sucesso);
			if (sucesso == true) {

				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");

			} else if (nome.length() <= 0 || cpf.length() <= 0 || endereco.length() <= 0) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			} 
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
		}
	}

	/**
	 * @param args the command line arguments
	 */
	//    public static void main(String args[]) {
	//        /* Set the Nimbus look and feel */
	//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	//         */
	//        try {
	//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	//                if ("Nimbus".equals(info.getName())) {
	//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	//                    break;
	//                }
	//            }
	//        } catch (ClassNotFoundException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (InstantiationException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (IllegalAccessException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	//            java.util.logging.Logger.getLogger(CadastrarClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	//        }
	//        //</editor-fold>
	//
	//        /* Create and display the form */
	//        java.awt.EventQueue.invokeLater(new Runnable() {
	//            public void run() {
	//                new CadastrarClienteView().setVisible(true);
	//            }
	//        });
	//    }

	// Variables declaration - do not modify                     
	private javax.swing.JButton jBTNCadastrar;
	private javax.swing.JButton jBTNVoltar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTFCpf;
	private javax.swing.JTextField jTFEndereco;
	private javax.swing.JTextField jTFNome;
	// End of variables declaration                   
}
