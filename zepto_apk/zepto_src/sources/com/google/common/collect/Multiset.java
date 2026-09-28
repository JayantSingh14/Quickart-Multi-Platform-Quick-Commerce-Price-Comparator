package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        Object a();

        int getCount();
    }

    int O1(Object obj);

    int T(int i2, Object obj);

    int add(int i2, Object obj);

    Set e();

    Set entrySet();

    boolean equals(Object obj);

    int hashCode();

    int o1(Object obj);

    boolean u0(int i2, Object obj);
}
