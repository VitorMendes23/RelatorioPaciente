package Data;

import java.util.ArrayList;

public class ControleDados {
	
	private static ArrayList<Paciente> listaPacientes;

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public static void setListaPacientes(ArrayList<Paciente> listaPacientesf) {
		listaPacientes = listaPacientesf;
	}

	public ControleDados(ArrayList<Paciente> listaPacientesf) {
		listaPacientes = listaPacientesf;
	}
	public  ControleDados() {
		listaPacientes = new ArrayList<>();
	}
	
	public void acionaPaciente(Paciente paciente) {
		listaPacientes.add(paciente);
		
	}
}
