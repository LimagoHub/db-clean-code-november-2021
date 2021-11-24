import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        Instant start = Instant.now();

        String sb = "";

        for (int i = 0; i < 2_000_000; i++) {
            sb+=("a");
        }

        String s = sb.toString();

        Instant ende = Instant.now();
        Duration duration = Duration.between(start, ende);
        System.out.println(duration.toMillis());
    }
}
