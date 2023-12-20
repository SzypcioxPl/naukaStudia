# funkcje anonimowe - lambda

def funkcja(f, liczba):
    return f(liczba)

print(funkcja(lambda x: x * x, 34))

def kwadrat(l):
    return l * l
print(kwadrat(5))

wynik = (lambda x: x * x)(5)
print(wynik)

lam = lambda x: x * x
print(lam(5))
print(lam(25))

lam2 = lambda x, y: (x * y)*10
print(lam2(2,3))
print((lambda x, y: 2*x+2*y)(5, 6))