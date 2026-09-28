package org.xbill.DNS.config;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;

/* loaded from: classes5.dex */
public abstract class BaseResolverConfigProvider implements ResolverConfigProvider {
    protected static final int DEFAULT_PORT = 53;
    private static final boolean IPV4_ONLY = Boolean.getBoolean("java.net.preferIPv4Stack");
    private static final boolean IPV6_FIRST = Boolean.getBoolean("java.net.preferIPv6Addresses");
    private final List<InetSocketAddress> nameservers = new ArrayList(3);
    protected final Logger log = LoggerFactory.b(getClass());
    protected final List<Name> searchlist = new ArrayList(1);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$servers$0(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        return Integer.compare(inetSocketAddress2.getAddress().getAddress().length, inetSocketAddress.getAddress().getAddress().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$servers$1(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.getAddress() instanceof Inet4Address;
    }

    public void addNameserver(InetSocketAddress inetSocketAddress) {
        if (this.nameservers.contains(inetSocketAddress)) {
            return;
        }
        this.nameservers.add(inetSocketAddress);
        this.log.s(inetSocketAddress, "Added {} to nameservers");
    }

    public void addSearchPath(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            Name nameFromString = Name.fromString(str, Name.root);
            if (this.searchlist.contains(nameFromString)) {
                return;
            }
            this.searchlist.add(nameFromString);
            this.log.s(nameFromString, "Added {} to search paths");
        } catch (TextParseException unused) {
            this.log.n(str, "Could not parse search path {} as a dns name, ignoring");
        }
    }

    public int parseNdots(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return 1;
        }
        try {
            int i2 = Integer.parseInt(str);
            if (i2 < 0) {
                return 1;
            }
            if (i2 > 15) {
                return 15;
            }
            return i2;
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    public void parseSearchPathList(String str, String str2) {
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                addSearchPath(stringTokenizer.nextToken());
            }
        }
    }

    public final void reset() {
        this.nameservers.clear();
        this.searchlist.clear();
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public final List<Name> searchPaths() {
        return Collections.unmodifiableList(this.searchlist);
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public final List<InetSocketAddress> servers() {
        return IPV6_FIRST ? (List) this.nameservers.stream().sorted(new androidx.media3.datasource.cache.a(6)).collect(Collectors.toList()) : IPV4_ONLY ? (List) this.nameservers.stream().filter(new a(0)).collect(Collectors.toList()) : Collections.unmodifiableList(this.nameservers);
    }
}
