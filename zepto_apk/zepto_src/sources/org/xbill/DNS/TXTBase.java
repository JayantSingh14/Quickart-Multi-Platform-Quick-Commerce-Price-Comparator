package org.xbill.DNS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes5.dex */
abstract class TXTBase extends Record {
    protected List<byte[]> strings;

    public TXTBase() {
    }

    public List<String> getStrings() {
        ArrayList arrayList = new ArrayList(this.strings.size());
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            arrayList.add(Record.byteArrayToString(it.next(), false));
        }
        return arrayList;
    }

    public List<byte[]> getStringsAsByteArrays() {
        return this.strings;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.strings = new ArrayList(2);
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            } else {
                try {
                    this.strings.add(Record.byteArrayFromString(token.value()));
                } catch (TextParseException e2) {
                    throw tokenizer.exception(e2.getMessage());
                }
            }
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.strings = new ArrayList(2);
        while (dNSInput.remaining() > 0) {
            this.strings.add(dNSInput.readCountedString());
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        if (this.strings.isEmpty()) {
            return "\"\"";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            sb.append(Record.byteArrayToString(it.next(), true));
            if (it.hasNext()) {
                sb.append(StringUtils.SPACE);
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        Iterator<byte[]> it = this.strings.iterator();
        while (it.hasNext()) {
            dNSOutput.writeCountedString(it.next());
        }
    }

    public TXTBase(Name name, int i2, int i3, long j2) {
        super(name, i2, i3, j2);
    }

    public TXTBase(Name name, int i2, int i3, long j2, List<String> list) {
        super(name, i2, i3, j2);
        if (list != null) {
            this.strings = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.strings.add(Record.byteArrayFromString(it.next()));
                } catch (TextParseException e2) {
                    throw new IllegalArgumentException(e2.getMessage());
                }
            }
            return;
        }
        throw new IllegalArgumentException("strings must not be null");
    }

    public TXTBase(Name name, int i2, int i3, long j2, String str) {
        this(name, i2, i3, j2, (List<String>) Collections.singletonList(str));
    }
}
