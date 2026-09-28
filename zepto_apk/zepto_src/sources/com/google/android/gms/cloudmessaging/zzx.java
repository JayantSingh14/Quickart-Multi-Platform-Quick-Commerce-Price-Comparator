package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzx implements SuccessContinuation {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzx f22291a = new zzx();

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i2 = Rpc.f22235h;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? Tasks.e(bundle) : Tasks.e(null);
    }
}
