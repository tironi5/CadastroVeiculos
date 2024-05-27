package entities;

public class Carro extends Veiculo {
    private String placa;

    public Carro() {
        super();
    }

    public Carro(String marca, String modelo, int ano, String placa) {
        super(marca, modelo, ano);
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa + "]";
    }
}
