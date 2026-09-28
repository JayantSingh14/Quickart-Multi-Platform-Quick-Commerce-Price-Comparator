package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public final class zzhg {
    private static final String[] zza = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzb = "googleads.g.doubleclick.net";
    private String zzc = "/pagead/ads";
    private final String zzd = "ad.doubleclick.net";
    private String[] zze = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzgz zzf;

    @Deprecated
    public zzhg(zzgz zzgzVar) {
        this.zzf = zzgzVar;
    }

    private final Uri zzh(Uri uri, String str) throws zzhh {
        try {
            if (uri == null) {
                throw null;
            }
            try {
                if (uri.getHost().equals(this.zzd)) {
                    if (uri.getPath().contains(";")) {
                        if (uri.toString().contains("dc_ms=")) {
                            throw new zzhh("Parameter already exists: dc_ms");
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
                }
            } catch (NullPointerException unused) {
            }
            if (uri.getQueryParameter("ms") != null) {
                throw new zzhh("Query parameter already exists: ms");
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
            throw new zzhh("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzhh {
        try {
            return zzh(uri, this.zzf.zze(context, uri.getQueryParameter("ai"), null, null));
        } catch (UnsupportedOperationException unused) {
            throw new zzhh("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzhh {
        return zzh(uri, ((zzhd) this.zzf).zzg(context, null));
    }

    @Deprecated
    public final void zzc(MotionEvent motionEvent) {
        this.zzf.zzk(motionEvent);
    }

    public final void zzd(String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
    }

    public final void zze(String str) {
        this.zze = str.split(",");
    }

    public final boolean zzf(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            for (String str : this.zze) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final boolean zzg(Uri uri) {
        uri.getClass();
        try {
            if (uri.getHost().equals(this.zzb)) {
                if (uri.getPath().equals(this.zzc)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }
}
