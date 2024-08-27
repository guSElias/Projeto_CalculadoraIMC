package model;

import java.util.Date;
import java.util.Objects;

public class CalculoIMC {
    private int id;
    private String cpfUsuario;
    private double peso;
    private double altura;
    private double imc;
    private Date dataConsulta;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpfUsuario() {
		return cpfUsuario;
	}
	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(altura, cpfUsuario, dataConsulta, id, imc, peso);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalculoIMC other = (CalculoIMC) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(cpfUsuario, other.cpfUsuario) && Objects.equals(dataConsulta, other.dataConsulta)
				&& id == other.id && Double.doubleToLongBits(imc) == Double.doubleToLongBits(other.imc)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}
	
	@Override
	public String toString() {
		return "CalculoIMC [id=" + id + ", cpfUsuario=" + cpfUsuario + ", peso=" + peso + ", altura=" + altura
				+ ", imc=" + imc + ", dataConsulta=" + dataConsulta + "]";
	}
	
	public CalculoIMC(int id, String cpfUsuario, double peso, double altura, double imc, Date dataConsulta) {
		super();
		this.id = id;
		this.cpfUsuario = cpfUsuario;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
		this.dataConsulta = dataConsulta;
	}
	
	public CalculoIMC() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}