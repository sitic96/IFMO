import DBWorker.DBUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Collection allPersons = Factory.getInstance().getCountryDAO().getAllCountries();
//        Iterator iterator = allPersons.iterator();
//        System.out.println("========Все страны=========");
//        while (iterator.hasNext()) {
//            Country c = (Country) iterator.next();
//            System.out.println("Страна : " + c.getCountry());


        int id = 9;
//        int id_c = 10;
//        HashSet<String> tables = new HashSet<>();
//        HashSet<String> actions = new HashSet<>();
//        tables.add("persons");
//        tables.add("countries");
//        actions.add("add");
//        actions.add("remove");
//        actions.add("update");
//        actions.add("show");
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Выберите таблицу:");
//            System.out.println("Доступные таблицы: Persons, DAO");
//            String table = scanner.nextLine();
//            if (tables.contains(table)) {
//                System.out.println("Выберите действие:");
//                System.out.println("Доступные действия: Add, Remove, Update, Show");
//                String action = scanner.nextLine();
//                if (actions.contains(action)) {
//                    switch (action) {
//                        case "add": {
//                            if (table.equals("persons")) {
//                                Person person = new Person();
//                                System.out.println("Введите категорию (1, 2, 3, 4):");
//                                int temp = scanner.nextInt();
//                                person.setCategory(temp);
//                                System.out.println("Введите страну (1 - 5):");
//                                temp = scanner.nextInt();
//                                person.setCountry(temp);
//                                System.out.println("Введите имя:");
//                                String line = scanner.next();
//                                person.setName(line);
//                                person.setId(++id);
//                                Factory.getInstance().getPersonDAO().addPerson(person);
//                            } else if (table.equals("countries")) {
//                                Country country = new Country();
//                                System.out.println("Введите название:");
//                                country.setCountry(scanner.nextLine());
//                                country.setId(id_c++);
//                                Factory.getInstance().getCountryDAO().addCountry(country);
//                            }
//                            break;
//                        }
//                        case "show": {
//                            if (table.equals("persons")) {
//                                Collection allPersons = Factory.getInstance().getPersonDAO().getAllPersons();
//                                Iterator iterator = allPersons.iterator();
//                                System.out.println("========Все спортсмены=========");
//                                while (iterator.hasNext()) {
//                                    Person p = (Person) iterator.next();
//                                    System.out.println("Спортсмен : " + p.getName());
//                                }
//                            } else if (table.equals("countries")) {
//                                Collection allPersons = Factory.getInstance().getCountryDAO().getAllCountries();
//                                Iterator iterator = allPersons.iterator();
//                                System.out.println("========Все страны=========");
//                                while (iterator.hasNext()) {
//                                    Country c = (Country) iterator.next();
//                                    System.out.println("Страна : " + c.getCountry());
//                                }
//                            }
//                            break;
//                        }
//                        case "remove": {
//                            if (table.equals("persons")) {
//                                Person person = new Person();
//                                System.out.println("Введите категорию (1, 2, 3, 4):");
//                                int temp = scanner.nextInt();
//                                person.setCategory(temp);
//                                System.out.println("Введите страну (1 - 5):");
//                                temp = scanner.nextInt();
//                                person.setCountry(temp);
//                                System.out.println("Введите имя:");
//                                person.setName(scanner.nextLine());
//                                Factory.getInstance().getPersonDAO().deletePerson(person);
//                            } else if (table.equals("countries")) {
//                                Country country = new Country();
//                                System.out.println("Введите название:");
//                                country.setCountry(scanner.nextLine());
//                                country.setId(id_c++);
//                                Factory.getInstance().getCountryDAO().deleteCountry(country);
//                            }
//                            break;
//                        }
//                        case "update": {
//                            if (table.equals("countries")) {
//                                System.out.println("Введите id страны (1 - 10");
//                                Integer c_id = scanner.nextInt();
//                                System.out.println("Введите новое название страны:");
//                                String new_country = scanner.nextLine();
//                                Country c = new Country();
//                                c.setId(c_id);
//                                c.setCountry(new_country);
//                                Factory.getInstance().getCountryDAO().updateCountry(c_id, c);
//                            }
//                            else if(table.equals("persons")){
//                                Person person = new Person();
//                                System.out.println("Введите новую категорию (1, 2, 3, 4):");
//                                int temp = scanner.nextInt();
//                                person.setCategory(temp);
//                                System.out.println("Введите новую страну (1 - 5):");
//                                temp = scanner.nextInt();
//                                person.setCountry(temp);
//                                System.out.println("Введите новое имя:");
//                                person.setName(scanner.nextLine());
//
//                                System.out.println("Введите id:");
//                                int p_id = scanner.nextInt();
//                                person.setId(p_id);
//                                Factory.getInstance().getPersonDAO().updatePerson(p_id, person);
//                            }
//                        }
//                    }
//                }
//            }
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========Available Tables:=========");
        DBUtils.getTABLES().forEach(System.out::println);
        System.out.println("Table name:");
        String tableName = scanner.nextLine();
        HashSet<String> params = DBUtils.getParameteres(tableName);
        Map<String, Object> elements = new HashMap<>();
        for (String param : params) {
            System.out.println(param);
            elements.put(param, scanner.next());
        }
        DBUtils.addInTable("Person", elements);
    }
}































