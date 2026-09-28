package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbjz extends NativeAd.Image {

    /* renamed from: a, reason: collision with root package name */
    public final zzbjy f25262a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f25263b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f25264c;

    /* renamed from: d, reason: collision with root package name */
    public final double f25265d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25266e;

    /* renamed from: f, reason: collision with root package name */
    public final int f25267f;

    public zzbjz(zzbjy zzbjyVar) {
        double dZzd;
        int iZze;
        IObjectWrapper iObjectWrapperZzb;
        this.f25262a = zzbjyVar;
        Uri uriZzc = null;
        try {
            iObjectWrapperZzb = zzbjyVar.zzb();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
        }
        Drawable drawable = iObjectWrapperZzb != null ? (Drawable) ObjectWrapper.z0(iObjectWrapperZzb) : null;
        this.f25263b = drawable;
        try {
            uriZzc = this.f25262a.zzc();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        this.f25264c = uriZzc;
        try {
            dZzd = this.f25262a.zzd();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
            dZzd = 1.0d;
        }
        this.f25265d = dZzd;
        int iZzf = -1;
        try {
            iZze = this.f25262a.zze();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
            iZze = -1;
        }
        this.f25266e = iZze;
        try {
            iZzf = this.f25262a.zzf();
        } catch (RemoteException e6) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e6);
        }
        this.f25267f = iZzf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable a() {
        return this.f25263b;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double b() {
        return this.f25265d;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri c() {
        return this.f25264c;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int d() {
        return this.f25266e;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int e() {
        return this.f25267f;
    }
}
