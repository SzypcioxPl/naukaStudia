# pętle, instrukcje skoku

# i = 0
# while i <= 5:
#     print(i)
#     i += 1
# print("Koniec")

i = 0
while True:
    i += 1
    if i % 2 == 1:
        continue
    print(i)
    if i > 10:
        break
print("Koniec")