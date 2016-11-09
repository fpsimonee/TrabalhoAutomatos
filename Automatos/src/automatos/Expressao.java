/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

/**
 *
 * @author felipe
 */
public class Expressao {
	protected String elementos[];
	private int topo;
	protected char[] delimitadores = {'{', '[', '(', ')', ']', '}'};
	public Expressao(int tamanho) {
		topo = -1;
		elementos = new String[tamanho];
	}
	public void empilha(char x) {
		topo++;
		elementos[topo] = String.valueOf(x);
	}
	public void desempilha() {
		topo--;
	}
	public String elementoTopo() {
		return elementos[topo].toString();
	}
	public boolean pilhaCheia() {
		return (topo == elementos.length - 1);
	}
	public boolean listaVazia() {
		return (topo == -1);
	}
	public boolean getDelimitador(char valor) {
		boolean ok = false;
		for (int i = 0; i <= delimitadores.length - 1; i++) {
			ok = delimitadores[i] == valor ? true : false;
			if (ok) {
				break;
			}
		}
		return ok;
	}
	public String retornaFormato(){
		String formato = "";
		for (int i = 0; i <= elementos.length-1; i++) {
			formato += elementos[i];             
		}
		return formato;
	}
}
