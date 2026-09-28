package io.ktor.utils.io.bits;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DefaultAllocator implements Allocator {

    /* renamed from: a, reason: collision with root package name */
    public static final DefaultAllocator f51174a = new DefaultAllocator();

    @Override // io.ktor.utils.io.bits.Allocator
    public final void a(ByteBuffer instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // io.ktor.utils.io.bits.Allocator
    public final ByteBuffer b(int i2) {
        ByteBuffer buffer = ByteBuffer.allocate(i2);
        Intrinsics.checkNotNullExpressionValue(buffer, "allocate(size)");
        ByteBuffer byteBuffer = Memory.f51175b;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return buffer;
    }
}
