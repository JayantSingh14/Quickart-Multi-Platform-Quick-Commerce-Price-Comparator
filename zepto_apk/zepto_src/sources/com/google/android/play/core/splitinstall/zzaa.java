package com.google.android.play.core.splitinstall;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzaa implements SplitInstallManager {

    /* renamed from: a, reason: collision with root package name */
    public final zzbc f42081a;

    /* renamed from: b, reason: collision with root package name */
    public final zzx f42082b;

    /* renamed from: c, reason: collision with root package name */
    public final zzs f42083c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbe f42084d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f42085e = new Handler(Looper.getMainLooper());

    public zzaa(zzbc zzbcVar, zzx zzxVar, zzs zzsVar, zzbe zzbeVar) {
        this.f42081a = zzbcVar;
        this.f42082b = zzxVar;
        this.f42083c = zzsVar;
        this.f42084d = zzbeVar;
    }

    public static ArrayList e(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Locale) it.next()).toLanguageTag());
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.tasks.Task a(com.google.android.play.core.splitinstall.SplitInstallRequest r12) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.zzaa.a(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.gms.tasks.Task");
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final Set b() {
        return this.f42083c.c();
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void c(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        zzx zzxVar = this.f42082b;
        synchronized (zzxVar) {
            zzxVar.f41991a.d("unregisterListener", new Object[0]);
            if (splitInstallStateUpdatedListener == null) {
                throw new NullPointerException("Unregistered Play Core listener should not be null.");
            }
            zzxVar.f41994d.remove(splitInstallStateUpdatedListener);
            zzxVar.b();
        }
    }

    @Override // com.google.android.play.core.splitinstall.SplitInstallManager
    public final synchronized void d(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        zzx zzxVar = this.f42082b;
        synchronized (zzxVar) {
            zzxVar.f41991a.d("registerListener", new Object[0]);
            zzxVar.f41994d.add(splitInstallStateUpdatedListener);
            zzxVar.b();
        }
    }
}
