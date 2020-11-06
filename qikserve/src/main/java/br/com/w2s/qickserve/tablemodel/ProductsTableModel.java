package br.com.w2s.qickserve.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.w2s.qickserve.model.ProductModel;
import br.com.w2s.qickserve.utils.AppUtils;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class ProductsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 6435439189522450821L;

	private List<ProductModel> items;
	private String[] columns = {"ID", "Nome", "Preço"};
	
	public ProductsTableModel(List<ProductModel> items) {
		this.items = items;
	}
	
	@Override
	public int getRowCount() {
		return items.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProductModel prod = getItem(rowIndex);
		switch(columnIndex) {
			case 0:
				return prod.getId();
			case 1:
				return prod.getName();
			case 2:
				return AppUtils.formatNumber(prod.getPrice());
			default:
				return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	// Metodos Auxiliares
	
	public ProductModel getItem(int index) {
		return items.get(index);
	}
	
	public List<ProductModel> getItems() {
		return items;
	}
	
	public void setItems(List<ProductModel> items) {
		this.items = items;
		fireTableDataChanged();
	}
	
	public void addItem(ProductModel item) {
		items.add(item);
		fireTableDataChanged();
	}
	
	public void removeItem(ProductModel item) {
		items.remove(item);
		fireTableDataChanged();
	}
	
	public void removeItem(int index) {
		items.remove(index);
		fireTableDataChanged();
	}
	
}
