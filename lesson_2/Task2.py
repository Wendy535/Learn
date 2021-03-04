inc = input("Напечатайте что-нибудь: ")
my_list = list(inc)
print(f"Было: {my_list}")

for x in range(0, len(my_list) - 1, 2):
    my_list[x], my_list[x + 1] = my_list[x + 1], my_list[x]

print(f"Стало: {my_list}")
