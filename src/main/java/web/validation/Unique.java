package web.validation;


import web.model.User;

import java.lang.annotation.Target;

import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface Unique {
    public boolean value() default true ;
    public String message() default "";

    public Class<?>[] groups() default {};
    public Class <? extends Payload>[] payload() default{};
}
