package org.xbill.DNS.config;

import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.function.Predicate;
import org.xbill.DNS.EDNSOption;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.dnssec.ValidatingResolver;
import org.xbill.DNS.lookup.LookupResult;

/* loaded from: classes5.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f57921a;

    public /* synthetic */ a(int i2) {
        this.f57921a = i2;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f57921a) {
            case 0:
                return BaseResolverConfigProvider.lambda$servers$1((InetSocketAddress) obj);
            case 1:
                return ValidatingResolver.lambda$applyEdeToOpt$19((EDNSOption) obj);
            case 2:
                return Objects.nonNull((Name) obj);
            case 3:
                return Objects.nonNull((Message) obj);
            default:
                return LookupResult.lambda$new$0((Message) obj);
        }
    }
}
