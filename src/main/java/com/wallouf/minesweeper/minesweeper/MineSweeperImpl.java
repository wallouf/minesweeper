package com.wallouf.minesweeper.minesweeper;

import com.wallouf.minesweeper.interfaces.MineSweeper;

public class MineSweeperImpl implements MineSweeper {

    private Integer    N;
    private Integer    M;
    private String[][] mineMap;

    public String[][] getMineMap() {
        return mineMap;
    }

    public Integer getN() {
        return N;
    }

    public void setN( Integer n ) {
        N = n;
    }

    public Integer getM() {
        return M;
    }

    public void setM( Integer m ) {
        M = m;
    }

    public void setMineField( int N, int M, String mineField ) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        String[] a_mineFieldList = mineField.split( "\\n" );
        if ( a_mineFieldList.length != N ) {
            throw new IllegalArgumentException( "You must set the same number of row as defined !" );
        }
        String[][] a_mineFieldMap = new String[a_mineFieldList.length][];
        for ( int i = 0; i < a_mineFieldList.length; i++ ) {
            if ( a_mineFieldList[i].length() != M ) {
                throw new IllegalArgumentException( "You must set the same number of column as defined !" );
            }
            a_mineFieldMap[i] = a_mineFieldList[i].split( "" );
        }
        mineMap = a_mineFieldMap;
    }

    public String getHintField() throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

}
