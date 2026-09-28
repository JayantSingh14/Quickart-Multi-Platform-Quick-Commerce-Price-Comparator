package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes4.dex */
public final /* synthetic */ class u implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44899a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f44900b;

    public /* synthetic */ u(Object obj, int i2) {
        this.f44899a = i2;
        this.f44900b = obj;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Object obj = this.f44900b;
        switch (this.f44899a) {
            case 0:
                WakeLockHolder.b((Intent) obj);
                break;
            case 1:
                int i2 = WithinAppServiceBinder.f44803b;
                ((WithinAppServiceConnection.BindRequest) obj).f44812b.d(null);
                break;
            default:
                ((ScheduledFuture) obj).cancel(false);
                break;
        }
    }
}
