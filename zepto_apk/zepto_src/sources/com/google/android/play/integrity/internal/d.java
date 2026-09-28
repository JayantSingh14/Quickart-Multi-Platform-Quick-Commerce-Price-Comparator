package com.google.android.play.integrity.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class d {
    public static final ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            Bundle bundle = new Bundle();
            bundle.putInt("event_type", fVar.a());
            bundle.putLong("event_timestamp", fVar.b());
            arrayList2.add(bundle);
        }
        return arrayList2;
    }

    public static final void b(int i2, ArrayList arrayList) {
        arrayList.add(new e(i2, System.currentTimeMillis()));
    }
}
