import java.util.HashMap;
import java.util.Stack;

import static java.lang.Character.isAlphabetic;

public class Main {
    public static void main(String[] args) {
        //Programa  programa abc(DECLARACAO) { COMANDOS }
        //DECLARACAO  abc: TYPE;
        //COMAND  DECLARACAO | IF | RETURN | ATR
        //IF  if (EXP) {COMANDS} | if (EXP) {RETURN} else {RETURN}
        //RETURN  return EXP;
        //EXP  VAR
        //OPERA  == | > | < | >= | <= | !=
        //TYPE  int | boolean | char
        //VAR  abc
        //BOOL  true | false
        //NUMBER  [0-9]NUMBER | [0-9]
        //CHAR  [a-Z]
        //Cada um destes acima equivale a um estado diferente


        Stack pilha = new Stack();
        pilha.push("PROGRAMA");
        Estados atual = Estados.PROGRAMA;
        String entrada = "programa id ( id : int ; ) { if ( id == 0 ) { return id ; } else { return id ; } return id ; }";
        String[] transicoes = atual.getTransicoes();

        if (pilha.peek() == atual.name()) { //checa pra ver se transição existe
            pilha.pop(); //remove o primeiro item da lista

            empilhar(atual.getTransicoes(), pilha);
        }

        while (!entrada.equals("")) {
            String chave;

            if (pilha.empty()) {
                System.out.println("Pilha vazia, passou no teste");
                break;
            }

            if (entrada.indexOf(" ") > 0) {
                chave = entrada.substring(0, entrada.indexOf(" ")); //pega pedaço a ser analisado
            } else {
                chave = entrada;
            }

            if (chave.equals(pilha.peek())) {
                pilha.pop();
                entrada = entrada.substring(entrada.indexOf(" ") + 1); //remove pedaço já analisado
            } else {
                    if (Estados.exists(pilha.peek().toString())) {
                        atual = Estados.valueOf(pilha.peek().toString());
                        transicoes = atual.getTransicoes();
                        pilha.pop();
                        empilhar(transicoes, pilha);
                    } else if (pilha.peek().equals("abc") && chave.matches("[a-zA-Z]+")) {
                        pilha.pop();
                        entrada = entrada.substring(entrada.indexOf(" ") + 1); //remove pedaço já analisado
                    } else {
                        System.out.println("Erro de cadeia");
                        break;
                    }
            }

            System.out.println("Pilha: " + pilha);
            System.out.println("Entrada restante: " + entrada);
            System.out.println("Chave:" + chave);



        }


    }

    public static void empilhar(String[] transicoes, Stack pilha) {
        for (int i = transicoes.length - 1; i >= 0; i--) {
            pilha.push(transicoes[i]); //empilha os novos itens
        }
    }
}
