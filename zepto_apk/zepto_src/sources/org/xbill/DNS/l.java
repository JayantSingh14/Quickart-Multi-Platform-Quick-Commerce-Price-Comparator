package org.xbill.DNS;

import java.util.function.ToIntFunction;
import org.xbill.DNS.ExtendedResolver;

/* loaded from: classes5.dex */
public final /* synthetic */ class l implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ExtendedResolver.Resolution.lambda$new$1((ExtendedResolver.ResolverEntry) obj);
    }
}
