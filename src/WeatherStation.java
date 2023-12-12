import java.util.ArrayList;

/**
 * Classe que representa uma estação climática, enviando suas informações para os objetos inscritos nela.
 */
public class WeatherStation {
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
    /**
     * Atributo que representa os objetos inscritos.
     */
    private ArrayList<Display> telasInscritas;

    /**
     * Construtor da classe, iniciando as variáveis necessárias.
     *
     * @param identificador (int)
     */
    public WeatherStation(int identificador) {
        setIdentificador(identificador);
        this.temperatura = gerarTemperatura();
        this.umidade = gerarUmidade();
        this.pressao = gerarPressao();
        telasInscritas = new ArrayList<Display>();
        CentralStation.adicionarEstacao(this);
    }

    /**
     * Gera um número aleatório de temperatura em graus Celsius.
     *
     * @return temperatura (double)
     */
    public double gerarTemperatura() {
        return Math.random() * 120 - 60;
    }

    /**
     * Gera um número aleatório de umidade em porcentagem.
     *
     * @return umidade (double)
     */
    public double gerarUmidade() {
        return Math.random() * 100;
    }

    /**
     * Gera um número aleatório de pressão em ATM.
     *
     * @return pressão (double)
     */
    public double gerarPressao() {
        return 1.0 / 3.0  +  Math.random() / 3.0 * 2.0;
    }

    /**
     * Enviar notificações para todos os objetos inscritos.
     */
    public void alteracoesNasMedicoes() {
        for (Display display : telasInscritas) {
            display.atualizar(this);
        }
    }

    /**
     * Inscreve um objeto Display.
     *
     * @param display (Display)
     */
    public void inscrever(Display display) {
        telasInscritas.add(display);
    }

    /**
     * Desinscreve um objeto display através do objeto em si.
     *
     * @param display (Display)
     */
    public void desinscrever(Display display) {
        telasInscritas.remove(display);
    }

    /**
     * Desinscreve um objeto display através de um index.
     *
     * @param index (int)
     */
    public void desinscrever(int index) {
        telasInscritas.remove(index);
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
        alteracoesNasMedicoes();
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
        alteracoesNasMedicoes();
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
        alteracoesNasMedicoes();
    }

    public ArrayList<Display> getTelasInscritas() {
        return telasInscritas;
    }

    public void setTelasInscritas(ArrayList<Display> telasInscritas) {
        this.telasInscritas = telasInscritas;
    }
}
