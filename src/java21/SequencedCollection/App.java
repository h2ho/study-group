package java21.SequencedCollection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.SequencedCollection;

public class App {

    // interface SequencedCollection<E> extends Collection<E> {
    // // new method
    // SequencedCollection<E> reversed();

    // // methods promoted from Deque
    // void addFirst(E);

    // void addLast(E);

    // E getFirst();

    // E getLast();

    // E removeFirst();

    // E removeLast();
    // }

    // interface SequencedMap<K,V> extends Map<K,V> {
    // // new methods
    // SequencedMap<K,V> reversed();
    // SequencedSet<K> sequencedKeySet();
    // SequencedCollection<V> sequencedValues();
    // SequencedSet<Entry<K,V>> sequencedEntrySet();
    // V putFirst(K, V);
    // V putLast(K, V);
    // // methods promoted from NavigableMap
    // Entry<K, V> firstEntry();
    // Entry<K, V> lastEntry();
    // Entry<K, V> pollFirstEntry();
    // Entry<K, V> pollLastEntry();
    // }

    public static void main(String[] args) throws Exception {

        var list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        System.out.println(map.pollLastEntry());

    }

}
