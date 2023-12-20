# operatory matematyczne, konwersja typów

print("Kolejność działań")
print((4 + 5) * 3)
print(23 / 4)
print(23 // 4)

print(4*5)
print(2 ** 10)

x = 5
x = x + 5
x += 5
print(x)
# x++ nie działa, błąd

print("Konwersja typów")
a = input("Podaj 1 liczbę: ")
b = input("Podaj 2 liczbę: ")
print(a + b)
print(int(a) + int(b))
a = 2.5
b = 4.56
print(float(a) + float(b))
print(str(a) + " " + str(b))

del a
# print(float(a) + float(b)) nie zadziała, bo zmienna "a" nie istnieje
