package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class zzby extends zzcb {

    @SuppressLint({"StaticFieldLeak"})
    private static final zzby zzb = new zzby();

    private zzby() {
    }

    public static zzby zza() {
        return zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzcb
    public final void zzb(boolean z) {
        Iterator it = zzbz.zza().zzc().iterator();
        while (it.hasNext()) {
            ((com.google.ads.interactivemedia.omid.library.adsession.zze) it.next()).zzh().zzk(z);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzcb
    public final boolean zzc() {
        Iterator it = zzbz.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzg = ((com.google.ads.interactivemedia.omid.library.adsession.zze) it.next()).zzg();
            if (viewZzg != null && viewZzg.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
