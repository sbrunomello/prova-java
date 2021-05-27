package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ConversorService {

	public Boolean validaNome(String nome) {
		Boolean valido = false;
		if (!nome.endsWith(" ") && !nome.startsWith(" ") && !nome.equalsIgnoreCase(" ") && !nome.isEmpty()) {
			valido = true;
		}

		return valido;
	}

	public String converterPrimeiroNome(String nome) {
		String[] nomes = nome.split(" ");
		String retorno = nomes[0];

		return StringUtils.capitalize(retorno);
	}

	public String converterUltimoNome(String nome) {
		String ultimoNome = nome.substring(nome.indexOf(" ") + 1, nome.length());
		String nomes[] = ultimoNome.split(" ");
		String retorno = "";
		for (int i = 0; i < nomes.length; i++) {
			retorno = retorno + StringUtils.capitalize(nomes[i].toString() + " ");

		}

		return retorno;
	}

	public String converterNomeCompleto(String nome) {
		return nome.toUpperCase();
	}

	public String converterNomeAbreviado(String nome) {

		String nomes[] = nome.split(" ");
		int i;
		String retorno = "";
		for (i = 0; i < nomes.length; i++) {
			if (i == 0 || i == (nomes.length - 1)) {
				retorno = retorno + StringUtils.capitalize(nomes[i].toString() + " ");
			} else {

				retorno = retorno + StringUtils.capitalize(nomes[i].charAt(0) + ". ");
			}
		}
		return retorno;
	}

}
