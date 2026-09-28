package com.facebook.soloader.recovery;

import android.util.Log;
import com.facebook.soloader.BackupSoSource;
import com.facebook.soloader.SoLoaderULError;
import com.facebook.soloader.SoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;

/* loaded from: classes3.dex */
public class CheckOnDiskStateDataData implements RecoveryStrategy {
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public final boolean a(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        if (unsatisfiedLinkError instanceof SoLoaderULError) {
            Log.e("SoLoader", "Checking /data/data missing libraries.");
            boolean z = false;
            for (SoSource soSource : soSourceArr) {
                if ((soSource instanceof UnpackingSoSource) && !(soSource instanceof BackupSoSource)) {
                    UnpackingSoSource unpackingSoSource = (UnpackingSoSource) soSource;
                    try {
                        UnpackingSoSource.Dso[] dsoArrG = unpackingSoSource.g();
                        int length = dsoArrG.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                UnpackingSoSource.Dso dso = dsoArrG[i2];
                                File file = new File(unpackingSoSource.f20254a, dso.f20304a);
                                if (!file.exists()) {
                                    file = null;
                                }
                                if (file == null) {
                                    Log.e("SoLoader", "Missing " + dso.f20304a + " from " + unpackingSoSource.c() + ", will force prepare.");
                                    unpackingSoSource.e(2);
                                    z = true;
                                    break;
                                }
                                i2++;
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("SoLoader", "Encountered an exception while recovering from /data/data failure ", e2);
                    }
                }
            }
            if (z) {
                Log.e("SoLoader", "Successfully recovered from /data/data disk failure.");
                return true;
            }
            Log.e("SoLoader", "No libraries missing from unpacking so paths while recovering /data/data failure");
            return false;
        }
        return false;
    }
}
