public class Examples extends ExampleRunner {

    public static void main(String[] args) throws Exception {
        runExamplesIn(Examples.class);
    }

    @Example
    void example1() {
        input("""
                """);

        run();

        assertOutputEqualTo("""
                """);

    }

    private void run(String... args) {
        try {
            Main.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
