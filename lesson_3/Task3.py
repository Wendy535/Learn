a = int(input("Введите число: "))
b = int(input("Введите число: "))
c = int(input("Введите число: "))


def sum_two(a, b, c):
    line = [a, b, c]
    line.sort()
    line.pop(0)
    sums = sum(line)
    return sums

print(sum_two(a, b, c))