package io.ktor.client.plugins.cache;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.DateUtilsKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpCacheEntryKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.client.statement.HttpResponse r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = (io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1) r0
            int r1 = r0.f49730c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49730c = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = new io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f49729b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49730c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.client.statement.HttpResponse r4 = r0.f49728a
            kotlin.ResultKt.b(r5)
            goto L48
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            io.ktor.utils.io.ByteReadChannel r5 = r4.a()
            r0.f49728a = r4
            r0.f49730c = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r5 = r5.n(r2, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            byte[] r5 = io.ktor.utils.io.core.StringsKt.c(r5)
            io.ktor.client.statement.HttpResponseKt.c(r4)
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = new io.ktor.client.plugins.cache.HttpCacheEntry
            io.ktor.util.date.GMTDate r1 = b(r4)
            java.util.Map r2 = c(r4)
            r0.<init>(r1, r2, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.a(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static GMTDate b(HttpResponse httpResponse) {
        Object next;
        String str;
        List listSplit$default;
        String str2;
        HttpCacheEntryKt$cacheExpires$1 fallback = HttpCacheEntryKt$cacheExpires$1.f49731c;
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Iterator it = HttpMessagePropertiesKt.a(httpResponse).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (StringsKt.O(((HeaderValue) next).f50192a, "max-age", false)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) next;
        Long lA0 = (headerValue == null || (str = headerValue.f50192a) == null || (listSplit$default = StringsKt__StringsKt.split$default(str, new String[]{"="}, false, 0, 6, null)) == null || (str2 = (String) listSplit$default.get(1)) == null) ? null : StringsKt.a0(str2);
        if (lA0 != null) {
            GMTDate gMTDateC = httpResponse.c();
            long jLongValue = lA0.longValue() * 1000;
            Intrinsics.checkNotNullParameter(gMTDateC, "<this>");
            return DateJvmKt.b(Long.valueOf(gMTDateC.f50543i + jLongValue));
        }
        Headers headers = httpResponse.getHeaders();
        List list = HttpHeaders.f50204a;
        String strB = headers.b("Expires");
        if (strB == null) {
            return DateJvmKt.b(null);
        }
        if (strB.equals("0") || StringsKt.z(strB)) {
            return DateJvmKt.b(null);
        }
        try {
            return DateUtilsKt.a(strB);
        } catch (Throwable unused) {
            return DateJvmKt.b(null);
        }
    }

    public static final Map c(HttpResponse httpResponse) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Headers headers = httpResponse.getHeaders();
        List list = HttpHeaders.f50204a;
        List listA = headers.a("Vary");
        if (listA != null) {
            arrayList = new ArrayList();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                List listSplit$default = StringsKt__StringsKt.split$default((String) it.next(), new String[]{","}, false, 0, 6, null);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(listSplit$default, 10));
                Iterator it2 = listSplit$default.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(StringsKt.b0((String) it2.next()).toString());
                }
                CollectionsKt.i(arrayList, arrayList2);
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return MapsKt.c();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers headers2 = httpResponse.o1().d().getHeaders();
        for (String str : arrayList) {
            String strB = headers2.b(str);
            if (strB == null) {
                strB = "";
            }
            linkedHashMap.put(str, strB);
        }
        return linkedHashMap;
    }
}
