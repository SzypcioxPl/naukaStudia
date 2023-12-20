# generatory (yield)

def gen():
    i = 0
    while i < 5:
        yield i
        i += 1

for h in gen():
    print(h)

print(list(gen()))

def parzyste(x):
    k = 0
    while k <= x:
        if k % 2 == 0:
            yield k
        k += 1
print(list(parzyste(20)))