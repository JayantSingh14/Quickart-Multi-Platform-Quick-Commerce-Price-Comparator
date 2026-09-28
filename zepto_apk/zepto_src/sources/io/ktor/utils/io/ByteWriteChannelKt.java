package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ByteWriteChannelKt {
    public static final boolean a(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return byteWriteChannel.d(null);
    }

    public static final Object b(ByteWriteChannel byteWriteChannel, byte[] bArr, ContinuationImpl continuationImpl) {
        Object objJ = byteWriteChannel.J(bArr, 0, bArr.length, continuationImpl);
        return objJ == CoroutineSingletons.f53689a ? objJ : Unit.f53572a;
    }
}
