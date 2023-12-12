import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherStation estacao_1 = new WeatherStation(1);
        WeatherStation estacao_2 = new WeatherStation(2);

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();

        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("1 - Mudar tudo - Estação 1;");
            System.out.println("2 - Mudar tudo - Estação 2;");
            System.out.println("3 - Mostrar tudo;");
            System.out.println("4 - Inscrever uma estação;");
            System.out.println("5 - Sair.");
            escolha = Integer.parseInt(sc.nextLine());
            switch (escolha) {
                case 1 -> {
                    estacao_1.setTemperatura(estacao_1.gerarTemperatura());
                    estacao_1.setUmidade(estacao_1.gerarUmidade());
                    estacao_1.setPressao(estacao_1.gerarPressao());
                }
                case 2 -> {
                    estacao_2.setTemperatura(estacao_2.gerarTemperatura());
                    estacao_2.setUmidade(estacao_2.gerarUmidade());
                    estacao_2.setPressao(estacao_2.gerarPressao());
                }
                case 3 -> System.out.println(currentConditionsDisplay.mostrarDados());
                case 4 -> {
                    System.out.println("Identificador da estação que será inscrita:");
                    currentConditionsDisplay.inscrever(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> {
                    System.out.println("Tchau");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Escolha inválida!");
            }
        } while (true);


    }
}
