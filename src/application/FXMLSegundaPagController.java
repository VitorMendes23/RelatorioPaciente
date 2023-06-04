package application;


import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Data.Paciente;
import Domain.ManipulaDados;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class FXMLSegundaPagController implements Initializable{

	private ArrayList<Paciente> listaPacientes;
	
	
    @FXML
    private Button btn_GerarRelatorio;
    
    @FXML
    private Button btn_voltar;
    
    @FXML
    private javafx.scene.control.TextArea txt_relatorio;
    
    
	
    public void setArrayListListaPacientes(ArrayList<Paciente> listPaciente) {
        this.listaPacientes = listPaciente;
    }
	
	
    @FXML
    void handleGerarRelatorioButtonAction(ActionEvent event) {
    	// (a) Quantidade de pacientes
        int quantidadePacientes = ManipulaDados.quantidadePacientes(listaPacientes);
        
        // (b) Média de idade dos homens
        double mediaIdadeHomens = ManipulaDados.mediaIdadeHomens(listaPacientes);

        // (c) Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg
        int quantidadeMulheresAlturaPeso = ManipulaDados.quantidadeMulheresAtura160_170(listaPacientes);

        // (d) Quantidade de pessoas com idade entre 18 e 25
        int quantidadePessoasIdade = ManipulaDados.quantidadePessoasIdade18_25(listaPacientes);

        // (e) Nome do paciente mais velho
        String nomePacienteMaisVelho = ManipulaDados.getPacienteMaisVelho(listaPacientes);

        // (f) Nome da mulher mais baixa
        String nomeMulherMaisBaixa = ManipulaDados.getMulherMaisBaixa(listaPacientes);

        // (g) Lista de todos os pacientes ordenados por idade
        ArrayList<String> listaPacientesOrdenada = ManipulaDados.listaPacientesOrdenadosIdade(listaPacientes);
        
     // Montar o relatório com as informações obtidas
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório:\n");
        relatorio.append("- Quantidade de pacientes: ").append(quantidadePacientes).append("\n");
        relatorio.append("- Média de idade dos homens: ").append(mediaIdadeHomens).append("\n");
        relatorio.append("- Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg: ").append(quantidadeMulheresAlturaPeso).append("\n");
        relatorio.append("- Quantidade de pessoas com idade entre 18 e 25: ").append(quantidadePessoasIdade).append("\n");
        relatorio.append("- Nome do paciente mais velho: ").append(nomePacienteMaisVelho).append("\n");
        relatorio.append("- Nome da mulher mais baixa: ").append(nomeMulherMaisBaixa).append("\n");
        relatorio.append("- Lista de todos os pacientes ordenados por idade (novos primeiro):\n");

        for (String nome : listaPacientesOrdenada) {
            relatorio.append(nome).append("\n");
        }

        // Exibir o relatório em um elemento de texto na interface gráfica
        txt_relatorio.setText(relatorio.toString());
    	
    }
    
    @FXML
    void handleVoltarButtonAction(ActionEvent event) {
    	// Carregar a nova cena do relatório a partir do arquivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDucument.fxml"));
        Parent relatorioRoot;
        try {
            relatorioRoot = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Obter o palco (stage) a partir do evento do botão
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Criar uma nova cena com a raiz do relatório
        Scene relatorioScene = new Scene(relatorioRoot);

        // Definir a nova cena no palco
        stage.setScene(relatorioScene);
        stage.show();
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
