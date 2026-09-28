package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class zzki extends zzkl {
    private final zzgz zza;
    private final zzhg zzb;

    public zzki(Context context, Executor executor, zzm zzmVar) {
        zzhd zzhdVar = new zzhd(context, executor, zzmVar);
        this.zza = zzhdVar;
        this.zzb = new zzhg(zzhdVar);
    }

    @Deprecated
    private final IObjectWrapper zzt(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, boolean z) {
        try {
            Uri uri = (Uri) ObjectWrapper.z0(iObjectWrapper);
            Context context = (Context) ObjectWrapper.z0(iObjectWrapper2);
            return new ObjectWrapper(z ? this.zzb.zzb(uri, context) : this.zzb.zza(uri, context, null, null));
        } catch (zzhh unused) {
            return null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final int zzb() {
        zzgz zzgzVar = this.zza;
        if (zzgzVar instanceof zzhd) {
            zzgz zzgzVarZza = ((zzhd) zzgzVar).zza();
            if (zzgzVarZza instanceof zzhf) {
                return 1;
            }
            if (zzgzVarZza instanceof zzgw) {
                return 2;
            }
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final IObjectWrapper zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return zzt(iObjectWrapper, iObjectWrapper2, false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final IObjectWrapper zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return zzt(iObjectWrapper, iObjectWrapper2, true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final String zze(IObjectWrapper iObjectWrapper, String str) {
        return ((zzhd) this.zza).zze((Context) ObjectWrapper.z0(iObjectWrapper), str, null, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final String zzf(IObjectWrapper iObjectWrapper) {
        return zzg(iObjectWrapper, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final String zzg(IObjectWrapper iObjectWrapper, byte[] bArr) {
        return this.zza.zzg((Context) ObjectWrapper.z0(iObjectWrapper), bArr);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final String zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, IObjectWrapper iObjectWrapper4) {
        return this.zza.zze((Context) ObjectWrapper.z0(iObjectWrapper), (String) ObjectWrapper.z0(iObjectWrapper2), (View) ObjectWrapper.z0(iObjectWrapper3), (Activity) ObjectWrapper.z0(iObjectWrapper4));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final String zzi(IObjectWrapper iObjectWrapper) {
        return ((zzhd) this.zza).zzg((Context) ObjectWrapper.z0(iObjectWrapper), null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final String zzj() {
        return "ms";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final String zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return this.zza.zzh((Context) ObjectWrapper.z0(iObjectWrapper), (View) ObjectWrapper.z0(iObjectWrapper2), (Activity) ObjectWrapper.z0(iObjectWrapper3));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzb.zzc((MotionEvent) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zza.zzn((View) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final void zzn(String str, String str2) {
        this.zzb.zzd(str, str2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final void zzo(String str) {
        this.zzb.zze(str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        return this.zzb.zzg((Uri) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    @Deprecated
    public final boolean zzq(IObjectWrapper iObjectWrapper) {
        return this.zzb.zzf((Uri) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final boolean zzr() {
        return this.zza.zzq();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkm
    public final boolean zzs() {
        return this.zza.zzs();
    }
}
