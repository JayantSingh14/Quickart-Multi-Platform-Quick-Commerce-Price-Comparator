package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {51}, m = "validateResponse")
/* loaded from: classes.dex */
final class HttpCallValidator$validateResponse$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpResponse f49525a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f49526b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49527c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpCallValidator f49528d;

    /* renamed from: e, reason: collision with root package name */
    public int f49529e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$validateResponse$1(HttpCallValidator httpCallValidator, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49528d = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49527c = obj;
        this.f49529e |= Integer.MIN_VALUE;
        return HttpCallValidator.b(this.f49528d, null, this);
    }
}
