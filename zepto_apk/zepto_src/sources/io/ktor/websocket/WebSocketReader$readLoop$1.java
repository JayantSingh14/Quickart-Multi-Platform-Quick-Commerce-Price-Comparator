package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", l = {WKSRecord.Service.BOOTPC, WKSRecord.Service.NETRJS_4}, m = "readLoop")
/* loaded from: classes3.dex */
final class WebSocketReader$readLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51525a;

    /* renamed from: b, reason: collision with root package name */
    public int f51526b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51525a = obj;
        this.f51526b |= Integer.MIN_VALUE;
        throw null;
    }
}
