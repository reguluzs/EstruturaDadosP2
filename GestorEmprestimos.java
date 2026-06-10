public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> filasEspera;

    public GestorEmprestimos(){
        this.filasEspera = new NossoHash<>();
    }
    
    public void solicitarEmprestimo(String isbn, Usuario usuario, Catalogo catalogo) {
        Livro livro = catalogo.buscar(isbn);
        if (livro == null) {
            System.out.println("não achei o livro!");
            return;
        
        }
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("foi realizado o emprestimo para: " + usuario.getNome() + " livro: " + livro.getTitulo());
        } else {
            Fila<Usuario> fila = filasEspera.get(isbn);
            if (fila == null) {
                fila = new Fila<>();
                filasEspera.put(isbn,fila);
            }
            fila.enfileira(usuario);
            System.out.println(usuario.getNome() + " foi adicionado na fila de espera do livro " + livro.getTitulo());
        }
    }

    public void devolverLivro(String isbn, Catalogo catalogo) {
        Livro livro = catalogo.buscar(isbn);
        if(livro == null) {
            System.out.println("Livro não encontrado");
            return;
        }

        livro.setDisponivel(true);
        System.out.println("livro devolvido: " + livro.getTitulo());

        Fila<Usuario> fila = filasEspera.get(isbn);
        if (fila != null && !fila.filaVazia()) {
            Usuario proximo = fila.desenfileira();
            livro.setDisponivel(false);
            System.out.println("Empréstimo automático para: " + proximo.getNome());
            
            if (fila.filaVazia()) {
                filasEspera.put(isbn, null);
            }
        }
    }
    
    public void listarFilaDeEspera(String isbn, Catalogo catalogo) {
        Livro livro = catalogo.buscar(isbn);
        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
        
        Fila<Usuario> fila = filasEspera.get(isbn);
        if (fila == null || fila.filaVazia()) {
            System.out.println("Não há fila de espera para: " + livro.getTitulo());
        } else {
            System.out.println("Fila de espera para " + livro.getTitulo() + ":");
            System.out.println(fila);
        }
    
    }
}
