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
	
	
		//cliando um array de objetos para colocar a op��o de escolha da conta
		Object[] opcoes = {"Conta Poupan�a","Conta Corrente"};  
		//recebendo do usuario qual � o tipo da conta escolhida
		Object res = JOptionPane.showInputDialog(null, "Escolha qual � o tipo da sua conta:", "Selecao de Conta", JOptionPane.PLAIN_MESSAGE, null,opcoes,"");
		
		//simplificando nomeclatura para tipo de conta
		String tipoConta;		
		if(res.toString().equals("Conta Poupan�a"))
		   tipoConta = "cp";
		else
			tipoConta = "cc";
		//pegando o codigo da conta do cliente
		int codConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sua conta"));
		
		//chamando a class TelaContaBancaria passando os parametros informados pelo usu�rio
		TelaContaBancaria telaPessoa = new TelaContaBancaria(tipoConta, codConta);
		telaPessoa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPessoa.setSize(800,600);
		telaPessoa.setVisible(true);
		
	}




}
