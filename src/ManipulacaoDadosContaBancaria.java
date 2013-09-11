
/**
 * @author Zyon Dias 
 * RA2401321
 * Classe de persistencia e manipulacao de dados.
 * aqui tera os selects e updates necessarios para Conta bancaria.
 * 
 * Esse exercicio serve para demostra uma class de persistencia solicidada no 
 * QUESTAO 5 Do trabalho
 */

//importando as bibliotecas
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ManipulacaoDadosContaBancaria {
	
	//criando objeto para fazer seleçaõ do dado
    private PreparedStatement comando;	
    //string com que ira receber as qury a serem executadas
    private String query;
    //variavel de conexao utilizada em toda classe
    private Connection conn;

	//metodo construtor
	public ManipulacaoDadosContaBancaria()throws Exception
	{
		//criando objeto de banco de dados 
		ConexaoDB db = new ConexaoDB();
		//acrindo conexao
		conn = db.criarConexao();
	}//fim do metodo construtor
	
	//metodo para pegar o saldo da conta bancaria
	public double selectSaldo(int codConta) throws Exception
	{
		double saldo = 0;
		//escrevendo query de seleão do saldo
		query = "SELECT saldo FROM Conta WHERE codConta = ?";	
		//iniciando comando que vai ser executado
		comando = conn.prepareStatement(query);
		//passando parametro para query
		comando.setInt(1, codConta);
		//pegando resultado
		ResultSet result = comando.executeQuery();
		//int v = rs.getInt("idRemedio"); 
		while (result.next()) {
			saldo = result.getDouble(1);
			
		}
		
		return saldo;
	}//fim do metodo para pegar o saldo da conta bancaria
	
	//metodo para atualizar saldo da conta
	public void atualizarSaldo(int codConta, double novoSaldo)throws Exception
	{
		//escrevendo query para fazer o update do saldo
		query = "UPDATE conta set saldo = ? where codConta = ?";
		//iniciando comando que vai ser executado
		comando = conn.prepareStatement(query);
		//passando os parametros para query
		comando.setDouble(1, novoSaldo);
		comando.setInt(2, codConta);
		
		//executando o comando
		comando.execute();
		
		//setando a data de movimetnacao no banco de dadoss
		setUltimaMovimetacao(codConta);
		
	}//fim do metodo para atulizar dado
	
	//mnetodo para pegar a data de movimentacao da conta
	public String dataDeUltimaMovimentacao(int codConta) throws Exception
	{
		String dtMovimetacao = "00000000";
		//escrevendo  query para fazer o select
		query = "SELECT dtUltiMovitacao FROM conta WHERE codConta = ?";
		//iniciando comando que vai ser executada
		comando = conn.prepareStatement(query);
		//passando parametros para query
		comando.setInt(1, codConta);
		
		//pegando resultado
		ResultSet result = comando.executeQuery(); 
		while (result.next()) {
			dtMovimetacao = result.getDate(1).toString();	
		}
		return dtMovimetacao ;
	}
	
	//metodo para registra data de movimentacao
    private void setUltimaMovimetacao(int codConta) throws Exception {
    	//obtendo a data do sistema
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        //escrevendo query para fazer update na data
        query = "UPDATE conta set dtUltiMovitacao = ? where codConta = ?;";
        //iniciando comando que vai ser executado
      	comando = conn.prepareStatement(query);
      	//passando os parametros para query
  		comando.setString(1, dateFormat.format(date));
  		comando.setInt(2, codConta);
  		//executando comando
  		comando.execute();  		
      	
    }//fim do metodo para pegar data
    
    
  //mnetodo para pegar a data do ultimo deposito
  	public String dataDoUltimoDeposito(int codConta) throws Exception
  	{
  		String dtDeposito = "00000000";
  		//escrevendo  query para fazer o select
  		query = "SELECT dtUltiDeposito FROM conta WHERE codConta = ?";
  		//iniciando comando que vai ser executada
  		comando = conn.prepareStatement(query);
  		//passando parametros para query
  		comando.setInt(1, codConta);
  		
  		//pegando resultado
  		ResultSet result = comando.executeQuery(); 
  		while (result.next()) {
  			dtDeposito = result.getDate(1).toString();	
  		}
  		return dtDeposito ;
  	}
  	
  	//metodo para registra data Deposito
      public void setUltimoDeposito(int codConta) throws Exception {
      	//obtendo a data do sistema
          DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
          Date date = new Date();
          //escrevendo query para fazer update na data
          query = "UPDATE conta set dtUltiDeposito = ? where codConta = ?;";
          //iniciando comando que vai ser executado
        	comando = conn.prepareStatement(query);
        	//passando os parametros para query
    		comando.setString(1, dateFormat.format(date));
    		comando.setInt(2, codConta);
    		//executando comando
    		comando.execute();  		
        	
      }//fim do metodo para pegar data
      
      //metodo para obter o tipo da conta
      public String getTipoConta(int codConta)throws Exception
      {
    	  String tipoConta = "";
    		//escrevendo  query para fazer o select
    		query = "SELECT tipoDeConta FROM conta WHERE codConta = ?";
    		//iniciando comando que vai ser executada
    		comando = conn.prepareStatement(query);
    		//passando parametros para query
    		comando.setInt(1, codConta);
    		
    		//pegando resultado
    		ResultSet result = comando.executeQuery(); 
    		while (result.next()) {
    			tipoConta = result.getString(1);	
    		}
    		return tipoConta ;
      }//fim do metodo para obter o tipo de conta
}
