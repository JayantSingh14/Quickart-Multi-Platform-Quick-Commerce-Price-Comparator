package com.horcrux.svg;

import java.util.HashMap;

/* loaded from: classes4.dex */
class TextProperties {

    public enum AlignmentBaseline {
        baseline("baseline"),
        /* JADX INFO: Fake field, exist only in values array */
        textBottom("text-bottom"),
        /* JADX INFO: Fake field, exist only in values array */
        alphabetic("alphabetic"),
        /* JADX INFO: Fake field, exist only in values array */
        ideographic("ideographic"),
        /* JADX INFO: Fake field, exist only in values array */
        middle("middle"),
        /* JADX INFO: Fake field, exist only in values array */
        central("central"),
        /* JADX INFO: Fake field, exist only in values array */
        mathematical("mathematical"),
        /* JADX INFO: Fake field, exist only in values array */
        textTop("text-top"),
        /* JADX INFO: Fake field, exist only in values array */
        bottom("bottom"),
        /* JADX INFO: Fake field, exist only in values array */
        center("center"),
        /* JADX INFO: Fake field, exist only in values array */
        top("top"),
        /* JADX INFO: Fake field, exist only in values array */
        textBeforeEdge("text-before-edge"),
        /* JADX INFO: Fake field, exist only in values array */
        textAfterEdge("text-after-edge"),
        /* JADX INFO: Fake field, exist only in values array */
        beforeEdge("before-edge"),
        /* JADX INFO: Fake field, exist only in values array */
        afterEdge("after-edge"),
        /* JADX INFO: Fake field, exist only in values array */
        hanging("hanging");


        /* renamed from: c, reason: collision with root package name */
        public static final HashMap f45878c = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45880a;

        static {
            for (AlignmentBaseline alignmentBaseline : values()) {
                f45878c.put(alignmentBaseline.f45880a, alignmentBaseline);
            }
        }

        AlignmentBaseline(String str) {
            this.f45880a = str;
        }

        public static AlignmentBaseline a(String str) {
            HashMap map = f45878c;
            if (map.containsKey(str)) {
                return (AlignmentBaseline) map.get(str);
            }
            throw new IllegalArgumentException(android.support.v4.media.b.C("Unknown String Value: ", str));
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45880a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Direction {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f45881a = {new Direction("ltr", 0), new Direction("rtl", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Direction EF5;

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) f45881a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class FontStyle {

        /* renamed from: a, reason: collision with root package name */
        public static final FontStyle f45882a;

        /* renamed from: b, reason: collision with root package name */
        public static final FontStyle f45883b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ FontStyle[] f45884c;

        static {
            FontStyle fontStyle = new FontStyle("normal", 0);
            f45882a = fontStyle;
            FontStyle fontStyle2 = new FontStyle("italic", 1);
            f45883b = fontStyle2;
            f45884c = new FontStyle[]{fontStyle, fontStyle2, new FontStyle("oblique", 2)};
        }

        public static FontStyle valueOf(String str) {
            return (FontStyle) Enum.valueOf(FontStyle.class, str);
        }

        public static FontStyle[] values() {
            return (FontStyle[]) f45884c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class FontVariantLigatures {

        /* renamed from: a, reason: collision with root package name */
        public static final FontVariantLigatures f45885a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ FontVariantLigatures[] f45886b;

        static {
            FontVariantLigatures fontVariantLigatures = new FontVariantLigatures("normal", 0);
            f45885a = fontVariantLigatures;
            f45886b = new FontVariantLigatures[]{fontVariantLigatures, new FontVariantLigatures("none", 1)};
        }

        public static FontVariantLigatures valueOf(String str) {
            return (FontVariantLigatures) Enum.valueOf(FontVariantLigatures.class, str);
        }

        public static FontVariantLigatures[] values() {
            return (FontVariantLigatures[]) f45886b.clone();
        }
    }

    public enum FontWeight {
        Normal("normal"),
        Bold("bold"),
        w100("100"),
        w200("200"),
        w300("300"),
        /* JADX INFO: Fake field, exist only in values array */
        w400("400"),
        w500("500"),
        w600("600"),
        /* JADX INFO: Fake field, exist only in values array */
        w700("700"),
        w800("800"),
        w900("900"),
        Bolder("bolder"),
        Lighter("lighter");


        /* renamed from: m, reason: collision with root package name */
        public static final HashMap f45898m = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45899a;

        static {
            for (FontWeight fontWeight : values()) {
                f45898m.put(fontWeight.f45899a, fontWeight);
            }
        }

        FontWeight(String str) {
            this.f45899a = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45899a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TextAnchor {

        /* renamed from: a, reason: collision with root package name */
        public static final TextAnchor f45900a;

        /* renamed from: b, reason: collision with root package name */
        public static final TextAnchor f45901b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ TextAnchor[] f45902c;

        static {
            TextAnchor textAnchor = new TextAnchor("start", 0);
            f45900a = textAnchor;
            TextAnchor textAnchor2 = new TextAnchor("middle", 1);
            f45901b = textAnchor2;
            f45902c = new TextAnchor[]{textAnchor, textAnchor2, new TextAnchor("end", 2)};
        }

        public static TextAnchor valueOf(String str) {
            return (TextAnchor) Enum.valueOf(TextAnchor.class, str);
        }

        public static TextAnchor[] values() {
            return (TextAnchor[]) f45902c.clone();
        }
    }

    public enum TextDecoration {
        None("none"),
        /* JADX INFO: Fake field, exist only in values array */
        Underline("underline"),
        /* JADX INFO: Fake field, exist only in values array */
        Overline("overline"),
        /* JADX INFO: Fake field, exist only in values array */
        LineThrough("line-through"),
        /* JADX INFO: Fake field, exist only in values array */
        Blink("blink");


        /* renamed from: c, reason: collision with root package name */
        public static final HashMap f45904c = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45906a;

        static {
            for (TextDecoration textDecoration : values()) {
                f45904c.put(textDecoration.f45906a, textDecoration);
            }
        }

        TextDecoration(String str) {
            this.f45906a = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45906a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TextLengthAdjust {

        /* renamed from: a, reason: collision with root package name */
        public static final TextLengthAdjust f45907a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TextLengthAdjust[] f45908b;

        static {
            TextLengthAdjust textLengthAdjust = new TextLengthAdjust("spacing", 0);
            f45907a = textLengthAdjust;
            f45908b = new TextLengthAdjust[]{textLengthAdjust, new TextLengthAdjust("spacingAndGlyphs", 1)};
        }

        public static TextLengthAdjust valueOf(String str) {
            return (TextLengthAdjust) Enum.valueOf(TextLengthAdjust.class, str);
        }

        public static TextLengthAdjust[] values() {
            return (TextLengthAdjust[]) f45908b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TextPathMethod {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextPathMethod[] f45909a = {new TextPathMethod("align", 0), new TextPathMethod("stretch", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        TextPathMethod EF5;

        public static TextPathMethod valueOf(String str) {
            return (TextPathMethod) Enum.valueOf(TextPathMethod.class, str);
        }

        public static TextPathMethod[] values() {
            return (TextPathMethod[]) f45909a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TextPathMidLine {

        /* renamed from: a, reason: collision with root package name */
        public static final TextPathMidLine f45910a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TextPathMidLine[] f45911b;

        static {
            TextPathMidLine textPathMidLine = new TextPathMidLine("sharp", 0);
            f45910a = textPathMidLine;
            f45911b = new TextPathMidLine[]{textPathMidLine, new TextPathMidLine("smooth", 1)};
        }

        public static TextPathMidLine valueOf(String str) {
            return (TextPathMidLine) Enum.valueOf(TextPathMidLine.class, str);
        }

        public static TextPathMidLine[] values() {
            return (TextPathMidLine[]) f45911b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TextPathSide {

        /* renamed from: a, reason: collision with root package name */
        public static final TextPathSide f45912a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TextPathSide[] f45913b;

        /* JADX INFO: Fake field, exist only in values array */
        TextPathSide EF0;

        static {
            TextPathSide textPathSide = new TextPathSide("left", 0);
            TextPathSide textPathSide2 = new TextPathSide("right", 1);
            f45912a = textPathSide2;
            f45913b = new TextPathSide[]{textPathSide, textPathSide2};
        }

        public static TextPathSide valueOf(String str) {
            return (TextPathSide) Enum.valueOf(TextPathSide.class, str);
        }

        public static TextPathSide[] values() {
            return (TextPathSide[]) f45913b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TextPathSpacing {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextPathSpacing[] f45914a = {new TextPathSpacing("auto", 0), new TextPathSpacing("exact", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        TextPathSpacing EF5;

        public static TextPathSpacing valueOf(String str) {
            return (TextPathSpacing) Enum.valueOf(TextPathSpacing.class, str);
        }

        public static TextPathSpacing[] values() {
            return (TextPathSpacing[]) f45914a.clone();
        }
    }
}
