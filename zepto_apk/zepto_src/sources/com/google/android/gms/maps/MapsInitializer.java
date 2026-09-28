package com.google.android.gms.maps;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public final class MapsInitializer {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f38412a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Renderer f38413b = Renderer.f38414a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Renderer {

        /* renamed from: a, reason: collision with root package name */
        public static final Renderer f38414a;

        /* renamed from: b, reason: collision with root package name */
        public static final Renderer f38415b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Renderer[] f38416c;

        static {
            Renderer renderer = new Renderer("LEGACY", 0);
            f38414a = renderer;
            Renderer renderer2 = new Renderer("LATEST", 1);
            f38415b = renderer2;
            f38416c = new Renderer[]{renderer, renderer2};
        }

        @NonNull
        public static Renderer valueOf(@NonNull String str) {
            return (Renderer) Enum.valueOf(Renderer.class, str);
        }

        @NonNull
        public static Renderer[] values() {
            return (Renderer[]) f38416c.clone();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063 A[Catch: all -> 0x0024, RemoteException -> 0x0068, TryCatch #2 {RemoteException -> 0x0068, blocks: (B:26:0x005d, B:28:0x0063, B:31:0x006a), top: B:51:0x005d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x001e, B:13:0x0029, B:14:0x002d, B:19:0x004d, B:21:0x0052, B:26:0x005d, B:28:0x0063, B:31:0x006a, B:34:0x007a, B:36:0x008d, B:33:0x0073, B:17:0x0042, B:40:0x0095, B:41:0x009a, B:43:0x009c), top: B:48:0x0003, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized int a(android.content.Context r5, com.google.android.gms.maps.MapsInitializer.Renderer r6, com.google.common.net.a r7) {
        /*
            java.lang.Class<com.google.android.gms.maps.MapsInitializer> r0 = com.google.android.gms.maps.MapsInitializer.class
            monitor-enter(r0)
            java.lang.String r1 = "Context is null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "MapsInitializer"
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "preferredRenderer: "
            java.lang.String r2 = r3.concat(r2)     // Catch: java.lang.Throwable -> L24
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L24
            boolean r1 = com.google.android.gms.maps.MapsInitializer.f38412a     // Catch: java.lang.Throwable -> L24
            r2 = 0
            if (r1 == 0) goto L29
            if (r7 == 0) goto L27
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = com.google.android.gms.maps.MapsInitializer.f38413b     // Catch: java.lang.Throwable -> L24
            r7.b(r5)     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r5 = move-exception
            goto La0
        L27:
            monitor-exit(r0)
            return r2
        L29:
            com.google.android.gms.maps.internal.zzf r1 = com.google.android.gms.maps.internal.zzcc.a(r5, r6)     // Catch: java.lang.Throwable -> L24 com.google.android.gms.common.GooglePlayServicesNotAvailableException -> L9b
            com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate r3 = r1.zze()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate r3 = (com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate) r3     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            com.google.android.gms.maps.CameraUpdateFactory.f38394a = r3     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            com.google.android.gms.internal.maps.zzi r3 = r1.zzj()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            com.google.android.gms.internal.maps.zzi r4 = com.google.android.gms.maps.model.BitmapDescriptorFactory.f38434a     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            if (r4 == 0) goto L42
            goto L4c
        L42:
            java.lang.String r4 = "delegate must not be null"
            java.lang.Object r3 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3, r4)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            com.google.android.gms.internal.maps.zzi r3 = (com.google.android.gms.internal.maps.zzi) r3     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
            com.google.android.gms.maps.model.BitmapDescriptorFactory.f38434a = r3     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L94
        L4c:
            r3 = 1
            com.google.android.gms.maps.MapsInitializer.f38412a = r3     // Catch: java.lang.Throwable -> L24
            r4 = 2
            if (r6 == 0) goto L5a
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L5d
            if (r6 == r3) goto L5c
        L5a:
            r3 = r2
            goto L5d
        L5c:
            r3 = r4
        L5d:
            int r6 = r1.zzd()     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L68
            if (r6 != r4) goto L6a
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.Renderer.f38415b     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L68
            com.google.android.gms.maps.MapsInitializer.f38413b = r6     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L68
            goto L6a
        L68:
            r5 = move-exception
            goto L73
        L6a:
            com.google.android.gms.dynamic.ObjectWrapper r6 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L68
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L68
            r1.C7(r6, r3)     // Catch: java.lang.Throwable -> L24 android.os.RemoteException -> L68
            goto L7a
        L73:
            java.lang.String r6 = "MapsInitializer"
            java.lang.String r1 = "Failed to retrieve renderer type or log initialization."
            android.util.Log.e(r6, r1, r5)     // Catch: java.lang.Throwable -> L24
        L7a:
            java.lang.String r5 = "MapsInitializer"
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.f38413b     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "loadedRenderer: "
            java.lang.String r6 = r1.concat(r6)     // Catch: java.lang.Throwable -> L24
            android.util.Log.d(r5, r6)     // Catch: java.lang.Throwable -> L24
            if (r7 == 0) goto L92
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = com.google.android.gms.maps.MapsInitializer.f38413b     // Catch: java.lang.Throwable -> L24
            r7.b(r5)     // Catch: java.lang.Throwable -> L24
        L92:
            monitor-exit(r0)
            return r2
        L94:
            r5 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r6 = new com.google.android.gms.maps.model.RuntimeRemoteException     // Catch: java.lang.Throwable -> L24
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L24
            throw r6     // Catch: java.lang.Throwable -> L24
        L9b:
            r5 = move-exception
            int r5 = r5.errorCode     // Catch: java.lang.Throwable -> L24
            monitor-exit(r0)
            return r5
        La0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapsInitializer.a(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer, com.google.common.net.a):int");
    }

    public static synchronized void b(Context context) {
        a(context, null, null);
    }
}
