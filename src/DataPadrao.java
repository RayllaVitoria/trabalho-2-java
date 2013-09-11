

/**
 * @author Zyon Dias
 * RA 2401321
 * 
 * Classo para Data onde tera as regras de negocio para o tipo datapadrao
 *
 */
public class DataPadrao {
	private int dia;
	private int mes;
	private int ano;
	
	//metodo construtor
	//o nome do metodo é sempre igual ao nome da class
	public DataPadrao(int dia, int mes, int ano)
	{
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}//fim do construtor
	
	//sobre carga de construtor
	public DataPadrao()
	{
		//construtor
	}
	
	//metodo setDia
	public void setDia(int dia)
	{
		this.dia = dia;
	}//fim setDia
	
	//getDia
	public int getDia()
	{
		return dia;
	}//fim getDia
	
	//set mes
	public void setMes(int mes)
	{
		this.mes = mes;
	}//fim setMes
	
	//getMes
	public int getMes()
	{
		return mes;
	}//fim getmes
	
	//setAno
	public void setAno(int ano)
	{
		this.ano = ano;
	}//fim setAno
	
	//getAno
	public int getAno()
	{
		return ano;
	}//fim getAno
	
	//retornar dataPadrao 
	//metodo nativo toString
	public String toString()
	{
		return  dia + "/"+mes+"/" + ano;
	}
	
	//validação de data
	
	//validando o dia
	public boolean validaDia()
	{
		if (this.dia >= 1 && this.dia <= 31)
		{
			if(this.mes == 2 && this.dia > 29)
			return false;
			
			else
				return true;
 		}
		else
 			return false;
	}
	//validacao do mes
	public boolean validaMes()
	{
		if(mes >= 1 && mes <=12)
		 return true;
		else
			return false;
	}
	
	//validacao do ano
	public boolean validaAno()
	{
		if(this.ano > 1900)
			return true;
		return false;
	}
}
