package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class GeneralRange<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f42619a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f42620b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f42621c;

    /* renamed from: d, reason: collision with root package name */
    public final BoundType f42622d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f42623e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f42624f;

    /* renamed from: g, reason: collision with root package name */
    public final BoundType f42625g;

    public GeneralRange(Comparator comparator, boolean z, Object obj, BoundType boundType, boolean z2, Object obj2, BoundType boundType2) {
        comparator.getClass();
        this.f42619a = comparator;
        this.f42620b = z;
        this.f42623e = z2;
        this.f42621c = obj;
        boundType.getClass();
        this.f42622d = boundType;
        this.f42624f = obj2;
        boundType2.getClass();
        this.f42625g = boundType2;
        if (z) {
            ((NaturalOrdering) comparator).compare(obj, obj);
        }
        if (z2) {
            ((NaturalOrdering) comparator).compare(obj2, obj2);
        }
        if (z && z2) {
            int iCompare = ((NaturalOrdering) comparator).compare(obj, obj2);
            Preconditions.d(obj, obj2, "lowerEndpoint (%s) > upperEndpoint (%s)", iCompare <= 0);
            if (iCompare == 0) {
                BoundType boundType3 = BoundType.f42528a;
                Preconditions.f((boundType == boundType3 && boundType2 == boundType3) ? false : true);
            }
        }
    }

    public final boolean a(Object obj) {
        return (d(obj) || c(obj)) ? false : true;
    }

    public final GeneralRange b(GeneralRange generalRange) {
        BoundType boundType;
        boolean z;
        int iCompare;
        BoundType boundType2;
        boolean z2;
        Object obj;
        int iCompare2;
        BoundType boundType3;
        int iCompare3;
        Comparator comparator = generalRange.f42619a;
        Comparator comparator2 = this.f42619a;
        Preconditions.f(comparator2.equals(comparator));
        BoundType boundType4 = BoundType.f42528a;
        boolean z3 = generalRange.f42620b;
        BoundType boundType5 = generalRange.f42622d;
        Object obj2 = generalRange.f42621c;
        boolean z4 = this.f42620b;
        if (z4) {
            Object obj3 = this.f42621c;
            if (!z3 || ((iCompare = ((NaturalOrdering) comparator2).compare(obj3, obj2)) >= 0 && !(iCompare == 0 && boundType5 == boundType4))) {
                boundType = this.f42622d;
                z = z4;
                obj2 = obj3;
            } else {
                boundType = boundType5;
                z = z4;
            }
        } else {
            z = z3;
            boundType = boundType5;
        }
        boolean z5 = generalRange.f42623e;
        BoundType boundType6 = generalRange.f42625g;
        Object obj4 = generalRange.f42624f;
        boolean z6 = this.f42623e;
        if (z6) {
            Object obj5 = this.f42624f;
            if (!z5 || ((iCompare2 = ((NaturalOrdering) comparator2).compare(obj5, obj4)) <= 0 && !(iCompare2 == 0 && boundType6 == boundType4))) {
                boundType2 = this.f42625g;
                z2 = z6;
                obj = obj5;
            } else {
                obj = obj4;
                boundType2 = boundType6;
                z2 = z6;
            }
        } else {
            obj = obj4;
            boundType2 = boundType6;
            z2 = z5;
        }
        if (z && z2 && ((iCompare3 = ((NaturalOrdering) comparator2).compare(obj2, obj)) > 0 || (iCompare3 == 0 && boundType == boundType4 && boundType2 == boundType4))) {
            boundType2 = BoundType.f42529b;
            boundType3 = boundType4;
            obj2 = obj;
        } else {
            boundType3 = boundType;
        }
        return new GeneralRange(comparator2, z, obj2, boundType3, z2, obj, boundType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(Object obj) {
        if (!this.f42623e) {
            return false;
        }
        int iCompare = this.f42619a.compare(obj, this.f42624f);
        return ((iCompare == 0) & (this.f42625g == BoundType.f42528a)) | (iCompare > 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(Object obj) {
        if (!this.f42620b) {
            return false;
        }
        int iCompare = this.f42619a.compare(obj, this.f42621c);
        return ((iCompare == 0) & (this.f42622d == BoundType.f42528a)) | (iCompare < 0);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GeneralRange) {
            GeneralRange generalRange = (GeneralRange) obj;
            if (this.f42619a.equals(generalRange.f42619a) && this.f42620b == generalRange.f42620b && this.f42623e == generalRange.f42623e && this.f42622d.equals(generalRange.f42622d) && this.f42625g.equals(generalRange.f42625g) && Objects.a(this.f42621c, generalRange.f42621c) && Objects.a(this.f42624f, generalRange.f42624f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f42619a, this.f42621c, this.f42622d, this.f42624f, this.f42625g});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f42619a);
        sb.append(":");
        BoundType boundType = BoundType.f42529b;
        sb.append(this.f42622d == boundType ? '[' : '(');
        sb.append(this.f42620b ? this.f42621c : "-∞");
        sb.append(',');
        sb.append(this.f42623e ? this.f42624f : "∞");
        sb.append(this.f42625g == boundType ? ']' : ')');
        return sb.toString();
    }
}
