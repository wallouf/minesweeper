package com.wallouf.minesweeper.test;

import junit.framework.TestCase;

import com.wallouf.minesweeper.minesweeper.MineSweeperImpl;

public class MineSweeperImplTest extends TestCase {

    public void testSetMineField() {
        // Test basic map
        String mineField = "*...\n..*.\n....";
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField( 3, 4, mineField );
        String[][] a_mineMap = { { "*", ".", ".", "." }, { ".", ".", "*", "." }, { ".", ".", ".", "." } };
        assertEquals( "Error with map", a_mineMap, mineSweeper.getMineMap() );
    }

    public void testGetHintField() {
        // Test basic hint
        String mineField = "*...\n..*.\n....";
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField( 3, 4, mineField );
        String[][] a_mineMap = { { "*", ".", ".", "." }, { ".", ".", "*", "." }, { ".", ".", ".", "." } };
        assertEquals( "Error with hint field", "*211\n12*1\n0111", mineSweeper.getHintField() );
    }

}
