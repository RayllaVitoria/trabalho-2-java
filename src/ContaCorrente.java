
/**
 * @author Zyon Dias
 *RA 2401321
 *Class com as regras de negocio de conta corrente que esta herdando da ContaBancaria
 */
public class ContaCorrente extends ContaBancaria {
	//propriedade
	private DataPadrao dtUltMov;
	
	//metodo construtor
	public ContaCorrente(int codConta)throws Exception
	{
		super(codConta);
	}
	
	//get data de ultima movimentacao
	public DataPadrao getUltMov() throws Exception
	{
		//estanciando o objeto data padrao 
		dtUltMov = new DataPadrao();
		//estanciando o objeto de manipulacao de dados
		ManipulacaoDadosContaBancaria dados = new ManipulacaoDadosContaBancaria();
		//pegando a data da ultima movimentacao
		String data = dados.dataDeUltimaMovimentacao(codConta);
		//passando a data para a variavel dtUltMov
		dtUltMov.setAno(Integer.parseInt(data.substring(0, 4)));
		dtUltMov.setMes(Integer.parseInt(data.substring(5, 7)));
		dtUltMov.setDia(Integer.parseInt(data.substring(8, 10)));
		//retornado a datapadrao
		return dtUltMov;
	}//fim do get data da ultima movimentacao

}
