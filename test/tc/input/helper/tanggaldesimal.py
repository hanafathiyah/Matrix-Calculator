tgl = input("Masukkan tanggal desimal: ")
tanggal = int(tgl[0:2])
bulan = int(tgl[3:5])
tahun = int(tgl[6:10])
if (tahun % 4 == 0):
    if(bulan == 2):
        hari = 29
else:
    if(bulan == 2):
        hari = 28
    elif(bulan == 1 or bulan == 3 or bulan == 5 or bulan == 7 or bulan == 8 or bulan == 10 or bulan == 12):
        hari = 31
    else:
        hari = 30
tanggaldesimal = float(bulan + (tanggal/hari))
print("tanggal(desimal) = %.3f" %tanggaldesimal)
