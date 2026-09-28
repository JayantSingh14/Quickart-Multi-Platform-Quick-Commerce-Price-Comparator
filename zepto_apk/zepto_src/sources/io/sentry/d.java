package io.sentry;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import io.sentry.metrics.EncodedMetrics;
import io.sentry.metrics.Metric;
import io.sentry.metrics.MetricsHelper;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52731a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52732b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f52731a = i2;
        this.f52732b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f52731a) {
            case 0:
                HostnameCache hostnameCache = (HostnameCache) this.f52732b;
                HostnameCache hostnameCache2 = HostnameCache.f51644i;
                hostnameCache.getClass();
                try {
                    hostnameCache.f51649e.getClass();
                    hostnameCache.f51646b = InetAddress.getLocalHost().getCanonicalHostName();
                    hostnameCache.f51647c = System.currentTimeMillis() + hostnameCache.f51645a;
                    return null;
                } finally {
                    hostnameCache.f51648d.set(false);
                }
            default:
                Charset charset = SentryEnvelopeItem.f51819d;
                EncodedMetrics encodedMetrics = (EncodedMetrics) this.f52732b;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : encodedMetrics.f52780a.entrySet()) {
                    ((Long) entry.getKey()).getClass();
                    Collection collectionValues = ((Map) entry.getValue()).values();
                    Pattern pattern = MetricsHelper.f52782a;
                    Iterator it = collectionValues.iterator();
                    if (it.hasNext()) {
                        Metric metric = (Metric) it.next();
                        metric.getClass();
                        sb.append(MetricsHelper.f52783b.matcher(null).replaceAll(Attributes.PREDEFINED_ATTRIBUTE_PREFIX));
                        sb.append("@");
                        sb.append(MetricsHelper.f52782a.matcher("none").replaceAll(""));
                        for (Object obj : metric.b()) {
                            sb.append(":");
                            sb.append(obj);
                        }
                        sb.append(CLConstants.SALT_DELIMETER);
                        throw null;
                    }
                }
                return sb.toString().getBytes(EncodedMetrics.f52779b);
        }
    }
}
