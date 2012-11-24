package entidade;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;


public class Quantidade implements Serializable{
    
    private Long quantidade;
    
    private Quantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
    public static Quantidade newInstance(Long quantidade) {
        Preconditions.checkArgument(quantidade != null);
        return new Quantidade(quantidade);
    }
    
    public String getTexto() {
        return String.format("%s", quantidade);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).
                add("quantidade", quantidade).toString();
    }
    
}