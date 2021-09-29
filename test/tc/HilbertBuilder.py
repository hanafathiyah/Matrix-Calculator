n = int(input("Masukan nilai n: "))
loc = input("Path file: ")

f = open(loc, "w")
f.write(str(n))
f.write(" ")
f.write(str(n))
f.write("\n")

for i in range(1, n + 1):
    for j in range(i, i+n):
        f.write(str(1/(j)))
        
        if j < i + n - 1:
            f.write(" ")
        else:
            f.write("\n")

