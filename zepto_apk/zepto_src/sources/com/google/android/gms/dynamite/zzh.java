package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class zzh implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int iB = iVersions.b(context, str);
        selectionResult.f22331a = iB;
        if (iB != 0) {
            selectionResult.f22333c = -1;
            return selectionResult;
        }
        int iA = iVersions.a(context, str, true);
        selectionResult.f22332b = iA;
        if (iA != 0) {
            selectionResult.f22333c = 1;
        }
        return selectionResult;
    }
}
