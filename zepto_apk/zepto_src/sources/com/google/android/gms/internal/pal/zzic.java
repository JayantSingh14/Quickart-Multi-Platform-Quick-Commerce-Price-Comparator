package com.google.android.gms.internal.pal;

import java.net.HttpURLConnection;

/* loaded from: classes4.dex */
public final class zzic extends zzhw {

    /* renamed from: a, reason: collision with root package name */
    public zzis f37807a;

    /* renamed from: b, reason: collision with root package name */
    public HttpURLConnection f37808b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        HttpURLConnection httpURLConnection = this.f37808b;
        zzhv zzhvVar = zzhx.f37805a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
