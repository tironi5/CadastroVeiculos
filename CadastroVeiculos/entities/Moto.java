package entities;

public class Moto extends Veiculo {
    private boolean partidaEletrica;
    private String placa;

    public Moto(String marca, String modelo, int ano, boolean partidaEletrica, String placa) {
        super(marca, modelo, ano);
        this.partidaEletrica = partidaEletrica;
        this.placa = placa;
    }

    // Getters e setters
    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Moto [placa=" + placa + ", partidaEletrica=" + partidaEletrica + ", " + super.toString() + "]";
    }
}
