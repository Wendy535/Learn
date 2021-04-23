import java.util.Scanner
import java.util.Random

const val dotDefault = '_'
const val dotEmpty = '•'
const val dotFire = 'X'
const val aiShip = 'S'
const val aiEmpty = 'E'
const val fieldSizeX: Int = 10
const val fieldSizeY: Int = 10
var battleField: Array<Array<Char>> = Array(10, { Array(10, {'_'})})
var aiShips: Array<Array<Char>> = Array(10, { Array(10, {'E'})})
val scanner = Scanner(System.`in`)
var counter = 0
var difficulty = 0
var misscounter = 0

fun main(args: Array<String>) {
    while (true) {
    introduction()
    aiSetsODShips()
    aiSetsTDShips()
    printBattleField()

    difficulty = chooseDiff()
        while(true) {
            if (difficulty == 1) {
                humanTurn()
                printBattleField()
                counter +=1
                if (checkWin() && counter <= 85) {
                    println("Вы победили!")
                    break
                } else if (counter > 85) {
                    println("У вас закончились снаряды.")
                    printAIBattleField()
                    break
                } else {
                    println("Игра продолжается.")
                }
            }
            if (difficulty == 2) {
                humanTurn()
                printBattleField()
                counter +=1
                if (checkWin() && counter <= 85) {
                    println("Вы победили!")
                    break
                } else if (counter > 85) {
                    println("У вас закончились снаряды.")
                    break
                } else {
                    println("Игра продолжается.")
                    if (misscounter == 5) {
                        misscounter = 0
                        counter += 3
                    }
                }
            }
            if (difficulty == 3) {
                humanTurn()
                printBattleField()
                counter += 1
                if (checkWin() && counter <= 85) {
                    println("Вы победили!")
                    break
                } else if (counter > 85) {
                    println("У вас закончились снаряды.")
                    break
                } else {
                    println("Игра продолжается.")
                    if (misscounter == 5) {
                        misscounter = 0
                        counter += 5
                    }
                }
            }
        }
        println("Игра закончена. Хотите сыграть еще?")
        println("Нажмите 1 чтобы продолжить, 0 - чтобы выйти")
        var restarter = scanner.nextInt()
        if (restarter == 1) {
            counter == 0
            difficulty == 0
        } else {
            break
        }
    }
}

//Введение - приветствие и правила игры
fun introduction() {
    println("Добро пожаловать в игру ${"Морской бой"}")
    println("Наши правила немного отличаются от классической игры.")
    println("Прежде всего, корабли есть только у компьютера. Но у вас есть пушка.")
    println("Перед началом игры компьютер расставляет свои корабли.")
    println("4 однопалубных и 3 двухпалубных.")
    println("Вы пытаетесь найти корабли компьютера и уничтожить.")
    println("Для этого у вас есть фиксированное число ходов. Не такое уж и большое.")
    println("В зависимости от уровня сложности вы можете терять ходы за то,")
    println("что слишком части ${"мажете"}.")
    println("Дальше все зависит только от вас и вашего терпения.")
    println("Удачи!")
}


//Выводим на экран поле боя
fun printBattleField() {
    print("   ")
    for (i in 0..((fieldSizeX - 1) * 2 + 1)) {
        print(if (i % 2 == 0) "-" else i / 2 + 1)
    }
    println()

    for (i in 0..(fieldSizeY - 1)) {
        if (i < 9) print("0${(i + 1)} |")
        if (i == 9) print("${(i + 1)} |")
        for (j in 0..(fieldSizeX - 1)) {
            print(battleField[i][j].toString() + "|")
        }
        println()
    }


    for (i in 0..((fieldSizeX) * 2 + 1)) {
        print("-")
    }
    println()
}

//Поле боя со стороны компьютера - для тестов
fun printAIBattleField() {
    print("   ")
    for (i in 0..((fieldSizeX - 1) * 2 + 1)) {
        print(if (i % 2 == 0) "-" else i / 2 + 1)
    }
    println()

    for (i in 0..(fieldSizeY - 1)) {
        if (i < 9) print("0${(i + 1)} |")
        if (i == 9) print("${(i + 1)} |")
        for (j in 0..(fieldSizeX - 1)) {
            print((aiShips[i][j].toString()) + "|")
        }
        println()
    }

    for (i in 0..((fieldSizeX) * 2 + 1)) {
        print("-")
    }
    println()
}

//Выбор сложности
fun chooseDiff(): Int {
    println("Выберите сложность игры, нажав 1, 2 или 3.")
    println("На сложности 1 вы имеете 85 ходов")
    println("На сложности 2 у вас 85 ходов. Каждые 5 выстрелов ${"в молоко"} подряд")
    println("отнимают у вас по 3 хода.")
    println("На сложности 3 у вас тоже 85 ходов, но плата за холостые выстрелы выше - ")
    println("по 5 ходов за каждые 5 выстрелов мимо, сделанные подряд.")
    println("Введите сложность: ")
    val difficulty = scanner.nextInt()
    if (difficulty != null) {
        when (difficulty) {
            1 -> println("Окей, играем в простую игру.")
            2 -> println("Вот это интересно! Играем на средней сложности.")
            3 -> println("Повеселимся! Играем на максимальной сложности")
            else -> println("Сложность введена неверно. Попробуйте еще.")
        }
    }
    return difficulty
}

//Проверка ячейки
fun isCellEmpty(x: Int, y: Int): Boolean {
    if (aiShips[y][x] == 'E') return true
    return false
}

//Компьютер расставляет однопалубные корабли
fun aiSetsODShips() {
    var x: Int
    var y: Int
    var shipCounter = 0
    while (shipCounter < 4) {
        x = (0..9).random()
        y = (0..9).random()
        if (isCellEmpty(x, y) && checkEmptyAround(x, y, 8)) {
            aiShips[y][x] = 'S'
            shipCounter += 1
        }
    }
}


//Компьютер расставляет двухпалубные корабли
fun aiSetsTDShips() {
    var a = 0
    var b = 0
    var x: Int
    var y: Int
    var shipCounter1 = 0
    var shipCounter2 = 0

    while (shipCounter1 < 3) {
        x = (0..9).random()
        y = (0..9).random()
        if (isCellEmpty(x, y) && checkEmptyAround( x, y, 8) && checkEmptyAround(x, y +1, 8)) {
            aiShips[y][x] = 'S'
            aiShips[y + 1][x] = 'S'
            shipCounter1 +=1
        } else {
            continue
        }
    }

    while(shipCounter2 < 3) {
        x = (0..9).random()
        y = (0..9).random()
        if (isCellEmpty(x, y) && checkEmptyAround(x, y, 8) && checkEmptyAround(x + 1, y, 8)) {
            aiShips[y][x] = 'S'
            aiShips[y][x + 1] = 'S'
            shipCounter2 += 1
        } else {
            continue
        }
    }
}

//Проверка на пустые места

fun checkEmptyAround(x: Int, y: Int, number: Int): Boolean {
    var dotcount = 0

    if (y + 1 < fieldSizeY && aiShips[y + 1][x] != 'S') dotcount +=1

    if (x + 1 < fieldSizeX && aiShips[y][x + 1] != 'S') dotcount +=1

    if (y + 1 < fieldSizeY && x + 1 < fieldSizeX && aiShips[y + 1][x + 1] != 'S') dotcount += 1

    if (y - 1 >= 0 && aiShips[y - 1][x] != 'S') dotcount +=1

    if (x - 1 >= 0 && aiShips[y][x - 1] != 'S') dotcount +=1

    if (x - 1 >= 0 && y - 1 >= 0 && aiShips[y - 1][x - 1] != 'S') dotcount +=1

    if (y - 1 >= 0 && x + 1 < fieldSizeX && aiShips[y - 1][x + 1] != 'S') dotcount +=1

    if (y + 1 < fieldSizeY && x - 1 >= 0 && aiShips[y + 1][x - 1] != 'S') dotcount +=1

    if (dotcount == number) {
        return true
    }
    return false
}

fun humanTurn() {
    println("Введите координаты противника, две цифры через пробел.")
    println("Первая цифра - координаты по горизонтали, вторая - по вертикали")
    var x: Int = scanner.nextInt() - 1
    var y: Int = scanner.nextInt() - 1
    if (x != null && y != null) {
        if (aiShips[y][x] == 'S') {
            if (checkEmptyAround(y, x, 8)) {
                println("Убил")
            }
            if (checkEmptyAround(y, x, 7)) {
                println("Ранил")
            }
            aiShips[y][x] == 'E'
            battleField[y][x] = 'X'
        } else if (aiShips[y][x] == 'E') {
            battleField[y][x] = dotEmpty
            println("Мимо")
            misscounter += 1
        }
        println("Сделано выстрелов: $counter")
    }
}

fun checkWin(): Boolean {
    for (y in 0..fieldSizeY - 1) {
        for (x in 0..fieldSizeX - 1) {
            if (aiShips[y][x] == 'S') return false
        }
    }
    return true
}

