package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.collection.IndexBasedArrayIterator;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.MeanCalculator;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    public float A;
    public BlurMaskFilter B;
    public LPaint C;

    /* renamed from: a, reason: collision with root package name */
    public final Path f14622a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f14623b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f14624c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public final LPaint f14625d = new LPaint(1);

    /* renamed from: e, reason: collision with root package name */
    public final LPaint f14626e;

    /* renamed from: f, reason: collision with root package name */
    public final LPaint f14627f;

    /* renamed from: g, reason: collision with root package name */
    public final LPaint f14628g;

    /* renamed from: h, reason: collision with root package name */
    public final LPaint f14629h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f14630i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f14631j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f14632k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f14633l;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f14634m;
    public final Matrix n;
    public final LottieDrawable o;
    public final Layer p;
    public final MaskKeyframeAnimation q;
    public final FloatKeyframeAnimation r;
    public BaseLayer s;
    public BaseLayer t;
    public List u;
    public final ArrayList v;
    public final TransformKeyframeAnimation w;
    public boolean x;
    public boolean y;
    public LPaint z;

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14635a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14636b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f14636b = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14636b[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14636b[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14636b[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f14635a = iArr2;
            try {
                iArr2[4] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14635a[0] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14635a[1] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14635a[2] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14635a[3] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14635a[5] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14635a[6] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f14626e = new LPaint(mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f14627f = new LPaint(mode2);
        LPaint lPaint = new LPaint(1);
        this.f14628g = lPaint;
        PorterDuff.Mode mode3 = PorterDuff.Mode.CLEAR;
        LPaint lPaint2 = new LPaint();
        lPaint2.setXfermode(new PorterDuffXfermode(mode3));
        this.f14629h = lPaint2;
        this.f14630i = new RectF();
        this.f14631j = new RectF();
        this.f14632k = new RectF();
        this.f14633l = new RectF();
        this.f14634m = new RectF();
        this.n = new Matrix();
        this.v = new ArrayList();
        this.x = true;
        this.A = 0.0f;
        this.o = lottieDrawable;
        this.p = layer;
        if (layer.u == Layer.MatteType.f14656b) {
            lPaint.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(mode));
        }
        AnimatableTransform animatableTransform = layer.f14646i;
        animatableTransform.getClass();
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.w = transformKeyframeAnimation;
        transformKeyframeAnimation.b(this);
        List list = layer.f14645h;
        if (list != null && !list.isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(list);
            this.q = maskKeyframeAnimation;
            Iterator it = maskKeyframeAnimation.f14357a.iterator();
            while (it.hasNext()) {
                ((BaseKeyframeAnimation) it.next()).a(this);
            }
            Iterator it2 = this.q.f14358b.iterator();
            while (it2.hasNext()) {
                BaseKeyframeAnimation baseKeyframeAnimation = (BaseKeyframeAnimation) it2.next();
                g(baseKeyframeAnimation);
                baseKeyframeAnimation.a(this);
            }
        }
        Layer layer2 = this.p;
        if (layer2.t.isEmpty()) {
            if (true != this.x) {
                this.x = true;
                this.o.invalidateSelf();
                return;
            }
            return;
        }
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(layer2.t);
        this.r = floatKeyframeAnimation;
        floatKeyframeAnimation.f14330b = true;
        floatKeyframeAnimation.a(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.model.layer.a
            @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
            public final void a() {
                BaseLayer baseLayer = this.f14661a;
                boolean z = baseLayer.r.l() == 1.0f;
                if (z != baseLayer.x) {
                    baseLayer.x = z;
                    baseLayer.o.invalidateSelf();
                }
            }
        });
        boolean z = ((Float) this.r.f()).floatValue() == 1.0f;
        if (z != this.x) {
            this.x = z;
            this.o.invalidateSelf();
        }
        g(this.r);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.o.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        this.w.c(colorFilter, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        BaseLayer baseLayer = this.s;
        Layer layer = this.p;
        if (baseLayer != null) {
            String str = baseLayer.p.f14640c;
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.f14467a.add(str);
            if (keyPath.a(i2, this.s.p.f14640c)) {
                BaseLayer baseLayer2 = this.s;
                KeyPath keyPath4 = new KeyPath(keyPath3);
                keyPath4.f14468b = baseLayer2;
                arrayList.add(keyPath4);
            }
            if (keyPath.d(i2, layer.f14640c)) {
                this.s.r(keyPath, keyPath.b(i2, this.s.p.f14640c) + i2, arrayList, keyPath3);
            }
        }
        if (keyPath.c(i2, layer.f14640c)) {
            String str2 = layer.f14640c;
            if (!"__container".equals(str2)) {
                KeyPath keyPath5 = new KeyPath(keyPath2);
                keyPath5.f14467a.add(str2);
                if (keyPath.a(i2, str2)) {
                    KeyPath keyPath6 = new KeyPath(keyPath5);
                    keyPath6.f14468b = this;
                    arrayList.add(keyPath6);
                }
                keyPath2 = keyPath5;
            }
            if (keyPath.d(i2, str2)) {
                r(keyPath, keyPath.b(i2, str2) + i2, arrayList, keyPath2);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z) {
        this.f14630i.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
        Matrix matrix2 = this.n;
        matrix2.set(matrix);
        if (z) {
            List list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    matrix2.preConcat(((BaseLayer) this.u.get(size)).w.e());
                }
            } else {
                BaseLayer baseLayer = this.t;
                if (baseLayer != null) {
                    matrix2.preConcat(baseLayer.w.e());
                }
            }
        }
        matrix2.preConcat(this.w.e());
    }

    public final void g(BaseKeyframeAnimation baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.v.add(baseKeyframeAnimation);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117  */
    @Override // com.airbnb.lottie.animation.content.DrawingContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.graphics.Canvas r23, android.graphics.Matrix r24, int r25) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.BaseLayer.h(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void i() {
        if (this.u != null) {
            return;
        }
        if (this.t == null) {
            this.u = Collections.EMPTY_LIST;
            return;
        }
        this.u = new ArrayList();
        for (BaseLayer baseLayer = this.t; baseLayer != null; baseLayer = baseLayer.t) {
            this.u.add(baseLayer);
        }
    }

    public final void k(Canvas canvas) {
        NetworkFetcher networkFetcher = L.f14106a;
        RectF rectF = this.f14630i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f14629h);
    }

    public abstract void l(Canvas canvas, Matrix matrix, int i2);

    public BlurEffect m() {
        return this.p.w;
    }

    public DropShadowEffect n() {
        return this.p.x;
    }

    public final boolean o() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.q;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.f14357a.isEmpty()) ? false : true;
    }

    public final void p() {
        PerformanceTracker performanceTracker = this.o.f14152a.f14135a;
        String str = this.p.f14640c;
        if (!performanceTracker.f14199a) {
            return;
        }
        HashMap map = performanceTracker.f14201c;
        MeanCalculator meanCalculator = (MeanCalculator) map.get(str);
        if (meanCalculator == null) {
            meanCalculator = new MeanCalculator();
            map.put(str, meanCalculator);
        }
        int i2 = meanCalculator.f14808a + 1;
        meanCalculator.f14808a = i2;
        if (i2 == Integer.MAX_VALUE) {
            meanCalculator.f14808a = i2 / 2;
        }
        if (!str.equals("__container")) {
            return;
        }
        Iterator it = performanceTracker.f14200b.iterator();
        while (true) {
            IndexBasedArrayIterator indexBasedArrayIterator = (IndexBasedArrayIterator) it;
            if (!indexBasedArrayIterator.hasNext()) {
                return;
            } else {
                ((PerformanceTracker.FrameListener) indexBasedArrayIterator.next()).a();
            }
        }
    }

    public final void q(BaseKeyframeAnimation baseKeyframeAnimation) {
        this.v.remove(baseKeyframeAnimation);
    }

    public void s(boolean z) {
        if (z && this.z == null) {
            this.z = new LPaint();
        }
        this.y = z;
    }

    public void t(float f2) {
        NetworkFetcher networkFetcher = L.f14106a;
        TransformKeyframeAnimation transformKeyframeAnimation = this.w;
        BaseKeyframeAnimation baseKeyframeAnimation = transformKeyframeAnimation.f14389j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.j(f2);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = transformKeyframeAnimation.f14392m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.j(f2);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = transformKeyframeAnimation.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.j(f2);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = transformKeyframeAnimation.f14385f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.j(f2);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = transformKeyframeAnimation.f14386g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.j(f2);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = transformKeyframeAnimation.f14387h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.j(f2);
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = transformKeyframeAnimation.f14388i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.j(f2);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = transformKeyframeAnimation.f14390k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.j(f2);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = transformKeyframeAnimation.f14391l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.j(f2);
        }
        MaskKeyframeAnimation maskKeyframeAnimation = this.q;
        int i2 = 0;
        if (maskKeyframeAnimation != null) {
            int i3 = 0;
            while (true) {
                ArrayList arrayList = maskKeyframeAnimation.f14357a;
                if (i3 >= arrayList.size()) {
                    break;
                }
                ((BaseKeyframeAnimation) arrayList.get(i3)).j(f2);
                i3++;
            }
            NetworkFetcher networkFetcher2 = L.f14106a;
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.r;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.j(f2);
        }
        BaseLayer baseLayer = this.s;
        if (baseLayer != null) {
            baseLayer.t(f2);
        }
        while (true) {
            ArrayList arrayList2 = this.v;
            if (i2 >= arrayList2.size()) {
                NetworkFetcher networkFetcher3 = L.f14106a;
                return;
            } else {
                ((BaseKeyframeAnimation) arrayList2.get(i2)).j(f2);
                i2++;
            }
        }
    }

    public void r(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
    }
}
