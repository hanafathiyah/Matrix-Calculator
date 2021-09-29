n = int(input("Masukan nilai n: "))
loc = input("Path file: ")

f = open(loc, "w")
f.write(str(n))
f.write(" ")
f.write(str(n + 1))
f.write("\n")

for i in range(1, n + 1):
    for j in range(i, i+n):
        f.write(str(1/(j)))
        f.write(" ")

    if(i == 1):
        f.write("1\n")
    else:
        f.write("0\n")
    
    
