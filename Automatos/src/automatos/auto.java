/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import static java.lang.System.exit;

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

    public static void main(String[] args) {
        //int vl = ValidaVar("testo_");
        
        
    }
    
    public static String[] QuebraLinha(String line){
        String teste = line;
        String[] splitTeste = teste.split(" ");
//        System.out.println(splitTeste[0]);
//        System.out.println(splitTeste[1]);
//        System.out.println(splitTeste[2]);  
        return splitTeste;
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

}
