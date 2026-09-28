package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public interface Target<R> extends LifecycleListener {
    void a(SingleRequest singleRequest);

    void c(SingleRequest singleRequest);

    void d();

    void f(Drawable drawable);

    void g(Object obj, Transition transition);

    Request getRequest();

    void j(SingleRequest singleRequest);

    void k();
}
