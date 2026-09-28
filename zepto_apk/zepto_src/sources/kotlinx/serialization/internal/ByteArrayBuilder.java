package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class ByteArrayBuilder extends PrimitiveArrayBuilder<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f55775a;

    /* renamed from: b, reason: collision with root package name */
    public int f55776b;

    public ByteArrayBuilder(byte[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55775a = bufferWithData;
        this.f55776b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f55775a, this.f55776b);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        byte[] bArr = this.f55775a;
        if (bArr.length < i2) {
            int length = bArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            this.f55775a = bArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55776b;
    }

    public final void e(byte b2) {
        b(d() + 1);
        byte[] bArr = this.f55775a;
        int i2 = this.f55776b;
        this.f55776b = i2 + 1;
        bArr[i2] = b2;
    }
}
