package com.ead.authuser.validations;

import com.ead.authuser.validations.impl.PasswordConstraintImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordConstraintImpl.class) // classe que vai implementar as regras que definimos
@Target({ElementType.METHOD, ElementType.FIELD}) // Anotação a nivel de metodo e atributo
@Retention(RetentionPolicy.RUNTIME) // Quando que a anotação ira ocorrer
public @interface PasswordConstraint {
    // Parametros padrão do bean validation
    String message() default """ 
            Invalid password! Password must contain at least one digit [0-9],
            at leasty one lowercase Latin character [a-z], at least one uppercase
            Latin character [A-Z], at least one special character like !@#&()-:;',?/*~$^+=<>,
            A length od at least 6 characters and a maximun of 20 characters """;

    Class<?>[] groups() default {}; // Um array de classes
    Class<? extends Payload>[] payload() default {}; // Um array de classes que extendem a classe Payload
}
