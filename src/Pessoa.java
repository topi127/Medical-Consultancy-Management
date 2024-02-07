public class Pessoa {
    private int nIdentificacao;
    private String nome;
    private int nTelefone;
    public Pessoa(){
        nome = "";
        nIdentificacao = 0;
        nTelefone = 0;
    }
    /**
     * @param nIdentificacao numero de identificação da pessoa
     * @param nome nome da pessoa
     * @param nTelefone número de telefone da pessoa
     * construtor da classe pessoa
     */
    public Pessoa(int nIdentificacao, String nome, int nTelefone) {
        this.nIdentificacao = nIdentificacao;
        this.nome = nome;
        this.nTelefone = nTelefone;
    }
    /**
     * @param nIdentificacao numero de identificação da pessoa
     * @param nome nome da pessoa
     * @param nTelefone número de telefone da pessoa
     * define um objeto do tipo pessoa
     */
    public void setPessoa(int nIdentificacao, String nome, int nTelefone){
        this.nIdentificacao = nIdentificacao;
        this.nome = nome;
        this.nTelefone = nTelefone;
    }
    /**
     * mostra os dados da pessoa no ecrã
     */
    public void getPessoa(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Nº de identificação: " + this.nIdentificacao);
        System.out.println("Nº de telefone: " + this.nTelefone);

    }
    public String getNomePessoa(){
        return this.nome;
    }
}