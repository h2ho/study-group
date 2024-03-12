package java21.vector;

import java.util.Arrays;

import jdk.incubator.vector.*;

public class App {

    static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4 };
        int[] b = { 5, 6, 7, 8 };
        int[] c = new int[4];

        for (int i = 0; i < c.length; i += IntVector.SPECIES_128.length()) {
            IntVector va = IntVector.fromArray(IntVector.SPECIES_128, a, i);
            IntVector vb = IntVector.fromArray(IntVector.SPECIES_128, b, i);
            IntVector vc = va.add(vb);
            vc.intoArray(c, i);
        }

        System.out.println(Arrays.toString(c));
    }

    public int[] addTwoVectorsWithMasks(int[] arr1, int[] arr2) {
        int[] finalResult = new int[arr1.length];
        int i = 0;
        for (; i < SPECIES.loopBound(arr1.length); i += SPECIES.length()) {
            var mask = SPECIES.indexInRange(i, arr1.length);
            var v1 = IntVector.fromArray(SPECIES, arr1, i, mask);
            var v2 = IntVector.fromArray(SPECIES, arr2, i, mask);
            var result = v1.add(v2, mask);
            result.intoArray(finalResult, i, mask);
        }

        // tail cleanup loop
        for (; i < arr1.length; i++) {
            finalResult[i] = arr1[i] + arr2[i];
        }
        return finalResult;
    }

    public double averageOfaVector(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i += SPECIES.length()) {
            var mask = SPECIES.indexInRange(i, arr.length);
            var V = IntVector.fromArray(SPECIES, arr, i, mask);
            sum += V.reduceLanes(VectorOperators.ADD, mask);
        }
        return sum / arr.length;
    }
}
