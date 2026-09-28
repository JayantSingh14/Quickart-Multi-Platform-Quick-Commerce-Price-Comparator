package org.xbill.DNS;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base16;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
public class HIPRecord extends Record {
    private byte[] hit;
    private int pkAlgorithm;
    private byte[] publicKey;
    private final List<Name> rvServers;

    public HIPRecord() {
        this.rvServers = new ArrayList();
    }

    private static int mapAlgTypeToDnssec(int i2) throws DNSSEC.UnsupportedAlgorithmException {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 2) {
            return 5;
        }
        throw new DNSSEC.UnsupportedAlgorithmException(i2);
    }

    public int getAlgorithm() {
        return this.pkAlgorithm;
    }

    public byte[] getHit() {
        return this.hit;
    }

    public byte[] getKey() {
        return this.publicKey;
    }

    public PublicKey getPublicKey() throws DNSSEC.DNSSECException {
        return DNSSEC.toPublicKey(mapAlgTypeToDnssec(this.pkAlgorithm), this.publicKey, this);
    }

    public List<Name> getRvServers() {
        return Collections.unmodifiableList(this.rvServers);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.pkAlgorithm = tokenizer.getUInt8();
        this.hit = tokenizer.getHexString();
        this.publicKey = base64.fromString(tokenizer.getString());
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                return;
            } else {
                this.rvServers.add(new Name(token.value()));
            }
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        int u8 = dNSInput.readU8();
        this.pkAlgorithm = dNSInput.readU8();
        int u16 = dNSInput.readU16();
        this.hit = dNSInput.readByteArray(u8);
        this.publicKey = dNSInput.readByteArray(u16);
        while (dNSInput.remaining() > 0) {
            this.rvServers.add(new Name(dNSInput));
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        if (Options.multiline()) {
            sb.append("( ");
        }
        String str = Options.multiline() ? "\n\t" : StringUtils.SPACE;
        sb.append(this.pkAlgorithm);
        sb.append(StringUtils.SPACE);
        sb.append(base16.toString(this.hit));
        sb.append(str);
        sb.append(base64.toString(this.publicKey));
        if (!this.rvServers.isEmpty()) {
            sb.append(str);
        }
        sb.append((String) this.rvServers.stream().map(new i(5)).collect(Collectors.joining(str)));
        if (Options.multiline()) {
            sb.append(" )");
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(final DNSOutput dNSOutput, Compression compression, final boolean z) {
        dNSOutput.writeU8(this.hit.length);
        dNSOutput.writeU8(this.pkAlgorithm);
        dNSOutput.writeU16(this.publicKey.length);
        dNSOutput.writeByteArray(this.hit);
        dNSOutput.writeByteArray(this.publicKey);
        this.rvServers.forEach(new Consumer() { // from class: org.xbill.DNS.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Name) obj).toWire(dNSOutput, null, z);
            }
        });
    }

    public HIPRecord(Name name, int i2, long j2, byte[] bArr, int i3, byte[] bArr2, List<Name> list) {
        super(name, 55, i2, j2);
        ArrayList arrayList = new ArrayList();
        this.rvServers = arrayList;
        this.hit = bArr;
        this.pkAlgorithm = i3;
        this.publicKey = bArr2;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public HIPRecord(Name name, int i2, long j2, byte[] bArr, int i3, byte[] bArr2) {
        this(name, i2, j2, bArr, i3, bArr2, (List<Name>) null);
    }

    public HIPRecord(Name name, int i2, long j2, byte[] bArr, int i3, PublicKey publicKey, List<Name> list) throws DNSSEC.DNSSECException {
        this(name, i2, j2, bArr, i3, DNSSEC.fromPublicKey(publicKey, mapAlgTypeToDnssec(i3)), list);
    }

    public HIPRecord(Name name, int i2, long j2, byte[] bArr, int i3, PublicKey publicKey) throws DNSSEC.DNSSECException {
        this(name, i2, j2, bArr, i3, publicKey, (List<Name>) null);
    }
}
