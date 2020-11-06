package br.com.w2s.qickserve.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import br.com.w2s.qickserve.model.OrderModel;
import br.com.w2s.qickserve.tablemodel.ItemsOrderTableModel;
import br.com.w2s.qickserve.utils.AppUtils;
import br.com.w2s.qickserve.utils.SessionApp;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class CartView extends JDialog {

	private static final long serialVersionUID = 1835136390446075762L;

	private ItemsOrderTableModel tableModel;
	
	private JTable table;
	private JLabel lblValorTotal;
	private JLabel lblValorVoucher;
	private JLabel lblValorLiquido;
	
	private boolean finalize;
	
	// Modal
	public CartView(Frame owner, boolean modal) {
		super(owner, modal);
		initComponents();
	}	
	
	/**
	 * Create the dialog.
	 */
	public CartView() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponents();
	}

	/**
	 * @author Lucas P. Soares (lucasperes20@gmail.com)
	 * @date 6 de nov de 2020
	 *
	 */
	private void initComponents() {
		setBounds(100, 100, 589, 470);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblValor = new JLabel("(+) Valor Total:");
		lblValor.setForeground(Color.BLACK);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValor.setBounds(10, 267, 146, 22);
		getContentPane().add(lblValor);
		
		JLabel lblValor_1 = new JLabel("............................................................");
		lblValor_1.setForeground(Color.BLACK);
		lblValor_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValor_1.setBounds(160, 266, 296, 22);
		getContentPane().add(lblValor_1);
		
		lblValorTotal = new JLabel("R$ <dynamic>");
		lblValorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorTotal.setForeground(Color.BLACK);
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorTotal.setBounds(417, 269, 146, 22);
		getContentPane().add(lblValorTotal);
		
		lblValorVoucher = new JLabel("R$ <dynamic>");
		lblValorVoucher.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorVoucher.setForeground(new Color(0, 128, 0));
		lblValorVoucher.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorVoucher.setBounds(417, 302, 146, 22);
		getContentPane().add(lblValorVoucher);
			
		JLabel lblValorDesconto_1 = new JLabel("......................................................");
		lblValorDesconto_1.setForeground(new Color(0, 128, 0));
		lblValorDesconto_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorDesconto_1.setBounds(144, 299, 317, 22);
		getContentPane().add(lblValorDesconto_1);
		
		JLabel lblValorDesconto = new JLabel("(-) Desconto:");
		lblValorDesconto.setForeground(new Color(0, 128, 0));
		lblValorDesconto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorDesconto.setBounds(10, 300, 146, 22);
		getContentPane().add(lblValorDesconto);
		
		JLabel lblValorLquido = new JLabel("(=) Valor Líquido:");
		lblValorLquido.setForeground(new Color(0, 0, 128));
		lblValorLquido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorLquido.setBounds(10, 333, 174, 22);
		getContentPane().add(lblValorLquido);
			
		JLabel lblValorLquido_1 = new JLabel("..........................................................");
		lblValorLquido_1.setForeground(new Color(0, 0, 128));
		lblValorLquido_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorLquido_1.setBounds(179, 332, 277, 22);
		getContentPane().add(lblValorLquido_1);
		
		lblValorLiquido = new JLabel("R$ <dynamic>");
		lblValorLiquido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorLiquido.setForeground(new Color(0, 0, 128));
		lblValorLiquido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorLiquido.setBounds(417, 335, 146, 22);
		getContentPane().add(lblValorLiquido);
		
		JLabel lblFinalizarCarrinhoDe = new JLabel("Finalizar Carrinho de Compra");
		lblFinalizarCarrinhoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalizarCarrinhoDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFinalizarCarrinhoDe.setBounds(10, 11, 553, 20);
		getContentPane().add(lblFinalizarCarrinhoDe);
		
		table = new JTable();
		table.setBorder(null);
		table.setBounds(10, 112, 601, 259);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableModel = new ItemsOrderTableModel(new ArrayList<>());
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(320);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setPreferredWidth(160);
		table.getColumnModel().getColumn(6).setPreferredWidth(160);
		
		JScrollPane scrollTable = new JScrollPane(table);
		scrollTable.setBounds(10, 42, 553, 216);
		
		getContentPane().add(scrollTable);
		
		JButton btnFinalizar = new JButton("Finalizar Compra");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizeOrder();
			}
		});
		btnFinalizar.setForeground(new Color(0, 128, 0));
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFinalizar.setBounds(10, 385, 553, 35);
		getContentPane().add(btnFinalizar);
		
		updateValuesOrder();
	}
	
	private void updateValuesOrder() {
		OrderModel orderOpen = SessionApp.setInstance().getOrderOpen();
		lblValorTotal.setText("R$ " + AppUtils.formatNumber(orderOpen.getValorTotal()));
		lblValorVoucher.setText("R$ " + AppUtils.formatNumber(orderOpen.getValorVoucher()));
		lblValorLiquido.setText("R$ " + AppUtils.formatNumber(orderOpen.getValorLiquido()));
		
		tableModel.setItems(orderOpen.getItems());
	}
	
	private void finalizeOrder() {
		finalize = true;
		dispose();
	}

	/**
	 * @return the finalize
	 */
	public boolean isFinalize() {
		return finalize;
	}
	
}
