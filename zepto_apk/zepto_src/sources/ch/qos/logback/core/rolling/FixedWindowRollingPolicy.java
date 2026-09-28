package ch.qos.logback.core.rolling;

import ch.qos.logback.core.rolling.helper.CompressionMode;
import ch.qos.logback.core.rolling.helper.RenameUtil;

/* loaded from: classes3.dex */
public class FixedWindowRollingPolicy extends RollingPolicyBase {

    /* renamed from: e, reason: collision with root package name */
    public final RenameUtil f13714e = new RenameUtil();

    /* renamed from: ch.qos.logback.core.rolling.FixedWindowRollingPolicy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13715a;

        static {
            int[] iArr = new int[CompressionMode.values().length];
            f13715a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13715a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13715a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13714e.V(this.f13733b);
        l1("The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. ");
        l1("See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
        throw new IllegalStateException("The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
    }
}
