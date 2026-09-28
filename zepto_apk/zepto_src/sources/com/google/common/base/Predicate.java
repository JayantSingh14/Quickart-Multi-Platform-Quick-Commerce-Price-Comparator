package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Predicate<T> {
    boolean apply(Object obj);

    boolean equals(Object obj);
}
