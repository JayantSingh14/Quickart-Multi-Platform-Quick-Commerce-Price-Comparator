package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
public interface ByteReadChannel {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f51074a = Companion.f51075a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f51075a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final Lazy f51076b = LazyKt.b(ByteReadChannel$Companion$Empty$2.f51077c);

        public static ByteReadChannel a() {
            return (ByteReadChannel) f51076b.getValue();
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Object D(long j2, ContinuationImpl continuationImpl);

    Object E(int i2, Function1 function1, ContinuationImpl continuationImpl);

    Object F(ByteBuffer byteBuffer, ContinuationImpl continuationImpl);

    Object I(ChunkBuffer chunkBuffer, ContinuationImpl continuationImpl);

    boolean K();

    Throwable a();

    int g();

    boolean h();

    Object i(ByteBuffer byteBuffer, long j2, long j3, long j4, Continuation continuation);

    Object j(byte[] bArr, int i2, int i3, ContinuationImpl continuationImpl);

    Object k(ContinuationImpl continuationImpl);

    boolean l(Throwable th);

    Object n(long j2, ContinuationImpl continuationImpl);

    Object o(ContinuationImpl continuationImpl);

    Object q(ContinuationImpl continuationImpl);

    Object t(int i2, ContinuationImpl continuationImpl);

    Object v(byte[] bArr, int i2, ContinuationImpl continuationImpl);

    Object w(Continuation continuation);

    Object x(Continuation continuation);
}
