package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbug extends zzbtn {

    /* renamed from: a, reason: collision with root package name */
    public final UnifiedNativeAdMapper f25575a;

    public zzbug(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.f25575a = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final float H() {
        this.f25575a.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final float I() {
        this.f25575a.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void R0(IObjectWrapper iObjectWrapper) {
        this.f25575a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final Bundle bb() {
        return this.f25575a.f21705l;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final boolean f() {
        return this.f25575a.f21706m;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void h() {
        this.f25575a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void i2(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f25575a.a((View) ObjectWrapper.z0(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final boolean p0() {
        return this.f25575a.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void s8(IObjectWrapper iObjectWrapper) {
        this.f25575a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final float t() {
        this.f25575a.getClass();
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void v() {
        this.f25575a.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zze() {
        return this.f25575a.f21694a;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final List zzf() {
        List<NativeAd.Image> list = this.f25575a.f21695b;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (NativeAd.Image image : list) {
                arrayList.add(new zzbjj(image.a(), image.c(), image.b(), image.d(), image.e(), null));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzg() {
        return this.f25575a.f21696c;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final zzbjy zzh() {
        NativeAd.Image image = this.f25575a.f21697d;
        if (image != null) {
            return new zzbjj(image.a(), image.c(), image.b(), image.d(), image.e(), null);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzi() {
        return this.f25575a.f21698e;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzj() {
        return this.f25575a.f21699f;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final double zzk() {
        Double d2 = this.f25575a.f21700g;
        if (d2 != null) {
            return d2.doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzl() {
        return this.f25575a.f21701h;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzm() {
        return this.f25575a.f21702i;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final com.google.android.gms.ads.internal.client.zzed zzn() {
        com.google.android.gms.ads.internal.client.zzed zzedVar;
        VideoController videoController = this.f25575a.f21703j;
        if (videoController == null) {
            return null;
        }
        synchronized (videoController.f21030a) {
            zzedVar = videoController.f21031b;
        }
        return zzedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final zzbjr zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final IObjectWrapper zzp() {
        this.f25575a.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final IObjectWrapper zzq() {
        this.f25575a.getClass();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final IObjectWrapper zzr() {
        Object obj = this.f25575a.f21704k;
        if (obj == null) {
            return null;
        }
        return new ObjectWrapper(obj);
    }
}
