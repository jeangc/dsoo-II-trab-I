package app.entity;

/*
Tolerância: o tempo que o veículo pode permanecer sem ser cobrado (por exemplo, 15 min.);
Período inicial: o tempo mínimo que será cobrado do veículo (por exemplo, 2 horas);
Valor inicial: valor cobrado pela permanência durante o período inicial;
Período adicional: intervalo de tempo considerado para tarifação após o período inicial (por exemplo, a cada 1 hora);
Valor adicional: valor pago por cada período adicional de permanência.
 */

public class SettingsEntity {

    private static SettingsEntity instance;

    private int toleranciaMinutos;
    private int periodoInicialMinutos;
    private float valorInicial;
    private int periodoMinutos;
    private float valorPeriodo;

    static public SettingsEntity getInstance() {
        if (instance == null) {
            instance = new SettingsEntity();
        }

        return instance;
    }

    public int getToleranciaMinutos() {
        return toleranciaMinutos;
    }

    public void setToleranciaMinutos(int toleranciaMinutos) {
        this.toleranciaMinutos = toleranciaMinutos;
    }

    public int getPeriodoInicialMinutos() {
        return periodoInicialMinutos;
    }

    public void setPeriodoInicialMinutos(int periodoInicialMinutos) {
        this.periodoInicialMinutos = periodoInicialMinutos;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getPeriodoMinutos() {
        return periodoMinutos;
    }

    public void setPeriodoMinutos(int periodoMinutos) {
        this.periodoMinutos = periodoMinutos;
    }

    public float getValorPeriodo() {
        return valorPeriodo;
    }

    public void setValorPeriodo(float valorPeriodo) {
        this.valorPeriodo = valorPeriodo;
    }
}
