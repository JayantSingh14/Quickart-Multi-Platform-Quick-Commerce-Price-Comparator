package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata
@ExperimentalSerializationApi
@ExperimentalUnsignedTypes
@PublishedApi
/* loaded from: classes3.dex */
public final class UShortArrayBuilder extends PrimitiveArrayBuilder<UShortArray> {

    /* renamed from: a, reason: collision with root package name */
    public short[] f55931a;

    /* renamed from: b, reason: collision with root package name */
    public int f55932b;

    public UShortArrayBuilder(short[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55931a = bufferWithData;
        this.f55932b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        short[] storage = Arrays.copyOf(this.f55931a, this.f55932b);
        Intrinsics.checkNotNullExpressionValue(storage, "copyOf(...)");
        Intrinsics.checkNotNullParameter(storage, "storage");
        return new UShortArray(storage);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        short[] sArr = this.f55931a;
        if (sArr.length < i2) {
            int length = sArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            short[] storage = Arrays.copyOf(sArr, i2);
            Intrinsics.checkNotNullExpressionValue(storage, "copyOf(...)");
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.f55931a = storage;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55932b;
    }

    public final void e(short s) {
        b(d() + 1);
        short[] sArr = this.f55931a;
        int i2 = this.f55932b;
        this.f55932b = i2 + 1;
        sArr[i2] = s;
    }
}
