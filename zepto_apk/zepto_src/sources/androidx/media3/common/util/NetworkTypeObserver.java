package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes.dex */
public final class NetworkTypeObserver {

    /* renamed from: e, reason: collision with root package name */
    public static NetworkTypeObserver f5709e;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f5710a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f5711b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Object f5712c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public int f5713d = 0;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static final class Api31 {

        public static final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a, reason: collision with root package name */
            public final NetworkTypeObserver f5714a;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.f5714a = networkTypeObserver;
            }

            public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                NetworkTypeObserver.a(this.f5714a, overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                telephonyManager.getClass();
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                NetworkTypeObserver.a(networkTypeObserver, 5);
            }
        }
    }

    public interface Listener {
        void a(int i2);
    }

    public final class Receiver extends BroadcastReceiver {
        public Receiver() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onReceive(android.content.Context r7, android.content.Intent r8) {
            /*
                r6 = this;
                java.lang.String r8 = "connectivity"
                java.lang.Object r8 = r7.getSystemService(r8)
                android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8
                r0 = 5
                if (r8 != 0) goto Lc
                goto L4c
            Lc:
                android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L4c
                r1 = 1
                if (r8 == 0) goto L4d
                boolean r2 = r8.isConnected()
                if (r2 != 0) goto L1a
                goto L4d
            L1a:
                int r2 = r8.getType()
                r3 = 9
                r4 = 6
                r5 = 4
                if (r2 == 0) goto L33
                if (r2 == r1) goto L44
                if (r2 == r5) goto L33
                if (r2 == r0) goto L33
                if (r2 == r4) goto L46
                if (r2 == r3) goto L31
                r1 = 8
                goto L4d
            L31:
                r1 = 7
                goto L4d
            L33:
                int r8 = r8.getSubtype()
                switch(r8) {
                    case 1: goto L4a;
                    case 2: goto L4a;
                    case 3: goto L48;
                    case 4: goto L48;
                    case 5: goto L48;
                    case 6: goto L48;
                    case 7: goto L48;
                    case 8: goto L48;
                    case 9: goto L48;
                    case 10: goto L48;
                    case 11: goto L48;
                    case 12: goto L48;
                    case 13: goto L46;
                    case 14: goto L48;
                    case 15: goto L48;
                    case 16: goto L3a;
                    case 17: goto L48;
                    case 18: goto L44;
                    case 19: goto L3a;
                    case 20: goto L3c;
                    default: goto L3a;
                }
            L3a:
                r1 = r4
                goto L4d
            L3c:
                int r8 = androidx.media3.common.util.Util.f5744a
                r1 = 29
                if (r8 < r1) goto L4c
                r1 = r3
                goto L4d
            L44:
                r1 = 2
                goto L4d
            L46:
                r1 = r0
                goto L4d
            L48:
                r1 = r5
                goto L4d
            L4a:
                r1 = 3
                goto L4d
            L4c:
                r1 = 0
            L4d:
                int r8 = androidx.media3.common.util.Util.f5744a
                r2 = 31
                androidx.media3.common.util.NetworkTypeObserver r3 = androidx.media3.common.util.NetworkTypeObserver.this
                if (r8 < r2) goto L5b
                if (r1 != r0) goto L5b
                androidx.media3.common.util.NetworkTypeObserver.Api31.a(r7, r3)
                goto L5e
            L5b:
                androidx.media3.common.util.NetworkTypeObserver.a(r3, r1)
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.NetworkTypeObserver.Receiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new Receiver(), intentFilter);
    }

    public static void a(NetworkTypeObserver networkTypeObserver, int i2) {
        synchronized (networkTypeObserver.f5712c) {
            try {
                if (networkTypeObserver.f5713d == i2) {
                    return;
                }
                networkTypeObserver.f5713d = i2;
                Iterator it = networkTypeObserver.f5711b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    Listener listener = (Listener) weakReference.get();
                    if (listener != null) {
                        listener.a(i2);
                    } else {
                        networkTypeObserver.f5711b.remove(weakReference);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized NetworkTypeObserver b(Context context) {
        try {
            if (f5709e == null) {
                f5709e = new NetworkTypeObserver(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5709e;
    }

    public final int c() {
        int i2;
        synchronized (this.f5712c) {
            i2 = this.f5713d;
        }
        return i2;
    }
}
