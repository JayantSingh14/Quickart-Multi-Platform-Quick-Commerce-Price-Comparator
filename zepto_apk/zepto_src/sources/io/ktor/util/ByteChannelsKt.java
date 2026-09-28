package io.ktor.util;

import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ObjectPoolKt$BufferObjectPool$1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.JobSupport;

@Metadata
/* loaded from: classes3.dex */
public final class ByteChannelsKt {
    public static final Pair a(ByteReadChannel byteReadChannel, HttpResponse coroutineScope) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        ObjectPoolKt$BufferObjectPool$1 objectPoolKt$BufferObjectPool$1 = ObjectPoolKt.f51248c;
        final ByteBufferChannel byteBufferChannel = new ByteBufferChannel(true, objectPoolKt$BufferObjectPool$1, 8);
        final ByteBufferChannel byteBufferChannel2 = new ByteBufferChannel(true, objectPoolKt$BufferObjectPool$1, 8);
        ((JobSupport) BuildersKt.c(coroutineScope, null, new ByteChannelsKt$split$1(byteReadChannel, byteBufferChannel, byteBufferChannel2, null), 3)).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$split$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                if (th != null) {
                    byteBufferChannel.d(th);
                    byteBufferChannel2.d(th);
                }
                return Unit.f53572a;
            }
        });
        return new Pair(byteBufferChannel, byteBufferChannel2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable b(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.util.ByteChannelsKt$toByteArray$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = (io.ktor.util.ByteChannelsKt$toByteArray$1) r0
            int r1 = r0.f50437b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50437b = r1
            goto L18
        L13:
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = new io.ktor.util.ByteChannelsKt$toByteArray$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f50436a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f50437b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r5)
            goto L40
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.ResultKt.b(r5)
            r0.f50437b = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r5 = r4.n(r2, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            byte[] r4 = io.ktor.utils.io.core.StringsKt.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.b(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }
}
