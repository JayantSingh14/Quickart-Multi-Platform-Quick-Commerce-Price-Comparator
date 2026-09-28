package io.ktor.client.plugins.cookies;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", l = {WKSRecord.Protocol.RVD}, m = "get")
/* loaded from: classes3.dex */
final class AcceptAllCookiesStorage$get$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AcceptAllCookiesStorage f49892a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49893b;

    /* renamed from: c, reason: collision with root package name */
    public MutexImpl f49894c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f49895d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AcceptAllCookiesStorage f49896e;

    /* renamed from: f, reason: collision with root package name */
    public int f49897f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptAllCookiesStorage$get$1(AcceptAllCookiesStorage acceptAllCookiesStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49896e = acceptAllCookiesStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49895d = obj;
        this.f49897f |= Integer.MIN_VALUE;
        return this.f49896e.b(null, this);
    }
}
