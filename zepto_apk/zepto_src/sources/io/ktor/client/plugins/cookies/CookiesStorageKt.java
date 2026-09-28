package io.ktor.client.plugins.cookies;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class CookiesStorageKt {
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean a(io.ktor.http.Cookie r9, io.ktor.http.Url r10) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            java.lang.String r3 = "requestUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r3)
            java.lang.String r3 = r9.f50137f
            if (r3 == 0) goto Lca
            java.lang.String r3 = io.ktor.util.TextKt.b(r3)
            if (r3 == 0) goto Lca
            char[] r4 = new char[r1]
            r5 = 46
            r4[r0] = r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "chars"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            int r2 = r3.length()
            r5 = r0
        L29:
            if (r5 >= r2) goto L40
            char r6 = r3.charAt(r5)
            boolean r6 = kotlin.collections.ArraysKt.e(r4, r6)
            if (r6 != 0) goto L3e
            int r2 = r3.length()
            java.lang.CharSequence r2 = r3.subSequence(r5, r2)
            goto L42
        L3e:
            int r5 = r5 + r1
            goto L29
        L40:
            java.lang.String r2 = ""
        L42:
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto Lca
            java.lang.String r3 = r9.f50138g
            if (r3 == 0) goto Lc2
            r4 = 47
            boolean r5 = kotlin.text.StringsKt.s(r3, r4)
            java.lang.String r6 = "/"
            if (r5 == 0) goto L57
            goto L5b
        L57:
            java.lang.String r3 = r3.concat(r6)
        L5b:
            java.lang.String r5 = r10.f50261b
            java.lang.String r5 = io.ktor.util.TextKt.b(r5)
            kotlin.Lazy r7 = r10.f50269j
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = (java.lang.String) r7
            boolean r4 = kotlin.text.StringsKt.s(r7, r4)
            if (r4 == 0) goto L70
            goto L74
        L70:
            java.lang.String r7 = r7.concat(r6)
        L74:
            boolean r4 = kotlin.jvm.internal.Intrinsics.b(r5, r2)
            if (r4 != 0) goto La0
            io.ktor.http.parsing.regex.RegexParser r4 = io.ktor.http.IpParserKt.f50231a
            java.lang.String r4 = "host"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            io.ktor.http.parsing.regex.RegexParser r4 = io.ktor.http.IpParserKt.f50231a
            r4.getClass()
            java.lang.String r8 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
            kotlin.text.Regex r4 = r4.f50312a
            boolean r4 = r4.c(r5)
            if (r4 != 0) goto Lc0
            java.lang.String r4 = "."
            java.lang.String r2 = r4.concat(r2)
            boolean r2 = kotlin.text.StringsKt.r(r5, r2, r0)
            if (r2 != 0) goto La0
            goto Lc0
        La0:
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r3, r6)
            if (r2 != 0) goto Lb3
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r7, r3)
            if (r2 != 0) goto Lb3
            boolean r2 = kotlin.text.StringsKt.O(r7, r3, r0)
            if (r2 != 0) goto Lb3
            goto Lc0
        Lb3:
            boolean r9 = r9.f50139h
            if (r9 == 0) goto Lc1
            io.ktor.http.URLProtocol r9 = r10.f50260a
            boolean r9 = io.ktor.http.URLProtocolKt.a(r9)
            if (r9 == 0) goto Lc0
            goto Lc1
        Lc0:
            return r0
        Lc1:
            return r1
        Lc2:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Path field should have the default value"
            r9.<init>(r10)
            throw r9
        Lca:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Domain field should have the default value"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.CookiesStorageKt.a(io.ktor.http.Cookie, io.ktor.http.Url):boolean");
    }
}
