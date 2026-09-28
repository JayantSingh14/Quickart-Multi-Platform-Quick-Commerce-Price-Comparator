package org.xbill.DNS;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.function.Function;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.NSEC3Record;

/* loaded from: classes5.dex */
public final /* synthetic */ class i implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58025a;

    public /* synthetic */ i(int i2) {
        this.f58025a = i2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f58025a) {
            case 0:
                return ExtendedResolver.ResolverEntry.access$500((ExtendedResolver.ResolverEntry) obj);
            case 1:
                return DNSSEC.Algorithm.string(((Integer) obj).intValue());
            case 2:
                return DNSSEC.Digest.string(((Integer) obj).intValue());
            case 3:
                return NSEC3Record.Digest.string(((Integer) obj).intValue());
            case 4:
                return ExtendedResolver.lambda$new$0((InetSocketAddress) obj);
            case 5:
                return ((Name) obj).toString();
            case 6:
                return Lookup.lambda$convertSearchPathDomainList$0((Name) obj);
            case 7:
                return ((Inet4Address) obj).getAddress();
            default:
                return ((Inet6Address) obj).getAddress();
        }
    }
}
