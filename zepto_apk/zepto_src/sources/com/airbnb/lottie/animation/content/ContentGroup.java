package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: a, reason: collision with root package name */
    public final LPaint f14227a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f14228b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f14229c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f14230d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f14231e;

    /* renamed from: f, reason: collision with root package name */
    public final String f14232f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f14233g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f14234h;

    /* renamed from: i, reason: collision with root package name */
    public final LottieDrawable f14235i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f14236j;

    /* renamed from: k, reason: collision with root package name */
    public final TransformKeyframeAnimation f14237k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup, LottieComposition lottieComposition) {
        AnimatableTransform animatableTransform;
        String str = shapeGroup.f14588a;
        List list = shapeGroup.f14589b;
        ArrayList arrayList = new ArrayList(list.size());
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Content contentA = ((ContentModel) list.get(i3)).a(lottieDrawable, lottieComposition, baseLayer);
            if (contentA != null) {
                arrayList.add(contentA);
            }
        }
        while (true) {
            if (i2 >= list.size()) {
                animatableTransform = null;
                break;
            }
            ContentModel contentModel = (ContentModel) list.get(i2);
            if (contentModel instanceof AnimatableTransform) {
                animatableTransform = (AnimatableTransform) contentModel;
                break;
            }
            i2++;
        }
        this(lottieDrawable, baseLayer, str, shapeGroup.f14590c, arrayList, animatableTransform);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14235i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        int size = list.size();
        ArrayList arrayList = this.f14234h;
        ArrayList arrayList2 = new ArrayList(arrayList.size() + size);
        arrayList2.addAll(list);
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            Content content = (Content) arrayList.get(size2);
            content.b(arrayList2, arrayList.subList(0, size2));
            arrayList2.add(content);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f14237k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.c(colorFilter, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        String str = this.f14232f;
        if (!keyPath.c(i2, str) && !"__container".equals(str)) {
            return;
        }
        if (!"__container".equals(str)) {
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.f14467a.add(str);
            if (keyPath.a(i2, str)) {
                KeyPath keyPath4 = new KeyPath(keyPath3);
                keyPath4.f14468b = this;
                arrayList.add(keyPath4);
            }
            keyPath2 = keyPath3;
        }
        if (!keyPath.d(i2, str)) {
            return;
        }
        int iB = keyPath.b(i2, str) + i2;
        int i3 = 0;
        while (true) {
            ArrayList arrayList2 = this.f14234h;
            if (i3 >= arrayList2.size()) {
                return;
            }
            Content content = (Content) arrayList2.get(i3);
            if (content instanceof KeyPathElement) {
                ((KeyPathElement) content).e(keyPath, iB, arrayList, keyPath2);
            }
            i3++;
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        Matrix matrix2 = this.f14229c;
        matrix2.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f14237k;
        if (transformKeyframeAnimation != null) {
            matrix2.preConcat(transformKeyframeAnimation.e());
        }
        RectF rectF2 = this.f14231e;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        ArrayList arrayList = this.f14234h;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Content content = (Content) arrayList.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).f(rectF2, matrix2, z);
                rectF.union(rectF2);
            }
        }
    }

    public final List g() {
        if (this.f14236j == null) {
            this.f14236j = new ArrayList();
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f14234h;
                if (i2 >= arrayList.size()) {
                    break;
                }
                Content content = (Content) arrayList.get(i2);
                if (content instanceof PathContent) {
                    this.f14236j.add((PathContent) content);
                }
                i2++;
            }
        }
        return this.f14236j;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        throw null;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void h(Canvas canvas, Matrix matrix, int i2) {
        if (this.f14233g) {
            return;
        }
        Matrix matrix2 = this.f14229c;
        matrix2.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f14237k;
        if (transformKeyframeAnimation != null) {
            matrix2.preConcat(transformKeyframeAnimation.e());
            i2 = (int) (((((transformKeyframeAnimation.f14389j == null ? 100 : ((Integer) r9.f()).intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f14235i.w;
        ArrayList arrayList = this.f14234h;
        boolean z2 = false;
        if (z) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (!(arrayList.get(i3) instanceof DrawingContent) || (i4 = i4 + 1) < 2) {
                    i3++;
                } else if (i2 != 255) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            RectF rectF = this.f14228b;
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            f(rectF, matrix2, true);
            LPaint lPaint = this.f14227a;
            lPaint.setAlpha(i2);
            Utils.e(canvas, lPaint, rectF);
        }
        if (z2) {
            i2 = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Object obj = arrayList.get(size);
            if (obj instanceof DrawingContent) {
                ((DrawingContent) obj).h(canvas, matrix2, i2);
            }
        }
        if (z2) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        Matrix matrix = this.f14229c;
        matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f14237k;
        if (transformKeyframeAnimation != null) {
            matrix.set(transformKeyframeAnimation.e());
        }
        Path path = this.f14230d;
        path.reset();
        if (!this.f14233g) {
            ArrayList arrayList = this.f14234h;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Content content = (Content) arrayList.get(size);
                if (content instanceof PathContent) {
                    path.addPath(((PathContent) content).j(), matrix);
                }
            }
        }
        return path;
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, ArrayList arrayList, AnimatableTransform animatableTransform) {
        this.f14227a = new LPaint();
        this.f14228b = new RectF();
        this.f14229c = new Matrix();
        this.f14230d = new Path();
        this.f14231e = new RectF();
        this.f14232f = str;
        this.f14235i = lottieDrawable;
        this.f14233g = z;
        this.f14234h = arrayList;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.f14237k = transformKeyframeAnimation;
            transformKeyframeAnimation.a(baseLayer);
            transformKeyframeAnimation.b(this);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Content content = (Content) arrayList.get(size);
            if (content instanceof GreedyContent) {
                arrayList2.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList2.get(size2)).g(arrayList.listIterator(arrayList.size()));
        }
    }
}
