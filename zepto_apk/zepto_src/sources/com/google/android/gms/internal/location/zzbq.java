package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzbq implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseImplementation.ResultHolder f36638a;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        boolean zP = task.p();
        BaseImplementation.ResultHolder resultHolder = this.f36638a;
        if (zP) {
            resultHolder.setResult(Status.RESULT_SUCCESS);
            return;
        }
        if (task.n()) {
            resultHolder.setFailedResult(Status.RESULT_CANCELED);
            return;
        }
        Exception excK = task.k();
        if (excK instanceof ApiException) {
            resultHolder.setFailedResult(((ApiException) excK).getStatus());
        } else {
            resultHolder.setFailedResult(Status.RESULT_INTERNAL_ERROR);
        }
    }
}
