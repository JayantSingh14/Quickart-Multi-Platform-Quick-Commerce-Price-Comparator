package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class zzed implements zzef {
    private final String zza;

    public zzed(String str) {
        this.zza = str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzef
    public final boolean zza(zzee zzeeVar, Context context, boolean z, boolean z2) {
        String host;
        if (z || !z2 || !this.zza.contains("GOOGLE_INSTREAM_VIDEO_NONCE")) {
            return false;
        }
        String str = this.zza;
        List list = zzeeVar.zzc;
        if (str == null || list == null || (host = Uri.parse(str).getHost()) == null) {
            return true;
        }
        if (host.startsWith("www.")) {
            host = host.substring(4);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Objects.equals(host, (String) it.next())) {
                return false;
            }
        }
        return true;
    }
}
