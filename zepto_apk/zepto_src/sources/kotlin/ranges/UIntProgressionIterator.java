package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final int f53861a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f53862b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53863c;

    /* renamed from: d, reason: collision with root package name */
    public int f53864d;

    public UIntProgressionIterator(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this.f53861a = i3;
        boolean z = false;
        if (i4 <= 0 ? Integer.compare(i2 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i3) >= 0 : Integer.compare(i2 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ i3) <= 0) {
            z = true;
        }
        this.f53862b = z;
        UInt.Companion companion = UInt.f53556b;
        this.f53863c = i4;
        this.f53864d = z ? i2 : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53862b;
    }

    @Override // java.util.Iterator
    public final UInt next() {
        int i2 = this.f53864d;
        if (i2 != this.f53861a) {
            int i3 = this.f53863c + i2;
            UInt.Companion companion = UInt.f53556b;
            this.f53864d = i3;
        } else {
            if (!this.f53862b) {
                throw new NoSuchElementException();
            }
            this.f53862b = false;
        }
        return new UInt(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
