package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzakk {
    public static String a(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        String str = null;
        boolean z = false;
        while (it.hasNext()) {
            String str2 = ((zzaky) it.next()).f23439a.f23415g.f35691m;
            if (zzas.b(str2)) {
                return "video/mp4";
            }
            if (zzas.a(str2)) {
                z = true;
            } else if (zzas.c(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z ? "audio/mp4" : str != null ? str : "application/mp4";
    }
}
