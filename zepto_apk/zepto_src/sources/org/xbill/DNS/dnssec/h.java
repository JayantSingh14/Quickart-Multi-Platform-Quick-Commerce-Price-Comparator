package org.xbill.DNS.dnssec;

import java.net.InetSocketAddress;
import java.util.function.Function;
import org.xbill.DNS.Cache;
import org.xbill.DNS.Name;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.lookup.LookupSession;

/* loaded from: classes5.dex */
public final /* synthetic */ class h implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57956a;

    public /* synthetic */ h(int i2) {
        this.f57956a = i2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f57956a) {
            case 0:
                return ValidatingResolver.lambda$validateNameErrorResponse$8((Throwable) obj);
            case 1:
                return LookupSession.lambda$new$0((Cache) obj);
            case 2:
                return new SimpleResolver((InetSocketAddress) obj);
            case 3:
                return Integer.valueOf(((Cache) obj).getDClass());
            case 4:
                return LookupSession.LookupSessionBuilder.lambda$build$0((Name) obj);
            default:
                return new Cache(((Integer) obj).intValue());
        }
    }
}
