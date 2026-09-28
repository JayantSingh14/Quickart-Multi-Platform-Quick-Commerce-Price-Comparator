package org.xbill.DNS.tools;

import java.net.InetAddress;

/* loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58055a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ jnamed f58056b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InetAddress f58057c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f58058d;

    public /* synthetic */ a(jnamed jnamedVar, InetAddress inetAddress, int i2, int i3) {
        this.f58055a = i3;
        this.f58056b = jnamedVar;
        this.f58057c = inetAddress;
        this.f58058d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f58055a) {
            case 0:
                this.f58056b.lambda$addTCP$1(this.f58057c, this.f58058d);
                break;
            default:
                this.f58056b.lambda$addUDP$2(this.f58057c, this.f58058d);
                break;
        }
    }
}
