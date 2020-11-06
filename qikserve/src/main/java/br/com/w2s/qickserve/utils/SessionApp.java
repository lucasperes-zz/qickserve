package br.com.w2s.qickserve.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.w2s.qickserve.model.OrderModel;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 5 de nov de 2020
 *
 */
public class SessionApp {
	
	private static SessionApp instance;
	// Values
	private OrderModel orderOpen;
	private List<OrderModel> ordersFinalize;
	
	/**
	 * Construtor privado para evitar instancia de fora
	 */
	private SessionApp() {
	}

	/**
	 * @return the instance
	 */
	public static SessionApp setInstance() {
		if(instance == null) {
			instance = new SessionApp();
		}
		
		return instance;
	}

	/**
	 * @return the orderOpen
	 */
	public OrderModel getOrderOpen() {
		return orderOpen;
	}

	/**
	 * @param orderOpen the orderOpen to set
	 */
	public void setOrderOpen(OrderModel orderOpen) {
		this.orderOpen = orderOpen;
	}

	/**
	 * @return the ordersFinalize
	 */
	public List<OrderModel> getOrdersFinalize() {
		return ordersFinalize;
	}
	
	public void addOrder(OrderModel order) {
		if(ordersFinalize == null) {
			ordersFinalize = new ArrayList<>();
		}
		ordersFinalize.add(order);
	}
	
	public void addOrder() {
		addOrder(orderOpen);
	}
	
}
