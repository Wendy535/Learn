a = "Имя"
b = "Фамилия"
c = "Год рождения"
d = "Город проживания"
e = "email"
f = "Телефон"

def user_info(**kwargs):
    info = {}
    info[a] = input(f"Введите {a}: ")
    info[b] = input(f"Введите {b}: ")
    info[c] = input(f"Введите {c}: ")
    info[d] = input(f"Введите {d}: ")
    info[e] = input(f"Введите {e}: ")
    info[f] = input(f"Введите {f}: ")
    return info

print(user_info())