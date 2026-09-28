package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class IntArrayBuilder extends PrimitiveArrayBuilder<int[]> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f55828a;

    /* renamed from: b, reason: collision with root package name */
    public int f55829b;

    public IntArrayBuilder(int[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55828a = bufferWithData;
        this.f55829b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f55828a, this.f55829b);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        int[] iArr = this.f55828a;
        if (iArr.length < i2) {
            int length = iArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f55828a = iArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55829b;
    }

    public final void e(int i2) {
        b(d() + 1);
        int[] iArr = this.f55828a;
        int i3 = this.f55829b;
        this.f55829b = i3 + 1;
        iArr[i3] = i2;
    }
}
