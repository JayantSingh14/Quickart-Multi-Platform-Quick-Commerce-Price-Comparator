package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzcm implements zzcj {
    private final int[] zza = new int[2];

    @Override // com.google.ads.interactivemedia.v3.internal.zzcj
    public final JSONObject zza(View view) {
        if (view == null) {
            return zzct.zza(0, 0, 0, 0);
        }
        int[] iArr = this.zza;
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(iArr);
        int[] iArr2 = this.zza;
        return zzct.zza(iArr2[0], iArr2[1], width, height);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzcj
    public final void zzb(View view, JSONObject jSONObject, zzci zzciVar, boolean z, boolean z2) {
        int i2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z) {
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    zzciVar.zza(viewGroup.getChildAt(i3), this, jSONObject, z2);
                }
                return;
            }
            HashMap map = new HashMap();
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                View childAt = viewGroup.getChildAt(i4);
                ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                ArrayList arrayList3 = (ArrayList) map.get((Float) arrayList2.get(i5));
                int size2 = arrayList3.size();
                int i6 = 0;
                while (true) {
                    i2 = i5 + 1;
                    if (i6 < size2) {
                        zzciVar.zza((View) arrayList3.get(i6), this, jSONObject, z2);
                        i6++;
                    }
                }
                i5 = i2;
            }
        }
    }
}
