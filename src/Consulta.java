import java.lang.reflect.Array;
import java.util.Date;
public class Consulta{
    private int nConsulta;
    private String dataEhora;
    private Date dataEhoraRegisto;
    //hospital
    private String edificioSala;
    private String localConsulta;
    private String medico;
    private String utente;
    private String usf;
    private String especialidade;
    private String polo;
    private String enfermeiros;
    // Construtor e getters/setters
    public Consulta(){
        nConsulta = 0;
        dataEhora = "";
        dataEhoraRegisto = new Date();
        edificioSala = "";
        localConsulta = "";
        medico = "";
        utente = "";
        usf = "";
        especialidade = "";
        polo = "";
        enfermeiros = "";
    }

    /**
     * @param nConsulta numero da consulta que esta implemantado dinamicamente
     * @param dataEhora data e hora da consulta
     * @param edificioSala sala ou edificio da consulta
     * @param dataEhoraRegisto data e hora do registo criado dinamicamente
     */
    public Consulta(int nConsulta, String dataEhora, String edificioSala, Date dataEhoraRegisto) {
        this.nConsulta = nConsulta;
        this.dataEhora = dataEhora;
        this.dataEhoraRegisto = dataEhoraRegisto;
        this.edificioSala = edificioSala;
        this.localConsulta = localConsulta;
        this.medico = medico;
        this.utente = utente;
        this.usf = usf;
        this.especialidade = especialidade;
        this.polo = polo;
        this.enfermeiros = enfermeiros;
    }

    /**
     *
     * @param nConsulta numero da consulta
     * @param dataEhora data e hora da consuçta
     * @param dataEhoraRegisto data e hora do registo da consulta
     * @param edificioSala edificio ou sala da consulta
     * @param localConsulta local da consulta
     * @param medico medico da consulta
     * @param utente utente da consulta
     * @param especialidade especialidade da consulta
     * @param enfermeiros enfermeiros da consulta
     */
    public void setConsulta(int nConsulta, String dataEhora, Date dataEhoraRegisto ,String edificioSala, String localConsulta, String medico, String utente, String especialidade, String enfermeiros){
        this.nConsulta = nConsulta;
        this.dataEhora = dataEhora;
        this.dataEhoraRegisto = dataEhoraRegisto;
        this.edificioSala = edificioSala;
        this.localConsulta = localConsulta;
        this.medico = medico;
        this.utente = utente;
        this.especialidade = especialidade;
        this.enfermeiros = enfermeiros;
    }

    /**
     *
     * @param enfAtualizar - enfermeiros a atualizar numa consulta
     */
    public void setEnfermeirosConsulta(String enfAtualizar){
        this.enfermeiros = enfAtualizar;
    }
    public void getConsulta(){
        System.out.println("Número da consulta: " + this.nConsulta);
        System.out.println("Data e Hora: " + this.dataEhora);
        System.out.println("Data e Hora do Registo: " + this.dataEhoraRegisto);
        System.out.println("Edificio/Sala: " + this.edificioSala);
        System.out.println("Local: " + this.localConsulta);
        System.out.println("Médico: " + this.medico);
        System.out.println("Utente: " + this.utente);
        System.out.println("Especialidade: "+ this.especialidade);
        System.out.println("Enfermeiros: " + this.enfermeiros);
    }
    public String getConsultaWriteFile(){
        String stringConsulta = ("Número da consulta: " + this.nConsulta + "\n" + "Data e Hora: " + this.dataEhora + "\n" + "Data e Hora do Registo: " + this.dataEhoraRegisto + "\n" + "Edificio/Sala: " + this.edificioSala + "\n" + "Local: " + this.localConsulta + "\n" + "Médico: " + this.medico + "\n" + "Utente: " + this.utente + "\n" + "Especialidade: " + this.especialidade + "\n" + "Enfermeiros: " + this.enfermeiros);
        return stringConsulta;
    }
    public int getNConsulta(){
        return this.nConsulta;
    }
    public String getConsultaData(){
        String dataFiltrada = this.dataEhora.substring(0, 10);
        return dataFiltrada;
    }
    public String getConsultaDataRegisto(){
        String dataFiltrada = this.dataEhora.substring(0, 10);
        return dataFiltrada;
    }
    public String getNomeEstabelecimentoDaConsulta(){ return this.localConsulta;}
    public String getEnfermeirosConsulta(){
        return this.enfermeiros;
    }
    public String getEspecialidadeConsulta(){
        return this.especialidade;
    }
    public String getUtenteConsulta(){
        return this.utente ;
    }

}
