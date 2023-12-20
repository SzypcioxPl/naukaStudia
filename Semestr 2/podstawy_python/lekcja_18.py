# operacje na tekście (String) i listach

print(", ".join(["a", "b", "c"]))
print("Hello Word!".replace("Word", "World"))
print("Długie bardzo zdanie.".startswith("Dł"))
print("Długie bardzo zdanie.".endswith("as"))
print("ł" in "Długie bardzo zdanie.")
print("Długie bardzo zdanie.".upper())
print("Długie bardzo zdanie.".lower())

print("-------------")

lista = [1, 22,45,56,77,89,99]

if all([i % 2 == 0 for i in lista]):
    print("Wszystkie liczby są parzyste")
else:
    print("Są również liczby nieparzyste")

if any([i % 2 == 0 for i in lista]):
    print("W zbiorze znajduje się chociaż 1 liczba parzysta")

for i in enumerate(lista):
    print(i[0]+1, "-", i[1])