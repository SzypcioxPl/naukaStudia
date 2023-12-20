# operatory logiczne

wiek = 19
kasa = 23

# if wiek >= 18:
#     if kasa >= 35:
#         print("Może wejść")
# if wiek >= 18 and kasa >= 35:
#     print("Może wejść")

# if wiek <= 12 or kasa >= 30:
#     print("Może wejść")

if not wiek > 12 or kasa >= 30:
    print("Może wejść")
else:
    print("Nie może wejść")

if True or False and False:
    print("Prawda")
else:
    print("Fałsz")