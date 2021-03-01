print("Здравствуйте! Сегодня я буду вашим финансовым консультантом.")
revenue = int(input("Какая у вас выручка? "))
costs = int(input("Ммм! А какие у вас косты? "))
profit = revenue - costs
margin = profit / revenue * 100
print("Так-так-так, где мой калькулятор?")
if revenue > costs:
    print("Отлично, вы работаете с прибылью!")
    print(f"Да еще и с маржой {margin}%!")
    staff = int(input("А какой у вас штат? "))
    productivity = profit / staff
    print(f"Это же {productivity} руб на сотрудника!")
elif revenue == costs:
    print("Батенька, а как вы думаете, что мешает вам работать не в ноль?")
else:
    print(f"Сочувствую, {costs - revenue} убытка - это непросто.")
