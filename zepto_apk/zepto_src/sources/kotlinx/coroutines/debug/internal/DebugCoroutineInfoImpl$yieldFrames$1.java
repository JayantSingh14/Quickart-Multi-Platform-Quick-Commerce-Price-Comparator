package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", l = {169}, m = "yieldFrames")
/* loaded from: classes3.dex */
final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54463a;

    /* renamed from: b, reason: collision with root package name */
    public int f54464b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54463a = obj;
        this.f54464b |= Integer.MIN_VALUE;
        throw null;
    }
}
