a = int(input("Введите число: "))
b = int(input("Введите еще число: "))

def simple_divide(a, b):
    if a != 0 and b != 0:
        return a / b
    if a == 0 or b == 0:
        return "С нолем шутки плохи"
print(simple_divide(a,b))
