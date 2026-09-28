package com.facebook.soloader.recovery;

import android.util.Log;
import com.facebook.soloader.BackupSoSource;
import com.facebook.soloader.SoLoaderDSONotFoundError;
import com.facebook.soloader.SoLoaderULError;
import com.facebook.soloader.SoSource;
import com.facebook.soloader.UnpackingSoSource;

/* loaded from: classes3.dex */
public class ReunpackNonBackupSoSources implements RecoveryStrategy {
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public final boolean a(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        if ((unsatisfiedLinkError instanceof SoLoaderULError) && !(unsatisfiedLinkError instanceof SoLoaderDSONotFoundError)) {
            String str = ((SoLoaderULError) unsatisfiedLinkError).f20298a;
            StringBuilder sb = new StringBuilder("Reunpacking NonApk UnpackingSoSources due to ");
            sb.append(unsatisfiedLinkError);
            sb.append(str == null ? "" : ", retrying for specific library ".concat(str));
            Log.e("SoLoader", sb.toString());
            for (SoSource soSource : soSourceArr) {
                if (soSource instanceof UnpackingSoSource) {
                    UnpackingSoSource unpackingSoSource = (UnpackingSoSource) soSource;
                    if (unpackingSoSource instanceof BackupSoSource) {
                        continue;
                    } else {
                        try {
                            Log.e("SoLoader", "Runpacking " + unpackingSoSource.c());
                            unpackingSoSource.e(2);
                        } catch (Exception e2) {
                            Log.e("SoLoader", "Encountered an exception while reunpacking " + unpackingSoSource.c() + " for library " + str + ": ", e2);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
