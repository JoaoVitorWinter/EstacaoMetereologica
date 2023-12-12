/**
 * Classe que armazena informações meterológicas de um certo momento
 */
public class WeatherData {
    /**
     * Atributo representando o identificador da estação.
     */
    private int identificador;
    /**
     * Atributo representando a temperatura na estação.
     */
    private double temperatura;
    /**
     * Atributo representando a umidade na estação.
     */
    private double umidade;
    /**
     * Atributo representando a pressão na estação.
     */
    private double pressao;

    public WeatherData(int identificador, double temperatura, double umidade, double pressao) {
        setIdentificador(identificador);
        setTemperatura(temperatura);
        setUmidade(umidade);
        setPressao(pressao);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
}
