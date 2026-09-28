package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import java.io.Serializable;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Function f42531a;

    /* renamed from: b, reason: collision with root package name */
    public final Ordering f42532b;

    public ByFunctionOrdering(Function function, Ordering ordering) {
        this.f42531a = function;
        ordering.getClass();
        this.f42532b = ordering;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Function function = this.f42531a;
        return this.f42532b.compare(function.apply(obj), function.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByFunctionOrdering) {
            ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
            if (this.f42531a.equals(byFunctionOrdering.f42531a) && this.f42532b.equals(byFunctionOrdering.f42532b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f42531a, this.f42532b});
    }

    public final String toString() {
        return this.f42532b + ".onResultOf(" + this.f42531a + ")";
    }
}
