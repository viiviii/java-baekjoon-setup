import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;

public abstract class ExampleRunner {
    private static final InputStream standardIn = System.in;
    private static final PrintStream standardOut = System.out;
    private static OutputStream captor;

    protected static void runExamplesIn(Class<? extends ExampleRunner> clazz) throws Exception {
        final var methods = clazz.getDeclaredMethods();
        final var instance = clazz.getDeclaredConstructor().newInstance();

        int success = 0;
        int fail = 0;

        for (var method : methods) {
            if (!method.isAnnotationPresent(Example.class)) {
                continue;
            }

            setOutputStream();
            try {
                method.invoke(instance);
                success++;
            } catch (InvocationTargetException e) {
                fail++;
                e.getTargetException().printStackTrace();
            }
            cleanUp();
        }

        System.out.println();
        System.out.printf("✅ 테스트 실행 결과 = success: %d, fail: %d%n", success, fail);
    }

    protected static void input(String given) {
        setInputStream(given);
    }

    protected static String output() {
        return captor.toString();
    }

    protected void assertOutputEqualTo(String expected) {
        var actual = output();
        if (!removeSpacesBeforeNewline(actual).equals(expected)) {
            throw new Failures(actual, expected);
        }
    }

    private static void setInputStream(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private static void setOutputStream() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private static void cleanUp() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    private String removeSpacesBeforeNewline(String str) {
        return str.replace(" \n", "\n");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Example {
    }

    static class Failures extends AssertionError {
        private final String actual;
        private final String expected;

        public Failures(String actual, String expected) {
            this.actual = actual;
            this.expected = expected;
        }
        
        @Override
        public void printStackTrace() {
            System.err.println("java.lang.AssertionError: ");
            System.err.println("Expecting actual:");
            System.err.println(expected);
            System.err.println("but was:");
            System.err.println(actual);
            super.printStackTrace();
            System.err.print(System.lineSeparator().repeat(2));
        }
    }
}