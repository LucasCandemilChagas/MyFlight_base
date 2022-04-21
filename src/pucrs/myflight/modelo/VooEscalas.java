package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VooEscalas extends Voo{
   private LocalDateTime datahora;
   private DateTimeFormatter formatter;
	private String texto;
	private LocalDateTime parseDateTime;

   private static int proxNum = 3000;
   private int numVoo;
   
   private Duration dur;

   private Rota rota;

   private ArrayList<Rota> rotas;
   private Status status;

   public VooEscalas(LocalDateTime dh) {
      super(dh);
      this.datahora = dh;
      this.status = Status.CONFIRMADO;
      formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		texto = datahora.format(formatter);
		parseDateTime = LocalDateTime.parse(texto, formatter);
      rotas = new ArrayList<>(); 
      numVoo = proxNum;
      proxNum+= 1;
   }

   public void adicionaRota(Rota rota){
      this.rota = rota;
      rotas.add(rota);
   }

   public void setStatus(Status novoStatu){
     this.status = novoStatu;
   }

   @Override
   public Rota getRota() {
      return rota;
   }
   
   public ArrayList<Rota> mostrarRotas(){
      return rotas;
   }

   @Override
   public LocalDateTime getDatahora(){
      return datahora;
   }
 
   @Override
   public Duration getDuration() {
      double d = (Geo.distancia(rota.getOrigem().getLocal(), rota.getDestino().getLocal())/805)*60;
      long duracao = (long) d;
      dur = Duration.ofMinutes(duracao);
      return dur;
   }
   
   public String mostrarVoo() {
     
     String r = "Voo com Escalas "+ numVoo +":\n\n";
     
     r += "Detalhes do Voo:\n\n";
     
     r+= "Status: " + status + "\n";
     
     for(Rota rot : rotas){
        r+=  "-" + rot.toString();
     }
     
     r+="Data do Voo: "+parseDateTime+"\n";
     
     r+="Duracao: "+getDuration()+" minutos\n";

     r+= "\n-------------------------------------------------\n";
     
     return r;
   }
}
