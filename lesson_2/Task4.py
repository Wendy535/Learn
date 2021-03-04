inc = input("Скажите что-нибудь ")
inc_upd = inc.split()
for ind, x in enumerate(inc_upd):
    print(f"{ind} {x[0:10]}")