package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class zzcw {
    private static int zza = 2;

    public static void zza(@NonNull Context context) {
        context.registerReceiver(new zzcv(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }

    public static int zzb() {
        if (zzcs.zza() != com.google.ads.interactivemedia.omid.library.adsession.zzg.CTV) {
            return 2;
        }
        return zza;
    }
}
