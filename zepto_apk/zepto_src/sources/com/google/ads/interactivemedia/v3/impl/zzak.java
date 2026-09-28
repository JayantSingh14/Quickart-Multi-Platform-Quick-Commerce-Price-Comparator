package com.google.ads.interactivemedia.v3.impl;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.internal.zzel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzak {
    private final List zza;

    @Nullable
    private final zzel zzb;

    public zzak() {
        this.zza = Collections.synchronizedList(new ArrayList(1));
        this.zzb = null;
    }

    public final String toString() {
        return b.D("ErrorListenerSupport [errorListeners=", String.valueOf(this.zza), "]");
    }

    public final void zza(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zza.add(adErrorListener);
    }

    public final void zzb() {
        this.zza.clear();
    }

    public final void zzc(AdErrorEvent adErrorEvent) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((AdErrorEvent.AdErrorListener) it.next()).onAdError(adErrorEvent);
        }
        zzel zzelVar = this.zzb;
        if (zzelVar != null) {
            zzelVar.zzc(adErrorEvent);
        }
    }

    public final void zzd(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zza.remove(adErrorListener);
    }

    public zzak(zzel zzelVar) {
        this.zza = Collections.synchronizedList(new ArrayList(1));
        this.zzb = zzelVar;
    }
}
