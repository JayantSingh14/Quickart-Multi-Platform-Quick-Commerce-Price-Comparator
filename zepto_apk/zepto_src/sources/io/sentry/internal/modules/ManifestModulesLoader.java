package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class ManifestModulesLoader extends ModulesLoader {

    /* renamed from: d, reason: collision with root package name */
    public final Pattern f52758d;

    /* renamed from: e, reason: collision with root package name */
    public final Pattern f52759e;

    /* renamed from: f, reason: collision with root package name */
    public final ClassLoader f52760f;

    public static final class Module {

        /* renamed from: a, reason: collision with root package name */
        public final String f52761a;

        /* renamed from: b, reason: collision with root package name */
        public final String f52762b;

        public Module(String str, String str2) {
            this.f52761a = str;
            this.f52762b = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManifestModulesLoader(ILogger iLogger) {
        super(iLogger);
        ClassLoader classLoader = ManifestModulesLoader.class.getClassLoader();
        this.f52758d = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.f52759e = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.f52760f = classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    public final Map b() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.f52760f.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                Matcher matcher = this.f52758d.matcher(resources.nextElement().toString());
                Module module = null;
                String strGroup = (matcher.matches() && matcher.groupCount() == 1) ? matcher.group(1) : null;
                if (strGroup != null) {
                    Matcher matcher2 = this.f52759e.matcher(strGroup);
                    if (matcher2.matches() && matcher2.groupCount() == 2) {
                        module = new Module(matcher2.group(1), matcher2.group(2));
                    }
                }
                if (module != null) {
                    arrayList.add(module);
                }
            }
        } catch (Throwable th) {
            this.f52764a.b(SentryLevel.ERROR, "Unable to detect modules via manifest files.", th);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Module module2 = (Module) it.next();
            map.put(module2.f52761a, module2.f52762b);
        }
        return map;
    }
}
