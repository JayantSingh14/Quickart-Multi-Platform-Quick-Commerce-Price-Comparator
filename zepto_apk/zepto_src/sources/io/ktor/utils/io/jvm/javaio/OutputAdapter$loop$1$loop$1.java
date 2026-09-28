package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1", f = "Blocking.kt", l = {319, 94}, m = "loop")
/* loaded from: classes3.dex */
final class OutputAdapter$loop$1$loop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public OutputAdapter$loop$1 f51325a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51326b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OutputAdapter$loop$1 f51327c;

    /* renamed from: d, reason: collision with root package name */
    public int f51328d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputAdapter$loop$1$loop$1(OutputAdapter$loop$1 outputAdapter$loop$1, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51327c = outputAdapter$loop$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51326b = obj;
        this.f51328d |= Integer.MIN_VALUE;
        return this.f51327c.b(this);
    }
}
