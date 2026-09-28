package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: a, reason: collision with root package name */
    public final zzf f36813a;

    /* renamed from: b, reason: collision with root package name */
    public zzg f36814b;

    /* renamed from: c, reason: collision with root package name */
    public final zzab f36815c;

    /* renamed from: d, reason: collision with root package name */
    public final zzz f36816d;

    public zzc() {
        zzf zzfVar = new zzf();
        this.f36813a = zzfVar;
        this.f36814b = zzfVar.f36939b.c();
        this.f36815c = new zzab();
        this.f36816d = new zzz();
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzv(this.f36781a.f36816d);
            }
        };
        zzj zzjVar = zzfVar.f36941d;
        zzjVar.a("internal.registerCallback", callable);
        zzjVar.a("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzk(this.f36744a.f36815c);
            }
        });
    }

    public final boolean a(zzaa zzaaVar) throws zzd {
        zzab zzabVar = this.f36815c;
        try {
            zzabVar.b(zzaaVar);
            this.f36813a.f36940c.e("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.f36816d.a(this.f36814b.c(), zzabVar);
            if (zzabVar.c().equals(zzabVar.a())) {
                return !((ArrayList) zzabVar.d()).isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void b(zzja zzjaVar) throws zzd {
        zzai zzaiVar;
        try {
            zzf zzfVar = this.f36813a;
            this.f36814b = zzfVar.f36939b.c();
            if (zzfVar.a(this.f36814b, (zzje[]) zzjaVar.s().toArray(new zzje[0])) instanceof zzag) {
                throw new IllegalStateException("Program loading failed");
            }
            for (zziy zziyVar : zzjaVar.t().s()) {
                List listT = zziyVar.t();
                String strS = zziyVar.s();
                Iterator it = listT.iterator();
                while (it.hasNext()) {
                    zzao zzaoVarA = zzfVar.a(this.f36814b, (zzje) it.next());
                    if (!(zzaoVarA instanceof zzal)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    zzg zzgVar = this.f36814b;
                    if (zzgVar.d(strS)) {
                        zzao zzaoVarG = zzgVar.g(strS);
                        if (!(zzaoVarG instanceof zzai)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strS)));
                        }
                        zzaiVar = (zzai) zzaoVarG;
                    } else {
                        zzaiVar = null;
                    }
                    if (zzaiVar == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strS)));
                    }
                    zzaiVar.a(this.f36814b, Collections.singletonList(zzaoVarA));
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }
}
