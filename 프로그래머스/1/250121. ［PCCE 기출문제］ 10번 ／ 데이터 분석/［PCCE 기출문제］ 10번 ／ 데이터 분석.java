
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        List<List<Integer>> extract = extract(data, ext,val_ext);
        answer = Sort(extract ,sort_by);

        return answer;
    }

    public static List<List<Integer>> extract(int[][] data, String ext, int val_ext){
        List<List<Integer>>  extract = new ArrayList<>();
        List<List<Integer>> data2 = Arrays.stream(data).map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());

        int intExt = index(ext);

        for (int i = 0; i < data2.size(); i++) {
            extract.add(new ArrayList<>());
            if(data[i][intExt] < val_ext){
                extract.get(i).add(data2.get(i).get(0));
                extract.get(i).add(data2.get(i).get(1));
                extract.get(i).add(data2.get(i).get(2));
                extract.get(i).add(data2.get(i).get(3));
            }
        }
        extract.removeIf(List::isEmpty);
        return extract;
    }
    public static int index(String standard){
        int index = 0;

        if(Objects.equals(standard, "date")){
            index = 1;
        } else if (Objects.equals(standard, "maximum")) {
            index = 2;
        }else if (Objects.equals(standard, "remain")){
            index = 3;
        }
        return index;
    }
    public static int[][] Sort(List<List<Integer>> extract, String sort_by){
        int sortindex = index(sort_by);

        int[][] sort = extract.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

        Arrays.sort(sort, Comparator.comparingInt(a -> a[sortindex]));

        return sort;
    }
}
