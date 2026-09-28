package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

@Metadata
@ExperimentalSerializationApi
@ExperimentalUnsignedTypes
@PublishedApi
/* loaded from: classes3.dex */
public final class UByteArrayBuilder extends PrimitiveArrayBuilder<UByteArray> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f55916a;

    /* renamed from: b, reason: collision with root package name */
    public int f55917b;

    public UByteArrayBuilder(byte[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55916a = bufferWithData;
        this.f55917b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        byte[] storage = Arrays.copyOf(this.f55916a, this.f55917b);
        Intrinsics.checkNotNullExpressionValue(storage, "copyOf(...)");
        Intrinsics.checkNotNullParameter(storage, "storage");
        return new UByteArray(storage);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        byte[] bArr = this.f55916a;
        if (bArr.length < i2) {
            int length = bArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            byte[] storage = Arrays.copyOf(bArr, i2);
            Intrinsics.checkNotNullExpressionValue(storage, "copyOf(...)");
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.f55916a = storage;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55917b;
    }

    public final void e(byte b2) {
        b(d() + 1);
        byte[] bArr = this.f55916a;
        int i2 = this.f55917b;
        this.f55917b = i2 + 1;
        bArr[i2] = b2;
    }
}
