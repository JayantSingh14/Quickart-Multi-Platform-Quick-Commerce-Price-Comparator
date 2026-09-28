package io.ktor.utils.io.streams;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Output;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class OutputStreamAdapter extends Output {
    @Override // io.ktor.utils.io.core.Output
    public final void s() {
        throw null;
    }

    @Override // io.ktor.utils.io.core.Output
    public final void x(ByteBuffer source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source.hasArray() && !source.isReadOnly()) {
            source.array();
            source.arrayOffset();
            throw null;
        }
        ByteArraysKt$ByteArrayPool$1 byteArraysKt$ByteArrayPool$1 = ByteArraysKt.f51378a;
        byte[] bArr = (byte[]) byteArraysKt$ByteArrayPool$1.S0();
        ByteBuffer byteBufferC = MemoryJvmKt.c(source, i2, i3);
        try {
            int iMin = Math.min(byteBufferC.remaining(), bArr.length);
            if (iMin == 0) {
                byteArraysKt$ByteArrayPool$1.G1(bArr);
            } else {
                byteBufferC.get(bArr, 0, iMin);
                throw null;
            }
        } catch (Throwable th) {
            ByteArraysKt.f51378a.G1(bArr);
            throw th;
        }
    }
}
