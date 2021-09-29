package tubes.algeo.lib.type;

public class Matriks {
  private int nRows;
  private int nCols;
  private double[][] matrix;
  private final double epsilon = 1e-9;

  public Matriks() {
    nRows = 0;
    nCols = 0;
    matrix = new double[1][1];
  }

  public Matriks(int nRows, int nCols) {
    this.nRows = nRows;
    this.nCols = nCols;
    this.matrix = new double[nRows][nCols];
    //Melakukan inisialisasi awal dengan mengisi semua elemen dengan 0
    for (int row = 0; row < nRows; row++) {
      for (int col = 0; col < nCols; col++) matrix[row][col] = 0;
    }
  }

  //Membuat matriks identitas yaitu semua elemen pada diagonal bernilai 1 dengan ukuran n
  public Matriks(int nSize) {
    this.nRows = nSize;
    this.nCols = nSize;
    this.matrix = new double[nSize][nSize];
    for (int i = 0; i < nSize; i++) {
      for (int j = 0; j < nSize; j++) {
        if (i == j) {
          this.matrix[i][j] = 1;
        } else {
          this.matrix[i][j] = 0;
        }
      }
    }
  }

  public Matriks(Matriks matriks) {
    this.copyMatrix(matriks);
  }

  // Selektor
  public int getNRows() {
    return nRows;
  }

  public int getNCols() {
    return nCols;
  }

  public double[][] getMatrix() {
    return matrix;
  }

  // Predikat
  public boolean isSquare() {
    return this.nRows == this.nCols;
  }


  // Setter Getter
  public void setElmt(int row, int col, double value) {
    this.matrix[row][col] = value;
  }

  public double getElmt(int row, int col) {
    return this.matrix[row][col];
  }


  public void copyMatrix(Matriks matriks) {
    this.nRows = matriks.getNRows();
    this.nCols = matriks.getNCols();
    double[][] matrix = matriks.getMatrix();
    this.matrix = new double[this.nRows][this.nCols];
    for (int row = 0; row < this.nRows; row++) {
      for (int col = 0; col < this.nCols; col++) {
        this.matrix[row][col] = matrix[row][col];
      }
    }
  }

  // Operasi

  public void transpose() {
    // Buat Transposenya
    double[][] matriks = new double[this.nCols][this.nRows];
    for (int i = 0; i < this.nRows; i++) {
      for (int j = 0; j < this.nCols; j++) {
        matriks[j][i] = this.matrix[i][j];
      }
    }
    int temp = this.nRows;
    this.nRows = this.nCols;
    this.nCols = temp;
    this.matrix = new double[this.nRows][this.nCols];
    for (int i = 0; i < this.nRows; i++) {
      for (int j = 0; j < this.nCols; j++) {
        this.matrix[i][j] = matriks[i][j];
      }
    }
  }

  // Operasi OBE
  // 1 0 0
  // 2 1 0 = plusMinusOBE(2, 1, 2)
  // 0 0 1
  public Matriks plusMinusOBE(int rowTarget, int row, double factor) {
    Matriks M = new Matriks(this.nRows, this.nCols - 1);
    for (int i = 0; i < this.nCols; i++) {
      this.matrix[row][i] += (this.matrix[rowTarget][i] * factor);
    }
    return M;
  }
  // 1 0 0
  // 4 2 0 = scaleRow(2, 2)
  // 0 0 1

  public Matriks scaleRow(int rowTarget, double factor) {
    Matriks M = new Matriks(this.nRows, this.nCols - 1);
    for (int i = 0; i < this.nCols; i++) {
      this.matrix[rowTarget][i] *= factor;
    }
    return M;
  }

  // 0 0 1
  // 4 2 0 = blah.swapRow(1,3)
  // 1 0 0

  public void swapRow(int row1, int row2) {
    // Tukar posisi 2 baris
    double temp;
    for (int i = 0; i < this.nCols; i++) {
      temp = this.matrix[row1][i];
      this.matrix[row1][i] = this.matrix[row2][i];
      this.matrix[row2][i] = temp;
    }
  }

  public Matriks cutOneRow(int row) {
    Matriks hasil;
    hasil = new Matriks(this.nRows - 1, this.nCols);
    for (int j = 0; j < this.nCols; j++) {
      for (int i = 0; i < row; i++) {
        hasil.matrix[i][j] = this.matrix[i][j];
      }
      for (int i = row + 1; i < this.nRows; i++) {
        hasil.matrix[i - 1][j] = this.matrix[i][j];
      }
    }
    return hasil;
  }

  public Matriks cutOneCol(int col) {
    Matriks hasil = new Matriks(this.nRows, this.nCols - 1);
    for (int i = 0; i < this.nRows; i++) {
      for (int j = 0; j < col; j++) {
        hasil.matrix[i][j] = this.matrix[i][j];
      }
      for (int j = col + 1; j < this.nCols; j++) {
        hasil.matrix[i][j - 1] = this.matrix[i][j];
      }
    }
    return hasil;
  }

  public void gantiOneColom(Matriks rep, int col) {
    //Assumption the matrix rep has only 1 column
    for (int i = 0; i < this.nRows; i++) {
      this.matrix[i][col] = rep.matrix[i][0];
    }
  }

  public Matriks akhirDariAugmented() {
    Matriks jawab = new Matriks(this.nRows, 1);
    for (int row = 0; row < this.nRows; row++) {
      jawab.matrix[row][0] = this.matrix[row][this.nCols - 1];
    }
    return jawab;
  }

  public void addRowToRow(int addingRow, int addedRow, double multiplier) {
    int j;
    for (j = 0; j < this.nCols; j++) {
      this.matrix[addedRow][j] += (multiplier * this.matrix[addingRow][j]);
    }
  }

  public int toSegitigaAtas() {
    //Mengubah matrix menjadi seperti bentuk eselon tereduksi namun bilangan taknol terdepan tiap baris tidak harus 1
    //Menjadi matriks segitiga atas
    int nRow = 0;
    int nCol = 0;
    int swaps = 0;
    int i;
    while (nRow < this.nRows && nCol < this.nCols) {
      i = nRow;
      if (-epsilon < this.matrix[nRow][nCol] && this.matrix[nRow][nCol] < epsilon) {
        while (i < this.nRows && -epsilon < this.matrix[i][nCol] && this.matrix[i][nCol] < epsilon) {
          this.matrix[i][nCol] = 0;
          i++;
        }
      }
      if (i == this.nRows) {
        //Semua bilangan pada baris lebih besar dari n pada kolom m bernilai 0
        nCol++;
      } else {
        //Tukar baris dengan nilai bukan nol tersebut dengan baris ke-n ini
        if (i != nRow) {
          swaps++;
          this.swapRow(i, nRow);
        }
        //Maka sekarang kondisinya nilai this.matrix[n][m] taknol, sehingga dapat dioperasikan OBE
        for (i = nRow + 1; i < this.nRows; i++) {
          double multiplier = -this.matrix[i][nCol] / this.matrix[nRow][nCol];
          this.addRowToRow(nRow, i, multiplier);
        }
        nRow++;
      }
    }
    return swaps;
  }

  public double minorMatriks(int x, int y) {
    Matriks temp = new Matriks();
    temp.copyMatrix(this);
    temp = temp.cutOneRow(x);
    temp = temp.cutOneCol(y);
    return temp.determinanByReduksi();
  }

  public Matriks kofaktor() {
    Matriks cofactor = new Matriks(this.nRows, this.nCols);
    int tanda;
    for (int i = 0; i < this.nRows; i++) {
      for (int j = 0; j < this.nCols; j++) {
        tanda = 1 - 2 * ((i + j) & 1);
        cofactor.matrix[i][j] = tanda * this.minorMatriks(i, j);
      }
    }
    return cofactor;
  }

  // Operasi matriks biasa
  public Matriks plus(Matriks m) throws Exception {
    // Penjumlahan matriks
    if (m.getNRows() == this.nRows && m.getNCols() == this.nCols) {
      Matriks result = new Matriks(this.nRows, this.nCols);

      for (int i = 0; i < this.nRows; i++) {
        for (int j = 0; j < this.nCols; j++) {
          result.setElmt(i, j, m.getElmt(i, j) + this.getElmt(i, j));
        }
      }
      return result;
    } else {
      throw new Exception("Jumlah baris dan kolom pada matriks tidak sama");
    }
  }

  public Matriks minus(Matriks m) throws Exception {
    // Pengurangan matriks
    if (m.getNRows() == this.nRows && m.getNCols() == this.nCols) {
      Matriks result = new Matriks(this.nRows, this.nCols);

      for (int i = 0; i < this.nRows; i++) {
        for (int j = 0; j < this.nCols; j++) {
          result.setElmt(i, j, this.getElmt(i, j) - m.getElmt(i, j));
        }
      }
      return result;
    } else {
      throw new Exception("Jumlah baris dan kolom pada matriks tidak sama");
    }
  }

  public void product(Matriks m) {
    //matriks kali biasa
    int nRows = this.nCols;
    int nCols = this.nRows;
    double[][] tmpMatrix = new double[nRows][nCols];
    for (int row = 0; row < nRows; row++) {
      for (int col = 0; col < nCols; col++) {
        tmpMatrix[row][col] = this.matrix[col][row];
      }
    }
    this.matrix = new double[nRows][nCols];
    this.nRows = nRows;
    this.nCols = nCols;
    //copy tmpMatrix to class's matrix
    for (int row = 0; row < nRows; row++) {
      for (int col = 0; col < nCols; col++) {
        this.matrix[row][col] = tmpMatrix[row][col];
      }
    }
  }

  public Matriks produk(Matriks m) throws Exception {

    int nRows = this.nRows;
    int nCols = this.nCols;
    if (m.getNRows() == this.nRows && m.getNCols() == this.nCols) {
      Matriks result = new Matriks(nRows, m.nCols);

      for (int row = 0; row < nRows; row++) {
        for (int col = 0; col < nCols; col++) {
          result.matrix[row][col] = this.matrix[col][row];
        }
      }

      for (int row = 0; row < nRows; row++) {
        for (int col = 0; col < nCols; col++) {
          this.matrix[row][col] = result.matrix[row][col];
        }

      }
      return result;
    } else {
      throw new Exception("Jumlah baris dan kolom pada matriks tidak sama");
    }
  }

  public Matriks dotProduct(Matriks m) {
    //perkalian dot matrix dengan sisi kanannya
    //assume origin matrix has right dimension
    int nRow = this.nRows;
    int nCol = this.nCols;
    Matriks dotResult = new Matriks(nRow, m.nCols);
    for (int row = 0; row < nRow; row++) {
      for (int col = 0; col < dotResult.nCols; col++) {
        for (int tmpCol = 0; tmpCol < nCol; tmpCol++) {
          dotResult.matrix[row][col] += this.matrix[row][tmpCol] * m.matrix[tmpCol][col];
        }
      }
    }
    return dotResult;
  }

  //Determinan
  public double determinanByKofaktor() {
    //Menggunakan perkalian dot pada baris pertama matriks dengan baris kofaktor
    Matriks temp = new Matriks();
    temp = this.kofaktor();
    double hasil = 0;
    for (int col = 0; col < this.nCols; col++) {
      hasil += temp.matrix[0][col] * this.matrix[0][col];
    }
    return hasil;
  }

  public double determinanByReduksi() {
    Matriks proses = new Matriks();
    proses.copyMatrix(this);
    if (proses.isSquare()) {
      int swaps = proses.toSegitigaAtas();
      double result = 1;
      if (swaps % 2 == 1) {
        result = -1;
      }
      for (int i = 0; i < proses.nRows; i++) {
        result *= proses.matrix[i][i];
      }
      return result;
    } else { //Apabila bukan matrix persegi
      return 0;
    }
  }

  //Adjoin Matrix
  public Matriks adjoinMatrix() {
    Matriks temp = new Matriks();
    temp = this.kofaktor();
    temp.transpose();
    return temp;
  }

  public Matriks conMultiplyMatrix(double k) {
    Matriks temp = new Matriks();
    temp.copyMatrix(this);
    for (int row = 0; row < this.nRows; row++) {
      for (int col = 0; col < this.nCols; col++) {
        temp.matrix[row][col] *= k;
      }
    }
    return temp;
  }

  public Matriks augmentedKanan(Matriks right) {
    //Precondition: this.nRow == right.nRow
    Matriks hasil = new Matriks(this.nRows, this.nCols + right.nCols);
    for (int i = 0; i < this.nRows; i++) {
      for (int j = 0; j < this.nCols; j++) {
        hasil.matrix[i][j] = this.matrix[i][j];
      }
      for (int j = 0; j < right.nCols; j++) {
        hasil.matrix[i][this.nCols + j] = right.matrix[i][j];
      }
    }
    return hasil;
  }

  public void eliminasiGauss() {
    this.toSegitigaAtas();
    int idxBukanNol = 0;
    for (int i = 0; i < this.nRows; i++) {
      while (idxBukanNol < this.nCols && -epsilon < this.matrix[i][idxBukanNol] && this.matrix[i][idxBukanNol] < epsilon) {
        this.matrix[i][idxBukanNol] = 0;
        idxBukanNol++;
      }
      if (idxBukanNol < this.nCols) {
        for (int j = this.nCols - 1; j >= idxBukanNol; j--) {
          this.matrix[i][j] /= this.matrix[i][idxBukanNol];
        }

      }
    }
  }

  public void eliminasiGaussJordan() {
    this.eliminasiGauss();
    int awal = 0;
    for (int i = 0; i < this.nRows; i++) {
      while (awal < this.nCols && -epsilon < this.matrix[i][awal] && this.matrix[i][awal] < epsilon) {
        this.matrix[i][awal] = 0;
        awal++;
      }
      if (awal < this.nCols) {
        for (int j = 0; j < i; j++) {
          this.addRowToRow(i, j, -this.matrix[j][awal]);
        }
      }
    }
  }

  public Matriks inverseByKofaktor() {
    Matriks temp = new Matriks();
    temp = this.adjoinMatrix();
    double ratio = 1 / (this.determinanByKofaktor());
    temp = temp.conMultiplyMatrix(ratio);
    return temp;
  }

  public Matriks inverseByAugmented() {
    //Assumption Matrix is square, however put a condition just in case
    Matriks inverse = new Matriks(this.nCols, this.nRows);
    if (this.isSquare()) {
      Matriks identity = new Matriks(this.nRows);
      Matriks augmented = new Matriks();
      augmented = this.augmentedKanan(identity);
      augmented.eliminasiGaussJordan();
      boolean isIdentityAfterInverse = true;
      for (int i = 0; i < this.nRows; i++) {
        if (augmented.matrix[i][i] != 1) {
          isIdentityAfterInverse = false;
        }
      }
      if (isIdentityAfterInverse) {
        for (int i = 0; i < this.nRows; i++) {
          for (int j = 0; j < this.nCols; j++) {
            inverse.matrix[i][j] = augmented.matrix[i][j + this.nCols];
          }
        }
      }
    }
    return inverse;
  }

  private double methodCrammerHelper(Matriks sol, int col) {
    Matriks wat = new Matriks();
    wat.copyMatrix(this);
    wat.gantiOneColom(sol, col);
    return wat.determinanByReduksi();
  }

  public Matriks metodeCrammer() throws Exception {
    //Fungsi menerima matriks augmented berukuran nx(n+1)
    //pisah dahulu matriksnya baru bisa dilakkukan metodecrammer
    //setelah dipisah matriks akan berukuran nxn dan nx1
    if (this.getNRows() + 1 == this.getNCols()) {
      Matriks asli, kons;
      asli = this.cutOneCol(this.nCols - 1);
      kons = this.akhirDariAugmented();

      double det = asli.determinanByReduksi();
      Matriks solusi = new Matriks(asli.nRows, 1);
      for (int i = 0; i < asli.nCols; i++) {
        double hasil = (asli.methodCrammerHelper(kons, i) / det);
        solusi.matrix[i][0] = hasil;
      }

      Matriks augmentedSolusi = new Matriks(this.getNRows(), this.getNCols());
      for(int i=0; i < augmentedSolusi.getNRows(); i++){
        for(int j=0; j < augmentedSolusi.getNCols(); j++){
          if(j == augmentedSolusi.getNCols() - 1){
            augmentedSolusi.setElmt(i,j,solusi.getElmt(i,0));
          }else if(i == j){
            augmentedSolusi.setElmt(i,j,1);
          }else{
            augmentedSolusi.setElmt(i,j,0);
          }
        }
      }

      return augmentedSolusi;
    } else {
      throw new Exception("Ukuran matriks yang digunakan tidak diizinkan.");
    }
  }

  public String getMatriksStr(){
    StringBuilder res = new StringBuilder();

    for(int i = 0; i < this.getNRows(); i++){
      for(int j = 0; j < this.getNCols(); j++){
        res.append(this.getElmt(i,j) == 0 ? 0.0 : this.getElmt(i,j));

        if(j < this.getNCols() - 1){
          res.append(" ");
        }
      }

      res.append("\n");
    }

    return res.toString();
  }
}

