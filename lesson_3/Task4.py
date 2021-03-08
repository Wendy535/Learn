a = float(input("Введите действительное положительное число: "))
b = int(input("Введите целое отрицательное число: "))


def involute(a, b):
    k = a**b #Стандартную операцию возведения в степень оставила здесь для сопоставления результатов
    print(k)
    inv = 1
    for x in range(abs(b)):
        inv *= a
    return 1/inv


print(involute(a, b))