package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzks implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzaz f39280a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39281b;

    public zzks(zzli zzliVar, zzaz zzazVar) {
        this.f39280a = zzazVar;
        Objects.requireNonNull(zzliVar);
        this.f39281b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.f39281b;
        zzib zzibVar = zzliVar.f39180a;
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        zzhgVar.g();
        zzhgVar.g();
        zzaz zzazVarB = zzaz.b(zzhgVar.k().getString("dma_consent_settings", null));
        zzaz zzazVar = this.f39280a;
        int i2 = zzazVarB.f38740a;
        int i3 = zzazVar.f38740a;
        boolean zL = zzjk.l(i3, i2);
        zzgt zzgtVar = zzibVar.f39089f;
        if (!zL) {
            zzib.l(zzgtVar);
            zzgtVar.f38964l.b(Integer.valueOf(i3), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = zzhgVar.k().edit();
        editorEdit.putString("dma_consent_settings", zzazVar.f38741b);
        editorEdit.apply();
        zzib.l(zzgtVar);
        zzgtVar.n.b(zzazVar, "Setting DMA consent(FE)");
        zzib zzibVar2 = zzliVar.f39180a;
        if (zzibVar2.o().q()) {
            final zznk zznkVarO = zzibVar2.o();
            zznkVarO.g();
            zznkVarO.h();
            zznkVarO.u(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznf
                @Override // java.lang.Runnable
                public final void run() {
                    zznk zznkVar = zznkVarO;
                    zzga zzgaVar = zznkVar.f39485d;
                    zzib zzibVar3 = zznkVar.f39180a;
                    if (zzgaVar == null) {
                        zzgt zzgtVar2 = zzibVar3.f39089f;
                        zzib.l(zzgtVar2);
                        zzgtVar2.f38958f.a("Failed to send Dma consent settings to service");
                        return;
                    }
                    try {
                        zzr zzrVarW = zznkVar.w(false);
                        Preconditions.checkNotNull(zzrVarW);
                        zzgaVar.m4(zzrVarW);
                        zznkVar.t();
                    } catch (RemoteException e2) {
                        zzgt zzgtVar3 = zzibVar3.f39089f;
                        zzib.l(zzgtVar3);
                        zzgtVar3.f38958f.b(e2, "Failed to send Dma consent settings to the service");
                    }
                }
            });
            return;
        }
        zznk zznkVarO2 = zzibVar2.o();
        zznkVarO2.g();
        zznkVarO2.h();
        if (zznkVarO2.p()) {
            zznkVarO2.u(new zzmr(zznkVarO2, zznkVarO2.w(false)));
        }
    }
}
