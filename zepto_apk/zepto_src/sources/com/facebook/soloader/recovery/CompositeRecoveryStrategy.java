package com.facebook.soloader.recovery;

import com.facebook.soloader.SoSource;

/* loaded from: classes3.dex */
public class CompositeRecoveryStrategy implements RecoveryStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final RecoveryStrategy[] f20315a;

    /* renamed from: b, reason: collision with root package name */
    public int f20316b = 0;

    public CompositeRecoveryStrategy(RecoveryStrategy... recoveryStrategyArr) {
        this.f20315a = recoveryStrategyArr;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public final boolean a(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        int i2;
        RecoveryStrategy[] recoveryStrategyArr;
        do {
            i2 = this.f20316b;
            recoveryStrategyArr = this.f20315a;
            if (i2 >= recoveryStrategyArr.length) {
                return false;
            }
            this.f20316b = i2 + 1;
        } while (!recoveryStrategyArr[i2].a(unsatisfiedLinkError, soSourceArr));
        return true;
    }
}
