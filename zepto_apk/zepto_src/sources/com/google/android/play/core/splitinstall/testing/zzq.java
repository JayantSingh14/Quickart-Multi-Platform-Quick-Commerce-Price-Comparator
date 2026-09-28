package com.google.android.play.core.splitinstall.testing;

import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzq implements com.google.android.play.core.splitinstall.zzf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f42058a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f42059b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f42060c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f42061d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f42062e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ FakeSplitInstallManager f42063f;

    public zzq(FakeSplitInstallManager fakeSplitInstallManager, ArrayList arrayList, ArrayList arrayList2, long j2, boolean z, ArrayList arrayList3) {
        this.f42063f = fakeSplitInstallManager;
        this.f42058a = arrayList;
        this.f42059b = arrayList2;
        this.f42060c = j2;
        this.f42061d = z;
        this.f42062e = arrayList3;
    }

    @Override // com.google.android.play.core.splitinstall.zzf
    public final void zza() {
        int i2 = FakeSplitInstallManager.p;
        ArrayList arrayList = this.f42058a;
        ArrayList arrayList2 = this.f42059b;
        FakeSplitInstallManager fakeSplitInstallManager = this.f42063f;
        fakeSplitInstallManager.f42021l.addAll(arrayList);
        fakeSplitInstallManager.f42022m.addAll(arrayList2);
        Long lValueOf = Long.valueOf(this.f42060c);
        fakeSplitInstallManager.h(5, 0, null, lValueOf, lValueOf, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.zzf
    public final void zzb(int i2) {
        int i3 = FakeSplitInstallManager.p;
        this.f42063f.h(6, i2, null, null, null, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.zzf
    public final void zzc() {
        if (this.f42061d) {
            return;
        }
        int i2 = FakeSplitInstallManager.p;
        ArrayList arrayList = this.f42062e;
        ArrayList arrayList2 = this.f42058a;
        ArrayList arrayList3 = this.f42059b;
        FakeSplitInstallManager fakeSplitInstallManager = this.f42063f;
        fakeSplitInstallManager.f42018i.a().a(arrayList, new zzq(fakeSplitInstallManager, arrayList2, arrayList3, this.f42060c, true, arrayList));
    }
}
