package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public final class zzak extends SmsRetrieverClient {
    public final Task b() {
        return doWrite(TaskApiCall.builder().run(new zzag()).setFeatures(zzal.f36247a).setMethodKey(1567).build());
    }
}
