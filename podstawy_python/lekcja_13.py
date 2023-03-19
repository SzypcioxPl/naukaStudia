# rzucanie wyjątków

def dzielenie(x, y):
    # assert y != 0, "y == 0"
    if y == 0:
        raise ZeroDivisionError("Dzielenie przez 0 jest zakazane!")
    print(x / y)


try:
    dzielenie(2, 0)
except ZeroDivisionError:
    print("Błąd")
    raise
