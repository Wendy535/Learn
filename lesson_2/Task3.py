month = int(input("Введите месяц: "))
winter = [12, 1, 2]
spring = [3, 4, 5]
summer = [6, 7, 8]
autumn = [9, 10, 11]
if month in winter:
    print("На дворе зима")
elif month in spring:
    print("Весна!")
elif month in summer:
    print("Лето, ах, лето!")
elif month in autumn:
    print("Поздняя осень, грачи улетели")
else:
    print("А что это вы такое напечатали?")

print("Попробуем еще")
mon = int(input("Который нынче месяц? "))
calendar = [(12, 1, 2), (3, 4, 5), (6, 7, 8), (9, 10, 11)]
if mon in calendar[0]:
    print("Зима")
elif mon in calendar[1]:
    print("Весна")
elif mon in calendar[2]:
    print("Лето")
elif mon in calendar[3]:
    print("Осень")
else:
    print("Нет такой цифры")

print("И еще попробуем!")

mn = input("Товарищ месяц, ваш порядковый номер? ")
calend1 = {
    12: "Декабрь, Зима",
    1: "Январь, Зима",
    2: "Февраль, Зима",
    3: "Март, Весна",
    4: "Апрель, Весна",
    5: "Май, Весна",
    6: "Июнь, Лето",
    7: "Июль, Лето",
    8: "Август, Осень",
    9: "Сентябрь, Осень",
    10: "Октябрь, Осень",
    11: "Ноябрь, Осень"
}
print(calend1[int(mn)])