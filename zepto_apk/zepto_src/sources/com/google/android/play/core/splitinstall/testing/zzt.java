package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.internal.zzbz;
import com.google.android.play.core.splitinstall.internal.zzcb;
import com.google.android.play.core.splitinstall.zzad;
import com.google.android.play.core.splitinstall.zzae;
import java.io.File;

/* loaded from: classes4.dex */
public final class zzt implements zzcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzad f42064a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcb f42065b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcb f42066c;

    /* renamed from: d, reason: collision with root package name */
    public final zzae f42067d;

    public zzt(zzad zzadVar, zzcb zzcbVar, zzcb zzcbVar2, zzae zzaeVar) {
        this.f42064a = zzadVar;
        this.f42065b = zzcbVar;
        this.f42066c = zzcbVar2;
        this.f42067d = zzaeVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        return new FakeSplitInstallManager(this.f42064a.f42091a.f42090a, (File) this.f42065b.zza(), (com.google.android.play.core.splitinstall.zzs) this.f42066c.zza(), zzbz.a(this.f42067d));
    }
}
