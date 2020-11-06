package br.com.w2s.qickserve.tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.w2s.qickserve.model.ItemOrderModel;
import br.com.w2s.qickserve.utils.AppUtils;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class ItemsOrderTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 6435439189522450821L;

	private List<ItemOrderModel> items;
	private String[] columns = {"ID", "Produto", "Quantidade", "R$ Vl. Unitário", "R$ Subtotal", "R$ Desconto", "R$ Total"};
	
	public ItemsOrderTableModel(List<ItemOrderModel> items) {
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
		ItemOrderModel item = getItem(rowIndex);
		switch(columnIndex) {
			case 0:
				return item.getId();
			case 1:
				return item.getProduct().getName();
			case 2:
				return item.getQuantity();
			case 3:
				return AppUtils.formatNumber(item.getPriceUnity());
			case 4:
				return AppUtils.formatNumber(item.getSubtotal());
			case 5:
				return AppUtils.formatNumber(item.getDiscount());
			case 6:
				return AppUtils.formatNumber(item.getTotal());
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
	
	public ItemOrderModel getItem(int index) {
		return items.get(index);
	}
	
	public List<ItemOrderModel> getItems() {
		return items;
	}
	
	public void setItems(List<ItemOrderModel> items) {
		this.items = items;
		fireTableDataChanged();
	}
	
	public void addItem(ItemOrderModel item) {
		items.add(item);
		fireTableDataChanged();
	}
	
	public void removeItem(ItemOrderModel item) {
		items.remove(item);
		fireTableDataChanged();
	}
	
	public void removeItem(int index) {
		items.remove(index);
		fireTableDataChanged();
	}
	
}
