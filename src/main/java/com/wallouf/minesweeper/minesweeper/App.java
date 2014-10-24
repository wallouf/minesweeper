package com.wallouf.minesweeper.minesweeper;

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
        try {
            MineSweeperImpl mineSweeper = new MineSweeperImpl();
            mineSweeper.setMineField( 3, 4, mineField );
            System.out.println( mineSweeper.toString() );
            System.out.println( mineSweeper.getHintField() );
        } catch ( IllegalArgumentException e ) {
            e.printStackTrace();
        } catch ( IllegalStateException e ) {
            e.printStackTrace();
        }
    }
}
