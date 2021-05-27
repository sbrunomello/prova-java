package br.com.confidencecambio.javabasico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.dto.ClienteDto;
import br.com.confidencecambio.javabasico.service.ConversorService;

@RestController
public class ClienteController {

	@Autowired
	private ConversorService conversor;

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public ResponseEntity<ClienteDto> retornaCliente(@RequestParam(value = "nome", required = true) String nome) {

		ClienteDto cliente = new ClienteDto();
		ResponseEntity<ClienteDto> response = null;
		if (conversor.validaNome(nome)) {
			cliente.setNomeAbreviado(conversor.converterNomeAbreviado(nome));
			cliente.setNomeMaisculo(conversor.converterNomeCompleto(nome));
			cliente.setPrimeiroNome(conversor.converterPrimeiroNome(nome));
			cliente.setUltimoNome(conversor.converterUltimoNome(nome));
			response = new ResponseEntity<>(cliente, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
