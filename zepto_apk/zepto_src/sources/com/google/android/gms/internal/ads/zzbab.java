package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;

/* loaded from: classes4.dex */
final class zzbab implements AppOpsManager$OnOpActiveChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbac f24620a;

    public zzbab(zzbac zzbacVar) {
        this.f24620a = zzbacVar;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z) {
        if (z) {
            zzbac zzbacVar = this.f24620a;
            zzbacVar.f24622a = System.currentTimeMillis();
            zzbacVar.f24625d = true;
            return;
        }
        zzbac zzbacVar2 = this.f24620a;
        long j2 = zzbacVar2.f24623b;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j2 > 0) {
            long j3 = zzbacVar2.f24623b;
            if (jCurrentTimeMillis >= j3) {
                zzbacVar2.f24624c = jCurrentTimeMillis - j3;
            }
        }
        zzbacVar2.f24625d = false;
    }
}
