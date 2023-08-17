import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * Used the video below same video - just 2 different links
        * https://www.youtube.com/watch?v=t1-YZ6bF-g0
        * https://youtu.be/t1-YZ6bF-g0
        * */
        ArrayList<String> arrayList =new ArrayList<>();

        arrayList.add("string 1");
        arrayList.add("string 2");
        arrayList.add("string 3");

        for (String ar:arrayList){
            System.out.println(ar.toUpperCase());
        }

        //Stream#1
        IntStream
                .range(1, 13)//max
                .forEach(System.out::print); //can add ln for each to have their own line/ this is method reference
        System.out.println();

        //Stream#2
        IntStream
                .range(1, 10)
                .skip(3)//skips number before in range then continues after digit added
                .forEach(System.out::println); //can add ln for each to have their own line
        System.out.println();

        //Stream#3
        System.out.println(
        IntStream
                .range(1, 10)
                .sum());

        System.out.println();

        //Stream#4
        Stream.of("Ava","Bella","Chelsy")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        //Stream#5
        String[] names = {"Al","Ava","Aba","Amanda, Bobby, Charlie", "Sam","Samuel", "Sally"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        //Stream#6
        Arrays.stream(new int[] {1,2,3,5,6,7,8,10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        //Stream#7
        List<String> Peeps = Arrays.asList("Al", "Ankit", "Alfred", "Amanda", "Kacy", "Jacob");
        Peeps
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();

        //Stream#8
        Stream<String> bands = Files.lines(Paths.get("../bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 1)
                .forEach(System.out::println);
        bands.close();
        System.out.println();

        /*    public static void main(String[] args) throws IOException {
        //List instead of Streams ??
        Stream<String> bands2 = Files.lines(Paths.get("../bands.txt"));
        bands2
                .filter(x -> x.contains("n"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
        bands2.close();
        System.out.println();
    }*/

        //Stream#9 >> HAD TO PUT THIS IS ANOTHER CLASS CAUSE STREAM HAS ALREADY BEEN OPERATED UPON OR CLOSED
        // PROBABLY ANOTHER JAVA PROJECT AS WELL
/*        Stream<String> bands2 = Files.lines(Paths.get("bands.txt"));
        bands2
                .filter(x -> x.contains("n"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
        bands2.close();
        System.out.println();*/


        //Stream#10 PROBABLY ANOTHER JAVA PROJECT AS WELL
/*        Stream<String> rows1 = Files.lines(Paths.get("../data.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();*/

/*        //Stream#11 PROBABLY ANOTHER JAVA PROJECT
        Stream<String> rows2 = Files.lines(Paths.get("../data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();*/

        //Stream#12 PROBABLY ANOTHER JAVA PROJECT
/*        Stream<String> rows3 = Files.lines(Paths.get("../data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key: map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }*/

        //Stream#13
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, Double::sum);//old way replaced by method reference
        System.out.println("Total = " + total);

        System.out.println();

        //Stream#14
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);

        // Creating a list of Strings
        List<String> list = Arrays.asList("G", "E", "E", "K",
                "g", "e", "e", "k");

        // using Stream.max() method with Comparator
        // Here, the character with maximum ASCII value
        // is stored in variable MAX
        String MAX = list.stream().max(Comparator.
                comparing(String::valueOf)).get();

        // Displaying the maximum element in
        // the stream according to provided Comparator
        System.out.println("Maximum element in the "
                + "stream is : " + MAX);


        // Creating a list of Strings
        List<String> list2 = Arrays.asList("Ge", "Ea", "Ed", "Kc",
                "gh", "ez", "ex", "kR");


        String MAX2 = list2.stream().max(Comparator.
                comparing(String::valueOf)).get();

        // Displaying the maximum element in
        // the stream according to provided Comparator
        System.out.println("Maximum element in the "
                + "stream is : " + MAX2);



    }
}
