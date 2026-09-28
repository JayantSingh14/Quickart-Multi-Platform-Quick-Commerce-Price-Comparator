package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata
/* loaded from: classes.dex */
public final class ExchangeFinder {

    /* renamed from: a, reason: collision with root package name */
    public final RealConnectionPool f56507a;

    /* renamed from: b, reason: collision with root package name */
    public final Address f56508b;

    /* renamed from: c, reason: collision with root package name */
    public final RealCall f56509c;

    /* renamed from: d, reason: collision with root package name */
    public final EventListener f56510d;

    /* renamed from: e, reason: collision with root package name */
    public RouteSelector.Selection f56511e;

    /* renamed from: f, reason: collision with root package name */
    public RouteSelector f56512f;

    /* renamed from: g, reason: collision with root package name */
    public int f56513g;

    /* renamed from: h, reason: collision with root package name */
    public int f56514h;

    /* renamed from: i, reason: collision with root package name */
    public int f56515i;

    /* renamed from: j, reason: collision with root package name */
    public Route f56516j;

    public ExchangeFinder(RealConnectionPool connectionPool, Address address, RealCall call, EventListener eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f56507a = connectionPool;
        this.f56508b = address;
        this.f56509c = call;
        this.f56510d = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.internal.connection.RealConnection a(int r15, int r16, int r17, boolean r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.a(int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final boolean b(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrl = this.f56508b.f56140i;
        return url.f56263e == httpUrl.f56263e && Intrinsics.b(url.f56262d, httpUrl.f56262d);
    }

    public final void c(IOException e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.f56516j = null;
        if ((e2 instanceof StreamResetException) && ((StreamResetException) e2).f56766a == ErrorCode.REFUSED_STREAM) {
            this.f56513g++;
        } else if (e2 instanceof ConnectionShutdownException) {
            this.f56514h++;
        } else {
            this.f56515i++;
        }
    }
}
