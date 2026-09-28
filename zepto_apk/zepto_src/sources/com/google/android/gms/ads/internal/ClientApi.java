package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzaj;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbon;
import com.google.android.gms.internal.ads.zzboq;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzccj;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzdof;
import com.google.android.gms.internal.ads.zzdoh;
import com.google.android.gms.internal.ads.zzdyv;
import com.google.android.gms.internal.ads.zzepr;
import com.google.android.gms.internal.ads.zzfcu;
import com.google.android.gms.internal.ads.zzfeh;
import com.google.android.gms.internal.ads.zzffx;
import com.google.android.gms.internal.ads.zzfhk;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class ClientApi extends zzcq {
    @KeepForSdk
    public ClientApi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbt D8(IObjectWrapper iObjectWrapper, String str, zzbsz zzbszVar, int i2) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        return new zzepr(zzclg.f(context, zzbszVar, i2), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx F2(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        zzffx zzffxVarQ = zzclg.f(context, zzbszVar, i2).q();
        zzffxVarQ.b(context);
        zzffxVarQ.a(zzrVar);
        zzffxVarQ.o(str);
        return zzffxVarQ.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwr G6(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        return zzclg.f((Context) ObjectWrapper.z0(iObjectWrapper), zzbszVar, i2).x();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx H5(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i2) {
        return new zzs((Context) ObjectWrapper.z0(iObjectWrapper), zzrVar, str, new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i2, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbkc Q6(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdoh((FrameLayout) ObjectWrapper.z0(iObjectWrapper), (FrameLayout) ObjectWrapper.z0(iObjectWrapper2));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzcaf Y2(IObjectWrapper iObjectWrapper, String str, zzbsz zzbszVar, int i2) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        zzfhk zzfhkVarT = zzclg.f(context, zzbszVar, i2).t();
        zzfhkVarT.a(context);
        zzfhkVarT.b(str);
        return zzfhkVarT.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwy Z(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.z0(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelB = AdOverlayInfoParcel.b(activity.getIntent());
        if (adOverlayInfoParcelB == null) {
            return new zzw(activity);
        }
        int i2 = adOverlayInfoParcelB.f21324k;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? new zzw(activity) : new zzag(activity) : new zzac(activity, adOverlayInfoParcelB) : new zzaj(activity) : new zzai(activity) : new zzv(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdb e6(IObjectWrapper iObjectWrapper, int i2) {
        return zzclg.f((Context) ObjectWrapper.z0(iObjectWrapper), null, i2).j();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzboq j3(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2, zzbon zzbonVar) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        zzdyv zzdyvVarA = zzclg.f(context, zzbszVar, i2).a();
        zzdyvVarA.a(context);
        zzdyvVarA.b(zzbonVar);
        return zzdyvVarA.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzck ja(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        return zzclg.f((Context) ObjectWrapper.z0(iObjectWrapper), zzbszVar, i2).k();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx m3(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        zzfeh zzfehVarM = zzclg.f(context, zzbszVar, i2).m();
        zzfehVarM.b(context);
        zzfehVarM.a(zzrVar);
        zzfehVarM.o(str);
        return zzfehVarM.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdw n5(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        return zzclg.f((Context) ObjectWrapper.z0(iObjectWrapper), zzbszVar, i2).c();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzccj n7(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        return zzclg.f((Context) ObjectWrapper.z0(iObjectWrapper), zzbszVar, i2).v();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx r6(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        zzfcu zzfcuVarO = zzclg.f(context, zzbszVar, i2).o();
        zzfcuVarO.b(str);
        zzfcuVarO.a(context);
        return zzfcuVarO.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbki zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdof((View) ObjectWrapper.z0(iObjectWrapper), (HashMap) ObjectWrapper.z0(iObjectWrapper2), (HashMap) ObjectWrapper.z0(iObjectWrapper3));
    }
}
