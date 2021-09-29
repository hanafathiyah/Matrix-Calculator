import math

n = int(input("Nilai n: "))
path = input("Masukkan path: ")

f = open(path, "w")
f.write(str(n))
f.write("\n")

step = 2/(n-1)
i = 0

def func(x):
    return (x ** 2 + math.sqrt(x))/(math.exp(x)+x)

while(i <= 2):
    f.write(f"{i} {func(i)}\n")
    i += step

f.close()

