-- ПЕРВЫЙ ПУНКТ
SELECT
  ИД,
  СЭС_ИД,
  ЧЛВК_ИД,
  TO_CHAR(ДАТА, 'DD.MM.YYYY HH24:MI:SS')          AS Дата,
  TO_CHAR(ВРЕМЯ, 'DD.MM.YYYY HH24:MI:SS')         AS Время,
  АУДИТОРИЯ,
  TO_CHAR(ДАТА_К, 'DD.MM.YYYY HH24:MI:SS')        AS Дата_Л,
  TO_CHAR(ВРЕМЯ_К, 'DD.MM.YYYY HH24:MI:SS')       AS Время_К,
  АУДИТОРИЯ_К,
  УЧГОД,
  ГРУППА,
  СЕМЕСТР,
  КТО_СОЗДАЛ,
  КТО_ИЗМЕНИЛ,
  TO_CHAR(КОГДА_ИЗМЕНИЛ, 'DD.MM.YYYY HH24:MI:SS') AS Когда_Изменил
FROM Н_СЕССИЯ;

--ВТОРОЙ ПУНКТ
SELECT DISTINCT *
FROM Н_ДИСЦИПЛИНЫ;

-- ТРЕТИЙ ПУНКТ
SELECT round(TO_DATE(sysdate, 'YYYY-MM-DD') - дата_рождения)
FROM Н_ЛЮДИ
WHERE ФАМИЛИЯ LIKE 'Зинчик';

-- ЧЕТВЕРТЫЙ ПУНКТ
SELECT ФАМИЛИЯ || ' ' || SUBSTR(ИМЯ, 0, 1) || '.' || SUBSTR(ОТЧЕСТВО, 0, 1) || '.'
  AS "ФИО"
FROM Н_ЛЮДИ
WHERE EXTRACT(MONTH FROM ДАТА_РОЖДЕНИЯ) LIKE extract(
    MONTH FROM (SELECT дата_рождения
                FROM н_люди
                WHERE ид LIKE 105840));

-- ПЯТЫЙ ПУНКТ
SELECT
  фамилия,
  имя,
  отчество,
  ид
FROM н_люди
WHERE (substr(to_char(фамилия), 1, 2)) LIKE substr((SELECT фамилия
                                                    FROM н_люди
                                                    WHERE ид LIKE 105840), 1, 2)
      AND rownum < 75
ORDER BY фамилия;

--ШЕСТОЙ ПУНКТ
SELECT
  фамилия,
  имя,
  отчество,
  ид
FROM н_люди
WHERE
  substr(имя, 1, 1) NOT IN ('А', 'Б', 'З', 'К', 'У') AND
  substr(отчество, 1, 1) NOT IN ('А', 'Б', 'З', 'К', 'У');

SELECT
  фамилия,
  имя,
  отчество,
  ид
FROM Н_ЛЮДИ
WHERE SUBSTR(ИМЯ, 0, 1) NOT LIKE 'А' AND SUBSTR(ИМЯ, 0, 1) NOT LIKE 'Б' AND SUBSTR(ИМЯ, 0, 1) NOT LIKE 'З'
      AND SUBSTR(ИМЯ, 0, 1) NOT LIKE 'К' AND SUBSTR(ИМЯ, 0, 1) NOT LIKE 'У'
      AND SUBSTR(ОТЧЕСТВО, 0, 1) NOT LIKE 'А' AND SUBSTR(ОТЧЕСТВО, 0, 1) NOT LIKE 'Б' AND
      SUBSTR(ОТЧЕСТВО, 0, 1) NOT LIKE 'З'
      AND SUBSTR(ОТЧЕСТВО, 0, 1) NOT LIKE 'К' AND SUBSTR(ОТЧЕСТВО, 0, 1) NOT LIKE 'У';

-- СЕДЬМОЙ ПУНКТ
SELECT DISTINCT count(*)
FROM н_люди
WHERE имя LIKE (SELECT ИМЯ
                FROM н_люди
                WHERE ид LIKE 105840);

-- ВОСЬМОЙ ПУНКТ
SELECT оценка * 2
FROM н_ведомости
WHERE (оценка NOT IN ((SELECT ОЦЕНКА
                       FROM Н_ВЕДОМОСТИ
                       WHERE
                         REGEXP_LIKE(оценка, '(не|)зач(|ет)$'))) AND члвк_ид LIKE (SELECT ид
                                                                                   FROM н_люди
                                                                                   WHERE фамилия LIKE 'Макаров'));

-- ДЕВЯТЫЙ ПУНКТ
SELECT sum(оценка)
FROM н_ведомости
WHERE (NOT REGEXP_LIKE(оценка, '(не|)зач(|ет)$')) AND члвк_ид IN (SELECT ид
                                                                  FROM н_люди
                                                                  WHERE имя IN ('Юрий', 'Анастасия', 'Денис') AND
                                                                        rownum < 8);

-- ДЕСЯТЫЙ ПУНКТ
--192809
SELECT
  н_учебные_года.*,
  н_квалификации.*
FROM н_учебные_года, н_квалификации;

-- ОДИННАДЦАТЫЙ ПУНКТ
WITH PEOPLE_MARKS AS (
    SELECT
      AVG(ОЦЕНКА) AS AVG_MARK,
      ФАМИЛИЯ,
      ИМЯ,
      ОТЧЕСТВО
    FROM Н_ЛЮДИ, Н_ВЕДОМОСТИ
    WHERE Н_ВЕДОМОСТИ.ЧЛВК_ИД = Н_ЛЮДИ.ИД
          AND REGEXP_LIKE(ОЦЕНКА, '[2-5]')
    GROUP BY ЧЛВК_ИД, ФАМИЛИЯ, ИМЯ, ОТЧЕСТВО)
SELECT *
FROM (SELECT
        AVG_MARK,
        ФАМИЛИЯ,
        ИМЯ,
        ОТЧЕСТВО
      FROM PEOPLE_MARKS
      WHERE ФАМИЛИЯ || AVG_MARK NOT IN
            (SELECT ФАМИЛИЯ || MAX(AVG_MARK)
             FROM PEOPLE_MARKS
             GROUP BY ФАМИЛИЯ
             HAVING COUNT(AVG_MARK) > 1))
WHERE ROWNUM <= 7;

-- ДВЕНАДЦАТЫЙ ПУНКТ
SELECT
  'Оценки 4 и 5 во всем университете' AS " ",
  (SELECT TO_CHAR(ROUND(AVG(ОЦЕНКА), 2))
   FROM Н_ВЕДОМОСТИ
   WHERE REGEXP_LIKE(ОЦЕНКА, '4|5'))  AS "Средняя оценка",
  (SELECT TO_CHAR(COUNT(ОЦЕНКА))
   FROM Н_ВЕДОМОСТИ
   WHERE REGEXP_LIKE(ОЦЕНКА, '4|5'))  AS "Количество оценок"
FROM DUAL
UNION ALL
SELECT
  'Оценки «зачет» в произвольном' || chr(10) ||
  'учебном году во всем университете' || chr(10)  AS " ",
  '-'                                             AS "Средняя оценка",
  (SELECT TO_CHAR(COUNT(ОЦЕНКА))
   FROM Н_ВЕДОМОСТИ
   WHERE ОЦЕНКА LIKE 'зачет'
         AND ДАТА BETWEEN TO_DATE('2011-09-01', 'YYYY-MM-DD')
         AND TO_DATE('2012-09-01', 'YYYY-MM-DD')) AS "Количество оценок"
FROM DUAL
UNION ALL
SELECT
  'Расстояние Левенштайна до вашей' || chr(10) ||
  'фамилии от фамилий 10 персон,' || chr(10) ||
  'имеющих оценки 3, 4 и 5'                                  AS " ",
  TO_CHAR(avg(utl_match.edit_distance(ФАМИЛИЯ, 'Гулямова'))) AS "Средняя оценка",
  '-'                                                        AS "Количество оценок"
FROM Н_ЛЮДИ
WHERE ИД IN
      (SELECT ЧЛВК_ИД
       FROM Н_ВЕДОМОСТИ
       WHERE REGEXP_LIKE(ОЦЕНКА, '3|4|5')
       GROUP BY ЧЛВК_ИД)
      AND ROWNUM <= 10;

--ТРИНАДЦАТЫЙ ПУНКТ
SELECT
  фамилия,
  имя,
  отчество
FROM н_люди
WHERE (ид IN (SELECT члвк_ид
              FROM н_ведомости
              WHERE оценка IN ('3', '4') AND (дата BETWEEN TO_DATE('2015.09.01', 'yyyy.mm.dd') AND
              TO_DATE(SYSDATE))))
ORDER BY ФАМИЛИЯ, имя, отчество;

-- ЧЕТЫРНАДЦАТЫЙ ПУНКТ
SELECT
  SUM(ОЦЕНКА),
  ФАМИЛИЯ,
  ИМЯ,
  ОТЧЕСТВО
FROM Н_ЛЮДИ, Н_ВЕДОМОСТИ
WHERE Н_ВЕДОМОСТИ.ЧЛВК_ИД = Н_ЛЮДИ.ИД
      AND REGEXP_LIKE(ОЦЕНКА, '[2-5]')
GROUP BY ЧЛВК_ИД, ФАМИЛИЯ, ИМЯ, ОТЧЕСТВО
HAVING SUM(ОЦЕНКА) <= 29
       AND ИМЯ IN
           (SELECT ИМЯ
            FROM Н_ЛЮДИ
            GROUP BY ИМЯ
            HAVING COUNT(*) > 1);

-- ДОП. ЗАДАНИЕ
SELECT
  фамилия,
  имя,
  ид
FROM н_люди
WHERE ((to_number(substr(to_char(ид), 1, 1))) +
       (to_number(substr(to_char(ид), 2, 1))) +
       (to_number(substr(to_char(ид), 3, 1))) +
       (to_number(substr(to_char(ид), 4, 1))) +
       (to_number(substr(to_char(ид), 5, 1))) +
       (to_number(substr(to_char(ид), 6, 1)))) = 18;
