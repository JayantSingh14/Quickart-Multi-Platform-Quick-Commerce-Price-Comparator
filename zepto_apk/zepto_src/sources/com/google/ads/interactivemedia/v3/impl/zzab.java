package com.google.ads.interactivemedia.v3.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.internal.zzpd;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqh;
import com.google.ads.interactivemedia.v3.internal.zzqn;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class zzab implements BaseDisplayContainer {
    private static int zza;

    @Nullable
    private ViewGroup zzb;
    private Collection zzc = zzqf.zzm();
    private Map zzd = zzqn.zzo();
    private final Set zze = new HashSet();

    @Nullable
    private zzaa zzf = null;
    private boolean zzg = false;

    public zzab(@Nullable ViewGroup viewGroup) {
        this.zzb = viewGroup;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void claim() {
        zzpd.zzd(!this.zzg, "A given DisplayContainer may only be used once");
        this.zzg = true;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void destroy() {
        ViewGroup viewGroup = this.zzb;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.zzf = null;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final ViewGroup getAdContainer() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final Collection<CompanionAdSlot> getCompanionSlots() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction) {
        if (friendlyObstruction == null || this.zze.contains(friendlyObstruction)) {
            return;
        }
        this.zze.add(friendlyObstruction);
        zzaa zzaaVar = this.zzf;
        if (zzaaVar != null) {
            ((zzbm) zzaaVar).zzc(friendlyObstruction);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void registerVideoControlsOverlay(View view) {
        if (view == null) {
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.zzbo zzboVarBuilder = com.google.ads.interactivemedia.v3.impl.data.zzbp.builder();
        zzboVarBuilder.view(view);
        zzboVarBuilder.purpose(FriendlyObstructionPurpose.VIDEO_CONTROLS);
        com.google.ads.interactivemedia.v3.impl.data.zzbp zzbpVarBuild = zzboVarBuilder.build();
        if (this.zze.contains(zzbpVarBuild)) {
            return;
        }
        this.zze.add(zzbpVarBuild);
        zzaa zzaaVar = this.zzf;
        if (zzaaVar != null) {
            ((zzbm) zzaaVar).zzc(zzbpVarBuild);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void setAdContainer(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.zzb = viewGroup;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void setCompanionSlots(@Nullable Collection<CompanionAdSlot> collection) {
        if (collection == null) {
            collection = zzqf.zzm();
        }
        zzqh zzqhVar = new zzqh();
        for (CompanionAdSlot companionAdSlot : collection) {
            if (companionAdSlot != null) {
                int i2 = zza;
                zza = i2 + 1;
                zzqhVar.zza("compSlot_" + i2, companionAdSlot);
            }
        }
        this.zzd = zzqhVar.zzc();
        this.zzc = collection;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void unregisterAllFriendlyObstructions() {
        this.zze.clear();
        zzaa zzaaVar = this.zzf;
        if (zzaaVar != null) {
            ((zzbm) zzaaVar).zzh();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void unregisterAllVideoControlsOverlays() {
        this.zze.clear();
        zzaa zzaaVar = this.zzf;
        if (zzaaVar != null) {
            ((zzbm) zzaaVar).zzh();
        }
    }

    public final Map zza() {
        return this.zzd;
    }

    public final Set zzb() {
        return new HashSet(this.zze);
    }

    public final void zzc(zzaa zzaaVar) {
        this.zzf = zzaaVar;
    }
}
