package br.com.confidencecambio.javabasico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.dto.GerenteDto;
import br.com.confidencecambio.javabasico.service.ConversorService;

@RestController
public class GerenteController {

	@Autowired
	private ConversorService conversor;

	@RequestMapping(value = "/gerente", method = RequestMethod.GET)
	public ResponseEntity<GerenteDto> retornaGerente(@RequestParam(value = "nome", required = true) String nome) {

		GerenteDto gerente = new GerenteDto();
		ResponseEntity<GerenteDto> response = null;
		if (conversor.validaNome(nome)) {
			gerente.setNomeAbreviado(conversor.converterNomeAbreviado(nome));
			gerente.setNomeMaisculo(conversor.converterNomeCompleto(nome));
			gerente.setPrimeiroNome(conversor.converterPrimeiroNome(nome));
			gerente.setUltimoNome(conversor.converterUltimoNome(nome));
			response = new ResponseEntity<>(gerente, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
