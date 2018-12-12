package com.company;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main extends Thread {
    static Socket s;
    static ServerSocket server;

    public static void main(String args[]) {
        try {

            server = new ServerSocket(3129, 0,
                    InetAddress.getByName("localhost"));

            System.out.println("server is started");

            // слушаем порт
            while (true) {
                s = server.accept();
                // ждём нового подключения, после чего запускаем обработку клиента
                new Thread(new Main());
            }
        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }

    public Main() {
        this.run();
    }


    public void run() {
        try {
            // из сокета клиента берём поток входящих данных
            InputStream is = s.getInputStream();

            // и оттуда же - поток данных от сервера к клиенту
            OutputStream os = s.getOutputStream();

            // буффер данных в 64 килобайта
            byte buf[] = new byte[64 * 1024];

            // читаем 64кб от клиента, результат - кол-во реально принятых данных
            int r = is.read(buf);

            // создаём строку, содержащую полученную от клиента информацию
            String data = new String(buf, 0, r);

            System.out.println(data);

            float[] someNumbers = new float[3];
            Pattern pattern = Pattern.compile("-?\\d+[.]\\d+");
            Matcher matcher = pattern.matcher(data);

            for (int i = 0; i < 2; i++) {
                if (!matcher.find()) {
                    throw new IllegalArgumentException();
                } else {
                    someNumbers[i] = new Float(matcher.group());
                }
            }
            pattern = Pattern.compile("-?\\d+[.]\\d+");
            matcher = pattern.matcher(data);

            for (int i = 0; i < 3; i++) {
                if (!matcher.find()) {
                    throw new IllegalArgumentException();
                } else {
                    someNumbers[i] = new Float(matcher.group());
                    System.out.println(someNumbers[i]);
                }
            }

            System.out.println(isHere.inFigure(someNumbers[0], someNumbers[1], someNumbers[2]));

            if(isHere.inFigure(someNumbers[0], someNumbers[1], someNumbers[2])) {
                os.write("1".getBytes());
            }
            else os.write("-1".getBytes());

            // выводим данные:
           // os.write(data.getBytes());

            // завершаем соединение
            s.close();
        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }
}
