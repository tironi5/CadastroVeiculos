package services;

import entities.Carro;
import entities.Moto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VeiculoService {
    private List<Carro> carros;
    private List<Moto> motos;

    public VeiculoService() {
        carros = new ArrayList<>();
        motos = new ArrayList<>();
    }

    public void criarCarro(String marca, String modelo, int ano, String placa) {
        Carro carro = new Carro(marca, modelo, ano, placa);
        carros.add(carro);
    }

    public void criarMoto(String marca, String modelo, int ano, boolean partidaEletrica, String placa) {
        Moto moto = new Moto(marca, modelo, ano, partidaEletrica, placa);
        motos.add(moto);
    }

    public List<Carro> listarCarros() {
        return carros;
    }

    public List<Moto> listarMotos() {
        return motos;
    }

    public int contarVeiculos() {
        return carros.size() + motos.size();
    }

    public Carro procurarCarroPorPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    public Moto procurarMotoPorPlaca(String placa) {
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                return moto;
            }
        }
        return null;
    }

    public boolean removerVeiculoPorPlaca(String placa) {
        Iterator<Carro> carroIterator = carros.iterator();
        while (carroIterator.hasNext()) {
            Carro carro = carroIterator.next();
            if (carro.getPlaca().equals(placa)) {
                carroIterator.remove();
                return true;
            }
        }

        Iterator<Moto> motoIterator = motos.iterator();
        while (motoIterator.hasNext()) {
            Moto moto = motoIterator.next();
            if (moto.getPlaca().equals(placa)) {
                motoIterator.remove();
                return true;
            }
        }

        return false; // Veículo não encontrado com a placa especificada
    }
}
