package com.facebook.soloader.recovery;

import android.content.Context;
import android.support.v4.media.b;
import com.facebook.soloader.NoBaseApkException;
import com.facebook.soloader.SoSource;
import java.io.File;

/* loaded from: classes3.dex */
public class CheckBaseApkExists implements RecoveryStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20312a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseApkPathHistory f20313b;

    public CheckBaseApkExists(Context context, BaseApkPathHistory baseApkPathHistory) {
        this.f20312a = context;
        this.f20313b = baseApkPathHistory;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public final boolean a(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        String str = this.f20312a.getApplicationInfo().sourceDir;
        if (new File(str).exists()) {
            b.A("Base apk exists: ", str, "soloader.recovery.CheckBaseApkExists");
            return false;
        }
        StringBuilder sbY = b.y("Base apk does not exist: ", str, ". ");
        this.f20313b.b(sbY);
        throw new NoBaseApkException(sbY.toString(), unsatisfiedLinkError);
    }
}
