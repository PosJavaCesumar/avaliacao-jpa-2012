package entidade;

import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;

public class JpaTest {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("jpaPU");
    }

    @Test
    public void test() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        
        ProdutoSimples prodS=new ProdutoSimples();
        prodS.setDataDeEntrada("DataTeste");
        prodS.setNomeDoProduto("Sabonete");
        prodS.setValor(2.5F);
        
        ProdutoComposto prodC=new ProdutoComposto();
        prodC.setDataDeEntrada("12/12/1912");
        prodC.setNomeDoKit("Kit de barbear");
        prodC.setValor(50.5F);
        
        Pedido pedido=new Pedido();
        pedido.setDataDoPedido("11/12/1999");
        pedido.setSetor("Vendas");
        prodC.getPedidos().add(pedido);
        prodS.getPedidos().add(pedido);
        //pedido.getProdutos().add(prodC);
        //pedido.getProdutos().add(prodS);
        entityManager.persist(prodS);
        entityManager.persist(prodC);
        entityManager.persist(pedido);
        
        entityManager.getTransaction().commit();
    }
}
