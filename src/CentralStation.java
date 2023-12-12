import java.util.ArrayList;

/**
 * Classe que junta todas as outras estações, representando a estação central.
 */
public class CentralStation {
    /**
     * Atributo que representa o conjunto de estações.
     */
    static private ArrayList<WeatherStation> listaEstacoes = new ArrayList<WeatherStation>();

    static public ArrayList<WeatherStation> getListaEstacoes() {
        return listaEstacoes;
    }

    /**
     * Adiciona uma estação na lista.
     *
     * @param estacao (WeatherStation)
     */
    static public void adicionarEstacao(WeatherStation estacao) {
        listaEstacoes.add(estacao);
    }


}
