package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: classes4.dex */
public final class zzgeb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32369a;

    public zzgeb(zzijh zzijhVar) {
        this.f32369a = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        DisplayMetrics displayMetrics = ((Context) this.f32369a.f34899a).getResources().getDisplayMetrics();
        zzijo.a(displayMetrics);
        return displayMetrics;
    }
}
