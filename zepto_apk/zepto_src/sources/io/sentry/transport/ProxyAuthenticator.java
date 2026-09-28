package io.sentry.transport;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* loaded from: classes3.dex */
final class ProxyAuthenticator extends Authenticator {

    /* renamed from: a, reason: collision with root package name */
    public final String f53100a;

    /* renamed from: b, reason: collision with root package name */
    public final String f53101b;

    public ProxyAuthenticator(String str, String str2) {
        this.f53100a = str;
        this.f53101b = str2;
    }

    @Override // java.net.Authenticator
    public final PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() != Authenticator.RequestorType.PROXY) {
            return null;
        }
        return new PasswordAuthentication(this.f53100a, this.f53101b.toCharArray());
    }
}
