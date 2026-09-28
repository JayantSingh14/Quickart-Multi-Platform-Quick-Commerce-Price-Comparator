package com.google.common.reflect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
}
