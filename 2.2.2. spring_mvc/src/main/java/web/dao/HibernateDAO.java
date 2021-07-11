package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class HibernateDAO implements DAO {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void cleanUsersTable() {

    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updateUser) {

    }

    @Override
    public void removeUserById(int id) {
//        User user = entityManager.createQuery("SELECT user FROM User user WHERE user.id=:id", User.class)
//                .setParameter("id", id).getSingleResult();
//        if (user != null){
//            entityManager.remove(user);
//            System.out.println("Вроде как удалили User с id: "+user.getId());
//        }else {
//            System.out.println("User c id: "+id+" не найден");
//        }
        entityManager.createQuery("DELETE FROM User user WHERE user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }
}
