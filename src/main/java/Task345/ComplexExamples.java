package Task345;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }


        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();


        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */


        Map<String, Long> newMap = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        for (Map.Entry<String, Long> entry : newMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "\n" + "Value:" + entry.getValue());
        }


        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Array sorted, two numbers that add up to target number were found");
        System.out.println();


        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */


        int[] array = {3, 4, 2, 7};

        System.out.println(Arrays.toString(twoNumbers(array, 10)));


        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Fuzzy ne fuzzy");
        System.out.println();


        /*
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }

    public static int[] twoNumbers(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] + array[right] == target) {
                return new int[] {array[left], array[right]};
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }

    public static boolean fuzzySearch(String substr, String str) {
        char[] c1 = substr.toCharArray();
        char[] c2 = str.toCharArray();
        int i = 0;

        for (char c : c2) {
            if (c1[i] == c) {
                i++;
            }

            if (c1.length == i) {
                return true;
            }
        }
        return false;
    }
}
