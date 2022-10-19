i, k, dan = 0, 0, ""

for i in range(9, 1, -1):
    dan = dan + ("# %d단 #" %i)

print(dan)

for i in range(9, 0, -1):
    dan = ""

    for k in range(9, 1, -1):
        dan = dan + str("%2dX %2d=%2d" % (k, i, k * i))

    print(dan)