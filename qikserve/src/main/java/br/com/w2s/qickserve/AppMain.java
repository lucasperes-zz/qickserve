package br.com.w2s.qickserve;

import br.com.w2s.qickserve.model.OrderModel;
import br.com.w2s.qickserve.utils.MessagesUtils;
import br.com.w2s.qickserve.utils.SessionApp;
import br.com.w2s.qickserve.view.HomeView;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class AppMain {
	
	/**
	 * Main
	 */
	public static void main(String[] args) {
		try {
			// Inicia a sessao
			SessionApp session = SessionApp.setInstance();
			session.setOrderOpen(new OrderModel());
			
			HomeView view = new HomeView();
			view.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			MessagesUtils.showMessageError("Erro ao tentar iniciar o aplicativo. " + e.getMessage());
		}
	}
}
