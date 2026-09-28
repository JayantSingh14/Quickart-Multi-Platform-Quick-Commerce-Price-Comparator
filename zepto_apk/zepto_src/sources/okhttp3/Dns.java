package okhttp3;

import android.support.v4.media.b;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface Dns {

    /* renamed from: a, reason: collision with root package name */
    public static final Dns f56242a = new Companion.DnsSystem();

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public final List a(String hostname) throws UnknownHostException {
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
                    return ArraysKt.F(allByName);
                } catch (NullPointerException e2) {
                    UnknownHostException unknownHostException = new UnknownHostException(b.C("Broken system behaviour for dns lookup of ", hostname));
                    unknownHostException.initCause(e2);
                    throw unknownHostException;
                }
            }
        }
    }

    List a(String str);
}
