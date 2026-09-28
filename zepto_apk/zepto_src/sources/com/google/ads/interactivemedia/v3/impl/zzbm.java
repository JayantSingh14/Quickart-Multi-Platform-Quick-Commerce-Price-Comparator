package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.support.v4.media.b;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzco;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zzbm implements AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, zzaa, zzau {
    private final zzav zza;
    private final zzbl zzb;
    private final Context zzc;

    @Nullable
    private View zzd;

    @Nullable
    private String zze;
    private final Set zzf;
    private boolean zzg;
    private boolean zzh;

    @Nullable
    private String zzi;

    @Nullable
    private com.google.ads.interactivemedia.omid.library.adsession.zza zzj;

    public zzbm(zzav zzavVar, Context context) {
        zzbl zzblVar = new zzbl();
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
        this.zza = zzavVar;
        this.zzc = context;
        this.zzb = zzblVar;
        this.zzf = new HashSet();
    }

    private final void zzj(List list) {
        zzco zzcoVarBuild;
        if (list == null) {
            zzcoVarBuild = null;
        } else if (list.isEmpty()) {
            return;
        } else {
            zzcoVarBuild = zzco.builder().friendlyObstructions(list).build();
        }
        this.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.omid, JavaScriptMessage.MsgType.registerFriendlyObstructions, this.zze, zzcoVarBuild));
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        com.google.ads.interactivemedia.omid.library.adsession.zza zzaVar;
        if (!this.zzg || (zzaVar = this.zzj) == null) {
            return;
        }
        zzaVar.zzc();
        this.zzj = null;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
    public final void onAdEvent(AdEvent adEvent) {
        if (this.zzg) {
            AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
            int iOrdinal = adEvent.getType().ordinal();
            if (iOrdinal == 3 || iOrdinal == 14) {
                zzi();
                return;
            }
            if (iOrdinal == 15 && this.zzg && this.zzj == null && this.zzd != null) {
                com.google.ads.interactivemedia.omid.library.adsession.zzf zzfVar = com.google.ads.interactivemedia.omid.library.adsession.zzf.DEFINED_BY_JAVASCRIPT;
                com.google.ads.interactivemedia.omid.library.adsession.zzh zzhVar = com.google.ads.interactivemedia.omid.library.adsession.zzh.DEFINED_BY_JAVASCRIPT;
                com.google.ads.interactivemedia.omid.library.adsession.zzi zziVar = com.google.ads.interactivemedia.omid.library.adsession.zzi.JAVASCRIPT;
                com.google.ads.interactivemedia.omid.library.adsession.zza zzaVarZza = com.google.ads.interactivemedia.omid.library.adsession.zza.zza(com.google.ads.interactivemedia.omid.library.adsession.zzb.zza(zzfVar, zzhVar, zziVar, zziVar, true), com.google.ads.interactivemedia.omid.library.adsession.zzc.zzb(com.google.ads.interactivemedia.omid.library.adsession.zzj.zza("Google1", "3.33.0"), this.zza.zza(), this.zzi, b.D("{ssai:", true != this.zzh ? "false" : "true", "}")));
                zzaVarZza.zzd(this.zzd);
                for (FriendlyObstruction friendlyObstruction : this.zzf) {
                    zzaVarZza.zzb(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
                }
                zzj(new ArrayList(this.zzf));
                zzaVarZza.zzf();
                this.zzj = zzaVarZza;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzau
    public final void zza() {
        com.google.ads.interactivemedia.v3.internal.zzbr.zza(this.zzc);
        this.zzg = true;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzau
    public final void zzb() {
        this.zzg = false;
    }

    public final void zzc(FriendlyObstruction friendlyObstruction) {
        if (this.zzf.contains(friendlyObstruction)) {
            return;
        }
        this.zzf.add(friendlyObstruction);
        com.google.ads.interactivemedia.omid.library.adsession.zza zzaVar = this.zzj;
        if (zzaVar != null) {
            zzaVar.zzb(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
            zzj(Arrays.asList(friendlyObstruction));
        }
    }

    public final void zzd(View view) {
        this.zzd = view;
    }

    public final void zze(String str) {
        this.zzi = str;
    }

    public final void zzf(boolean z) {
        this.zzh = true;
    }

    public final void zzg(String str) {
        this.zze = str;
    }

    public final void zzh() {
        this.zzf.clear();
        com.google.ads.interactivemedia.omid.library.adsession.zza zzaVar = this.zzj;
        if (zzaVar == null) {
            return;
        }
        zzaVar.zze();
        zzj(null);
    }

    public final boolean zzi() {
        com.google.ads.interactivemedia.omid.library.adsession.zza zzaVar;
        if (!this.zzg || (zzaVar = this.zzj) == null) {
            return false;
        }
        zzaVar.zzc();
        this.zzj = null;
        return true;
    }
}
