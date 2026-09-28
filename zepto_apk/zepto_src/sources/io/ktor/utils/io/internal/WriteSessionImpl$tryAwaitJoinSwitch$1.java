package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.internal.WriteSessionImpl", f = "WriteSessionImpl.kt", l = {86}, m = "tryAwaitJoinSwitch")
/* loaded from: classes3.dex */
final class WriteSessionImpl$tryAwaitJoinSwitch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public WriteSessionImpl f51292a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51293b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WriteSessionImpl f51294c;

    /* renamed from: d, reason: collision with root package name */
    public int f51295d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteSessionImpl$tryAwaitJoinSwitch$1(WriteSessionImpl writeSessionImpl, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51294c = writeSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51293b = obj;
        this.f51295d |= Integer.MIN_VALUE;
        return this.f51294c.f(0, this);
    }
}
