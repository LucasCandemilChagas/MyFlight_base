package pucrs.myflight.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
    private static GerenciadorVoos instance;

    private ArrayList<Voo> voos;   
    
    private GerenciadorVoos(){
        voos = new ArrayList<>();
    }

    public static GerenciadorVoos getInstance(){
        if(instance == null){instance = new GerenciadorVoos();}
        return instance;
    }

    public void adicionar(Voo r){
        voos.add(r);
    }

    public String listarTodas(){
        String v = "Voos:\n\n";

        for(Voo voo : voos){
            if(voo instanceof VooDireto){
                VooDireto vooD = (VooDireto) voo;
                v+= vooD.mostrarVoo();
            }
            else if(voo instanceof VooEscalas){
                VooEscalas vooE = (VooEscalas) voo;
                v+= vooE.mostrarVoo();
            }
        }

        return v;
    }

    public String buscarPorDate(LocalDateTime date){
        String pesqDate = "";
        for(Voo v : voos){  
            if(v.getDatahora().compareTo(date) == 0){
                if(v instanceof VooDireto){
                    VooDireto vD = (VooDireto) v;
                    pesqDate+=vD.mostrarVoo();               
                }
                else if(v instanceof VooEscalas){
                    VooEscalas vE = (VooEscalas) v;
                    pesqDate+=vE.mostrarVoo();
                }
            }
        }     
        return pesqDate;
    }
}
