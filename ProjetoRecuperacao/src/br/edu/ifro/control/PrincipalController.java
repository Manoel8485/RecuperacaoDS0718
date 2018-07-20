/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Carro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 01291187294
 */
public class PrincipalController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtNumero1;
    @FXML
    private TextField txtNumero2;
    @FXML
    private TextField txtResultado;
    @FXML
    private Button soma;
    @FXML
    private TextField txtCor;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtAno;
    @FXML
    private void handleButtonAction(ActionEvent event) {
       Double n1, n2, res;
       n1 = Double.parseDouble(txtNumero1.getText());
       n2 = Double.parseDouble(txtNumero2.getText());
       res = n1 + n2;
       txtResultado.setText(res.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void gravar(MouseEvent event){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em =emf.createEntityManager();
        
        Carro carro = new Carro();
        carro.setAno(Integer.parseInt(txtAno.getText()));
        carro.setCor(txtCor.getText());
        carro.setModelo(txtAno.getText());
        
        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
       
    }

    @FXML
    private void menos(MouseEvent event) {
          Double n1, n2, res;
       n1 = Double.parseDouble(txtNumero1.getText());
       n2 = Double.parseDouble(txtNumero2.getText());
       res = n1 - n2;
       txtResultado.setText(res.toString());
    }

    @FXML
    private void vezes(MouseEvent event) {
          Double n1, n2, res;
       n1 = Double.parseDouble(txtNumero1.getText());
       n2 = Double.parseDouble(txtNumero2.getText());
       res = n1 * n2;
       txtResultado.setText(res.toString());
    }

    @FXML
    private void dividir(MouseEvent event) {
          Double n1, n2, res;
       n1 = Double.parseDouble(txtNumero1.getText());
       n2 = Double.parseDouble(txtNumero2.getText());
       res = n1 / n2;
       txtResultado.setText(res.toString());
    }
    
}
