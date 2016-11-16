/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*

Transformando Caracteres em numeros da tabela ASCII 

* - 42
+ - 43
- - 45

. - 46
/ - 47
0 - 48
1 - 49
2 - 50
3 - 51
4 - 52
5 - 53
6 - 54
7 - 55
8 - 56
9 - 57
; - 59

61 - = 

A - 65
B - 66
C - 67
D - 68
E - 69
F - 70
G - 71
H - 72
I - 73
J - 74
K - 75
L - 76
M - 77
N - 78
O - 79
P - 80
Q - 81
R - 82
S - 83
T - 84
U - 85
V - 86
W - 87
X - 88
Y - 89
Z - 90

[ - 91
\ - 92
] - 93
^ - 94
_ - 95


a - 97
b - 98
c - 99
d - 100
e - 101
f - 102
g - 103
h - 104
i - 105
j - 106
k - 107
l - 108
m - 109
n - 110
o - 111
p - 112
q - 113
r - 114
s - 115
t - 116
u - 117
v - 118
w - 119
x - 120
y - 121
z - 122

 */
/**
 *
 * @author felipe
 */
public class auto {

    public static void main(String[] args) throws FileNotFoundException {
        //int vl = ValidaVar("testo_");

        ArrayList<Atribuicao> atrs = new ArrayList<Atribuicao>();
        ArrayList<String> oper = new ArrayList<>();
        ArrayList<String> atribuicaoVet = new ArrayList<>();
        String atribuicao = leArquivoAtribuicao();
//        Pilha<String> pilha = new Pilha<>();
        atrs = leArquivoValores();
        String[] splitAtribuicao = atribuicao.split(" ");
        int statusatrib = 0;
        double result = 0;

        System.out.println(atribuicao);
        
//        if(splitAtribuicao[splitAtribuicao.length-1]!=";"){
//            System.out.println("Atribuicao invalida!");
//        }

        for (int i = 0; i < splitAtribuicao.length; i++) {
            int getchar = splitAtribuicao[i].charAt(0);

            if(splitAtribuicao[i].length()==1){
              oper.add(splitAtribuicao[i]);
            }
            else{
                // variavel iniciando com letra minuscula
                if(getchar >= 97 && getchar <= 122){
                   statusatrib = ValidaVar(splitAtribuicao[i]);  
                   if(statusatrib==1){
                     atribuicaoVet.add(splitAtribuicao[i]);
                   }
                }else{
                  statusatrib = ValidaNum(splitAtribuicao[i]);  
                  if(statusatrib==1){
                     atribuicaoVet.add(splitAtribuicao[i]);
                   }
                }
            }
             
        }
        
        for(int i=1; i<atribuicaoVet.size();i++){
          if(oper.get(i).equals("+")){
            result += Double.parseDouble(atribuicaoVet.get(i));
          }
          if(oper.get(i).equals("-")){
            result -= Double.parseDouble(atribuicaoVet.get(i));
          }
          if(oper.get(i).equals("/")){
            result -= Double.parseDouble(atribuicaoVet.get(i));
          }
          if(oper.get(i).equals("*")){
            result -= Double.parseDouble(atribuicaoVet.get(i));
          }        
        }
        
        
    }

  

    public static String leArquivoAtribuicao() throws FileNotFoundException {

        String atribuicao = null;
        InputStream is = new FileInputStream("arquivo");
        Scanner entrada = new Scanner(is);
        String line = null;

        // delimitando o final das atribuicoes 
        while (entrada.hasNext()) {
            line = entrada.nextLine();
            String[] splitText = line.split(" ");

            if (splitText.length > 3) {

                atribuicao = line;

            }
        }
        return atribuicao;
    }

    public static ArrayList<Atribuicao> leArquivoValores() throws FileNotFoundException {

        ArrayList<Atribuicao> atrs = new ArrayList<Atribuicao>();
        InputStream is = new FileInputStream("arquivo");
        Scanner entrada = new Scanner(is);
        String line = null;

        // delimitando o final das atribuicoes 
        while (entrada.hasNext()) {
            line = entrada.nextLine();
            String[] splitText = line.split(" ");

            if (splitText.length == 3) {

                if ((ValidaVar(splitText[0]) == 1) && (ValidaNum(splitText[2]) == 1)) {
                    Atribuicao atrib = new Atribuicao();
                    atrib.setIdentificador(splitText[0]);
                    atrib.setValor(splitText[2]);
                    atrs.add(atrib);

                }

            }
        }
        return atrs;
    }

    public static int ValidaVar(String text) {
        String texto = text;
        int textoStatus = 0;  // Status da Validacao 
        // textoStatus = 0 - nome de variavel invalido 
        // textoStatus = 1 - nome de variavel valido

        int first = texto.charAt(0);
        // Se cair aqui, primeira posicao e valida
        if (first >= 97 && first <= 122) {
            // comeco do teste das demais posicoes
            for (int i = 1; i < texto.length(); i++) {

                int getchar = texto.charAt(i);

                if ((getchar >= 97 && getchar <= 122) || (getchar >= 65 && getchar <= 90)
                        || (getchar >= 48 && getchar <= 57) || (getchar == 95)) {
                    textoStatus = 1;
                } else {
                    textoStatus = 0;
                    break;
                }

            }

        } // fim da verificacao das posicoes
        else {
            // string e invalida
            textoStatus = 0;

        }

        return textoStatus;
    }

    public static int ValidaNum(String text) {
        String texto = text;
        int textoStatus = 0;  // Status da Validacao 
        // textoStatus = 0 - nome de variavel invalido 
        // textoStatus = 1 - nome de variavel valido

        int first = texto.charAt(0);

        if (first >= 48 && first <= 57) {
            textoStatus = 1;
            for (int j = 1; j < texto.length(); j++) {
                int getchar = texto.charAt(j);
                if (getchar == 46 && (texto.length() - j > 0)) {
                    textoStatus = 1;
                } else if ((getchar >= 48 && getchar <= 57)) {
                    textoStatus = 1;
                } else {
                    textoStatus = 0;
                }

            }
        } else {
            textoStatus = 0;
        }

        return textoStatus;
    }

}
