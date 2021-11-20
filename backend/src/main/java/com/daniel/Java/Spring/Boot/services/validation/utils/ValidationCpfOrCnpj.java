package com.daniel.Java.Spring.Boot.services.validation.utils;

public class ValidationCpfOrCnpj {
	
	//CPF
	private static final int[] weightSam = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

	//CNPJ
	private static final int[] weightTim = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};


private static int cal(final String str, final int[] weight) {
	int sum = 0;
	for(int i = str.length() - 1, digit; i >= 0; i--) {
		digit = Integer.parseInt(str.substring(i, i+ 1));
		sum += digit * weight[weight.length - str.length() + i];
	}
	
	sum = 11 - sum % 11;
	return sum > 9 ? 0 : sum;
}

public static boolean isValidCPF(final String ssm) {
	if((ssm == null) || (ssm.length() != 11) || ssm.matches(ssm.charAt(0) + "{11}")) return false;
	
	final Integer digit1 = cal(ssm.substring(0,9), weightSam);
	final Integer digit2 = cal(ssm.substring(0,9) + digit1, weightSam);
	return ssm.equals(ssm.substring(0,9) + digit1.toString() + digit2.toString());
}

public static boolean isValidCNPJ(final String tin) {
	if((tin == null) || (tin.length() != 14) || tin.matches(tin.charAt(0) + "{14}")) return false;
	
	final Integer digit1 = cal(tin.substring(0,12), weightTim);
	final Integer digit2 = cal(tin.substring(0,12) + digit1, weightTim);
	return tin.equals(tin.substring(0,12) + digit1.toString() + digit2.toString());
}

}
