package com.airbnb.lottie.model.content;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class TextRangeUnits {

    /* renamed from: a, reason: collision with root package name */
    public static final TextRangeUnits f14619a;

    /* renamed from: b, reason: collision with root package name */
    public static final TextRangeUnits f14620b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ TextRangeUnits[] f14621c;

    static {
        TextRangeUnits textRangeUnits = new TextRangeUnits("PERCENT", 0);
        f14619a = textRangeUnits;
        TextRangeUnits textRangeUnits2 = new TextRangeUnits("INDEX", 1);
        f14620b = textRangeUnits2;
        f14621c = new TextRangeUnits[]{textRangeUnits, textRangeUnits2};
    }

    public static TextRangeUnits valueOf(String str) {
        return (TextRangeUnits) Enum.valueOf(TextRangeUnits.class, str);
    }

    public static TextRangeUnits[] values() {
        return (TextRangeUnits[]) f14621c.clone();
    }
}
