package g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f48419a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48420b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f48421c;

    public i(int i2, String str, HashMap map) {
        this.f48419a = i2;
        this.f48420b = str;
        this.f48421c = map;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0041
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static java.lang.String a(javax.net.ssl.HttpsURLConnection r6) {
        /*
            java.io.InputStream r0 = r6.getInputStream()     // Catch: java.io.IOException -> L5
            goto L9
        L5:
            java.io.InputStream r0 = r6.getErrorStream()
        L9:
            r1 = 0
            if (r0 != 0) goto Ld
            return r1
        Ld:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L3c
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L3c
            java.lang.String r5 = "UTF-8"
            r4.<init>(r0, r5)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L3c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L3c
        L1e:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L30
            if (r1 == 0) goto L2a
            r2.append(r1)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L30
            goto L1e
        L28:
            r6 = move-exception
            goto L2e
        L2a:
            r3.close()     // Catch: java.io.IOException -> L41
            goto L41
        L2e:
            r1 = r3
            goto L33
        L30:
            r1 = r3
            goto L3c
        L32:
            r6 = move-exception
        L33:
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.io.IOException -> L38
        L38:
            r0.close()     // Catch: java.io.IOException -> L3b
        L3b:
            throw r6
        L3c:
            if (r1 == 0) goto L41
            r1.close()     // Catch: java.io.IOException -> L41
        L41:
            r0.close()     // Catch: java.io.IOException -> L44
        L44:
            java.lang.String r0 = r2.toString()
            java.net.URL r6 = r6.getURL()
            r6.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.i.a(javax.net.ssl.HttpsURLConnection):java.lang.String");
    }

    public static HashMap b(HttpsURLConnection httpsURLConnection) {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<String>> entry : httpsURLConnection.getHeaderFields().entrySet()) {
            map.put(entry.getKey(), TextUtils.join(", ", entry.getValue()));
            entry.getKey();
        }
        return map;
    }
}
