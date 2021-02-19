package OCP.Collections.List;

import java.util.Arrays;
import java.util.List;

public class ArrayListLearning {
    public static void main(String[] args) {
        String arr[] = {"gerbil","mouse"};
        List<String> list = Arrays.asList(arr);

        list.set(1, "test");

        System.out.println(Arrays.toString(list.toArray()));
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        arr[0] = "new";

        System.out.println(Arrays.toString(list.toArray()));
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        // Since the list is created by callinng "aslist", it becomes non-resizable as it backed by the underlying array.
        list.remove(1);
        list.add("qweerty");

        System.out.println(Arrays.toString(list.toArray()));
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();


    }
}
