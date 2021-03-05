/**
 * Universidade Católica Dom Bosco
 * Atividade: Hash linear com vetor de String
 * Academico: Thayane Batista RA159049
 * Docente: Marcos Alves
 * Disciplina: Estrutura de dados II
 */
package hash_linear_vetor;

import java.lang.String;
import java.math.BigInteger;

/**
 * @author ra159049
 *
 *
 */
class HashLinear {

    private int maxTam, tamAtual;
    private String[] chaves;
    private String[] valores;

    /**
     * construtor para nosso hash linear que define o tamanho da string com o
     * tamanho maximo
     *
     * @param tamanho
     */
    public HashLinear(int tamanho) {
        tamAtual = 0;
        maxTam = tamanho;
        chaves = new String[maxTam];
        valores = new String[maxTam];
    }

    /**
     * a função hashcode vai gerar um codigo que vai representar o valor que o
     * usuario fornecer
     *
     * @param chave
     * @return
     */
    private int hash(String ch) {
        return ch.hashCode() % maxTam;
    }

    /**
     * esta função verifica se o vetor esta cheio no caso se o tamanho atual do
     * vetor for igual ao tamanho definido pelo usuario
     *
     * @return
     */
    public boolean vetor_cheio() {
        return tamAtual == maxTam;
    }

    /**
     * a função equals ira comprar se a chave sera igual a chave recebida como
     * parametro e devolver o valor buscado caso tenha
     *
     * @param ch
     * @return
     */
    public String busca(String ch) {
        int i = hash(ch);
        while (chaves[i] != null) {
            if (chaves[i].equals(ch)) {
                return valores[i];
            }
            i = (i + 1) % maxTam;
        }
        return null;
    }

    /**
     * Função insere um novo valor no vetor de string com uma chave
     *
     * @param ch
     * @param val
     */
    public void Insere_Hash(String ch, String val) {

        int aux = hash(ch);
        int i = aux;
        do {
            if (chaves[i] == null) {
                chaves[i] = ch;
                valores[i] = val;
                tamAtual++;
                return;
            }
            if (chaves[i].equals(ch)) {
                valores[i] = val;
                return;
            }
            i = (i + 1) % maxTam;
        } while (i != aux);
    }

    /**
     * Função para imprimir o hash
     */
    public void imprimir() {
        for (int i = 0; i < maxTam; i++) {
            if (chaves[i] != null) {
                LE.show("Tabela Hash:\n\n" + "RA:" + chaves[i] + "\nAcademico:" + valores[i]);
            }
        }
    }
}

public class HashLinearTeste {

    public static void main(String[] args) {

        /* Scanner scan = new Scanner(System.in);
        System.out.println("*****     Hash Linear     *****");
        System.out.println("***** by: Thayane Batista *****");

        System.out.println("\nDigite o tamanho do vetor:");

        HashLinear hl = new HashLinear(scan.nextInt());
         */
        HashLinear hl = new HashLinear(LE.readIntPane("Hash Linear"
                + "\n(by: Thayane Batista)"
                + "\n\nDigite o tamanho do vetor:"));
        char op;

        do {
            int esc = LE.readIntPane(
                    "HASH LINEAR"
                    + "\n 1. inserir"
                    + "\n 2. buscar"
                    + "\n 3. imprimir"
                    + "\n\n");

            switch (esc) {
                case 1:

                    hl.Insere_Hash(LE.readStringPane("Digite o RA(numeros)"), LE.readStringPane("Nome do Academico:"));
                    break;
                case 2:
                    LE.show(hl.busca(LE.readStringPane("Digite um RA(numeros) para busca:")));
                    break;
                case 3:
                    hl.imprimir();
                    break;
                case 4:
                    break;
                default:
                    LE.show("Opção invalida!");
                    break;
            }
            op = LE.readCharPane("Deseja continuar? (s= sim ou n=nao)\n");

            //   op = scan.next().charAt(0);
        } while (op == 'S' || op == 's' || op == 4);
    }
}
