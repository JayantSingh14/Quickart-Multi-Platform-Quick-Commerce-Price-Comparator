package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
abstract class zzs {

    /* renamed from: a, reason: collision with root package name */
    public final int f22279a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f22280b = new TaskCompletionSource();

    /* renamed from: c, reason: collision with root package name */
    public final int f22281c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f22282d;

    public zzs(int i2, int i3, Bundle bundle) {
        this.f22279a = i2;
        this.f22281c = i3;
        this.f22282d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final void c(zzt zztVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + zztVar.toString());
        }
        this.f22280b.a(zztVar);
    }

    public final void d(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f22280b.b(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f22281c + " id=" + this.f22279a + " oneWay=" + b() + "}";
    }
}
