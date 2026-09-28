package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgbd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32201a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32202b;

    public zzgbd(zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32201a = zzijhVar;
        this.f32202b = zzijhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        ExecutorService executorService = (ExecutorService) this.f32201a.f34899a;
        zzgad zzgadVar = (zzgad) this.f32202b.f34899a;
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(str2).length() + 1);
        android.support.v4.media.b.B(sb, "Mozilla/5.0 (Linux; Android ", str, "; ", str2);
        sb.append(")");
        return new zzgbi(executorService, sb.toString(), zzgadVar.R());
    }
}
