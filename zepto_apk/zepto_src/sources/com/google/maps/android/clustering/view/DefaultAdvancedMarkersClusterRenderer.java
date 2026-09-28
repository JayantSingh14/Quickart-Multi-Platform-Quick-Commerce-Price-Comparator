package com.google.maps.android.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterItem;

/* loaded from: classes4.dex */
public class DefaultAdvancedMarkersClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final DecelerateInterpolator f45503a = new DecelerateInterpolator();

    /* renamed from: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$1, reason: invalid class name */
    class AnonymousClass1 implements GoogleMap.OnMarkerClickListener {
        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
        public final boolean g(Marker marker) {
            DecelerateInterpolator decelerateInterpolator = DefaultAdvancedMarkersClusterRenderer.f45503a;
            throw null;
        }
    }

    /* renamed from: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$2, reason: invalid class name */
    class AnonymousClass2 implements GoogleMap.OnInfoWindowClickListener {
        @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
        public final void a(Marker marker) {
            DecelerateInterpolator decelerateInterpolator = DefaultAdvancedMarkersClusterRenderer.f45503a;
            throw null;
        }
    }

    public class AnimationTask extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            throw null;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator.getAnimatedFraction();
            throw null;
        }
    }

    public class CreateMarkerTask {
    }

    public static class MarkerCache<T> {
    }

    @SuppressLint({"HandlerLeak"})
    public class MarkerModifier extends Handler implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        public boolean f45504a;

        public final boolean a() {
            throw null;
        }

        public final void b() {
            throw null;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (!this.f45504a) {
                Looper.myQueue().addIdleHandler(this);
                this.f45504a = true;
            }
            removeMessages(0);
            throw null;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            sendEmptyMessage(0);
            return true;
        }
    }

    public static class MarkerWithPosition {
        public final boolean equals(Object obj) {
            if (!(obj instanceof MarkerWithPosition)) {
                return false;
            }
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    public class RenderTask implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class ViewModifier extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what == 1) {
                return;
            }
            removeMessages(0);
        }
    }
}
