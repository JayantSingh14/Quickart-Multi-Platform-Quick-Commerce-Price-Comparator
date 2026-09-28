package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@KeepForSdk
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class AdvertisingIdClient {

    /* renamed from: a, reason: collision with root package name */
    public BlockingServiceConnection f21063a;

    /* renamed from: b, reason: collision with root package name */
    public zzf f21064b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21065c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f21066d;

    /* renamed from: e, reason: collision with root package name */
    public zzb f21067e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f21068f;

    /* renamed from: g, reason: collision with root package name */
    public final long f21069g;

    @KeepForSdkWithMembers
    /* loaded from: classes4.dex */
    public static final class Info {

        /* renamed from: a, reason: collision with root package name */
        public final String f21070a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f21071b;

        public Info(String str, boolean z) {
            this.f21070a = str;
            this.f21071b = z;
        }

        public final String a() {
            return this.f21070a;
        }

        public final boolean b() {
            return this.f21071b;
        }

        public final String toString() {
            String str = this.f21070a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(this.f21071b);
            return sb.toString();
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false);
    }

    public static Info a(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, true);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.d(false);
            Info infoF = advertisingIdClient.f();
            e(infoF, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return infoF;
        } finally {
        }
    }

    public static boolean b(Context context) {
        boolean zZzd;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false);
        try {
            advertisingIdClient.d(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                try {
                    if (!advertisingIdClient.f21065c) {
                        synchronized (advertisingIdClient.f21066d) {
                            zzb zzbVar = advertisingIdClient.f21067e;
                            if (zzbVar == null || !zzbVar.f21076d) {
                                throw new IOException("AdvertisingIdClient is not connected.");
                            }
                        }
                        try {
                            advertisingIdClient.d(false);
                            if (!advertisingIdClient.f21065c) {
                                throw new IOException("AdvertisingIdClient cannot reconnect.");
                            }
                        } catch (Exception e2) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                        }
                    }
                    Preconditions.checkNotNull(advertisingIdClient.f21063a);
                    Preconditions.checkNotNull(advertisingIdClient.f21064b);
                    try {
                        zZzd = advertisingIdClient.f21064b.zzd();
                    } catch (RemoteException e3) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                        throw new IOException("Remote exception");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            advertisingIdClient.g();
            return zZzd;
        } finally {
            advertisingIdClient.c();
        }
    }

    public static void e(Info info, long j2, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (info != null) {
                map.put("limit_ad_tracking", true != info.b() ? "0" : "1");
                String strA = info.a();
                if (strA != null) {
                    map.put("ad_id_size", Integer.toString(strA.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j2));
            new zza(map).start();
        }
    }

    public final void c() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f21068f == null || this.f21063a == null) {
                    return;
                }
                try {
                    if (this.f21065c) {
                        ConnectionTracker.getInstance().unbindService(this.f21068f, this.f21063a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f21065c = false;
                this.f21064b = null;
                this.f21063a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(boolean z) {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f21065c) {
                    c();
                }
                Context context = this.f21068f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
                    if (iIsGooglePlayServicesAvailable != 0 && iIsGooglePlayServicesAvailable != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f21063a = blockingServiceConnection;
                        try {
                            this.f21064b = zze.g(blockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
                            this.f21065c = true;
                            if (z) {
                                g();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new GooglePlayServicesNotAvailableException(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Info f() {
        Info info;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f21065c) {
                    synchronized (this.f21066d) {
                        zzb zzbVar = this.f21067e;
                        if (zzbVar == null || !zzbVar.f21076d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f21065c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e2) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                    }
                }
                Preconditions.checkNotNull(this.f21063a);
                Preconditions.checkNotNull(this.f21064b);
                try {
                    info = new Info(this.f21064b.zzc(), this.f21064b.zze());
                } catch (RemoteException e3) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return info;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f21066d) {
            zzb zzbVar = this.f21067e;
            if (zzbVar != null) {
                zzbVar.f21075c.countDown();
                try {
                    this.f21067e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j2 = this.f21069g;
            if (j2 > 0) {
                this.f21067e = new zzb(this, j2);
            }
        }
    }

    public AdvertisingIdClient(Context context, long j2, boolean z) {
        Context applicationContext;
        this.f21066d = new Object();
        Preconditions.checkNotNull(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f21068f = context;
        this.f21065c = false;
        this.f21069g = j2;
    }
}
