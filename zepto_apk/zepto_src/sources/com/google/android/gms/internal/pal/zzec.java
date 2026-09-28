package com.google.android.gms.internal.pal;

import android.app.AppOpsManager$OnOpActiveChangedListener;

/* loaded from: classes4.dex */
final class zzec implements AppOpsManager$OnOpActiveChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzed f37681a;

    public zzec(zzed zzedVar) {
        this.f37681a = zzedVar;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z) {
        if (z) {
            this.f37681a.f37683a = System.currentTimeMillis();
            this.f37681a.f37686d = true;
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzed zzedVar = this.f37681a;
        long j2 = zzedVar.f37684b;
        if (j2 > 0 && jCurrentTimeMillis >= j2) {
            zzedVar.f37685c = jCurrentTimeMillis - j2;
        }
        zzedVar.f37686d = false;
    }
}
