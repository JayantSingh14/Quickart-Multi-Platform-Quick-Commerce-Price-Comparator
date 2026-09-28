package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Function<F, T> {
    @ParametricNullness
    T apply(@ParametricNullness F f2);

    boolean equals(@CheckForNull Object obj);
}
