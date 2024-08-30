package ss12.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        String str = "codegym viet nam";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character character : str.toCharArray()) {
            if(character == ' '){
                continue;
            }
            if(!map.containsKey(character)){
                map.put(character,1);
            } else {
                map.put(character,map.get(character)+1);
            }
        }
        System.out.println(map);
    }
}
