package kotlin.collections;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Companion f53584a = new Companion(null);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static void a(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                StringBuilder sbT = b.t(i2, i3, "startIndex: ", ", endIndex: ", ", size: ");
                sbT.append(i4);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            if (i2 > i3) {
                throw new IllegalArgumentException(b.d(i2, i3, "startIndex: ", " > endIndex: "));
            }
        }

        public static void b(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException(b.d(i2, i3, "index: ", ", size: "));
            }
        }

        public static void c(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException(b.d(i2, i3, "index: ", ", size: "));
            }
        }

        public static void d(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                StringBuilder sbT = b.t(i2, i3, "fromIndex: ", ", toIndex: ", ", size: ");
                sbT.append(i4);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            if (i2 > i3) {
                throw new IllegalArgumentException(b.d(i2, i3, "fromIndex: ", " > toIndex: "));
            }
        }

        public static int e(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 <= 0) {
                return i4;
            }
            if (i3 > 2147483639) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return 2147483639;
        }
    }

    @Metadata
    public class IteratorImpl implements Iterator<E>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public int f53585a;

        public IteratorImpl() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f53585a < AbstractList.this.b();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i2 = this.f53585a;
            this.f53585a = i2 + 1;
            return AbstractList.this.get(i2);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E>, KMappedMarker {
        public ListIteratorImpl(int i2) {
            super();
            Companion companion = AbstractList.f53584a;
            int iB = AbstractList.this.b();
            companion.getClass();
            Companion.c(i2, iB);
            this.f53585a = i2;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.f53585a > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f53585a;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i2 = this.f53585a - 1;
            this.f53585a = i2;
            return AbstractList.this.get(i2);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f53585a - 1;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class SubList<E> extends AbstractList<E> implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        public final AbstractList f53588b;

        /* renamed from: c, reason: collision with root package name */
        public final int f53589c;

        /* renamed from: d, reason: collision with root package name */
        public final int f53590d;

        public SubList(AbstractList list, int i2, int i3) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f53588b = list;
            this.f53589c = i2;
            Companion companion = AbstractList.f53584a;
            int iB = list.b();
            companion.getClass();
            Companion.d(i2, i3, iB);
            this.f53590d = i3 - i2;
        }

        @Override // kotlin.collections.AbstractCollection
        public final int b() {
            return this.f53590d;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final Object get(int i2) {
            Companion companion = AbstractList.f53584a;
            int i3 = this.f53590d;
            companion.getClass();
            Companion.b(i2, i3);
            return this.f53588b.get(this.f53589c + i2);
        }
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection other = (Collection) obj;
        f53584a.getClass();
        Intrinsics.checkNotNullParameter(this, "c");
        Intrinsics.checkNotNullParameter(other, "other");
        if (size() == other.size()) {
            Iterator<E> it = other.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.b(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.List
    public abstract Object get(int i2);

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        f53584a.getClass();
        Intrinsics.checkNotNullParameter(this, "c");
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (Intrinsics.b(it.next(), obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new IteratorImpl();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i2, int i3) {
        return new SubList(this, i2, i3);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i2) {
        return new ListIteratorImpl(i2);
    }
}
