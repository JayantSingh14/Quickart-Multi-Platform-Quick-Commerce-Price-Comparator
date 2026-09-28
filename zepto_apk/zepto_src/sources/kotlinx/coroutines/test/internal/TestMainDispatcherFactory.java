package kotlinx.coroutines.test.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import kotlinx.coroutines.internal.MissingMainCoroutineDispatcherFactory;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TestMainDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final MainCoroutineDispatcher a(List list) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((MainDispatcherFactory) obj2) != this) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
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
            mainDispatcherFactory = MissingMainCoroutineDispatcherFactory.f55100a;
        }
        return new TestMainDispatcher(mainDispatcherFactory.a(arrayList));
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final int b() {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
