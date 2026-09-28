package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.android.react.lottie.LottieAnimationViewManager;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final boolean C0;
    public static final List D0;
    public static final ThreadPoolExecutor E0;
    public final Matrix A;
    public final p A0;
    public Bitmap B;
    public float B0;
    public Canvas C;
    public Rect D;
    public RectF E;
    public LPaint F;
    public Rect G;
    public Rect H;
    public RectF I;
    public RectF J;
    public Matrix K;
    public Matrix L;
    public boolean M;
    public AsyncUpdates Q;
    public final Semaphore X;
    public Handler Y;
    public p Z;

    /* renamed from: a, reason: collision with root package name */
    public LottieComposition f14152a;

    /* renamed from: b, reason: collision with root package name */
    public final LottieValueAnimator f14153b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14154c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14155d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14156e;

    /* renamed from: f, reason: collision with root package name */
    public OnVisibleAction f14157f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f14158g;

    /* renamed from: h, reason: collision with root package name */
    public ImageAssetManager f14159h;

    /* renamed from: i, reason: collision with root package name */
    public String f14160i;

    /* renamed from: j, reason: collision with root package name */
    public ImageAssetDelegate f14161j;

    /* renamed from: k, reason: collision with root package name */
    public FontAssetManager f14162k;

    /* renamed from: l, reason: collision with root package name */
    public Map f14163l;

    /* renamed from: m, reason: collision with root package name */
    public String f14164m;
    public FontAssetDelegate n;
    public TextDelegate o;
    public final LottieFeatureFlags p;
    public boolean q;
    public boolean r;
    public CompositionLayer s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public RenderMode y;
    public boolean z;

    /* renamed from: com.airbnb.lottie.LottieDrawable$1, reason: invalid class name */
    class AnonymousClass1 extends LottieValueCallback<Object> {
        @Override // com.airbnb.lottie.value.LottieValueCallback
        public final Object a(LottieFrameInfo lottieFrameInfo) {
            throw null;
        }
    }

    public interface LazyCompositionTask {
        void run();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class OnVisibleAction {

        /* renamed from: a, reason: collision with root package name */
        public static final OnVisibleAction f14165a;

        /* renamed from: b, reason: collision with root package name */
        public static final OnVisibleAction f14166b;

        /* renamed from: c, reason: collision with root package name */
        public static final OnVisibleAction f14167c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ OnVisibleAction[] f14168d;

        static {
            OnVisibleAction onVisibleAction = new OnVisibleAction("NONE", 0);
            f14165a = onVisibleAction;
            OnVisibleAction onVisibleAction2 = new OnVisibleAction("PLAY", 1);
            f14166b = onVisibleAction2;
            OnVisibleAction onVisibleAction3 = new OnVisibleAction("RESUME", 2);
            f14167c = onVisibleAction3;
            f14168d = new OnVisibleAction[]{onVisibleAction, onVisibleAction2, onVisibleAction3};
        }

        public static OnVisibleAction valueOf(String str) {
            return (OnVisibleAction) Enum.valueOf(OnVisibleAction.class, str);
        }

        public static OnVisibleAction[] values() {
            return (OnVisibleAction[]) f14168d.clone();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    static {
        C0 = Build.VERSION.SDK_INT <= 25;
        D0 = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        E0 = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new LottieThreadFactory());
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.f14153b = lottieValueAnimator;
        this.f14154c = true;
        this.f14155d = false;
        this.f14156e = false;
        this.f14157f = OnVisibleAction.f14165a;
        this.f14158g = new ArrayList();
        this.p = new LottieFeatureFlags();
        this.q = false;
        this.r = true;
        this.t = 255;
        this.x = false;
        this.y = RenderMode.f14202a;
        this.z = false;
        this.A = new Matrix();
        this.M = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                boolean z = LottieDrawable.C0;
                LottieDrawable lottieDrawable = this.f14788a;
                if (lottieDrawable.l()) {
                    lottieDrawable.invalidateSelf();
                    return;
                }
                CompositionLayer compositionLayer = lottieDrawable.s;
                if (compositionLayer != null) {
                    compositionLayer.t(lottieDrawable.f14153b.c());
                }
            }
        };
        this.X = new Semaphore(1);
        this.A0 = new p(this, 1);
        this.B0 = -3.4028235E38f;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    public static void h(Rect rect, RectF rectF) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final int A() {
        return this.f14153b.getRepeatMode();
    }

    public final float B() {
        return this.f14153b.f14798d;
    }

    public final boolean C() {
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.f14807m;
    }

    public final boolean D() {
        if (isVisible()) {
            return this.f14153b.f14807m;
        }
        OnVisibleAction onVisibleAction = this.f14157f;
        return onVisibleAction == OnVisibleAction.f14166b || onVisibleAction == OnVisibleAction.f14167c;
    }

    public final boolean E() {
        return this.p.f14171a.contains(LottieFeatureFlag.f14169a);
    }

    public final void F() {
        this.f14158g.clear();
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        lottieValueAnimator.g(true);
        Iterator it = lottieValueAnimator.f14791c.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorPauseListener) it.next()).onAnimationPause(lottieValueAnimator);
        }
        if (isVisible()) {
            return;
        }
        this.f14157f = OnVisibleAction.f14165a;
    }

    public final void G() {
        if (this.s == null) {
            this.f14158g.add(new q(this, 1));
            return;
        }
        g();
        boolean zC = c(p());
        OnVisibleAction onVisibleAction = OnVisibleAction.f14165a;
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        if (zC || lottieValueAnimator.getRepeatCount() == 0) {
            if (isVisible()) {
                lottieValueAnimator.f14807m = true;
                boolean zF = lottieValueAnimator.f();
                Iterator it = lottieValueAnimator.f14790b.iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it.next();
                    if (Build.VERSION.SDK_INT >= 26) {
                        animatorListener.onAnimationStart(lottieValueAnimator, zF);
                    } else {
                        animatorListener.onAnimationStart(lottieValueAnimator);
                    }
                }
                lottieValueAnimator.h((int) (lottieValueAnimator.f() ? lottieValueAnimator.d() : lottieValueAnimator.e()));
                lottieValueAnimator.f14800f = 0L;
                lottieValueAnimator.f14803i = 0;
                if (lottieValueAnimator.f14807m) {
                    lottieValueAnimator.g(false);
                    Choreographer.getInstance().postFrameCallback(lottieValueAnimator);
                }
                this.f14157f = onVisibleAction;
            } else {
                this.f14157f = OnVisibleAction.f14166b;
            }
        }
        if (c(p())) {
            return;
        }
        Iterator it2 = D0.iterator();
        Marker markerD = null;
        while (it2.hasNext()) {
            markerD = this.f14152a.d((String) it2.next());
            if (markerD != null) {
                break;
            }
        }
        if (markerD != null) {
            S((int) markerD.f14472b);
        } else {
            S((int) (lottieValueAnimator.f14798d < 0.0f ? lottieValueAnimator.e() : lottieValueAnimator.d()));
        }
        lottieValueAnimator.g(true);
        lottieValueAnimator.a(lottieValueAnimator.f());
        if (isVisible()) {
            return;
        }
        this.f14157f = onVisibleAction;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(android.graphics.Canvas r10, com.airbnb.lottie.model.layer.CompositionLayer r11) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieDrawable.H(android.graphics.Canvas, com.airbnb.lottie.model.layer.CompositionLayer):void");
    }

    public final void I() {
        if (this.s == null) {
            this.f14158g.add(new q(this, 0));
            return;
        }
        g();
        boolean zC = c(p());
        OnVisibleAction onVisibleAction = OnVisibleAction.f14165a;
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        if (zC || lottieValueAnimator.getRepeatCount() == 0) {
            if (isVisible()) {
                lottieValueAnimator.f14807m = true;
                lottieValueAnimator.g(false);
                Choreographer.getInstance().postFrameCallback(lottieValueAnimator);
                lottieValueAnimator.f14800f = 0L;
                if (lottieValueAnimator.f() && lottieValueAnimator.f14802h == lottieValueAnimator.e()) {
                    lottieValueAnimator.h(lottieValueAnimator.d());
                } else if (!lottieValueAnimator.f() && lottieValueAnimator.f14802h == lottieValueAnimator.d()) {
                    lottieValueAnimator.h(lottieValueAnimator.e());
                }
                Iterator it = lottieValueAnimator.f14791c.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorPauseListener) it.next()).onAnimationResume(lottieValueAnimator);
                }
                this.f14157f = onVisibleAction;
            } else {
                this.f14157f = OnVisibleAction.f14167c;
            }
        }
        if (c(p())) {
            return;
        }
        S((int) (lottieValueAnimator.f14798d < 0.0f ? lottieValueAnimator.e() : lottieValueAnimator.d()));
        lottieValueAnimator.g(true);
        lottieValueAnimator.a(lottieValueAnimator.f());
        if (isVisible()) {
            return;
        }
        this.f14157f = onVisibleAction;
    }

    public final void J() {
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        lottieValueAnimator.f14798d = -lottieValueAnimator.f14798d;
    }

    public final void K(boolean z) {
        this.w = z;
    }

    public final void L(AsyncUpdates asyncUpdates) {
        this.Q = asyncUpdates;
    }

    public final void M(boolean z) {
        if (z != this.x) {
            this.x = z;
            invalidateSelf();
        }
    }

    public final void N(boolean z) {
        if (z != this.r) {
            this.r = z;
            CompositionLayer compositionLayer = this.s;
            if (compositionLayer != null) {
                compositionLayer.J = z;
            }
            invalidateSelf();
        }
    }

    public final boolean O(LottieComposition lottieComposition) {
        if (this.f14152a == lottieComposition) {
            return false;
        }
        this.M = true;
        f();
        this.f14152a = lottieComposition;
        d();
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        boolean z = lottieValueAnimator.f14806l == null;
        lottieValueAnimator.f14806l = lottieComposition;
        if (z) {
            lottieValueAnimator.i(Math.max(lottieValueAnimator.f14804j, lottieComposition.f14146l), Math.min(lottieValueAnimator.f14805k, lottieComposition.f14147m));
        } else {
            lottieValueAnimator.i((int) lottieComposition.f14146l, (int) lottieComposition.f14147m);
        }
        float f2 = lottieValueAnimator.f14802h;
        lottieValueAnimator.f14802h = 0.0f;
        lottieValueAnimator.f14801g = 0.0f;
        lottieValueAnimator.h((int) f2);
        lottieValueAnimator.b();
        i0(lottieValueAnimator.getAnimatedFraction());
        ArrayList arrayList = this.f14158g;
        Iterator it = new ArrayList(arrayList).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run();
            }
            it.remove();
        }
        arrayList.clear();
        lottieComposition.f14135a.a(this.u);
        g();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public final void P(String str) {
        this.f14164m = str;
        FontAssetManager fontAssetManagerQ = q();
        if (fontAssetManagerQ != null) {
            fontAssetManagerQ.f14433f = str;
        }
    }

    public final void Q(FontAssetDelegate fontAssetDelegate) {
        this.n = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.f14162k;
        if (fontAssetManager != null) {
            fontAssetManager.f14432e = fontAssetDelegate;
        }
    }

    public final void R(Map map) {
        if (map == this.f14163l) {
            return;
        }
        this.f14163l = map;
        invalidateSelf();
    }

    public final void S(int i2) {
        if (this.f14152a == null) {
            this.f14158g.add(new k(this, i2, 2));
        } else {
            this.f14153b.h(i2);
        }
    }

    public final void T(boolean z) {
        this.f14155d = z;
    }

    public final void U(ImageAssetDelegate imageAssetDelegate) {
        this.f14161j = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.f14159h;
        if (imageAssetManager != null) {
            imageAssetManager.f14437c = imageAssetDelegate;
        }
    }

    public final void V(String str) {
        this.f14160i = str;
    }

    public final void W(boolean z) {
        this.q = z;
    }

    public final void X(int i2) {
        if (this.f14152a == null) {
            this.f14158g.add(new k(this, i2, 0));
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        lottieValueAnimator.i(lottieValueAnimator.f14804j, i2 + 0.99f);
    }

    public final void Y(String str) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new i(this, str, 1));
            return;
        }
        Marker markerD = lottieComposition.d(str);
        if (markerD == null) {
            throw new IllegalArgumentException(android.support.v4.media.b.D("Cannot find marker with name ", str, CLConstants.DOT_SALT_DELIMETER));
        }
        X((int) (markerD.f14472b + markerD.f14473c));
    }

    public final void Z(float f2) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new n(this, f2, 0));
            return;
        }
        float fE = MiscUtils.e(lottieComposition.f14146l, lottieComposition.f14147m, f2);
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        lottieValueAnimator.i(lottieValueAnimator.f14804j, fE);
    }

    public final void a(LottieAnimationViewManager.AnonymousClass3 anonymousClass3) {
        this.f14153b.addListener(anonymousClass3);
    }

    public final void a0(final int i2, final int i3) {
        if (this.f14152a == null) {
            this.f14158g.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    boolean z = LottieDrawable.C0;
                    this.f14675a.a0(i2, i3);
                }
            });
        } else {
            this.f14153b.i(i2, i3 + 0.99f);
        }
    }

    public final void b(final KeyPath keyPath, final ColorFilter colorFilter, final LottieValueCallback lottieValueCallback) {
        CompositionLayer compositionLayer = this.s;
        if (compositionLayer == null) {
            this.f14158g.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.m
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    boolean z = LottieDrawable.C0;
                    this.f14424a.b(keyPath, colorFilter, lottieValueCallback);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (keyPath == KeyPath.f14466c) {
            compositionLayer.d(colorFilter, lottieValueCallback);
        } else {
            KeyPathElement keyPathElement = keyPath.f14468b;
            if (keyPathElement != null) {
                keyPathElement.d(colorFilter, lottieValueCallback);
            } else {
                ArrayList arrayList = new ArrayList();
                this.s.e(keyPath, 0, arrayList, new KeyPath(new String[0]));
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((KeyPath) arrayList.get(i2)).f14468b.d(colorFilter, lottieValueCallback);
                }
                zIsEmpty = true ^ arrayList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (colorFilter == LottieProperty.z) {
                i0(this.f14153b.c());
            }
        }
    }

    public final void b0(String str) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new i(this, str, 0));
            return;
        }
        Marker markerD = lottieComposition.d(str);
        if (markerD == null) {
            throw new IllegalArgumentException(android.support.v4.media.b.D("Cannot find marker with name ", str, CLConstants.DOT_SALT_DELIMETER));
        }
        int i2 = (int) markerD.f14472b;
        a0(i2, ((int) markerD.f14473c) + i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.content.Context r4) {
        /*
            r3 = this;
            boolean r0 = r3.f14155d
            if (r0 == 0) goto L5
            goto L2c
        L5:
            boolean r0 = r3.f14154c
            if (r0 == 0) goto L2e
            com.airbnb.lottie.configurations.reducemotion.SystemReducedMotionOption r0 = com.airbnb.lottie.L.f14108c
            r0.getClass()
            com.airbnb.lottie.configurations.reducemotion.ReducedMotionMode r0 = com.airbnb.lottie.configurations.reducemotion.ReducedMotionMode.f14397a
            if (r4 == 0) goto L29
            java.lang.ThreadLocal r1 = com.airbnb.lottie.utils.Utils.f14810a
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r1 = "animator_duration_scale"
            r2 = 1065353216(0x3f800000, float:1.0)
            float r4 = android.provider.Settings.Global.getFloat(r4, r1, r2)
            r1 = 0
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 == 0) goto L26
            goto L29
        L26:
            com.airbnb.lottie.configurations.reducemotion.ReducedMotionMode r4 = com.airbnb.lottie.configurations.reducemotion.ReducedMotionMode.f14398b
            goto L2a
        L29:
            r4 = r0
        L2a:
            if (r4 != r0) goto L2e
        L2c:
            r4 = 1
            return r4
        L2e:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieDrawable.c(android.content.Context):boolean");
    }

    public final void c0(final float f2, final float f3) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.j
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run() {
                    boolean z = LottieDrawable.C0;
                    this.f14418a.c0(f2, f3);
                }
            });
            return;
        }
        int iE = (int) MiscUtils.e(lottieComposition.f14146l, lottieComposition.f14147m, f2);
        LottieComposition lottieComposition2 = this.f14152a;
        a0(iE, (int) MiscUtils.e(lottieComposition2.f14146l, lottieComposition2.f14147m, f3));
    }

    public final void d() {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            return;
        }
        JsonReader.Options options = LayerParser.f14722a;
        Rect rect = lottieComposition.f14145k;
        List list = Collections.EMPTY_LIST;
        CompositionLayer compositionLayer = new CompositionLayer(this, new Layer(list, lottieComposition, "__container", -1L, Layer.LayerType.f14651a, -1L, null, list, new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, list, Layer.MatteType.f14655a, null, false, null, null, LBlendMode.f14533a), lottieComposition.f14144j, lottieComposition);
        this.s = compositionLayer;
        if (this.v) {
            compositionLayer.s(true);
        }
        this.s.J = this.r;
    }

    public final void d0(int i2) {
        if (this.f14152a == null) {
            this.f14158g.add(new k(this, i2, 1));
        } else {
            this.f14153b.i(i2, (int) r0.f14805k);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        LottieComposition lottieComposition;
        CompositionLayer compositionLayer = this.s;
        if (compositionLayer == null) {
            return;
        }
        boolean zL = l();
        ThreadPoolExecutor threadPoolExecutor = E0;
        Semaphore semaphore = this.X;
        p pVar = this.A0;
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        if (zL) {
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
                NetworkFetcher networkFetcher = L.f14106a;
                if (!zL) {
                    return;
                }
                semaphore.release();
                if (compositionLayer.I == lottieValueAnimator.c()) {
                    return;
                }
            } catch (Throwable th) {
                NetworkFetcher networkFetcher2 = L.f14106a;
                if (zL) {
                    semaphore.release();
                    if (compositionLayer.I != lottieValueAnimator.c()) {
                        threadPoolExecutor.execute(pVar);
                    }
                }
                throw th;
            }
        }
        NetworkFetcher networkFetcher3 = L.f14106a;
        if (zL && (lottieComposition = this.f14152a) != null) {
            float f2 = this.B0;
            float fC = lottieValueAnimator.c();
            this.B0 = fC;
            if (Math.abs(fC - f2) * lottieComposition.b() >= 50.0f) {
                i0(lottieValueAnimator.c());
            }
        }
        if (this.f14156e) {
            try {
                if (this.z) {
                    H(canvas, compositionLayer);
                } else {
                    i(canvas);
                }
            } catch (Throwable unused2) {
                Logger.f14793a.getClass();
                NetworkFetcher networkFetcher4 = L.f14106a;
            }
        } else if (this.z) {
            H(canvas, compositionLayer);
        } else {
            i(canvas);
        }
        this.M = false;
        if (zL) {
            semaphore.release();
            if (compositionLayer.I == lottieValueAnimator.c()) {
                return;
            }
            threadPoolExecutor.execute(pVar);
        }
    }

    public final void e() {
        this.f14158g.clear();
        this.f14153b.cancel();
        if (isVisible()) {
            return;
        }
        this.f14157f = OnVisibleAction.f14165a;
    }

    public final void e0(String str) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new i(this, str, 2));
            return;
        }
        Marker markerD = lottieComposition.d(str);
        if (markerD == null) {
            throw new IllegalArgumentException(android.support.v4.media.b.D("Cannot find marker with name ", str, CLConstants.DOT_SALT_DELIMETER));
        }
        d0((int) markerD.f14472b);
    }

    public final void f() {
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        if (lottieValueAnimator.f14807m) {
            lottieValueAnimator.cancel();
            if (!isVisible()) {
                this.f14157f = OnVisibleAction.f14165a;
            }
        }
        this.f14152a = null;
        this.s = null;
        this.f14159h = null;
        this.B0 = -3.4028235E38f;
        lottieValueAnimator.f14806l = null;
        lottieValueAnimator.f14804j = -2.14748365E9f;
        lottieValueAnimator.f14805k = 2.14748365E9f;
        invalidateSelf();
    }

    public final void f0(float f2) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new n(this, f2, 1));
        } else {
            d0((int) MiscUtils.e(lottieComposition.f14146l, lottieComposition.f14147m, f2));
        }
    }

    public final void g() {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            return;
        }
        RenderMode renderMode = this.y;
        int i2 = Build.VERSION.SDK_INT;
        boolean z = lottieComposition.o;
        int i3 = lottieComposition.p;
        int iOrdinal = renderMode.ordinal();
        boolean z2 = false;
        if (iOrdinal != 1 && (iOrdinal == 2 || ((z && i2 < 28) || i3 > 4 || i2 <= 25))) {
            z2 = true;
        }
        this.z = z2;
    }

    public final void g0(boolean z) {
        if (this.v == z) {
            return;
        }
        this.v = z;
        CompositionLayer compositionLayer = this.s;
        if (compositionLayer != null) {
            compositionLayer.s(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.f14145k.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.f14145k.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h0(boolean z) {
        this.u = z;
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition != null) {
            lottieComposition.f14135a.a(z);
        }
    }

    public final void i(Canvas canvas) {
        CompositionLayer compositionLayer = this.s;
        LottieComposition lottieComposition = this.f14152a;
        if (compositionLayer == null || lottieComposition == null) {
            return;
        }
        Matrix matrix = this.A;
        matrix.reset();
        if (!getBounds().isEmpty()) {
            matrix.preScale(r3.width() / lottieComposition.f14145k.width(), r3.height() / lottieComposition.f14145k.height());
            matrix.preTranslate(r3.left, r3.top);
        }
        compositionLayer.h(canvas, matrix, this.t);
    }

    public final void i0(float f2) {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition == null) {
            this.f14158g.add(new n(this, f2, 2));
            return;
        }
        NetworkFetcher networkFetcher = L.f14106a;
        this.f14153b.h(MiscUtils.e(lottieComposition.f14146l, lottieComposition.f14147m, f2));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable.Callback callback;
        if (this.M) {
            return;
        }
        this.M = true;
        if ((!C0 || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return C();
    }

    public final void j(boolean z) {
        LottieFeatureFlag lottieFeatureFlag = LottieFeatureFlag.f14169a;
        HashSet hashSet = this.p.f14171a;
        boolean zAdd = z ? hashSet.add(lottieFeatureFlag) : hashSet.remove(lottieFeatureFlag);
        if (this.f14152a == null || !zAdd) {
            return;
        }
        d();
    }

    public final void j0(RenderMode renderMode) {
        this.y = renderMode;
        g();
    }

    public final AsyncUpdates k() {
        AsyncUpdates asyncUpdates = this.Q;
        if (asyncUpdates != null) {
            return asyncUpdates;
        }
        NetworkFetcher networkFetcher = L.f14106a;
        return AsyncUpdates.f14103a;
    }

    public final void k0(int i2) {
        this.f14153b.setRepeatCount(i2);
    }

    public final boolean l() {
        return k() == AsyncUpdates.f14104b;
    }

    public final void l0(int i2) {
        this.f14153b.setRepeatMode(i2);
    }

    public final boolean m() {
        return this.x;
    }

    public final void m0(boolean z) {
        this.f14156e = z;
    }

    public final boolean n() {
        return this.r;
    }

    public final void n0(float f2) {
        this.f14153b.f14798d = f2;
    }

    public final LottieComposition o() {
        return this.f14152a;
    }

    public final void o0(TextDelegate textDelegate) {
        this.o = textDelegate;
    }

    public final Context p() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public final void p0(boolean z) {
        this.f14153b.n = z;
    }

    public final FontAssetManager q() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f14162k == null) {
            FontAssetManager fontAssetManager = new FontAssetManager(getCallback(), this.n);
            this.f14162k = fontAssetManager;
            String str = this.f14164m;
            if (str != null) {
                fontAssetManager.f14433f = str;
            }
        }
        return this.f14162k;
    }

    public final int r() {
        return (int) this.f14153b.f14802h;
    }

    public final String s() {
        return this.f14160i;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.t = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Logger.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        OnVisibleAction onVisibleAction = OnVisibleAction.f14167c;
        if (z) {
            OnVisibleAction onVisibleAction2 = this.f14157f;
            if (onVisibleAction2 == OnVisibleAction.f14166b) {
                G();
                return visible;
            }
            if (onVisibleAction2 == onVisibleAction) {
                I();
                return visible;
            }
        } else {
            if (this.f14153b.f14807m) {
                F();
                this.f14157f = onVisibleAction;
                return visible;
            }
            if (zIsVisible) {
                this.f14157f = OnVisibleAction.f14165a;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        G();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f14158g.clear();
        LottieValueAnimator lottieValueAnimator = this.f14153b;
        lottieValueAnimator.g(true);
        lottieValueAnimator.a(lottieValueAnimator.f());
        if (isVisible()) {
            return;
        }
        this.f14157f = OnVisibleAction.f14165a;
    }

    public final boolean t() {
        return this.q;
    }

    public final float u() {
        return this.f14153b.d();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final float v() {
        return this.f14153b.e();
    }

    public final PerformanceTracker w() {
        LottieComposition lottieComposition = this.f14152a;
        if (lottieComposition != null) {
            return lottieComposition.f14135a;
        }
        return null;
    }

    public final float x() {
        return this.f14153b.c();
    }

    public final RenderMode y() {
        return this.z ? RenderMode.f14204c : RenderMode.f14203b;
    }

    public final int z() {
        return this.f14153b.getRepeatCount();
    }
}
