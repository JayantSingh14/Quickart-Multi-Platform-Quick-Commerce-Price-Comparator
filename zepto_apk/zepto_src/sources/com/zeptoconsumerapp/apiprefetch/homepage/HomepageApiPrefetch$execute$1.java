package com.zeptoconsumerapp.apiprefetch.homepage;

import android.content.SharedPreferences;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.apiprefetch.base.HeaderField;
import com.zeptoconsumerapp.apiprefetch.tracker.ApiPrefetchTracker;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata
@DebugMetadata(c = "com.zeptoconsumerapp.apiprefetch.homepage.HomepageApiPrefetch$execute$1", f = "HomepageApiPrefetch.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes4.dex */
final class HomepageApiPrefetch$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomepageApiPrefetch f47594a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomepageApiPrefetch$execute$1(HomepageApiPrefetch homepageApiPrefetch, Continuation continuation) {
        super(2, continuation);
        this.f47594a = homepageApiPrefetch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HomepageApiPrefetch$execute$1(this.f47594a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HomepageApiPrefetch$execute$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String string;
        ArrayList arrayListC;
        JSONObject jSONObjectD;
        int length;
        HomePageOptions homePageOptions;
        HomepageApiPrefetch homepageApiPrefetch = this.f47594a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        try {
            ApiPrefetchTracker.Companion companion = ApiPrefetchTracker.Companion;
            MediaType mediaType = HomepageApiPrefetch.f47593d;
            companion.start(homepageApiPrefetch.f47580a.f47589a);
            Object value = homepageApiPrefetch.f47582c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            string = ((SharedPreferences) value).getString("accessToken", "");
            if (string == null) {
                string = "";
            }
            arrayListC = homepageApiPrefetch.c(string);
            jSONObjectD = homepageApiPrefetch.d();
            length = BuildConfig.LAYOUT_SERVICE_URL.length();
            homePageOptions = homepageApiPrefetch.f47580a;
        } catch (Exception e2) {
            ApiPrefetchTracker.Companion companion2 = ApiPrefetchTracker.Companion;
            MediaType mediaType2 = HomepageApiPrefetch.f47593d;
            companion2.moveToError(homepageApiPrefetch.f47580a.f47589a, "Error in prefetch logic" + e2.getMessage());
            Timber.d("PREFETCH").e(e2, "Error in prefetch logic", new Object[0]);
        }
        if (length == 0) {
            ApiPrefetchTracker.Companion.moveToError(homePageOptions.f47589a, "Base URL is empty");
            return Unit.f53572a;
        }
        if (string.length() == 0) {
            ApiPrefetchTracker.Companion.moveToError(homePageOptions.f47589a, "Access token is empty");
            return Unit.f53572a;
        }
        if (jSONObjectD == null) {
            ApiPrefetchTracker.Companion.moveToError(homePageOptions.f47589a, "Request body is null");
            return Unit.f53572a;
        }
        RequestBody.Companion companion3 = RequestBody.Companion;
        String string2 = jSONObjectD.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        MediaType mediaType3 = HomepageApiPrefetch.f47593d;
        companion3.getClass();
        RequestBody$Companion$toRequestBody$2 body = RequestBody.Companion.a(string2, mediaType3);
        Request.Builder builder = new Request.Builder();
        builder.i(BuildConfig.LAYOUT_SERVICE_URL.concat("v2/get_page"));
        Intrinsics.checkNotNullParameter(body, "body");
        builder.f("POST", body);
        Iterator it = arrayListC.iterator();
        while (it.hasNext()) {
            HeaderField headerField = (HeaderField) it.next();
            builder.a(headerField.f47583a, headerField.f47584b);
        }
        HomepageApiPrefetch.a(homepageApiPrefetch, builder.b());
        return Unit.f53572a;
    }
}
