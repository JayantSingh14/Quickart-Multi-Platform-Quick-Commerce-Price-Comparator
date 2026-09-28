package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final class zzau implements FusedLocationProviderApi {
    public static TaskCompletionSource a(final BaseImplementation.ResultHolder resultHolder) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.f39750a.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzah
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                boolean zP = task.p();
                BaseImplementation.ResultHolder resultHolder2 = resultHolder;
                if (zP) {
                    resultHolder2.setResult(Status.RESULT_SUCCESS);
                    return;
                }
                if (task.n()) {
                    resultHolder2.setFailedResult(Status.RESULT_CANCELED);
                    return;
                }
                Exception excK = task.k();
                if (excK instanceof ApiException) {
                    resultHolder2.setFailedResult(((ApiException) excK).getStatus());
                } else {
                    resultHolder2.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            }
        });
        return taskCompletionSource;
    }
}
