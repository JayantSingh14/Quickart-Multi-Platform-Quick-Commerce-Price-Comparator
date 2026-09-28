package com.facebook.react.uimanager.style;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ComputedBorderRadius {

    /* renamed from: a, reason: collision with root package name */
    public final CornerRadii f19873a;

    /* renamed from: b, reason: collision with root package name */
    public final CornerRadii f19874b;

    /* renamed from: c, reason: collision with root package name */
    public final CornerRadii f19875c;

    /* renamed from: d, reason: collision with root package name */
    public final CornerRadii f19876d;

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ComputedBorderRadiusProp.values().length];
            try {
                ComputedBorderRadiusProp[] computedBorderRadiusPropArr = ComputedBorderRadiusProp.f19877a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ComputedBorderRadiusProp[] computedBorderRadiusPropArr2 = ComputedBorderRadiusProp.f19877a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ComputedBorderRadiusProp[] computedBorderRadiusPropArr3 = ComputedBorderRadiusProp.f19877a;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ComputedBorderRadiusProp[] computedBorderRadiusPropArr4 = ComputedBorderRadiusProp.f19877a;
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ComputedBorderRadius(CornerRadii topLeft, CornerRadii topRight, CornerRadii bottomLeft, CornerRadii bottomRight) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        this.f19873a = topLeft;
        this.f19874b = topRight;
        this.f19875c = bottomLeft;
        this.f19876d = bottomRight;
    }

    public final boolean a() {
        CornerRadii cornerRadii = this.f19873a;
        if (cornerRadii.f19879a > 0.0f || cornerRadii.f19880b > 0.0f) {
            return true;
        }
        CornerRadii cornerRadii2 = this.f19874b;
        if (cornerRadii2.f19879a > 0.0f || cornerRadii2.f19880b > 0.0f) {
            return true;
        }
        CornerRadii cornerRadii3 = this.f19875c;
        return cornerRadii3.f19879a > 0.0f || cornerRadii3.f19880b > 0.0f || this.f19876d.f19879a > 0.0f;
    }

    public final boolean b() {
        CornerRadii cornerRadii = this.f19874b;
        CornerRadii cornerRadii2 = this.f19873a;
        return Intrinsics.b(cornerRadii2, cornerRadii) && Intrinsics.b(cornerRadii2, this.f19875c) && Intrinsics.b(cornerRadii2, this.f19876d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComputedBorderRadius)) {
            return false;
        }
        ComputedBorderRadius computedBorderRadius = (ComputedBorderRadius) obj;
        return Intrinsics.b(this.f19873a, computedBorderRadius.f19873a) && Intrinsics.b(this.f19874b, computedBorderRadius.f19874b) && Intrinsics.b(this.f19875c, computedBorderRadius.f19875c) && Intrinsics.b(this.f19876d, computedBorderRadius.f19876d);
    }

    public final int hashCode() {
        return this.f19876d.hashCode() + ((this.f19875c.hashCode() + ((this.f19874b.hashCode() + (this.f19873a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ComputedBorderRadius(topLeft=" + this.f19873a + ", topRight=" + this.f19874b + ", bottomLeft=" + this.f19875c + ", bottomRight=" + this.f19876d + ")";
    }

    public ComputedBorderRadius() {
        this(new CornerRadii(0.0f, 0.0f), new CornerRadii(0.0f, 0.0f), new CornerRadii(0.0f, 0.0f), new CornerRadii(0.0f, 0.0f));
    }
}
