public class NoDuplo {
    private Livro livro;
    private NoDuplo anterior;
    private NoDuplo seguinte;

    public NoDuplo(Livro livro) {
        this.livro = livro;
        this.anterior = null;
        this.seguinte = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public NoDuplo getSeguinte() {
        return seguinte;
    }

    public void setSeguinte(NoDuplo seguinte) {
        this.seguinte = seguinte;
    }

    
}
