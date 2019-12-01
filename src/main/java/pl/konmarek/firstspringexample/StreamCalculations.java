package pl.konmarek.firstspringexample;

import pl.konmarek.firstspringexample.domain.Owner;
import pl.konmarek.firstspringexample.domain.Secret;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;



public class StreamCalculations {
    public static void main(String[] args) {
       Stream<BigDecimal> stream1 = Stream.of(BigDecimal.valueOf(1_000_000), BigDecimal.ONE, BigDecimal.valueOf(5));

       stream1.min((x, y) -> x.compareTo(y))
                .ifPresent(bigDecimal -> System.out.println("min: " + bigDecimal));

        List<Owner> owners = Arrays.asList(new Owner("Felek", null), new Owner("Ardian", null));
//        Collections.sort(owners);
        Stream.of(new Owner("Felek", null), new Owner("Ardian", null))
//               .max((o1, o2) -> o1.getNick().compareTo(o2.getNick()))
       .max(Comparator.comparing(Owner::getNick));


        Stream.of(new Secret(5), new Secret(1));
//                .min(Comparator.comparing(secret -> secret.getNumber()))
//                .min(Comparator.comparing(Secret::getNumber));

        Stream.of(BigDecimal.valueOf(1_000_000), BigDecimal.ONE, BigDecimal.valueOf(5))
                .reduce(BigDecimal.ZERO, (acumulator, bigDecimal) -> acumulator.add(bigDecimal));
        long number = Stream.of(BigDecimal.valueOf(1_000_000), BigDecimal.ONE, BigDecimal.valueOf(5))
                .count();
        //TODO: use full force of reduce
    }
// randomowy komentarz, sprawdzam gita
    static class Acumulator{
        int numberOfElements;
        int sum;
    }
}
