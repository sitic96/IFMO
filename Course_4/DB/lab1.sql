DECLARE
  input_line VARCHAR(20);
BEGIN
  input_line := :k;
  dbms_output.put_line('Последовательность символов: ' || input_line);
  dbms_output.put_line('Длина: ' || length(input_line));
  dbms_output.put_line('No. Ключевое слово');
  dbms_output.put_line('--- -------------------------');

  FOR ROW IN
  (SELECT
     ROWNUM,
     keyword
   FROM v$reserved_words
   WHERE LENGTH(keyword) = 6 AND upper(keyword) LIKE upper(input_line || '%'))
  LOOP
    dbms_output.put_line(RPAD(row.rownum, 3) || ' ' || RPAD(row.keyword, 25));
  END LOOP;
END;