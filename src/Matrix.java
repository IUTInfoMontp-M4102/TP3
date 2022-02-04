import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;

/******************************************************************************
 *  Représentation des matrices d'entiers
 *  Source : https://introcs.cs.princeton.edu/java/95linear/Matrix.java
 ******************************************************************************/

final public class Matrix {
    private final int m;             // nombre de lignes
    private final int n;             // nombre de colonnes
    private final int[][] data;   // tableau de n x m éléments

    /**
     * Constructeur d'une matrice m x n de zéros
     */
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        data = new int[m][n];
    }

    /**
     * Constructeur d'une matrice à partir d'un tableau de valeurs (le tableau est copié)
     */
    public Matrix(int[][] data) {
        m = data.length;
        n = data[0].length;
        this.data = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    /**
     * Constructeur par copie
     */
    public Matrix(Matrix A) {
        this(A.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return m == matrix.m && n == matrix.n && Arrays.deepEquals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m, n);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0; i < m; i++) {
            StringJoiner rowJoiner = new StringJoiner(" ");
            for (int j = 0; j < n; j++) {
                rowJoiner.add(String.format("%3d", data[i][j]));
            }
            joiner.add(rowJoiner.toString());
        }
        return joiner.toString();
    }

    /**
     * Renvoie une matrice m x n contenant des valeurs aléatoires entre -10 et 10 (inclus)
     */
    public static Matrix random(int m, int n) {
        Random rd = new Random();
        Matrix A = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                A.data[i][j] = rd.nextInt(21) - 10;
        return A;
    }

    /**
     * Renvoie la matrice identité de taille n
     */
    public static Matrix identity(int n) {
        Matrix I = new Matrix(n, n);
        for (int i = 0; i < n; i++)
            I.data[i][i] = 1;
        return I;
    }

    /**
     * Renvoie la somme matricielle (this + B)
     * Prérequis : A et B sont de mêmes dimensions
     */
    public Matrix plus(Matrix B) {
        Matrix C = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C.data[i][j] = this.data[i][j] + B.data[i][j];
        return C;
    }


    /**
     * Renvoie la différence matricielle (this - B)
     * Prérequis : A et B sont de mêmes dimensions
     */
    public Matrix minus(Matrix B) {
        Matrix C = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C.data[i][j] = this.data[i][j] - B.data[i][j];
        return C;
    }

    /**
     * Renvoie le produit matriciel (this * B)
     * Prérequis : A et B sont de dimensions compatibles
     */
    public Matrix times(Matrix B) {
        // À compléter
        return null;
    }

    public static void main(String[] args) {
        Matrix A = Matrix.random(8, 8);
        System.out.println(A);
        System.out.println();
    }
}
