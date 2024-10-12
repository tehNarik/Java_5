# Інструкція по запуску та використанню

## Опис
Ця програма реалізує функціональність для керування автопарком таксі. Вона дозволяє додавати різні типи автомобілів до автопарку, обчислювати загальну вартість автопарку, сортувати автомобілі за витратами палива, а також знаходити автомобілі в заданому діапазоні максимальної швидкості.

## Вимоги
- Java Development Kit (JDK) версії 8 або вище.
- Установлений Git (для клонування репозиторію).

## Як запустити проект

### Крок 1: Клонування репозиторію
Відкрийте термінал (або командний рядок) і виконайте команду:

git clone https://github.com/tehNarik/Java_5.git

### Крок 2: Перейдіть до директорії проекту
cd Java_5

### Крок 3: Компиляція проекту
Використовуйте команду javac для компіляції файлу Main.java:

javac Main.java

### Крок 4: Запуск проекту
Виконайте наступну команду для запуску програми:

java Main

## Функціонал програми:
Після запуску програма виконає такі дії:

- Створить автопарк, що містить автомобілі різних класів (седан, позашляховик, хетчбек).
- Виведе список автомобілів, доданих до автопарку.
- Обчислить та виведе загальну вартість всіх автомобілів у парку.
- Відсортує автомобілі за витратами палива та виведе результати.
- Знайде та виведе автомобілі, які потрапляють у заданий діапазон максимальної швидкості (наприклад, від 180 до 220 км/год).
