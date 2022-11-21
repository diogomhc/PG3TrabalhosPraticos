package trab2.grupo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AlgorithmUtils {

    public static <E> boolean isOrdered(Collection<E> seq, Comparator<E> compareValue ) {
        if(seq.isEmpty()) return false;
        Iterator<E> iter = seq.iterator();
        E e = iter.next(), tmp = iter.next();
        boolean ascending = false, descending = false;

        E[] array = (E[])seq.toArray();
        for(int i = 0; i < array.length - 1; i++) {
            if(compareValue.compare(array[i], array[i+1]) < 0) ascending = true;
            else if(compareValue.compare(array[i], array[i+1]) > 0) descending = true;
            if(ascending && descending) return false;
        }
        return true;
    }

    public static <E> List<E> getSubSequences(Collection<E> seq, int n, Comparator<E> cmp ) {
        if(n < 1) throw new IllegalArgumentException();
        if(seq.isEmpty()) return List.of();

        int segs = 1;

        E[] array = (E[]) seq.toArray();
        ArrayList<E> tmp = new ArrayList<>();

        for(int i = 0; i < array.length - 1; i++) {
            if(cmp.compare(array[i], array[i+1]) > 0) {
                if(segs == n) {
                    tmp.add(array[i]);
                    break;
                }
                tmp = new ArrayList<>();
                segs++;
                if(cmp.compare(array[array.length-2], array[array.length-1]) > 0 && i == array.length - 2) { tmp.add(array[array.length-1]); segs++; }
                continue;
            }

            tmp.add(array[i]);
            if(i == array.length - 2) tmp.add(array[i+1]);
        }

        if(segs < n) return List.of();
        return tmp;
    }

    public static <K,V,C extends Collection<V>> void addAll(BufferedReader in, Map<K,C> m, Function<String, V> getValue, Function<V, K> getKey, Supplier<C> supC)  throws IOException {
        String s;
        while((s = in.readLine()) != null) {
            V v = getValue.apply(s);
            K k = getKey.apply(v);
            if(m.get(k) == null) {
            }
        }
    }

    public static <K,V,C extends Collection<V>> void forEachIf(Map<K,C> m, Predicate<K> pred, Consumer<V> action) {
    }
}
