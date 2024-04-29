DROP DATABASE IF EXISTS `human_friends`;

CREATE DATABASE IF NOT EXISTS `human_friends`;

USE `human_friends`;

CREATE TABLE `animals` (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
  animals_class VARCHAR(30)
);

CREATE TABLE `dogs` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `birth_date` DATE NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE
);

CREATE TABLE `cats` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `birth_date` DATE NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE
);

CREATE TABLE `hamsters` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `birth_date` DATE NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE
);

INSERT INTO `human_friends`.`animals` (`id`, `animals_class`) VALUES ('1', 'pet'),('2', 'wild');


INSERT INTO `human_friends`.`dogs` (`name`, `skills`, `birth_date`, `animal_class_id`) VALUES
  ('Buddy', 'Sit, Stay, Fetch', '2019-02-10', 1),
  ('Max', 'Roll over, Shake hands', '2018-06-15', 1),
  ('Bailey', 'Play dead, Jump', '2020-01-05', 1),
  ('Charlie', 'Speak, Catch', '2017-09-20', 1),
  ('Luna', 'Bark, Spin', '2016-12-08', 1);


INSERT INTO `human_friends`.`cats` (`name`, `skills`, `birth_date`, `animal_class_id`) VALUES
  ('Oliver', 'Purr, Pounce', '2018-04-25', 1),
  ('Leo', 'Groom, Sleep', '2019-07-10', 1),
  ('Milo', 'Climb, Hunt', '2020-03-17', 1),
  ('Lily', 'Stretch, Chase', '2017-11-30', 1),
  ('Simba', 'Meow, Play', '2016-09-12', 1);

INSERT INTO `human_friends`.`hamsters` (`name`, `skills`, `birth_date`, `animal_class_id`) VALUES
  ('Coco', 'Run on the wheel', '2021-01-03', 1),
  ('Peanut', 'Hide food, Burrow', '2022-02-14', 1),
  ('Oreo', 'Climb tubes', '2020-11-20', 1),
  ('Biscuit', 'Cheek pouches, Dig', '2019-10-05', 1),
  ('Hazel', 'Gnaw, Explore', '2023-04-01', 1);


CREATE TABLE `young_animals` (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(50) NOT NULL,
  `species` VARCHAR(20) NOT NULL,
  `age_months` INT NOT NULL
);

-- Вставляем данные из таблиц `dogs`, `cats`, `donkeys`, `hamsters`, и `horses` в таблицу `young_animals`
INSERT INTO `young_animals` (`name`, `species`, `age_months`)
SELECT `name`, 'Dog' AS `species`, TIMESTAMPDIFF(MONTH, `birth_date`, CURDATE()) AS `age_months`
FROM `dogs`
WHERE `birth_date` <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND `birth_date` >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

INSERT INTO `young_animals` (`name`, `species`, `age_months`)
SELECT `name`, 'Cat' AS `species`, TIMESTAMPDIFF(MONTH, `birth_date`, CURDATE()) AS `age_months`
FROM `cats`
WHERE `birth_date` <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND `birth_date` >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

INSERT INTO `young_animals` (`name`, `species`, `age_months`)
SELECT `name`, 'Hamster' AS `species`, TIMESTAMPDIFF(MONTH, `birth_date`, CURDATE()) AS `age_months`
FROM `hamsters`
WHERE `birth_date` <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND `birth_date` >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);


CREATE TABLE `all_animals` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `birth_date` DATE NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  `source_table` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `all_animals` (`name`, `skills`, `birth_date`, `animal_class_id`, `source_table`)
SELECT `name`, `skills`, `birth_date`, `animal_class_id`, 'dogs' AS `source_table`
FROM `dogs`;

INSERT INTO `all_animals` (`name`, `skills`, `birth_date`, `animal_class_id`, `source_table`)
SELECT `name`, `skills`, `birth_date`, `animal_class_id`, 'cats' AS `source_table`
FROM `cats`;

INSERT INTO `all_animals` (`name`, `skills`, `birth_date`, `animal_class_id`, `source_table`)
SELECT `name`, `skills`, `birth_date`, `animal_class_id`, 'hamsters' AS `source_table`
FROM `hamsters`;


