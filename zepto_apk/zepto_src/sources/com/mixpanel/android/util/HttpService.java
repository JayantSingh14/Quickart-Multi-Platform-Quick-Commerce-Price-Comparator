package com.mixpanel.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class HttpService implements RemoteService {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f46095a;

    /* renamed from: com.mixpanel.android.util.HttpService$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() throws UnknownHostException {
            try {
                InetAddress byName = InetAddress.getByName("api.mixpanel.com");
                InetAddress byName2 = InetAddress.getByName("decide.mixpanel.com");
                boolean z = byName.isLoopbackAddress() || byName.isAnyLocalAddress() || byName2.isLoopbackAddress() || byName2.isAnyLocalAddress();
                HttpService.f46095a = z;
                if (z) {
                    MPLog.e("MixpanelAPI.Message", "AdBlocker is enabled. Won't be able to use Mixpanel services.");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
        while (true) {
            int i2 = inputStream.read(bArr, 0, KEYRecord.Flags.FLAG2);
            if (i2 == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public final void a() {
        new Thread(new AnonymousClass1()).start();
    }

    public final boolean b(Context context) {
        if (f46095a) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                MPLog.e("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
                return true;
            }
            boolean zIsConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
            StringBuilder sb = new StringBuilder("ConnectivityManager says we ");
            sb.append(zIsConnectedOrConnecting ? "are" : "are not");
            sb.append(" online");
            MPLog.e("MixpanelAPI.Message", sb.toString());
            return zIsConnectedOrConnecting;
        } catch (SecurityException unused) {
            MPLog.e("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x012b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[Catch: all -> 0x0034, IOException -> 0x0039, EOFException -> 0x0040, TryCatch #18 {EOFException -> 0x0040, IOException -> 0x0039, all -> 0x0034, blocks: (B:8:0x0029, B:10:0x002d, B:21:0x0045, B:23:0x0052, B:24:0x005f, B:26:0x0065, B:27:0x007d, B:43:0x00c8), top: B:111:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[Catch: all -> 0x0034, IOException -> 0x0039, EOFException -> 0x0040, TRY_ENTER, TRY_LEAVE, TryCatch #18 {EOFException -> 0x0040, IOException -> 0x0039, all -> 0x0034, blocks: (B:8:0x0029, B:10:0x002d, B:21:0x0045, B:23:0x0052, B:24:0x005f, B:26:0x0065, B:27:0x007d, B:43:0x00c8), top: B:111:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] c(java.lang.String r12, java.util.HashMap r13, javax.net.ssl.SSLSocketFactory r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.HttpService.c(java.lang.String, java.util.HashMap, javax.net.ssl.SSLSocketFactory):byte[]");
    }
}
