public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int tamanho;

    public ListaDupla(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void insereInicio(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (tamanho == 0) {
            primeiro = ultimo = novo;
        } else {
            novo.setSeguinte(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
        tamanho++;
    }
    
    public void insereFim(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (tamanho == 0) {
            primeiro = ultimo = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setSeguinte(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    public Livro removePrimeiro() {
        if (tamanho == 0) return null;
        Livro livro = primeiro.getLivro();
        if (tamanho == 1) {
            primeiro = ultimo = null;
        } else {
            primeiro = primeiro.getSeguinte();
            primeiro.setAnterior(null);
        }
        tamanho --;
        return livro;
    }

    public Livro removeUltiumo() {
        if (tamanho == 0) {
            return null;
        }
        Livro livro = ultimo.getLivro();
        if (tamanho == 1) {
            primeiro = ultimo = null; 
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSeguinte(null);
        }
        tamanho --;
        return livro;
    }

    public Livro buscarPorIsbn(String isbn) {
        NoDuplo atual = primeiro;
        while (atual != null) {
            if (atual.getLivro().getIsbn().equals(isbn)) {
                return atual.getLivro();
            }
            atual = atual.getSeguinte();
        }
        return null;
    }

    public void listarDoInicio(){
        NoDuplo atual = primeiro;
        while (atual != null){
            System.out.println(atual.getLivro());
            atual = atual.getSeguinte();
        }
    }

    public void listarDoFim(){
        NoDuplo atual = ultimo;
        while (atual != null) {
            System.out.println(atual.getLivro());
            atual = atual.getAnterior();
        }
    }
    public int tamanho() {
        return tamanho;
    }
}
