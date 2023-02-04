// 1
// В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task_1 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moscow");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder WHERE = new StringBuilder();
        for (Map.Entry<String, String> pair: params.entrySet()) {
            if (pair.getValue() != null) {
                WHERE.append(pair.getKey() + " = " + "'" + pair.getValue() + "'" + " and ");
            }
        }
        WHERE.delete(WHERE.length()-4, WHERE.length());
        return WHERE.toString();
    }
}

