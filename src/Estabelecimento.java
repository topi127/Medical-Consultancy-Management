public class Estabelecimento{
    private String nome;
    private String email;
    public Estabelecimento(){
//        nome = "";
//        email = "";
    }
    /**
     * @param nome nome do estabelecimento
     * @param email email do estabelecimento
     * construtor da classe estavelecimento
     */
    public Estabelecimento (String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    /**
     *
     * @param nome nome do estabelicimento
     * @param email email do estabelecimento
     * define um objeto do tipo estabelecimento
     */
    public void setEstabelecimento(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    /**
     * mostra no ecrã o dados do estabelecimento
     */
    public void getEstabelecimento(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
    }
    /**
     * @return - o nome do estabelicimento
     */
    public String getNomeEstabelecimento(){
        return this.nome;
    }
}