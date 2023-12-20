# lista

lista = [1, 2, "c", "d", "e"]
print(lista)
print(lista[3])
lista[2] = 3
print(lista)
tekst = "Hello World"
print(tekst[4])
print(lista + ["f", "g"])
print(lista * 3)
print("Długość listy:", len(lista))

lista.append("f")
print(lista)
lista.append(["g", "h", "i"])
print(lista)
print(lista[6][2])

lista.insert(3, 3)
print(lista)

print("Ilość powtórzeń:", lista.count(3))
print("Index:", lista.index("f"))
lista.remove("f")
print(lista)

lista2 = [1, 2, 6, 3, 56, -19, -3, -6]
print("Min:", min(lista2))
print("Max:", max(lista2))
lista2.sort()
print(lista2)
lista2.reverse()
print(lista2)
lista2.clear()
print(lista2)