public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        while(true) {
            longRunner();
            midRunner();
            shortRunner();
        }
    }

    public long longRunner() {
        long result = 0;
        for (int i = 0; i < 2_000_000; i++) {
            result++;
        }
        return result;
    }

    public long midRunner() {
        long result = 0;
        for (int i = 0; i < 2_000; i++) {
            result ++;
        }
        return result;
    }

    public long shortRunner() {
        long result = 0;
        for (int i = 0; i < 20; i++) {
            result ++;
        }
        return result;
    }

}
