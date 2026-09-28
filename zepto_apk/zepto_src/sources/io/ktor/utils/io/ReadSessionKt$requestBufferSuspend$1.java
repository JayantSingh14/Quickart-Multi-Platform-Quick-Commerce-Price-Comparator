package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", l = {WKSRecord.Service.LOCUS_MAP}, m = "requestBufferSuspend")
/* loaded from: classes3.dex */
final class ReadSessionKt$requestBufferSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SuspendableReadSession f51161a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51162b;

    /* renamed from: c, reason: collision with root package name */
    public int f51163c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51162b = obj;
        this.f51163c |= Integer.MIN_VALUE;
        return ReadSessionKt.d(null, 0, this);
    }
}
