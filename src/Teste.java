import model.Atendimento;

public class Teste {

	public static void main(String[] args) {
		
		
		System.out.println("Olá mundo");
		
		Atendimento atendimento = new Atendimento();
		
		atendimento.getVacina().setId_vacina(1);
		
		System.out.println(atendimento.getVacina().getId_vacina());

	}

}
