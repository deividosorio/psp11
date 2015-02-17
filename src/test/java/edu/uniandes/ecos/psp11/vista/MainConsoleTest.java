/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.vista;

import junit.framework.TestCase;

/**
 *
 * @author deividosorio
 */
public class MainConsoleTest extends TestCase {
    
    public MainConsoleTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of main method, of class MainConsole.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MainConsole.main(args);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }
    
}
