package controller;
public class ContaBancaria {
	
    private int numeroConta;
    private String nomeCliente;
    private double saldo;
    

    public ContaBancaria(int numeroConta, String nomeCliente, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }
    
    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }
    
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
