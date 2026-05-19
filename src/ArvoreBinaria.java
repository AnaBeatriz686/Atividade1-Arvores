public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
        System.out.println("Árvore Binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz == null || this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }

    public void remover(Integer elemento){
        if (estaVazia()){
            System.out.println("Não existem elementos para remover");
            return;
        }
        if (elemento == null){
            System.out.println("O elemento a ser buscado não pode ser nulo");
            return;
        }
        procurarElemento(elemento, this.raiz, null);
    }

    private void procurarElemento(Integer elemento, No atual, No pai){
        if (atual == null){
            System.out.println("Elemento " + elemento + " não encontrado!");
            return;
        }
        if (atual.getConteudo().equals(elemento)){
            System.out.println("Elemento " + elemento + " encontrado!");
            tipo(atual, pai);
        } else {
            if (elemento > atual.getConteudo()){
                procurarElemento(elemento, atual.getDireita(), atual);
            } else {
                procurarElemento(elemento, atual.getEsquerda(), atual);
            }
        }
    }

    private void tipo(No atual, No pai){
        if (atual.getEsquerda() == null && atual.getDireita() == null){
            removerFolha(atual, pai);
        }

        if (atual.getEsquerda() == null && atual.getDireita() != null){
            removerNoFilhoDireita(atual, pai);
        }

        if (atual.getEsquerda() != null && atual.getDireita() == null){
            removerNoFilhoEsquerda(atual, pai);
        }

        if (atual.getEsquerda() != null && atual.getDireita() != null){
            removerNoDoisFilhos(atual, pai);
        }
    }

    private void removerFolha(No atual, No pai){
        if (pai == null){
            this.raiz = null;
        } else if (pai.getEsquerda() == atual){
            pai.setEsquerda(null);
        } else if (pai.getDireita() == atual){
            pai.setDireita(null);
        }
    }

    private void removerNoFilhoDireita(No atual, No pai){
        if (pai == null){
            this.raiz = atual.getDireita();
        } else if (pai.getDireita() == atual){
            pai.setDireita(atual.getDireita());
        } else if (pai.getEsquerda() == atual){
            pai.setEsquerda(atual.getDireita());
        }
    }

    private void removerNoFilhoEsquerda(No atual, No pai){
        if (pai == null){
            this.raiz = atual.getEsquerda();
        } else if (pai.getEsquerda() == atual){
            pai.setEsquerda(atual.getEsquerda());
        } else if (pai.getDireita() == atual){
            pai.setDireita(atual.getEsquerda());
        }
    }

    private void removerNoDoisFilhos(No atual, No pai){
        No sucessor = encontrarSucessor(atual);
        atual.setConteudo(sucessor.getConteudo());
        procurarElemento(sucessor.getConteudo(), atual.getDireita(), atual);
    }

    private No encontrarSucessor(No atual){
        No sucessor = atual.getDireita();
        while (sucessor.getEsquerda() != null){
            sucessor = sucessor.getEsquerda();
        }
        return sucessor;
    }
}