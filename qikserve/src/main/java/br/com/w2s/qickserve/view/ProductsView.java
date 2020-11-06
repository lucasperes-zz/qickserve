package br.com.w2s.qickserve.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import br.com.w2s.qickserve.model.ProductModel;
import br.com.w2s.qickserve.service.ProductsService;
import br.com.w2s.qickserve.tablemodel.ProductsTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class ProductsView extends JDialog {
	
	private static final long serialVersionUID = -6218318998059309745L;
	
	private ProductsService service;
	private ProductModel product;
	
	private JTextField txtNomeProduto;
	private JTable table;
	private ProductsTableModel tableModel;

	// Modal
	public ProductsView(Frame owner, boolean modal) {
		super(owner, modal);
		initComponents();
	}

	/**
	 * Create the dialog.
	 */
	public ProductsView() {
		initComponents();
	}
	
	private void initComponents() {
		service = new ProductsService();
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 455);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JLabel lblTitulo = new JLabel("Adicionar Itens ao Carrinho");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTitulo.setBounds(10, 11, 601, 20);
			getContentPane().add(lblTitulo);
		}
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Event com ENTER
				listProducts();
			}
		});
		txtNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomeProduto.setBounds(10, 76, 499, 25);
		getContentPane().add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome Produto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 59, 125, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.setBounds(522, 76, 89, 25);
		btnPesquisar.addActionListener((evt) -> listProducts()); // Busca os produtos
		getContentPane().add(btnPesquisar);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					selectProduct();
				}
			}
		});
		table.setBorder(null);
		table.setBounds(10, 112, 601, 259);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new ProductsTableModel(new ArrayList<>());
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(320);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		
		JScrollPane scrollTable = new JScrollPane(table);
		scrollTable.setBounds(10, 112, 601, 259);
		
		getContentPane().add(scrollTable);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFechar.setBounds(425, 382, 89, 25);
		getContentPane().add(btnFechar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProduct();
			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdicionar.setBounds(522, 382, 89, 25);
		getContentPane().add(btnAdicionar);
	}
	
	public void listProducts() {
		List<ProductModel> products = service.list(txtNomeProduto.getText());
		tableModel.setItems(products);
	}
	
	public void selectProduct() {
		if(table.getSelectedRow() != -1) {
			product = tableModel.getItem(table.getSelectedRow());
			dispose();
		}
	}
	
	// GETTERS E SETTERS

	/**
	 * @return the product
	 */
	public ProductModel getProduct() {
		return product;
	}
	
}
