package io.ktor.utils.io;

import io.ktor.utils.io.internal.ObjectPoolKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;

@Metadata
/* loaded from: classes.dex */
public final class CoroutinesKt {
    public static final WriterJob a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        final ByteBufferChannel byteBufferChannel = new ByteBufferChannel(z, ObjectPoolKt.f51248c, 8);
        Job jobC = BuildersKt.c(coroutineScope, coroutineContext, new CoroutinesKt$launchChannel$job$1(byteBufferChannel, block, (CoroutineDispatcher) coroutineScope.r().get(CoroutineDispatcher.f54074a), null), 2);
        ((JobSupport) jobC).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.CoroutinesKt$launchChannel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byteBufferChannel.d((Throwable) obj);
                return Unit.f53572a;
            }
        });
        return new ChannelJob(jobC, byteBufferChannel);
    }
}
