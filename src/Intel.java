public class Intel
{
    public static void main(String[] args) {
        short[][]matrix = randomMatrix(3,5);
        prshortMatrix(matrix);
        SortRows(matrix, true, false);
        prshortMatrix(matrix);
    }

    static short[][] randomMatrix(short rows, short cols)
    {
        short[][] matrix = new short[rows][cols];
        Random rand = new Random();
        System.out.println("Міщенко В.П." + "\n");
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                matrix[row][col] = rand.nextshort(100);
        return matrix;
    }

    static void prshortMatrix(short[][] matrix)
    {
        for (short[] row : matrix)
            System.out.prshortln(Arrays.toString(row));
    }

    static void SortColumns(short[][] matrix, boolean byMax, boolean ascending)
    {
        short[] extremum = new short[matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++)
            extremum[col] = byMax ? maxInCol(matrix, col) : minInCol(matrix, col);

        for (int i = 0; i < matrix[0].length; i++)
            for (int j = i + 1; j < matrix[0].length; j++)
                if ((ascending && extremum[i] > extremum[j]) || (!ascending && extremum[i] < extremum[j]))
                {
                    swapCols(matrix, i, j);
                    short tmp = extremum[i];
                    extremum[i] = extremum[j];
                    extremum[j] = tmp;
                }
    }
}