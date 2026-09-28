package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpSend;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$DefaultSender", f = "HttpSend.kt", l = {WKSRecord.Service.NETBIOS_DGM}, m = "execute")
/* loaded from: classes.dex */
final class HttpSend$DefaultSender$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49631a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49632b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpSend.DefaultSender f49633c;

    /* renamed from: d, reason: collision with root package name */
    public int f49634d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$DefaultSender$execute$1(HttpSend.DefaultSender defaultSender, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49633c = defaultSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49632b = obj;
        this.f49634d |= Integer.MIN_VALUE;
        return this.f49633c.a(null, this);
    }
}
