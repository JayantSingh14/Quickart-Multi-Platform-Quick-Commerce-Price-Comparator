package androidx.media3.common.util;

import android.os.Bundle;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class BundleCollectionUtil {
    public static ImmutableList a(Function function, List list) {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Bundle bundle = (Bundle) list.get(i2);
            bundle.getClass();
            builder.h(function.apply(bundle));
        }
        return builder.j();
    }

    public static ArrayList b(Collection collection, Function function) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) function.apply(it.next()));
        }
        return arrayList;
    }
}
