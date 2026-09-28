package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        Object a();

        Object b();

        Object getValue();
    }

    boolean equals(Object obj);

    Map g();

    int hashCode();

    Set n();

    int size();
}
