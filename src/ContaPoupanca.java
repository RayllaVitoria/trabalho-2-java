
/**
 * @author Zyon Dias
 * RA 2401321
 * 
 * Class com regras de negocios da conta poupanca que esta herdando da conta bancaria
 *
 */
public class ContaPoupanca extends ContaBancaria{
	
   //propriedades
   private DataPadrao dataDeposito;
   
	
	//metodo constrautor
	public ContaPoupanca(int codConta)throws Exception
	{
		super(codConta);
	}//fim do metodo construtor
	
	//get data de deposito
	public DataPadrao getDataDeposito() throws Exception
	{
		//estanciando o objeto data padrao 
		dataDeposito = new DataPadrao();
		//estanciando o objeto de manipulacao de dados
		ManipulacaoDadosContaBancaria dados = new ManipulacaoDadosContaBancaria();
		//pegando a data do ultimo depoisto
		String data = dados.dataDoUltimoDeposito(codConta);
		//passando a data para a variavel dataDepostio
		dataDeposito.setAno(Integer.parseInt(data.substring(0, 4)));
		dataDeposito.setMes(Integer.parseInt(data.substring(5, 7)));
		dataDeposito.setDia(Integer.parseInt(data.substring(8, 10)));
		//retornado a datapadrao
		return dataDeposito;
	}//fim do get data de deposito
	
	
	
	

}
