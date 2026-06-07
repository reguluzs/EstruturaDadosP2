public class Teste1 {
    public static void main(String[] args) {
        System.out.println("-- Teste 1 --");
        
        ListaDupla lista = ListaDupla();

        Livro livro1 = new Livro("123-12-1234-123-1", "algum livro aí", "eu mesmo", 2026);
        Livro livro2 = new Livro("321-21-4321-321-1", "o caminho dos reis", "brandon sanderson", 2003);
    
    
        //inserção no inicio
        System.out.println("inserindo no inicio" + livro1.getTitulo());
        System.out.println("inserindo no inicio" + livro2.getTitulo());

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
    }
}
