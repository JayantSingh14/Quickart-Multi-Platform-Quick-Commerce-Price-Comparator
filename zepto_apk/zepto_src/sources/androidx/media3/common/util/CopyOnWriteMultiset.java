package androidx.media3.common.util;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@UnstableApi
/* loaded from: classes3.dex */
public final class CopyOnWriteMultiset<E> implements Iterable<E> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5671a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f5672b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Set f5673c = Collections.EMPTY_SET;

    /* renamed from: d, reason: collision with root package name */
    public List f5674d = Collections.EMPTY_LIST;

    public final int b(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        int iIntValue;
        synchronized (this.f5671a) {
            try {
                iIntValue = this.f5672b.containsKey(eventDispatcher) ? ((Integer) this.f5672b.get(eventDispatcher)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator<E> it;
        synchronized (this.f5671a) {
            it = this.f5674d.iterator();
        }
        return it;
    }
}
