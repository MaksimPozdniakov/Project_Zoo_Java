#7. В подключенном MySQL репозитории создать базу данных “Друзья
#человека”
#8. Создать таблицы с иерархией из диаграммы в БД
#9. Заполнить низкоуровневые таблицы именами(животных), командами
#которые они выполняют и датами рождения

DROP DATABASE IF EXISTS friends_human;
CREATE DATABASE friends_human;
USE friends_human;

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    kind_animals VARCHAR(50)
);

INSERT INTO `animals` (`id`, `kind_animals`) values
(1, 'cat'),
(2, 'cat'),
(3, 'dog'),
(4, 'dog'),
(5, 'hamster'),
(6, 'hamster'),
(7, 'horse'),
(8, 'horse'),
(9, 'camel'),
(10, 'camel'),
(11, 'donkey'),
(12, 'donkey');

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	pet_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `pets` (`pet_id`, `animal_id`) values
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
	pack_animal_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);


INSERT INTO `pack_animals` (`pack_animal_id`, `animal_id`) values
(1, 7),
(2, 8),
(3, 9),
(4, 10),
(5, 11),
(6, 12);


DROP TABLE IF EXISTS cats;
CREATE TABLE cats (
	cat_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(50),
    commands TEXT,
    birthday DATE,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `cats` (`cat_id`, `animal_id`, `name`, `commands`, `birthday`) values
(1, 1, 'Мурзик', 'стоять, лежать', '2020-08-01'),
(2, 2, 'Томик', 'прыжок, смотреть', '2022-11-08');


DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
	dog_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(50),
    commands TEXT,
    birthday DATE,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `dogs` (`dog_id`, `animal_id`, `name`, `commands`, `birthday`) values
(1, 3, 'Тедди', 'сидеть, стоять', '2020-01-08'),
(2, 4, 'Доги', 'дай лапу, лежать', '2022-12-08');


DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters (
	hamster_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(50),
    commands TEXT,
    birthday DATE,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `hamsters` (`hamster_id`, `animal_id`, `name`, `commands`, `birthday`) values
(1, 5, 'Стаилз', 'бежать, стоять', '2023-11-08'),
(2, 6, 'Родж', 'стоять, лежать', '2023-10-07');


DROP TABLE IF EXISTS horses;
CREATE TABLE horses (
	horse_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(50),
    commands TEXT,
    birthday DATE,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `horses` (`horse_id`, `animal_id`, `name`, `commands`, `birthday`) values
(1, 7, 'Морковка', 'прыжок, галоп', '2017-11-08'),
(2, 8, 'Тыковка', 'стоять, лежать', '2020-12-08');


DROP TABLE IF EXISTS camels;
CREATE TABLE camels (
	camel_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(50),
    commands TEXT,
    birthday DATE,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `camels` (`camel_id`, `animal_id`, `name`, `commands`, `birthday`) values
(1, 9, 'Горбатый', 'идти, лежать', '2018-12-08'),
(2, 10, 'Лохматый', 'бежать, лежать', '2020-12-08');


DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (
	donkey_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(50),
    commands TEXT,
    birthday DATE,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

INSERT INTO `donkeys` (`donkey_id`, `animal_id`, `name`, `commands`, `birthday`) values
(1, 11, 'Тонкий', 'идти, лежать', '2017-11-10'),
(2, 12, 'Громкий', 'бежать, лежать', '2021-11-11');


#10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
#питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

DELETE camels, pack_animals, animals FROM camels
JOIN pack_animals 
JOIN animals
WHERE camels.animal_id = pack_animals.animal_id AND
		camels.animal_id = animals.id;
	
	
	
SELECT horse_id, NULL AS donkey_id, animal_id, name, commands, birthday
FROM horses
UNION
SELECT NULL AS horse_id, donkey_id, animal_id, name, commands, birthday
FROM donkeys;	
	
#11.Создать новую таблицу “молодые животные” в которую попадут все
#животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
#до месяца подсчитать возраст животных в новой таблице

DROP TABLE IF EXISTS young_animals;		
CREATE TABLE young_animals
SELECT animals.*,
		cats.name,
		TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age
FROM cats
LEFT JOIN animals ON animals.id = cats.animal_id
WHERE TIMESTAMPDIFF(MONTH, birthday, NOW()) < 37 AND TIMESTAMPDIFF(MONTH, birthday, NOW()) > 11
UNION
SELECT animals.*,
		dogs.name,
		TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age
FROM dogs
LEFT JOIN animals ON animals.id = dogs.animal_id
WHERE TIMESTAMPDIFF(MONTH, birthday, NOW()) < 37 AND TIMESTAMPDIFF(MONTH, birthday, NOW()) > 11
UNION
SELECT animals.*,
		hamsters.name,
		TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age
FROM hamsters
LEFT JOIN animals ON animals.id = hamsters.animal_id
WHERE TIMESTAMPDIFF(MONTH, birthday, NOW()) < 37 AND TIMESTAMPDIFF(MONTH, birthday, NOW()) > 11
UNION
SELECT animals.*,
		horses.name,
		TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age
FROM horses
LEFT JOIN animals ON animals.id = horses.animal_id
WHERE TIMESTAMPDIFF(MONTH, birthday, NOW()) < 37 AND TIMESTAMPDIFF(MONTH, birthday, NOW()) > 11
UNION
SELECT animals.*,
		name,
		TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age
FROM donkeys
LEFT JOIN animals ON animals.id = donkeys.animal_id
WHERE TIMESTAMPDIFF(MONTH, birthday, NOW()) < 37 AND TIMESTAMPDIFF(MONTH, birthday, NOW()) > 11;


#12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
#прошлую принадлежность к старым таблицам.

SELECT animals.id, cats.*, dogs.*, hamsters.*, horses.*, donkeys.*
FROM animals
LEFT JOIN cats ON animals.id = cats.animal_id
LEFT JOIN dogs ON animals.id = dogs.animal_id
LEFT JOIN hamsters ON animals.id = hamsters.animal_id
LEFT JOIN horses ON animals.id = horses.animal_id
LEFT JOIN donkeys ON animals.id = donkeys.animal_id;


