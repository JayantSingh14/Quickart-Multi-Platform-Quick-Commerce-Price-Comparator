package com.amazon.identity.auth.device.thread;

import android.os.Bundle;
import android.os.Looper;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.shared.APIListener;
import j.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class MAPCallbackFuture implements Future<Bundle>, APIListener {
    protected AuthError mError;
    protected final CountDownLatch mLatch;
    protected final AuthorizationListener mListener;
    protected Bundle mSuccessResult;

    public MAPCallbackFuture() {
        this(null);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    public Bundle getResultHelper() {
        AuthError authError = this.mError;
        if (authError == null) {
            return this.mSuccessResult;
        }
        Bundle errorBundle = AuthError.getErrorBundle(authError);
        errorBundle.putSerializable(AuthzConstants.BUNDLE_KEY.FUTURE.val, AuthzConstants.FUTURE_TYPE.ERROR);
        return errorBundle;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mLatch.getCount() == 0;
    }

    public MAPCallbackFuture(AuthorizationListener authorizationListener) {
        this.mListener = authorizationListener == null ? new DefaultAuthorizationListener() : authorizationListener;
        this.mLatch = new CountDownLatch(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public void onError(AuthError authError) {
        this.mError = authError;
        this.mLatch.countDown();
        this.mListener.onError(authError);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazon.identity.auth.device.shared.APIListener, com.amazon.identity.auth.device.api.Listener
    public void onSuccess(Bundle bundle) {
        this.mSuccessResult = bundle;
        if (bundle == null) {
            this.mSuccessResult = new Bundle();
        }
        this.mSuccessResult.putSerializable(AuthzConstants.BUNDLE_KEY.FUTURE.val, AuthzConstants.FUTURE_TYPE.SUCCESS);
        this.mLatch.countDown();
        this.mListener.onSuccess(bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Future
    public Bundle get() throws ExecutionException, InterruptedException {
        int i2 = a.f53503a;
        if (Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Cannot call get on the main thread, unless you want ANRs");
        }
        this.mLatch.await();
        return getResultHelper();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Future
    public Bundle get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        int i2 = a.f53503a;
        if (Looper.getMainLooper() != null && Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Cannot call get on the main thread, unless you want ANRs");
        }
        timeUnit.name();
        this.mLatch.await(j2, timeUnit);
        return getResultHelper();
    }
}
