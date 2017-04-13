package cn.sheeva.ast;

public class WordExp extends AbstractExp {
    String word;
    
    public WordExp(String word) {
        this.word=word;
    }

    @Override
    public String toString() {
        return word;
    }
    
    
}
