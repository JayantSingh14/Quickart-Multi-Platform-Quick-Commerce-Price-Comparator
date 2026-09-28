package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CharProgressionIterator extends CharIterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f53832a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53833b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f53834c;

    /* renamed from: d, reason: collision with root package name */
    public int f53835d;

    public CharProgressionIterator(char c2, char c3, int i2) {
        this.f53832a = i2;
        this.f53833b = c3;
        boolean z = false;
        if (i2 <= 0 ? Intrinsics.e(c2, c3) >= 0 : Intrinsics.e(c2, c3) <= 0) {
            z = true;
        }
        this.f53834c = z;
        this.f53835d = z ? c2 : c3;
    }

    @Override // kotlin.collections.CharIterator
    public final char a() {
        int i2 = this.f53835d;
        if (i2 != this.f53833b) {
            this.f53835d = this.f53832a + i2;
        } else {
            if (!this.f53834c) {
                throw new NoSuchElementException();
            }
            this.f53834c = false;
        }
        return (char) i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53834c;
    }
}
