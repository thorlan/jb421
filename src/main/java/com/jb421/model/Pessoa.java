package com.jb421.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Pessoa {

	private String nome;
	private String telefone;
	private int idade;
	
	public Pessoa(String nome, String telefone, int idade) {
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}
	
	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", telefone=" + telefone + ", idade=" + idade + "]";
	}
	
}
