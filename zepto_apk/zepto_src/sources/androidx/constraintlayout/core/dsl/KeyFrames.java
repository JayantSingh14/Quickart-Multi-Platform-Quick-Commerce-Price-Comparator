package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class KeyFrames {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1768a = new ArrayList();

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f1768a;
        if (!arrayList.isEmpty()) {
            sb.append("keyFrames:{\n");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(((Keys) it.next()).toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
