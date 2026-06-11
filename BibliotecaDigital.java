import java.util.Scanner;

public class BibliotecaDigital {
    private Catalogo catalogo;
    private ListaDupla acervo;
    private GestorEmprestimos gestor;
    
    public BibliotecaDigital() {
        this.catalogo = new Catalogo();
        this.acervo = new ListaDupla();
        this.gestor = new GestorEmprestimos();
    }
    
    public void cadastrarLivro(Livro livro) {
        acervo.insereFim(livro);
        catalogo.cadastrar(livro);
        System.out.println("Livro cadastrado com sucesso");
    }
    
    public void buscarLivro(String isbn) {
        Livro livro = catalogo.buscar(isbn);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro);
        } else {
            System.out.println("Livro não encontrado");
        }
    }
    
    public void listarAcervoInicio() {
        System.out.println("\n=== ACERVO (INICIO -> FIM) ===");
        acervo.listarDoInicio();
    }
    
    public void listarAcervoFim() {
        System.out.println("\n=== ACERVO (FIM -> INICIO) ===");
        acervo.listarDoFim();
    }
    
    public void solicitarEmprestimo(Usuario usuario, String isbn) {
        gestor.solicitarEmprestimo(isbn, usuario, catalogo);
    }
    
    public void devolverLivro(String isbn) {
        gestor.devolverLivro(isbn, catalogo);
    }
    
    public void verFilaEspera(String isbn) {
        gestor.listarFilaDeEspera(isbn, catalogo);
    }
    
    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital();
        Scanner scan = new Scanner(System.in);
        
        biblioteca.cadastrarLivro(new Livro("123-12-1234-123-1", "o caminho dos reis", "brandon sanderson", 2013));
        biblioteca.cadastrarLivro(new Livro("321-32-4321-321-1", "jogos vorazes", "suzanne collins", 2010));
        
        Usuario user1 = new Usuario(1, "João Silva", "joao@email.com");
        Usuario user2 = new Usuario(2, "Maria Santos", "maria@email.com");
        
        int opcao;
        do {
            System.out.println("\n=== BIBLIOTECA DIGITAL ===");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Listar acervo do início ao fim");
            System.out.println("4. Listar acervo do fim ao início");
            System.out.println("5. Solicitar empréstimo");
            System.out.println("6. Devolver livro");
            System.out.println("7. Ver fila de espera");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Autor: ");
                    String autor = scan.nextLine();
                    System.out.print("Ano: ");
                    int ano = scan.nextInt();
                    biblioteca.cadastrarLivro(new Livro(isbn, titulo, autor, ano));
                    break;
                case 2:
                    System.out.print("ISBN: ");
                    isbn = scan.nextLine();
                    biblioteca.buscarLivro(isbn);
                    break;
                case 3:
                    biblioteca.listarAcervoInicio();
                    break;
                case 4:
                    biblioteca.listarAcervoFim();
                    break;
                case 5:
                    System.out.print("ISBN do livro: ");
                    isbn = scan.nextLine();
                    System.out.print("Matrícula: ");
                    int mat = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Email: ");
                    String email = scan.nextLine();
                    biblioteca.solicitarEmprestimo(new Usuario(mat, nome, email), isbn);
                    break;
                case 6:
                    System.out.print("ISBN do livro: ");
                    isbn = scan.nextLine();
                    biblioteca.devolverLivro(isbn);
                    break;
                case 7:
                    System.out.print("ISBN do livro: ");
                    isbn = scan.nextLine();
                    biblioteca.verFilaEspera(isbn);
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scan.close();
    }
}