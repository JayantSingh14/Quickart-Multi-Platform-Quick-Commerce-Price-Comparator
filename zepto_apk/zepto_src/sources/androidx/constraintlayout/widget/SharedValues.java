package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class SharedValues {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2532a;

    public interface SharedValuesListener {
    }

    public SharedValues() {
        new SparseIntArray();
        this.f2532a = new HashMap();
    }

    public final void a(int i2, SharedValuesListener sharedValuesListener) {
        HashMap map = this.f2532a;
        HashSet hashSet = (HashSet) map.get(Integer.valueOf(i2));
        if (hashSet == null) {
            hashSet = new HashSet();
            map.put(Integer.valueOf(i2), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }
}
