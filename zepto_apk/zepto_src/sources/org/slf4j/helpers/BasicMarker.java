package org.slf4j.helpers;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class BasicMarker implements Marker {

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f57887b = new CopyOnWriteArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final String f57886a = "FINALIZE_SESSION";

    @Override // org.slf4j.Marker
    public final boolean contains(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (this.f57886a.equals(str)) {
            return true;
        }
        if (this.f57887b.size() <= 0) {
            return false;
        }
        Iterator it = this.f57887b.iterator();
        while (it.hasNext()) {
            if (((Marker) it.next()).contains(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Marker)) {
            return this.f57886a.equals(((Marker) obj).getName());
        }
        return false;
    }

    @Override // org.slf4j.Marker
    public final String getName() {
        return this.f57886a;
    }

    public final int hashCode() {
        return this.f57886a.hashCode();
    }

    public final String toString() {
        boolean z = this.f57887b.size() > 0;
        String str = this.f57886a;
        if (!z) {
            return str;
        }
        Iterator it = this.f57887b.iterator();
        StringBuilder sb = new StringBuilder(str);
        sb.append(" [ ");
        while (it.hasNext()) {
            sb.append(((Marker) it.next()).getName());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
