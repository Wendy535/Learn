run = float(input("Результат первого дня: "))
goal = float(input("Результат, к которму надо стремиться: "))
day_counter = 1
while run < goal:
    run *= 1.1
    day_counter += 1
print(f"Цель достигнута на {day_counter}й день")
