package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgmw implements AppOpsManager$OnOpActiveChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgmy f32944a;

    public zzgmw(zzgmy zzgmyVar) {
        Objects.requireNonNull(zzgmyVar);
        this.f32944a = zzgmyVar;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z) {
        zzgmy zzgmyVar = this.f32944a;
        synchronized (zzgmyVar) {
            try {
                if (z) {
                    zzgmyVar.f32950d = System.currentTimeMillis();
                    zzgmyVar.f32953g = true;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j2 = zzgmyVar.f32951e;
                    if (j2 > 0 && jCurrentTimeMillis >= j2) {
                        zzgmyVar.f32952f = jCurrentTimeMillis - j2;
                    }
                    zzgmyVar.f32953g = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
