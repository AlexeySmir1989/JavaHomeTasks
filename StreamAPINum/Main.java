package JavaCoreTasks.StreamAPINum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> newList = new ArrayList<>();
         for (int i = 0; i < intList.size(); i++){
            int j = intList.get(i);
            if (j > 0){
                if (j % 2 ==0){
                    newList.add(j);
                }
            }
        }
        newList.sort(Comparator.naturalOrder());
        System.out.println(newList);
    }
}
