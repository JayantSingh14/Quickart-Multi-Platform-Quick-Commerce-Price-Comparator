package io.ktor.utils.io.internal;

import io.ktor.utils.io.pool.DirectByteBufferPool;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ObjectPoolKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f51246a;

    /* renamed from: b, reason: collision with root package name */
    public static final DirectByteBufferPool f51247b;

    /* renamed from: c, reason: collision with root package name */
    public static final ObjectPoolKt$BufferObjectPool$1 f51248c;

    /* renamed from: d, reason: collision with root package name */
    public static final ObjectPoolKt$BufferObjectNoPool$1 f51249d;

    static {
        int iA = UtilsKt.a(4096, "BufferSize");
        f51246a = iA;
        int iA2 = UtilsKt.a(2048, "BufferPoolSize");
        int iA3 = UtilsKt.a(1024, "BufferObjectPoolSize");
        f51247b = new DirectByteBufferPool(iA2, iA);
        f51248c = new ObjectPoolKt$BufferObjectPool$1(iA3);
        f51249d = new ObjectPoolKt$BufferObjectNoPool$1();
    }
}
