import java.util.UUID;

public class Fornecedor {
    private UUID ID;
    private String nome;
    private String numero;
    private String marca;


    public Fornecedor(String nome, String numero, String marca){
        this.nome = nome;
        this.numero = numero;
        this.marca = marca;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public static UUID gerarID() {
      return UUID.randomUUID();
    }
}
