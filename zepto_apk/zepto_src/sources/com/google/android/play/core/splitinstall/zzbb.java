package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.splitinstall.internal.zzbp;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class zzbb extends zzbp {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f42101a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbc f42102b;

    public zzbb(zzbc zzbcVar, TaskCompletionSource taskCompletionSource) {
        this.f42102b = zzbcVar;
        this.f42101a = taskCompletionSource;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzbq
    public final void A(int i2) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onCompleteInstall(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzbq
    public final void E4(Bundle bundle) {
        com.google.android.play.core.splitinstall.internal.zzaf zzafVar = this.f42102b.f42106b;
        TaskCompletionSource taskCompletionSource = this.f42101a;
        zzafVar.d(taskCompletionSource);
        int i2 = bundle.getInt("error_code");
        zzbc.f42103c.b("onError(%d)", Integer.valueOf(i2));
        taskCompletionSource.c(new SplitInstallException(i2));
    }

    public void E7(Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onDeferredUninstall", new Object[0]);
    }

    public void Fb(ArrayList arrayList) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onGetSessionStates", new Object[0]);
    }

    public void L4(int i2, Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onStartInstall(%d)", Integer.valueOf(i2));
    }

    public void M8(Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onDeferredLanguageInstall", new Object[0]);
    }

    public void Q5(int i2, Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onGetSession(%d)", Integer.valueOf(i2));
    }

    public void W(Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onDeferredLanguageUninstall", new Object[0]);
    }

    public void zzb(int i2, Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onCancelInstall(%d)", Integer.valueOf(i2));
    }

    public void zzc(Bundle bundle) {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onDeferredInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzbq
    public final void zzk() {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onCompleteInstallForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzbq
    public final void zzm() {
        this.f42102b.f42106b.d(this.f42101a);
        zzbc.f42103c.d("onGetSplitsForAppUpdate", new Object[0]);
    }
}
