import java.awt.font.TextHitInfo;

public class Utente extends Pessoa{
    private int nUtente;
    private String morada;
    private String dataNascimento;
    public Utente(){
        nUtente = 0;
        morada = "";
        dataNascimento = "";
    }
    /**
     * @param nIdentificacao número de identificação do utente
     * @param nome nome do utente
     * @param nTelefone numero de telefone do utente
     * @param nUtente número de utente
     * @param morada morada do utente
     * @param dataNascimento data de nascimento do utente
     * construtor da classe utente
     */
    public Utente(int nIdentificacao, String nome, int nTelefone, int nUtente, String morada, String dataNascimento){
        super(nIdentificacao, nome, nTelefone);
        this.nUtente = nUtente;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
    }
    /**
     * @param nIdentificacao número de identificação do utente
     * @param nome nome do utente
     * @param nTelefone numero de telefone do utente
     * @param nUtente número de utente
     * @param morada morada do utente
     * @param dataNascimento data de nascimento do utente
     * define um objeto di tipo utente
     */
    public void setUtente(int nIdentificacao, String nome, int nTelefone, int nUtente, String morada, String dataNascimento){
        /*Quando chamada criar um utente e a função setUtente é chamada para conseguirmos
         *  mudar o numero de Utente, morada e data de nascimento que são parametros herdados da super classe Pessoa
         * */
        setPessoa(nIdentificacao, nome, nTelefone);
        this.nUtente = nUtente;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
    }
    /**
     * mostra os dados do utente no ecrã
     **/
    public void getUtente(){
        getPessoa();
        System.out.println("Nº de Utente: " + this.nUtente);
        System.out.println("Morada: " + this.morada);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
    }
    public String getUtenteFile(){
        String textoEnviar = ("Nº de Utente: " + this.nUtente + "\n"+ "Morada: " + this.morada + "\n" + "Data de Nascimento: " + this.dataNascimento + "\n");
        return textoEnviar;
    }
    public void getUtenteConsulta() {
        String nUtenteENome;
        nUtenteENome = this.getNid() + " - " + this.getNomePessoa();
        System.out.println(nUtenteENome);
    }
    public String getUtenteMarcarConsulta(){
        String infoUtenteConsula = this.getNid() + " - " + this.getNomePessoa() + " - " + this.dataNascimento;
        return infoUtenteConsula;
    }
    public int getNid(){
        return this.nUtente;
    }
}