package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@GwtCompatible
@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface MapDifference<K, V> {

    @DoNotMock
    public interface ValueDifference<V> {
    }

    Map a();
}
