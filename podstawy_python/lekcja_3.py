# operatory porównania, instrukcje warunkowe

x = True
y = False
print(x)
print(y)

print(5 == 5)
print(5 != 5)

print(5 > 5)
print(5 < 5)
print(5 >= 5)
print(5 <= 5)

z = input("Podaj liczbę: ")

if int(z) == 5:
    print("Wpisałeś liczbę równą 5")
elif 5 > int(z) >= 0:    # int(z) < 5 and int(z) >= 0
    print("Wpisałeś liczbę mniejszą od 5")
elif int(z) < 0:
    print("Wpisałeś liczbę ujemną")
else:
    print("Wpisałeś liczbę większą od 5")

print("Koniec programu")