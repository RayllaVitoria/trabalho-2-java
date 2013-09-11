/*
 * Autor Zyon Dias
 * Ra 2401321
 * Exercio 2
 * Class que deve executa a tela no cliente
 */
import javax.swing.*;
import javax.swing.JFrame;

public class ExecutaTelaInteracao {	
	public static void main (String [] args){
	
	
		//cliando um array de objetos para colocar a opção de escolha da conta
		Object[] opcoes = {"Conta Poupança","Conta Corrente"};  
		//recebendo do usuario qual é o tipo da conta escolhida
		Object res = JOptionPane.showInputDialog(null, "Escolha qual é o tipo da sua conta:", "Selecao de Conta", JOptionPane.PLAIN_MESSAGE, null,opcoes,"");
		
		//simplificando nomeclatura para tipo de conta
		String tipoConta;		
		if(res.toString().equals("Conta Poupança"))
		   tipoConta = "cp";
		else
			tipoConta = "cc";
		//pegando o codigo da conta do cliente
		int codConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sua conta"));
		
		//chamando a class TelaContaBancaria passando os parametros informados pelo usuário
		TelaContaBancaria telaPessoa = new TelaContaBancaria(tipoConta, codConta);
		telaPessoa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPessoa.setSize(800,600);
		telaPessoa.setVisible(true);
		
	}




}
