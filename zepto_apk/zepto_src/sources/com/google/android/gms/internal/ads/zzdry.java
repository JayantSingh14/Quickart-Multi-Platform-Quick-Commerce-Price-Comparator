package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzdry extends zzbkr {

    /* renamed from: a, reason: collision with root package name */
    public final Context f28388a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdnm f28389b;

    /* renamed from: c, reason: collision with root package name */
    public zzdol f28390c;

    /* renamed from: d, reason: collision with root package name */
    public zzdnh f28391d;

    public zzdry(Context context, zzdnm zzdnmVar, zzdol zzdolVar, zzdnh zzdnhVar) {
        this.f28388a = context;
        this.f28389b = zzdnmVar;
        this.f28390c = zzdolVar;
        this.f28391d = zzdnhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbks
    public final boolean J(IObjectWrapper iObjectWrapper) {
        zzdol zzdolVar;
        Object objZ0 = ObjectWrapper.z0(iObjectWrapper);
        if (!(objZ0 instanceof ViewGroup) || (zzdolVar = this.f28390c) == null || !zzdolVar.c((ViewGroup) objZ0, true)) {
            return false;
        }
        this.f28389b.h().n0(new zzdrx(this));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbks
    public final IObjectWrapper T9() {
        return new ObjectWrapper(this.f28388a);
    }

    @Override // com.google.android.gms.internal.ads.zzbks
    public final String zzh() {
        return this.f28389b.g();
    }
}
