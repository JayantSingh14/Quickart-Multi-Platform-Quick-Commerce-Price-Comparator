package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata
/* loaded from: classes3.dex */
public final class LongProgressionIterator extends LongIterator {

    /* renamed from: a, reason: collision with root package name */
    public final long f53851a;

    /* renamed from: b, reason: collision with root package name */
    public final long f53852b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f53853c;

    /* renamed from: d, reason: collision with root package name */
    public long f53854d;

    public LongProgressionIterator(long j2, long j3, long j4) {
        this.f53851a = j4;
        this.f53852b = j3;
        boolean z = false;
        if (j4 <= 0 ? j2 >= j3 : j2 <= j3) {
            z = true;
        }
        this.f53853c = z;
        this.f53854d = z ? j2 : j3;
    }

    @Override // kotlin.collections.LongIterator
    public final long a() {
        long j2 = this.f53854d;
        if (j2 != this.f53852b) {
            this.f53854d = this.f53851a + j2;
            return j2;
        }
        if (!this.f53853c) {
            throw new NoSuchElementException();
        }
        this.f53853c = false;
        return j2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53853c;
    }
}
