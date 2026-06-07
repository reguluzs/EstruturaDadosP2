public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean filaVazia(){
        return tamanho == 0;
    }

    public int tamanho(){
        return tamanho;
    }

    public void enfileira (T info){
        No<T> novo = new No<>(info);
        if (filaVazia()) {
            primeiro = ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    public T desenfileira() {
        if (filaVazia()) {
            throw new FilaVaziaException("fila vazia chefe");
        }
        T info = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        tamanho--;

        if(filaVazia()) {
            ultimo = null;
        }
        return info;
    }
    public T primeiro() {
        if (filaVazia()) {
            throw new FilaVaziaException("fila vazia chefia");
        }
        return primeiro.getInfo();
    }

    @Override
    public String toString(){
        if (filaVazia()) return "fila vazia";
        StringBuilder sb = new StringBuilder();
        No<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.toString());
            if (atual.getProximo() != null) {
                sb.append(" -> ");
            }
            atual = atual.getProximo();
        }
        sb.append(" -> \\");
        return sb.toString();
    }
}
