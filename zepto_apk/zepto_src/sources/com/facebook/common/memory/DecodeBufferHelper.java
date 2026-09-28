package com.facebook.common.memory;

import androidx.core.util.Pools;
import com.facebook.infer.annotation.Nullsafe;
import java.nio.ByteBuffer;

@Nullsafe
/* loaded from: classes.dex */
public class DecodeBufferHelper implements Pools.Pool<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    public static final int f17092a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f17093b;

    /* renamed from: com.facebook.common.memory.DecodeBufferHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends ThreadLocal<ByteBuffer> {
        @Override // java.lang.ThreadLocal
        public final ByteBuffer initialValue() {
            return ByteBuffer.allocate(DecodeBufferHelper.f17092a);
        }
    }

    static {
        new DecodeBufferHelper();
        f17092a = 16384;
        f17093b = new AnonymousClass1();
    }

    @Override // androidx.core.util.Pools.Pool
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // androidx.core.util.Pools.Pool
    public final Object b() {
        return (ByteBuffer) f17093b.get();
    }
}
