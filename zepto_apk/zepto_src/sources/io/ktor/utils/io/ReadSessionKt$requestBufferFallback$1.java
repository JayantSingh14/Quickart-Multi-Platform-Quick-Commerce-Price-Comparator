package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", l = {WKSRecord.Service.STATSRV}, m = "requestBufferFallback")
/* loaded from: classes3.dex */
final class ReadSessionKt$requestBufferFallback$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ChunkBuffer f51158a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51159b;

    /* renamed from: c, reason: collision with root package name */
    public int f51160c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51159b = obj;
        this.f51160c |= Integer.MIN_VALUE;
        return ReadSessionKt.c(null, 0, this);
    }
}
