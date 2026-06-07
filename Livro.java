public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPublicado;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, int anoPublicado){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
        this.disponivel = true;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public int getAnoPublicado() {
        return anoPublicado;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel (boolean disponivel){
        this.disponivel = disponivel;
    }
    public void SetTitulo (String titulo) {
        this.titulo = titulo;
    }
    public void setAutor (String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        String status = disponivel ? "DISPONIVEL" : "EMPRESTADO";
        return String.format("[%s] %s - %s (%d) [%s]", isbn, titulo, autor, anoPublicado, status);
    } 
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return isbn.equals(livro.isbn);
    }

}