package com.google.ads.interactivemedia.pal;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.pal.zzagc;

/* loaded from: classes3.dex */
public final class zzav {
    private final Handler zza;
    private final zzagc zzb;

    @Nullable
    private Runnable zzc;

    public zzav(Handler handler, zzagc zzagcVar) {
        this.zza = handler;
        this.zzb = zzagcVar;
    }

    public final void finalize() throws Throwable {
        zzd();
        super.finalize();
    }

    public final void zzc(Runnable runnable) {
        if (this.zzc != null) {
            return;
        }
        zzau zzauVar = new zzau(this, runnable);
        this.zzc = zzauVar;
        this.zza.postDelayed(zzauVar, this.zzb.f37520a);
    }

    public final void zzd() {
        Runnable runnable = this.zzc;
        if (runnable == null) {
            return;
        }
        this.zza.removeCallbacks(runnable);
        this.zzc = null;
    }
}
