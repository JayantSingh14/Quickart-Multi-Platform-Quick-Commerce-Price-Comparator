package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzou implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpf f39566a;

    public zzou(zzpf zzpfVar, zzpg zzpgVar) {
        Objects.requireNonNull(zzpfVar);
        this.f39566a = zzpfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpf zzpfVar = this.f39566a;
        zzpfVar.c().g();
        zzpfVar.f39604k = new zzhj(zzpfVar);
        zzav zzavVar = new zzav(zzpfVar);
        zzavVar.i();
        zzpfVar.f39596c = zzavVar;
        zzpfVar.d0().f38690d = (zzak) Preconditions.checkNotNull(zzpfVar.f39594a);
        zznm zznmVar = new zznm(zzpfVar);
        zznmVar.i();
        zzpfVar.f39602i = zznmVar;
        zzad zzadVar = new zzad(zzpfVar);
        zzadVar.i();
        zzpfVar.f39599f = zzadVar;
        zzlo zzloVar = new zzlo(zzpfVar);
        zzloVar.i();
        zzpfVar.f39601h = zzloVar;
        zzoj zzojVar = new zzoj(zzpfVar);
        zzojVar.i();
        zzpfVar.f39598e = zzojVar;
        zzpfVar.f39597d = new zzha(zzpfVar);
        if (zzpfVar.r != zzpfVar.s) {
            zzgt zzgtVarB = zzpfVar.b();
            zzgtVarB.f38958f.c("Not all upload components initialized", Integer.valueOf(zzpfVar.r), Integer.valueOf(zzpfVar.s));
        }
        zzpfVar.f39606m.set(true);
        zzpfVar.b().n.a("UploadController is now fully initialized");
        zzpfVar.c().g();
        zzav zzavVar2 = zzpfVar.f39596c;
        zzpf.S(zzavVar2);
        zzavVar2.q();
        zzav zzavVar3 = zzpfVar.f39596c;
        zzpf.S(zzavVar3);
        zzavVar3.g();
        zzavVar3.h();
        if (zzavVar3.R()) {
            zzfw zzfwVar = zzfx.v0;
            if (((Long) zzfwVar.a(null)).longValue() != 0) {
                SQLiteDatabase sQLiteDatabaseX = zzavVar3.X();
                zzib zzibVar = zzavVar3.f39180a;
                int iDelete = sQLiteDatabaseX.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzibVar.f39094k.currentTimeMillis()), String.valueOf(zzfwVar.a(null))});
                if (iDelete > 0) {
                    zzgt zzgtVar = zzibVar.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.n.b(Integer.valueOf(iDelete), "Deleted stale trigger uris. rowsDeleted");
                }
            }
        }
        if (zzpfVar.f39602i.f39499h.a() == 0) {
            zzpfVar.f39602i.f39499h.b(zzpfVar.f().currentTimeMillis());
        }
        zzpfVar.L();
    }
}
