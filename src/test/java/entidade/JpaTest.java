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
        emf = Persistence.createEntityManagerFactory("jpaAvaliacao");
    }

    @Test
    public void pessoa() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        ProdutoSimples produtoSimples = new ProdutoSimples();
        produtoSimples.setCodigo("PS01");
        produtoSimples.setNome("Produto Simples 01");
        produtoSimples.setPreco(10.00);
        produtoSimples.setDescricao("Esse é um produto simples!");
        entityManager.persist(produtoSimples);

        ProdutoSimples produtoSimples2 = new ProdutoSimples();
        produtoSimples2.setCodigo("PS02");
        produtoSimples2.setNome("Produto Simples 02");
        produtoSimples2.setPreco(15.00);
        produtoSimples2.setDescricao("Esse é um produto simples02!");
        entityManager.persist(produtoSimples2);

        ProdutoComposto produtoComposto = new ProdutoComposto();
        produtoComposto.setCodigo("PRO01");
        produtoComposto.setNome("Produto 01");
        produtoComposto.setPreco(12.45);
        produtoComposto.setObservacao("Esse é uma produto composto!");
        produtoComposto.addProdutos(produtoSimples);
        produtoComposto.addProdutos(produtoSimples2);
        entityManager.persist(produtoComposto);

        ProdutoSimples produtoSimples3 = new ProdutoSimples();
        produtoSimples3.setCodigo("PS03");
        produtoSimples3.setNome("Produto Simples 03");
        produtoSimples3.setPreco(34.66);
        produtoSimples3.setDescricao("Esse é um produto simples03!");
        entityManager.persist(produtoSimples3);

        Pedido pedido = new Pedido();
        pedido.getProdutos().add(produtoComposto);
        pedido.getProdutos().add(produtoSimples3);
        entityManager.persist(pedido);
        pedido.showPedido();

        JPAQuery query = new JPAQuery(entityManager);
        QPedido qPedido = QPedido.pedido;
        List<Pedido> result = query.from(qPedido).where(
                   qPedido.id.isNotNull()).list(qPedido);
        
        
        System.out.println("*****\nResultado da Query\n*****");
        for (Pedido pedido1 : result) {
                System.out.println(pedido1.toString());
        }
                
        entityManager.getTransaction().commit();
    }
}