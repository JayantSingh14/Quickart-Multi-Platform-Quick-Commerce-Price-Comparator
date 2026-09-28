package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f4948a = new LinkedHashMap();

    public final void a() {
        LinkedHashMap linkedHashMap = this.f4948a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((ViewModel) it.next()).b();
        }
        linkedHashMap.clear();
    }
}
