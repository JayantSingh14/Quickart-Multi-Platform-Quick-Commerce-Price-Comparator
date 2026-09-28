package com.facebook.soloader.recovery;

import android.content.Context;

/* loaded from: classes.dex */
public class DefaultRecoveryStrategyFactory implements RecoveryStrategyFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20317a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseApkPathHistory f20318b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20319c;

    public DefaultRecoveryStrategyFactory(Context context, int i2) {
        this.f20317a = context;
        this.f20319c = i2;
        BaseApkPathHistory baseApkPathHistory = new BaseApkPathHistory();
        this.f20318b = baseApkPathHistory;
        baseApkPathHistory.a(context.getApplicationInfo().sourceDir);
    }

    public final CompositeRecoveryStrategy a() {
        Context context = this.f20317a;
        BaseApkPathHistory baseApkPathHistory = this.f20318b;
        return new CompositeRecoveryStrategy(new DetectDataAppMove(context, baseApkPathHistory), new CheckBaseApkExists(context, baseApkPathHistory), new WaitForAsyncInit(), new CheckOnDiskStateDataApp(context), new ReunpackBackupSoSources(this.f20319c), new CheckOnDiskStateDataData(), new ReunpackNonBackupSoSources(), new WaitForAsyncInit());
    }
}
