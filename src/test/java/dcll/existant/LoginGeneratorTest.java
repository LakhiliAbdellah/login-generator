package dcll.existant;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PC SALON on 15/04/2016.
 */
public class LoginGeneratorTest {

    LoginService loginService;
    LoginGenerator loginGenerator;
    @Before
    public void setUp() throws Exception {

        loginService = new LoginService(new String[]
                {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});

        loginGenerator=new LoginGenerator(loginService);

    }

    @Test
    public void testGenerateLoginForNomAndPrenom1() throws Exception {
        //quand on génère le login de "Paul Durand", on vérifie que
        // le login généré et ajouté à la liste des logins existants est "PDUR"
        loginService.addLogin(loginGenerator.generateLoginForNomAndPrenom("Durand","Paul"));
        assertEquals(true,loginService.loginExists("PDUR"));

    }
    @Test
    public void testGenerateLoginForNomAndPrenom2() throws Exception {

        //quand on génère le login de "Jean Rolling", on vérifie que le login
        // généré et ajouté à la liste des logins existants est "JROL1" ;
        loginService.addLogin(loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean"));
        assertEquals(true,loginService.loginExists("JROL1"));

    }
    @Test
    public void testGenerateLoginForNomAndPrenom3() throws Exception {

        //quand on génère le login de "Paul Dùrand", on vérifie que le login
        // généré et ajouté à la liste des logins existants est "PDUR".
        loginService.addLogin(loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul"));
        assertEquals(true,loginService.loginExists("PDUR"));
    }
}
