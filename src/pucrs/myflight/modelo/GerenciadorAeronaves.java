package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {
    
    private static GerenciadorAeronaves instance;

    private ArrayList<Aeronave> aero;   
    
    
    private GerenciadorAeronaves(){
        aero = new ArrayList<>();
    }

    public static GerenciadorAeronaves getInstance(){
        if(instance == null){instance = new GerenciadorAeronaves();}
        return instance;
    }

    public void adicionar(Aeronave a){
        aero.add(a);
    }

    public ArrayList<Aeronave> listarTodas(){
        return aero;
    }

    public Aeronave buscarPorCodigo(String cod){
        for(Aeronave a : aero){if(a.getCodigo().equals(cod)){return a;}}     
        return null;
    }
}
