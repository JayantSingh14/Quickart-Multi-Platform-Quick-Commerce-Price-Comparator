package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzm extends zzj {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzj f41862b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzt f41863c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzt zztVar, TaskCompletionSource taskCompletionSource, zzj zzjVar) {
        super(taskCompletionSource);
        this.f41863c = zztVar;
        this.f41862b = zzjVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void a() {
        zzt zztVar = this.f41863c;
        zzf zzfVar = zztVar.f41881m;
        ArrayList arrayList = zztVar.f41872d;
        zzj zzjVar = this.f41862b;
        zzi zziVar = zztVar.f41870b;
        if (zzfVar != null || zztVar.f41875g) {
            if (!zztVar.f41875g) {
                zzjVar.run();
                return;
            } else {
                zziVar.a("Waiting to bind to the service.", new Object[0]);
                arrayList.add(zzjVar);
                return;
            }
        }
        zziVar.a("Initiate binding to the service.", new Object[0]);
        arrayList.add(zzjVar);
        zzs zzsVar = new zzs(zztVar);
        zztVar.f41880l = zzsVar;
        zztVar.f41875g = true;
        if (zztVar.f41869a.bindService(zztVar.f41876h, zzsVar, 1)) {
            return;
        }
        zziVar.a("Failed to bind to the service.", new Object[0]);
        zztVar.f41875g = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzj zzjVar2 = (zzj) it.next();
            zzu zzuVar = new zzu();
            TaskCompletionSource taskCompletionSource = zzjVar2.f41858a;
            if (taskCompletionSource != null) {
                taskCompletionSource.c(zzuVar);
            }
        }
        arrayList.clear();
    }
}
