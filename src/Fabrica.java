import java.util.UUID;
public class Fabrica {
    private UUID ID;
    private String nome;
    private String marca;

       public Fabrica(String nome, String marca) {
        this.ID = gerarID();
        this.nome = nome;
        this.marca = marca;
     }
     public static UUID gerarID() {
      return UUID.randomUUID();
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public String getMarca() {
      return marca;
   }
   public void setMarca(String marca) {
      this.marca = marca;
   }
   
}
