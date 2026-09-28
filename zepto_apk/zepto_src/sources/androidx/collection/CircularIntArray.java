package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CircularIntArray {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1406a;

    /* renamed from: b, reason: collision with root package name */
    public int f1407b;

    /* renamed from: c, reason: collision with root package name */
    public int f1408c;

    /* renamed from: d, reason: collision with root package name */
    public int f1409d;

    @JvmOverloads
    public CircularIntArray() {
        int iHighestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.f1409d = iHighestOneBit - 1;
        this.f1406a = new int[iHighestOneBit];
    }

    public final void a(int i2) {
        int[] iArr = this.f1406a;
        int i3 = this.f1408c;
        iArr[i3] = i2;
        int i4 = this.f1409d & (i3 + 1);
        this.f1408c = i4;
        int i5 = this.f1407b;
        if (i4 == i5) {
            int length = iArr.length;
            int i6 = length - i5;
            int i7 = length << 1;
            if (i7 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i7];
            ArraysKt.k(0, i5, length, iArr, iArr2);
            ArraysKt.k(i6, 0, this.f1407b, this.f1406a, iArr2);
            this.f1406a = iArr2;
            this.f1407b = 0;
            this.f1408c = length;
            this.f1409d = i7 - 1;
        }
    }

    public final int b() {
        int i2 = this.f1407b;
        if (i2 == this.f1408c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.f1406a[i2];
        this.f1407b = (i2 + 1) & this.f1409d;
        return i3;
    }
}
