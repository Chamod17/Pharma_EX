/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma_ex;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CHAMOD
 */
public class pharmacyTest {
    
    public pharmacyTest() {
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
     * Test of getId method, of class pharmacy.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        pharmacydsd instance = new pharmacydsd();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class pharmacy.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        pharmacydsd instance = new pharmacydsd();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class pharmacy.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        pharmacydsd instance = new pharmacydsd();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class pharmacy.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        pharmacydsd instance = new pharmacydsd();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContact method, of class pharmacy.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        pharmacydsd instance = new pharmacydsd();
        String expResult = "";
        String result = instance.getContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContact method, of class pharmacy.
     */
    @Test
    public void testSetContact() {
        System.out.println("setContact");
        String contact = "";
        pharmacydsd instance = new pharmacydsd();
        instance.setContact(contact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class pharmacy.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        pharmacydsd instance = new pharmacydsd();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class pharmacy.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        pharmacydsd instance = new pharmacydsd();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistrict method, of class pharmacy.
     */
    @Test
    public void testGetDistrict() {
        System.out.println("getDistrict");
        pharmacydsd instance = new pharmacydsd();
        String expResult = "";
        String result = instance.getDistrict();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDistrict method, of class pharmacy.
     */
    @Test
    public void testSetDistrict() {
        System.out.println("setDistrict");
        String district = "";
        pharmacydsd instance = new pharmacydsd();
        instance.setDistrict(district);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
