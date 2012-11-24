@TypeDefs({
    @TypeDef(name="quantidade", 
            typeClass=QuantidadeUserType.class, 
            defaultForType=Quantidade.class)
})
package entidade;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
