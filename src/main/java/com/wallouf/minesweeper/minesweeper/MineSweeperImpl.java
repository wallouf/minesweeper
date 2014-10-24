package com.wallouf.minesweeper.minesweeper;

import com.wallouf.minesweeper.interfaces.MineSweeper;

public class MineSweeperImpl implements MineSweeper {

    private Integer    N;
    private Integer    M;
    private String[][] a_mineMap;

    public String[][] getMineMap() {
        return a_mineMap;
    }

    public Integer getN() {
        return N;
    }

    public Integer getM() {
        return M;
    }

    /**
     * Initialises the mine-field
     *
     *
     * @param N
     *            number of rows in the field
     * @param M
     *            number of columns in the field
     * @param mineField
     *            string containing the mines (see interface javadoc for
     *            representation)
     * @throws IllegalArgumentException
     *             if any of the arguments is invalid or have invalid format
     */
    public void setMineField( int N, int M, String mineField ) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        String[] a_mineFieldList = mineField.trim().split( "\\n" );
        if ( a_mineFieldList.length != N ) {
            throw new IllegalArgumentException( "You must set the same number of row as defined !" );
        }
        String[][] a_mineFieldMap = new String[a_mineFieldList.length][];
        for ( int i = 0; i < a_mineFieldList.length; i++ ) {
            if ( a_mineFieldList[i].trim().length() != M ) {
                throw new IllegalArgumentException( "You must set the same number of column as defined !" );
            }
            a_mineFieldMap[i] = a_mineFieldList[i].trim().split( "" );
        }
        this.N = N;
        this.M = M;
        a_mineMap = a_mineFieldMap;
    }

    /**
     * Produces a hint-field for the current mine-filed (see interface javadoc
     * for details)
     *
     * @return a string representation of the hint-field
     * @throws IllegalStateException
     *             if the mine-field has not been initialised (i.e.
     *             setMineField() has not been called)
     */
    public String getHintField() throws IllegalStateException {
        // TODO Auto-generated method stub
        if ( a_mineMap != null && a_mineMap.length > 0 ) {
            String result = "";
            for ( int i = 0; i < a_mineMap.length; i++ ) {
                for ( int j = 1; j < a_mineMap[i].length; j++ ) {
                    if ( a_mineMap[i][j].equalsIgnoreCase( "*" ) ) {
                        result += a_mineMap[i][j];
                    } else {
                        // count mines
                        int i_minesCount = 0;
                        // Check mines around
                        if ( ( j - 1 ) >= 0 && a_mineMap[i][( j - 1 )].equalsIgnoreCase( "*" ) ) {
                            i_minesCount++;
                        }
                        if ( ( j + 1 ) < a_mineMap[i].length && a_mineMap[i][( j + 1 )].equalsIgnoreCase( "*" ) ) {
                            i_minesCount++;
                        }
                        // Check mines on top
                        if ( ( i - 1 ) >= 0 ) {
                            if ( a_mineMap[( i - 1 )][( j )].equalsIgnoreCase( "*" ) ) {
                                i_minesCount++;
                            }
                            if ( ( j - 1 ) >= 0 && a_mineMap[( i - 1 )][( j - 1 )].equalsIgnoreCase( "*" ) ) {
                                i_minesCount++;
                            }
                            if ( ( j + 1 ) < a_mineMap[i].length
                                    && a_mineMap[( i - 1 )][( j + 1 )].equalsIgnoreCase( "*" ) ) {
                                i_minesCount++;
                            }
                        }
                        // Check mines on bottom
                        if ( ( i + 1 ) < N ) {
                            if ( a_mineMap[( i + 1 )][( j )].equalsIgnoreCase( "*" ) ) {
                                i_minesCount++;
                            }
                            if ( ( j - 1 ) >= 0 && a_mineMap[( i + 1 )][( j - 1 )].equalsIgnoreCase( "*" ) ) {
                                i_minesCount++;
                            }
                            if ( ( j + 1 ) < a_mineMap[i].length
                                    && a_mineMap[( i + 1 )][( j + 1 )].equalsIgnoreCase( "*" ) ) {
                                i_minesCount++;
                            }
                        }
                        result += i_minesCount;
                    }
                }
                if ( ( i + 1 ) < N ) {
                    result += "\n";
                }
            }
            return result;
        } else {
            throw new IllegalStateException( "You must defined a map before!" );
        }
    }

    /**
     * Display mine map
     */
    public String toString() throws IllegalStateException {
        if ( a_mineMap != null && a_mineMap.length > 0 ) {
            String result = "";
            for ( int i = 0; i < a_mineMap.length; i++ ) {
                for ( int j = 1; j < a_mineMap[i].length; j++ ) {
                    result += a_mineMap[i][j];
                }
                if ( ( i + 1 ) < N ) {
                    result += "\n";
                }
            }
            return result;
        } else {
            throw new IllegalStateException( "You must defined a map before!" );
        }
    }
}
