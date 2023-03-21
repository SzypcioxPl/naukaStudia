# wyrażenia listowe

lista = list(range(10))

nowa = [i * 2 for i in lista]
nowa2 = [i + 2 for i in lista if i % 2 == 0]
print(lista)
print("Nowa: ", nowa)
print("Nowa2: ", nowa2)

# string formatter

argumenty = ["Grzegorz", 20]
tekst = "Cześć mam na imię {imie} i mam {wiek} lat. {imie}".format(imie = argumenty[0], wiek = argumenty[1])
tekst2 = "Cześć mam na imię {1} i mam {0} lat. {1}".format(argumenty[0],argumenty[1])
print(tekst)
print(tekst2)