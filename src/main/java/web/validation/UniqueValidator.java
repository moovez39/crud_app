package web.validation;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(Unique unique) {

    }

    @Override
    @Transactional
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(s);
        try{
            entityManager.createQuery("from User where username= :name").setParameter("name",s).executeUpdate();
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
