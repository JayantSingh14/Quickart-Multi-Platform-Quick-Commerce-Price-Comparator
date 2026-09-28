package com.zeptoconsumerapp;

import com.zeptonow.horizon.HorizonSDK;
import com.zeptonow.horizon.di.DependencyContainer;
import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.EventType;
import in.juspay.hyperutil.constants.LogLevel;
import j$.time.Duration;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Dns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.Address;
import org.xbill.DNS.DohResolver;
import org.xbill.DNS.ExtendedResolver;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ZeptoDns implements Dns {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f47563b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f47564c = new HashMap();

    @Metadata
    public static final class Companion {
    }

    @Override // okhttp3.Dns
    public final List a(String hostname) throws JSONException, UnknownHostException {
        IOException e2;
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        if (!f47563b) {
            f47563b = true;
            try {
                SimpleResolver simpleResolver = new SimpleResolver("1.1.1.1");
                SimpleResolver simpleResolver2 = new SimpleResolver("8.8.8.8");
                new SimpleResolver("8.8.4.4");
                DohResolver dohResolver = new DohResolver("https://cloudflare-dns.com/dns-query");
                new DohResolver("https://dns.google/dns-query");
                ExtendedResolver extendedResolver = new ExtendedResolver(new Resolver[]{simpleResolver, simpleResolver2, dohResolver});
                extendedResolver.setTimeout(Duration.ofSeconds(5L));
                Lookup.setDefaultResolver(extendedResolver);
            } catch (UnknownHostException unused) {
                Timber.f58263c.w("Couldn't initialize custom resolvers", new Object[0]);
            }
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(Dns.f56242a.a(hostname));
            e2 = null;
        } catch (IOException e3) {
            e2 = e3;
        } catch (IllegalArgumentException e4) {
            String message = e4.getMessage();
            if (message == null) {
                message = "";
            }
            e2 = new UnknownHostException(message);
        }
        boolean zIsEmpty = arrayList.isEmpty();
        HashMap map = f47564c;
        if (zIsEmpty) {
            try {
                InetAddress[] allByName = Address.getAllByName(hostname);
                Intrinsics.c(allByName);
                if (allByName.length != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("hostname", hostname);
                    ArrayList arrayList2 = new ArrayList(allByName.length);
                    for (InetAddress inetAddress : allByName) {
                        arrayList2.add(inetAddress.getHostAddress());
                    }
                    jSONObject.put("ips", new JSONArray((Collection) arrayList2));
                    if (e2 != null) {
                        jSONObject.put(LogLevel.EXCEPTION, e2.getMessage());
                    }
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    DependencyContainer dependencyContainer = HorizonSDK.f47830a;
                    HorizonSDK.e(new Event("dns_recovered", string, EventType.f48077b));
                }
                CollectionsKt.j(arrayList, allByName);
            } catch (UnknownHostException e5) {
                if (StringsKt.n(hostname, "zepto", true)) {
                    map.put(hostname, EmptyList.f53609a);
                }
                throw e5;
            }
        }
        if (StringsKt.n(hostname, "zepto", true)) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                String hostAddress = ((InetAddress) next).getHostAddress();
                if (hostAddress != null && hostAddress.length() != 0) {
                    arrayList3.add(next);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.r(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InetAddress) it2.next()).getHostAddress());
            }
            map.put(hostname, arrayList4);
        }
        return arrayList;
    }
}
