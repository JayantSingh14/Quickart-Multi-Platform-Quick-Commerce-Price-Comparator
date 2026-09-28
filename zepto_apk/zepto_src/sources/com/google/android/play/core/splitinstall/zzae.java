package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.internal.zzcb;
import java.io.File;

/* loaded from: classes4.dex */
public final class zzae implements zzcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzcb f42092a;

    public zzae(zzcb zzcbVar) {
        this.f42092a = zzcbVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final /* bridge */ /* synthetic */ Object zza() {
        File file = (File) this.f42092a.zza();
        if (file == null) {
            return null;
        }
        return com.google.android.play.core.splitinstall.testing.zzaa.a(file);
    }
}
