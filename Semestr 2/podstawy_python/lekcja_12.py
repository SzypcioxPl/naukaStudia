# obsługa wyjątków

x = 12
y = 0

try:
    lista = []
    print(lista[0])
    print(x + "!")
    print(x / y)
    # print("Koniec")
except (ZeroDivisionError, TypeError):
    print("Nie dzielimy przez zero!")
    print("Zły typ danych !")
except:
    print("Wystąpił błąd!")
finally:
    print("Finally")

print("Dalsze instrukcje ...")
