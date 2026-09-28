package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
final class zzchh extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f26250a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzchi f26251b;

    public zzchh(zzchi zzchiVar) {
        Objects.requireNonNull(zzchiVar);
        this.f26251b = zzchiVar;
        this.f26250a = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    public final void a(Socket socket) throws SocketException {
        zzchi zzchiVar = this.f26251b;
        int i2 = zzchiVar.r;
        if (i2 > 0) {
            socket.setReceiveBufferSize(i2);
        }
        zzchiVar.s.add(socket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) throws IOException {
        Socket socketCreateSocket = this.f26250a.createSocket(str, i2);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f26250a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f26250a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        Socket socketCreateSocket = this.f26250a.createSocket(str, i2, inetAddress, i3);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.f26250a.createSocket(inetAddress, i2);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        Socket socketCreateSocket = this.f26250a.createSocket(inetAddress, i2, inetAddress2, i3);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        Socket socketCreateSocket = this.f26250a.createSocket(socket, str, i2, z);
        a(socketCreateSocket);
        return socketCreateSocket;
    }
}
