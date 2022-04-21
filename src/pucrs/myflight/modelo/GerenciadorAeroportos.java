package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {
    private static GerenciadorAeroportos instance;

    private ArrayList<Aeroporto> aero;   
    
    
    private GerenciadorAeroportos(){
        aero = new ArrayList<>();
    }

    public static GerenciadorAeroportos getInstance(){
        if(instance == null){instance = new GerenciadorAeroportos();}
        return instance;
    }

    public void adicionar(Aeroporto a){
        aero.add(a);
    }

    public String listarTodas(){
        String aeroportos = "Todos os Aeroportos:\n\n";

        for (Aeroporto aeroporto : aero) {aeroportos+= aeroporto.toString();}
        
        return aeroportos;
    }

    public Aeroporto buscarPorCodigo(String cod){
        for(Aeroporto a : aero){if(a.getCodigo().equals(cod)){return a;}}     
        return null;
    }
}
