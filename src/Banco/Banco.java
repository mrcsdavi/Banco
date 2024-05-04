package Banco;

import java.util.Random;
public class Banco {
        Random random = new Random();

        public long numConta;
        protected String tipo; //o (tipo) so aceita dois valores = 'cc' - conta corrente ou 'cp' - conta poupanca
        private String dono;
        private double saldo;
        private boolean status;  // (status)Se a conta estiver aberto - true , se a conta estiver fechada - false
        // Na hora que abrir a conta, deve-se perguntar que tipo de conta ela eh

        public Banco(){
            this.setNumConta(random.nextInt());
            this.status = false;
            this.saldo = 0;
            this.tipo = "";
            this.dono = "";
        }

        public void setNumConta(long numConta) {
            do{
                if(numConta > 0) this.numConta = numConta;
            }while(numConta < 0);
        }

        public long getNumConta() {
            return numConta;
        }

        public void setTipo(String tipo) {
            if (tipo.length() != 2) {
                System.out.println("ERRO! Tamanho de caracteres diferente de 2");
                this.tipo = "";
                return;
            }
            if (tipo.equals("cc")) {
                this.tipo = tipo;
            } else if (tipo.equals("cp")) {
                this.tipo = tipo;
            }else{
                this.tipo = tipo;
                System.out.println("ERRO! Apenas cc e cp sao escolhas para o tipo da sua conta.");
            }
        }

        public String getTipo() {
            return tipo;
        }

        public void setDono(String dono) {

            if(!dono.isEmpty()) this.dono = dono;
        }

        public String getDono() {
            return dono;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public boolean isStatus() {
            return status;
        }

        public void abrirConta(){

            if(status){
                System.out.println("A sua conta já está aberta.");
            } else {
                switch (this.tipo){
                    case "cc":
                        this.setStatus(true);
                        this.setSaldo(50);
                        System.out.println("Conta corrente escolhida.");
                        this.status = true;
                        break;
                    case "cp":
                        this.setStatus(true);
                        this.setSaldo(50);
                        System.out.println("Conta poupanca escolhida.");
                        break;
                }
            }
        }


        public void fecharConta() {

            if (status) {
                if (saldo > 0) {
                    System.out.println("\nNao foi possivel fechar a conta pois ainda ha saldo nela.");
                } else if (saldo < 0) {
                    System.out.println("\nVoce esta em debito, pague imediatamente!");
                } else {
                    System.out.println("CONTA FECHADA! Agradecemos por usar os nossos servicos.");
                    this.setStatus(false);
                }
            }
        }

        public void depositar(float saldo){
            if(status){
                this.saldo += saldo;
            }else{
                System.out.println("> A conta deve estar aberta.");
            }
        }

        public void sacar(float sacarSaldo){

            if(status){
                if(sacarSaldo <= this.saldo){
                    this.saldo -= sacarSaldo;
                    System.out.println("Foi sacado " + sacarSaldo + " da sua conta.");
                }else if(sacarSaldo > getSaldo()){
                    System.out.println("Nao foi possivel sacar. O saldo que voce quer sacar eh maior que o disponivel.\n");
                    System.out.println("SALDO DISPONIVEL: " + this.saldo);
                }else if(this.saldo < 0){
                    System.out.println("Nao eh possivel sacar saldo devedor.");
                }
            }else{
                System.out.println("> A conta deve estar aberta.");
            }
        }

        /* public void pagarMensalidade(){


            if(status){
                switch (tipo){
                    case "cc":
                        this.saldo -= 12;
                        System.out.println("mensalidade de 12 reais paga: " + this.saldo + "\n");
                        break;
                    case "cp":
                        this.saldo -= 20;
                        System.out.println("mensalidade de 20 reais paga: " + this.saldo + "\n");
                        break;
                    default:
                        System.out.println("Saldo insuficiente");
                }
            }else{
                System.out.println("> A conta nao esta aberta.");
            }
        }*/

        public void dadosConta(){
            if(status){
                System.out.println("Numero da conta " + getNumConta());
                System.out.println("Tipo da conta: " + getTipo());
                System.out.println("Dono da conta: " + getDono());
                System.out.println("Saldo: " + getSaldo());
            }else{
                System.out.println("> A conta nao esta aberta.");
            }
        }
}
