package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class DoubleArrayBuilder extends PrimitiveArrayBuilder<double[]> {

    /* renamed from: a, reason: collision with root package name */
    public double[] f55798a;

    /* renamed from: b, reason: collision with root package name */
    public int f55799b;

    public DoubleArrayBuilder(double[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55798a = bufferWithData;
        this.f55799b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f55798a, this.f55799b);
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        double[] dArr = this.f55798a;
        if (dArr.length < i2) {
            int length = dArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr, i2);
            Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
            this.f55798a = dArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55799b;
    }

    public final void e(double d2) {
        b(d() + 1);
        double[] dArr = this.f55798a;
        int i2 = this.f55799b;
        this.f55799b = i2 + 1;
        dArr[i2] = d2;
    }
}
