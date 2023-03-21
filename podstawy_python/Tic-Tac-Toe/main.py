# pola są ponumerowane od 1 do 9, idąc od lewej do prawej oraz z góry na dół
# gracze wpisują numer pola na zmianę


board = {0:" ", 1:" ", 2:" ", 3:" ", 4:" ", 5:" ", 6:" ", 7:" ", 8:" ",}

g1 = input("Gracz nr.1 (X): ")
g2 = input("Gracz nr.2 (O): ")

licznik = 0
gra = True

def wygrany(gracz, znak):

    # zwiększenie licznika do 3 oznacza wygraną
    wygrana = 0

    # poziom
    for i in board:
        if board[i] == znak:
            wygrana += 1
            if wygrana == 3 and (int(i)+1) % 3 == 0:
                print("")
                print("Wygrał gracz", gracz, ". Gratulacje! (Poziom)")
                print("")
                return False
        else:
            wygrana = 0

    wygrana = 0

    # pion
    for o in range(0,9,3):
        if board[o] == znak:
            wygrana += 1
            if wygrana == 3:
                print("")
                print("Wygrał gracz", gracz, ". Gratulacje! (Pion)")
                print("")
                return False
        else:
            wygrana = 0

    # ukos
    if(board[0] == znak and board[4] == znak and board[8] == znak) or (board[2] == znak and board[4] == znak and board[6] == znak):
            print("")
            print("Wygrał gracz", gracz, ". Gratulacje! (Ukos)")
            print("")
            return False

    #remis
    for p in board:
        m = 0
        if board[p] == " ":
            m += 1
            if m != 0:
                print("Remis")
                return False
        else:
            return True

    return True

# rysowanie planszy
def plansza():
    print("-------------")
    print("| {0} | {1} | {2} |".format(board[0], board[1], board[2]))
    print("-------------")
    print("| {0} | {1} | {2} |".format(board[3], board[4], board[5]))
    print("-------------")
    print("| {0} | {1} | {2} |".format(board[6], board[7], board[8]))
    print("-------------")

# wykonywanie ruchu gracza
def ruszanie(gracz, znak, l):
    try:
        ruch = int(input("Ruch gracza {0}: ".format(gracz)))
        if board[ruch - 1] != "O" and board[ruch - 1] != "X":
            board[ruch-1] = znak
            l += 1
            plansza() # żeby plansza nie była zbyt często rysowana
        else:
            print("")
            print("W tym miejscu już był ruch.")
            print("")
    except KeyError:
        print("")
        print("Nie ma pola o takim numerze")
        print("")
    except ValueError:
        print("")
        print("Nie ma pola o takim numerze")
        print("")
    return l

# pierwsze wczytanie planszy
print("")
print("Numeracja pól")
print("-------------")
print("| 1 | 2 | 3 |")
print("-------------")
print("| 4 | 5 | 6 |")
print("-------------")
print("| 7 | 8 | 9 |")
print("-------------")

# gra
while gra:
    if licznik % 2 == 0:
        licznik = ruszanie(g1, "X", licznik)
        gra = wygrany(g1, "X")
    else:
        licznik = ruszanie(g2, "O", licznik)
        gra = wygrany(g2, "O")

