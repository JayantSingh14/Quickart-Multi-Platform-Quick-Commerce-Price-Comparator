package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class BooleanArrayBuilder extends PrimitiveArrayBuilder<boolean[]> {

    /* renamed from: a, reason: collision with root package name */
    public boolean[] f55770a;

    /* renamed from: b, reason: collision with root package name */
    public int f55771b;

    public BooleanArrayBuilder(boolean[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55770a = bufferWithData;
        this.f55771b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f55770a, this.f55771b);
        Intrinsics.checkNotNullExpressionValue(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        boolean[] zArr = this.f55770a;
        if (zArr.length < i2) {
            int length = zArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i2);
            Intrinsics.checkNotNullExpressionValue(zArrCopyOf, "copyOf(...)");
            this.f55770a = zArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55771b;
    }

    public final void e(boolean z) {
        b(d() + 1);
        boolean[] zArr = this.f55770a;
        int i2 = this.f55771b;
        this.f55771b = i2 + 1;
        zArr[i2] = z;
    }
}
