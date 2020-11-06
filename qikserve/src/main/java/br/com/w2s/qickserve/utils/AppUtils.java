package br.com.w2s.qickserve.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class AppUtils {

	public static final String formatNumber(BigDecimal value) {
		if(value == null) {
			value = BigDecimal.ZERO;
		}
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		
		return format.format(value);
	}
	
}
