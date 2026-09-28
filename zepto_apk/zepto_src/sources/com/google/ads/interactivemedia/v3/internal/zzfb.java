package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class zzfb implements Continuation {
    public final /* synthetic */ zzff zza;

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        List<Task> list = (List) task.l();
        ArrayList arrayList = new ArrayList(list.size());
        for (Task task2 : list) {
            if (task2.p()) {
                arrayList.add(task2.l());
            }
        }
        return arrayList;
    }
}
