number = int(input("Введите число: "))
dmax = 0
while number > 10:
    d = number % 10
    d_prev = (number // 10) % 10
    if d >= d_prev:
        dmax = 0 + d
    if d < d_prev:
        dmax = 0 + d_prev
    number = number // 10
print(dmax)
