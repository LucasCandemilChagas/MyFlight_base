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
   private double d;
   private long duracao;

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
      d = (Geo.distancia(rota.getOrigem().getLocal(), rota.getDestino().getLocal())/805)*60+30;
      duracao = (long) d;
      dur = Duration.ofMinutes(duracao);
      return dur;
   }
   
   public String mostrarVoo() {
     double dT = 0;

     String r = "Voo com Escalas "+ numVoo +":\n\n";
     
     r += "Detalhes do Voo:\n\n";
     
     r+= "Status: " + status + "\n";
     
     for(Rota rot : rotas){
        d = (Geo.distancia(rot.getOrigem().getLocal(), rot.getDestino().getLocal())/805)*60+30;
        duracao = (long) d;
        r+=  rot.toString();
        r+= "Duracao da Escala: "+Duration.ofMinutes(duracao)+"\n"; 
        dT += d;
     }

     duracao = (long) dT;
     
     r+="Data do Voo: "+parseDateTime+"\n";
     
     r+="Duracao Total: "+Duration.ofMinutes(duracao);

     r+= "\n-------------------------------------------------\n";
     
     return r;
   }
}
