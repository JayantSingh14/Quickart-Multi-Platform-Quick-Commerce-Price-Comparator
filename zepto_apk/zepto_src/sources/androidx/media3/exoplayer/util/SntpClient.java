package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class SntpClient {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8214a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8215b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8216c;

    /* renamed from: d, reason: collision with root package name */
    public static long f8217d;

    public interface InitializationCallback {
        void a(IOException iOException);

        void b();
    }

    public static final class NtpTimeCallback implements Loader.Callback<Loader.Loadable> {

        /* renamed from: a, reason: collision with root package name */
        public final InitializationCallback f8218a;

        public NtpTimeCallback(InitializationCallback initializationCallback) {
            this.f8218a = initializationCallback;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void a0(Loader.Loadable loadable, long j2, long j3) {
            boolean z;
            InitializationCallback initializationCallback = this.f8218a;
            synchronized (SntpClient.f8215b) {
                z = SntpClient.f8216c;
            }
            if (z) {
                initializationCallback.b();
            } else {
                initializationCallback.a(new IOException(new ConcurrentModificationException()));
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final void d0(Loader.Loadable loadable, long j2, long j3, boolean z) {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public final Loader.LoadErrorAction k(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            InitializationCallback initializationCallback = this.f8218a;
            if (initializationCallback != null) {
                initializationCallback.a(iOException);
            }
            return Loader.f8165e;
        }
    }

    public static final class NtpTimeLoadable implements Loader.Loadable {
        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void a() {
            synchronized (SntpClient.f8214a) {
                Object obj = SntpClient.f8215b;
                synchronized (obj) {
                    if (SntpClient.f8216c) {
                        return;
                    }
                    long jA = SntpClient.a();
                    synchronized (obj) {
                        SntpClient.f8217d = jA;
                        SntpClient.f8216c = true;
                    }
                }
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
        public final void b() {
        }
    }

    public static long a() throws UnknownHostException {
        char c2;
        long j2;
        synchronized (f8215b) {
        }
        InetAddress byName = InetAddress.getByName("time.android.com");
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, WKSRecord.Service.NTP);
            bArr[0] = 27;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jCurrentTimeMillis == 0) {
                Arrays.fill(bArr, 40, 48, (byte) 0);
                c2 = 0;
                j2 = jCurrentTimeMillis;
            } else {
                long j3 = jCurrentTimeMillis / 1000;
                long j4 = jCurrentTimeMillis - (j3 * 1000);
                c2 = 0;
                j2 = jCurrentTimeMillis;
                bArr[40] = (byte) (r14 >> 24);
                bArr[41] = (byte) (r14 >> 16);
                bArr[42] = (byte) (r14 >> 8);
                bArr[43] = (byte) (j3 + 2208988800L);
                long j5 = (j4 * 4294967296L) / 1000;
                bArr[44] = (byte) (j5 >> 24);
                bArr[45] = (byte) (j5 >> 16);
                bArr[46] = (byte) (j5 >> 8);
                bArr[47] = (byte) (Math.random() * 255.0d);
            }
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j6 = (jElapsedRealtime2 - jElapsedRealtime) + j2;
            byte b2 = bArr[c2];
            int i2 = bArr[1] & 255;
            long jE = e(24, bArr);
            long jE2 = e(32, bArr);
            long jE3 = e(40, bArr);
            b((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), i2, jE3);
            long j7 = (j6 + (((jE3 - j6) + (jE2 - jE)) / 2)) - jElapsedRealtime2;
            datagramSocket.close();
            return j7;
        } finally {
        }
    }

    public static void b(byte b2, byte b3, int i2, long j2) throws IOException {
        if (b2 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b3 != 4 && b3 != 5) {
            throw new IOException(b.f(b3, "SNTP: Untrusted mode: "));
        }
        if (i2 == 0 || i2 > 15) {
            throw new IOException(b.f(i2, "SNTP: Untrusted stratum: "));
        }
        if (j2 == 0) {
            throw new IOException("SNTP: Zero transmitTime");
        }
    }

    public static void c(Loader loader, InitializationCallback initializationCallback) {
        boolean z;
        synchronized (f8215b) {
            z = f8216c;
        }
        if (z) {
            initializationCallback.b();
            return;
        }
        if (loader == null) {
            loader = new Loader("SntpClient");
        }
        loader.g(new NtpTimeLoadable(), new NtpTimeCallback(initializationCallback), 1);
    }

    public static long d(int i2, byte[] bArr) {
        int i3 = bArr[i2];
        int i4 = bArr[i2 + 1];
        int i5 = bArr[i2 + 2];
        int i6 = bArr[i2 + 3];
        if ((i3 & 128) == 128) {
            i3 = (i3 & WKSRecord.Service.LOCUS_CON) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & WKSRecord.Service.LOCUS_CON) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & WKSRecord.Service.LOCUS_CON) + 128;
        }
        if ((i6 & 128) == 128) {
            i6 = (i6 & WKSRecord.Service.LOCUS_CON) + 128;
        }
        return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
    }

    public static long e(int i2, byte[] bArr) {
        long jD = d(i2, bArr);
        long jD2 = d(i2 + 4, bArr);
        if (jD == 0 && jD2 == 0) {
            return 0L;
        }
        return ((jD2 * 1000) / 4294967296L) + ((jD - 2208988800L) * 1000);
    }
}
