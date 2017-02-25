package employee;

import employee.EmployeeEntity;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Yang on 2017/2/25.
 */
public class EmployeeInterceptor extends EmptyInterceptor {
    private int updates;
    private int loads;
    private int creates;

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        super.onDelete(entity, id, state, propertyNames, types);

    }


    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState,
                                Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof EmployeeEntity) {
            System.out.println("update operation");
            return true;
        }
        return false;
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("onLoad...");
        return true;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof EmployeeEntity) {
            System.out.println("onSave...");
            return true;
        }

        return false;
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("pre flush...");
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("post flush");
    }
}
