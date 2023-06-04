package Data;

import java.util.Objects;

public class Paciente {

	private int codigo;
	private String nome;
	private double peso;
	private String genero;
	private int idade;
	private double altura;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public Paciente(int codigo, String nome, double peso, String genero, int idade, double altura) {
		this.codigo = codigo;
		this.nome = nome;
		this.peso = peso;
		this.genero = genero;
		this.idade = idade;
		this.altura = altura;
	}
	public Paciente() {
		this.codigo = 0;
		this.nome = "";
		this.peso = 0;
		this.genero = "";
		this.idade = 0;
		this.altura = 0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(altura, codigo, genero, idade, nome, peso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura) && codigo == other.codigo
				&& Objects.equals(genero, other.genero) && idade == other.idade && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}
	
	
	
	
}
