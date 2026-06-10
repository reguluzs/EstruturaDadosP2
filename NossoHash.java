// NossoHash.java
public class NossoHash<K, V> {
    private static final int CAPACIDADE_INICIAL = 16;
    private Entrada<K, V>[] tabela;
    private int tamanho;
    
    @SuppressWarnings("unchecked")
    public NossoHash() {
        tabela = new Entrada[CAPACIDADE_INICIAL];
        tamanho = 0;
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % tabela.length;
    }
    
    public void put(K key, V value) {
        int posicao = hash(key);
        Entrada<K, V> nova = new Entrada<>(key, value);
        
        if (tabela[posicao] == null) {
            tabela[posicao] = nova;
        } else {
            nova.proximo = tabela[posicao];
            tabela[posicao] = nova;
        }
        tamanho++;
    }
    
    public V get(K key) {
        int posicao = hash(key);
        Entrada<K, V> atual = tabela[posicao];
        
        while (atual != null) {
            if (atual.key.equals(key)) {
                return atual.value;
            }
            atual = atual.proximo;
        }
        return null;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public boolean containsValue(V value) {
        for (Entrada<K, V> entrada : tabela) {
            Entrada<K, V> atual = entrada;
            while (atual != null) {
                if (atual.value.equals(value)) {
                    return true;
                }
                atual = atual.proximo;
            }
        }
        return false;
    }
    
    public void exibemap() {
        for (int i = 0; i < tabela.length; i++) {
            System.out.print("Posição " + i + ": ");
            Entrada<K, V> atual = tabela[i];
            if (atual == null) {
                System.out.println("vazio");
            } else {
                while (atual != null) {
                    System.out.print("[" + atual.key + "->" + atual.value + "] ");
                    atual = atual.proximo;
                }
                System.out.println();
            }
        }
    }
}