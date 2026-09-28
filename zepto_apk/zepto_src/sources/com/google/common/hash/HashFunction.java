package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public interface HashFunction {
    HashCode a(String str);
}
