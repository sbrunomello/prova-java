package br.com.confidencecambio.javabasico.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.IMCService;

@RestController
public class IMCController {

	@Autowired
	private IMCService service;

	@RequestMapping(value = "/imc", method = RequestMethod.GET)
	public ResponseEntity<String> calculoIMC(@RequestParam(value = "peso", required = true) double peso,
			@RequestParam(value = "altura", required = true) double altura) {

		double calculo = service.calculaIMC(altura, peso);
		DecimalFormat df = new DecimalFormat("##.00");
		String imc = df.format(calculo);
		String retorno = "Seu IMC é: " + imc;
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

}
