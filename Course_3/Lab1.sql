-- ПЕРВЫЙ ПУНКТ
/*SELECT
  ИД,
  СЭС_ИД,
  ЧЛВК_ИД,
  TO_CHAR(ДАТА, 'DD.MM.YYYY HH24:MI:SS'),
  TO_CHAR(ВРЕМЯ, 'DD.MM.YYYY HH24:MI:SS'),
  АУДИТОРИЯ,
  TO_CHAR(ДАТА_К, 'DD.MM.YYYY HH24:MI:SS'),
  TO_CHAR(ВРЕМЯ_К, 'DD.MM.YYYY HH24:MI:SS'),
  АУДИТОРИЯ_К,
  УЧГОД,
  ГРУППА,
  СЕМЕСТР,
  КТО_СОЗДАЛ,
  КТО_ИЗМЕНИЛ,
  TO_CHAR(КОГДА_ИЗМЕНИЛ, 'DD.MM.YYYY HH24:MI:SS')
FROM Н_СЕССИЯ;
*/

--ВТОРОЙ ПУНКТ
/*
SELECT DISTINCT *
FROM Н_ДИСЦИПЛИНЫ;
*/

-- ТРЕТИЙ ПУНКТ
/*
SELECT (trunc(to_date('2016/09/1', 'yyyy/mm/dd')) - ДАТА_РОЖДЕНИЯ)
FROM Н_ЛЮДИ
WHERE ФАМИЛИЯ LIKE 'Зинчик';
*/

-- ЧЕТВЕРТЫЙ ПУНКТ
/*
SELECT фамилия
FROM Н_ЛЮДИ
WHERE EXTRACT(MONTH FROM ДАТА_РОЖДЕНИЯ) LIKE extract(
    MONTH FROM (SELECT дата_рождения
                FROM н_люди
                WHERE ид LIKE 105840));
*/

-- ПЯТЫЙ ПУНКТ
/*
SELECT
  фамилия,
  имя,
  отчество,
  ид
FROM н_люди
WHERE (substr(to_char(фамилия), 1, 2))  LIKE 'Зи' AND rownum <  75
ORDER BY фамилия;
*/

--ШЕСТОЙ ПУНКТ
/*SELECT
  фамилия,
  имя,
  отчество,
  ид
FROM н_люди
WHERE
  --(фамилия NOT LIKE 'З%') and (имя not LIKE 'А%') AND (отчество not like 'А%');
  (substr(фамилия, 1, 1)) NOT IN ('А', 'Б', 'З', 'К', 'У') AND substr(имя, 1, 1) NOT IN ('А', 'Б', 'З', 'К', 'У') AND
  substr(отчество, 1, 1) NOT IN ('А', 'Б', 'З', 'К', 'У');
  */

-- СЕДЬМОЙ ПУНКТ
/*SELECT DISTINCT count(*)
FROM н_люди
WHERE имя LIKE 'Александр';
*/

-- ВОСЬМОЙ ПУНКТ
/*SELECT оценка * 2
FROM н_ведомости
WHERE (NOT REGEXP_LIKE(оценка, '(не|)зач(|ет)$') AND члвк_ид LIKE (SELECT ид
                                                                   FROM н_люди
                                                                   WHERE фамилия LIKE 'Макаров'));
*/

-- ДЕВЯТЫЙ ПУНКТ
--SELECT count(*) from н_люди WHERE имя IN ('Юрий', 'Анастасия', 'Денис') AND rownum<8;
SELECT sum(оценка)
FROM н_ведомости
WHERE (NOT REGEXP_LIKE(оценка, '(не|)зач(|ет)$')) AND члвк_ид in (SELECT ид
                                                                    FROM н_люди
                                                                    WHERE имя IN ('Юрий', 'Анастасия', 'Денис') AND
                                                                          rownum < 8);
