package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzaa implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzaa f22245a = new zzaa();

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) throws IOException {
        if (task.p()) {
            return (Bundle) task.l();
        }
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Error making request: ".concat(String.valueOf(task.k())));
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.k());
    }
}
