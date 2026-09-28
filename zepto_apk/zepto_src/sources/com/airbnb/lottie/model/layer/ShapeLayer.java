package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeLayer extends BaseLayer {
    public final ContentGroup D;
    public final CompositionLayer E;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        this.E = compositionLayer;
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.f14638a, false), lottieComposition);
        this.D = contentGroup;
        List list = Collections.EMPTY_LIST;
        contentGroup.b(list, list);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        super.f(rectF, matrix, z);
        this.D.f(rectF, this.n, z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void l(Canvas canvas, Matrix matrix, int i2) {
        this.D.h(canvas, matrix, i2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final BlurEffect m() {
        BlurEffect blurEffect = this.p.w;
        return blurEffect != null ? blurEffect : this.E.p.w;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final DropShadowEffect n() {
        DropShadowEffect dropShadowEffect = this.p.x;
        return dropShadowEffect != null ? dropShadowEffect : this.E.p.x;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void r(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        this.D.e(keyPath, i2, arrayList, keyPath2);
    }
}
