package com.airbnb.lottie.model.layer;

import android.support.v4.media.b;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class Layer {

    /* renamed from: a, reason: collision with root package name */
    public final List f14638a;

    /* renamed from: b, reason: collision with root package name */
    public final LottieComposition f14639b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14640c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14641d;

    /* renamed from: e, reason: collision with root package name */
    public final LayerType f14642e;

    /* renamed from: f, reason: collision with root package name */
    public final long f14643f;

    /* renamed from: g, reason: collision with root package name */
    public final String f14644g;

    /* renamed from: h, reason: collision with root package name */
    public final List f14645h;

    /* renamed from: i, reason: collision with root package name */
    public final AnimatableTransform f14646i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14647j;

    /* renamed from: k, reason: collision with root package name */
    public final int f14648k;

    /* renamed from: l, reason: collision with root package name */
    public final int f14649l;

    /* renamed from: m, reason: collision with root package name */
    public final float f14650m;
    public final float n;
    public final float o;
    public final float p;
    public final AnimatableTextFrame q;
    public final AnimatableTextProperties r;
    public final AnimatableFloatValue s;
    public final List t;
    public final MatteType u;
    public final boolean v;
    public final BlurEffect w;
    public final DropShadowEffect x;
    public final LBlendMode y;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LayerType {

        /* renamed from: a, reason: collision with root package name */
        public static final LayerType f14651a;

        /* renamed from: b, reason: collision with root package name */
        public static final LayerType f14652b;

        /* renamed from: c, reason: collision with root package name */
        public static final LayerType f14653c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ LayerType[] f14654d;

        static {
            LayerType layerType = new LayerType("PRE_COMP", 0);
            f14651a = layerType;
            LayerType layerType2 = new LayerType("SOLID", 1);
            LayerType layerType3 = new LayerType("IMAGE", 2);
            f14652b = layerType3;
            LayerType layerType4 = new LayerType("NULL", 3);
            LayerType layerType5 = new LayerType("SHAPE", 4);
            LayerType layerType6 = new LayerType("TEXT", 5);
            LayerType layerType7 = new LayerType("UNKNOWN", 6);
            f14653c = layerType7;
            f14654d = new LayerType[]{layerType, layerType2, layerType3, layerType4, layerType5, layerType6, layerType7};
        }

        public static LayerType valueOf(String str) {
            return (LayerType) Enum.valueOf(LayerType.class, str);
        }

        public static LayerType[] values() {
            return (LayerType[]) f14654d.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MatteType {

        /* renamed from: a, reason: collision with root package name */
        public static final MatteType f14655a;

        /* renamed from: b, reason: collision with root package name */
        public static final MatteType f14656b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ MatteType[] f14657c;

        static {
            MatteType matteType = new MatteType("NONE", 0);
            f14655a = matteType;
            MatteType matteType2 = new MatteType("ADD", 1);
            MatteType matteType3 = new MatteType("INVERT", 2);
            f14656b = matteType3;
            f14657c = new MatteType[]{matteType, matteType2, matteType3, new MatteType("LUMA", 3), new MatteType("LUMA_INVERTED", 4), new MatteType("UNKNOWN", 5)};
        }

        public static MatteType valueOf(String str) {
            return (MatteType) Enum.valueOf(MatteType.class, str);
        }

        public static MatteType[] values() {
            return (MatteType[]) f14657c.clone();
        }
    }

    public Layer(List list, LottieComposition lottieComposition, String str, long j2, LayerType layerType, long j3, String str2, List list2, AnimatableTransform animatableTransform, int i2, int i3, int i4, float f2, float f3, float f4, float f5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z, BlurEffect blurEffect, DropShadowEffect dropShadowEffect, LBlendMode lBlendMode) {
        this.f14638a = list;
        this.f14639b = lottieComposition;
        this.f14640c = str;
        this.f14641d = j2;
        this.f14642e = layerType;
        this.f14643f = j3;
        this.f14644g = str2;
        this.f14645h = list2;
        this.f14646i = animatableTransform;
        this.f14647j = i2;
        this.f14648k = i3;
        this.f14649l = i4;
        this.f14650m = f2;
        this.n = f3;
        this.o = f4;
        this.p = f5;
        this.q = animatableTextFrame;
        this.r = animatableTextProperties;
        this.t = list3;
        this.u = matteType;
        this.s = animatableFloatValue;
        this.v = z;
        this.w = blurEffect;
        this.x = dropShadowEffect;
        this.y = lBlendMode;
    }

    public final String a(String str) {
        int i2;
        StringBuilder sbW = b.w(str);
        sbW.append(this.f14640c);
        sbW.append(StringUtils.LF);
        LottieComposition lottieComposition = this.f14639b;
        Layer layer = (Layer) lottieComposition.f14143i.c(this.f14643f);
        if (layer != null) {
            sbW.append("\t\tParents: ");
            sbW.append(layer.f14640c);
            for (Layer layer2 = (Layer) lottieComposition.f14143i.c(layer.f14643f); layer2 != null; layer2 = (Layer) lottieComposition.f14143i.c(layer2.f14643f)) {
                sbW.append("->");
                sbW.append(layer2.f14640c);
            }
            sbW.append(str);
            sbW.append(StringUtils.LF);
        }
        List list = this.f14645h;
        if (!list.isEmpty()) {
            sbW.append(str);
            sbW.append("\tMasks: ");
            sbW.append(list.size());
            sbW.append(StringUtils.LF);
        }
        int i3 = this.f14647j;
        if (i3 != 0 && (i2 = this.f14648k) != 0) {
            sbW.append(str);
            sbW.append("\tBackground: ");
            sbW.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.f14649l)));
        }
        List list2 = this.f14638a;
        if (!list2.isEmpty()) {
            sbW.append(str);
            sbW.append("\tShapes:\n");
            for (Object obj : list2) {
                sbW.append(str);
                sbW.append("\t\t");
                sbW.append(obj);
                sbW.append(StringUtils.LF);
            }
        }
        return sbW.toString();
    }

    public final String toString() {
        return a("");
    }
}
