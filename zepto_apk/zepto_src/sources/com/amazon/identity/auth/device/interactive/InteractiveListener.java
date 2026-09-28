package com.amazon.identity.auth.device.interactive;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.api.CancellableListener;
import i.f;
import l.a;

/* loaded from: classes3.dex */
public interface InteractiveListener<T, U, V> extends CancellableListener<T, U, V>, InteractiveAPI, f {
    @Override // com.amazon.identity.auth.device.api.CancellableListener
    void onCancel(U u);

    @Override // com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    void onError(V v);

    /* synthetic */ void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, a aVar);

    /* synthetic */ void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri);

    /* synthetic */ void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc);

    @Override // com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    void onSuccess(T t);
}
