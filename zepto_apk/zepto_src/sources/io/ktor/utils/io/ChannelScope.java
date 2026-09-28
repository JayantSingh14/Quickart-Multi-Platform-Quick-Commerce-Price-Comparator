package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
final class ChannelScope implements ReaderScope, WriterScope, CoroutineScope {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBufferChannel f51119a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f51120b;

    public ChannelScope(CoroutineScope delegate, ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f51119a = channel;
        this.f51120b = delegate;
    }

    @Override // io.ktor.utils.io.WriterScope
    public final ByteChannel l0() {
        return this.f51119a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f51120b.r();
    }
}
