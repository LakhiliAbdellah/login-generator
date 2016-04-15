package dcll.existant;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PC SALON on 15/04/2016.
 */
public class LoginServiceTest {


    @Test
    public void testLoginExists() throws Exception {
        String[] login = new String[2];
        login[0] = "abdel";
        login[1] = "tesklak";
        LoginService loginService = new LoginService(login);
        //tester si il est pas null
        assertNotNull(loginService);
        //tester si le logine existe
        assertEquals(true, loginService.loginExists("abdel"));
        assertEquals(true, loginService.loginExists("tesklak"));


    }

    @Test
    public void testAddLogin() throws Exception {

        String[] login = new String[0];

        LoginService loginService = new LoginService(login);
        loginService.addLogin("abdel");
        //tester si la liste de logine n'est pas vide
        assertEquals(1, loginService.findAllLogins().size());
        assertEquals(false, loginService.findAllLogins().size() == 0);
        //tester s'il a bien été ajouter
        assertEquals(true, loginService.loginExists("abdel"));

    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {

        String[] login = new String[3];
        login[0] = "abdel";
        login[1] = "abklak";
        login[2] = "tesklak";

        LoginService loginService = new LoginService(login);

        List<String> l = loginService.findAllLoginsStartingWith("ab");
        //tester si y'a deux elmts dans la liste
        assertEquals(2, l.size());
        //tester les deux elements si il son dans la liste
        assertEquals("abdel", l.get(0));
        assertEquals("abklak", l.get(1));
    }

    @Test
    public void testFindAllLogins() throws Exception {

        String[] login = new String[3];
        login[0] = "abdel";
        login[1] = "abklak";
        login[2] = "tesklak";

        LoginService loginService = new LoginService(login);


        //tester si la liste de logine retourner contient juste deux element
        assertEquals(3, loginService.findAllLogins().size());
        //tester les trois elements si il son dans la liste
        assertEquals("abdel", loginService.findAllLogins().get(0));
        assertEquals("abklak", loginService.findAllLogins().get(1));
        assertEquals("tesklak", loginService.findAllLogins().get(2));

    }
}
