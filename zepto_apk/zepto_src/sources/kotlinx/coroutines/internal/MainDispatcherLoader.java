package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class MainDispatcherLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final MainCoroutineDispatcher f55099a;

    static {
        Object obj;
        String strC = SystemPropsKt.c("kotlinx.coroutines.fast.service.loader");
        if (strC != null) {
            Boolean.parseBoolean(strC);
        }
        List listQ = SequencesKt.q(SequencesKt.c(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
        Iterator it = listQ.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int iB = ((MainDispatcherFactory) next).b();
                do {
                    Object next2 = it.next();
                    int iB2 = ((MainDispatcherFactory) next2).b();
                    if (iB < iB2) {
                        next = next2;
                        iB = iB2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
        if (mainDispatcherFactory == null) {
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        }
        f55099a = mainDispatcherFactory.a(listQ);
    }
}
