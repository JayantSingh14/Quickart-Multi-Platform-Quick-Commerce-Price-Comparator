package k;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f53510a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f53511b;

    /* renamed from: c, reason: collision with root package name */
    public final String f53512c;

    public c(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        this.f53510a = str;
        this.f53511b = context;
        String str2 = null;
        try {
            if (context != null) {
                try {
                    inputStreamOpen = context.getPackageManager().getResourcesForApplication(str).getAssets().open("api_key.txt");
                    try {
                        String strA = a(inputStreamOpen);
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        str2 = strA;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamOpen = null;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.getMessage();
        } catch (IOException e3) {
            e3.getMessage();
        }
        this.f53512c = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.InputStream r4) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            java.lang.String r2 = "UTF-8"
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.lang.String r0 = r4.readLine()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            if (r0 == 0) goto L25
            java.lang.String r2 = "\ufeff"
            boolean r2 = r0.startsWith(r2)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            if (r2 == 0) goto L25
            r2 = 1
            java.lang.String r0 = r0.substring(r2)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            goto L25
        L21:
            r0 = move-exception
            goto L34
        L23:
            r2 = move-exception
            goto L38
        L25:
            r1.close()     // Catch: java.io.IOException -> L29
            goto L2d
        L29:
            r1 = move-exception
            r1.getMessage()
        L2d:
            r4.close()     // Catch: java.io.IOException -> L32
            goto L6d
        L32:
            r4 = move-exception
            goto L68
        L34:
            r3 = r1
            r1 = r0
        L36:
            r0 = r3
            goto L6f
        L38:
            r3 = r1
            r1 = r0
            r0 = r3
            goto L53
        L3c:
            r4 = move-exception
            goto L41
        L3e:
            r4 = move-exception
            r2 = r4
            goto L45
        L41:
            r3 = r1
            r1 = r4
            r4 = r0
            goto L36
        L45:
            r4 = r0
            r0 = r1
        L47:
            r1 = r4
            goto L53
        L49:
            r4 = move-exception
            goto L4e
        L4b:
            r4 = move-exception
            r2 = r4
            goto L51
        L4e:
            r1 = r4
            r4 = r0
            goto L6f
        L51:
            r4 = r0
            goto L47
        L53:
            r2.getMessage()     // Catch: java.lang.Throwable -> L6e
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r0 = move-exception
            r0.getMessage()
        L60:
            if (r4 == 0) goto L6c
            r4.close()     // Catch: java.io.IOException -> L66
            goto L6c
        L66:
            r4 = move-exception
            r0 = r1
        L68:
            r4.getMessage()
            goto L6d
        L6c:
            r0 = r1
        L6d:
            return r0
        L6e:
            r1 = move-exception
        L6f:
            if (r0 == 0) goto L79
            r0.close()     // Catch: java.io.IOException -> L75
            goto L79
        L75:
            r0 = move-exception
            r0.getMessage()
        L79:
            if (r4 == 0) goto L83
            r4.close()     // Catch: java.io.IOException -> L7f
            goto L83
        L7f:
            r4 = move-exception
            r4.getMessage()
        L83:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.a(java.io.InputStream):java.lang.String");
    }
}
