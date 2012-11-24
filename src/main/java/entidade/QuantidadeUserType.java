package entidade;

import br.com.insula.opes.hibernate.usertype.ImmutableUserType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.HibernateException;

public class QuantidadeUserType extends ImmutableUserType {

    public int[] sqlTypes() {
        return new int[]{Types.INTEGER};
    }

    public Class returnedClass() {
        return Quantidade.class;
    }

    public Object nullSafeGet(ResultSet rs, String[] strings, Object o) throws HibernateException, SQLException {
        String value = rs.getString(strings[0]);
        if (rs.wasNull()) {
            return null;
        } else {
            return Quantidade.newInstance(Long.parseLong(value));
        }
    }

    public void nullSafeSet(PreparedStatement ps, Object o, int i) throws HibernateException, SQLException {
        if (o == null) {
            ps.setNull(i, Types.INTEGER);
        } else {
            Quantidade quantidade  = (Quantidade) o;
            ps.setString(i, quantidade.getTexto());
        }
    }
}