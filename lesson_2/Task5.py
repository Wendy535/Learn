my_list = [8, 6, 6, 6, 4, 3]
x = int(input("Введите число: "))
index = my_list.index(x)
if x in my_list is True:
    my_list.insert(int(index), x)
else:
    my_list.append(x)
my_list.sort(reverse = True)
print(my_list)
