public class Teste1 {
    public static void main(String[] args) {
        System.out.println("-- Teste 1 --");
        
        ListaDupla lista = ListaDupla();

        Livro livro1 = new Livro("123-12-1234-123-1", "algum livro aí", "eu mesmo", 2026);
        Livro livro2 = new Livro("321-21-4321-321-1", "o caminho dos reis", "brandon sanderson", 2003);
        Livro livro3 = new Livro("321-21-4321-321-2", "o ceifador", "neil shusterman", 2014);
    
        //inserção no inicio
        System.out.println("inserindo no inicio" + livro1.getTitulo());
        System.out.println("inserindo no inicio" + livro2.getTitulo());
        System.out.println("inserindo no inicio" + livro3.getTitulo());

        //listar do inicio para o fim
        lista.listarDoInicio();

        //listar do fim para o inicio
        lista.listarDoFim();

        //tamanho da lista
        System.out.println("tamanho atual:" + lista.tamanho());


        //buscando livro existente
        String isbnBusca = "123-12-1234-123-1";
        System.out.println("Buscando ISBN: " + isbnBusca);
        Livro encontrado = lista.buscarPorIsbn(isbnBusca);
        if (encontrado != null) {
            System.out.println("Livro encontrado: " + encontrado);
        } else {
            System.out.println("Livro não encontrado!");
        }


        //buscando livro inexistente
        isbnBusca = "000-00-0000-000-0";
        System.out.println("\nBuscando ISBN: " + isbnBusca);
        encontrado = lista.buscarPorIsbn(isbnBusca);
        if (encontrado != null) {
            System.out.println("Livro encontrado: " + encontrado);
        } else {
            System.out.println("Livro não encontrado!");
        }

        //removendo do inicio
        Livro removido = lista.removePrimeiro();
        System.out.println("Livro removido: " + removido.getTitulo());
        
        System.out.println("\nLista após remoção do início:");
        lista.listarDoInicio();

        //removando o fim 
        System.out.println("\nRemovendo do fim:");
        removido = lista.removeUltimo();
        System.out.println("Livro removido: " + removido.getTitulo());
        
        System.out.println("\nLista após remoção do fim:");
        lista.listarDoInicio();
        System.out.println("\nTamanho após remoções: " + lista.tamanho() + " livros");

        //navegação bidirecional
        System.out.println("\nLista completa (início -> fim):");
        lista.listarDoInicio();
        
        System.out.println("\nLista completa (fim -> início):");
        lista.listarDoFim();

        //remoção até ficar vazia
        while (lista.tamanho() > 0) {
            System.out.println("Removendo: " + lista.removePrimeiro().getTitulo());
            System.out.println("  Livros restantes: " + lista.tamanho());
        }
        
        System.out.println("\nTentando remover de lista vazia:");
        Livro removidoVazio = lista.removePrimeiro();
        if (removidoVazio == null) {
            System.out.println("lista vazia");
        }
        
        //TESTANDO MÉTODO EQUALS E TOSTRING DA CLASSE LIVRO

        Livro livroClone = new Livro("123-12-1234-123-1", "algum livro aí", "eu mesmo", 2026);
        System.out.println("Livro1: " + livro1);
        System.out.println("LivroClone: " + livroClone);
        System.out.println("Livro1 equals LivroClone? " + livro1.equals(livroClone));
        
        Livro livroDiferente = new Livro("999-99-9999-999-9", "Outro Livro", "Outro Autor", 2020);
        System.out.println("\nLivro1 equals LivroDiferente? " + livro1.equals(livroDiferente));

    }
}
