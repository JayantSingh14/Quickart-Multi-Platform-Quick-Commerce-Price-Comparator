package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", l = {WKSRecord.Service.DCP}, m = "writeBufferSuspend")
/* loaded from: classes3.dex */
final class WriterSessionKt$writeBufferSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public WriterSuspendSession f51170a;

    /* renamed from: b, reason: collision with root package name */
    public int f51171b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f51172c;

    /* renamed from: d, reason: collision with root package name */
    public int f51173d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51172c = obj;
        this.f51173d |= Integer.MIN_VALUE;
        return WriterSessionKt.d(null, 0, this);
    }
}
