package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final long f53870a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f53871b;

    /* renamed from: c, reason: collision with root package name */
    public final long f53872c;

    /* renamed from: d, reason: collision with root package name */
    public long f53873d;

    public ULongProgressionIterator(long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this.f53870a = j3;
        boolean z = false;
        if (j4 <= 0 ? Long.compare(j2 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j3) >= 0 : Long.compare(j2 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ j3) <= 0) {
            z = true;
        }
        this.f53871b = z;
        ULong.Companion companion = ULong.f53561b;
        this.f53872c = j4;
        this.f53873d = z ? j2 : j3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53871b;
    }

    @Override // java.util.Iterator
    public final ULong next() {
        long j2 = this.f53873d;
        if (j2 != this.f53870a) {
            long j3 = this.f53872c + j2;
            ULong.Companion companion = ULong.f53561b;
            this.f53873d = j3;
        } else {
            if (!this.f53871b) {
                throw new NoSuchElementException();
            }
            this.f53871b = false;
        }
        return new ULong(j2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
