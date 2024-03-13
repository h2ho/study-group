package java21.ScopedValue;

class App {

    private static final ScopedValue<String> USER = ScopedValue.newInstance();

    static void main(String[] args) {

        // CREATE TWO CARRIERS WITH DIFFERENT VALUES IN THE SAME THREAD

        ScopedValue.Carrier carrierForBen = ScopedValue.where(USER, "ben");
        ScopedValue.Carrier carrierForBob = ScopedValue.where(USER, "bob");

        // USE THE SAME RUNNABLE FOR EACH CARRIER

        Runnable r = () -> {
            var currentUser = USER.get();
            System.out.println("Current: " + currentUser);
        };

        // RUN RUNNABLE WITH DIFFERENT CARRIERS

        carrierForBen.run(r);
        // => "Current: ben"

        carrierForBob.run(r);
        // => "Current: bob"

        carrierForBen.run(r);
        // => "Current: ben"
    }
}