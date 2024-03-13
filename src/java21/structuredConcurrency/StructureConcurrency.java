package java21.structuredConcurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class StructureConcurrency {

    static void main(String[] args) {
        Temp a = new Temp();
        a.composeUserProfile();

    }

}

class Temp {
    static void composeUserProfile() {
        try (final var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            Supplier<Integer> highwaySubtask = scope.fork(Temp::getResult);
            Supplier<Integer> highwaySubtask2 = scope.fork(Temp::getResult);

            scope.join().throwIfFailed();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static Integer getResult() throws InterruptedException {
        Thread.sleep(1000);
        Integer a = Integer.parseInt("123");
        System.out.println(a);
        return a;
    }
}