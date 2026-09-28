package org.xbill.DNS.lookup;

import java.util.function.Function;
import org.xbill.DNS.Message;
import org.xbill.DNS.RRset;

/* loaded from: classes5.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58036a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LookupSession f58037b;

    public /* synthetic */ b(LookupSession lookupSession, int i2) {
        this.f58036a = i2;
        this.f58037b = lookupSession;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f58036a) {
            case 0:
                return this.f58037b.maybeAddToCache((Message) obj);
            default:
                return this.f58037b.lambda$setResponseToMessageFuture$10((RRset) obj);
        }
    }
}
