# mini gra "zgadnij liczbę"

from random import randint

# for i in range(100):
#     print(randint(1,10))

los = randint(1,10)
odp = -1
i = 0

print("Zgadnij liczbę z przedziału 1 - 10")

while odp != los:
    i += 1
    odp = int(input("Podaj liczbę: "))
    if odp > los:
        print("Wylosowana liczba jest mniejsza")
    elif odp < los:
        print("Wylosowana liczba jest większa")
    else:
        print("Gratulacje! Zgadłeś w", i, "podejściu")
        break
print("Koniec")