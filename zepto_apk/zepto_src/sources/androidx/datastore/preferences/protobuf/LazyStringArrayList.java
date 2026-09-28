package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.Utf8;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f4061c = 0;

    /* renamed from: b, reason: collision with root package name */
    public final List f4062b;

    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        @Override // java.util.AbstractList, java.util.List
        public final void add(int i2, Object obj) {
            int i3 = LazyStringArrayList.f4061c;
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object remove(int i2) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            int i3 = LazyStringArrayList.f4061c;
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        @Override // java.util.AbstractList, java.util.List
        public final void add(int i2, Object obj) {
            int i3 = LazyStringArrayList.f4061c;
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int i2) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object remove(int i2) {
            throw null;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object set(int i2, Object obj) {
            int i3 = LazyStringArrayList.f4061c;
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            throw null;
        }
    }

    static {
        new LazyStringArrayList(0);
    }

    public LazyStringArrayList(ArrayList arrayList) {
        super(true);
        this.f4062b = arrayList;
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public final Object J1(int i2) {
        return this.f4062b.get(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public final List O() {
        return Collections.unmodifiableList(this.f4062b);
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public final void T0(ByteString byteString) {
        b();
        this.f4062b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public final Internal.ProtobufList a(int i2) {
        List list = this.f4062b;
        if (i2 < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(list);
        return new LazyStringArrayList(arrayList);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        b();
        this.f4062b.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f4062b.size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f4062b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        List list = this.f4062b;
        Object obj = list.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            byteString.getClass();
            String strV = byteString.size() == 0 ? "" : byteString.v(Internal.f4024a);
            if (byteString.o()) {
                list.set(i2, strV);
            }
            return strV;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, Internal.f4024a);
        Utf8.Processor processor = Utf8.f4190a;
        if (Utf8.f4190a.e(0, 0, bArr, bArr.length) == 0) {
            list.set(i2, str);
        }
        return str;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, androidx.datastore.preferences.protobuf.Internal.ProtobufList
    public final boolean r0() {
        return this.f3732a;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        b();
        Object objRemove = this.f4062b.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof ByteString)) {
            return new String((byte[]) objRemove, Internal.f4024a);
        }
        ByteString byteString = (ByteString) objRemove;
        byteString.getClass();
        return byteString.size() == 0 ? "" : byteString.v(Internal.f4024a);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b();
        Object obj2 = this.f4062b.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof ByteString)) {
            return new String((byte[]) obj2, Internal.f4024a);
        }
        ByteString byteString = (ByteString) obj2;
        byteString.getClass();
        return byteString.size() == 0 ? "" : byteString.v(Internal.f4024a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4062b.size();
    }

    public LazyStringArrayList(int i2) {
        super(false);
        this.f4062b = Collections.EMPTY_LIST;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        b();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).O();
        }
        boolean zAddAll = this.f4062b.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public LazyStringArrayList() {
        this(new ArrayList(10));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        this.f4062b.add((String) obj);
        ((AbstractList) this).modCount++;
        return true;
    }
}
