package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Component;

@Component
public class IMCService {

	public double calculaIMC(double altura, double peso) {
		var imc = peso / (altura * altura);
		return imc;
	}

}
