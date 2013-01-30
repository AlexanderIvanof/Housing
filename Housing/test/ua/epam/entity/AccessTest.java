package ua.epam.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test access class
 *
 * @author Alexandr Ivanov
 */
public class AccessTest {

    public AccessTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class Access.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Access instance = new Access();
        instance.setUsername("name");
        String expResult = "name";
        String result = instance.getUsername();
        assertEquals(expResult, "name");
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setUsername method, of class Access.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "name";
        String expResult = "name";
        Access instance = new Access();
        instance.setUsername(username);
        String result = instance.getUsername();
        assertEquals(expResult, result);


    }

    /**
     * Test of getPassword method, of class Access.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Access instance = new Access();
        String expResult = "pass";
        instance.setPassword("pass");
        String result = instance.getPassword();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPassword method, of class Access.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");

        String expResult = "pass";
        String password = "pass";
        Access instance = new Access();
        instance.setPassword(password);
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserType method, of class Access.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        Access instance = new Access();
        UserType expResult = null;
        UserType result = instance.getUserType();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUserType method, of class Access.
     */
    @Test
    public void testSetUserType() {
        System.out.println("setUserType");
        UserType userType = null;
        Access instance = new Access();
        instance.setUserType(userType);

    }

    /**
     * Test of getIdAccess method, of class Access.
     */
    @Test
    public void testGetIdAccess() {
        System.out.println("getIdAccess");
        Access instance = new Access();
        int expResult = 0;
        int result = instance.getIdAccess();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIdAccess method, of class Access.
     */
    @Test
    public void testSetIdAccess() {
        System.out.println("setIdAccess");
        int idAccess = 0;
        Access instance = new Access();
        instance.setIdAccess(idAccess);

    }

    /**
     * Test of toString method, of class Access.
     */
    public void testToString() {
        System.out.println("toString");
        Access instance = new Access();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
}
