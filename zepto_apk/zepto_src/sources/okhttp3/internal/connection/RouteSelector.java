package okhttp3.internal.connection;

import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

@Metadata
/* loaded from: classes.dex */
public final class RouteSelector {

    /* renamed from: a, reason: collision with root package name */
    public final Address f56561a;

    /* renamed from: b, reason: collision with root package name */
    public final RouteDatabase f56562b;

    /* renamed from: c, reason: collision with root package name */
    public final Call f56563c;

    /* renamed from: d, reason: collision with root package name */
    public final EventListener f56564d;

    /* renamed from: e, reason: collision with root package name */
    public final List f56565e;

    /* renamed from: f, reason: collision with root package name */
    public int f56566f;

    /* renamed from: g, reason: collision with root package name */
    public Object f56567g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f56568h;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Selection {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f56569a;

        /* renamed from: b, reason: collision with root package name */
        public int f56570b;

        public Selection(ArrayList routes) {
            Intrinsics.checkNotNullParameter(routes, "routes");
            this.f56569a = routes;
        }

        public final boolean a() {
            return this.f56570b < this.f56569a.size();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        List listL;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f56561a = address;
        this.f56562b = routeDatabase;
        this.f56563c = call;
        this.f56564d = eventListener;
        EmptyList emptyList = EmptyList.f53609a;
        this.f56565e = emptyList;
        this.f56567g = emptyList;
        this.f56568h = new ArrayList();
        HttpUrl httpUrl = address.f56140i;
        eventListener.p(call, httpUrl);
        Proxy proxy = address.f56138g;
        if (proxy != null) {
            listL = CollectionsKt.H(proxy);
        } else {
            URI uriI = httpUrl.i();
            if (uriI.getHost() == null) {
                listL = Util.l(Proxy.NO_PROXY);
            } else {
                List<Proxy> proxiesOrNull = address.f56139h.select(uriI);
                List<Proxy> list = proxiesOrNull;
                if (list == null || list.isEmpty()) {
                    listL = Util.l(Proxy.NO_PROXY);
                } else {
                    Intrinsics.checkNotNullExpressionValue(proxiesOrNull, "proxiesOrNull");
                    listL = Util.y(proxiesOrNull);
                }
            }
        }
        this.f56565e = listL;
        this.f56566f = 0;
        eventListener.o(call, httpUrl, listL);
    }

    public final boolean a() {
        return this.f56566f < this.f56565e.size() || !this.f56568h.isEmpty();
    }
}
