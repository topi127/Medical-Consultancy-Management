public class USF extends Estabelecimento{
    private String morada;
    private String nTelefone;
    public USF(){morada = "";}
    /**
     * @param nome nome da unidade de saúde profissional
     * @param email email da unidade de saúde profissional
     * @param morada morada da unidade de saúde profissioal
     * @param nTelefone número de telefone da unidade de saúde profissional
     * construtor da classe unidade de saúde familiar
     */
    public USF (String nome, String email, String morada, String nTelefone){
        super(nome,email);
        this.morada = morada;
        this.nTelefone = nTelefone;
    }
    /**
     * @param nome nome da unidade de saúde profissional
     * @param email email da unidade de saúde profissional
     * @param morada morada da unidade de saúde profissioal
     * @param nTelefone número de telefone da unidade de saúde profissional
     * define um obejeto do tipo unidade de saúde profissional
     */
    public void setUSF(String nome, String email, String morada, String nTelefone){
        setEstabelecimento(nome, email);
        this.morada = morada;
        this.nTelefone = nTelefone;
    }
    /**
     * mostra os dados da unidade de saúde profissional no ecrã
     */
    public void getUSF(){
        getEstabelecimento();
        System.out.println("Morada: " + this.morada);
        System.out.println("Contacto: " + this.nTelefone);
    }
    public String getUsfConsulta(){
        String infoUsfConsulta;
        infoUsfConsulta = this.getNomeEstabelecimento() + " - "+ this.morada;
        return infoUsfConsulta;
    }
    public String getNomeUSF(){
        return this.getNomeEstabelecimento();
    }
}