package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReadWriteBufferStateKt {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f51267a;

    /* renamed from: b, reason: collision with root package name */
    public static final RingBufferCapacity f51268b;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(0)");
        f51267a = byteBufferAllocate;
        f51268b = new RingBufferCapacity(0);
    }
}
