package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StartStopTokens {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12630a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f12631b = new LinkedHashMap();

    public final boolean a(WorkGenerationalId id) {
        boolean zContainsKey;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f12630a) {
            zContainsKey = this.f12631b.containsKey(id);
        }
        return zContainsKey;
    }

    public final StartStopToken b(WorkGenerationalId id) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f12630a) {
            startStopToken = (StartStopToken) this.f12631b.remove(id);
        }
        return startStopToken;
    }

    public final List c(String workSpecId) {
        List listE0;
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        synchronized (this.f12630a) {
            try {
                LinkedHashMap linkedHashMap = this.f12631b;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (Intrinsics.b(((WorkGenerationalId) entry.getKey()).f12893a, workSpecId)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    this.f12631b.remove((WorkGenerationalId) it.next());
                }
                listE0 = CollectionsKt.e0(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return listE0;
    }

    public final StartStopToken d(WorkGenerationalId id) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f12630a) {
            try {
                LinkedHashMap linkedHashMap = this.f12631b;
                Object startStopToken2 = linkedHashMap.get(id);
                if (startStopToken2 == null) {
                    startStopToken2 = new StartStopToken(id);
                    linkedHashMap.put(id, startStopToken2);
                }
                startStopToken = (StartStopToken) startStopToken2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }
}
