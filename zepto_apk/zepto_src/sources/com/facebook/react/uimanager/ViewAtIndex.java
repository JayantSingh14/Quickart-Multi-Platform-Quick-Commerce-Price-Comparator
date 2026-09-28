package com.facebook.react.uimanager;

import java.util.Comparator;

/* loaded from: classes.dex */
public class ViewAtIndex {

    /* renamed from: c, reason: collision with root package name */
    public static final Comparator f19591c = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f19592a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19593b;

    /* renamed from: com.facebook.react.uimanager.ViewAtIndex$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<ViewAtIndex> {
        @Override // java.util.Comparator
        public final int compare(ViewAtIndex viewAtIndex, ViewAtIndex viewAtIndex2) {
            return viewAtIndex.f19593b - viewAtIndex2.f19593b;
        }
    }

    public ViewAtIndex(int i2, int i3) {
        this.f19592a = i2;
        this.f19593b = i3;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            ViewAtIndex viewAtIndex = (ViewAtIndex) obj;
            if (this.f19593b == viewAtIndex.f19593b && this.f19592a == viewAtIndex.f19592a) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f19592a);
        sb.append(", ");
        return android.support.v4.media.b.o(sb, this.f19593b, "]");
    }
}
