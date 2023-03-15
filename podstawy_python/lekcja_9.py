# funkcje cz.1

def funkcja_test():
    print("Funkcja...")
funkcja_test()

def dodaj(x):
    print(x + 1)
zmienna = dodaj(3)
print(zmienna)
def dodaj(x, y = 1, z = 0):
    print(x, "+", y, "+", z, "=")
    return x + y + z
print(dodaj(2, 5))
print(dodaj(2))
wynik = dodaj(1,2,3)
print(wynik)