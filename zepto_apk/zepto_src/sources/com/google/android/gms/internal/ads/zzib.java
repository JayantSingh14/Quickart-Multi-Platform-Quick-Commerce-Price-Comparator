package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: classes4.dex */
public final class zzib extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f34652e;

    /* renamed from: f, reason: collision with root package name */
    public final DatagramPacket f34653f;

    /* renamed from: g, reason: collision with root package name */
    public Uri f34654g;

    /* renamed from: h, reason: collision with root package name */
    public DatagramSocket f34655h;

    /* renamed from: i, reason: collision with root package name */
    public MulticastSocket f34656i;

    /* renamed from: j, reason: collision with root package name */
    public InetAddress f34657j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f34658k;

    /* renamed from: l, reason: collision with root package name */
    public int f34659l;

    public zzib() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws IOException {
        Uri uri = zzhfVar.f33691a;
        this.f34654g = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.f34654g.getPort();
        d(zzhfVar);
        try {
            this.f34657j = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f34657j, port);
            if (this.f34657j.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f34656i = multicastSocket;
                multicastSocket.joinGroup(this.f34657j);
                this.f34655h = this.f34656i;
            } else {
                this.f34655h = new DatagramSocket(inetSocketAddress);
            }
            this.f34655h.setSoTimeout(8000);
            this.f34658k = true;
            e(zzhfVar);
            return -1L;
        } catch (IOException e2) {
            throw new zzia(2001, e2);
        } catch (SecurityException e3) {
            throw new zzia(2006, e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f34659l;
        DatagramPacket datagramPacket = this.f34653f;
        if (i4 == 0) {
            try {
                DatagramSocket datagramSocket = this.f34655h;
                if (datagramSocket == null) {
                    throw null;
                }
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.f34659l = length;
                f(length);
            } catch (SocketTimeoutException e2) {
                throw new zzia(2002, e2);
            } catch (IOException e3) {
                throw new zzia(2001, e3);
            }
        }
        int length2 = datagramPacket.getLength();
        int i5 = this.f34659l;
        int iMin = Math.min(i5, i3);
        System.arraycopy(this.f34652e, length2 - i5, bArr, i2, iMin);
        this.f34659l -= iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f34654g;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() throws IOException {
        InetAddress inetAddress;
        this.f34654g = null;
        MulticastSocket multicastSocket = this.f34656i;
        if (multicastSocket != null) {
            try {
                inetAddress = this.f34657j;
            } catch (IOException unused) {
            }
            if (inetAddress == null) {
                throw null;
            }
            multicastSocket.leaveGroup(inetAddress);
            this.f34656i = null;
        }
        DatagramSocket datagramSocket = this.f34655h;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f34655h = null;
        }
        this.f34657j = null;
        this.f34659l = 0;
        if (this.f34658k) {
            this.f34658k = false;
            g();
        }
    }

    public zzib(int i2) {
        super(true);
        byte[] bArr = new byte[2000];
        this.f34652e = bArr;
        this.f34653f = new DatagramPacket(bArr, 0, 2000);
    }
}
