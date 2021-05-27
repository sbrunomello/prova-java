package br.com.confidencecambio.javabasico.dto;

public class RoboDto {
	
	private String primeiroNome;
	private String ultimoNome;
	private String nomeMaisculo;
	private String nomeAbreviado;
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public String getNomeMaisculo() {
		return nomeMaisculo;
	}
	public void setNomeMaisculo(String nomeMaisculo) {
		this.nomeMaisculo = nomeMaisculo;
	}
	public String getNomeAbreviado() {
		return nomeAbreviado;
	}
	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

}
