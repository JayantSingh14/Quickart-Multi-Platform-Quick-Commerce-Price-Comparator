package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzaz extends zzbb {
    @Override // com.google.android.play.core.splitinstall.zzbb, com.google.android.play.core.splitinstall.internal.zzbq
    public final void Fb(ArrayList arrayList) {
        super.Fb(arrayList);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(SplitInstallSessionState.m((Bundle) it.next()));
        }
        this.f42101a.d(arrayList2);
    }
}
