public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.remover(10);
        arvoreBinaria.exibir("Em");
        System.out.println("---------------------");
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(4);
        System.out.println("---------------------");
        arvoreBinaria.exibir("Em");
        System.out.println("---------------------");
        arvoreBinaria.exibir("Pos");
        System.out.println("---------------------");
        arvoreBinaria.remover(9);
        arvoreBinaria.exibir("Em");
        System.out.println("---------------------");
        arvoreBinaria.remover(5);
        arvoreBinaria.exibir("Em");
        System.out.println("---------------------");
        arvoreBinaria.remover(4);
        arvoreBinaria.exibir("Em");
        System.out.println("---------------------");
    }
}