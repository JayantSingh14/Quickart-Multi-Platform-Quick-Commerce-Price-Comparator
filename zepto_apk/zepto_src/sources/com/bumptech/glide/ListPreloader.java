package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public int f15679a;

    /* renamed from: b, reason: collision with root package name */
    public int f15680b;

    /* renamed from: c, reason: collision with root package name */
    public int f15681c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15682d;

    public interface PreloadModelProvider<U> {
    }

    public interface PreloadSizeProvider<T> {
    }

    public static final class PreloadTargetQueue {
    }

    public final void a(int i2, boolean z) {
        if (this.f15682d != z) {
            this.f15682d = z;
            throw null;
        }
        int iMin = Math.min(this.f15681c, Math.min(this.f15679a, i2));
        int iMin2 = Math.min(this.f15681c, Math.max(0, i2));
        if (iMin - 1 >= iMin2) {
            throw null;
        }
        this.f15679a = iMin2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.f15681c = i4;
        int i5 = this.f15680b;
        if (i2 > i5) {
            a(i3 + i2, true);
        } else if (i2 < i5) {
            a(i2, false);
        }
        this.f15680b = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    public static final class PreloadTarget implements Target<Object> {

        /* renamed from: a, reason: collision with root package name */
        public SingleRequest f15683a;

        @Override // com.bumptech.glide.request.target.Target
        public final void c(SingleRequest singleRequest) throws Throwable {
            singleRequest.a(0, 0);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void e() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void f(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void g(Object obj, Transition transition) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final Request getRequest() {
            return this.f15683a;
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void i() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void j(SingleRequest singleRequest) {
            this.f15683a = singleRequest;
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public final void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void d() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void k() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void a(SingleRequest singleRequest) {
        }
    }
}
