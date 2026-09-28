package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MotionScene {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1771a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1772b = new ArrayList();

    public final String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        ArrayList arrayList = this.f1771a;
        if (!arrayList.isEmpty()) {
            sb.append("Transitions:{\n");
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                ((Transition) it.next()).toString();
                throw null;
            }
            sb.append("},\n");
        }
        ArrayList arrayList2 = this.f1772b;
        if (!arrayList2.isEmpty()) {
            sb.append("ConstraintSets:{\n");
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                ((ConstraintSet) it2.next()).getClass();
                throw null;
            }
            sb.append("},\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
