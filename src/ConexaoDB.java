/**
 * 
 */

/**
 * @author Zyon Dias
 * ra 2401321
 * Exercicio 2
 *
 * 
 * Class onde tera as confirgurações e criara a conexao com banco onde outras classes poderam consumir
 *
 */

import com.mysql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


public class ConexaoDB {
	//definindo as propriedades
	static final String DRIVER = "com.mysql.jdbc.Driver";//caminho de onde esta o drive para conectar com banco MySql
	static final String URL = "jdbc:mysql://127.0.0.1/exercicio2";//caminho onde esta o servidor com o mysql e a base de dados que vamos utlizar
	static final String USUARIO = "root";//usuario para o banco de dados
	static final String SENHA = "";//senha

	protected Connection conexao;//

	public ConexaoDB() throws Exception {
		//caregando o drive no construtor da classe
		Class.forName(DRIVER);
	}
	//metodo que abre a conexao e retorna ela para que as outras classes possam rodar as query
	public Connection criarConexao() throws java.sql.SQLException {
		//passando a conexao para nossa propriedade conexao
		conexao = DriverManager.getConnection(URL, USUARIO, SENHA);	
		// returnando a conexao
		return conexao;
	}
	
}
 
       