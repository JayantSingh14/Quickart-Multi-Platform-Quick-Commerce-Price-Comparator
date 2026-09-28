package ch.qos.logback.core.net.ssl;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class SSLParametersConfiguration extends ContextAwareBase {

    /* renamed from: d, reason: collision with root package name */
    public String[] f13645d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f13646e;

    public final void T1(SSLConfigurable sSLConfigurable) {
        sSLConfigurable.a();
        String[] strArrF = sSLConfigurable.f();
        if (this.f13645d == null) {
            String[] strArr = (String[]) Arrays.copyOf(strArrF, strArrF.length);
            this.f13645d = strArr;
            for (String str : strArr) {
                s1("enabled protocol: " + str);
            }
        }
        sSLConfigurable.b(this.f13645d);
        sSLConfigurable.c();
        String[] strArrD = sSLConfigurable.d();
        if (this.f13646e == null) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArrD, strArrD.length);
            this.f13646e = strArr2;
            for (String str2 : strArr2) {
                s1("enabled cipher suite: " + str2);
            }
        }
        sSLConfigurable.e(this.f13646e);
    }
}
