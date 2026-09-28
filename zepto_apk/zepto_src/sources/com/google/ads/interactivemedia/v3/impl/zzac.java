package com.google.ads.interactivemedia.v3.impl;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.BaseManager;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzcp;
import com.google.ads.interactivemedia.v3.internal.zzdt;
import com.google.ads.interactivemedia.v3.internal.zzdu;
import com.google.ads.interactivemedia.v3.internal.zzdv;
import com.google.ads.interactivemedia.v3.internal.zzfl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class zzac implements BaseManager, zzat, zzdu {
    private final zzav zza;
    private final String zzb;
    private final List zzc;
    private final zzak zzd;
    private final Context zze;
    private final zzb zzf;
    private final zzbm zzg;
    private final zzbv zzh;

    @Nullable
    private com.google.ads.interactivemedia.v3.impl.data.zzc zzi;

    @Nullable
    private com.google.ads.interactivemedia.v3.api.zza zzj;

    @Nullable
    private AdProgressInfo zzk;
    private AdsRenderingSettings zzl;
    private boolean zzm;
    private final zzfl zzn;

    @Nullable
    private zzdv zzo;

    public zzac(String str, zzav zzavVar, zzbv zzbvVar, BaseDisplayContainer baseDisplayContainer, zzb zzbVar, zzbm zzbmVar, zzak zzakVar, Context context, boolean z) {
        ArrayList arrayList = new ArrayList(1);
        this.zzc = arrayList;
        this.zzm = false;
        this.zzb = str;
        this.zza = zzavVar;
        this.zzh = zzbvVar;
        this.zze = context;
        this.zzd = zzakVar;
        this.zzl = new com.google.ads.interactivemedia.v3.impl.data.zzh();
        this.zzf = zzbVar;
        zzbVar.zzj(z);
        if (zzbmVar == null) {
            zzbmVar = null;
        } else {
            zzbmVar.zzg(str);
            zzbmVar.zzd(baseDisplayContainer.getAdContainer());
            arrayList.add(zzbmVar);
            zzakVar.zza(zzbmVar);
            zzab zzabVar = (zzab) baseDisplayContainer;
            Iterator it = zzabVar.zzb().iterator();
            while (it.hasNext()) {
                zzbmVar.zzc((FriendlyObstruction) it.next());
            }
            zzabVar.zzc(zzbmVar);
        }
        this.zzg = zzbmVar;
        this.zzn = new zzfl(context, this.zzl);
        zzavVar.zzg(this, str);
        zzavVar.zzi(this.zzh, str);
        zzbVar.zzf();
        Application applicationZza = zzdt.zza(context);
        if (applicationZza != null) {
            zzdv zzdvVar = new zzdv(applicationZza);
            this.zzo = zzdvVar;
            zzdvVar.zza(this);
        }
    }

    private final void zza(String str) {
        if (zzdt.zzc(this.zze, this.zza.zzb())) {
            this.zza.zza().requestFocus();
            this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.userInteraction, JavaScriptMessage.MsgType.focusUiElement, str, null));
        }
    }

    private final boolean zzr() {
        return this.zzl.getFocusSkipButtonWhenAvailable();
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zzd.zza(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void addAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.zzc.add(adEventListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public void destroy() {
        this.zzm = true;
        this.zzg.zzi();
        this.zzf.zzg();
        this.zzf.zzk();
        zzdv zzdvVar = this.zzo;
        if (zzdvVar != null) {
            zzdvVar.zzb();
        }
        this.zzh.zzc();
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void focus() {
        zza(this.zzb);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.zzm ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : this.zzh.getAdProgress();
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final AdProgressInfo getAdProgressInfo() {
        return this.zzk;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final Ad getCurrentAd() {
        return this.zzi;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void init() {
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsManager, JavaScriptMessage.MsgType.init, this.zzb, zzb(this.zzl)));
        this.zzh.zzd();
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zzd.zzd(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void removeAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.zzc.remove(adEventListener);
    }

    public Map zzb(AdsRenderingSettings adsRenderingSettings) {
        HashMap map = new HashMap();
        map.put("adsRenderingSettings", com.google.ads.interactivemedia.v3.impl.data.zzg.builder(adsRenderingSettings).build());
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zzc(com.google.ads.interactivemedia.v3.impl.zzas r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.zzac.zzc(com.google.ads.interactivemedia.v3.impl.zzas):void");
    }

    public final zzbv zzd() {
        return this.zzh;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    public final void zze(AdError.AdErrorType adErrorType, int i2, String str) {
        zzf(adErrorType, AdError.AdErrorCode.getErrorCodeByNumber(i2), str);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzf(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str) {
        this.zzk = null;
        this.zzd.zzc(new zzd(new AdError(adErrorType, adErrorCode, str)));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzdu
    public final void zzg() {
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsManager, JavaScriptMessage.MsgType.appBackgrounding, this.zzb, null));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzdu
    public final void zzh() {
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsManager, JavaScriptMessage.MsgType.appForegrounding, this.zzb, null));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzi(String str) {
        if (this.zzn.zzb(str)) {
            return;
        }
        zzp(JavaScriptMessage.MsgType.navigationRequestedFailed);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(android.view.ViewGroup r9, com.google.ads.interactivemedia.v3.impl.data.zzbk r10, java.lang.String r11, com.google.ads.interactivemedia.v3.api.CompanionAdSlot r12, com.google.ads.interactivemedia.v3.impl.zzav r13, com.google.ads.interactivemedia.v3.internal.zzek r14) {
        /*
            r8 = this;
            r9.removeAllViews()
            com.google.ads.interactivemedia.v3.impl.zzad r12 = (com.google.ads.interactivemedia.v3.impl.zzad) r12
            java.util.List r5 = r12.zza()
            com.google.ads.interactivemedia.v3.impl.data.zzbj r0 = com.google.ads.interactivemedia.v3.impl.data.zzbj.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            com.google.ads.interactivemedia.v3.impl.data.zzbj r0 = r10.type()
            int r0 = r0.ordinal()
            if (r0 == 0) goto L20
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L24
            if (r0 == r2) goto L20
            r4 = r11
            goto L6e
        L20:
            r2 = r10
            r4 = r11
            r1 = r13
            goto L64
        L24:
            android.content.Context r0 = r9.getContext()
            java.lang.String r4 = r10.src()
            java.lang.String r6 = r10.size()
            if (r6 != 0) goto L33
            goto L56
        L33:
            java.lang.String r1 = "x"
            r7 = -1
            java.lang.String[] r1 = r6.split(r1, r7)
            int r6 = r1.length
            r7 = 0
            if (r6 == r2) goto L44
            com.google.ads.interactivemedia.v3.impl.data.zzbw r1 = new com.google.ads.interactivemedia.v3.impl.data.zzbw
            r1.<init>(r7, r7)
            goto L56
        L44:
            com.google.ads.interactivemedia.v3.impl.data.zzbw r2 = new com.google.ads.interactivemedia.v3.impl.data.zzbw
            r6 = r1[r7]
            int r6 = java.lang.Integer.parseInt(r6)
            r1 = r1[r3]
            int r1 = java.lang.Integer.parseInt(r1)
            r2.<init>(r6, r1)
            r1 = r2
        L56:
            com.google.android.gms.tasks.Task r3 = r14.zzb(r4, r1)
            com.google.ads.interactivemedia.v3.internal.zzfl r6 = r8.zzn
            r2 = r10
            r4 = r11
            r1 = r13
            com.google.ads.interactivemedia.v3.impl.zzao r1 = com.google.ads.interactivemedia.v3.impl.zzao.zza(r0, r1, r2, r3, r4, r5, r6)
            goto L6e
        L64:
            android.content.Context r10 = r9.getContext()
            com.google.ads.interactivemedia.v3.internal.zzfl r11 = r8.zzn
            com.google.ads.interactivemedia.v3.impl.zzag r1 = com.google.ads.interactivemedia.v3.impl.zzag.zza(r10, r1, r2, r5, r11)
        L6e:
            if (r1 == 0) goto L79
            r1.setTag(r4)
            r12.zzb(r4)
            r9.addView(r1)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.zzac.zzj(android.view.ViewGroup, com.google.ads.interactivemedia.v3.impl.data.zzbk, java.lang.String, com.google.ads.interactivemedia.v3.api.CompanionAdSlot, com.google.ads.interactivemedia.v3.impl.zzav, com.google.ads.interactivemedia.v3.internal.zzek):void");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzk(zzcp zzcpVar) {
        this.zzh.zzg(zzcpVar);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzl() {
        this.zzh.zzh();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzat
    public final void zzm(com.google.ads.interactivemedia.v3.api.zza zzaVar) {
        this.zzj = zzaVar;
        com.google.ads.interactivemedia.v3.impl.data.zzc zzcVar = this.zzi;
        if (zzcVar != null) {
            zzcVar.setAdUi(zzaVar);
        }
    }

    public final void zzn() {
        this.zza.zzo(this.zzb);
        this.zzc.clear();
        this.zzd.zzb();
    }

    public final void zzo(JavaScriptMessage.MsgChannel msgChannel, JavaScriptMessage.MsgType msgType, Object obj) {
        this.zza.zzp(new JavaScriptMessage(msgChannel, msgType, this.zzb, obj));
    }

    public final void zzp(JavaScriptMessage.MsgType msgType) {
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsManager, msgType, this.zzb, null));
    }

    @VisibleForTesting
    public final void zzq(com.google.ads.interactivemedia.v3.impl.data.zzc zzcVar) {
        this.zzi = zzcVar;
        if (zzcVar != null) {
            zzcVar.setAdUi(this.zzj);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseManager
    public final void init(AdsRenderingSettings adsRenderingSettings) {
        if (adsRenderingSettings != null) {
            this.zzl = adsRenderingSettings;
            this.zzn.zza(adsRenderingSettings);
        }
        Map mapZzb = zzb(this.zzl);
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsManager, JavaScriptMessage.MsgType.init, this.zzb, mapZzb));
        this.zzh.zzd();
    }
}
