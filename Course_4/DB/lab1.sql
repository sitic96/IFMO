{\rtf1\ansi\ansicpg1251\cocoartf1504\cocoasubrtf830
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;\f1\fnil\fcharset0 Menlo-Italic;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\csgenericrgb\c0\c0\c0;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh18000\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf2 DECLARE\
  input_line VARCHAR(20);\
BEGIN\
  input_line := :k;\
  dbms_output.put_line('\uc0\u1055 \u1086 \u1089 \u1083 \u1077 \u1076 \u1086 \u1074 \u1072 \u1090 \u1077 \u1083 \u1100 \u1085 \u1086 \u1089 \u1090 \u1100  \u1089 \u1080 \u1084 \u1074 \u1086 \u1083 \u1086 \u1074 : ' || input_line);\
  dbms_output.put_line('\uc0\u1044 \u1083 \u1080 \u1085 \u1072 : ' || 
\f1\i length
\f0\i0 (input_line));\
  dbms_output.put_line('No. \uc0\u1050 \u1083 \u1102 \u1095 \u1077 \u1074 \u1086 \u1077  \u1089 \u1083 \u1086 \u1074 \u1086 ');\
  dbms_output.put_line('--- -------------------------');\
\
  FOR ROW IN\
  (SELECT\
     ROWNUM,\
     keyword\
   FROM v$reserved_words\
   WHERE 
\f1\i LENGTH
\f0\i0 (keyword) = 6 AND 
\f1\i upper
\f0\i0 (keyword) LIKE 
\f1\i upper
\f0\i0 (input_line || '%'))\
  LOOP\
    dbms_output.put_line(
\f1\i RPAD
\f0\i0 (row.rownum, 3) || ' ' || 
\f1\i RPAD
\f0\i0 (row.keyword, 25));\
  END LOOP;\
END;\
}