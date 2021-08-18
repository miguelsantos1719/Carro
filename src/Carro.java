/**
 * A classe Carro cont�m m�todos para visualizar e alterar a quantidade de combust�vel e simular um carro em andamento.
 * 
 * <ul>
 * <li>meterCombustivel</li>
 * <li>meterCombustivel</li>
 * <li>andar</li>
 * <li>parar</li>
 * <li>obterAutonomia</li>
 * </ul>
 * 
 * @author miguelsantos
 *
 */
public class Carro {
	
	static private final double consumo=5.5; // litros por 100 klm
	
	private double quantidadeCombustivel;
	private double capacidadeDeposito;
	
	// Construtor por defeito 
	public Carro() {
		super();
	
		quantidadeCombustivel = 0;
		capacidadeDeposito = 40.0;
	}
	
	// Acessores 

	public static double getConsumo() {
		return consumo;
	}

	public double getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	public double getCapacidadeDeposito() {
		return capacidadeDeposito;
	}
	
	// M�todos 
	/**
	 * Calcula a quantidade de combustivel com que o carro ir� ficar depois do utilizador abastecer com a quantidade pretendida.
	 * 
	 * @param quantidade valor da quantidade de combustivel a ser introduzido.
	 */
	public void meterCombustivel( double quantidade) { 		
		
		// Devia testar se Transborda o dep�sito
		// Podia retornar os Litros Metidos 
		quantidadeCombustivel = quantidadeCombustivel + quantidade;
		
		
	}
	
	
	/**
	 * Calcula a quantidade de combustivel que ainda � poss�vel meter para encher o dep�sito.
	 * 
	 * @return retorna o valor de litros a meter para atestar o dep�sito.
	 */
	// atestar o dep�sito
	public double meterCombustivel() {
		
		double litrosMeter = capacidadeDeposito - quantidadeCombustivel;
		
		// ou quantidadeCombustivel = capacidadeDeposito;
		meterCombustivel(litrosMeter);
		
		return litrosMeter;
	}
	
	/**
	 * Calcula e verifica se � poss�vel andar a dist�ncia pretendida tendo em conta a quantidade de combust�vel.
	 * 
	 * @param distancia valor da dist�ncia pretendida a ser percorrida.
	 * @return retorna o resultado sobre se � poss�vel andar.
	 */
	// distancia em klm
	public boolean andar( double distancia ) {
		
		// Verificar se tem combustivel para a distancia que se pretende andar 
		if( distancia < obterAutonomia() ) {
			
			quantidadeCombustivel -= getConsumo() * (distancia / 100); 
			return true;
		}
		else {
			
			// Aqui ou simplesmente n�o percorre qualquer distancia 
			// ou anda at� parar porque fica sem combust�vel 
			return false;
		}
			
			
	}
	
	/**
	 * Faz o carro parar.
	 * 
	 * @return o valor para fazer o carro parar.
	 */
	public boolean parar() {
		
		// se estiver a andar p�ra 
		// falta a flag que indica se o carro est� em andamento
		return true;
	}
	
	
	/**
	 * Calcula a autonomia do carro.
	 * 
	 * @return retorna o valor da autonomia do carro.
	 */
	// kmCombustivel( )
	public double obterAutonomia() {
		
		return ( quantidadeCombustivel / getConsumo() ) * 100;
		
	}

}
