package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", l = {WKSRecord.Protocol.RVD}, m = "addCookie")
/* loaded from: classes3.dex */
final class AcceptAllCookiesStorage$addCookie$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AcceptAllCookiesStorage f49882a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49883b;

    /* renamed from: c, reason: collision with root package name */
    public Cookie f49884c;

    /* renamed from: d, reason: collision with root package name */
    public MutexImpl f49885d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f49886e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AcceptAllCookiesStorage f49887f;

    /* renamed from: g, reason: collision with root package name */
    public int f49888g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptAllCookiesStorage$addCookie$1(AcceptAllCookiesStorage acceptAllCookiesStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49887f = acceptAllCookiesStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49886e = obj;
        this.f49888g |= Integer.MIN_VALUE;
        return this.f49887f.a(null, null, this);
    }
}
