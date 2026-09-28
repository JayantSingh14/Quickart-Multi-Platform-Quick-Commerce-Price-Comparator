package com.amazon.identity.auth.device.interactive;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.workflow.ListenerNotFoundException;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import l.a;

/* loaded from: classes3.dex */
public abstract class InteractiveRequest<T extends InteractiveListener<S, U, V>, S, U, V> implements InteractiveAPI, InteractiveListener<S, U, V> {

    /* renamed from: a, reason: collision with root package name */
    public RequestContext f15238a;

    public static abstract class Builder<W extends InteractiveRequest<?, ?, ?, ?>> {
        protected RequestContext requestContext;

        public Builder(RequestContext requestContext) {
            if (requestContext == null) {
                throw new IllegalArgumentException("A RequestContext is necessary for making interactive requests");
            }
            this.requestContext = requestContext;
        }

        public abstract W build();
    }

    public InteractiveRequest(RequestContext requestContext) {
        setRequestContext(requestContext);
    }

    public void assertListenerPresent() throws ListenerNotFoundException {
        this.f15238a.assertListenerPresent(this);
    }

    public Context getContext() {
        return this.f15238a.getContext();
    }

    public abstract Class<T> getListenerClass();

    public RequestContext getRequestContext() {
        return this.f15238a;
    }

    public Bundle getRequestExtras() {
        return null;
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener
    public void onCancel(U u) {
        this.f15238a.getAggregateListener(this).onCancel(u);
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    public void onError(V v) {
        this.f15238a.getAggregateListener(this).onError(v);
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, a aVar) {
        this.f15238a.getAggregateListener(this).onRequestCancel(context, interactiveRequestRecord, aVar);
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, i.f
    public void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        this.f15238a.getAggregateListener(this).onRequestCompletion(context, interactiveRequestRecord, uri);
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        this.f15238a.getAggregateListener(this).onRequestError(context, interactiveRequestRecord, exc);
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    public void onSuccess(S s) {
        this.f15238a.getAggregateListener(this).onSuccess(s);
    }

    public void setRequestContext(RequestContext requestContext) {
        if (requestContext == null) {
            throw new IllegalArgumentException("requestContext must be non-null");
        }
        this.f15238a = requestContext;
    }
}
