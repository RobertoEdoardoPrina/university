package Services;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratoreTessere {
    private static final Random generatore = new Random();

    static public GeneratoreTessere getInstance(){
        return new GeneratoreTessere();
    }

    public String generaCodice(){
        return IntStream.generate(() -> {return generatore.nextInt(0, 10);}).limit(15).mapToObj(Integer::toString).collect(Collectors.joining());
    }
}
