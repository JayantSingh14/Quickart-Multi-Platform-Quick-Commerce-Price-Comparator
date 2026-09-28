package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
final class zzv implements zzf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SplitInstallSessionState f42136a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f42137b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f42138c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzx f42139d;

    public zzv(zzx zzxVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f42139d = zzxVar;
        this.f42136a = splitInstallSessionState;
        this.f42137b = intent;
        this.f42138c = context;
    }

    @Override // com.google.android.play.core.splitinstall.zzf
    public final void zza() {
        SplitInstallSessionState splitInstallSessionState = this.f42136a;
        zzx zzxVar = this.f42139d;
        zzxVar.f42145g.post(new zzw(zzxVar, splitInstallSessionState, 5, 0));
    }

    @Override // com.google.android.play.core.splitinstall.zzf
    public final void zzb(int i2) {
        SplitInstallSessionState splitInstallSessionState = this.f42136a;
        zzx zzxVar = this.f42139d;
        zzxVar.f42145g.post(new zzw(zzxVar, splitInstallSessionState, 6, i2));
    }

    @Override // com.google.android.play.core.splitinstall.zzf
    public final void zzc() {
        Intent intent = this.f42137b;
        if (intent.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f42139d.f41991a.b("Splits copied and verified more than once.", new Object[0]);
        } else {
            intent.putExtra("triggered_from_app_after_verification", true);
            this.f42138c.sendBroadcast(intent);
        }
    }
}
