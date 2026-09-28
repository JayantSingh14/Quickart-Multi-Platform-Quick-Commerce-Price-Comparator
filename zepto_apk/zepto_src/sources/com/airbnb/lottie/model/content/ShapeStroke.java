package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ShapeStroke implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14595a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableFloatValue f14596b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f14597c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableColorValue f14598d;

    /* renamed from: e, reason: collision with root package name */
    public final AnimatableIntegerValue f14599e;

    /* renamed from: f, reason: collision with root package name */
    public final AnimatableFloatValue f14600f;

    /* renamed from: g, reason: collision with root package name */
    public final LineCapType f14601g;

    /* renamed from: h, reason: collision with root package name */
    public final LineJoinType f14602h;

    /* renamed from: i, reason: collision with root package name */
    public final float f14603i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14604j;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14605a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14606b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f14606b = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14606b[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14606b[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f14605a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14605a[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14605a[2] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LineCapType {

        /* renamed from: a, reason: collision with root package name */
        public static final LineCapType f14607a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ LineCapType[] f14608b;

        static {
            LineCapType lineCapType = new LineCapType("BUTT", 0);
            f14607a = lineCapType;
            f14608b = new LineCapType[]{lineCapType, new LineCapType("ROUND", 1), new LineCapType("UNKNOWN", 2)};
        }

        public static LineCapType valueOf(String str) {
            return (LineCapType) Enum.valueOf(LineCapType.class, str);
        }

        public static LineCapType[] values() {
            return (LineCapType[]) f14608b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LineJoinType {

        /* renamed from: a, reason: collision with root package name */
        public static final LineJoinType f14609a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ LineJoinType[] f14610b;

        static {
            LineJoinType lineJoinType = new LineJoinType("MITER", 0);
            f14609a = lineJoinType;
            f14610b = new LineJoinType[]{lineJoinType, new LineJoinType("ROUND", 1), new LineJoinType("BEVEL", 2)};
        }

        public static LineJoinType valueOf(String str) {
            return (LineJoinType) Enum.valueOf(LineJoinType.class, str);
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) f14610b.clone();
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, ArrayList arrayList, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f2, boolean z) {
        this.f14595a = str;
        this.f14596b = animatableFloatValue;
        this.f14597c = arrayList;
        this.f14598d = animatableColorValue;
        this.f14599e = animatableIntegerValue;
        this.f14600f = animatableFloatValue2;
        this.f14601g = lineCapType;
        this.f14602h = lineJoinType;
        this.f14603i = f2;
        this.f14604j = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }
}
