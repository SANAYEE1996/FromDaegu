package LV2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CandicateKey {

    public static void isRight(ArrayList<Integer> list, String[][] relation){
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < relation.length; i++){
            sb.setLength(0);
            for (int j : list){
                sb.append(relation[i][j]);
            }
            set.add(sb.toString());
        }

        if(set.size() == relation.length){
            System.out.println(list + " 로는 후보키가 맞다!");
        }
        else{
            System.out.println(list + " 로는 후보키가 성립되지 않는다");
        }
    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r, String[][] relation) {
        if (r == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    list.add(arr[i]);
                }
            }
            System.out.println(list);
            isRight(list,relation);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1,relation);
            visited[i] = false;
        }
    }

    public int solution(String[][] relation) {
        int answer = 0;


        int n = relation[0].length;
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = i;
        }
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(array, visited, 0, n, i,relation);
        }



        return answer;
    }

    public static void main(String[] args) {
        CandicateKey s = new CandicateKey();

        String[][] relation = {{"100","ryan","music","2"},
                                {"200","apeach","math","2"},
                                {"300","tube","computer","3"},
                                {"400","con","computer","4"},
                                {"500","muzi","music","3"},
                                {"600","apeach","music","2"}};

        System.out.println("the answer is : " +s.solution(relation));
    }
}
