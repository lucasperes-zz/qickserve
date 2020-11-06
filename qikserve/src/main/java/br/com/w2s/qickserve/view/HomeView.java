package br.com.w2s.qickserve.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.w2s.qickserve.model.OrderModel;
import br.com.w2s.qickserve.model.ProductModel;
import br.com.w2s.qickserve.utils.AppUtils;
import br.com.w2s.qickserve.utils.MessagesUtils;
import br.com.w2s.qickserve.utils.SessionApp;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class HomeView extends JFrame {

	private static final long serialVersionUID = 296154146743459963L;
	
	private JPanel contentPane;
	private JLabel lblValorTotal;
	private JLabel lblValorVoucher;
	private JLabel lblValorLiquido;
	
	/**
	 * Create the frame.
	 */
	public HomeView() {
		initComponents();
	}

	/**
	 * @author Lucas P. Soares (lucasperes20@gmail.com)
	 * @date 6 de nov de 2020
	 *
	 */
	private void initComponents() {
		setTitle("QickServe - Sistema para checkout de supermercado - Versão 1.0.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 579, 414);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarItens = new JButton("Adicionar Itens");
		btnAdicionarItens.setForeground(new Color(0, 128, 0));
		btnAdicionarItens.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAdicionarItens.setBounds(162, 115, 246, 52);
		btnAdicionarItens.addActionListener((evt) -> {
			addItem();
		});
		contentPane.add(btnAdicionarItens);
		
		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.setForeground(new Color(0, 0, 128));
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizeOrder();
			}
		});
		btnFinalizarCompra.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnFinalizarCompra.setBounds(162, 178, 246, 52);
		contentPane.add(btnFinalizarCompra);
		
		JLabel lblValor = new JLabel("(+) Valor Total:");
		lblValor.setForeground(new Color(0, 0, 0));
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValor.setBounds(10, 286, 146, 22);
		contentPane.add(lblValor);
		
		lblValorTotal = new JLabel("R$ 0,00");
		lblValorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorTotal.setForeground(new Color(0, 0, 0));
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorTotal.setBounds(417, 289, 146, 22);
		contentPane.add(lblValorTotal);
		
		JLabel lblBemvindoAoSistema = new JLabel("Bem-vindo ao sistema QickServe");
		lblBemvindoAoSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindoAoSistema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBemvindoAoSistema.setBounds(10, 17, 543, 22);
		contentPane.add(lblBemvindoAoSistema);
		
		JLabel lblBemvindoAoSistema_1 = new JLabel("Adicione produtos ao seu carrinho clicando no botão abaixo!");
		lblBemvindoAoSistema_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindoAoSistema_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBemvindoAoSistema_1.setBounds(10, 42, 543, 22);
		contentPane.add(lblBemvindoAoSistema_1);
		
		JLabel lblValorDesconto = new JLabel("(-) Desconto:");
		lblValorDesconto.setForeground(new Color(0, 128, 0));
		lblValorDesconto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorDesconto.setBounds(10, 319, 130, 22);
		contentPane.add(lblValorDesconto);
		
		lblValorVoucher = new JLabel("R$ 0,00");
		lblValorVoucher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorVoucher.setForeground(new Color(0, 128, 0));
		lblValorVoucher.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorVoucher.setBounds(417, 322, 146, 22);
		contentPane.add(lblValorVoucher);
		
		JLabel lblValorLquido = new JLabel("(=) Valor Líquido:");
		lblValorLquido.setForeground(new Color(0, 0, 128));
		lblValorLquido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorLquido.setBounds(10, 352, 189, 22);
		contentPane.add(lblValorLquido);
		
		lblValorLiquido = new JLabel("R$ 0,00");
		lblValorLiquido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorLiquido.setForeground(new Color(0, 0, 128));
		lblValorLiquido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorLiquido.setBounds(417, 355, 146, 22);
		contentPane.add(lblValorLiquido);
		
		JLabel lblValor_1 = new JLabel("............................................................");
		lblValor_1.setForeground(Color.BLACK);
		lblValor_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValor_1.setBounds(162, 286, 294, 22);
		contentPane.add(lblValor_1);
		
		JLabel lblValorDesconto_1 = new JLabel("......................................................");
		lblValorDesconto_1.setForeground(new Color(0, 128, 0));
		lblValorDesconto_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorDesconto_1.setBounds(162, 318, 299, 22);
		contentPane.add(lblValorDesconto_1);
		
		JLabel lblValorLquido_1 = new JLabel("..........................................................");
		lblValorLquido_1.setForeground(new Color(0, 0, 128));
		lblValorLquido_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorLquido_1.setBounds(183, 351, 273, 22);
		contentPane.add(lblValorLquido_1);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(MessagesUtils.showMessageConfirm("Tem certeza que realmente deseja sair do sistema?")) {
					System.exit(0);
				}
			}
		});
		
		updateValuesOrder();
	}
	
	// Metodos Auxiliares
	
	/**
	 * @author Lucas P. Soares (lucasperes20@gmail.com)
	 * @date 6 de nov de 2020
	 *
	 */
	private void addItem() {
		ProductsView view = new ProductsView(this, true);
		view.setVisible(true);
		
		ProductModel prod = view.getProduct();
		if(prod != null) {
			String value = MessagesUtils.showMessageInput("Informe a quantidade do produto a ser adicionada ao carrinho");
			if(value != null && value.matches("[1-9]{1,}")) { // Regex para pegar somente numeros acima de 0
				OrderModel orderOpen = SessionApp.setInstance().getOrderOpen();
				orderOpen.addItem(prod, Integer.parseInt(value));
				updateValuesOrder();
			} else {
				MessagesUtils.showMessageError("Quantidade de produto informado está inválido!");
			}
		}
	}

	private void updateValuesOrder() {
		OrderModel orderOpen = SessionApp.setInstance().getOrderOpen();
		lblValorTotal.setText("R$ " + AppUtils.formatNumber(orderOpen.getValorTotal()));
		lblValorVoucher.setText("R$ " + AppUtils.formatNumber(orderOpen.getValorVoucher()));
		lblValorLiquido.setText("R$ " + AppUtils.formatNumber(orderOpen.getValorLiquido()));
	}
	
	private void finalizeOrder() {
		SessionApp session = SessionApp.setInstance();
		// Realiza as validacoes
		OrderModel orderOpen = session.getOrderOpen();
		if(orderOpen == null || orderOpen.getItems().isEmpty()) {
			MessagesUtils.showMessageWarn("Carrinho de compra sem itens!");
			return;
		}
		
		CartView view = new CartView(this, true);
		view.setVisible(true);
		
		if(view.isFinalize()) {
			session.addOrder(); // Adiciona a ordem a lista
			session.setOrderOpen(new OrderModel());
			
			updateValuesOrder();
			MessagesUtils.showMessageInfo("Compra realizada com sucesso!");
		}
	}
}
