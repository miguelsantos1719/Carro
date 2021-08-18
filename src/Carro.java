/**
 * A classe Carro contém métodos para visualizar e alterar a quantidade de combustível e simular um carro em andamento.
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
	
	// Métodos 
	/**
	 * Calcula a quantidade de combustivel com que o carro irá ficar depois do utilizador abastecer com a quantidade pretendida.
	 * 
	 * @param quantidade valor da quantidade de combustivel a ser introduzido.
	 */
	public void meterCombustivel( double quantidade) { 		
		
		// Devia testar se Transborda o depósito
		// Podia retornar os Litros Metidos 
		quantidadeCombustivel = quantidadeCombustivel + quantidade;
		
		
	}
	
	
	/**
	 * Calcula a quantidade de combustivel que ainda é possível meter para encher o depósito.
	 * 
	 * @return retorna o valor de litros a meter para atestar o depósito.
	 */
	// atestar o depósito
	public double meterCombustivel() {
		
		double litrosMeter = capacidadeDeposito - quantidadeCombustivel;
		
		// ou quantidadeCombustivel = capacidadeDeposito;
		meterCombustivel(litrosMeter);
		
		return litrosMeter;
	}
	
	/**
	 * Calcula e verifica se é possível andar a distância pretendida tendo em conta a quantidade de combustível.
	 * 
	 * @param distancia valor da distância pretendida a ser percorrida.
	 * @return retorna o resultado sobre se é possível andar.
	 */
	// distancia em klm
	public boolean andar( double distancia ) {
		
		// Verificar se tem combustivel para a distancia que se pretende andar 
		if( distancia < obterAutonomia() ) {
			
			quantidadeCombustivel -= getConsumo() * (distancia / 100); 
			return true;
		}
		else {
			
			// Aqui ou simplesmente não percorre qualquer distancia 
			// ou anda até parar porque fica sem combustível 
			return false;
		}
			
			
	}
	
	/**
	 * Faz o carro parar.
	 * 
	 * @return o valor para fazer o carro parar.
	 */
	public boolean parar() {
		
		// se estiver a andar pára 
		// falta a flag que indica se o carro está em andamento
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
