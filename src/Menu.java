import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class Menu {
    Scanner r = new Scanner(System.in);
    /*Pessoa pessoas[] = new Pessoa[100];*/
    Utente pessoaUtente[] = new Utente[100];
    Trabalhador pessoaTrabalhador[] = new Trabalhador[100];
    USF unidadesDeSaude[] = new USF[100];
    Hospital unidadesHospitalares[] = new Hospital[100];
    Polo polos[] = new Polo[100];
    Consulta consultas[] = new Consulta[100];
    int numeroConsultas = 0;
    int numeroUtentes = 0;
    int numeroTrabalhador = 0;
    int numeroUSF = 0;
    int numeroHospitais = 0;
    int numeroPolos = 0;
    void testeDados(){
        for (int A = 0; A < 3 ; A++ ){
            pessoaUtente[A] = new Utente();
            int nIdentificacao = A+1;
            String nome = "Rodrigo " + A;
            int nTelefone = A+1;
            int nUtente =  A+1;
            String morada = "Morada " + (A+1);
            String dataNascimento = "01/01/200" + (A+1);
            pessoaUtente[A].setUtente(nIdentificacao, nome, nTelefone, nUtente, morada, dataNascimento);
            numeroUtentes++;
        }
        for (int B = 0; B < 3; B++){
            unidadesDeSaude[B] = new USF();
            String nome = "USF " + (B+1);
            String email = "USF" + (B+1) + "@" + nome + ".com";
            String morada = "Morada " + (B+1);
            String nTelefone = "Contacto: 25264328" + (B+1);
            unidadesDeSaude[B].setUSF(nome, email, morada, nTelefone);
            numeroUSF++;
        }
        for (int C = 0; C < 3; C++){
            unidadesHospitalares[C] = new Hospital();
            String nome = "Hospital " + (C+1);
            String email = "Hospital" + (C+1) + "@" + nome + ".com";
            String morada = "Morada " + (C+1);
            unidadesHospitalares[C].setHospital(nome, email, morada);
            numeroHospitais++;
            polos[C] = new Polo();
            String nomePolo = "Polo " +(C+1);
            int nTelefone = 252643274 +(C+1);
            String moradaPolo = "Morada Polo " + (C+1);
            String hospital = nome;
            polos[C].setPolo(nomePolo, nTelefone, moradaPolo, hospital);
            numeroPolos++;
        }
        /*for (int D = 0; D < 3; D++){
            consultas[D] = new Consulta();
            int nConsulta = D+1;
            String dataEhora = "10/10/2024 12:12:12" + (D+1);
            Date dataEhoraRegisto =  new Date();
            String edificioSala = "Edificio/Sala" + (D+1);
            String localConsulta = "Local Consulta" + (D+1);
            String medico = "Médico" + (D+1);
            String utente = "Utente" + (D+1);
            String usf = "USF" + (D+1);
            String especialidade = "Especialidade" + (D+1);
            String polo = "Polo" + (D+1);
            String enfermeiro = "Enfermeiro" + (D+1);
            consultas[D].setConsulta(nConsulta, dataEhora,dataEhoraRegisto, edificioSala,localConsulta, medico, utente,especialidade,enfermeiro);
            numeroConsultas++;
        }*/
        for (int E = 0; E < 6; E++){
            Random r = new Random();
            int a = 1;
            int b = 3;
            pessoaTrabalhador[E] = new Trabalhador();
            int nIdentificacao = E+1;
            String nome = "Nome " + (E+1);
            int nTelefone = 911111111 + E;
            int catProf = r.nextInt(b-a) + a;
            String cedProf = "1" + E;
            String especialidade = "Dermatologia";
            pessoaTrabalhador[E].setTrabalhador(nIdentificacao, nome, nTelefone, catProf, cedProf, especialidade);
            numeroTrabalhador++;
        }
    }
    void mostrarMenu(){
        String opcao;
        System.out.println("==== Gestão de consultas médicas ====");
        System.out.println("1 - Área de utentes");
        System.out.println("2 - Área de trabalhadores");
        System.out.println("3 - Área de USFs");
        System.out.println("4 - Área Hospitalar");
        System.out.println("5 - Área Consultas");
        System.out.println("0 - Sair");
        System.out.println("Escolha a opção desejada: ");
        opcao = r.nextLine();
        switch(opcao){
            case "1":
                limpar();
                menuUtentes();
                break;
            case "2":
                limpar();
                menuTrabalhador();
                break;
            case "3":
                limpar();
                menuUSF();
                break;
            case "4":
                limpar();
                menuHospital();
                break;
            case "5":
                limpar();
                menuConsultas();
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Insira uma opção válida!");
                dormir(3000);
                limpar();
                mostrarMenu();
                break;
        }
    }
    public void menuUtentes(){
        String opcao;
        System.out.println("==== ÁREA UTENTES ====");
        System.out.println("1 - Adicionar Utente");
        System.out.println("2 - Mostrar Utentes");
        System.out.println("3 - Atualizar Utente");
        System.out.println("4 - Apagar Utente");
        System.out.println("5 - Voltar ao menu inicial");
        System.out.println("Escolha a opção desejada: ");
        opcao = r.nextLine();
        switch(opcao){
            case "1":
                limpar();
                adicionarUtente();
                break;
            case "2":
                limpar();
                mostrarUtente();
                break;
            case "3":
                limpar();
                atualizarUtente();
                break;
            case "4":
                limpar();
                apagarUtente();
                break;
            case "5":
                limpar();
                mostrarMenu();
            default:
                limpar();
                System.out.println("Insira uma opção válida!");
                dormir(3000);
                limpar();
                menuUtentes();
                break;
        }
    }
    public void adicionarUtente(){
        int nIdentificacao;
        String nome;
        int nTelefone;
        int nUtente;
        String morada;
        String dataNascimento;
        System.out.println("==== Adicionar Utente ====");
        System.out.println("Introduza o nome do Utente");
        nome = r.nextLine();
        System.out.println("Introduza o número de Identicação");
        nIdentificacao = r.nextInt();
        System.out.println("Introduza o número de telefone");
        nTelefone = r.nextInt();
        System.out.println("Introduza o nº de Utente");
        nUtente = r.nextInt();
        r.nextLine();
        System.out.println("Introduza a morada");
        morada = r.nextLine();
        System.out.println("Introduza a data de nascimento");
        dataNascimento = r.nextLine();
        numeroUtentes++;
        pessoaUtente[numeroUtentes - 1 ] = new Utente();
        pessoaUtente[numeroUtentes - 1].setUtente(nIdentificacao, nome, nTelefone, nUtente, morada, dataNascimento);
        dormir(3000);
        limpar();
        menuUtentes();
    }
    public void mostrarUtente(){
        if (numeroUtentes == 0) {
            System.out.println("Não existem Utentes!");
            dormir(3000);
            limpar();
            mostrarMenu();
        }
        System.out.println("==== Utentes ====");
         for (int i =0 ; i< numeroUtentes ; i++){
             System.out.println("==== " + (i+1) + " ====");
             pessoaUtente[i].getUtente();
             System.out.println("========");
         }
        dormir(3000);
        limpar();
        menuUtentes();
    }
    public void atualizarUtente(){
        int escolhaAtualizarUtente;
        int nIdentificacao;
        String nome;
        int nTelefone;
        int nUtente;
        String morada;
        String dataNascimento;
        System.out.println("==== Atualizar Utente ====");
        for (int i = 0 ; i < numeroUtentes ; i++){
            System.out.println(("==== " + (i+1) +" ==== "));
            pessoaUtente[i].getUtente();
        }
        System.out.println("Escolha o Utente a atualizar: ");
        escolhaAtualizarUtente = r.nextInt();
        if (escolhaAtualizarUtente == 0 || escolhaAtualizarUtente > numeroUtentes){
            System.out.println("Escolha um utente válido");
            menuUtentes();
        }else{
            System.out.println("Utente Selecionado - Dados Atuais");
            pessoaUtente[escolhaAtualizarUtente - 1].getUtente();
            System.out.println("========");
            System.out.println("Dados a atualizar: ");
            System.out.println("Introduza o nome do Utente");
            nome = r.nextLine();
            r.nextLine();
            System.out.println("Introduza o número de Identicação");
            nIdentificacao = r.nextInt();
            System.out.println("Introduza o número de telefone");
            nTelefone = r.nextInt();
            System.out.println("Introduza o nº de Utente");
            nUtente = r.nextInt();
            r.nextLine();
            System.out.println("Introduza a morada");
            morada = r.nextLine();
            System.out.println("Introduza a data de nascimento");
            dataNascimento = r.nextLine();
            pessoaUtente[escolhaAtualizarUtente - 1].setUtente(nIdentificacao, nome, nTelefone, nUtente, morada, dataNascimento);
            limpar();
            System.out.println("Utente atualizado com sucesso!");
            dormir(2000);
            limpar();
            menuUtentes();
        }
    }
    public void apagarUtente(){
        Utente pessoaUtenteApagar[] = new Utente[numeroUtentes];
        System.out.println("==== Apagar Utente ====");
        int escolhaApagarUtente;
        for (int i = 0 ; i < numeroUtentes ; i++){
            System.out.println(("==== " + (i+1) + " ==== "));
            pessoaUtente[i].getUtente();
        }
        System.out.println("Escolha o Utente a apagar: ");
        escolhaApagarUtente = r.nextInt();
        r.nextLine();
        if (escolhaApagarUtente == 0 || escolhaApagarUtente > numeroUtentes){
            System.out.println("Escolha um Utente válido!");
            menuUtentes();
            limpar();
        }else{
            escolhaApagarUtente -= 1;
            for (int i = 0 ; i < numeroUtentes; i++){
                if ( i < escolhaApagarUtente){
                    pessoaUtenteApagar[i] = pessoaUtente[i];
                }else if(i > escolhaApagarUtente){
                    pessoaUtenteApagar[i - 1] = pessoaUtente[i];
                }
            }
            System.out.println("Utente apagado com sucesso!");
            pessoaUtente = pessoaUtenteApagar;
            numeroUtentes -= 1;
        }
        dormir(2000);
        menuUtentes();
        limpar();
    }
    public void menuTrabalhador(){
        String opcao;
        System.out.println("==== ÁREA DE TRABALHADORES ====");
        System.out.println("1- Adicionar Trabalhador");
        System.out.println("2- Mostrar Trabalhador");
        System.out.println("3- Atualizar Trabalhador");
        System.out.println("4- Apagar Trabalhador");
        System.out.println("5- Voltar ao menu inicial");
        System.out.println("Escolha a opção desejada");
        opcao = r.nextLine();
        switch (opcao){
            case "1":
                limpar();
                adicionarTrabalhador();
                break;
            case "2":
                limpar();
                mostrarTrabalhador();
                break;
            case "3":
                limpar();
                atualizarTrabalhador();
                break;
            case "4":
                limpar();
                apagarTrabalhador();
                break;
            case "5":
                limpar();
                mostrarMenu();
            default:
                System.out.println("Insira uma opção válida!");
                dormir(2000);
                limpar();
                menuTrabalhador();
                break;
        }
    }
    public void adicionarTrabalhador(){
        int nIdentificacao;
        String nome;
        int nTelefone;
        int catProf;
        String cedProf;
        String confirmarEspecialidade = "";
        String especialidade;
        System.out.println("==== Adicionar Trabalhador ====");
        System.out.println("Introduza o nome do Trabalhador");
        nome = r.nextLine();
        System.out.println("Introduza o número de Identicação");
        nIdentificacao = r.nextInt();
        System.out.println("Introduza o número de telefone");
        nTelefone = r.nextInt();
        do {
            System.out.println("Introduza a categoria profissional");
            System.out.println("1- Médico");
            System.out.println("2- Enfermeiro");
            catProf = r.nextInt();
            if ((catProf <= 0 || catProf > 2)){
                System.out.println("Categoria profissional inexistente! Insira novamente:");
            }
        }
        while (catProf <= 0 || catProf > 2);
        r.nextLine();
        System.out.println("Introduza a cédula profissional");
        cedProf = r.nextLine();
        System.out.println("Tem alguma especialidade? (sim/não)");
        confirmarEspecialidade = r.nextLine();
        especialidade = "Não tem especialidade";
        if (confirmarEspecialidade.equalsIgnoreCase("sim")){
            System.out.println("Insira a especialidade");
            especialidade = r.nextLine();
        }
        System.out.println("Trabalhador adicionado com sucesso!");
        numeroTrabalhador++;
        pessoaTrabalhador[numeroTrabalhador - 1] = new Trabalhador();
        pessoaTrabalhador[numeroTrabalhador - 1].setTrabalhador(nIdentificacao, nome, nTelefone, catProf, cedProf, especialidade);
        dormir(1000);
        limpar();
        menuTrabalhador();
    }
    public void mostrarTrabalhador(){
        int opcaoTrabalhador;
        if (numeroTrabalhador == 0) {
            System.out.println("Não existem Trabalhadores!");
            menuTrabalhador();
        }
        System.out.println("==== Trabalhadores ====");
        System.out.println("1- Mostrar Médicos");
        System.out.println("2- Mostrar Enfermeiros");
        System.out.println("3- Mostrar todos os Trabalhadores");
        System.out.println("4- Voltar ao menu anterior");
        opcaoTrabalhador = r.nextInt();
        switch (opcaoTrabalhador){
            case 1:
                limpar();
                mostrarMedico();
                break;
            case 2:
                limpar();
                mostrarEnfermeiro();
                break;
            case 3:
                limpar();
                mostrarTodosTrabalhadores();
                break;
            case 4:
                limpar();
                menuTrabalhador();
                break;
            default:
                limpar();
                System.out.println("Insira uma opção válida!");
                dormir(3000);
                limpar();
                menuTrabalhador();
                break;
        }
    }
    public void mostrarMedico(){
        System.out.println("==== Médicos ====");
        for (int i =0 ; i< numeroTrabalhador ; i++){
            if (pessoaTrabalhador[i].getCatProf().equals("Médico")){
                pessoaTrabalhador[i].getTrabalhador();
                System.out.println("========");
            }else {
                System.out.println("Não existem médicos disponíveis!");
            }
        }
        dormir(3000);
        limpar();
        menuTrabalhador();
    }
    public void mostrarEnfermeiro(){
        System.out.println("==== Enfermeiros ====");
        for (int i =0 ; i< numeroTrabalhador ; i++){
            if (pessoaTrabalhador[i].getCatProf().equals("Enfermeiro")){
                pessoaTrabalhador[i].getTrabalhador();
                System.out.println("========");
            }else {
                System.out.println("Não existem enfermeiros disponíveis");
            }
        }
        dormir(3000);
        limpar();
        menuTrabalhador();
    }
    public void mostrarTodosTrabalhadores(){
        System.out.println("==== Trabalhadores ====");
        for (int i =0 ; i< numeroTrabalhador ; i++){
            pessoaTrabalhador[i].getTrabalhador();
            System.out.println("========");
        }
        dormir(3000);
        limpar();
        menuTrabalhador();
    }
    public void atualizarTrabalhador() {
        int escolhaAtualizarTrabalhador;
        int nIdentificacao;
        String nome;
        int nTelefone;
        int catProf;
        String cedProf;
        String especialidade;
        String confirmarEspecialidade;
        System.out.println("==== Atualizar Trabalhador ====");
        for (int i = 0; i < numeroTrabalhador; i++) {
            System.out.println(("==== " + (i + 1) + " ==== "));
            pessoaTrabalhador[i].getTrabalhador();
        }
        System.out.println("Escolha o Trabalhador a atualizar: ");
        escolhaAtualizarTrabalhador = r.nextInt();
        if (escolhaAtualizarTrabalhador == 0 || escolhaAtualizarTrabalhador > numeroTrabalhador) {
            System.out.println("Escolha um trabalhador válido");
            menuTrabalhador();
        } else {
            System.out.println("Trabalhador Selecionado - Dados Atuais");
            pessoaTrabalhador[escolhaAtualizarTrabalhador - 1].getTrabalhador();
            System.out.println("========");
            System.out.println("Dados a atualizar: ");
            r.nextLine();
            System.out.println("Introduza o nome do Trabalhador");
            nome = r.nextLine();
            System.out.println("Introduza o número de Identicação");
            nIdentificacao = r.nextInt();
            System.out.println("Introduza o número de telefone");
            nTelefone = r.nextInt();
            do {
                System.out.println("Introduza a categoria profissional");
                System.out.println("1- Médico");
                System.out.println("2- Enfermeiro");
                catProf = r.nextInt();
                if ((catProf <= 0 || catProf > 2)){
                    System.out.println("Categoria profissional inexistente! Insira novamente:");
                }
            }
            while (catProf <= 0 || catProf > 2);
            r.nextLine();
            System.out.println("Introduza a cédula profissional");
            cedProf = r.nextLine();
            System.out.println("Tem alguma especialidade? (sim/não)");
            confirmarEspecialidade = r.nextLine();
            especialidade = "Não tem especialidade";
            if (confirmarEspecialidade.equalsIgnoreCase("sim")){
                System.out.println("Insira a especialidade");
                especialidade = r.nextLine();
            }
            pessoaTrabalhador[escolhaAtualizarTrabalhador - 1].setTrabalhador(nIdentificacao, nome, nTelefone, catProf, cedProf, especialidade);
            limpar();
            System.out.println("Trabalhador atualizado com sucesso!");
            dormir(3000);
            limpar();
            menuTrabalhador();
        }
    }
    public void apagarTrabalhador() {
        Trabalhador pessoaTrabalhadorApagar[] = new Trabalhador[numeroTrabalhador];
        System.out.println("==== Apagar Trabalhador ====");
        int escolhaApagarTrabalhador;
        for (int i = 0; i < numeroTrabalhador; i++) {
            System.out.println(("==== " + (i + 1) + " ==== "));
            pessoaTrabalhador[i].getTrabalhador();
        }
        System.out.println("Escolha o Trabalhador a apagar: ");
        escolhaApagarTrabalhador = r.nextInt();
        r.nextLine();
        if (escolhaApagarTrabalhador == 0 || escolhaApagarTrabalhador > numeroTrabalhador) {
            System.out.println("Escolha um Trabalhador válido!");
            menuTrabalhador();
        } else {
            escolhaApagarTrabalhador -= 1;
            for (int i = 0; i < numeroTrabalhador; i++) {
                if (i < escolhaApagarTrabalhador) {
                    pessoaTrabalhadorApagar[i] = pessoaTrabalhador[i];
                } else if (i > escolhaApagarTrabalhador) {
                    pessoaTrabalhadorApagar[i - 1] = pessoaTrabalhador[i];
                }
            }
            System.out.println("Trabalhador apagado com sucesso!");
            pessoaTrabalhador = pessoaTrabalhadorApagar;
            numeroTrabalhador -= 1;
        }
        limpar();
        menuTrabalhador();
    }
    public void menuUSF(){
        String opcao;
        System.out.println("==== ÁREA USF ====");
        System.out.println("1 - Adicionar USF");
        System.out.println("2 - Mostrar USF");
        System.out.println("3 - Atualizar USF");
        System.out.println("4 - Apagar USF");
        System.out.println("5 - Mostrar utentes de uma USF");
        System.out.println("6 - Mostrar consultas existentes de um USF por data");
        System.out.println("7 - Voltar ao menu inicial");
        System.out.println("Escolha a opção desejada: ");
        opcao = r.nextLine();
        switch(opcao){
            case "1":
                limpar();
                adicionarUSF();
                break;
            case "2":
                limpar();
                mostrarUSF();
                break;
            case "3":
                limpar();
                atualizarUSF();
                break;
            case "4":
                limpar();
                apagarUSF();
                break;
            case "5":
                limpar();
                mostrarUtentesUSF();
                break;
            case "6":
                limpar();
                mostrarUsfTotalConsultasData();
                break;
            case "7":
                limpar();
                mostrarMenu();
                break;
            default:
                limpar();
                System.out.println("Insira uma opção válida!");
                dormir(2000);
                limpar();
                menuUSF();
                break;
        }
    }
    public void adicionarUSF() {
        Scanner r = new Scanner(System.in);
        String nome;
        String email;
        String morada;
        String nTelefone;
        System.out.println("==== Adicionar USF ====");
        System.out.println("Introduza o nome");
        nome = r.nextLine();
        System.out.println("Introduza o email");
        email = r.nextLine();
        System.out.println("Introduza a morada");
        morada = r.nextLine();
        System.out.println("Introduza o contacto");
        nTelefone = r.nextLine();
        numeroUSF ++;
        unidadesDeSaude[numeroUSF - 1] = new USF();
        unidadesDeSaude[numeroUSF - 1].setUSF(nome, email, morada, nTelefone);
        System.out.println("USF criada com sucesso!");
        dormir(3000);
        limpar();
        menuUSF();
    }
    public void mostrarUSF(){
        if (numeroUSF == 0) {
            System.out.println("Não existem USF!");
            menuUSF();
        }
        System.out.println("==== USF ====");
        for (int i =0 ; i< numeroUSF ; i++){
            unidadesDeSaude[i].getUSF();
            System.out.println("========");
        }
        System.out.println("Aqui acima estão listadas todas as USF disponíveis de momento.");
        dormir(3000);
        limpar();
        menuUSF();
    }
    public void mostrarUtentesUSF(){
        int escolhaUsfMostrarUtentes;
        for(int i = 0 ; i < numeroUSF ; i++){
            System.out.printf((i+1) +" - ");
            unidadesDeSaude[i].getUSF();
        }
        System.out.println("Insira a USF desejada");
        escolhaUsfMostrarUtentes = r.nextInt();
        String nomeEstabelecimentoMostrarUtentes = unidadesDeSaude[escolhaUsfMostrarUtentes - 1].getNomeEstabelecimento();
        System.out.println("Utentes do " + nomeEstabelecimentoMostrarUtentes);
        for (int i = 0 ; i < numeroConsultas ; i++){
            String nomeEstabelecimento =  consultas[i].getNomeEstabelecimentoDaConsulta().split(" -")[0];
            if(nomeEstabelecimento.equals(nomeEstabelecimentoMostrarUtentes)){
               System.out.println(consultas[i].getUtenteConsulta());
           }
        }
    }
    public void mostrarUsfTotalConsultasData(){
        int escolhaUsf;
        String escolhaDiaFiltro;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int contadorConsultasUsf = 0;
        for(int i = 0 ; i < numeroUSF ; i++){
            System.out.printf((i+1) +" - ");
            unidadesDeSaude[i].getUSF();
        }
        System.out.println("Insira a USF desejada");
        escolhaUsf = r.nextInt();
        r.nextLine();
        System.out.println("Insira o intervalo de data (exemplo: 20/04/2024 - 30/04/2024): ");
        escolhaDiaFiltro = r.nextLine();
        String nomeEstabelecimentoEscolhido = unidadesDeSaude[escolhaUsf - 1].getNomeEstabelecimento();
        String inputInicioData = escolhaDiaFiltro.substring(0, 10);
        LocalDate inicioData = LocalDate.parse(inputInicioData, formato);
        String inputFimData = escolhaDiaFiltro.substring(13, 23);
        LocalDate fimData = LocalDate.parse(inputFimData, formato);
        for (int i =0 ; i< numeroConsultas ; i++){
            String nomeEstabelecimentoConsulta =  consultas[i].getNomeEstabelecimentoDaConsulta().split(" -")[0];
            if(nomeEstabelecimentoConsulta.equals(nomeEstabelecimentoEscolhido)){
                contadorConsultasUsf++;
            }
        }
        System.out.println("No usf " + nomeEstabelecimentoEscolhido + " existem " + contadorConsultasUsf + " consultas ");
        menuUSF();
        dormir(2000);
        limpar();
    }
    public void atualizarUSF(){
        int escolhaAtualizarUSF;
        String nome;
        String email;
        String morada;
        String nTelefone;
        System.out.println("==== Atualizar USF ====");
        for (int i = 0; i < numeroUSF; i++){
            System.out.println(("==== " + (i+1) +" ==== "));
            unidadesDeSaude[i].getUSF();
        }
        System.out.println("Escolha a USF a atualizar: ");
        escolhaAtualizarUSF = r.nextInt();
        if (escolhaAtualizarUSF == 0 || escolhaAtualizarUSF > numeroUSF){
            System.out.println("Escolha uma USF válida");
            menuUSF();
        }else{
            System.out.println("USF Selecionada - Dados Atuais");
            unidadesDeSaude[escolhaAtualizarUSF - 1].getUSF();
            System.out.println("========");
            System.out.println("Dados a atualizar: ");
            System.out.println("Introduza o nome da USF: ");
            r.nextLine();
            nome = r.nextLine();
            System.out.println("Introduza o e-mail da USF: ");
            email = r.nextLine();
            System.out.println("Introduza a morada da USF: ");
            morada = r.nextLine();
            System.out.println("Introduza o contacto da USF: ");
            nTelefone = r.nextLine();
            unidadesDeSaude[escolhaAtualizarUSF - 1].setUSF(nome, email, morada, nTelefone);
            limpar();
            System.out.println("USF atualizada com sucesso!");
            dormir(2000);
            limpar();
            menuUSF();
        }
    }
    public void apagarUSF(){
        USF apagarUSF[] = new USF[numeroUSF];
        System.out.println("==== Apagar USF ====");
        int escolhaApagarUSF;
        for (int i = 0 ; i < numeroUSF ; i++){
            System.out.print(("==== " + (i+1) + " ==== "));
            unidadesDeSaude[i].getUSF();
        }
        System.out.println("Escolha a USF a apagar: ");
        escolhaApagarUSF = r.nextInt();
        r.nextLine();
        if (escolhaApagarUSF == 0 || escolhaApagarUSF > numeroUSF){
            System.out.println("Escolha uma USF válida!");
            menuUSF();
        }else{
            escolhaApagarUSF -= 1;
            for (int i = 0 ; i < numeroUSF; i++){
                if ( i < escolhaApagarUSF){
                    apagarUSF[i] = unidadesDeSaude[i];
                }else if(i > escolhaApagarUSF){
                    apagarUSF[i - 1] = unidadesDeSaude[i];
                }
            }
            unidadesDeSaude = apagarUSF;
            numeroUSF -= 1;
            System.out.println("USF apagada com sucesso!");
        }
        limpar();
        menuUSF();
    }
    public void menuHospital(){
        String opcao;
        System.out.println("==== ÁREA HOSPITALAR ====");
        System.out.println("1 - Adicionar Hospital");
        System.out.println("2 - Mostrar Hospital");
        System.out.println("3 - Atualizar Hospital");
        System.out.println("4 - Apagar Hospital");
        System.out.println("5 - Adicionar Polo");
        System.out.println("6 - Mostrar Polos");
        System.out.println("7 - Atualizar Polo");
        System.out.println("8 - Apagar Polo");
        System.out.println("9 - Voltar ao menu inicial");
        System.out.println("Escolha a opção desejada: ");
        opcao = r.nextLine();
        switch(opcao){
            case "1":
                limpar();
                adicionarHospital();
                break;
            case "2":
                limpar();
                mostrarHospital();
                break;
            case "3":
                limpar();
                atualizarHospital();
                break;
            case "4":
                limpar();
                apagarHospital();
                break;
            case "5":
                limpar();
                adicionarPolo();
                break;
            case "6":
                limpar();
                mostrarPolos();
            case "7":
                limpar();
                atualizarPolo();
                break;
            case "8":
                limpar();
                apagarPolo();
                break;
            case "9":
                limpar();
                mostrarMenu();
            default:
                limpar();
                System.out.println("Insira uma opção válida!");
                dormir(2000);
                limpar();
                menuHospital();
                break;
        }
    }
    public void adicionarHospital() {
        String nome;
        String email;
        String morada;
        String nomePolo;
        String moradaPolo;
        int nTelPolo;
        System.out.println("==== Adicionar Hospital ====");
        r.nextLine();
        System.out.println("Introduza o nome");
        nome = r.nextLine();
        System.out.println("Introduza o email");
        email = r.nextLine();
        System.out.println("Introduza a morada");
        morada = r.nextLine();
        numeroHospitais++;
        unidadesHospitalares[numeroHospitais - 1] = new Hospital();
        unidadesHospitalares[numeroHospitais - 1].setHospital(nome, email, morada);
        unidadesHospitalares[numeroHospitais - 1].getHospital();
        System.out.println("==== Adicionar Polo====");
        System.out.println("Introduza o nome");
        nomePolo = r.nextLine();
        System.out.println("Introduza o número de telefone");
        nTelPolo = r.nextInt();
        r.nextLine();
        System.out.println("Introduza a morada");
        moradaPolo = r.nextLine();
        numeroPolos ++;
        polos[numeroPolos - 1] = new Polo();
        String hospitalAssociado = unidadesHospitalares[numeroHospitais - 1].getNomeHospital();
        System.out.println(hospitalAssociado);
        polos[numeroPolos - 1].setPolo(nomePolo, nTelPolo, moradaPolo, hospitalAssociado);
        System.out.println("Hospital criado com sucesso!");
        dormir(3000);
        limpar();
        menuHospital();
    }
    public void mostrarHospital(){
        if (numeroHospitais == 0){
            System.out.println("Não existem Hospitais!");
        }
        System.out.println("==== Hospitais ====");
        System.out.println("====");
       for (int i =0 ; i< numeroHospitais ; i++){
            unidadesHospitalares[i].getHospital();
           System.out.println("==== Polos Associados ====");
           for (int j = 0; j < numeroPolos; j++){
               String hospitalAssociado = polos[j].getHospitalAssociado();
               String nomeHospital = unidadesHospitalares[i].getNomeHospital();
               if (hospitalAssociado.equals(nomeHospital)){
                   polos[j].getPolo();
                   System.out.println("====");
               }
           }
        }
        System.out.println("Aqui acima estão listados todos os hospitais disponíveis de momento, bem como os seus respetivos polos.");
        dormir(3000);
        limpar();
        menuHospital();
    }
    public void atualizarHospital(){
        int escolhaAtualizarHospital;
        String nome;
        String email;
        String morada;
        System.out.println("==== Atualizar Hospital ====");
        for (int i = 0; i < numeroHospitais; i++){
            System.out.println(("==== " + (i+1) +" ==== "));
            unidadesHospitalares[i].getHospital();
        }
        System.out.println("Escolha o Hospital a atualizar: ");
        escolhaAtualizarHospital = r.nextInt();
        if (escolhaAtualizarHospital == 0 || escolhaAtualizarHospital > numeroHospitais){
            System.out.println("Escolha um Hospital válido.");
            menuHospital();
        }else{
            System.out.println("Hospital Selecionado - Dados Atuais");
            unidadesHospitalares[escolhaAtualizarHospital - 1].getHospital();
            System.out.println("========");
            System.out.println("Dados a atualizar: ");
            System.out.println("Introduza o nome do Hospital: ");
            r.nextLine();
            nome = r.nextLine();
            System.out.println("Introduza o e-mail do Hospital: ");
            email = r.nextLine();
            System.out.println("Introduza a morada do Hospital: ");
            morada = r.nextLine();
            unidadesHospitalares[escolhaAtualizarHospital - 1].setHospital(nome, email, morada);
            limpar();
            System.out.println("Hospital atualizado com sucesso!");
            dormir(2000);
            limpar();
            menuHospital();
        }
    }
    public void apagarHospital(){
        Hospital apagarHospital[] = new Hospital[numeroHospitais];
        System.out.println("==== Apagar Hospital ====");
        int escolhaApagarHospital;
        for (int i = 0 ; i < numeroHospitais ; i++){
            System.out.print(("==== " + (i+1) + " ==== "));
            unidadesHospitalares[i].getHospital();
        }
        System.out.println("Escolha o Hospital a apagar: ");
        escolhaApagarHospital = r.nextInt();
        r.nextLine();
        if (escolhaApagarHospital == 0 || escolhaApagarHospital > numeroHospitais){
            System.out.println("Escolha um Hospital válido!");
            limpar();
            menuHospital();
        }else{
            escolhaApagarHospital -= 1;
            for (int i = 0 ; i < numeroHospitais; i++){
                if ( i < escolhaApagarHospital){
                    apagarHospital[i] = unidadesHospitalares[i];
                }else if(i > escolhaApagarHospital){
                    apagarHospital[i - 1] = unidadesHospitalares[i];
                }
            }
            unidadesHospitalares = apagarHospital;
            numeroHospitais -= 1;
            System.out.println("Hospital apagado com sucesso!");
        }
        limpar();
        menuHospital();
    }
    public void adicionarPolo(){
        String nome;
        int nTel;
        String morada;
        System.out.println("==== Adicionar Polo ====");
        r.nextLine();
        System.out.println("Introduza o nome do Polo: ");
        nome = r.nextLine();
        System.out.println("Introduza o número de telefone do Polo: ");
        nTel = r.nextInt();
        r.nextLine();
        System.out.println("Introduza a morada do Polo: ");
        morada = r.nextLine();
        numeroPolos++;
        polos[numeroPolos - 1] = new Polo();
        for (int i =0 ; i< numeroHospitais ; i++) {
            System.out.println(("==== " + (i+1) +" ==== "));
            String mostrarHospitais = unidadesHospitalares[i].getNomeHospital();
            System.out.println(mostrarHospitais);
        }
        System.out.println("Escolha o hospital a que pretende associar o Polo: ");
        int hospitalEscolhido = r.nextInt();
            if(hospitalEscolhido == 0 || hospitalEscolhido > numeroHospitais){
                System.out.println("Insira um hospital válido!");
                limpar();
                menuHospital();
            }else{
               String hospitalAssociado = unidadesHospitalares[hospitalEscolhido - 1].getNomeHospital();
                System.out.println("O hospital associado a este polo é: " + hospitalAssociado);
                polos[numeroPolos - 1].setPolo(nome, nTel, morada, hospitalAssociado);
                System.out.println("Polo criado e associado a um hospital com sucesso!");
            }
        dormir(6000);
        limpar();
        menuHospital();
    }
    public void mostrarPolos(){
        if (numeroPolos == 0){
            System.out.println("Não foram criados quaisquer polos!");
        }else{
            System.out.println("==== Polos ====");
            for (int i = 0; i < numeroPolos; i++){
                polos[i].getPolo();
                System.out.println("====");
                }
            System.out.println("Aqui acima estão listados todos os polos existentes de momento e os respetivos nomes dos hospitais a que pertencem.");
        }
        dormir(5000);
        limpar();
        mostrarMenu();
    }
    public void menuConsultas(){
        String opcao;
        System.out.println("==== ÁREA CONSULTAS ====");
        System.out.println("1 - Marcar Consulta");
        System.out.println("2 - Desmarcar Consulta");
        System.out.println("3 - Mostrar consultas");
        System.out.println("4 - Mostrar consultas por data específica");
        System.out.println("5 - Mostrar consultas por intervalo de data");
        System.out.println("6 - Tempo médio da consulta");
        System.out.println("7 - Tempo médio da consulta por data");
        System.out.println("8 - Guardar consulta");
        System.out.println("9 - Ler consultas");
        System.out.println("10 - Mostrar consultas por especialidade");
        System.out.println("11 - Mostrar consultas por utente");
        System.out.println("12 - Atualizar enfermeiros de uma consulta");
        System.out.println("0 - Sair");
        opcao = r.nextLine();
        switch (opcao){
            case "1":
                limpar();
                marcarConsulta();
                break;
            case "2":
                limpar();
                desmarcarConsulta();
                break;
            case "3":
                limpar();
                mostrarConsulta();
                break;
            case "4":
                limpar();
                mostrarConsultaData();
                break;
            case "5":
                limpar();
                mostrarConsutaIntervaloData();
                break;
            case "6":
                limpar();
                tempoMedioConsulta();
                break;
            case "7":
                limpar();
                tempoMedioConsultaData();
                break;
            case "8":
                limpar();
                guardarConsulta();
                break;
            case "9":
                limpar();
                //lerConsultas();
                break;
            case "0":
                limpar();
                mostrarMenu();
                break;
            case "10":
                limpar();
                mostrarConsultasEspecialidadeEIntervaloDatas();
                break;
            case "11":
                limpar();
                mostrarConsultasUtentesEIntervaloDatas();
                break;
            case "12":
                limpar();
                alterarEnfermeirosConsulta();
                break;
            default:
                limpar();
                System.out.println("Insira uma opção válida!");
                dormir(2000);
                limpar();
                menuConsultas();
                break;
        }
    }
    public void marcarConsulta(){
        String escolhaMedico;
        String escolhaEnfermeiros;
        int localConsulta;
        int escolhaUtente;
        int escolhaUSF;
        int escolhaHospitalConsulta;
        String dataEhora;
        Date dataEhoraRegisto;
        String edificioSala;
        String escolhaPolo;
        String escolhaMedicoConsulta = "";
        String escolhaUtenteConsulta;
        String escolhaLocalConsulta = "";
        String especialidadeConsulta = "Não tem especialidade";
        String escolhaEnfermeirosConsulta = "Não existem enfermeiros para esta consulta";
        System.out.println("==== Adicionar Consulta ====");
        System.out.println("Indique onde irá ser a sua consulta:");
        System.out.println("1 - USF");
        System.out.println("2 - Hospital");
        localConsulta = r.nextInt();
        System.out.println("==== Marcar consulta");
        System.out.println("Insira a data e hora da consulta com o seguinte formato (dd/MM/yyyy HH:mm):");
        r.nextLine();
        dataEhora = r.nextLine();
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        dataEhoraRegisto = new Date();
        for(int i = 0 ; i < numeroTrabalhador ; i++){
            if (pessoaTrabalhador[i].getCatProf().equals("Médico")){
                System.out.println(pessoaTrabalhador[i].getProfMarcarConsulta());
            }
        }
        if(numeroTrabalhador == 0 ){
            System.out.println("Não existem médicos!");
            menuConsultas();
        }
        System.out.println("Escolha o médico da consulta: (digite a cédula profissional)");
        escolhaMedico = r.nextLine();
        for (int i = 0; i < numeroTrabalhador; i++){
            if(escolhaMedico.equals(pessoaTrabalhador[i].getCedulaProf())){
                 escolhaMedicoConsulta = pessoaTrabalhador[i].getProfMarcarConsulta();
                 especialidadeConsulta = pessoaTrabalhador[i].getEspecialidade();
            }
        }
        if (escolhaMedicoConsulta.equals("N/A")){
            System.out.println("Cédula inválida!");
            menuConsultas();
        }
        for (int i = 0 ; i < numeroUtentes ; i++){
            System.out.printf((i+1) + " - ");
            pessoaUtente[i].getUtenteConsulta();
        }
        System.out.println("Escolha o Utente:");
        escolhaUtente = r.nextInt();
        escolhaUtenteConsulta =  pessoaUtente[escolhaUtente - 1].getUtenteMarcarConsulta();
        if(localConsulta == 1){
            for (int i = 0 ; i < numeroUSF ; i++){
                System.out.printf((i+1) + " - ");
                System.out.println(unidadesDeSaude[i].getUsfConsulta());
            }
            System.out.println("Escolha a USF:");
            escolhaUSF = r.nextInt();
            r.nextLine();
            escolhaLocalConsulta = unidadesDeSaude[escolhaUSF - 1].getUsfConsulta();
            numeroConsultas++;
            consultas[numeroConsultas - 1] = new Consulta();
            consultas[numeroConsultas - 1].setConsulta(numeroConsultas, dataEhora, dataEhoraRegisto, "N/A",escolhaLocalConsulta, escolhaMedicoConsulta, escolhaUtenteConsulta, especialidadeConsulta,escolhaEnfermeirosConsulta.toString());
            System.out.println("Consulta marcada com sucesso!");
        }else{
            r.nextLine();
            System.out.println("Insira o Edificio/Sala:");
            edificioSala = r.nextLine();
            for (int i = 0; i < numeroHospitais ; i++){
                System.out.printf((i+1) + " - ");
                System.out.println(unidadesHospitalares[i].getNomeHospital());
            }
            System.out.println("Escolha o Hospital");
            escolhaHospitalConsulta = r.nextInt();
            for (int i = 0 ; i <numeroPolos ; i++){
                if (polos[i].getHospitalAssociado().equals(unidadesHospitalares[escolhaHospitalConsulta - 1].getNomeHospital())){
                    System.out.println(polos[i].getPoloConsulta());
                }
            }
            r.nextLine();
            System.out.println("Escolha o polo (insira o nome)");
            escolhaPolo = r.nextLine();
            for (int i = 0 ; i < numeroPolos ; i++){
                if (escolhaPolo.equals(polos[i].getNomePolo())){
                    escolhaLocalConsulta = polos[i].getPoloConsulta();
                }
            }
            if (escolhaLocalConsulta.equals("N/A")){
                System.out.println("Polo inválido");
                menuConsultas();
            }
            System.out.println("A consulta necessecita de enfermeiros? (sim/não)");
            escolhaEnfermeiros = r.nextLine();
            int contadorEnfermeirosDisp = 0;
            if(escolhaEnfermeiros.equalsIgnoreCase("sim")){
                int enfermeirosNecessarios;
                for (int i = 0 ; i < numeroTrabalhador ; i++){
                    if (pessoaTrabalhador[i].getCatProf().equals("Enfermeiro")){
                        contadorEnfermeirosDisp++;
                    }
                }
                System.out.println("De quantos Enfermeiros precisa? (Existem " + contadorEnfermeirosDisp + " enfermeiros disponíveis)");
                enfermeirosNecessarios = r.nextInt();
                String enfermeirosDaConsulta[] = new String[enfermeirosNecessarios];
                if (enfermeirosNecessarios <=0 || enfermeirosNecessarios > contadorEnfermeirosDisp  ){
                    System.out.println("Resposta inválida");
                    menuConsultas();
                }
                for (int i = 0 ; i < numeroTrabalhador ; i++){
                    if (pessoaTrabalhador[i].getCatProf().equals("Enfermeiro")){
                        System.out.println(pessoaTrabalhador[i].getProfMarcarConsulta());
                    }
                }
                r.nextLine();
                for (int i = 0 ; i < enfermeirosNecessarios ; i++){
                    System.out.println("Escolha o "+ (i+1)+ " enfermeiro (Digite a cédula Profissional)");
                    enfermeirosDaConsulta[i] = r.nextLine();
                }
                for (int i = 0; i < enfermeirosNecessarios; i++) {
                    for (int j = 0; j < numeroTrabalhador; j++) {
                        if (enfermeirosDaConsulta[i] != null) {
                            if (enfermeirosDaConsulta[i].equals(pessoaTrabalhador[j].getCedulaProf())) {
                                enfermeirosDaConsulta[i] = pessoaTrabalhador[j].getProfMarcarConsulta();
                            }
                        }
                    }
                }
                for (int i = 0; i < enfermeirosNecessarios; i++){
                    StringBuffer sb = new StringBuffer();
                    System.out.println(enfermeirosDaConsulta[i]);
                    sb.append(enfermeirosDaConsulta[i]);
                    escolhaEnfermeirosConsulta= Arrays.toString(enfermeirosDaConsulta);
                }
                numeroConsultas++;
                consultas[numeroConsultas - 1] = new Consulta();
                consultas[numeroConsultas - 1].setConsulta(numeroConsultas, dataEhora, dataEhoraRegisto, edificioSala,escolhaLocalConsulta, escolhaMedicoConsulta, escolhaUtenteConsulta, especialidadeConsulta,escolhaEnfermeirosConsulta);
            }else{
                numeroConsultas++;
                consultas[numeroConsultas - 1] = new Consulta();
                consultas[numeroConsultas - 1].setConsulta(numeroConsultas, dataEhora, dataEhoraRegisto, edificioSala,escolhaLocalConsulta, escolhaMedicoConsulta, escolhaUtenteConsulta, especialidadeConsulta,escolhaEnfermeirosConsulta);
            }
        }
        dormir(1000);
        limpar();
        menuConsultas();
    }
    public void desmarcarConsulta(){
        Consulta apagarConsulta[] = new Consulta[numeroConsultas];
        System.out.println("==== Apagar Consulta ====");
        int escolhaApagarConsulta;
        for (int i = 0; i < numeroConsultas; i++){
            System.out.println("====" + (i+1) + "====");
            consultas[i].getConsulta();
        }
        System.out.println("Escolha a Consulta que pretende eliminar: ");
        escolhaApagarConsulta = r.nextInt();
        if (escolhaApagarConsulta < 0 || escolhaApagarConsulta > numeroConsultas){
            System.out.println("Escolha uma consulta válida!");
        }else {
            escolhaApagarConsulta -= 1;
            for (int i = 0; i < numeroConsultas; i++){
                if (i < escolhaApagarConsulta){
                    apagarConsulta[i] = consultas[i];
                } else if (i > escolhaApagarConsulta) {
                    apagarConsulta [i - 1] = consultas[i];
                }
            }
            consultas = apagarConsulta;
            numeroConsultas -= 1;
            System.out.println("Consulta apagada com sucesso!");
        }
        menuConsultas();
    }
    public void mostrarConsulta(){
        if (numeroConsultas == 0){
            System.out.println("Não existem consultas!");
            dormir(3000);
        }else {
            for (int i = 0; i < numeroConsultas ; i++){
                consultas[i].getConsulta();
            }
        }
        dormir(6000);
        limpar();
        menuConsultas();
    }
    public void mostrarConsultaData(){
        if (numeroConsultas == 0) {
            System.out.println("Não existem Consultas!");
            dormir(3000);
            limpar();
            menuConsultas();
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("==== Pesquisa de Consultas por Data ====");
        System.out.println("Insira a data a pesquisar (exemplo: 20/04/2024): ");
        String lerDataPesquisa = r.nextLine();
        LocalDate dataPesquisa = LocalDate.parse(lerDataPesquisa, formato);
        for (int i =0 ; i< numeroConsultas ; i++){
            String dataFiltrada = consultas[i].getConsultaData();
            LocalDate confirmarData = LocalDate.parse(dataFiltrada, formato);
            if(confirmarData.isEqual(dataPesquisa)) {
                consultas[i].getConsulta();
                System.out.println();
                System.out.println("========");
            }
        }
        System.out.println("Aqui acima estão listadas todas as consultas disponíveis de momento.");
        dormir(3000);
        limpar();
        menuConsultas();
    }
    public void alterarEnfermeirosConsulta(){
        int escolhaAtualizarEnfConsulta;
        String escolhaEnfermeiros = "N/A";
        String escolhaEnfermeiroAdicionar;
        String enfermeiroEscolha;
        String escolhaEnfermeirosConsulta = "";
        System.out.println("==== Alteração de  enfermeiros de uma consulta");
        for (int i = 0 ; i < numeroConsultas ; i++){
            System.out.println(("==== " + (i+1) +" ==== "));
            if(!consultas[i].getEnfermeirosConsulta().equals("Não existem enfermeiros para esta consulta")){
                consultas[i].getConsulta();
            }
        }
        System.out.println("Escolha a consulta atualizar: ");
        escolhaAtualizarEnfConsulta = r.nextInt();
        if (escolhaAtualizarEnfConsulta == 0 || escolhaAtualizarEnfConsulta > numeroConsultas){
            System.out.println("Escolha um consulta válida");
            menuConsultas();
        }else{
            System.out.println("Consulta Selecionada - Dados Atuais");
            consultas[escolhaAtualizarEnfConsulta - 1].getConsulta();
            System.out.println("========");
            System.out.println("Dados a atualizar: ");
            int enfermeirosNecessarios;
            int contadorEnfermeirosDisp = 0;
            for (int i = 0 ; i < numeroTrabalhador ; i++){
                if (pessoaTrabalhador[i].getCatProf().equals("Enfermeiro")){
                    contadorEnfermeirosDisp++;
                }
            }
            System.out.println("De quantos Enfermeiros precisa? (Existem " + contadorEnfermeirosDisp + " enfermeiros disponíveis)");
            enfermeirosNecessarios = r.nextInt();
            String enfermeirosDaConsulta[] = new String[enfermeirosNecessarios];
            if (enfermeirosNecessarios <=0 || enfermeirosNecessarios > contadorEnfermeirosDisp  ){
                System.out.println("Resposta inválida");
                menuConsultas();
            }
            for (int i = 0 ; i < numeroTrabalhador ; i++){
                if (pessoaTrabalhador[i].getCatProf().equals("Enfermeiro")){
                    System.out.println(pessoaTrabalhador[i].getProfMarcarConsulta());
                }
            }
            r.nextLine();
            for (int i = 0 ; i < enfermeirosNecessarios ; i++){
                System.out.println("Escolha o "+ (i+1)+ " enfermeiro (Digite a cédula Profissional)");
                enfermeirosDaConsulta[i] = r.nextLine();
            }
            for (int i = 0; i < enfermeirosNecessarios; i++) {
                for (int j = 0; j < numeroTrabalhador; j++) {
                    if (enfermeirosDaConsulta[i] != null) {
                        if (enfermeirosDaConsulta[i].equals(pessoaTrabalhador[j].getCedulaProf())) {
                            enfermeirosDaConsulta[i] = pessoaTrabalhador[j].getProfMarcarConsulta();
                        }
                    }
                }
            }
            for (int i = 0; i < enfermeirosNecessarios; i++){
                StringBuffer sb = new StringBuffer();
                System.out.println(enfermeirosDaConsulta[i]);
                sb.append(enfermeirosDaConsulta[i]);
                escolhaEnfermeirosConsulta= Arrays.toString(enfermeirosDaConsulta);
                System.out.println(escolhaEnfermeirosConsulta);
            }
            consultas[escolhaAtualizarEnfConsulta - 1 ].setEnfermeirosConsulta(escolhaEnfermeirosConsulta);
            dormir(2000);
            limpar();
            menuConsultas();
        }
    }
    public void mostrarConsultasEspecialidadeEIntervaloDatas(){
        String especialidades[] = new String[numeroTrabalhador];
        String escolhaEspecialidade;
        String escolhaDiaFiltro;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0 ; i < numeroTrabalhador ; i++){
            especialidades[i] = pessoaTrabalhador[i].getEspecialidade();
        }
        for(int i = 0; i < especialidades.length; i++){
            boolean especialidadeDuplicada = false;
            for (int j = 0; j < i; j++) {
                if (especialidades[i].equals(especialidades[j])) {
                    especialidadeDuplicada = true;
                    break;
                }
            }
            if (!especialidadeDuplicada) {
                System.out.println(especialidades[i]);
            }
        }
        System.out.println("Insira a especialidade pretendida: ");
        escolhaEspecialidade = r.nextLine();
        System.out.println("Insira o intervalo de data (exemplo: 20/04/2024 - 30/04/2024): ");
        escolhaDiaFiltro = r.nextLine();
        String inputInicioData = escolhaDiaFiltro.substring(0, 10);
        LocalDate inicioData = LocalDate.parse(inputInicioData, formato);
        String inputFimData = escolhaDiaFiltro.substring(13, 23);
        LocalDate fimData = LocalDate.parse(inputFimData, formato);
        for (int i =0 ; i< numeroConsultas ; i++){
            String dataFiltrada = consultas[i].getConsultaData();
            LocalDate confirmarData = LocalDate.parse(dataFiltrada, formato);
            if(!confirmarData.isBefore(inicioData) && !confirmarData.isAfter(fimData) && consultas[i].getEspecialidadeConsulta().equals(escolhaEspecialidade)) {
                consultas[i].getConsulta();
                System.out.println("========");
            }
        }
        dormir(3000);
        limpar();
        menuConsultas();
    }
    public void mostrarConsultasUtentesEIntervaloDatas(){
        int escolhaUtente;
        String escolhaDiaFiltro;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0 ; i < numeroUtentes ; i++){
            System.out.println(("==== " + (i+1) +" ==== "));
            pessoaUtente[i].getUtente();
        }
        System.out.println("Insira o utente que pretenda: ");
        escolhaUtente = r.nextInt();
        r.nextLine(); // limpar o imput buffer
        String utenteEscolhido = pessoaUtente[escolhaUtente - 1].getUtenteMarcarConsulta();
        System.out.println(utenteEscolhido);
        System.out.println("Insira o intervalo de data (exemplo: 20/04/2024 - 30/04/2024): ");
        escolhaDiaFiltro = r.nextLine();
        String inputInicioData = escolhaDiaFiltro.substring(0, 10);
        LocalDate inicioData = LocalDate.parse(inputInicioData, formato);
        String inputFimData = escolhaDiaFiltro.substring(13, 23);
        LocalDate fimData = LocalDate.parse(inputFimData, formato);
        for (int i =0 ; i< numeroConsultas ; i++){
            String dataFiltrada = consultas[i].getConsultaData();
            LocalDate confirmarData = LocalDate.parse(dataFiltrada, formato);
            if(!confirmarData.isBefore(inicioData) && !confirmarData.isAfter(fimData) && pessoaUtente[i].getUtenteMarcarConsulta().equals(utenteEscolhido)){
                consultas[i].getConsulta();
                System.out.println("========");
            }
        }
        dormir(3000);
        limpar();
        menuConsultas();
    }
    public void mostrarConsutaIntervaloData(){
        if (numeroConsultas == 0) {
            System.out.println("Não existem Consultas!");
            dormir(3000);
            limpar();
            menuConsultas();
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("==== Pesquisa de Consultas por Intervalo de Data ====");
        System.out.println("Insira o intervalo de data (exemplo: 20/04/2024 - 30/04/2024): ");
        String intervaloData = r.nextLine();
        String inputInicioData = intervaloData.substring(0, 10);
        LocalDate inicioData = LocalDate.parse(inputInicioData, formato);
        String inputFimData = intervaloData.substring(13, 23);
        LocalDate fimData = LocalDate.parse(inputFimData, formato);
        for (int i =0 ; i< numeroConsultas ; i++){
            String dataFiltrada = consultas[i].getConsultaData();
            LocalDate confirmarData = LocalDate.parse(dataFiltrada, formato);
            if(!confirmarData.isBefore(inicioData) && !confirmarData.isAfter(fimData)) {
                consultas[i].getConsulta();
                System.out.println();
                System.out.println("========");
            }
        }
        System.out.println("Aqui acima estão listadas todas as consultas disponíveis de momento.");
        dormir(3000);
        limpar();
        menuConsultas();
    }
    public void tempoMedioConsulta(){

    }
    public void tempoMedioConsultaData(){
        if (numeroConsultas == 0) {
            System.out.println("Não existem Consultas!");
            dormir(3000);
            limpar();
            menuConsultas();
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("==== Pesquisa de Consultas por Intervalo de Data ====");
        System.out.println("Insira o intervalo de data (exemplo: 20/04/2024 - 30/04/2024): ");
        String intervaloData = r.nextLine();
        String inputInicioData = intervaloData.substring(0, 10);
        LocalDate inicioData = LocalDate.parse(inputInicioData, formato);
        String inputFimData = intervaloData.substring(13, 23);
        LocalDate fimData = LocalDate.parse(inputFimData, formato);
        int mediaHorasRealizacaoConsulta;
        int contadorConsulta = 0;
        long intervalo = 0;
        for (int i =0 ; i< numeroConsultas ; i++){
            String dataFiltrada = consultas[i].getConsultaData();
            LocalDate confirmarData = LocalDate.parse(dataFiltrada, formato);
            if(!confirmarData.isBefore(inicioData) && !confirmarData.isAfter(fimData)) {
                String dataDaConsulta = consultas[i].getConsultaData();
                String dataDoResgisto = consultas[i].getConsultaDataRegisto();
                LocalDate dataDaConsultaFormatada = LocalDate.parse(dataDaConsulta, formato);
                LocalDate dataDoRegistoFormatada = LocalDate.parse(dataDoResgisto, formato);
                dataDaConsulta = dataDaConsultaFormatada.format(formato);
                LocalDate dataDaConsultaFormatadaNova = LocalDate.parse(dataDaConsulta, formato);
                dataDoResgisto = dataDoRegistoFormatada.format(formato);
                LocalDate dataDoRegistoFormatadaNova = LocalDate.parse(dataDoResgisto, formato);
                intervalo += DAYS.between(dataDoRegistoFormatadaNova,dataDaConsultaFormatadaNova);
                System.out.println(intervalo);
                contadorConsulta++;
            }
            System.out.println(intervalo);
            System.out.println("O tempo médio entre a marcação de uma consulta e a sua realização é de " + (intervalo/contadorConsulta) + " dias");
        }
    }
    public void guardarConsulta(){
        try {
            FileWriter myWriter = new FileWriter("consultas.txt");
            for (int i = 0 ; i < numeroConsultas ; i++){
                myWriter.write(consultas[i].getConsultaWriteFile());
            }
            myWriter.write("==========");
            myWriter.close();
            System.out.println("Consultas escritas no ficheiro com sucesso");
        } catch (IOException e) {
            System.out.println("ERRO!");
            e.printStackTrace();
        }
    }
    public void lerConsultas(){

    }
    public void atualizarPolo(){
        int escolhaAtualizarPolo;
        String nome;
        int nTelefone;
        String morada;
        String hospital = "";
        System.out.println("==== Atualizar Polo ====");
        for (int i = 0; i < numeroPolos; i++){
            System.out.println(("==== " + (i+1) +" ==== "));
            polos[i].getPolo();
        }
        System.out.println("Escolha o Polo a atualizar: ");
        escolhaAtualizarPolo = r.nextInt();
        if (escolhaAtualizarPolo == 0 || escolhaAtualizarPolo > numeroPolos){
            System.out.println("Escolha um Polo válido.");
            menuHospital();
        }else{
            System.out.println("Polo Selecionado - Dados Atuais");
            polos[escolhaAtualizarPolo - 1].getPolo();
            System.out.println("========");
            System.out.println("Dados a atualizar: ");
            System.out.println("Introduza o nome do Polo: ");
            r.nextLine();
            nome = r.nextLine();
            System.out.println("Introduza o contacto do Polo: ");
            nTelefone = r.nextInt();
            r.nextLine();
            System.out.println("Introduza a morada do Polo: ");
            morada = r.nextLine();
            for (int i =0 ; i< numeroHospitais ; i++) {
                System.out.println(("==== " + (i+1) +" ==== "));
                String mostrarHospitais = unidadesHospitalares[i].getNomeHospital();
                System.out.println(mostrarHospitais);
            }
            System.out.println("Escolha da lista de hospitais o hospital que quer associar: ");
             int escolhaHospital = r.nextInt();
            if (escolhaHospital <= 0 || escolhaHospital > numeroHospitais){
                System.out.println("Escolha um hospital válido");
                menuHospital();
            } else{
                unidadesHospitalares[escolhaHospital - 1].getNomeHospital();
                System.out.println("O hospital associado a este polo é: " + escolhaHospital);
            }
            String hospitalAssociado = unidadesHospitalares[escolhaHospital -1].getNomeHospital();
            polos[escolhaAtualizarPolo - 1].setPolo(nome, nTelefone, morada, hospitalAssociado);
            limpar();
            System.out.println("Polo atualizado com sucesso!");
            dormir(2000);
            limpar();
            menuHospital();
        }
    }
    public void apagarPolo(){
        Polo apagarPolo[] = new Polo[numeroPolos];
        System.out.println("==== Apagar Polo ====");
        int escolhaApagarPolo;
        for (int i = 0; i < numeroPolos; i++){
            System.out.println("====" + (i+1) + "====");
            polos[i].getPolo();
        }
        System.out.println("Escolha o polo que pretende eliminar: ");
        escolhaApagarPolo = r.nextInt();
        if (escolhaApagarPolo < 0 || escolhaApagarPolo > numeroPolos){
            System.out.println("Escolha um polo válido!");
            menuHospital();
            limpar();
        }else {
            escolhaApagarPolo -= 1;
            for (int i = 0 ; i < numeroPolos; i++){
                if ( i < escolhaApagarPolo){
                    apagarPolo[i] = polos[i];
                }else if(i > escolhaApagarPolo){
                    apagarPolo[i - 1] = polos[i];
                }
            }
            polos = apagarPolo;
            numeroPolos -= 1;
            System.out.println("Polo apagado com sucesso!");
        }
        limpar();
        menuHospital();
        }
    public static void limpar(){
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
    }
    public static void dormir(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
