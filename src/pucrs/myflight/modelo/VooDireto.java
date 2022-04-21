package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VooDireto extends Voo{
    private static int proxNum = 3000;
    private int numVoo;
   
    
    private LocalDateTime datahora;
   
    private Rota r;
    private Status status;

    private DateTimeFormatter formatter;
	private String texto;
	private LocalDateTime parseDateTime;

    private Duration dur;
    
    public VooDireto(Rota rota, LocalDateTime datahora) {
        super(datahora);
        this.r = rota;
        this.datahora = datahora;
        this.status = Status.CONFIRMADO;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		texto = datahora.format(formatter);
		parseDateTime = LocalDateTime.parse(texto, formatter);
        numVoo = proxNum;
        proxNum+=1;
    }

    public void setStatus(Status novoStatu){
        this.status = novoStatu;
    }

    @Override
    public Rota getRota() {
        return r;
    }

    @Override
    public LocalDateTime getDatahora() {
        return datahora;
    }

    @Override
   public Duration getDuration() {
      double d = (Geo.distancia(r.getOrigem().getLocal(), r.getDestino().getLocal())/805)*60;
      long duracao = (long) d;
      dur = Duration.ofMinutes(duracao);
      return dur;
   }

    public String mostrarVoo(){
        String r = "Voo Direto "+ numVoo +":\n\n";
        
        r+= "Status: "+status+"\n";
        
        r+= "Rota - "+getRota()+"\n"+ "Data do Voo: "+parseDateTime+"\n"+
            "Duracao: "+getDuration();

        r+= "\n-------------------------------------------------\n";
        
        return r;
    }
    
}
