package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes.dex */
public final class IntProgressionIterator extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f53841a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53842b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f53843c;

    /* renamed from: d, reason: collision with root package name */
    public int f53844d;

    public IntProgressionIterator(int i2, int i3, int i4) {
        this.f53841a = i4;
        this.f53842b = i3;
        boolean z = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z = true;
        }
        this.f53843c = z;
        this.f53844d = z ? i2 : i3;
    }

    @Override // kotlin.collections.IntIterator
    public final int a() {
        int i2 = this.f53844d;
        if (i2 != this.f53842b) {
            this.f53844d = this.f53841a + i2;
            return i2;
        }
        if (!this.f53843c) {
            throw new NoSuchElementException();
        }
        this.f53843c = false;
        return i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53843c;
    }
}
