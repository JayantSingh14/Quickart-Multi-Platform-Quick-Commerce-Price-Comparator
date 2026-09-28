package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Internal {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4024a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f4025b;

    /* renamed from: c, reason: collision with root package name */
    public static final ByteBuffer f4026c;

    public interface BooleanList extends ProtobufList<Boolean> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        BooleanList a(int i2);
    }

    public interface DoubleList extends ProtobufList<Double> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        DoubleList a(int i2);
    }

    public interface EnumLite {
        int f();
    }

    public interface EnumLiteMap<T extends EnumLite> {
    }

    public interface EnumVerifier {
        boolean a(int i2);
    }

    public interface FloatList extends ProtobufList<Float> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        FloatList a(int i2);
    }

    public interface IntList extends ProtobufList<Integer> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        IntList a(int i2);
    }

    public static class IntListAdapter<T> extends AbstractList<T> {

        public interface IntConverter<T> {
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {

        public interface Converter<F, T> {
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    public interface LongList extends ProtobufList<Long> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        LongList a(int i2);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4027a = 0;

        /* renamed from: androidx.datastore.preferences.protobuf.Internal$MapAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements Converter<Integer, EnumLite> {
        }

        public interface Converter<A, B> {
        }

        public class EntryAdapter implements Map.Entry<K, V> {
            @Override // java.util.Map.Entry
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Map.Entry) {
                    throw null;
                }
                return false;
            }

            @Override // java.util.Map.Entry
            public final Object getKey() {
                throw null;
            }

            @Override // java.util.Map.Entry
            public final Object getValue() {
                int i2 = MapAdapter.f4027a;
                throw null;
            }

            @Override // java.util.Map.Entry
            public final int hashCode() {
                throw null;
            }

            @Override // java.util.Map.Entry
            public final Object setValue(Object obj) {
                int i2 = MapAdapter.f4027a;
                throw null;
            }
        }

        public class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            @Override // java.util.Iterator
            public final boolean hasNext() {
                throw null;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw null;
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw null;
            }
        }

        public class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                throw null;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set entrySet() {
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            throw null;
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        void D();

        ProtobufList a(int i2);

        boolean r0();
    }

    static {
        Charset.forName("US-ASCII");
        f4024a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f4025b = bArr;
        f4026c = ByteBuffer.wrap(bArr);
        CodedInputStream.e(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
