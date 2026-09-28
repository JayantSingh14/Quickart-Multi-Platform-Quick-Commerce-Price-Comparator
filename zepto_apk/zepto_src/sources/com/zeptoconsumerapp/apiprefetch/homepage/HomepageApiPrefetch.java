package com.zeptoconsumerapp.apiprefetch.homepage;

import com.facebook.react.modules.network.OkHttpClientProvider;
import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import com.zeptoconsumerapp.apiprefetch.base.ApiPrefetch;
import com.zeptoconsumerapp.apiprefetch.tracker.ApiPrefetchTracker;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata
/* loaded from: classes4.dex */
public final class HomepageApiPrefetch extends ApiPrefetch<HomePageOptions> {

    /* renamed from: d, reason: collision with root package name */
    public static final MediaType f47593d;

    @Metadata
    public static final class Companion {
    }

    static {
        Pattern pattern = MediaType.f56278d;
        f47593d = MediaType.Companion.b("application/json; charset=utf-8");
    }

    public static final void a(HomepageApiPrefetch homepageApiPrefetch, Request request) {
        homepageApiPrefetch.getClass();
        Response responseD = OkHttpClientProvider.b().a(request).d();
        try {
            boolean zC = responseD.c();
            int i2 = responseD.f56353d;
            String str = homepageApiPrefetch.f47580a.f47589a;
            ResponseBody responseBody = responseD.f56356g;
            if (!zC || responseBody == null) {
                ApiPrefetchTracker.Companion.moveToError(str, "API returned " + i2 + StringUtils.SPACE + responseBody);
                Timber.d("PREFETCH").e("API returned " + i2 + StringUtils.SPACE + responseBody, new Object[0]);
            } else {
                String strR = responseBody.r();
                try {
                    JSONObject jSONObject = new JSONObject(strR);
                    if (!jSONObject.has("storeServiceableResponse") || jSONObject.isNull("storeServiceableResponse")) {
                        ApiPrefetchTracker.Companion.moveToError(str, "storeServiceableResponse is null");
                        Timber.d("PREFETCH").d("PREFETCHLOGIC Skipping cache: storeServiceableResponse is null in response", new Object[0]);
                    } else {
                        ApiPrefetchTracker.Companion.moveToSuccess(str, strR);
                        Timber.d("PREFETCH").d("PREFETCHLOGIC Successfully prefetched and cached layout", new Object[0]);
                    }
                } catch (Exception unused) {
                    ApiPrefetchTracker.Companion.moveToError(str, "Error in parsing success response");
                    Timber.d("PREFETCH").e("PREFETCHLOGIC Skipping cache: storeServiceableResponse is null in response", new Object[0]);
                }
            }
            Unit unit = Unit.f53572a;
            responseD.close();
        } finally {
        }
    }

    public final void b() {
        AppCoroutineManager.a(new HomepageApiPrefetch$execute$1(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList c(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.apiprefetch.homepage.HomepageApiPrefetch.c(java.lang.String):java.util.ArrayList");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(22:132|16|(0)(5:21|22|128|23|(1:27))|31|(1:33)|136|34|(3:130|39|(1:41))|42|127|125|47|(6:52|(2:54|(2:56|(1:60))(2:61|62))|63|121|64|(1:(1:72)(1:73))(1:70))|76|134|77|(1:80)|81|(5:123|86|(1:92)(1:91)|93|(3:97|(1:99)(1:100)|(3:103|(1:105)(2:106|(0))|111))(0))|114|115|138)(1:12)|127|125|47|(7:49|52|(0)|63|121|64|(2:68|(0)(0))(0))|76|134|77|(0)|81|(4:83|123|86|(5:88|90|92|93|(4:95|97|(0)(0)|(3:103|(0)(0)|111))(0))(0))|114|115|138) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:0|2|126|3|4|(22:132|16|(0)(5:21|22|128|23|(1:27))|31|(1:33)|136|34|(3:130|39|(1:41))|42|127|125|47|(6:52|(2:54|(2:56|(1:60))(2:61|62))|63|121|64|(1:(1:72)(1:73))(1:70))|76|134|77|(1:80)|81|(5:123|86|(1:92)(1:91)|93|(3:97|(1:99)(1:100)|(3:103|(1:105)(2:106|(0))|111))(0))|114|115|138)(1:12)|13|31|(0)|136|34|(4:36|130|39|(0))|42|127|125|47|(7:49|52|(0)|63|121|64|(2:68|(0)(0))(0))|76|134|77|(0)|81|(4:83|123|86|(5:88|90|92|93|(4:95|97|(0)(0)|(3:103|(0)(0)|111))(0))(0))|114|115|138|(2:(0)|(1:137))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0194, code lost:
    
        timber.log.Timber.d("PREFETCH").d("PREFETCHLOGIC error reading user_action_meta", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x022f, code lost:
    
        timber.log.Timber.d("PREFETCH").d("PREFETCHLOGIC error reading future_timestamp", new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0289 A[Catch: Exception -> 0x02ad, TryCatch #4 {Exception -> 0x02ad, blocks: (B:81:0x0245, B:83:0x024b, B:103:0x0282, B:111:0x02a6, B:106:0x0289, B:108:0x029d, B:114:0x02af, B:75:0x022f, B:47:0x01a1, B:49:0x01a7, B:52:0x01af, B:54:0x01be, B:56:0x01c9, B:58:0x01d2, B:60:0x01d8, B:61:0x01ea, B:62:0x01f1, B:63:0x01f2, B:68:0x0203, B:70:0x020e, B:72:0x0214, B:73:0x022b), top: B:127:0x01a1, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014a A[Catch: Exception -> 0x008f, TRY_LEAVE, TryCatch #3 {Exception -> 0x008f, blocks: (B:3:0x0037, B:8:0x006c, B:10:0x0076, B:12:0x007e, B:31:0x00f3, B:33:0x014a, B:45:0x0194, B:30:0x00e7, B:34:0x0165, B:36:0x016e, B:43:0x0187), top: B:126:0x0037, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016e A[Catch: Exception -> 0x0194, TRY_LEAVE, TryCatch #9 {Exception -> 0x0194, blocks: (B:34:0x0165, B:36:0x016e, B:43:0x0187, B:39:0x0175, B:41:0x0180), top: B:136:0x0165, outer: #3, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0180 A[Catch: Exception -> 0x0187, TRY_LEAVE, TryCatch #6 {Exception -> 0x0187, blocks: (B:39:0x0175, B:41:0x0180), top: B:130:0x0175, outer: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a7 A[Catch: Exception -> 0x022f, TryCatch #2 {Exception -> 0x022f, blocks: (B:47:0x01a1, B:49:0x01a7, B:52:0x01af, B:54:0x01be, B:56:0x01c9, B:58:0x01d2, B:60:0x01d8, B:61:0x01ea, B:62:0x01f1, B:63:0x01f2, B:68:0x0203, B:70:0x020e, B:72:0x0214, B:73:0x022b), top: B:125:0x01a1, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01be A[Catch: Exception -> 0x022f, TryCatch #2 {Exception -> 0x022f, blocks: (B:47:0x01a1, B:49:0x01a7, B:52:0x01af, B:54:0x01be, B:56:0x01c9, B:58:0x01d2, B:60:0x01d8, B:61:0x01ea, B:62:0x01f1, B:63:0x01f2, B:68:0x0203, B:70:0x020e, B:72:0x0214, B:73:0x022b), top: B:125:0x01a1, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0214 A[Catch: Exception -> 0x022f, TryCatch #2 {Exception -> 0x022f, blocks: (B:47:0x01a1, B:49:0x01a7, B:52:0x01af, B:54:0x01be, B:56:0x01c9, B:58:0x01d2, B:60:0x01d8, B:61:0x01ea, B:62:0x01f1, B:63:0x01f2, B:68:0x0203, B:70:0x020e, B:72:0x0214, B:73:0x022b), top: B:125:0x01a1, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022b A[Catch: Exception -> 0x022f, TRY_LEAVE, TryCatch #2 {Exception -> 0x022f, blocks: (B:47:0x01a1, B:49:0x01a7, B:52:0x01af, B:54:0x01be, B:56:0x01c9, B:58:0x01d2, B:60:0x01d8, B:61:0x01ea, B:62:0x01f1, B:63:0x01f2, B:68:0x0203, B:70:0x020e, B:72:0x0214, B:73:0x022b), top: B:125:0x01a1, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x024b A[Catch: Exception -> 0x02ad, TRY_LEAVE, TryCatch #4 {Exception -> 0x02ad, blocks: (B:81:0x0245, B:83:0x024b, B:103:0x0282, B:111:0x02a6, B:106:0x0289, B:108:0x029d, B:114:0x02af, B:75:0x022f, B:47:0x01a1, B:49:0x01a7, B:52:0x01af, B:54:0x01be, B:56:0x01c9, B:58:0x01d2, B:60:0x01d8, B:61:0x01ea, B:62:0x01f1, B:63:0x01f2, B:68:0x0203, B:70:0x020e, B:72:0x0214, B:73:0x022b), top: B:127:0x01a1, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0272 A[Catch: Exception -> 0x02af, TRY_LEAVE, TryCatch #1 {Exception -> 0x02af, blocks: (B:86:0x0252, B:88:0x025c, B:93:0x0266, B:95:0x026c, B:97:0x0272), top: B:123:0x0252 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject d() throws org.json.JSONException, java.text.ParseException {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.apiprefetch.homepage.HomepageApiPrefetch.d():org.json.JSONObject");
    }
}
