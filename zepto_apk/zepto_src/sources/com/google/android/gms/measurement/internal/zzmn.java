package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzmn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39417a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f39418b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbe f39419c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f39420d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zznk f39421e;

    public zzmn(zznk zznkVar, zzr zzrVar, boolean z, zzbe zzbeVar, Bundle bundle) {
        this.f39417a = zzrVar;
        this.f39418b = z;
        this.f39419c = zzbeVar;
        this.f39420d = bundle;
        Objects.requireNonNull(zznkVar);
        this.f39421e = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zznk zznkVar = this.f39421e;
        zzga zzgaVar = zznkVar.f39485d;
        zzib zzibVar = zznkVar.f39180a;
        if (zzgaVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Failed to send default event parameters to service");
            return;
        }
        boolean zQ = zzibVar.f39087d.q(null, zzfx.c1);
        zzr zzrVar = this.f39417a;
        if (zQ) {
            Preconditions.checkNotNull(zzrVar);
            zznkVar.y(zzgaVar, this.f39418b ? null : this.f39419c, zzrVar);
            return;
        }
        try {
            Preconditions.checkNotNull(zzrVar);
            zzgaVar.aa(this.f39420d, zzrVar);
            zznkVar.t();
        } catch (RemoteException e2) {
            zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2, "Failed to send default event parameters to service");
        }
    }
}
