public class Polo{
    private String nome;
    private String morada;
    private int nTelefone;
    private String hospital;
    public Polo(){
        nome = "";
        morada = "";
        nTelefone = 0;
        hospital = "";
    }
    /**
     * @param nome nome do polo
     * @param nTelefone número de telefone do polo
     * @param morada morada do polo
     * @param hospital nome do hospital em que o polo está associado
     * construtor da classe polo
     */
    public Polo(String nome, int nTelefone, String morada, String hospital){
        this.nome = nome;
        this.morada = morada;
        this.nTelefone = nTelefone;
        this.hospital = hospital;
    }
    /**
     * @param nome nome do polo
     * @param nTelefone número de telefone do polo
     * @param morada morada do polo
     * @param hospital nome do hospital em que o polo está associado
     * define um objeto do tipo polo
     */
    public void setPolo(String nome, int nTelefone, String morada, String hospital){
        this.nome = nome;
        this.morada = morada;
        this.nTelefone = nTelefone;
        this.hospital = hospital;
    }
    /**
     * mostra os dados do polo no ecrã
     */
    public void getPolo(){
        System.out.println("Nome do Polo: " + nome);
        System.out.println("Morada do Polo: " + morada);
        System.out.println("Nª Telefone: " + nTelefone);
        System.out.println("Pertence ao hospital " + hospital);
    }
    /**
     * @return nome do hospital
     */
    public String getHospitalAssociado(){
        return this.hospital;
    }

    public String getPoloConsulta(){
        String infoConsulta = this.nome + " - " + this.morada + " - " + this.getHospitalAssociado();
        return infoConsulta;
    }

    public String getNomePolo(){
        return this.nome;
    }
}

