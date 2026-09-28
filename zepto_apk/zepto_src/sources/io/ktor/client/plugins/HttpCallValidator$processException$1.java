package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {Type.TALINK, Type.CDS}, m = "processException")
/* loaded from: classes3.dex */
final class HttpCallValidator$processException$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f49519a;

    /* renamed from: b, reason: collision with root package name */
    public HttpRequest f49520b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f49521c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f49522d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpCallValidator f49523e;

    /* renamed from: f, reason: collision with root package name */
    public int f49524f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$processException$1(HttpCallValidator httpCallValidator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49523e = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49522d = obj;
        this.f49524f |= Integer.MIN_VALUE;
        return HttpCallValidator.a(this.f49523e, null, null, this);
    }
}
