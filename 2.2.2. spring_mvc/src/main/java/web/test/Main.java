package web.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.HibernateConfig;
import web.dao.UserDAOImpl;
import web.model.User;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserDAOImpl hibernateDAO = context.getBean(UserDAOImpl.class);
        hibernateDAO.saveUser(new User("Vlad",23,"vlad.mekhedov@yandex.ru"));
        context.close();
    }
}
