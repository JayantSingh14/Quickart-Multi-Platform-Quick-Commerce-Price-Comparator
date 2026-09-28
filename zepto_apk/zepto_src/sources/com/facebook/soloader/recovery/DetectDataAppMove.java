package com.facebook.soloader.recovery;

import android.content.Context;
import android.util.Log;
import com.facebook.soloader.RecoverableSoSource;
import com.facebook.soloader.SoSource;
import java.io.File;

/* loaded from: classes3.dex */
public class DetectDataAppMove implements RecoveryStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20320a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseApkPathHistory f20321b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20322c;

    public DetectDataAppMove(Context context, BaseApkPathHistory baseApkPathHistory) {
        int i2;
        this.f20320a = context;
        this.f20321b = baseApkPathHistory;
        synchronized (baseApkPathHistory) {
            i2 = baseApkPathHistory.f20311b;
        }
        this.f20322c = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public final boolean a(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        int i2;
        Context context = this.f20320a;
        String str = context.getApplicationInfo().sourceDir;
        boolean zExists = new File(str).exists();
        BaseApkPathHistory baseApkPathHistory = this.f20321b;
        if (zExists && baseApkPathHistory.a(str)) {
            for (int i3 = 0; i3 < soSourceArr.length; i3++) {
                Object[] objArr = soSourceArr[i3];
                if (objArr instanceof RecoverableSoSource) {
                    soSourceArr[i3] = ((RecoverableSoSource) objArr).b(context);
                }
            }
            return true;
        }
        int i4 = this.f20322c;
        synchronized (baseApkPathHistory) {
            i2 = baseApkPathHistory.f20311b;
        }
        if (i4 == i2) {
            return false;
        }
        Log.w("soloader.recovery.DetectDataAppMove", "Context was updated (perhaps by another thread)");
        return true;
    }
}
