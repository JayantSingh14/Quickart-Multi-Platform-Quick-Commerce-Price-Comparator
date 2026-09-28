package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzk implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        int iA;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int iB = iVersions.b(context, str);
        selectionResult.f22331a = iB;
        int i2 = 1;
        int i3 = 0;
        if (iB != 0) {
            iA = iVersions.a(context, str, false);
            selectionResult.f22332b = iA;
        } else {
            iA = iVersions.a(context, str, true);
            selectionResult.f22332b = iA;
        }
        int i4 = selectionResult.f22331a;
        if (i4 == 0) {
            if (iA == 0) {
                i2 = 0;
            }
            selectionResult.f22333c = i2;
            return selectionResult;
        }
        i3 = i4;
        if (i3 >= iA) {
            i2 = -1;
        }
        selectionResult.f22333c = i2;
        return selectionResult;
    }
}
