package com.google.ads.interactivemedia.v3.impl;

/* loaded from: classes3.dex */
final class zzbh implements zzbi {
    private zzbh() {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a8: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:169), block:B:42:0x00a8 */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    @Override // com.google.ads.interactivemedia.v3.impl.zzbi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.impl.data.zzck zza(com.google.ads.interactivemedia.v3.impl.data.zzcj r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> Laa java.io.IOException -> Lac
            java.lang.String r2 = r9.url()     // Catch: java.lang.Throwable -> Laa java.io.IOException -> Lac
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Laa java.io.IOException -> Lac
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> Laa java.io.IOException -> Lac
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> Laa java.io.IOException -> Lac
            java.lang.String r0 = "User-Agent"
            java.lang.String r2 = r9.userAgent()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r1.setRequestProperty(r0, r2)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            int r0 = r9.connectionTimeoutMs()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r1.setConnectTimeout(r0)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            int r0 = r9.readTimeoutMs()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r1.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            com.google.ads.interactivemedia.v3.impl.data.zzci r0 = r9.requestType()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            com.google.ads.interactivemedia.v3.impl.data.zzci r2 = com.google.ads.interactivemedia.v3.impl.data.zzci.POST     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            if (r0 != r2) goto L5e
            r0 = 1
            r1.setDoOutput(r0)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r0 = 0
            r1.setChunkedStreamingMode(r0)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            java.lang.String r0 = r9.content()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            if (r0 == 0) goto L5e
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L52
            byte[] r0 = r0.getBytes(r3)     // Catch: java.lang.Throwable -> L52
            r2.write(r0)     // Catch: java.lang.Throwable -> L52
            r2.close()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            goto L5e
        L4e:
            r9 = move-exception
            goto La8
        L50:
            r0 = move-exception
            goto Lb0
        L52:
            r0 = move-exception
            if (r2 == 0) goto L5d
            r2.close()     // Catch: java.lang.Throwable -> L59
            goto L5d
        L59:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        L5d:
            throw r0     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        L5e:
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L82
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L82
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L82
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L82
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L82
            r5.<init>(r2, r6)     // Catch: java.lang.Throwable -> L82
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L82
        L78:
            java.lang.String r2 = r4.readLine()     // Catch: java.lang.Throwable -> L82
            if (r2 == 0) goto L84
            r3.append(r2)     // Catch: java.lang.Throwable -> L82
            goto L78
        L82:
            r2 = move-exception
            goto L9d
        L84:
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L8d
            r0.close()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        L8d:
            java.lang.String r0 = r1.getContentType()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r1.disconnect()
            java.lang.String r9 = r9.id()
            com.google.ads.interactivemedia.v3.impl.data.zzck r9 = com.google.ads.interactivemedia.v3.impl.data.zzck.forResponse(r9, r2, r0)
            return r9
        L9d:
            if (r0 == 0) goto La7
            r0.close()     // Catch: java.lang.Throwable -> La3
            goto La7
        La3:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        La7:
            throw r2     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        La8:
            r0 = r1
            goto Lcf
        Laa:
            r9 = move-exception
            goto Lcf
        Lac:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        Lb0:
            boolean r0 = r0 instanceof java.net.SocketTimeoutException     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto Lbf
            java.lang.String r9 = r9.id()     // Catch: java.lang.Throwable -> L4e
            r0 = 101(0x65, float:1.42E-43)
            com.google.ads.interactivemedia.v3.impl.data.zzck r9 = com.google.ads.interactivemedia.v3.impl.data.zzck.forError(r9, r0)     // Catch: java.lang.Throwable -> L4e
            goto Lc9
        Lbf:
            java.lang.String r9 = r9.id()     // Catch: java.lang.Throwable -> L4e
            r0 = 100
            com.google.ads.interactivemedia.v3.impl.data.zzck r9 = com.google.ads.interactivemedia.v3.impl.data.zzck.forError(r9, r0)     // Catch: java.lang.Throwable -> L4e
        Lc9:
            if (r1 == 0) goto Lce
            r1.disconnect()
        Lce:
            return r9
        Lcf:
            if (r0 == 0) goto Ld4
            r0.disconnect()
        Ld4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.zzbh.zza(com.google.ads.interactivemedia.v3.impl.data.zzcj):com.google.ads.interactivemedia.v3.impl.data.zzck");
    }

    public /* synthetic */ zzbh(zzbg zzbgVar) {
    }
}
