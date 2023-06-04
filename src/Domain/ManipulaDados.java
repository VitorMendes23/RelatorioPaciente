package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Data.Paciente;

public class ManipulaDados {
	
	public static int quantidadePacientes(ArrayList<Paciente> listaPaciente) {
		
		return listaPaciente.size();
	}

	public static double mediaIdadeHomens(ArrayList<Paciente> listaPaciente) {
		int totalIdade = 0;
		int quantHomem = 0;

        for (Paciente pessoa : listaPaciente) {
        	
        	if(pessoa.getGenero() == "Masculino") {
        		totalIdade += pessoa.getIdade();
        		quantHomem++;
        	}
        	
        }
        
        if(quantHomem >0)
        	return (double) totalIdade / quantHomem;
        else
        	return 0;
		
	}
	
	public static int quantidadeMulheresAtura160_170(ArrayList<Paciente> listaPaciente) {
		int quantMulher = 0;
		
		for (Paciente pessoa : listaPaciente) {
        	
        	if((pessoa.getGenero() == "Feminino") && (pessoa.getAltura() < 1.70) && (pessoa.getAltura() > 1.60) && (pessoa.getPeso() > 70)) {
        		quantMulher++;
        	}
        	
        }
		
		return quantMulher;
	}
	
	public static int quantidadePessoasIdade18_25(ArrayList<Paciente> listaPaciente) {
		int quant = 0;
		
		for (Paciente pessoa : listaPaciente) {
        	
        	if( pessoa.getIdade() < 25 && pessoa.getIdade() > 18  ) {
        		quant++;
        	}
        	
        }
		
		
		return quant;
	}
	
	public static String getPacienteMaisVelho(ArrayList<Paciente> listaPaciente) {
		String nome = "";
		int idade = 0;
		
		for (Paciente pessoa : listaPaciente) {
        	
        	if( pessoa.getIdade() > idade) {
        		nome = pessoa.getNome();
        		idade = pessoa.getIdade();
        	}
        	
        }
		
		
		return nome;
	}
	
	public static String getMulherMaisBaixa(ArrayList<Paciente> listaPaciente) {
		String nome = "";
		double tamanho = 0;

		for (Paciente pessoa : listaPaciente) {
        	
        	if( pessoa.getAltura() > tamanho && pessoa.getGenero() == "Feminino") {
        		nome = pessoa.getNome();
        		tamanho = pessoa.getAltura();
        	}
        	
        }
		
		return nome;
	}
	
	public static ArrayList<String> listaPacientesOrdenadosIdade(ArrayList<Paciente> listaPaciente) {
		
		ArrayList<String> nomes = new ArrayList<>();
	    
	    Collections.sort(listaPaciente, Comparator.comparingInt(Paciente::getIdade));
	    
	    for (Paciente paciente : listaPaciente) {
	        nomes.add(paciente.getNome());
	    }
	    
	    return nomes;
		
	}
	
}
