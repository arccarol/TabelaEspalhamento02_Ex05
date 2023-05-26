package controller;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TabelaEspalhamento {
    private List<List<ContaBancaria>> tabela;
    private int tamanho;
    
    // construtor da class e criação da tabela
    public TabelaEspalhamento(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            tabela.add(new LinkedList<>());
        }
    }
    
    // Função de hash para obter o índice na tabela
    private int hash(int numeroConta) {
        return numeroConta % tamanho;
    }
    
    // Inserir uma conta bancária na tabela
    public void inserir(ContaBancaria conta) {
        int indice = hash(conta.getNumeroConta());
        tabela.get(indice).add(conta); //percorre e preenche
    }
    
    // Consultar uma conta bancária pelo número da conta
    public ContaBancaria consultar(int numeroConta) {
        int indice = hash(numeroConta);
        List<ContaBancaria> listaContas = tabela.get(indice); //percorre consultando
        for (ContaBancaria conta : listaContas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null; // quando a conta não é encontrada
    }
    
    // Remover uma conta bancária pelo número da conta
    public boolean remover(int numeroConta) {
        int indice = hash(numeroConta);
        List<ContaBancaria> listaContas = tabela.get(indice);
        for (ContaBancaria conta : listaContas) {
            if (conta.getNumeroConta() == numeroConta) {
                listaContas.remove(conta);
                return true; // Remoção bem-sucedida
            }
        }
        return false; // quando a conta não é encontrada
    }
}

