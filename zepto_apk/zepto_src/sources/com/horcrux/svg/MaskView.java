package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class MaskView extends GroupView {

    /* renamed from: f, reason: collision with root package name */
    public SVGLength f45784f;

    /* renamed from: g, reason: collision with root package name */
    public SVGLength f45785g;

    /* renamed from: h, reason: collision with root package name */
    public SVGLength f45786h;

    /* renamed from: i, reason: collision with root package name */
    public SVGLength f45787i;

    /* renamed from: j, reason: collision with root package name */
    public Brush.BrushUnits f45788j;

    /* renamed from: k, reason: collision with root package name */
    public MaskType f45789k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class MaskType {

        /* renamed from: a, reason: collision with root package name */
        public static final MaskType f45790a;

        /* renamed from: b, reason: collision with root package name */
        public static final MaskType f45791b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ MaskType[] f45792c;

        static {
            MaskType maskType = new MaskType("LUMINANCE", 0);
            f45790a = maskType;
            MaskType maskType2 = new MaskType("ALPHA", 1);
            f45791b = maskType2;
            f45792c = new MaskType[]{maskType, maskType2};
        }

        public static MaskType valueOf(String str) {
            return (MaskType) Enum.valueOf(MaskType.class, str);
        }

        public static MaskType[] values() {
            return (MaskType[]) f45792c.clone();
        }
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMask(this, this.mName);
        }
    }
}
