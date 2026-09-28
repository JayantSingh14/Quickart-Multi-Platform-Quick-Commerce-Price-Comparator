package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public abstract class SplitInstallSessionState {
    public static SplitInstallSessionState b(int i2, int i3, int i4, long j2, long j3, List list, List list2) {
        if (i3 != 8) {
            return new zza(i2, i3, i4, j2, j3, list, list2, null, null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    public static SplitInstallSessionState m(Bundle bundle) {
        return new zza(bundle.getInt("session_id"), bundle.getInt(CLConstants.OTP_STATUS), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public abstract long a();

    public abstract int c();

    public final ArrayList d() {
        return j() != null ? new ArrayList(j()) : new ArrayList();
    }

    public final ArrayList e() {
        return k() != null ? new ArrayList(k()) : new ArrayList();
    }

    public abstract PendingIntent f();

    public abstract int g();

    public abstract int h();

    public abstract long i();

    public abstract List j();

    public abstract List k();

    public abstract List l();
}
