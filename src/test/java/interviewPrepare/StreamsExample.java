package interviewPrepare;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        List<Integer> eventNumber = numbers.stream().filter(n->n%2 ==0).collect(Collectors.toList());

        eventNumber.forEach(i->{
            System.out.println("i:"+i);
        });
    }
}
