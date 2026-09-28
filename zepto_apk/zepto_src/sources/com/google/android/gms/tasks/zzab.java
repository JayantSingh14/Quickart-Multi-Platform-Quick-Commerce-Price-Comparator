package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class zzab implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f39754a;

    public zzab(List list) {
        this.f39754a = list;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f39754a);
        return Tasks.e(arrayList);
    }
}
