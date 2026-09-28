package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes4.dex */
public final class zzr implements AppSetIdClient {

    /* renamed from: a, reason: collision with root package name */
    public final zzp f36022a;

    /* renamed from: b, reason: collision with root package name */
    public final zzl f36023b;

    public zzr(Context context) {
        zzl zzlVar;
        this.f36022a = new zzp(context, GoogleApiAvailabilityLight.getInstance());
        synchronized (zzl.class) {
            try {
                Preconditions.checkNotNull(context, "Context must not be null");
                if (zzl.f36013d == null) {
                    zzl.f36013d = new zzl(context.getApplicationContext());
                }
                zzlVar = zzl.f36013d;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f36023b = zzlVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.appset.zzq] */
    @Override // com.google.android.gms.appset.AppSetIdClient
    public final Task a() {
        return this.f36022a.a().i(new Continuation() { // from class: com.google.android.gms.internal.appset.zzq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (task.p() || task.n()) {
                    return task;
                }
                Exception excK = task.k();
                if (!(excK instanceof ApiException)) {
                    return task;
                }
                int statusCode = ((ApiException) excK).getStatusCode();
                return (statusCode == 43001 || statusCode == 43002 || statusCode == 43003 || statusCode == 17) ? this.f36021a.f36023b.a() : statusCode == 43000 ? Tasks.d(new Exception("Failed to get app set ID due to an internal error. Please try again later.")) : statusCode != 15 ? task : Tasks.d(new Exception("The operation to get app set ID timed out. Please try again later."));
            }
        });
    }
}
