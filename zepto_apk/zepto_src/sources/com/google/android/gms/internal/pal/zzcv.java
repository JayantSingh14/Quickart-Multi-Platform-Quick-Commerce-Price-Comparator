package com.google.android.gms.internal.pal;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzcv {

    /* renamed from: a, reason: collision with root package name */
    public String f37596a = "googleads.g.doubleclick.net";

    /* renamed from: b, reason: collision with root package name */
    public String f37597b = "/pagead/ads";

    /* renamed from: c, reason: collision with root package name */
    public String[] f37598c = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: d, reason: collision with root package name */
    public final zzcu f37599d;

    public zzcv(zzcu zzcuVar) {
        this.f37599d = zzcuVar;
    }

    public static Uri a(Uri uri, String str) throws zzcw {
        try {
            if (uri == null) {
                throw null;
            }
            try {
                if (uri.getHost().equals("ad.doubleclick.net")) {
                    if (uri.toString().contains("dc_ms=")) {
                        throw new zzcw("Parameter already exists: dc_ms");
                    }
                    String string = uri.toString();
                    int iIndexOf = string.indexOf(";adurl");
                    if (iIndexOf != -1) {
                        int i2 = iIndexOf + 1;
                        return Uri.parse(string.substring(0, i2) + "dc_ms=" + str + ";" + string.substring(i2));
                    }
                    String encodedPath = uri.getEncodedPath();
                    int iIndexOf2 = string.indexOf(encodedPath);
                    return Uri.parse(string.substring(0, encodedPath.length() + iIndexOf2) + ";dc_ms=" + str + ";" + string.substring(iIndexOf2 + encodedPath.length()));
                }
            } catch (NullPointerException unused) {
            }
            if (uri.getQueryParameter("ms") != null) {
                throw new zzcw("Query parameter already exists: ms");
            }
            String string2 = uri.toString();
            int iIndexOf3 = string2.indexOf("&adurl");
            if (iIndexOf3 == -1) {
                iIndexOf3 = string2.indexOf("?adurl");
            }
            if (iIndexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            int i3 = iIndexOf3 + 1;
            return Uri.parse(string2.substring(0, i3) + "ms=" + str + "&" + string2.substring(i3));
        } catch (UnsupportedOperationException unused2) {
            throw new zzcw("Provided Uri is not in a valid state");
        }
    }
}
