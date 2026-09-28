package org.xbill.DNS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/* loaded from: classes5.dex */
public class DnssecAlgorithmOption extends EDNSOption {
    private final List<Integer> algCodes;

    private DnssecAlgorithmOption(int i2) {
        super(i2);
        if (i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException("Invalid option code, must be one of DAU, DHU, N3U");
        }
        this.algCodes = new ArrayList();
    }

    public List<Integer> getAlgorithms() {
        return Collections.unmodifiableList(this.algCodes);
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionFromWire(DNSInput dNSInput) throws IOException {
        this.algCodes.clear();
        while (dNSInput.remaining() > 0) {
            this.algCodes.add(Integer.valueOf(dNSInput.readU8()));
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    public String optionToString() {
        i iVar;
        int code = getCode();
        if (code == 5) {
            iVar = new i(1);
        } else if (code == 6) {
            iVar = new i(2);
        } else {
            if (code != 7) {
                throw new IllegalStateException("Unknown option code");
            }
            iVar = new i(3);
        }
        return android.support.v4.media.b.r(new StringBuilder("["), (String) this.algCodes.stream().map(iVar).collect(Collectors.joining(", ")), "]");
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionToWire(DNSOutput dNSOutput) {
        List<Integer> list = this.algCodes;
        Objects.requireNonNull(dNSOutput);
        list.forEach(new x(dNSOutput, 1));
    }

    public DnssecAlgorithmOption(int i2, List<Integer> list) {
        this(i2);
        this.algCodes.addAll(list);
    }

    public DnssecAlgorithmOption(int i2, int... iArr) {
        this(i2);
        if (iArr != null) {
            for (int i3 : iArr) {
                this.algCodes.add(Integer.valueOf(i3));
            }
        }
    }
}
