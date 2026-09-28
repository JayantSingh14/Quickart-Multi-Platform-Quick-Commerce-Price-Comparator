package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
public class OPENPGPKEYRecord extends Record {
    private byte[] cert;

    public OPENPGPKEYRecord() {
    }

    public byte[] getCert() {
        return this.cert;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.cert = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.cert = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        if (this.cert != null) {
            if (Options.multiline()) {
                sb.append("(\n");
                sb.append(base64.formatString(this.cert, 64, "\t", true));
            } else {
                sb.append(base64.toString(this.cert));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.cert);
    }

    public OPENPGPKEYRecord(Name name, int i2, long j2, byte[] bArr) {
        super(name, 61, i2, j2);
        this.cert = bArr;
    }
}
