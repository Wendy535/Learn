line = input("Введите строку чисел: ")
total = 0

def gimmesum(line):
    line2 = line.split(" ")
    sums = 0
    for x in line2:
        if x.isdigit() == True:
            x = int(x)
            sums += x
        if x in ["@", "#", ".", ",", ":", ";", "!", "*"]:
            print("Это не число!")
            break
    global total
    total += sums
    return sums, total
print(gimmesum(line))


line = input("Введите строку чисел: ")
gimmesum(line)
print(gimmesum(line))

