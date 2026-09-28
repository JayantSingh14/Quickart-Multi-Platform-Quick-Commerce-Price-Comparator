package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon", f = "RawWebSocketCommon.kt", l = {WKSRecord.Service.NTP, 126, WKSRecord.Service.CISCO_TNA}, m = "flush")
/* loaded from: classes3.dex */
final class RawWebSocketCommon$flush$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RawWebSocketCommon f51487b;

    /* renamed from: c, reason: collision with root package name */
    public int f51488c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$flush$1(RawWebSocketCommon rawWebSocketCommon, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51487b = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51486a = obj;
        this.f51488c |= Integer.MIN_VALUE;
        return this.f51487b.n0(this);
    }
}
