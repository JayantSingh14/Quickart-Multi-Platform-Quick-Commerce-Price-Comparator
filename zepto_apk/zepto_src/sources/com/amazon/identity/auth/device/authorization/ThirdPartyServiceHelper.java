package com.amazon.identity.auth.device.authorization;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IInterface;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

@SuppressLint({"PackageManagerGetSignatures"})
/* loaded from: classes3.dex */
public class ThirdPartyServiceHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f15184a = new Object();

    public static final class TOKEN_KEYS {
    }

    public class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15185a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f15186b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ThirdPartyAuthorizationServiceConnection f15187c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Intent f15188d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f15189e;

        public a(Context context, c cVar, ThirdPartyAuthorizationServiceConnection thirdPartyAuthorizationServiceConnection, Intent intent, CountDownLatch countDownLatch) {
            this.f15185a = context;
            this.f15186b = cVar;
            this.f15187c = thirdPartyAuthorizationServiceConnection;
            this.f15188d = intent;
            this.f15189e = countDownLatch;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static c f15190a;

        /* renamed from: b, reason: collision with root package name */
        public static long f15191b;

        public static void a(c cVar) {
            f15190a = cVar;
            if (cVar == null) {
                f15191b = 0L;
            } else {
                f15191b = new Date().getTime();
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final m.a f15192a;

        /* renamed from: b, reason: collision with root package name */
        public IInterface f15193b = null;

        /* renamed from: c, reason: collision with root package name */
        public ThirdPartyAuthorizationServiceConnection f15194c;

        /* renamed from: d, reason: collision with root package name */
        public Intent f15195d;

        /* renamed from: e, reason: collision with root package name */
        public final ResolveInfo f15196e;

        public c(m.a aVar, ThirdPartyAuthorizationServiceConnection thirdPartyAuthorizationServiceConnection, ResolveInfo resolveInfo, Intent intent) {
            this.f15192a = aVar;
            this.f15194c = thirdPartyAuthorizationServiceConnection;
            this.f15196e = resolveInfo;
            this.f15195d = intent;
        }
    }

    public static boolean a(Context context) throws AuthError {
        if (b.f15190a == null || new Date().getTime() > b.f15191b + DateUtils.MILLIS_PER_DAY) {
            return false;
        }
        c cVar = b.f15190a;
        ServiceInfo serviceInfo = cVar.f15196e.serviceInfo;
        ComponentName componentName = new ComponentName(serviceInfo.applicationInfo.packageName, serviceInfo.name);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        ThirdPartyAuthorizationServiceConnection thirdPartyAuthorizationServiceConnection = new ThirdPartyAuthorizationServiceConnection();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        thirdPartyAuthorizationServiceConnection.setServiceListener(new a(context, cVar, thirdPartyAuthorizationServiceConnection, intent, countDownLatch));
        if (!(Build.VERSION.SDK_INT >= 34 ? context.bindService(intent, thirdPartyAuthorizationServiceConnection, 517) : context.bindService(intent, thirdPartyAuthorizationServiceConnection, 5))) {
            b.a(null);
            intent.getComponent().flattenToString();
            return true;
        }
        try {
            if (countDownLatch.await(10L, TimeUnit.SECONDS)) {
                return true;
            }
            b.a(null);
            throw new AuthError("Binding to authorization service has timed out!", AuthError.ERROR_TYPE.ERROR_THREAD);
        } catch (InterruptedException e2) {
            e2.getMessage();
            b.a(null);
            throw new AuthError("Binding to authorization service has timed out!", e2, AuthError.ERROR_TYPE.ERROR_THREAD);
        }
    }

    public static void clearCachedService(Context context) {
        synchronized (f15184a) {
            try {
                c cVar = b.f15190a;
                if (cVar != null) {
                    safeUnbind(context, cVar.f15194c, cVar.f15195d);
                    b.a(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void safeUnbind(Context context, ServiceConnection serviceConnection, Intent intent) {
        if (intent != null) {
            intent.getComponent().getPackageName();
        }
        if (serviceConnection != null) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public static void unbind(Context context) {
        ThirdPartyAuthorizationServiceConnection thirdPartyAuthorizationServiceConnection;
        synchronized (f15184a) {
            try {
                c cVar = b.f15190a;
                if (cVar != null && (thirdPartyAuthorizationServiceConnection = cVar.f15194c) != null) {
                    safeUnbind(context, thirdPartyAuthorizationServiceConnection, cVar.f15195d);
                    cVar.f15193b = null;
                    cVar.f15194c = null;
                    cVar.f15195d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00eb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.IInterface getAuthorizationServiceInstance(android.content.Context r11, boolean r12) throws com.amazon.identity.auth.device.AuthError, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.authorization.ThirdPartyServiceHelper.getAuthorizationServiceInstance(android.content.Context, boolean):android.os.IInterface");
    }

    public AmazonAuthorizationServiceInterface getRemoteAndroidService(Context context, boolean z) throws AuthError {
        return (AmazonAuthorizationServiceInterface) getAuthorizationServiceInstance(context, z);
    }

    public static boolean a(PackageInfo packageInfo) {
        boolean zEquals = TextUtils.equals(packageInfo.packageName, "com.amazon.identity.auth.device.authorization");
        String.valueOf(zEquals);
        return zEquals;
    }

    public static c a(ArrayList arrayList) {
        int iCompareTo;
        arrayList.size();
        Iterator it = arrayList.iterator();
        c cVar = null;
        while (it.hasNext()) {
            c cVar2 = (c) it.next();
            if (cVar != null) {
                m.a aVar = cVar2.f15192a;
                m.a aVar2 = cVar.f15192a;
                aVar.getClass();
                int[] iArr = aVar.f56131a;
                try {
                    int[] iArr2 = aVar2.f56131a;
                    int iMin = Math.min(iArr.length, iArr2.length) - 1;
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < iMin && iArr[i3] == iArr2[i3]) {
                        i3++;
                    }
                    Integer numValueOf = Integer.valueOf(iArr[i3]);
                    Integer numValueOf2 = Integer.valueOf(iArr2[i3]);
                    if (i3 != iArr.length || iArr.length != aVar2.f56131a.length) {
                        if (iArr2.length != iArr.length && numValueOf.equals(numValueOf2)) {
                            iCompareTo = Integer.valueOf(iArr.length).compareTo(Integer.valueOf(iArr2.length));
                        } else {
                            iCompareTo = numValueOf.compareTo(numValueOf2);
                        }
                        i2 = iCompareTo;
                    }
                    if (i2 > 0) {
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new ArrayIndexOutOfBoundsException("1=" + aVar.toString() + " vs 2=" + aVar2.toString() + StringUtils.SPACE + e2.getMessage());
                }
            }
            cVar = cVar2;
        }
        return cVar;
    }
}
