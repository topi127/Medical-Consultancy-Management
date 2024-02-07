public class Trabalhador extends Pessoa{
    private int catProf;
    private String cedProf;
    private String especialidade;
    public Trabalhador(){
        catProf = 0;
        cedProf = "";
        especialidade = "";
    }
    /**
     * @param nIdentificacao numero de identificação do trabalhador
     * @param nome nome do trabalhador
     * @param nTelefone número de telefone do trabalhador
     * @param catProf categoria profissional do trabalahador, por numeros inteiros
     * @param cedProf número da cedula profissional
     * @param especialidade especialidade do trabalhador
     * construtor da classe trabalhador
     */
    public Trabalhador(int nIdentificacao, String nome, int nTelefone, int catProf, String cedProf, String especialidade){
        super(nIdentificacao, nome, nTelefone);
        this.catProf = catProf;
        this.cedProf = cedProf;
        this.especialidade = especialidade;
    }
    /**
     * @param nIdentificacao numero de identificação do trabalhador
     * @param nome nome do trabalhador
     * @param nTelefone número de telefone do trabalhador
     * @param catProf categoria profissional do trabalahador, por numeros inteiros
     * @param cedProf número da cedula profissional
     * @param especialidade especialidade do trabalhador
     * define um objeto do tipo trabalahdor
     */
    public void setTrabalhador(int nIdentificacao, String nome, int nTelefone, int catProf, String cedProf, String especialidade){
        setPessoa(nIdentificacao, nome, nTelefone);
        this.catProf = catProf;
        this.cedProf = cedProf;
        this.especialidade = especialidade;
    }
    /**
     * mostra os dados do trabalhador no ecrã
     */
    public void getTrabalhador(){
        getPessoa();
        if (this.catProf == 1){
            System.out.println("Categoria Profissional: Médico");
        }else{
            System.out.println("Categoria Profissional: Enfermeiro");
        }
        System.out.println("Cédula Profissional: " + this.cedProf);
        if (!this.especialidade.equals("não")) {
            System.out.println("Especialidade: " + this.especialidade);
        }
    }
    /**
     * @return categoria profissional do trabalhador
     */
    public String getCatProf(){
        if (this.catProf == 1){
            return "Médico";
        }else{
            return "Enfermeiro";
        }
    }
    public String getCedulaProf(){
        return this.cedProf;
    }
    public String getEspecialidade(){return this.especialidade;}
    public String getProfMarcarConsulta() {
        String infoProfConsulta;
        infoProfConsulta = this.getCedulaProf() + " - " + this.getNomePessoa() + " - " + this.getEspecialidade();
        return infoProfConsulta;
    }
}