package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzal extends com.google.android.play.core.splitinstall.internal.zzv {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f42096b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f42097c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.google.android.play.core.splitinstall.internal.zzn f42098d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f42099e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzbc f42100f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzbc zzbcVar, TaskCompletionSource taskCompletionSource, ArrayList arrayList, ArrayList arrayList2, com.google.android.play.core.splitinstall.internal.zzn zznVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f42100f = zzbcVar;
        this.f42096b = arrayList;
        this.f42097c = arrayList2;
        this.f42098d = zznVar;
        this.f42099e = taskCompletionSource2;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzv
    public final void a() {
        TaskCompletionSource taskCompletionSource = this.f42099e;
        zzbc zzbcVar = this.f42100f;
        com.google.android.play.core.splitinstall.internal.zzn zznVar = this.f42098d;
        ArrayList arrayList = this.f42096b;
        com.google.android.play.core.splitinstall.internal.zzu zzuVar = zzbc.f42103c;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList2.add(bundle);
        }
        ArrayList arrayList3 = this.f42097c;
        ArrayList arrayList4 = new ArrayList(arrayList3.size());
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            Bundle bundle2 = new Bundle();
            bundle2.putString("language", str2);
            arrayList4.add(bundle2);
        }
        arrayList2.addAll(arrayList4);
        try {
            zznVar.a(2);
            zzbcVar.f42106b.f41952m.V7(zzbcVar.f42105a, arrayList2, zzbc.a(zznVar), new zzba(zzbcVar, taskCompletionSource));
        } catch (RemoteException e2) {
            zzbc.f42103c.c(e2, "startInstall(%s,%s)", arrayList, arrayList3);
            taskCompletionSource.c(new RuntimeException(e2));
        }
    }
}
