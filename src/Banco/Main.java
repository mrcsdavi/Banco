package Banco;

import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        Banco conta1 = new Banco();



        while (true){
            if(!conta1.isStatus()){
                System.out.println("\n" + "Escolha o que voce deseja fazer: " + "\n"
                        + "1- Abrir uma conta" + "\n" + "2- Ver os dados da sua conta" + "\n" +
                        "3- Depositar saldo" + "\n" + "4- Sacar saldo" + "\n" + "5- Fechar uma conta");
            }else{
                System.out.println("\n" + "Ola " + conta1.getDono() + ", escolha o que voce deseja fazer: " + "\n"
                        + "1- Abrir uma conta" + "\n" + "2- Ver os dados da sua conta" + "\n" +
                        "3- Depositar saldo" + "\n" + "4- Sacar saldo" + "\n" + "5- Fechar uma conta");
            }

            System.out.println("///\n" + "Digite aqui a sua escolha: ");
            int escolha = scan.nextInt();

            switch (escolha){
                case 1:
                    if(!conta1.isStatus()){
                        System.out.println("Digite o seu nome: ");
                        scan.nextLine();
                        String nomeDono = scan.nextLine().toUpperCase();
                        conta1.setDono(nomeDono);


                        System.out.println("Qual o seu tipo da conta?: 'cc' para Conta Corrente" +
                                            " e 'cp' para Conta Poupanca");
                        String contaTipo = scan.nextLine().toLowerCase();

                        conta1.setTipo(contaTipo);
                        conta1.abrirConta();
                        }else{
                            conta1.abrirConta();
                        }
                        break;
                case 2:
                    conta1.dadosConta();
                    break;
                case 3:
                    if(!conta1.isStatus()) {
                        System.out.println("> Voce nao tem uma conta no banco");
                        break;
                    }

                    while(true){

                        int valor = 0;
                        System.out.println("SALDO ATUAL: " + conta1.getSaldo());
                        System.out.println("Deposite um valor: ");
                        valor = scan.nextInt();

                        if(valor > 0){

                            System.out.println("Valor de: " + valor + " foi depositado na sua conta");
                            conta1.depositar(valor);

                        }else{
                            System.out.println("ERRO! DIGITE UM VALOR VALIDO");
                            break;
                        }
                        break;
                    }
                    break;
                case 4:
                    if(!conta1.isStatus()){
                        System.out.println("> Voce nao tem uma conta no banco.");
                        break;
                    }


                    while(true){

                        System.out.println("Digite o valor que voce quer sacar");
                        System.out.println("SALDO DISPONIVEL: " + conta1.getSaldo());
                        int valor = scan.nextInt();

                        if(valor > 0){
                            conta1.sacar(valor);
                        }else{
                            System.out.println("ERRO! DIGITE UM NUMERO VALIDO.");
                            break;
                        }
                        break;
                    }
                    break;

                case 5:
                    if(conta1.isStatus()){
                        while(true) {
                            int numeroAleatorio = random.nextInt();
                            System.out.println("Digite a senha seguinte para fechar a sua conta: ");
                            System.out.println(numeroAleatorio);

                            System.out.println("Digite a senha para fechar a sua conta: ");

                            int senha = scan.nextInt();

                            if (senha == numeroAleatorio) {
                                conta1.fecharConta();
                                break;
                            } else {
                                System.out.println("\nERRO! SENHA DIGITADA INCORRETAMENTE.\n");
                            }
                        }
                    }else{
                        System.out.println("> Voce nao tem uma conta no banco.");
                        break;
                    }
                    break;
                default:
                    System.out.println("---------" + "\n" + "OPCAO ESCOLHIDA INCORRETA" + "\n" + "---------");
                    break;
            }
        }

    }
}
