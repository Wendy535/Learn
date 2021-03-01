sec = int(input("Время в секундах: "))
mins = sec // 60
sec_left = sec - mins * 60
if sec_left < 10:
    sec_left = str(f"0{sec_left}")
hr = mins // 60
mins_left = mins - hr * 60
if mins_left < 10:
    mins_left = str(f"0{mins_left}")
if hr < 10:
    hr = str(f"0{hr}")
print(f"{hr}:{mins_left}:{sec_left}")
