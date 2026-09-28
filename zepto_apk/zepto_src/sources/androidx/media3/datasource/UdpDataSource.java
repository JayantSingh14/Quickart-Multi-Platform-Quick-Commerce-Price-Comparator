package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

@UnstableApi
/* loaded from: classes3.dex */
public final class UdpDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final int f5937e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f5938f;

    /* renamed from: g, reason: collision with root package name */
    public final DatagramPacket f5939g;

    /* renamed from: h, reason: collision with root package name */
    public Uri f5940h;

    /* renamed from: i, reason: collision with root package name */
    public DatagramSocket f5941i;

    /* renamed from: j, reason: collision with root package name */
    public MulticastSocket f5942j;

    /* renamed from: k, reason: collision with root package name */
    public InetAddress f5943k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5944l;

    /* renamed from: m, reason: collision with root package name */
    public int f5945m;

    public static final class UdpDataSourceException extends DataSourceException {
    }

    public UdpDataSource() {
        super(true);
        this.f5937e = 8000;
        byte[] bArr = new byte[2000];
        this.f5938f = bArr;
        this.f5939g = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() throws IOException {
        this.f5940h = null;
        MulticastSocket multicastSocket = this.f5942j;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.f5943k;
                inetAddress.getClass();
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.f5942j = null;
        }
        DatagramSocket datagramSocket = this.f5941i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f5941i = null;
        }
        this.f5943k = null;
        this.f5945m = 0;
        if (this.f5944l) {
            this.f5944l = false;
            m();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws IOException {
        Uri uri = dataSpec.f5851a;
        this.f5940h = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.f5940h.getPort();
        n(dataSpec);
        try {
            this.f5943k = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f5943k, port);
            if (this.f5943k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f5942j = multicastSocket;
                multicastSocket.joinGroup(this.f5943k);
                this.f5941i = this.f5942j;
            } else {
                this.f5941i = new DatagramSocket(inetSocketAddress);
            }
            this.f5941i.setSoTimeout(this.f5937e);
            this.f5944l = true;
            o(dataSpec);
            return -1L;
        } catch (IOException e2) {
            throw new UdpDataSourceException(2001, e2);
        } catch (SecurityException e3) {
            throw new UdpDataSourceException(2006, e3);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f5940h;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f5945m;
        DatagramPacket datagramPacket = this.f5939g;
        if (i4 == 0) {
            try {
                DatagramSocket datagramSocket = this.f5941i;
                datagramSocket.getClass();
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.f5945m = length;
                l(length);
            } catch (SocketTimeoutException e2) {
                throw new UdpDataSourceException(2002, e2);
            } catch (IOException e3) {
                throw new UdpDataSourceException(2001, e3);
            }
        }
        int length2 = datagramPacket.getLength();
        int i5 = this.f5945m;
        int iMin = Math.min(i5, i3);
        System.arraycopy(this.f5938f, length2 - i5, bArr, i2, iMin);
        this.f5945m -= iMin;
        return iMin;
    }
}
