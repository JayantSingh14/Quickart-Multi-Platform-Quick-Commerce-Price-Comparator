package io.ktor.client.plugins.cookies;

import io.ktor.client.plugins.HttpClientPluginKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.slf4j.Logger;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", l = {WKSRecord.Service.PROFILE}, m = "cookies")
/* loaded from: classes3.dex */
final class HttpCookiesKt$cookies$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49940a;

    /* renamed from: b, reason: collision with root package name */
    public int f49941b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49940a = obj;
        int i2 = this.f49941b | Integer.MIN_VALUE;
        this.f49941b = i2;
        Logger logger = HttpCookiesKt.f49939a;
        int i3 = i2 - Integer.MIN_VALUE;
        this.f49941b = i3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i3 == 0) {
            ResultKt.b(obj);
            HttpClientPluginKt.b(null, HttpCookies.f49898d);
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List list = (List) obj;
        return list == null ? EmptyList.f53609a : list;
    }
}
