package com.wallouf.minesweeper.minesweeper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MineSweeperImplTest {
    protected MineSweeperImpl mine;
    protected final String    s_mineField = "*...\n..*.\n....";

    @Before
    public void setUp() {
        mine = new MineSweeperImpl();
    }

    @After
    public void teardDown() {
        mine = new MineSweeperImpl();
    }

    @Test
    public void testMineSweeperImpl() {
        assertNotNull( mine );
    }

    @Test
    public void testSetMineField() {
        // Test with good arguments
        mine.setMineField( 3, 4, s_mineField );
        // Test with wrong arguments
        try {
            mine.setMineField( 4, 4, s_mineField );
            fail( "IllegalArgumentException not catch" );
        } catch ( IllegalArgumentException e ) {
            // OK
        }
        try {
            mine.setMineField( 4, 3, s_mineField );
            fail( "IllegalArgumentException not catch" );
        } catch ( IllegalArgumentException e ) {
            // OK
        }
        try {
            mine.setMineField( 3, 4, s_mineField + "." );
            fail( "IllegalArgumentException not catch" );
        } catch ( IllegalArgumentException e ) {
            // OK
        }
    }

    @Test
    public void testGetHintField() {
        mine.setMineField( 3, 4, s_mineField );
        assertEquals( "Test Hint field", "*211\n12*1\n0111", mine.getHintField() );
    }

    @Test
    public void testToString() {
        mine.setMineField( 3, 4, s_mineField );
        assertEquals( "Test value of toString", "*...\n..*.\n....", mine.toString() );
    }

}
