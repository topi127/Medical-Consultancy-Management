public class Hospital extends Estabelecimento{
    private String morada;
    public Hospital(){
        morada = "";
    }
    /**
     * @param nome nome do hospital
     * @param email email do hospital
     * @param morada morada do hospital
     * construtor da classe hospital
     */
    public Hospital (String nome, String email, String morada){
        super(nome, email);
        this.morada = morada;
    }
    /**
     * @param nome nome do hospital
     * @param email email do hospital
     * @param morada morada do hospital
     * define um objeto da classe hospital
     */
    public void setHospital(String nome, String email, String morada){
        setEstabelecimento(nome, email);
        this.morada = morada;
    }
    /**
     * Mostra no ecrã o dados do hospital
     */
    public void getHospital(){
        getEstabelecimento();
        System.out.println("Morada: "+ this.morada);

    }
    /**
     * @return o nome do hospital
     */
    public String getNomeHospital(){
       return getNomeEstabelecimento();
    }
}
