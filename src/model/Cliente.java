package model;

import javax.lang.model.element.NestingKind;

public class Cliente {

	private String nome;
	private int idade;
	private String cpf;
	private double altura;
	private double peso;
	private String senha;
	private double renda;
	
	
	public Cliente(String nome, int idade, String cpf, double altura, double peso, String senha, double renda) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.altura = altura;
		this.peso = peso;
		this.senha = senha;
		this.renda = renda;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", altura=" + altura + ", peso=" + peso
				+ ", senha=" + senha + ", renda=" + renda + "]";
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}



}
