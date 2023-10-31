rows = int(input("Введіть розмір квадратної матриці: "))
filler = input("Введіть символ-заповнювач: ")
row_size = rows
lst = [[]]

file = "Arr.txt"
with open(file, "w") as fout:
    # Заповнення масиву
    for i in range(rows):
        lst.append([filler] * row_size)
        if rows % 2 == 0:
            if i < rows // 2 - 1:
                row_size -= 2
            elif i > rows // 2 - 1:
                row_size += 2
        else:
            if i < rows // 2:
                row_size -= 2
            else:
                row_size += 2
    # Вивід масиву
    for i in lst:
        for j in range(0, rows - (len(i) // 2)):
            print(' ', end=' ')
        for j in i:
            print(j, end=' ')
        for j in range(0, rows - (len(i) // 2)):
            print(' ', end=' ')
        print()
    # Запис у файл
    for i in lst:
        for j in range(0, rows - (len(i) // 2)):
            fout.write('  ')
        for j in i:
            fout.write(str(j) + ' ')
        for j in range(0, rows - (len(i) // 2)):
            fout.write('  ')
        fout.write('\n')