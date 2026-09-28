package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.TTL;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Memory {

    /* renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f51175b;

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f51176a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        ByteBuffer buffer = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(buffer, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        f51175b = buffer;
    }

    public static final void a(long j2, long j3, long j4, ByteBuffer byteBuffer, ByteBuffer destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j2 >= TTL.MAX_VALUE) {
            NumbersKt.a(j2, "offset");
            throw null;
        }
        int i2 = (int) j2;
        if (j3 >= TTL.MAX_VALUE) {
            NumbersKt.a(j3, "length");
            throw null;
        }
        int i3 = (int) j3;
        if (j4 < TTL.MAX_VALUE) {
            b(byteBuffer, i2, i3, destination, (int) j4);
        } else {
            NumbersKt.a(j4, "destinationOffset");
            throw null;
        }
    }

    public static final void b(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer destination, int i4) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (byteBuffer.hasArray() && destination.hasArray() && !byteBuffer.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i2, destination.array(), destination.arrayOffset() + i4, i3);
            return;
        }
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i2);
        byteBufferDuplicate.limit(i2 + i3);
        ByteBuffer byteBufferDuplicate2 = destination.duplicate();
        byteBufferDuplicate2.position(i4);
        byteBufferDuplicate2.put(byteBufferDuplicate);
    }

    public static final ByteBuffer c(ByteBuffer byteBuffer, int i2, int i3) {
        ByteBuffer buffer = MemoryJvmKt.c(byteBuffer, i2, i3);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Memory) {
            return Intrinsics.b(this.f51176a, ((Memory) obj).f51176a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f51176a.hashCode();
    }

    public final String toString() {
        return "Memory(buffer=" + this.f51176a + ')';
    }
}
