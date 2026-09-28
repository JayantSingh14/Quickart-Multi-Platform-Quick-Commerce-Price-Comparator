package ch.qos.logback.core.joran.spi;

import android.support.v4.media.a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ElementPath {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f13556a = new ArrayList();

    public ElementPath() {
    }

    public final String a(int i2) {
        return (String) this.f13556a.get(i2);
    }

    public final String b() {
        ArrayList arrayList = this.f13556a;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(arrayList.size() - 1);
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f13556a.iterator();
        while (it.hasNext()) {
            a.u(sb, "[", (String) it.next(), "]");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ElementPath)) {
            return false;
        }
        ElementPath elementPath = (ElementPath) obj;
        int size = elementPath.f13556a.size();
        ArrayList arrayList = this.f13556a;
        if (size != arrayList.size()) {
            return false;
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!a(i2).equalsIgnoreCase(elementPath.a(i2))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return c();
    }

    public ElementPath(String str) {
        String[] strArrSplit;
        if (str == null || (strArrSplit = str.split("/")) == null) {
            return;
        }
        for (String str2 : strArrSplit) {
            if (str2.length() > 0) {
                this.f13556a.add(str2);
            }
        }
    }
}
