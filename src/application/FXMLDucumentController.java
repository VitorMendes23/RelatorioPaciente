package application;


import java.net.URL;
import java.util.ResourceBundle;

import Data.ControleDados;
import Data.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FXMLDucumentController implements Initializable{
	
	ControleDados controleDados = new ControleDados();
	private Set<Integer> codigosGerados = new HashSet<>();

	 
    @FXML
    private Button btn_sair;

    @FXML
    private ComboBox<String> cbx_genero;

    @FXML
    private Button btn_novo;

    @FXML
    private TextField txt_peso;

    @FXML
    private TextField txt_codigo;

    @FXML
    private TextField txt_altura;

    @FXML
    private Button btn_relatorio;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_idade;

    @FXML
    void handleNovoButtonAction(ActionEvent event) {

    	
        String nome = txt_nome.getText();
        String pesoText = txt_peso.getText();
        String genero = cbx_genero.getSelectionModel().getSelectedItem();
        String idadeText = txt_idade.getText();
        String alturaText = txt_altura.getText();

        // Verificar se os campos estão preenchidos
        if ( nome.isEmpty() || pesoText.isEmpty() ||
            genero == null || idadeText.isEmpty() || alturaText.isEmpty()) {
            // Exibir uma mensagem de erro ou executar outra ação apropriada
            System.out.println("Preencha todos os campos antes de adicionar um paciente.");
            return; // Interromper o processamento do método
        }

        // Converter os campos para os tipos apropriados
        int codigo = Integer.parseInt(txt_codigo.getText());
        double peso = Double.parseDouble(pesoText);
        int idade = Integer.parseInt(idadeText);
        double altura = Double.parseDouble(alturaText);
    	
        Paciente paciente = new Paciente(codigo, nome, peso, genero, idade, altura);

    	
    	gravarDados(paciente);
    	
    	 // Limpar os campos de texto
        txt_codigo.setText(Integer.toString(gerarCodigoUnico()));
        txt_nome.clear();
        txt_peso.clear();
        txt_idade.clear();
        txt_altura.clear();

        // Limpar a seleção do combobox
        cbx_genero.setValue(null);
    }
    
    private int gerarCodigoUnico() {
        Random random = new Random();

        // Gerar um novo código até encontrar um que seja único
        while (true) {
            int codigo = random.nextInt(9000) + 1000; // Gerar um número entre 1000 e 9999

            if (!codigosGerados.contains(codigo)) {
                codigosGerados.add(codigo);
                return codigo;
            }
        }
    }
    
    @FXML
    void handleRelatorioButtonAction(ActionEvent event) {

    	 // Carregar a nova cena do relatório a partir do arquivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSegundaPag.fxml"));
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
        
        // Obter a referência para o controlador da segunda tela
        FXMLSegundaPagController segundaPagController = loader.getController();

        // Passar o ArrayList para o controlador da segunda tela
        segundaPagController.setArrayListListaPacientes(this.controleDados.getListaPacientes());
        
        // Definir a nova cena no palco
        stage.setScene(relatorioScene);
        stage.show();
    }
    
    @FXML
    void handleSairButtonAction(ActionEvent event) {
    	System.out.println("programa encerrando...");
    	System.exit(0);

    }
    
    private void gravarDados(Paciente paciente) {
        //  lógica para gravar os dados 
    	
    	if(!controleDados.getListaPacientes().contains(paciente)) {
        	controleDados.acionaPaciente(paciente);
        	System.out.println("paciente adicionado sem erro");
    	}else {
        	System.out.println("não adicionado");
    	}

    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	cbx_genero.getItems().add("Masculino");
    	cbx_genero.getItems().add("Feminino");
        txt_codigo.setEditable(false);
        // Gerar um código de 4 dígitos aleatório
        String codigoGerado = Integer.toString(gerarCodigoUnico());

        // Definir o código gerado no campo "código"
        txt_codigo.setText(codigoGerado);


    	
    }    
}
