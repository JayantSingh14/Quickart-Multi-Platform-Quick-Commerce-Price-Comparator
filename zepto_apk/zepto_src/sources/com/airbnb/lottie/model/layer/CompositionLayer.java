package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CompositionLayer extends BaseLayer {
    public BaseKeyframeAnimation D;
    public final ArrayList E;
    public final RectF F;
    public final RectF G;
    public final Paint H;
    public float I;
    public boolean J;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14637a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f14637a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14637a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List list, LottieComposition lottieComposition) {
        int i2;
        BaseLayer baseLayer;
        BaseLayer compositionLayer;
        super(lottieDrawable, layer);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.J = true;
        AnimatableFloatValue animatableFloatValue = layer.s;
        if (animatableFloatValue != null) {
            FloatKeyframeAnimation floatKeyframeAnimationA = animatableFloatValue.a();
            this.D = floatKeyframeAnimationA;
            g(floatKeyframeAnimationA);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.f14144j.size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = (Layer) list.get(size);
            int iOrdinal = layer2.f14642e.ordinal();
            if (iOrdinal == 0) {
                compositionLayer = new CompositionLayer(lottieDrawable, layer2, (List) lottieComposition.f14137c.get(layer2.f14644g), lottieComposition);
            } else if (iOrdinal == 1) {
                compositionLayer = new SolidLayer(lottieDrawable, layer2);
            } else if (iOrdinal == 2) {
                compositionLayer = new ImageLayer(lottieDrawable, layer2);
            } else if (iOrdinal == 3) {
                compositionLayer = new NullLayer(lottieDrawable, layer2);
            } else if (iOrdinal == 4) {
                compositionLayer = new ShapeLayer(lottieDrawable, layer2, this, lottieComposition);
            } else if (iOrdinal != 5) {
                Logger.b("Unknown layer type " + layer2.f14642e);
                compositionLayer = null;
            } else {
                compositionLayer = new TextLayer(lottieDrawable, layer2);
            }
            if (compositionLayer != null) {
                longSparseArray.g(compositionLayer.p.f14641d, compositionLayer);
                if (baseLayer2 != null) {
                    baseLayer2.s = compositionLayer;
                    baseLayer2 = null;
                } else {
                    this.E.add(0, compositionLayer);
                    int iOrdinal2 = layer2.u.ordinal();
                    if (iOrdinal2 == 1 || iOrdinal2 == 2) {
                        baseLayer2 = compositionLayer;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.h(); i2++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.c(longSparseArray.f(i2));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.c(baseLayer3.p.f14643f)) != null) {
                baseLayer3.t = baseLayer;
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        super.d(colorFilter, lottieValueCallback);
        if (colorFilter == LottieProperty.z) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.D = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            g(this.D);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        super.f(rectF, matrix, z);
        ArrayList arrayList = this.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.F;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((BaseLayer) arrayList.get(size)).f(rectF2, this.n, true);
            rectF.union(rectF2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void l(Canvas canvas, Matrix matrix, int i2) {
        NetworkFetcher networkFetcher = L.f14106a;
        RectF rectF = this.G;
        Layer layer = this.p;
        rectF.set(0.0f, 0.0f, layer.o, layer.p);
        matrix.mapRect(rectF);
        boolean z = this.o.w;
        ArrayList arrayList = this.E;
        boolean z2 = z && arrayList.size() > 1 && i2 != 255;
        if (z2) {
            Paint paint = this.H;
            paint.setAlpha(i2);
            Utils.e(canvas, paint, rectF);
        } else {
            canvas.save();
        }
        if (z2) {
            i2 = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((this.J || !"__container".equals(layer.f14640c)) && !rectF.isEmpty()) ? canvas.clipRect(rectF) : true) {
                ((BaseLayer) arrayList.get(size)).h(canvas, matrix, i2);
            }
        }
        canvas.restore();
        NetworkFetcher networkFetcher2 = L.f14106a;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void r(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList2 = this.E;
            if (i3 >= arrayList2.size()) {
                return;
            }
            ((BaseLayer) arrayList2.get(i3)).e(keyPath, i2, arrayList, keyPath2);
            i3++;
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void s(boolean z) {
        super.s(z);
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            ((BaseLayer) it.next()).s(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void t(float f2) {
        NetworkFetcher networkFetcher = L.f14106a;
        this.I = f2;
        super.t(f2);
        BaseKeyframeAnimation baseKeyframeAnimation = this.D;
        Layer layer = this.p;
        if (baseKeyframeAnimation != null) {
            LottieComposition lottieComposition = this.o.f14152a;
            f2 = ((((Float) baseKeyframeAnimation.f()).floatValue() * layer.f14639b.n) - layer.f14639b.f14146l) / ((lottieComposition.f14147m - lottieComposition.f14146l) + 0.01f);
        }
        if (this.D == null) {
            LottieComposition lottieComposition2 = layer.f14639b;
            f2 -= layer.n / (lottieComposition2.f14147m - lottieComposition2.f14146l);
        }
        if (layer.f14650m != 0.0f && !"__container".equals(layer.f14640c)) {
            f2 /= layer.f14650m;
        }
        ArrayList arrayList = this.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((BaseLayer) arrayList.get(size)).t(f2);
        }
        NetworkFetcher networkFetcher2 = L.f14106a;
    }
}
