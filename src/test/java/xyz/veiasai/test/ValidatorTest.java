package xyz.veiasai.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import xyz.veiasai.pojo.User;
import xyz.veiasai.util.ValidatorUtil;

import java.util.Map;

public class ValidatorTest extends TestCase{
    public void testUser() {
        User t = new User();
        Map errormap = ValidatorUtil.validate(t);
        assertTrue(errormap != null);
    }
}
