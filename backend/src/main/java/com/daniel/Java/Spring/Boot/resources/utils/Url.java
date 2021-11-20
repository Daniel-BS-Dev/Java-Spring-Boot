package com.daniel.Java.Spring.Boot.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Url {
	
	//se o usuario colocar espaço no meu nome eu tenho que decodificar por ele ficara id20%carro
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		}
		catch(UnsupportedEncodingException e) {
			return "";
		}
	}
	
	
	// pegando o numeros da minha url transformando em long e returnando e return 
	public static List<Long> decodeIntList(String s){
		String[] vet = s.split(",");
		List<Long> list = new ArrayList<>();
		for(int i=0; i<vet.length; i++) {
			list.add(Long.parseLong(vet[i]));
		}
		
		return list;
	}

}
