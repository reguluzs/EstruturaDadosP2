public class Teste2 {
    public static void main(String[] args) {
        System.out.println("-- Teste 2 --");

        Catalogo catalogo = new Catalogo();
        GestorEmprestimos gestor = new GestorEmprestimos();
        
        // Cadastrando um livro
        System.out.println("1.CADASTRANDO LIVRO NO CATÁLOGO:");
        Livro livro = new Livro("123-12-123-1234-1", "caminho dos reis", "brandon sanderson", 2013);
        catalogo.cadastrar(livro);
        System.out.println("Livro cadastrado: " + livro);
        
        // Criando usuários
        Usuario user1 = new Usuario(101, "João Silva", "joao@email.com");
        Usuario user2 = new Usuario(102, "Maria Santos", "maria@email.com");
        Usuario user3 = new Usuario(103, "Pedro Souza", "pedro@email.com");
        
        System.out.println("\n2.EMPRÉSTIMO DE LIVRO DISPONÍVEL");
        System.out.println("Usuário: " + user1);
        gestor.solicitarEmprestimo("123-12-123-1234-1", user1, catalogo);
        System.out.println("\nStatus do livro: " + catalogo.buscar("123-12-123-1234-1"));
        
        System.out.println("\n3.TENTATIVA DE EMPRESTAR O MESMO LIVRO (GERANDO FILA)");
        System.out.println("Usuário: " + user2);
        gestor.solicitarEmprestimo("123-12-123-1234-1", user2, catalogo);
        
        System.out.println("\nUsuário: " + user3);
        gestor.solicitarEmprestimo("123-12-123-1234-1", user3, catalogo);
        System.out.println("\nStatus do livro apos tentativas: " + catalogo.buscar("123-12-123-1234-1"));
        
        System.out.println("\n4.VISUALIZANDO FILA DE ESPERA:");
        gestor.listarFilaDeEspera("123-12-123-1234-1", catalogo);
        
        System.out.println("\n5,DEVOLUÇÃO DO LIVRO (ATENDIMENTO AUTOMÁTICO)");
        System.out.println("=== DEVOLVENDO LIVRO ===");
        gestor.devolverLivro("123-12-123-1234-1", catalogo);
        
        System.out.println("\nStatus do livro após devolução: " + catalogo.buscar("123-12-123-1234-1"));
        
        System.out.println("\n6.VERIFICANDO FILA DE ESPERA APÓS ATENDIMENTO:");
        gestor.listarFilaDeEspera("123-12-123-1234-1", catalogo);
        
        System.out.println("\n7.CENÁRIO 4: SEGUNDA DEVOLUÇÃO (FILA VAZIA)");
        System.out.println("=== DEVOLVENDO LIVRO ===");
        gestor.devolverLivro("123-12-123-1234-1", catalogo);

        System.out.println("\nStatus final do livro: " + catalogo.buscar("123-12-123-1234-1"));
        
        System.out.println("\n8.RESUMO FINAL:");
        System.out.println("Livro: " + catalogo.buscar("123-12-123-1234-1"));
        System.out.println("Fila de espera: ");
        gestor.listarFilaDeEspera("123-12-123-1234-1", catalogo);
        
        System.out.println("\n-- fim --");
    }
}