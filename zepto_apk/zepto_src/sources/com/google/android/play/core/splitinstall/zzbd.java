package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitinstall.internal.zzcb;

/* loaded from: classes4.dex */
public final class zzbd implements zzcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzad f42107a;

    public zzbd(zzad zzadVar) {
        this.f42107a = zzadVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        Context context = this.f42107a.f42091a.f42090a;
        return new zzbc(context, context.getPackageName());
    }
}
