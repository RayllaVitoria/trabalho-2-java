
/**
 * @author Zyon Dias
 * Exercicio2
 * 
 * Class ira engloba toda regra de negocio da conta bancaria que sera uma class
 * super para outras class.
 *
 */


//importando as bibliotecas
import java.sql.Connection;
import java.sql.SQLException;


public class ContaBancaria {
	//propriedade da conta bancaria
	public int codConta;
	private double saldo;
	private String tipoDeConta;

	//Metodo construtor recebendo como parametro o codigo da conta
	public ContaBancaria(int codConta)throws Exception
	{
		super();
		//passando o codigo da conta recebido para a propriedade da class
		this.codConta = codConta;
		//pegando o tipo de conta 
		ManipulacaoDadosContaBancaria dados = new ManipulacaoDadosContaBancaria();
		tipoDeConta = dados.getTipoConta(codConta);
		
	}//fim do metodo construtor
	
	//metodo setSaldo, esta em modo privado pois sera utilizado somente internamento por motivo de serguraca
	//para classes externas o modo de setar sealdo vai ser via creditar e debitar saldo.
	private void setSaldo(double saldo)throws Exception
	{
		//criando objeto de manipulacao de dados
		ManipulacaoDadosContaBancaria dados = new ManipulacaoDadosContaBancaria();
		dados.atualizarSaldo(codConta, saldo);	
	}//fim do metodo para setSaldo
	
	//sobre carga do metodo para setar saldo caso seja deposito em conta poupaca
	private void setSaldo(double saldo, boolean DepositoPoupaca)throws Exception
	{
		//criando objeto de manipulacao de dados
		ManipulacaoDadosContaBancaria dados = new ManipulacaoDadosContaBancaria();
		dados.atualizarSaldo(codConta, saldo);	
		dados.setUltimoDeposito(codConta);
	}//fim do metodo sobrecarga de setSaldo
	
	//metodo get para o saldo
	public double obterSaldo() throws Exception
	{
		//criando objeto de manipulacao de dados
		ManipulacaoDadosContaBancaria dados = new ManipulacaoDadosContaBancaria();
		saldo = dados.selectSaldo(codConta);
		return saldo;
	}//fim do metodo obterSaldo
	
	//metodo para creditar saldo
	public void credtiar(double valorACreditar) throws Exception
	{
		//obtendo o valor atual do saldo da conta
		saldo = obterSaldo();
		//somando o valor atual com o valor que vai ser creidtado
		saldo = saldo + valorACreditar;
		//setando o novo saldo da conta
		if(tipoDeConta.equals("cp"))
			setSaldo(saldo, true);	
		else
			setSaldo(saldo);
	}//fim do metodo para creitar saldo
	
	//metodo para debitar
	public void debitar(double valorADebitar) throws Exception
	{
		//obtendo o valor atual do saldo da conta
		saldo = obterSaldo();		
		//subtraindo o saldo atual com o valor informado do debito
		saldo = saldo - valorADebitar;
		//setando o novo saldo na conta
		setSaldo(saldo);
	}//fim do metodo para debitar
	
	

}
