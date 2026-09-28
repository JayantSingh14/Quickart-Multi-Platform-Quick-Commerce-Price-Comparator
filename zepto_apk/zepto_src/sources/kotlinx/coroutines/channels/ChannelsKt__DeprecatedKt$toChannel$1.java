package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", l = {514, 308}, m = "toChannel")
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$toChannel$1<E, C extends SendChannel<? super E>> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SendChannel f54393a;

    /* renamed from: b, reason: collision with root package name */
    public ReceiveChannel f54394b;

    /* renamed from: c, reason: collision with root package name */
    public ChannelIterator f54395c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54396d;

    /* renamed from: e, reason: collision with root package name */
    public int f54397e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54396d = obj;
        this.f54397e |= Integer.MIN_VALUE;
        return ChannelsKt.b(null, null, this);
    }
}
