package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Route {

    /* renamed from: a, reason: collision with root package name */
    public final Address f56384a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f56385b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f56386c;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(socketAddress, "socketAddress");
        this.f56384a = address;
        this.f56385b = proxy;
        this.f56386c = socketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return Intrinsics.b(route.f56384a, this.f56384a) && Intrinsics.b(route.f56385b, this.f56385b) && Intrinsics.b(route.f56386c, this.f56386c);
    }

    public final int hashCode() {
        return this.f56386c.hashCode() + ((this.f56385b.hashCode() + ((this.f56384a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f56386c + '}';
    }
}
