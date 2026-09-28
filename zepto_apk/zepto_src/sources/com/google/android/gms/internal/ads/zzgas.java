package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgas implements zzgdz {

    /* renamed from: a, reason: collision with root package name */
    public final zzgaj f32181a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgap f32182b;

    /* renamed from: c, reason: collision with root package name */
    public Context f32183c;

    /* renamed from: d, reason: collision with root package name */
    public View f32184d;

    /* renamed from: e, reason: collision with root package name */
    public Activity f32185e;

    /* renamed from: f, reason: collision with root package name */
    public String f32186f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f32187g;

    /* renamed from: h, reason: collision with root package name */
    public zzavs f32188h;

    /* renamed from: i, reason: collision with root package name */
    public zzgba f32189i;

    public /* synthetic */ zzgas(zzgaj zzgajVar, zzgap zzgapVar) {
        this.f32181a = zzgajVar;
        this.f32182b = zzgapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdz
    public final /* bridge */ /* synthetic */ zzgdz a(Context context) {
        context.getClass();
        this.f32183c = context;
        return this;
    }

    public final zzgea b() {
        zzijo.b(Context.class, this.f32183c);
        zzijo.b(Map.class, this.f32187g);
        zzijo.b(zzavs.class, this.f32188h);
        zzijo.b(zzgba.class, this.f32189i);
        return new zzgat(this.f32181a, this.f32182b, this.f32183c, this.f32184d, this.f32185e, this.f32186f, this.f32187g, this.f32188h, this.f32189i);
    }

    public final /* bridge */ /* synthetic */ zzgdz c(zzavs zzavsVar) {
        zzavsVar.getClass();
        this.f32188h = zzavsVar;
        return this;
    }
}
