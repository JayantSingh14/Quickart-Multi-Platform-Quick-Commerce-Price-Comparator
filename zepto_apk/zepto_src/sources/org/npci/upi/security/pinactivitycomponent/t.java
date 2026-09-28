package org.npci.upi.security.pinactivitycomponent;

/* loaded from: classes5.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private String f57595a;

    /* renamed from: b, reason: collision with root package name */
    private String f57596b;

    /* renamed from: c, reason: collision with root package name */
    private String f57597c;

    public String a() {
        return this.f57595a;
    }

    public String b() {
        return this.f57596b;
    }

    public String c() {
        return this.f57597c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OtpSms{, sms='");
        sb.append(this.f57595a);
        sb.append("', otp='");
        sb.append(this.f57596b);
        sb.append("', id='");
        return android.support.v4.media.b.r(sb, this.f57597c, "'}");
    }

    public void a(String str) {
        this.f57595a = str;
    }

    public void b(String str) {
        this.f57596b = str;
    }

    public void c(String str) {
        this.f57597c = str;
    }
}
