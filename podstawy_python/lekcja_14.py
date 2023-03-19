# podstawowe operacje na plikach

plik = open("test.txt", "a")
if plik.writable():
    ile = plik.write(input("Wprowadź tekst: ") + "\n")
    print("Ilość zapisanych bajtów: ", ile)
plik.close()

plik = open("test.txt", "r")

if plik.readable():
    print("Zawartość pliku: ")

    # print(plik.read())

    # tekst = plik.readlines()
    # print(tekst)
    # for t in tekst:
    #     print(t)

    for l in plik:
        print(l)
