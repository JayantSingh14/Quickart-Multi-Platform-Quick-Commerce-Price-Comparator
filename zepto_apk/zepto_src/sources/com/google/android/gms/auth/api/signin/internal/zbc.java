package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zbc extends AsyncTaskLoader implements SignInConnectionListener {

    /* renamed from: k, reason: collision with root package name */
    public final Semaphore f22210k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f22211l;

    public zbc(Context context, Set set) {
        super(context);
        this.f22210k = new Semaphore(0);
        this.f22211l = set;
    }

    @Override // androidx.loader.content.Loader
    public final void e() {
        this.f22210k.drainPermits();
        k();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final /* bridge */ /* synthetic */ Object i() throws InterruptedException {
        Iterator it = this.f22211l.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((GoogleApiClient) it.next()).maybeSignIn(this)) {
                i2++;
            }
        }
        try {
            this.f22210k.tryAcquire(i2, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e2) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e2);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.f22210k.release();
    }
}
