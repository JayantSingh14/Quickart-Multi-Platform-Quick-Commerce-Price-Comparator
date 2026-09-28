package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzab implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzab f22246a = new zzab();

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        Intent intent = (Intent) ((Bundle) task.l()).getParcelable("notification_data");
        if (intent != null) {
            return new CloudMessage(intent);
        }
        return null;
    }
}
