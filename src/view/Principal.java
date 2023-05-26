package view;

import javax.swing.JOptionPane;

import controller.ContaBancaria;
import controller.TabelaEspalhamento;

public class Principal {
    public static void main(String[] args) {
        TabelaEspalhamento tabela = new TabelaEspalhamento(100); // Tamanho da tabela de espalhamento
        
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                    "1. Inserir conta bancária\n" +
                    "2. Consultar conta bancária\n" +
                    "3. Remover conta bancária\n" +
                    "0. Sair"));
            
            switch (opcao) {
                case 1:
                    int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
                    String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta:"));
                    
                    ContaBancaria conta = new ContaBancaria(numeroConta, nomeCliente, saldo);
                    tabela.inserir(conta);
                    JOptionPane.showMessageDialog(null, "Conta bancária inserida com sucesso!");
                    break;
                
                case 2:
                    int numeroConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta para consulta:"));
                    
                    ContaBancaria contaConsulta = tabela.consultar(numeroConsulta);
                    if (contaConsulta != null) {
                        String mensagem = "Número da conta: " + contaConsulta.getNumeroConta() + "\n" +
                                "Nome do cliente: " + contaConsulta.getNomeCliente() + "\n" +
                                "Saldo: R$" + contaConsulta.getSaldo();
                        JOptionPane.showMessageDialog(null, mensagem);
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta bancária não encontrada!");
                    }
                    break;
                
                case 3:
                    int numeroRemocao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta para remoção:"));
                    
                    boolean removido = tabela.remover(numeroRemocao);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Conta bancária removida com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta bancária não encontrada!");
                    }
                    break;
                
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
