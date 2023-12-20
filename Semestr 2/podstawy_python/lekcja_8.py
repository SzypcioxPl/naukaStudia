# pętla obiektowa FOR, funkcja range

lista = ["Witaj", "Świecie", "!"]

i = 0
while i < len(lista):
    print(lista[i])
    i += 1

for x in lista:
    print(x)

print(list(range(10)))

for y in range(1, 24, 3):
    print(y)