package org.xbill.DNS;

import java.util.function.Supplier;
import org.xbill.DNS.SVCBBase;

/* loaded from: classes5.dex */
public final /* synthetic */ class y implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58069a;

    public /* synthetic */ y(int i2) {
        this.f58069a = i2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f58069a) {
            case 0:
                return new SVCBBase.ParameterMandatory();
            case 1:
                return new SVCBBase.ParameterAlpn();
            case 2:
                return new SVCBBase.ParameterNoDefaultAlpn();
            case 3:
                return new SVCBBase.ParameterPort();
            case 4:
                return new SVCBBase.ParameterIpv4Hint();
            case 5:
                return new SVCBBase.ParameterEch();
            case 6:
                return new SVCBBase.ParameterIpv6Hint();
            case 7:
                return new ARecord();
            case 8:
                return new ISDNRecord();
            case 9:
                return new NSRecord();
            case 10:
                return new RTRecord();
            case 11:
                return new NSAPRecord();
            case 12:
                return new NSAP_PTRRecord();
            case 13:
                return new SIGRecord();
            case 14:
                return new KEYRecord();
            case 15:
                return new PXRecord();
            case 16:
                return new GPOSRecord();
            case 17:
                return new AAAARecord();
            case 18:
                return new WKSRecord();
            case 19:
                return new LOCRecord();
            case 20:
                return new NXTRecord();
            case 21:
                return new MDRecord();
            case 22:
                return new SRVRecord();
            case 23:
                return new NAPTRRecord();
            case 24:
                return new KXRecord();
            case 25:
                return new CERTRecord();
            case 26:
                return new A6Record();
            case 27:
                return new DNAMERecord();
            case 28:
                return new OPTRecord();
            default:
                return new PTRRecord();
        }
    }
}
