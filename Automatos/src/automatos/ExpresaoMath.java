package automatos;

import java.util.Scanner;

public class ExpresaoMath {

    public static void main(String[] args) {
        Expressao pilha = new Expressao(6);
        Scanner in = new Scanner(System.in);
        System.out.println("Digite uma expressão algébrica no formato {[()]}\n");
        String expr = in.nextLine();
        
        expr.matches("[a-z]");
       
        for (int i = 0; i <= expr.length() - 1; i++) {
            if (pilha.getDelimitador(expr.charAt(i))) {
                pilha.empilha(expr.charAt(i));
            }
        }
        String aux = pilha.retornaFormato();
        if (aux.equals("")) {
            System.out.println("Expressão Correta");
        } else {
            System.out.println("Expressão Incorreta");
        }
    }
}
