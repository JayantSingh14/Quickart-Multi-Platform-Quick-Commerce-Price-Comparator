package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(Object obj);
}
