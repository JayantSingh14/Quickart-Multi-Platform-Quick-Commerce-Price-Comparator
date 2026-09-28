package io.ktor.utils.io.core;

import android.support.v4.media.b;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BufferKt {
    public static final void a(int i2, int i3) {
        throw new EOFException(b.e(i2, i3, "Unable to discard ", " bytes: only ", " available for writing"));
    }

    public static final void b(int i2, int i3) {
        throw new EOFException(b.e(i2, i3, "Unable to discard ", " bytes: only ", " available for reading"));
    }

    public static final void c(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalArgumentException("End gap 8 is too big: capacity is " + buffer.f51185f);
    }

    public static final void d(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalArgumentException("Unable to reserve end gap 8: there are already " + (buffer.f51182c - buffer.f51181b) + " content bytes at offset " + buffer.f51181b);
    }

    public static final void e(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalArgumentException(b.o(new StringBuilder("End gap 8 is too big: there are already "), buffer.f51183d, " bytes reserved in the beginning"));
    }

    public static final void f(int i2, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        chunkBuffer.d(chunkBuffer.f51181b - i2);
    }

    public static final void g(int i2, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        StringBuilder sbU = b.u(i2, "Unable to reserve ", " start gap: there are already ");
        sbU.append(chunkBuffer.f51182c - chunkBuffer.f51181b);
        sbU.append(" content bytes starting at offset ");
        sbU.append(chunkBuffer.f51181b);
        throw new IllegalStateException(sbU.toString());
    }

    public static final void h(int i2, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        int i3 = chunkBuffer.f51185f;
        if (i2 > i3) {
            throw new IllegalArgumentException(b.d(i2, i3, "Start gap ", " is bigger than the capacity "));
        }
        StringBuilder sbU = b.u(i2, "Unable to reserve ", " start gap: there are already ");
        sbU.append(i3 - chunkBuffer.f51184e);
        sbU.append(" bytes reserved in the end");
        throw new IllegalStateException(sbU.toString());
    }
}
