package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzfiq {
    public static com.google.android.gms.ads.internal.client.zzr a(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfhs zzfhsVar = (zzfhs) it.next();
            if (zzfhsVar.f31164c) {
                arrayList.add(AdSize.o);
            } else {
                arrayList.add(new AdSize(zzfhsVar.f31162a, zzfhsVar.f31163b));
            }
        }
        return new com.google.android.gms.ads.internal.client.zzr(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }
}
