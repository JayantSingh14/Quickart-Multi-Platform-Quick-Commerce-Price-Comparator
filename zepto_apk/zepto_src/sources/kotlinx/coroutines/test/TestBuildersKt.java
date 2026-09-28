package kotlinx.coroutines.test;

import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata
/* loaded from: classes3.dex */
public final class TestBuildersKt {
    public static final void a(Throwable th, List list) throws Throwable {
        Object obj = TestBuildersKt__TestBuildersKt.f55272a;
        if (th != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ExceptionsKt.a(th, (Throwable) it.next());
            }
            throw th;
        }
        Throwable th2 = (Throwable) CollectionsKt.firstOrNull(list);
        if (th2 != null) {
            Iterator it2 = CollectionsKt.v(list).iterator();
            while (it2.hasNext()) {
                ExceptionsKt.a(th2, (Throwable) it2.next());
            }
            throw th2;
        }
    }
}
