max@max-linux:~$ mkdir examFolder

max@max-linux:~$ cd examFolder

max@max-linux:~/examFolder$ cat > Домашние_животные

кот Гигант, 3

кот Мелкий, 5

собака Тедди, 2

собака Джеки, 4

хомяк Том, 7

хомяк Джери, 6

^C

max@max-linux:~/examFolder$ cat > Вьючные_животные

лошадь Морковка, 2

лошадь Персик, 3

верблюд Горбатый, 4

верблюд Бородатый, 4

осел Осел, 1

осел Шрек, 2

^C

max@max-linux:~/examFolder$ cat Домашние_животные

кот Гигант, 3

кот Мелкий, 5

собака Тедди, 2

собака Джеки, 4

хомяк Том, 7

хомяк Джери, 6

max@max-linux:~/examFolder$ cat Вьючные_животные

лошадь Морковка, 2

лошадь Персик, 3

верблюд Горбатый, 4

верблюд Бородатый, 4

осел Осел, 1

осел Шрек, 2

max@max-linux:~/examFolder$ cat Домашние_животные Вьючные_животные > Все_животные

max@max-linux:~/examFolder$ cat Все_животные

кот Гигант, 3

кот Мелкий, 5

собака Тедди, 2

собака Джеки, 4

хомяк Том, 7

хомяк Джери, 6

лошадь Морковка, 2

лошадь Персик, 3

верблюд Горбатый, 4

верблюд Бородатый, 4

осел Осел, 1

осел Шрек, 2

max@max-linux:~/examFolder$ mv Все_животные Друзья_человека

max@max-linux:~/examFolder$ mkdir Животные

max@max-linux:~/examFolder$ mv Друзья_человека Животные

max@max-linux:~/examFolder$ wget https://dev.mysql.com/get/mysql-apt-config_0.8.25-1_all.deb

max@max-linux:~/examFolder$ sudo dpkg -i mysql-apt-config_0.8.25-1_all.deb

max@max-linux:~/examFolder$ sudo apt-get update

max@max-linux:~/examFolder$ sudo apt-get install mysql-server

max@max-linux:~/examFolder$ wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

max@max-linux:~/examFolder$ sudo dpkg -i --force-depends google-chrome-stable_current_amd64.deb

max@max-linux:~/examFolder$ sudo dpkg -r google-chrome-stable