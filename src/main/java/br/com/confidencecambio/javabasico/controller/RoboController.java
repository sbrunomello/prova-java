package br.com.confidencecambio.javabasico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.dto.RoboDto;
import br.com.confidencecambio.javabasico.service.ConversorService;

@RestController
public class RoboController {

	@Autowired
	private ConversorService conversor;

	@RequestMapping(value = "/robo", method = RequestMethod.GET)
	public ResponseEntity<RoboDto> retornaRobo(@RequestParam(value = "nome", required = true) String nome) {

		RoboDto robo = new RoboDto();
		ResponseEntity<RoboDto> response = null;
		if (conversor.validaNome(nome)) {
			robo.setNomeAbreviado(conversor.converterNomeAbreviado(nome));
			robo.setNomeMaisculo(conversor.converterNomeCompleto(nome));
			robo.setPrimeiroNome(conversor.converterPrimeiroNome(nome));
			robo.setUltimoNome(conversor.converterUltimoNome(nome));
			response = new ResponseEntity<>(robo, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
