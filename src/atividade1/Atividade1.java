package atividade1;

import java.util.Scanner;

/**
 *
 * @author Vitoria Cristina
 */
public class Atividade1 {

    static Scanner console = new Scanner(System.in);

    static String[] v;

    // Menu para o usuário digitar o que deseja
    static String menu() {
        System.out.println("DIGITE A OPÇÃO DESEJADA");
        System.out.println("1- ADICIONAR UM NOVO NOME");
        System.out.println("2- APRESENTAR UM NOVO NOME");
        System.out.println("3- PESQUISAR UM NOVO NOME");
        System.out.println("4- REMOVER UM NOME");
        System.out.println("0- SAIR");

        String opcao = console.next();

        return opcao;
    }

    //Método que pesquisa o nome a ser digitado, e mostra a posição
    static int pesquisar() {
        System.out.println("PESQUISAR");
        System.out.println("Digite o nome desejado: ");
        String nome = console.next();
        int posicao = -1;
        for (int i = 0; i < v.length; i++) {
            if ((v[i] != null) && (nome.equals(v[i]))) {
                posicao = i;
                break;
            }
        }
        return posicao;
    }
    //Método que remove o nome a ser primeiro pesquisado

    static String removerNome(int posicao) {
        System.out.println("REMOVER NOME...");
        boolean Removeu = false;
        // Aqui está removendo nome
        if ((posicao > -1) && (posicao < v.length) && (v[posicao] != null)) {
            v[posicao] = null;
            Removeu = true;
        }
        //Aqui está colocando o próximo nome no local que está vazio...
        if (Removeu) {
            for (int i = 0; i < v.length; i++) {
                if ((v[i] == null) && ((i + 1) < v.length)) {
                    v[i] = v[i + 1];
                    v[i + 1] = null;
                }
            }
            return "S";
        } else {
            return "N";
        }

    }

    // Apresenta ao usuários os nomes digitados
    static void apresentar() {
        System.out.println("OS NOMES ADICIONADOS FORAM:\n ");
        boolean existemNomes = false;
        for (int i = 0; i < v.length; i++) {

            if (v[i] != null) {
                existemNomes = true;
                System.out.println(v[i]);
            }
        }

        if (!existemNomes) {
            System.out.println("Não existem nomes na lista para serem exibidos!");
        }

    }

    static String AddNome() {
        System.out.println("ADICIONAR NOME...");
        String temespaco = "N";
        String Adicionou = "N";
        for (int i = 0; i < v.length; i++) {

            if (v[i] == null) {
                temespaco = "S";
                break;
            }
        }

        if (temespaco.equals("S")) {
            System.out.println("Digite o nome");
            String Nome = console.next();
            boolean jaExiste = false;
            for (int i = 0; i < v.length; i++) {

                if ((v[i] != null) && (v[i].equals(Nome))) {
                    jaExiste = true;
                    break;
                }
            }
            if (!jaExiste) {

                for (int i = 0; i < v.length; i++) {
                    if ((v[i] == null) || (v[i].equals(null))) {
                        v[i] = Nome;
                        Adicionou = "S";
                        break;
                    }

                }
                return Adicionou;
            } else {
                return "jaExiste";
            }

        } else {
            return "N";
        }

    }

    public static void main(String[] args) {
        String opcao = " ";

        v = new String[50];

        while (!opcao.equals("0")) {
            opcao = menu();

            if (opcao.equals("1")) {
                String retorno = AddNome();
                if (retorno.equals("N")) {
                    System.out.println("Não existem casas disponíveis!!  Não é possível adicionar o nome!!\n");

                } else if (retorno.equals("jaExiste")) {
                    System.out.println("O nome já existe na lista\n");

                } else if (retorno.equals("S")) {
                    System.out.println("Nome adicionado a lista com sucesso!\n");

                } else {
                    System.err.print("ERRO, NOME NÃO ADICIONADO");
                }

            } else if (opcao.equals("2")) {
                apresentar();

            } else if (opcao.equals("3")) {
                int posicao = pesquisar();

                if (posicao == -1) {
                    System.out.println("Nome não foi localizado!");
                } else {
                    System.out.println("Nome localizado na posição " + posicao);
                }

            } else if (opcao.equals("4")) {
                int posicao = pesquisar();

                if (posicao > -1) {
                    String retorno = removerNome(posicao);
                    if (retorno.equals("S")) {
                        System.out.println("Nome removido com sucesso!");

                    } else {
                        System.out.println("Falha na tentativa de remoção do nome");
                    }

                } else {
                    System.out.println("Nome não foi localizado.  Não é possível seguir com a operação solicitada!");
                }

            } else if (!opcao.equals("0")) {
                System.out.println("Opção inválida!");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("");

        }

    }

}
