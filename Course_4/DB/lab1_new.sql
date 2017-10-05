set serveroutput on
accept k prompt 'length: '
accept l prompt 'line: '
DECLARE
  k NUMBER;
  l VARCHAR(20);
  input_line  VARCHAR(20);
  word_length NUMBER;
BEGIN
  input_line := &l;
  word_length:= &k;
  dbms_output.put_line('Последовательность символов: ' || input_line);
  dbms_output.put_line('Длина: ' || length(input_line));
  dbms_output.put_line('No. Ключевое слово');
  dbms_output.put_line('--- -------------------------');

  FOR ROW IN
  (SELECT
     ROWNUM,
     keyword
   FROM v$reserved_words
   WHERE LENGTH(keyword) = word_length AND upper(keyword) LIKE upper(input_line || '%') AND reserved = 'Y')
  LOOP
    dbms_output.put_line(RPAD(row.rownum, 3) || ' ' || RPAD(row.keyword, 25));
  END LOOP;
END;
/

