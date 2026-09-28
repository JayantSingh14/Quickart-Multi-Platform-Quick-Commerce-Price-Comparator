package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {

    /* renamed from: c, reason: collision with root package name */
    public static final int f16481c = R.id.glide_custom_view_target_tag;

    /* renamed from: a, reason: collision with root package name */
    public final SizeDeterminer f16482a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f16483b;

    /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            throw null;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            throw null;
        }
    }

    @VisibleForTesting
    public static final class SizeDeterminer {

        /* renamed from: d, reason: collision with root package name */
        public static Integer f16484d;

        /* renamed from: a, reason: collision with root package name */
        public final ImageView f16485a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f16486b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public SizeDeterminerLayoutListener f16487c;

        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference f16488a;

            public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f16488a = new WeakReference(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.f16488a.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                ArrayList arrayList = sizeDeterminer.f16486b;
                if (arrayList.isEmpty()) {
                    return true;
                }
                ImageView imageView = sizeDeterminer.f16485a;
                int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int iA = sizeDeterminer.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                int iA2 = sizeDeterminer.a(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                if (iA <= 0 && iA != Integer.MIN_VALUE) {
                    return true;
                }
                if (iA2 <= 0 && iA2 != Integer.MIN_VALUE) {
                    return true;
                }
                Iterator it = new ArrayList(arrayList).iterator();
                while (it.hasNext()) {
                    ((SizeReadyCallback) it.next()).a(iA, iA2);
                }
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(sizeDeterminer.f16487c);
                }
                sizeDeterminer.f16487c = null;
                arrayList.clear();
                return true;
            }
        }

        public SizeDeterminer(ImageView imageView) {
            this.f16485a = imageView;
        }

        public final int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            ImageView imageView = this.f16485a;
            if (imageView.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = imageView.getContext();
            if (f16484d == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Preconditions.c(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f16484d = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f16484d.intValue();
        }
    }

    public CustomViewTarget(ImageView imageView) {
        Preconditions.c(imageView, "Argument must not be null");
        this.f16483b = imageView;
        this.f16482a = new SizeDeterminer(imageView);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void a(SingleRequest singleRequest) {
        this.f16482a.f16486b.remove(singleRequest);
    }

    public abstract void b(Drawable drawable);

    @Override // com.bumptech.glide.request.target.Target
    public final void c(SingleRequest singleRequest) throws Throwable {
        SizeDeterminer sizeDeterminer = this.f16482a;
        ImageView imageView = sizeDeterminer.f16485a;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iA = sizeDeterminer.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        ImageView imageView2 = sizeDeterminer.f16485a;
        int paddingBottom = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iA2 = sizeDeterminer.a(imageView2.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iA > 0 || iA == Integer.MIN_VALUE) && (iA2 > 0 || iA2 == Integer.MIN_VALUE)) {
            singleRequest.a(iA, iA2);
            return;
        }
        ArrayList arrayList = sizeDeterminer.f16486b;
        if (!arrayList.contains(singleRequest)) {
            arrayList.add(singleRequest);
        }
        if (sizeDeterminer.f16487c == null) {
            ViewTreeObserver viewTreeObserver = imageView2.getViewTreeObserver();
            SizeDeterminer.SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminer.SizeDeterminerLayoutListener(sizeDeterminer);
            sizeDeterminer.f16487c = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void e() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void f(Drawable drawable) {
        SizeDeterminer sizeDeterminer = this.f16482a;
        ViewTreeObserver viewTreeObserver = sizeDeterminer.f16485a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(sizeDeterminer.f16487c);
        }
        sizeDeterminer.f16487c = null;
        sizeDeterminer.f16486b.clear();
        b(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        Object tag = this.f16483b.getTag(f16481c);
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void i() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void j(SingleRequest singleRequest) {
        this.f16483b.setTag(f16481c, singleRequest);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    public final String toString() {
        return "Target for: " + this.f16483b;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k() {
    }
}
