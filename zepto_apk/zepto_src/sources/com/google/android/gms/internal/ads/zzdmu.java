package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzdmu extends zzbju {

    /* renamed from: a, reason: collision with root package name */
    public final zzdnm f27982a;

    /* renamed from: b, reason: collision with root package name */
    public IObjectWrapper f27983b;

    public zzdmu(zzdnm zzdnmVar) {
        this.f27982a = zzdnmVar;
    }

    public static float Xb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.z0(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbjv
    public final IObjectWrapper zzg() {
        IObjectWrapper iObjectWrapper = this.f27983b;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbjy zzbjyVarB = this.f27982a.b();
        if (zzbjyVarB == null) {
            return null;
        }
        return zzbjyVarB.zzb();
    }
}
