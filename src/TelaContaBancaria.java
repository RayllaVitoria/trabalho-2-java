
/**
 * 
 *
 * @author Zyon Dias 
 * RA2401321
 * 
 * Classe para montar layout da tela e ultilar as class com as regras de negocios referente a conta bancaria
 *
 */



//importando as bibliotecas
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaContaBancaria  extends JFrame {

	
	//Definino as propriedades da label
	private JLabel lTipoConta;
	private JLabel lSaldo;
	private JLabel lUltMovimetacao;
	private JLabel lUltDeposito;
	private JLabel lDebitar;
	private JLabel lCredita;
	
	//definindo campos de texto
	private JTextField tfSaldo;
	private JTextField tfValorDebitar;
	private JTextField tfValorCreditar;
	
	//botoes 
	private JButton btDebitar;
	private JButton btCreditar;

	//definindo propriedades dos objetos conta correte e poupanca
	private ContaPoupanca cp;
	private ContaCorrente cc;
	
	//tipo da conta que usuario informou
	private String tipoConta;
	private int codConta;
	
	//metodo construtor
	public TelaContaBancaria(String TipoConta, int CodConta)
	{
		setLayout(new FlowLayout());//defindo o tipo de layout
		//pegando os dados usuarios informado e passando para propriedades
		this.tipoConta = TipoConta;
		this.codConta = CodConta;
		
		//estanciando class
		try
		{
			//verificando qual conta que o usuário selecionou para estanciar o objeto correto
			if(tipoConta.equals("cp"))
				cp = new ContaPoupanca(codConta);		
			else
				cc = new ContaCorrente(codConta);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro ao conectar no banco", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		//configurando propriedades
		tfSaldo = new JTextField(7);
		tfSaldo.setEditable(false);
		tfValorCreditar = new JTextField(7);
		tfValorDebitar = new JTextField(7);
		btCreditar = new JButton("Creditar");
		btDebitar = new JButton("Debitar");
		lSaldo = new JLabel("Seu saldo é: ");
		lCredita = new JLabel("Valor a Creditar: ");
		lDebitar = new JLabel("Valor a Debitar: ");
		
		try
		{
			//verificando o tipo da conta para fazer a confirugação correta das labels e para obter o saldo 
			//na TextField
			if(tipoConta.equals("cp"))
			{
				//configurando label para informa que é conta poupanca
				lTipoConta = new JLabel("Conta Poupança");
				//setando na label a data do ultimo deposito
				lUltDeposito = new JLabel("Data do Ultimo depoisto: "+ cp.getDataDeposito().toString());
				//setando no  text field o saldo da conta
				tfSaldo.setText("R$ "+cp.obterSaldo());
								
			}
			else//caso seja conta Corrente
			{
				//Configrando label para informar o tipo da conta que é Corrente
				lTipoConta = new JLabel("Conta Corrente");
				//setando na label a ultima movimentacao da conta
				lUltMovimetacao = new JLabel("Data da Ultima Movimentação: "+cc.getUltMov().toString());
				//setando na textFiel o saldo
				tfSaldo.setText("R$ "+cc.obterSaldo());
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro ao conectar no banco", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		//adcionando propriedades na tela
		add(lTipoConta);
		add(lSaldo);
		add(tfSaldo);
		if(tipoConta.equals("cp"))
			add(lUltDeposito);
		else
			add(lUltMovimetacao);
		
		add(lDebitar);
		add(tfValorDebitar);
		add(btDebitar);
		add(lCredita);
		add(tfValorCreditar);
		add(btCreditar);
		
		  //adiciona escutador (listener) aos botoes
	    Manipulador manipula = new Manipulador();
	    btDebitar.addActionListener(manipula);
	    btCreditar.addActionListener(manipula);
	}
	
	private class  Manipulador implements ActionListener{
		public void actionPerformed( ActionEvent evento ){
			//caso o botao debitar tenha sido precionado 
			if(evento.getSource()== btDebitar){
				//verificando o tipo da conta
				if(tipoConta.equals("cc"))
				{
					try{
						//estanciando a class conta corrente
						ContaCorrente cc = new ContaCorrente(codConta);
						//pegando o valor digitado na textField e colocando como parametro para o metodo
						//de debitar
						cc.debitar(Double.parseDouble(tfValorDebitar.getText()));
						//atualizando a label que mostra a ultima movimentacao
						lUltMovimetacao.setText("Data da Ultima Movimentação: "+cc.getUltMov().toString());
						//atualizando o text Field de saldo 
						tfSaldo.setText("R$: "+cc.obterSaldo());
						//limpando a text field onde o usuário tinha colocado o valor para ser debitado
						tfValorDebitar.setText("");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					try{
						//estanciando a class conta corrente
						ContaPoupanca cp = new ContaPoupanca(codConta);
						//pegando o valor digitado na textField e colocando como parametro para o metodo
						//de debitar
						cp.debitar(Double.parseDouble(tfValorDebitar.getText()));
						//atualizando a text Field com o saldo
						tfSaldo.setText("R$: "+cp.obterSaldo());
						//limpando a text field onde o usuário tinha colocado o valor para ser debitado
						tfValorDebitar.setText("");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			//verificando se o botao precionado foi creditar
			if(evento.getSource()== btCreditar){
			
				//verificando o tipo da conta
				if(tipoConta.equals("cc"))
				{
					try {
						//estanciando a class Conta Corrente
						ContaCorrente cc = new ContaCorrente(codConta);
						//utilizando o metodo de creditar passando como parametro o valor que esta na text filde de saldo
						cc.credtiar(Double.parseDouble(tfValorCreditar.getText()));
						//atuliando a label passando a data da ultima movimentacao
						lUltMovimetacao.setText("Data da Ultima Movimentação: "+cc.getUltMov().toString());
						//atualizando a text filde de saldo
						tfSaldo.setText("R$: "+cc.obterSaldo());
						//limpando a text Field onde o usuario digitou o valor para creditar
						tfValorCreditar.setText("");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					try {
						//estanciando a class Conta Poupanca
						ContaPoupanca cp = new ContaPoupanca(codConta);
						//utilizando o metodo de creditar passando como parametro o valor que esta na text filde de saldo
						cp.credtiar(Double.parseDouble(tfValorCreditar.getText()));
						//atualizando a label que informa a data do ultimo depoisto
						lUltDeposito.setText("Data do Ultimo depoisto: "+cp.getDataDeposito().toString());
						//atualizando a text fielde do saldo
						tfSaldo.setText("R$: "+cp.obterSaldo());
						//limpando  a text field onde foi digitado o valor para credita
						tfValorCreditar.setText("");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados", "erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		
		}
	   }
	}

