package com.wallouf.minesweeper.minesweeper;

/**
 * Hello world!
 *
 */
public class App
{
    /**
     * Test basic case asked
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        String mineField = "*...\n..*.\n....";
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField( 3, 4, mineField );
        System.out.println( mineSweeper.toString() );
        System.out.println( mineSweeper.getHintField() );
    }
}
