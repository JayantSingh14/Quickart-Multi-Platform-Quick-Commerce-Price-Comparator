package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;

@Metadata
@JvmName
/* loaded from: classes.dex */
public final class HttpHeaders {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f56576a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f56577b;

    static {
        ByteString byteString = ByteString.f56924d;
        f56576a = ByteString.Companion.c("\"\\");
        f56577b = ByteString.Companion.c("\t ,=");
    }

    public static final boolean a(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        if (Intrinsics.b(response.f56350a.f56332b, "HEAD")) {
            return false;
        }
        int i2 = response.f56353d;
        return (((i2 >= 100 && i2 < 200) || i2 == 204 || i2 == 304) && Util.k(response) == -1 && !"chunked".equalsIgnoreCase(response.b("Transfer-Encoding", null))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0108, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0108, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(okio.Buffer r17, java.util.ArrayList r18) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.b(okio.Buffer, java.util.ArrayList):void");
    }

    public static final String c(Buffer buffer) {
        long jT = buffer.T(f56577b);
        if (jT == -1) {
            jT = buffer.f56914b;
        }
        if (jT != 0) {
            return buffer.T0(jT, Charsets.UTF_8);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x01db, code lost:
    
        if (okhttp3.internal.Util.f56399f.c(r0) == false) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(okhttp3.CookieJar r38, okhttp3.HttpUrl r39, okhttp3.Headers r40) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.d(okhttp3.CookieJar, okhttp3.HttpUrl, okhttp3.Headers):void");
    }

    public static final boolean e(Buffer buffer) {
        boolean z = false;
        while (!buffer.l()) {
            byte bX = buffer.x(0L);
            if (bX == 44) {
                buffer.k0();
                z = true;
            } else {
                if (bX != 32 && bX != 9) {
                    break;
                }
                buffer.k0();
            }
        }
        return z;
    }
}
