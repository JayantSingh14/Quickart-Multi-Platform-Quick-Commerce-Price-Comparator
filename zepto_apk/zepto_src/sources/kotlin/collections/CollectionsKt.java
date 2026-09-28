package kotlin.collections;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation$special$$inlined$binarySearchBy$default$1;
import okio.ByteString;

@Metadata
/* loaded from: classes.dex */
public final class CollectionsKt extends CollectionsKt___CollectionsKt {
    private CollectionsKt() {
    }

    public static IntRange A(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1, 1);
    }

    public static int B(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static Object C(int i2, List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    public static /* synthetic */ void D(Iterable iterable, StringBuilder sb, String str, Function1 function1, int i2) {
        if ((i2 & 2) != 0) {
            str = ", ";
        }
        String str2 = str;
        String str3 = (i2 & 4) != 0 ? "" : "Errors: ";
        if ((i2 & 64) != 0) {
            function1 = null;
        }
        CollectionsKt___CollectionsKt.f(iterable, sb, str2, str3, "", function1);
    }

    public static String E(Iterable iterable, String str, String str2, String str3, Function1 function1, int i2) {
        if ((i2 & 1) != 0) {
            str = ", ";
        }
        String separator = str;
        String prefix = (i2 & 2) != 0 ? "" : str2;
        String postfix = (i2 & 4) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder sb = new StringBuilder();
        CollectionsKt___CollectionsKt.f(iterable, sb, separator, prefix, postfix, function1);
        return sb.toString();
    }

    public static Object F(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(B(list));
    }

    public static Object G(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return e.k(1, list);
    }

    public static List H(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static List I(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt.c(elements) : EmptyList.f53609a;
    }

    public static ArrayList J(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    public static ArrayList K(Object obj, Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static ArrayList L(Collection collection, Iterable elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            i(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList M(CharRange charRange, CharRange elements) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (charRange instanceof Collection) {
            return L((Collection) charRange, elements);
        }
        ArrayList arrayList = new ArrayList();
        i(arrayList, charRange);
        i(arrayList, elements);
        return arrayList;
    }

    public static void N(ArrayList arrayList, Function1 predicate) {
        int iB;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (arrayList == null) {
            Intrinsics.d(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            if (!(arrayList instanceof KMappedMarker) || (arrayList instanceof KMutableIterable)) {
                CollectionsKt__MutableCollectionsKt.c(arrayList, predicate, true);
                return;
            } else {
                TypeIntrinsics.d(arrayList, "kotlin.collections.MutableIterable");
                throw null;
            }
        }
        int iB2 = B(arrayList);
        int i2 = 0;
        if (iB2 >= 0) {
            int i3 = 0;
            while (true) {
                Object obj = arrayList.get(i2);
                if (!((Boolean) predicate.invoke(obj)).booleanValue()) {
                    if (i3 != i2) {
                        arrayList.set(i3, obj);
                    }
                    i3++;
                }
                if (i2 == iB2) {
                    break;
                } else {
                    i2++;
                }
            }
            i2 = i3;
        }
        if (i2 >= arrayList.size() || i2 > (iB = B(arrayList))) {
            return;
        }
        while (true) {
            arrayList.remove(iB);
            if (iB == i2) {
                return;
            } else {
                iB--;
            }
        }
    }

    public static void O(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (arrayList.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        arrayList.remove(0);
    }

    public static Object P(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(B(list));
    }

    public static void Q(Iterable iterable, Function1 predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        CollectionsKt__MutableCollectionsKt.c((Collection) iterable, predicate, false);
    }

    public static List R(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if ((list instanceof Collection) && list.size() <= 1) {
            return e0(list);
        }
        List listH = CollectionsKt___CollectionsKt.h(list);
        Intrinsics.checkNotNullParameter(listH, "<this>");
        Collections.reverse(listH);
        return listH;
    }

    public static List S(ArrayList arrayList, SecureRandom random) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List listH = CollectionsKt___CollectionsKt.h(arrayList);
        Collections.shuffle(listH, random);
        return listH;
    }

    public static Object T(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object U(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static void V(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void W(List list, Comparator comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static List X(ListBuilder listBuilder) {
        Intrinsics.checkNotNullParameter(listBuilder, "<this>");
        if (listBuilder == null) {
            List listH = CollectionsKt___CollectionsKt.h(listBuilder);
            V(listH);
            return listH;
        }
        if (listBuilder.size() <= 1) {
            return e0(listBuilder);
        }
        Object[] array = listBuilder.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        Intrinsics.checkNotNullParameter(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return ArraysKt.c(array);
    }

    public static List Y(Comparator comparator, Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listH = CollectionsKt___CollectionsKt.h(iterable);
            W(listH, comparator);
            return listH;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return e0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Intrinsics.checkNotNullParameter(array, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return ArraysKt.c(array);
    }

    public static List Z(Iterable iterable, int i2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "Requested element count ", " is less than zero.").toString());
        }
        if (i2 == 0) {
            return EmptyList.f53609a;
        }
        if (iterable instanceof Collection) {
            if (i2 >= ((Collection) iterable).size()) {
                return e0(iterable);
            }
            if (i2 == 1) {
                return H(y(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i2);
        Iterator it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return CollectionsKt__CollectionsKt.a(arrayList);
    }

    public static void a0(int i2, Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i2 < array.length) {
            array[i2] = null;
        }
    }

    public static void b0() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static float[] c0(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        float[] fArr = new float[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            fArr[i2] = ((Number) it.next()).floatValue();
            i2++;
        }
        return fArr;
    }

    public static HashSet d0(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        HashSet hashSet = new HashSet(MapsKt.f(r(arrayList, 12)));
        CollectionsKt___CollectionsKt.g(arrayList, hashSet);
        return hashSet;
    }

    public static List e0(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.a(CollectionsKt___CollectionsKt.h(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.f53609a;
        }
        if (size != 1) {
            return f0(collection);
        }
        return H(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList f0(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static LinkedHashSet g0(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        CollectionsKt___CollectionsKt.g(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static Set h0(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            CollectionsKt___CollectionsKt.g(iterable, linkedHashSet);
            Intrinsics.checkNotNullParameter(linkedHashSet, "<this>");
            int size = linkedHashSet.size();
            return size != 0 ? size != 1 ? linkedHashSet : SetsKt.e(linkedHashSet.iterator().next()) : EmptySet.f53611a;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return EmptySet.f53611a;
        }
        if (size2 == 1) {
            return SetsKt.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(MapsKt.f(collection.size()));
        CollectionsKt___CollectionsKt.g(iterable, linkedHashSet2);
        return linkedHashSet2;
    }

    public static void i(Collection collection, Iterable elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void j(Collection collection, Object[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        collection.addAll(ArraysKt.c(elements));
    }

    public static ArrayList k(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    public static List l(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new ReversedListReadOnly(list);
    }

    public static List m(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return new ReversedList(arrayList);
    }

    public static CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 n(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(iterable);
    }

    public static double o(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Iterator it = arrayList.iterator();
        double dFloatValue = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            dFloatValue += ((Number) it.next()).floatValue();
            i2++;
            if (i2 < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return dFloatValue / i2;
    }

    public static int p(ArrayList arrayList, int i2, StringSetParserOperation$special$$inlined$binarySearchBy$default$1 comparison) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        CollectionsKt__CollectionsKt.b(arrayList.size(), i2);
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int iIntValue = ((Number) comparison.invoke(arrayList.get(i5))).intValue();
            if (iIntValue < 0) {
                i4 = i5 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return -(i4 + 1);
    }

    public static int q(ArrayList arrayList, ByteString byteString) {
        int size = arrayList.size();
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        CollectionsKt__CollectionsKt.b(arrayList.size(), size);
        int i2 = size - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int iA = ComparisonsKt.a((Comparable) arrayList.get(i4), byteString);
            if (iA < 0) {
                i3 = i4 + 1;
            } else {
                if (iA <= 0) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static int r(Iterable iterable, int i2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    public static boolean s(Iterable iterable, Object obj) {
        int iIndexOf;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    b0();
                    throw null;
                }
                if (Intrinsics.b(obj, next)) {
                    iIndexOf = i2;
                    break;
                }
                i2++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static Collection t(Set set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return set != null ? set : e0(set);
    }

    public static ListBuilder u() {
        return new ListBuilder(0, 1, null);
    }

    public static List v(Iterable iterable) {
        ArrayList arrayList;
        Object objF;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - 1;
            if (size <= 0) {
                return EmptyList.f53609a;
            }
            if (size == 1) {
                Intrinsics.checkNotNullParameter(iterable, "<this>");
                if (iterable instanceof List) {
                    objF = F((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                    Object next = it.next();
                    while (it.hasNext()) {
                        next = it.next();
                    }
                    objF = next;
                }
                return H(objF);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    for (int i2 = 1; i2 < size2; i2++) {
                        arrayList.add(list.get(i2));
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(1);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i3 = 0;
        for (Object obj : iterable) {
            if (i3 >= 1) {
                arrayList.add(obj);
            } else {
                i3++;
            }
        }
        return CollectionsKt__CollectionsKt.a(arrayList);
    }

    public static List w(int i2, List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "Requested element count ", " is less than zero.").toString());
        }
        List list2 = list;
        int size = list.size() - i2;
        if (size < 0) {
            size = 0;
        }
        return Z(list2, size);
    }

    public static ArrayList x(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList destination = new ArrayList();
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static Object y(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return z((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object z(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }
}
