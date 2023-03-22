# mapa i filtr (map & filter)

liczby = [2, 4, 7, 12, 16, 19, 25, 29, 36, 47, 50, 62, 87, 99]

def funkcja(x):
    return x * 2

wynik = list(map(funkcja, liczby))
print(liczby)
print(wynik)

wynik2 = list(map((lambda x: x * 3), liczby))
print(wynik2)

wynik3 = filter((lambda x: x % 2 == 0), liczby)
print(list(wynik3))