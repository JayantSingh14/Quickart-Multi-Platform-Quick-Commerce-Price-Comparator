package io.sentry.android.core;

import android.content.Context;
import android.content.Intent;
import io.sentry.IConnectionStatusProvider;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.ContextUtils;
import io.sentry.protocol.OperatingSystem;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class DeviceInfoUtil {

    /* renamed from: h, reason: collision with root package name */
    public static volatile DeviceInfoUtil f52119h;

    /* renamed from: a, reason: collision with root package name */
    public final Context f52120a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryAndroidOptions f52121b;

    /* renamed from: c, reason: collision with root package name */
    public final BuildInfoProvider f52122c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f52123d;

    /* renamed from: e, reason: collision with root package name */
    public final ContextUtils.SideLoadedInfo f52124e;

    /* renamed from: f, reason: collision with root package name */
    public final OperatingSystem f52125f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f52126g;

    /* renamed from: io.sentry.android.core.DeviceInfoUtil$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52127a;

        static {
            int[] iArr = new int[IConnectionStatusProvider.ConnectionStatus.values().length];
            f52127a = iArr;
            try {
                iArr[IConnectionStatusProvider.ConnectionStatus.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52127a[IConnectionStatusProvider.ConnectionStatus.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        r5 = new java.lang.String[]{"/system/xbin/which", "su"};
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c1, code lost:
    
        r5 = r1.f52326f.exec((java.lang.String[]) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
    
        r6 = new java.io.BufferedReader(new java.io.InputStreamReader(r5.getInputStream(), io.sentry.android.core.internal.util.RootChecker.f52320g));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00db, code lost:
    
        if (r6.readLine() == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00df, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
    
        r5.destroy();
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        r6 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e9, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f2, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f3, code lost:
    
        r6 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f6, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f8, code lost:
    
        r8.b(io.sentry.SentryLevel.DEBUG, "Error when trying to check if SU exists.", r6);
        r5 = r5;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0105, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0107, code lost:
    
        r8.c(io.sentry.SentryLevel.DEBUG, "SU isn't found on this Device.", new java.lang.Object[0]);
        r5 = r5;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0110, code lost:
    
        if (r5 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0113, code lost:
    
        r7 = false;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0114, code lost:
    
        if (r7 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0116, code lost:
    
        new io.sentry.android.core.BuildInfoProvider(r8);
        r5 = r1.f52321a.getPackageManager();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0121, code lost:
    
        if (r5 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0123, code lost:
    
        r1 = r1.f52325e;
        r6 = r1.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0129, code lost:
    
        r8 = r1[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012f, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 33) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0131, code lost:
    
        r5.getPackageInfo(r8, android.content.pm.PackageManager.PackageInfoFlags.of(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0139, code lost:
    
        r5.getPackageInfo(r8, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x013c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x013e, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0141, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0142, code lost:
    
        if (r1 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0145, code lost:
    
        r1 = false;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014f, code lost:
    
        if (r5 != 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0151, code lost:
    
        r5.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0154, code lost:
    
        throw r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101 A[DONT_GENERATE, PHI: r5
      0x0101: PHI (r5v13 java.lang.Process) = (r5v32 java.lang.Process), (r5v33 java.lang.Process) binds: [B:58:0x00ff, B:63:0x0110] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0147 A[EDGE_INSN: B:129:0x0147->B:82:0x0147 BREAK  A[LOOP:0: B:28:0x0097->B:36:0x00b6], PHI: r5
      0x0147: PHI (r5v23 ??) = (r5v16 ??), (r5v19 ??), (r5v7 ??), (r5v24 ??) binds: [B:66:0x0114, B:79:0x0142, B:129:0x0147, B:25:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v19, types: [android.content.pm.PackageManager] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.String[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DeviceInfoUtil(android.content.Context r14, io.sentry.android.core.SentryAndroidOptions r15) throws android.content.pm.PackageManager.NameNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DeviceInfoUtil.<init>(android.content.Context, io.sentry.android.core.SentryAndroidOptions):void");
    }

    public static Float b(Intent intent, SentryOptions sentryOptions) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    public static DeviceInfoUtil c(Context context, SentryAndroidOptions sentryAndroidOptions) {
        if (f52119h == null) {
            synchronized (DeviceInfoUtil.class) {
                try {
                    if (f52119h == null) {
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        f52119h = new DeviceInfoUtil(context, sentryAndroidOptions);
                    }
                } finally {
                }
            }
        }
        return f52119h;
    }

    public static Boolean d(Intent intent, SentryOptions sentryOptions) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x024c A[Catch: all -> 0x0266, TryCatch #5 {all -> 0x0266, blocks: (B:91:0x021f, B:94:0x0227, B:96:0x022d, B:98:0x0231, B:107:0x0249, B:102:0x0238, B:105:0x023f, B:111:0x025c, B:108:0x024c), top: B:140:0x021f }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x025c A[Catch: all -> 0x0266, TRY_LEAVE, TryCatch #5 {all -> 0x0266, blocks: (B:91:0x021f, B:94:0x0227, B:96:0x022d, B:98:0x0231, B:107:0x0249, B:102:0x0238, B:105:0x023f, B:111:0x025c, B:108:0x024c), top: B:140:0x021f }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0225  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.protocol.Device a(boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DeviceInfoUtil.a(boolean, boolean):io.sentry.protocol.Device");
    }
}
