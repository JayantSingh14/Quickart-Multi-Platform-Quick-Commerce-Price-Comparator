package androidx.work.impl.background.systemjob;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.SystemClock;

@RequiresApi
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo
/* loaded from: classes.dex */
class SystemJobInfoConverter {

    /* renamed from: c, reason: collision with root package name */
    public static final String f12778c = Logger.g("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f12779a;

    /* renamed from: b, reason: collision with root package name */
    public final SystemClock f12780b;

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12781a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            f12781a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12781a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12781a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12781a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12781a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public SystemJobInfoConverter(Context context, SystemClock systemClock) {
        this.f12780b = systemClock;
        this.f12779a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
