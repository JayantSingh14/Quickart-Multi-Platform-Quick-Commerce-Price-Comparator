package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zzle implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;

    @VisibleForTesting
    volatile boolean zza = false;

    @Nullable
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;

    private final void zze(final SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            this.zzh = new JSONObject((String) zzlh.zza(new zzph() { // from class: com.google.ads.interactivemedia.v3.internal.zzlb
                @Override // com.google.ads.interactivemedia.v3.internal.zzph
                public final Object zza() {
                    return sharedPreferences.getString("flag_configuration", "{}");
                }
            }));
        } catch (JSONException unused) {
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zze(sharedPreferences);
        }
    }

    public final Object zza(final zzkx zzkxVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                try {
                    if (!this.zza) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } finally {
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null) {
                }
                return zzkxVar.zzk();
            }
        }
        if (zzkxVar.zzd() != 2) {
            return (zzkxVar.zzd() == 1 && this.zzh.has(zzkxVar.zzl())) ? zzkxVar.zza(this.zzh) : zzlh.zza(new zzph() { // from class: com.google.ads.interactivemedia.v3.internal.zzlc
                @Override // com.google.ads.interactivemedia.v3.internal.zzph
                public final Object zza() {
                    return this.zza.zzb(zzkxVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzkxVar.zzk() : zzkxVar.zzb(bundle);
    }

    public final /* synthetic */ Object zzb(zzkx zzkxVar) {
        return zzkxVar.zzc(this.zze);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b3 A[Catch: all -> 0x000f, TRY_ENTER, TryCatch #3 {all -> 0x000f, blocks: (B:7:0x0009, B:9:0x000d, B:13:0x0012, B:15:0x0017, B:16:0x0019, B:18:0x002b, B:19:0x002f, B:20:0x0031, B:47:0x00b3, B:48:0x00ba, B:56:0x00e1, B:57:0x00e8, B:59:0x00ea, B:60:0x00f1, B:22:0x0046, B:25:0x0050, B:31:0x005d, B:34:0x0068, B:35:0x0070, B:45:0x00af, B:50:0x00bc, B:52:0x00d3, B:54:0x00d7, B:55:0x00da, B:38:0x0081, B:40:0x008f, B:42:0x0097, B:43:0x00a2), top: B:71:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bc A[Catch: all -> 0x0058, TRY_ENTER, TryCatch #1 {all -> 0x0058, blocks: (B:22:0x0046, B:25:0x0050, B:31:0x005d, B:34:0x0068, B:35:0x0070, B:45:0x00af, B:50:0x00bc, B:52:0x00d3, B:54:0x00d7, B:55:0x00da, B:38:0x0081, B:40:0x008f, B:42:0x0097, B:43:0x00a2), top: B:67:0x0046, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzc(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzle.zzc(android.content.Context):void");
    }

    public final boolean zzd() {
        return this.zzi;
    }
}
