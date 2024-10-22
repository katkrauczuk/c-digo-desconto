import java.util.ArrayList;
import java.util.List;

class Produto {
    String nome; 
    double valorUnitario;
    int quantidade;

    Produto(String nome, double valorUnitario, int quantidade) {
        this.nome = nome; 
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }
}

public class Venda {
    private List<Produto> produtos; 

    public Venda() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public double calcularTotal() {
        double total = 0; 
        for (Produto produto : produtos) {
            total += produto.valorUnitario * produto.quantidade;
        }
        if (total >= 500 && total <= 1000) { // Correção da condição
            total *= 0.95; // 5% de desconto
        } else if (total > 1000 && total <= 2000) { // Correção da condição
            total *= 0.90; // 10% de desconto
        } else if (total > 2000) { // Correção da condição
            total *= 0.85; // 15% de desconto
        }
        return total; 
    }

    public static void main(String[] args) {
        Venda venda = new Venda();
        venda.adicionarProduto(new Produto("Produto 1", 1000, 1)); // Teste com valor igual a 1000
        
        double total = venda.calcularTotal();
        System.out.println("Total da venda: " + total); // Deve exibir 950.0
    }
}
