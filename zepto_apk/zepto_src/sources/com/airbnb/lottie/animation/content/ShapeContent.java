package com.airbnb.lottie.animation.content;

import android.graphics.ColorFilter;
import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: b, reason: collision with root package name */
    public final String f14317b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14318c;

    /* renamed from: d, reason: collision with root package name */
    public final LottieDrawable f14319d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeKeyframeAnimation f14320e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14321f;

    /* renamed from: a, reason: collision with root package name */
    public final Path f14316a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final CompoundTrimPathContent f14322g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.f14317b = shapePath.f14591a;
        this.f14318c = shapePath.f14594d;
        this.f14319d = lottieDrawable;
        ShapeKeyframeAnimation shapeKeyframeAnimationA = shapePath.f14593c.a();
        this.f14320e = shapeKeyframeAnimationA;
        baseLayer.g(shapeKeyframeAnimationA);
        shapeKeyframeAnimationA.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14321f = false;
        this.f14319d.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            r1 = r6
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r2 = r1.size()
            if (r0 >= r2) goto L3c
            java.lang.Object r1 = r1.get(r0)
            com.airbnb.lottie.animation.content.Content r1 = (com.airbnb.lottie.animation.content.Content) r1
            boolean r2 = r1 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r2 == 0) goto L29
            r2 = r1
            com.airbnb.lottie.animation.content.TrimPathContent r2 = (com.airbnb.lottie.animation.content.TrimPathContent) r2
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r3 = r2.f14325c
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r4 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.f14616a
            if (r3 != r4) goto L29
            com.airbnb.lottie.animation.content.CompoundTrimPathContent r1 = r5.f14322g
            java.util.ArrayList r1 = r1.f14226a
            r1.add(r2)
            r2.d(r5)
            goto L39
        L29:
            boolean r2 = r1 instanceof com.airbnb.lottie.animation.content.ShapeModifierContent
            if (r2 == 0) goto L39
            if (r7 != 0) goto L34
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L34:
            com.airbnb.lottie.animation.content.ShapeModifierContent r1 = (com.airbnb.lottie.animation.content.ShapeModifierContent) r1
            r7.add(r1)
        L39:
            int r0 = r0 + 1
            goto L2
        L3c:
            com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation r6 = r5.f14320e
            r6.f14371m = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.ShapeContent.b(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        if (colorFilter == LottieProperty.K) {
            this.f14320e.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14317b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        boolean z = this.f14321f;
        Path path = this.f14316a;
        ShapeKeyframeAnimation shapeKeyframeAnimation = this.f14320e;
        if (z && shapeKeyframeAnimation.f14333e == null) {
            return path;
        }
        path.reset();
        if (this.f14318c) {
            this.f14321f = true;
            return path;
        }
        Path path2 = (Path) shapeKeyframeAnimation.f();
        if (path2 == null) {
            return path;
        }
        path.set(path2);
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f14322g.a(path);
        this.f14321f = true;
        return path;
    }
}
