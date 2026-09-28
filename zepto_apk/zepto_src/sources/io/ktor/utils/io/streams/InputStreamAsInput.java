package io.ktor.utils.io.streams;

import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InputStreamAsInput extends Input {
    @Override // io.ktor.utils.io.core.Input
    public final void a() {
        throw null;
    }

    @Override // io.ktor.utils.io.core.Input
    public final int r(ByteBuffer destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.hasArray() && !destination.isReadOnly()) {
            destination.array();
            destination.arrayOffset();
            throw null;
        }
        byte[] bArr = (byte[]) ByteArraysKt.f51378a.S0();
        try {
            Math.min(bArr.length, i3);
            throw null;
        } catch (Throwable th) {
            ByteArraysKt.f51378a.G1(bArr);
            throw th;
        }
    }
}
