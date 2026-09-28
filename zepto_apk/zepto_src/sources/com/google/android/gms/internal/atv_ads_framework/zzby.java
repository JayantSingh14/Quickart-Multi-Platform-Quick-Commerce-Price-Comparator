package com.google.android.gms.internal.atv_ads_framework;

import com.reactnativecommunity.clipboard.ClipboardModule;
import java.util.Iterator;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes4.dex */
public final class zzby {

    /* renamed from: a, reason: collision with root package name */
    public static final zzbi f36084a = zzbi.o(4, "http", "https", "mailto", "ftp");

    /* renamed from: b, reason: collision with root package name */
    public static final zzbi f36085b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzbi f36086c;

    static {
        String[] strArr = {"audio/mpeg", "audio/oga", "audio/ogg", "audio/opus", "audio/x-m4a", "audio/x-matroska", "audio/x-wav", "audio/wav", "audio/webm", "image/bmp", "image/gif", "image/jpeg", ClipboardModule.MIMETYPE_JPG, ClipboardModule.MIMETYPE_PNG, "image/svg+xml", "image/tiff", "image/webp", "image/x-icon", "video/mpeg", "video/mp4", "video/ogg", "video/webm", "video/x-matroska"};
        Object[] objArr = new Object[29];
        objArr[0] = "audio/3gpp2";
        objArr[1] = "audio/3gpp";
        objArr[2] = "audio/aac";
        objArr[3] = "audio/midi";
        objArr[4] = "audio/mp3";
        objArr[5] = "audio/mp4";
        System.arraycopy(strArr, 0, objArr, 6, 23);
        f36085b = zzbi.o(29, objArr);
        f36086c = zzbr.f36075i;
    }

    public static String a(String str) {
        zzay zzayVar;
        char cCharAt;
        int i2;
        char cCharAt2;
        char cCharAt3;
        zzbi zzbiVar = f36086c;
        String strA = zzaf.a(str);
        zzbu it = f36084a.iterator();
        while (it.hasNext()) {
            if (strA.startsWith(String.valueOf((String) it.next()).concat(":"))) {
                return str;
            }
        }
        if (!strA.startsWith("data:")) {
            Iterator it2 = ((zzbr) zzbiVar).iterator();
            do {
                zzayVar = (zzay) it2;
                if (!zzayVar.hasNext()) {
                    for (int i3 = 0; i3 < str.length() && (cCharAt = str.charAt(i3)) != '#' && cCharAt != '/'; i3++) {
                        if (cCharAt != ':') {
                            if (cCharAt == '?') {
                                return str;
                            }
                        }
                    }
                    return str;
                }
            } while (!strA.startsWith(String.valueOf(zzaf.a(((zzbx) zzayVar.next()).name()).replace('_', Soundex.SILENT_MARKER)).concat(":")));
            return str;
        }
        String strA2 = zzaf.a(str);
        if (strA2.startsWith("data:") && strA2.length() > 5) {
            int i4 = 5;
            while (i4 < strA2.length() && (cCharAt3 = strA2.charAt(i4)) != ';' && cCharAt3 != ',') {
                i4++;
            }
            if (f36085b.contains(strA2.substring(5, i4)) && strA2.startsWith(";base64,", i4) && (i2 = i4 + 8) < strA2.length()) {
                while (i2 < strA2.length() && (cCharAt2 = strA2.charAt(i2)) != '=') {
                    if ((cCharAt2 < 'a' || cCharAt2 > 'z') && !((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '+' || cCharAt2 == '/')) {
                        break;
                    }
                    i2++;
                }
                while (i2 < strA2.length()) {
                    if (strA2.charAt(i2) == '=') {
                        i2++;
                    }
                }
                return str;
            }
        }
        return "about:invalid#zTvAdsFrameworkz";
    }
}
