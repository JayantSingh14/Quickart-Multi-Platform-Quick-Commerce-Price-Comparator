package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: classes3.dex */
public interface ByteWriteChannel {

    @Metadata
    public static final class DefaultImpls {
    }

    Object C(int i2, Function1 function1, ContinuationImpl continuationImpl);

    Object H(int i2, ContinuationImpl continuationImpl);

    Object J(byte[] bArr, int i2, int i3, ContinuationImpl continuationImpl);

    boolean L();

    Throwable a();

    boolean d(Throwable th);

    Object e(short s, ContinuationImpl continuationImpl);

    Object f(byte b2, ContinuationImpl continuationImpl);

    void flush();

    Object m(Function2 function2, Continuation continuation);

    Object p(long j2, ContinuationImpl continuationImpl);

    Object r(ByteBuffer byteBuffer, ContinuationImpl continuationImpl);

    Object s(Buffer buffer, ContinuationImpl continuationImpl);

    Object u(ByteReadPacket byteReadPacket, ContinuationImpl continuationImpl);
}
