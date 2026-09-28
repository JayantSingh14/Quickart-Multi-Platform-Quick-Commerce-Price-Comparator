package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.BufferKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UnsafeKt {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f51229a = new byte[0];

    public static final void a(Input input, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current == input) {
            return;
        }
        int i2 = current.f51182c;
        int i3 = current.f51181b;
        if (i2 <= i3) {
            input.e(current);
            return;
        }
        int i4 = current.f51184e;
        int i5 = current.f51185f;
        if (i5 - i4 >= 8) {
            input.f51197d = i3;
            return;
        }
        input.getClass();
        Intrinsics.checkNotNullParameter(current, "current");
        ChunkBuffer chunkBufferI = current.i();
        if (chunkBufferI == null) {
            input.s(current);
            return;
        }
        int i6 = current.f51182c - current.f51181b;
        int iMin = Math.min(i6, 8 - (i5 - current.f51184e));
        if (chunkBufferI.f51183d < iMin) {
            input.s(current);
            return;
        }
        BufferKt.f(iMin, chunkBufferI);
        if (i6 > iMin) {
            current.f51184e = i5;
            input.f51198e = current.f51182c;
            input.k0(input.f51199f + iMin);
        } else {
            input.l0(chunkBufferI);
            input.k0(input.f51199f - ((chunkBufferI.f51182c - chunkBufferI.f51181b) - iMin));
            current.g();
            current.k(input.f51194a);
        }
    }

    public static final ChunkBuffer b(Input input, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.O(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ChunkBuffer c(Input input, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current != input) {
            input.getClass();
            Intrinsics.checkNotNullParameter(current, "current");
            return input.e(current);
        }
        if (input.f51197d == input.f51198e && input.f51199f == 0) {
            return null;
        }
        return (ChunkBuffer) input;
    }

    public static final ChunkBuffer d(Output output, int i2, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (chunkBuffer != null) {
            output.a();
        }
        return output.D(i2);
    }
}
