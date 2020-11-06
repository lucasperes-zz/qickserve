package br.com.w2s.qickserve.utils;

import javax.swing.JOptionPane;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class MessagesUtils {

	public static void showMessageInfo(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Informação do sistema", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showMessageWarn(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Aviso do sistema", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void showMessageError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro do sistema", JOptionPane.ERROR_MESSAGE);
	}
	
	public static boolean showMessageConfirm(String msg) {
		int resp = JOptionPane.showConfirmDialog(null, msg, "Erro do sistema", JOptionPane.OK_CANCEL_OPTION);
		return JOptionPane.OK_OPTION == resp;
	}
	
	public static String showMessageInput(String msg) {
		return JOptionPane.showInputDialog(null, msg, "Entrada de valores do sistema", JOptionPane.QUESTION_MESSAGE);
	}
	
}
