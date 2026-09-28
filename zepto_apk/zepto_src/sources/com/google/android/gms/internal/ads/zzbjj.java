package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbjj extends zzbjx {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f25243a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f25244b;

    /* renamed from: c, reason: collision with root package name */
    public final double f25245c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25246d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25247e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f25248f;

    public zzbjj(Drawable drawable, Uri uri, double d2, int i2, int i3, HashMap map) {
        this.f25243a = drawable;
        this.f25244b = uri;
        this.f25245c = d2;
        this.f25246d = i2;
        this.f25247e = i3;
        this.f25248f = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final IObjectWrapper zzb() {
        return new ObjectWrapper(this.f25243a);
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final Uri zzc() {
        return this.f25244b;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final double zzd() {
        return this.f25245c;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final int zze() {
        return this.f25246d;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final int zzf() {
        return this.f25247e;
    }

    @Override // com.google.android.gms.internal.ads.zzbjy
    public final Map zzg() {
        return this.f25248f;
    }
}
