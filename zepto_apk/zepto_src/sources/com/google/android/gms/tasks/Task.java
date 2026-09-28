package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class Task<TResult> {
    public void a(Executor executor, OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public void b(Executor executor, OnCompleteListener onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task c(OnFailureListener onFailureListener);

    public abstract Task d(Executor executor, OnFailureListener onFailureListener);

    public abstract Task e(OnSuccessListener onSuccessListener);

    public abstract Task f(Executor executor, OnSuccessListener onSuccessListener);

    public Task g(Continuation continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public Task h(Executor executor, Continuation continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public Task i(com.google.android.gms.internal.appset.zzq zzqVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public Task j(Executor executor, Continuation continuation) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception k();

    public abstract Object l();

    public abstract Object m();

    public abstract boolean n();

    public abstract boolean o();

    public abstract boolean p();

    public Task q(SuccessContinuation successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task r(Executor executor, SuccessContinuation successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
