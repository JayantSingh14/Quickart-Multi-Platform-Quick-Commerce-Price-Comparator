package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class LongArrayBuilder extends PrimitiveArrayBuilder<long[]> {

    /* renamed from: a, reason: collision with root package name */
    public long[] f55839a;

    /* renamed from: b, reason: collision with root package name */
    public int f55840b;

    public LongArrayBuilder(long[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55839a = bufferWithData;
        this.f55840b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f55839a, this.f55840b);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        long[] jArr = this.f55839a;
        if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i2);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.f55839a = jArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55840b;
    }

    public final void e(long j2) {
        b(d() + 1);
        long[] jArr = this.f55839a;
        int i2 = this.f55840b;
        this.f55840b = i2 + 1;
        jArr[i2] = j2;
    }
}
