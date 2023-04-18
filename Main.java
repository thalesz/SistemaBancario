import java.util.Scanner;


class Conta{
    int numero;
    String nome;
    double saldo;
    //String 
    Conta(int numero, String nome){
        setNumero(numero);
        setNome(nome);
        setSaldo(0);
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    public int getNumero(){
        return this.numero;
    }
    public String getNome(){
        return this.nome;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void depositar(double valor){
        this.saldo += valor;
    }
    public void sacar(double valor){
        try{
            if(valor > this.getSaldo() ||valor <= 0){
                throw new Exception();
            }

            this.setSaldo(this.getSaldo()-valor);
            System.out.println("Operacao concluida");
            System.out.println();

        }catch(Exception e){
            System.out.println("Valor invalido, operacao cancelada");
            System.out.println();
        }
    }
    public void depositar(Conta destino, double valor){
        try{
            if (valor <= 0 || valor > saldo) {
                throw new Exception();
            }
            this.setSaldo(this.getSaldo()-valor);
            destino.depositar(valor);
            System.out.println("Operacao concluida");
            System.out.println();
           //System.out.println("\nTransferência realizada com sucesso.");
        }catch(Exception e){
            System.out.println("Valor invalido, operacao cancelada");
            System.out.println();
        }  
    }
    public void imprimir(){
        System.out.print("Nome - " + this.getNome());
        System.out.print(" | Numero da conta - " + this.getNumero());
        System.out.printf(" | Saldo - %.2f\n", this.getSaldo());
        System.out.println();
    }
}
class Agencia{
    int numero;
    String nome;
    int numCt;
    Conta[] contas;
    Agencia(int numero, String nome){

        this.numero=numero;
        this.nome=nome; 
        contas= new Conta[10];
        numCt=0;

    }
    public int getNumero(){
        return this.numero;
    }
    public String getNome(){
        return this.nome;
    }
    public void criarConta(int numero, String nomeTitular){
        Conta ct = new Conta(numero, nomeTitular);
        this.contas[numCt]=ct;
        this.numCt++; 
    }
    public void removerConta(int numero){
        int cont = numCt;
        for(int i=0; i < numCt; i++){
            if(this.contas[i].getNumero() == numero){
                for(int j=i; j<numCt-1; j++){
                    this.contas[j]=this.contas[j+1];
                } 
                this.contas[numCt-1]=null;
                numCt--;
                System.out.println("Operacao concluida");
                System.out.println();
                break;   
            }
        }
        if(cont==numCt){
            System.out.println("Numero nao encontrado");
            System.out.println();
        }

    }
    public void listarConta(){
        System.out.println("----CONTAS----");

        for(int i = 0; i< this.numCt;i++){
            System.out.print(i+1);
            System.out.print(".Nome: " + contas[i].getNome()  + " - ");
            System.out.println("Numero: " + contas[i].getNumero());
        }
        System.out.println();
    }
    public Conta selecionarConta(int numero){
        for(int i=0; i<numCt;i++){
            if(numero==contas[i].getNumero()){
                return contas[i];
            }
        }
        return null;
    }
}

class Banco{
    String nome;
    Agencia[] agencias;
    int numAg;
    Banco(String nome){
        this.nome = nome;
        this.agencias = new Agencia[10]; //vai poder armazenar 10 
        this.numAg = 0;
    }
    public String getNome(){

        return this.nome;
        
    }
    public void criarAgencia(int numero, String nome){

        Agencia ag = new Agencia(numero,nome);
        this.agencias[numAg]=ag;
        this.numAg++; 

    }
    public void removerAgencia(int numero){
        int cont = numAg;
        for(int i=0; i<numAg;i++){

            if(this.agencias[i].getNumero()==numero){
                for(int j=i;j<numAg-1;j++){
                    //if(j<10){
                    this.agencias[j]=this.agencias[j+1];
                    //}
                    
                } 
                this.agencias[numAg-1]=null;
                numAg--;
                System.out.println("Operacao concluida");
                System.out.println();
                break;   

            }
        }
        if(cont==numAg){
            System.out.println("Numero nao encontrado");
            System.out.println();
            
        }

    }
    public void listarAgencia(){
        System.out.println("----AGENCIAS----");
        for(int i = 0; i< this.numAg;i++){
            System.out.printf("%d", i+1);
            System.out.printf(". Nome: %s - ", agencias[i].getNome());
            System.out.println("Numero: " + agencias[i].getNumero());
        }
        System.out.println();
    }
    public Agencia selecionarAgencia(int numero){
        for(int i=0; i<numAg;i++){
            if(numero==agencias[i].getNumero()){
                return agencias[i];
            }
        }
        return null;
    }

}
class Main{
    static Scanner s = new Scanner(System.in);
    public static void escreverMenu3(){
        
        //System.out.println();
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Transferir");
        System.out.println("4. Ver Saldo");
        System.out.println("5. Voltar");
    }
    public static void exibirMenu3(Conta ct, Agencia ag){
        int num=0;
        //Scanner s = new Scanner(System.in);
        do{
            System.out.printf("Menu da conta - %s\n",ct.getNome());
            escreverMenu3();
            try{
                num = s.nextInt();
                s.nextLine();
            }catch(Exception e){
                System.out.println("Insira um valor valido");
                System.out.println();
                s.nextLine();
                continue;
            }

            switch(num){
                case 1:
                    System.out.println("Insira o valor que deseja depositar");
                    double valor = s.nextDouble();
                    ct.depositar(valor);
                    System.out.println("Operacao concluida");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Insira o valor que deseja sacar");
                    double saque = s.nextDouble();
                    ct.sacar(saque);
                    
                    //
                    break;
                case 3:
                    System.out.println("Insira o numero da conta que deseja transferir");
                    int conta = s.nextInt();
                    double v;
                    Conta ctt =  ag.selecionarConta(conta);
                    if(ctt!=null){

                        System.out.println("Insira o valor que deseja transferir");
                        v = s.nextDouble();
                        ct.depositar(ctt, v);

                    }else{
                        System.out.println("Numero nao encontrado, operacao cancelada");
                        System.out.println();
                    }
                break;
                case 4: 
                    ct.imprimir();
                break;
                case 5:
                break;
                default:
                    System.out.println("Opcao nao encontrada");


            }
        }while(num!=5);


    }
    public static void escreverMenu2(){
        
        System.out.println("1. Criar conta");
        System.out.println("2. Remover Conta");
        System.out.println("3. Listar Contas");
        System.out.println("4. Selecionar Contas");
        System.out.println("5. Voltar");
    }
    public static void exibirMenu2(Agencia ag){
        int num=0;
        //Scanner sss = new Scanner(System.in);
        do{
            System.out.println("----Menu da agencia " + ag.getNome()+"----");
            escreverMenu2();
            try{
                num = s.nextInt();
                s.nextLine();

            }catch(Exception e){
                System.out.println("Insira um valor valido");
                System.out.println();
                s.nextLine();
                continue;
                
            }
            switch(num){
                case 1:
                    if(ag.numCt==10){
                        System.out.println("Capacidade maxima alcancada");
                        System.out.println();
                        break;
                    }
                    System.out.println("Digite o nome do titular");
                    String nome = s.nextLine();
                    
                    System.out.println("Digite o numero da conta");
                    int num1 = s.nextInt();
                    s.nextLine(); //limpar o buffer
                    ag.criarConta(num1, nome);
                    System.out.println("Operacao concluida");
                    System.out.println();
                    break;      
                case 2:
                    if(ag.numCt==0){
                        System.out.println("Nao eh possivel remover, lista vazia");
                        System.out.println();
                        break;
                    }
                    System.out.println("Digite o numero da conta");
                    int num2 = s.nextInt();
                    ag.removerConta(num2);
                    //System.out.println("Operacao concluida");
                    //System.out.println();
                    break;
                case 3: 
                    ag.listarConta();
                    break;
                case 4:
                    System.out.println("Digite o numero da conta");
                    int num3 = s.nextInt();
                    Conta ct = ag.selecionarConta(num3);
                    if(ag!=null){
                        exibirMenu3(ct,ag);
                    }else{
                        System.out.println("Numero nao encontrado, operacao cancelada");
                        System.out.println();
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcao nao encontrada");
            }
        }while(num!=5);
        
    }

    public static void escreverMenu(){
        System.out.println("----MENU----");
        System.out.println("1. Criar agencia");
        System.out.println("2. Remover agencia");
        System.out.println("3. Listar agencias");
        System.out.println("4. Selecionar agencia ");
        System.out.println("5. Sair");
        //System.out.println();
    }
    public static void exibirMenu(Banco bb){
        System.out.println("Bem vindo ao sistema de gerenciamento do Banco " + bb.getNome());
        System.out.println();
        //Scanner ss = new Scanner(System.in);
        int opc=1;
        do{
            escreverMenu();
            try{
                opc = s.nextInt();
                s.nextLine();
            }catch(Exception e){
                System.out.println("Insira um valor valido");
                System.out.println();
                s.nextLine();
                continue;
            }
            
            switch(opc){
                case 1:
                    if(bb.numAg ==10){
                        System.out.println("Capacidade maxima alcancada");
                        System.out.println();
                        break;
                    }
                    System.out.println("Digite o nome da agencia");
                    String nome = s.nextLine();
                    System.out.println("Digite o numero da agencia");
                    int num = s.nextInt();
                    bb.criarAgencia(num,nome);
                    System.out.println("Operacao concluida");
                    System.out.println();
                    break;
                case 2:
                    if(bb.numAg ==0){
                        System.out.println("Nao eh possivel remover, lista vazia");
                        System.out.println();
                        break;
                    }
                    System.out.println("Digite o numero da agencia");
                    int num2 = s.nextInt();
                    bb.removerAgencia(num2);
                    //System.out.println("Operacao concluida");
                    break;
                case 3:
                    bb.listarAgencia();
                    break;
                case 4:
                    System.out.println("Digite o numero da agencia");
                    int num3 = s.nextInt();
                    Agencia ag = bb.selecionarAgencia(num3);
                    if(ag!=null){
                        exibirMenu2(ag);
                        //break;
                    }else{
                        System.out.println("Numero nao encontrado, operacao cancelada");
                        System.out.println();
                    }
                    
                break;
                case 5:
                    break;
                default:
                    System.out.println("Opcao nao encontrada");
                    System.out.println();
            }
            
            
        }while(opc!=5);
        //ss.close();
        System.out.println("Volte sempre :)");
        System.out.println();
    }
    public static void main(String[] args) {
        Banco bb = new Banco("Icomp");
        exibirMenu(bb);      
    }
}