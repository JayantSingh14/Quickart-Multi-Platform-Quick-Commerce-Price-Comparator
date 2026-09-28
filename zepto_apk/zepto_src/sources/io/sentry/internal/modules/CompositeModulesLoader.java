package io.sentry.internal.modules;

import io.sentry.ILogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class CompositeModulesLoader extends ModulesLoader {

    /* renamed from: d, reason: collision with root package name */
    public final List f52757d;

    public CompositeModulesLoader(List list, ILogger iLogger) {
        super(iLogger);
        this.f52757d = list;
    }

    @Override // io.sentry.internal.modules.ModulesLoader
    public final Map b() {
        TreeMap treeMap = new TreeMap();
        Iterator it = this.f52757d.iterator();
        while (it.hasNext()) {
            Map mapA = ((IModulesLoader) it.next()).a();
            if (mapA != null) {
                treeMap.putAll(mapA);
            }
        }
        return treeMap;
    }
}
