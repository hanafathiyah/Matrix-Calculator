package tubes.algeo.lib.type;

public class Matriks {
  private final int nRows;
  private final int nCols;
  private final double[][] matrix;

  public Matriks(int nRows, int nCols){
    this.nRows = nRows;
    this.nCols = nCols;
    this.matrix = new double[nRows][nCols];
  }

  // Selektor
  public int getNRows() {
    return nRows;
  }

  public int getNCols() {
    return nCols;
  }

  public boolean isSquare(){
    return this.nRows == this.nCols;
  }

  // Setter Getter
  public void setElmt(int row, int col, double value){
    this.matrix[row][col] = value;
  }

  public double getElmt(int row, int col){
    return this.matrix[row][col];
  }

  public Matriks copyMatrix(){
    Matriks result = new Matriks(nRows, nCols);

    for(int i = 0; i < nRows; i++){
      for(int j = 0; j < nCols; j++){
        result.setElmt(i, j, this.matrix[i][j]);
      }
    }

    return result;
  }

  // Operasi
  public Matriks transpose(){
    // Buat Transposenya
    return new Matriks(1,2);
  }

  // Operasi OBE
  // 1 0 0
  // 2 1 0 = plusMinusOBE(2, 1, 2)
  // 0 0 1
  public Matriks plusMinusOBE(int rowTarget, int row, double factor){
    // OBE buat nambahin atau ngurangin baris
    return new Matriks(0,0);
  }

  // 1 0 0
  // 4 2 0 = scaleRow(2, 2)
  // 0 0 1
  public Matriks scaleRow(int rowTarget, double factor){
    return new Matriks(0,0);
  }

  // 0 0 1
  // 4 2 0 = blah.swapRow(1,3)
  // 1 0 0
  public Matriks swapRow(int row1, int row2){
    // TUkar dua baris
    return new Matriks(0,0);
  }

  //
  public Matriks kofaktor(){
    return new Matriks(1,2);
  }

  // Operasi matriks biasa
  public Matriks plus(Matriks m) throws Exception {
    // Penjumlahan matriks
    if(m.getNRows() == this.nRows && m.getNCols() == this.nCols){
      Matriks result = new Matriks(this.nRows, this.nCols);

      for(int i = 0; i < this.nRows; i++){
        for(int j = 0; j < this.nCols; j++){
          result.setElmt(i,j, m.getElmt(i,j) + this.getElmt(i,j));
        }
      }

      return result;
    }else{
      throw new Exception("Jumlah baris dan kolom pada matriks tidak sama");
    }
  }

  public Matriks minus(Matriks m){
    // Penjumlahan matriks
    return new Matriks(0,0);
  }

  public Matriks product(Matriks m){
      return new Matriks(0,0);
  }

  public  Matriks dotProduct(Matriks m){
    return new Matriks(0,0);
  }
}
