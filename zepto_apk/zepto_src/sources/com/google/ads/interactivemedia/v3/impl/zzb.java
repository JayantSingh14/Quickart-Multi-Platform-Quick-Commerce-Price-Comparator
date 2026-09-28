package com.google.ads.interactivemedia.v3.impl;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.internal.zzdt;
import com.google.ads.interactivemedia.v3.internal.zzfj;

/* loaded from: classes3.dex */
public final class zzb implements zzaq {
    private final zzav zza;
    private final String zzb;
    private final View zzc;

    @Nullable
    private zza zzd;

    @Nullable
    private Activity zze;
    private boolean zzf;
    private final zzfj zzg;

    public zzb(String str, zzav zzavVar, View view) {
        zzfj zzfjVar = new zzfj();
        this.zzb = str;
        this.zza = zzavVar;
        this.zzc = view;
        this.zzg = zzfjVar;
        this.zze = null;
        this.zzd = null;
        this.zzf = false;
    }

    private final DisplayMetrics zzl() {
        return this.zzc.getContext().getResources().getDisplayMetrics();
    }

    private static com.google.ads.interactivemedia.v3.impl.data.zzbh zzm(com.google.ads.interactivemedia.v3.impl.data.zzbh zzbhVar, float f2) {
        com.google.ads.interactivemedia.v3.impl.data.zzbg zzbgVarBuilder = com.google.ads.interactivemedia.v3.impl.data.zzbh.builder();
        zzbgVarBuilder.left((int) Math.ceil(zzbhVar.left() / f2));
        zzbgVarBuilder.top((int) Math.ceil(zzbhVar.top() / f2));
        zzbgVarBuilder.height((int) Math.ceil(zzbhVar.height() / f2));
        zzbgVarBuilder.width((int) Math.ceil(zzbhVar.width() / f2));
        return zzbgVarBuilder.build();
    }

    public final com.google.ads.interactivemedia.v3.impl.data.zzb zzc(String str, String str2, String str3) {
        com.google.ads.interactivemedia.v3.impl.data.zzbh zzbhVarZzm = zzm(com.google.ads.interactivemedia.v3.impl.data.zzbh.builder().locationOnScreenOfView(this.zzc).build(), zzl().density);
        Rect rect = new Rect();
        boolean globalVisibleRect = this.zzc.getGlobalVisibleRect(rect);
        IBinder windowToken = this.zzc.getWindowToken();
        if (!globalVisibleRect || windowToken == null || !this.zzc.isShown()) {
            rect.set(0, 0, 0, 0);
        }
        com.google.ads.interactivemedia.v3.impl.data.zzbg zzbgVarBuilder = com.google.ads.interactivemedia.v3.impl.data.zzbh.builder();
        zzbgVarBuilder.left(rect.left);
        zzbgVarBuilder.top(rect.top);
        zzbgVarBuilder.height(rect.height());
        zzbgVarBuilder.width(rect.width());
        com.google.ads.interactivemedia.v3.impl.data.zzbh zzbhVarZzm2 = zzm(zzbgVarBuilder.build(), zzl().density);
        boolean z = (this.zzc.getGlobalVisibleRect(new Rect()) && this.zzc.isShown()) ? false : true;
        double streamVolume = ((AudioManager) this.zzc.getContext().getSystemService("audio")) != null ? r2.getStreamVolume(3) / r2.getStreamMaxVolume(3) : 0.0d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.google.ads.interactivemedia.v3.impl.data.zza zzaVarBuilder = com.google.ads.interactivemedia.v3.impl.data.zzb.builder();
        zzaVarBuilder.queryId(str);
        zzaVarBuilder.eventId(str2);
        zzaVarBuilder.appState(str3);
        zzaVarBuilder.nativeTime(jCurrentTimeMillis);
        zzaVarBuilder.nativeVolume(streamVolume);
        zzaVarBuilder.nativeViewHidden(z);
        zzaVarBuilder.nativeViewBounds(zzbhVarZzm);
        zzaVarBuilder.nativeViewVisibleBounds(zzbhVarZzm2);
        return zzaVarBuilder.build();
    }

    public final void zzf() {
        this.zza.zzd(this, this.zzb);
    }

    public final void zzg() {
        this.zza.zzn(this.zzb);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzaq
    public final void zzh(String str, String str2) {
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.activityMonitor, JavaScriptMessage.MsgType.viewability, this.zzb, zzc(str, str2, "")));
    }

    public final void zzi() {
        Application applicationZza;
        if (!this.zzf || (applicationZza = zzdt.zza(this.zzc.getContext())) == null) {
            return;
        }
        zza zzaVar = new zza(this);
        this.zzd = zzaVar;
        applicationZza.registerActivityLifecycleCallbacks(zzaVar);
    }

    public final void zzj(boolean z) {
        this.zzf = z;
    }

    public final void zzk() {
        zza zzaVar;
        Application applicationZza = zzdt.zza(this.zzc.getContext());
        if (applicationZza == null || (zzaVar = this.zzd) == null) {
            return;
        }
        applicationZza.unregisterActivityLifecycleCallbacks(zzaVar);
    }
}
