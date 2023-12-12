import java.util.ArrayList;

/**
 * Classe que exibe as condições atuais das estações climáticas.
 */
public class CurrentConditionsDisplay implements Display {
    /**
     * Atributo que representa a lista de dados da tela.
     */
    private ArrayList<WeatherData> listaDados;

    /**
     * Construtor da classe, iniciando as variáveis.
     */
    public CurrentConditionsDisplay() {
        listaDados = new ArrayList<WeatherData>();
    }

    @Override
    public void atualizar(WeatherStation estacao) {
        for (WeatherData data : listaDados) {
            if (data.getIdentificador() == estacao.getIdentificador()) {
                data.setTemperatura(estacao.getTemperatura());
                data.setUmidade(estacao.getUmidade());
                data.setPressao(estacao.getPressao());
                break;
            }
        }
    }

    /**
     * Adiciona um objeto WeatherData.
     *
     * @param data (WeatherData)
     */
    public void adicionarDados(WeatherData data) {
        listaDados.add(data);
    }

    /**
     * Remove um objeto WeatherData através do objeto em si.
     *
     * @param data (WeatherData)
     */
    public void removerDados(WeatherData data) {
        listaDados.remove(data);
    }

    /**
     * Remove um objeto WeatherData através de um index.
     *
     * @param index (int)
     */
    public void removerDados(int index) {
        listaDados.remove(index);
    }

    /**
     * Inscreve um objeto Display na estação e adiciona um objeto WeatherData na classe.
     *
     * @param estacao (WeatherStation)
     */
    public void inscrever(WeatherStation estacao) {
        estacao.inscrever(this);
        adicionarDados(new WeatherData(estacao.getIdentificador(), estacao.getTemperatura(), estacao.getUmidade(), estacao.getPressao()));
    }

    /**
     * Inscreve um objeto Display na estação e adiciona um objeto WeatherData na classe.
     *
     * @param identificador (int)
     */
    public void inscrever(int identificador) {

        for (WeatherStation estacao : CentralStation.getListaEstacoes()) {
            if (estacao.getIdentificador() == identificador) {
                estacao.inscrever(this);
                adicionarDados(new WeatherData(estacao.getIdentificador(), estacao.getTemperatura(), estacao.getUmidade(), estacao.getPressao()));

            }
        }

    }

    /**
     * Desinscreve um objeto Display na estação e remove um objeto WeatherData na classe.
     *
     * @param estacao (WeatherStation)
     */
    public void desinscrever(WeatherStation estacao) {
        estacao.desinscrever(this);
        for (WeatherData data : listaDados) {
            if (data.getIdentificador() == estacao.getIdentificador()) {
                removerDados(data);
            }
        }
    }

    /**
     * Retorna uma String com todas as informações da tela.
     *
     * @return dados (String)
     */
    public String mostrarDados() {
        String dados = "";

        for (WeatherData data : listaDados) {
            dados += "\nID: " + data.getIdentificador()
                    + "\nTemperatura: " + (double) Math.round(data.getTemperatura() * 100) / 100  + "°C"
                    + "\nUmidade: " + (double) Math.round(data.getUmidade() * 100) / 100 + "%"
                    + "\nPressão: " + (double) Math.round(data.getPressao() * 100) / 100 + " ATM\n";
        }

        return dados;
    }
}
