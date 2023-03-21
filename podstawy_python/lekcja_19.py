# analiza tekstu (Praktyka)

plik = open("tekst.txt", "r")
tekst = plik.read()
plik.close()

def policz(txt, znak):
    licznik = 0
    for z in txt:
        if z == znak:
            licznik += 1
    return licznik

print("Liczba wystąpień znaku:", policz(tekst.lower(), "a"))

for i in "abcdefghijklmnoprstuwz":
    ilosc = policz(tekst.lower(), i)
    procent = 100 * ilosc / len(tekst)
    print("{znak} - {procent}% - {liczba}".format(znak = i, procent = round(procent, 2), liczba = ilosc))
    