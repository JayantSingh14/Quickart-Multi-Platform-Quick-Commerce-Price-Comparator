package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class FloatArrayBuilder extends PrimitiveArrayBuilder<float[]> {

    /* renamed from: a, reason: collision with root package name */
    public float[] f55819a;

    /* renamed from: b, reason: collision with root package name */
    public int f55820b;

    public FloatArrayBuilder(float[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55819a = bufferWithData;
        this.f55820b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f55819a, this.f55820b);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        float[] fArr = this.f55819a;
        if (fArr.length < i2) {
            int length = fArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, i2);
            Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
            this.f55819a = fArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55820b;
    }

    public final void e(float f2) {
        b(d() + 1);
        float[] fArr = this.f55819a;
        int i2 = this.f55820b;
        this.f55820b = i2 + 1;
        fArr[i2] = f2;
    }
}
