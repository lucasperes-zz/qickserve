package br.com.w2s.qickserve.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author Lucas P. Soares (lucasperes20@gmail.com)
 * @date 6 de nov de 2020
 *
 */
public class AppUtils {
	
	public static final String URL_API = "http://localhost:8081";
	public static final BigDecimal BASE_PERCENT = new BigDecimal("100");

	public static final String formatNumber(BigDecimal value) {
		if(value == null) {
			value = BigDecimal.ZERO;
		}
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		
		return format.format(value);
	}
	
	public static BigDecimal calculatePercent(BigDecimal total, BigDecimal percent) {
		BigDecimal res = BigDecimal.ZERO;
		if(total != null && percent != null) {
			res = total.divide(BASE_PERCENT, 20, RoundingMode.HALF_EVEN).multiply(percent);
		}
		return round(res);
	}
	
	public static BigDecimal convertCentsOnReal(BigDecimal value) {
		BigDecimal res = BigDecimal.ZERO;
		if(value != null) {
			res = value.divide(BASE_PERCENT, 20, RoundingMode.HALF_EVEN);
		}
		return round(res);
	}
	
	public static BigDecimal round(BigDecimal value) {
		if(value != null) {
			value = value.setScale(2, RoundingMode.HALF_EVEN);
		}
		
		return value;
	}
	
}
