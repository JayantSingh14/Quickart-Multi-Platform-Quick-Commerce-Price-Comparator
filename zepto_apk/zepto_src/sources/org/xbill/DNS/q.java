package org.xbill.DNS;

import java.util.function.Predicate;

/* loaded from: classes5.dex */
public final /* synthetic */ class q implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Message.lambda$normalize$0((RRset) obj);
    }
}
