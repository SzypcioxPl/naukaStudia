# słownik - dictionary

slownik = {1: "Poniedziałek", 2: "Wtorek", 3: "Środa", 7: "Niedziela"}

print(slownik[1])
print(slownik[2])
print(slownik[7])
print(slownik)

slownik[4] = "Czwartek"
slownik[5] = True
slownik[6] = 31

slownik["a"] = 1
print(slownik["a"])

try:
    print(slownik[8])
except KeyError:
    print("\n", "Nie ma elementu o takim kluczu!", "\n")

print(slownik.get(8, "Inny dzień"))
print(slownik.get(7, "Inny dzień"), "\n")

print("Pętla: ")

for i in slownik:   # slownik.values(), slownik.keys()
    print("-", slownik[i])

print("")

print(slownik.pop(1))
print(slownik)