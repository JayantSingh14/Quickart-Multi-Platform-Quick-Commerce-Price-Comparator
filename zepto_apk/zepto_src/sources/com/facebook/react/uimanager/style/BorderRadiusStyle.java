package com.facebook.react.uimanager.style;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.LengthPercentage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class BorderRadiusStyle {

    /* renamed from: a, reason: collision with root package name */
    public LengthPercentage f19843a;

    /* renamed from: b, reason: collision with root package name */
    public LengthPercentage f19844b;

    /* renamed from: c, reason: collision with root package name */
    public LengthPercentage f19845c;

    /* renamed from: d, reason: collision with root package name */
    public LengthPercentage f19846d;

    /* renamed from: e, reason: collision with root package name */
    public LengthPercentage f19847e;

    /* renamed from: f, reason: collision with root package name */
    public LengthPercentage f19848f;

    /* renamed from: g, reason: collision with root package name */
    public LengthPercentage f19849g;

    /* renamed from: h, reason: collision with root package name */
    public LengthPercentage f19850h;

    /* renamed from: i, reason: collision with root package name */
    public LengthPercentage f19851i;

    /* renamed from: j, reason: collision with root package name */
    public LengthPercentage f19852j;

    /* renamed from: k, reason: collision with root package name */
    public LengthPercentage f19853k;

    /* renamed from: l, reason: collision with root package name */
    public LengthPercentage f19854l;

    /* renamed from: m, reason: collision with root package name */
    public LengthPercentage f19855m;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[BorderRadiusProp.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BorderRadiusProp borderRadiusProp = BorderRadiusProp.f19836a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BorderRadiusProp borderRadiusProp2 = BorderRadiusProp.f19836a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BorderRadiusProp borderRadiusProp3 = BorderRadiusProp.f19836a;
                iArr[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BorderRadiusProp borderRadiusProp4 = BorderRadiusProp.f19836a;
                iArr[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BorderRadiusProp borderRadiusProp5 = BorderRadiusProp.f19836a;
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BorderRadiusProp borderRadiusProp6 = BorderRadiusProp.f19836a;
                iArr[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                BorderRadiusProp borderRadiusProp7 = BorderRadiusProp.f19836a;
                iArr[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                BorderRadiusProp borderRadiusProp8 = BorderRadiusProp.f19836a;
                iArr[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                BorderRadiusProp borderRadiusProp9 = BorderRadiusProp.f19836a;
                iArr[12] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                BorderRadiusProp borderRadiusProp10 = BorderRadiusProp.f19836a;
                iArr[11] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                BorderRadiusProp borderRadiusProp11 = BorderRadiusProp.f19836a;
                iArr[10] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                BorderRadiusProp borderRadiusProp12 = BorderRadiusProp.f19836a;
                iArr[9] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public BorderRadiusStyle() {
        this(0);
    }

    public static ComputedBorderRadius a(CornerRadii cornerRadii, CornerRadii cornerRadii2, CornerRadii cornerRadii3, CornerRadii cornerRadii4, float f2, float f3) {
        float f4 = cornerRadii.f19880b;
        float f5 = cornerRadii3.f19880b;
        float f6 = f4 + f5;
        float f7 = cornerRadii.f19879a;
        float f8 = cornerRadii2.f19879a;
        float f9 = f7 + f8;
        float f10 = cornerRadii2.f19880b;
        float f11 = cornerRadii4.f19880b;
        float f12 = f10 + f11;
        float f13 = cornerRadii3.f19879a;
        float f14 = cornerRadii4.f19879a;
        float f15 = f13 + f14;
        float fMin = f6 > 0.0f ? Math.min(f3 / f6, 1.0f) : 0.0f;
        float fMin2 = f9 > 0.0f ? Math.min(f2 / f9, 1.0f) : 0.0f;
        float fMin3 = f12 > 0.0f ? Math.min(f3 / f12, 1.0f) : 0.0f;
        float fMin4 = f15 > 0.0f ? Math.min(f2 / f15, 1.0f) : 0.0f;
        return new ComputedBorderRadius(new CornerRadii(Math.min(fMin2, fMin) * f7, Math.min(fMin2, fMin) * f4), new CornerRadii(Math.min(fMin3, fMin2) * f8, Math.min(fMin3, fMin2) * f10), new CornerRadii(Math.min(fMin4, fMin) * f13, Math.min(fMin4, fMin) * f5), new CornerRadii(Math.min(fMin4, fMin3) * f14, Math.min(fMin4, fMin3) * f11));
    }

    public final LengthPercentage b(BorderRadiusProp property) {
        Intrinsics.checkNotNullParameter(property, "property");
        switch (property.ordinal()) {
            case 0:
                return this.f19843a;
            case 1:
                return this.f19844b;
            case 2:
                return this.f19845c;
            case 3:
                return this.f19847e;
            case 4:
                return this.f19846d;
            case 5:
                return this.f19848f;
            case 6:
                return this.f19849g;
            case 7:
                return this.f19850h;
            case 8:
                return this.f19851i;
            case 9:
                return this.f19855m;
            case 10:
                return this.f19854l;
            case 11:
                return this.f19853k;
            case 12:
                return this.f19852j;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean c() {
        return (this.f19843a == null && this.f19844b == null && this.f19845c == null && this.f19846d == null && this.f19847e == null && this.f19848f == null && this.f19849g == null && this.f19850h == null && this.f19851i == null && this.f19852j == null && this.f19853k == null && this.f19854l == null && this.f19855m == null) ? false : true;
    }

    public final ComputedBorderRadius d(int i2, Context context, float f2, float f3) {
        Intrinsics.checkNotNullParameter(context, "context");
        CornerRadii cornerRadii = new CornerRadii(0.0f, 0.0f);
        if (i2 == 0) {
            LengthPercentage lengthPercentage = this.f19852j;
            if (lengthPercentage == null && (lengthPercentage = this.f19848f) == null && (lengthPercentage = this.f19844b) == null) {
                lengthPercentage = this.f19843a;
            }
            CornerRadii cornerRadiiA = lengthPercentage != null ? lengthPercentage.a(f2, f3) : cornerRadii;
            LengthPercentage lengthPercentage2 = this.f19854l;
            if (lengthPercentage2 == null && (lengthPercentage2 = this.f19849g) == null && (lengthPercentage2 = this.f19845c) == null) {
                lengthPercentage2 = this.f19843a;
            }
            CornerRadii cornerRadiiA2 = lengthPercentage2 != null ? lengthPercentage2.a(f2, f3) : cornerRadii;
            LengthPercentage lengthPercentage3 = this.f19853k;
            if (lengthPercentage3 == null && (lengthPercentage3 = this.f19850h) == null && (lengthPercentage3 = this.f19846d) == null) {
                lengthPercentage3 = this.f19843a;
            }
            CornerRadii cornerRadiiA3 = lengthPercentage3 != null ? lengthPercentage3.a(f2, f3) : cornerRadii;
            LengthPercentage lengthPercentage4 = this.f19855m;
            if (lengthPercentage4 == null && (lengthPercentage4 = this.f19851i) == null && (lengthPercentage4 = this.f19847e) == null) {
                lengthPercentage4 = this.f19843a;
            }
            if (lengthPercentage4 != null) {
                cornerRadii = lengthPercentage4.a(f2, f3);
            }
            return a(cornerRadiiA, cornerRadiiA2, cornerRadiiA3, cornerRadii, f2, f3);
        }
        if (i2 != 1) {
            throw new IllegalArgumentException("Expected?.resolved layout direction");
        }
        if (I18nUtil.a(context)) {
            LengthPercentage lengthPercentage5 = this.f19854l;
            if (lengthPercentage5 == null && (lengthPercentage5 = this.f19849g) == null && (lengthPercentage5 = this.f19845c) == null) {
                lengthPercentage5 = this.f19843a;
            }
            CornerRadii cornerRadiiA4 = lengthPercentage5 != null ? lengthPercentage5.a(f2, f3) : cornerRadii;
            LengthPercentage lengthPercentage6 = this.f19852j;
            if (lengthPercentage6 == null && (lengthPercentage6 = this.f19848f) == null && (lengthPercentage6 = this.f19844b) == null) {
                lengthPercentage6 = this.f19843a;
            }
            CornerRadii cornerRadiiA5 = lengthPercentage6 != null ? lengthPercentage6.a(f2, f3) : cornerRadii;
            LengthPercentage lengthPercentage7 = this.f19855m;
            if (lengthPercentage7 == null && (lengthPercentage7 = this.f19850h) == null && (lengthPercentage7 = this.f19847e) == null) {
                lengthPercentage7 = this.f19843a;
            }
            CornerRadii cornerRadiiA6 = lengthPercentage7 != null ? lengthPercentage7.a(f2, f3) : cornerRadii;
            LengthPercentage lengthPercentage8 = this.f19853k;
            if (lengthPercentage8 == null && (lengthPercentage8 = this.f19851i) == null && (lengthPercentage8 = this.f19846d) == null) {
                lengthPercentage8 = this.f19843a;
            }
            if (lengthPercentage8 != null) {
                cornerRadii = lengthPercentage8.a(f2, f3);
            }
            return a(cornerRadiiA4, cornerRadiiA5, cornerRadiiA6, cornerRadii, f2, f3);
        }
        LengthPercentage lengthPercentage9 = this.f19854l;
        if (lengthPercentage9 == null && (lengthPercentage9 = this.f19849g) == null && (lengthPercentage9 = this.f19844b) == null) {
            lengthPercentage9 = this.f19843a;
        }
        CornerRadii cornerRadiiA7 = lengthPercentage9 != null ? lengthPercentage9.a(f2, f3) : cornerRadii;
        LengthPercentage lengthPercentage10 = this.f19852j;
        if (lengthPercentage10 == null && (lengthPercentage10 = this.f19848f) == null && (lengthPercentage10 = this.f19845c) == null) {
            lengthPercentage10 = this.f19843a;
        }
        CornerRadii cornerRadiiA8 = lengthPercentage10 != null ? lengthPercentage10.a(f2, f3) : cornerRadii;
        LengthPercentage lengthPercentage11 = this.f19855m;
        if (lengthPercentage11 == null && (lengthPercentage11 = this.f19850h) == null && (lengthPercentage11 = this.f19846d) == null) {
            lengthPercentage11 = this.f19843a;
        }
        CornerRadii cornerRadiiA9 = lengthPercentage11 != null ? lengthPercentage11.a(f2, f3) : cornerRadii;
        LengthPercentage lengthPercentage12 = this.f19853k;
        if (lengthPercentage12 == null && (lengthPercentage12 = this.f19851i) == null && (lengthPercentage12 = this.f19847e) == null) {
            lengthPercentage12 = this.f19843a;
        }
        if (lengthPercentage12 != null) {
            cornerRadii = lengthPercentage12.a(f2, f3);
        }
        return a(cornerRadiiA7, cornerRadiiA8, cornerRadiiA9, cornerRadii, f2, f3);
    }

    public final void e(BorderRadiusProp property, LengthPercentage lengthPercentage) {
        Intrinsics.checkNotNullParameter(property, "property");
        switch (property.ordinal()) {
            case 0:
                this.f19843a = lengthPercentage;
                return;
            case 1:
                this.f19844b = lengthPercentage;
                return;
            case 2:
                this.f19845c = lengthPercentage;
                return;
            case 3:
                this.f19847e = lengthPercentage;
                return;
            case 4:
                this.f19846d = lengthPercentage;
                return;
            case 5:
                this.f19848f = lengthPercentage;
                return;
            case 6:
                this.f19849g = lengthPercentage;
                return;
            case 7:
                this.f19850h = lengthPercentage;
                return;
            case 8:
                this.f19851i = lengthPercentage;
                return;
            case 9:
                this.f19855m = lengthPercentage;
                return;
            case 10:
                this.f19854l = lengthPercentage;
                return;
            case 11:
                this.f19853k = lengthPercentage;
                return;
            case 12:
                this.f19852j = lengthPercentage;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderRadiusStyle)) {
            return false;
        }
        BorderRadiusStyle borderRadiusStyle = (BorderRadiusStyle) obj;
        return Intrinsics.b(this.f19843a, borderRadiusStyle.f19843a) && Intrinsics.b(this.f19844b, borderRadiusStyle.f19844b) && Intrinsics.b(this.f19845c, borderRadiusStyle.f19845c) && Intrinsics.b(this.f19846d, borderRadiusStyle.f19846d) && Intrinsics.b(this.f19847e, borderRadiusStyle.f19847e) && Intrinsics.b(this.f19848f, borderRadiusStyle.f19848f) && Intrinsics.b(this.f19849g, borderRadiusStyle.f19849g) && Intrinsics.b(this.f19850h, borderRadiusStyle.f19850h) && Intrinsics.b(this.f19851i, borderRadiusStyle.f19851i) && Intrinsics.b(this.f19852j, borderRadiusStyle.f19852j) && Intrinsics.b(this.f19853k, borderRadiusStyle.f19853k) && Intrinsics.b(this.f19854l, borderRadiusStyle.f19854l) && Intrinsics.b(this.f19855m, borderRadiusStyle.f19855m);
    }

    public final int hashCode() {
        LengthPercentage lengthPercentage = this.f19843a;
        int iHashCode = (lengthPercentage == null ? 0 : lengthPercentage.hashCode()) * 31;
        LengthPercentage lengthPercentage2 = this.f19844b;
        int iHashCode2 = (iHashCode + (lengthPercentage2 == null ? 0 : lengthPercentage2.hashCode())) * 31;
        LengthPercentage lengthPercentage3 = this.f19845c;
        int iHashCode3 = (iHashCode2 + (lengthPercentage3 == null ? 0 : lengthPercentage3.hashCode())) * 31;
        LengthPercentage lengthPercentage4 = this.f19846d;
        int iHashCode4 = (iHashCode3 + (lengthPercentage4 == null ? 0 : lengthPercentage4.hashCode())) * 31;
        LengthPercentage lengthPercentage5 = this.f19847e;
        int iHashCode5 = (iHashCode4 + (lengthPercentage5 == null ? 0 : lengthPercentage5.hashCode())) * 31;
        LengthPercentage lengthPercentage6 = this.f19848f;
        int iHashCode6 = (iHashCode5 + (lengthPercentage6 == null ? 0 : lengthPercentage6.hashCode())) * 31;
        LengthPercentage lengthPercentage7 = this.f19849g;
        int iHashCode7 = (iHashCode6 + (lengthPercentage7 == null ? 0 : lengthPercentage7.hashCode())) * 31;
        LengthPercentage lengthPercentage8 = this.f19850h;
        int iHashCode8 = (iHashCode7 + (lengthPercentage8 == null ? 0 : lengthPercentage8.hashCode())) * 31;
        LengthPercentage lengthPercentage9 = this.f19851i;
        int iHashCode9 = (iHashCode8 + (lengthPercentage9 == null ? 0 : lengthPercentage9.hashCode())) * 31;
        LengthPercentage lengthPercentage10 = this.f19852j;
        int iHashCode10 = (iHashCode9 + (lengthPercentage10 == null ? 0 : lengthPercentage10.hashCode())) * 31;
        LengthPercentage lengthPercentage11 = this.f19853k;
        int iHashCode11 = (iHashCode10 + (lengthPercentage11 == null ? 0 : lengthPercentage11.hashCode())) * 31;
        LengthPercentage lengthPercentage12 = this.f19854l;
        int iHashCode12 = (iHashCode11 + (lengthPercentage12 == null ? 0 : lengthPercentage12.hashCode())) * 31;
        LengthPercentage lengthPercentage13 = this.f19855m;
        return iHashCode12 + (lengthPercentage13 != null ? lengthPercentage13.hashCode() : 0);
    }

    public final String toString() {
        return "BorderRadiusStyle(uniform=" + this.f19843a + ", topLeft=" + this.f19844b + ", topRight=" + this.f19845c + ", bottomLeft=" + this.f19846d + ", bottomRight=" + this.f19847e + ", topStart=" + this.f19848f + ", topEnd=" + this.f19849g + ", bottomStart=" + this.f19850h + ", bottomEnd=" + this.f19851i + ", startStart=" + this.f19852j + ", startEnd=" + this.f19853k + ", endStart=" + this.f19854l + ", endEnd=" + this.f19855m + ")";
    }

    public BorderRadiusStyle(int i2) {
        this.f19843a = null;
        this.f19844b = null;
        this.f19845c = null;
        this.f19846d = null;
        this.f19847e = null;
        this.f19848f = null;
        this.f19849g = null;
        this.f19850h = null;
        this.f19851i = null;
        this.f19852j = null;
        this.f19853k = null;
        this.f19854l = null;
        this.f19855m = null;
    }
}
