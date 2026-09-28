package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class ShortArrayBuilder extends PrimitiveArrayBuilder<short[]> {

    /* renamed from: a, reason: collision with root package name */
    public short[] f55897a;

    /* renamed from: b, reason: collision with root package name */
    public int f55898b;

    public ShortArrayBuilder(short[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55897a = bufferWithData;
        this.f55898b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f55897a, this.f55898b);
        Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        short[] sArr = this.f55897a;
        if (sArr.length < i2) {
            int length = sArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i2);
            Intrinsics.checkNotNullExpressionValue(sArrCopyOf, "copyOf(...)");
            this.f55897a = sArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55898b;
    }

    public final void e(short s) {
        b(d() + 1);
        short[] sArr = this.f55897a;
        int i2 = this.f55898b;
        this.f55898b = i2 + 1;
        sArr[i2] = s;
    }
}
