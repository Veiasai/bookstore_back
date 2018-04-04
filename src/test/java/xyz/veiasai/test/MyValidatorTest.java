package xyz.veiasai.test;

import org.junit.BeforeClass;
import org.junit.Test;
import xyz.veiasai.hibernate.pojo.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MyValidatorTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUser() {

        User user = new User();
        user.setUsername("test");
        user.setPassword("444qqq");
        user.setEmail("77@qq.com");
        user.setValid(true);
        user.setLevel(0);
        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate( user );

        assertEquals( 0, constraintViolations.size() );
        assertEquals( "must not be null", constraintViolations.iterator().next().getMessage());
    }
}
