package org.xbill.DNS;

import j$.time.Duration;
import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

/* loaded from: classes5.dex */
public class TcpKeepaliveOption extends EDNSOption {
    private static final Duration UPPER_LIMIT = Duration.ofMillis(6553600);
    private Integer timeout;

    public TcpKeepaliveOption() {
        super(11);
        this.timeout = null;
    }

    public OptionalInt getTimeout() {
        Integer num = this.timeout;
        return num == null ? OptionalInt.empty() : OptionalInt.of(num.intValue());
    }

    public Optional<Duration> getTimeoutDuration() {
        return this.timeout != null ? Optional.of(Duration.ofMillis(r0.intValue() * 100)) : Optional.empty();
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionFromWire(DNSInput dNSInput) throws IOException {
        int iRemaining = dNSInput.remaining();
        if (iRemaining == 0) {
            this.timeout = null;
        } else {
            if (iRemaining != 2) {
                throw new WireParseException(android.support.v4.media.b.g(iRemaining, "invalid length (", ") of the data in the edns_tcp_keepalive option"));
            }
            this.timeout = Integer.valueOf(dNSInput.readU16());
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    public String optionToString() {
        Integer num = this.timeout;
        return num != null ? String.valueOf(num) : "-";
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionToWire(DNSOutput dNSOutput) {
        Integer num = this.timeout;
        if (num != null) {
            dNSOutput.writeU16(num.intValue());
        }
    }

    public TcpKeepaliveOption(int i2) {
        super(11);
        if (i2 >= 0 && i2 <= 65535) {
            this.timeout = Integer.valueOf(i2);
            return;
        }
        throw new IllegalArgumentException("timeout must be betwee 0 and 65535");
    }

    public TcpKeepaliveOption(Duration duration) {
        super(11);
        if (!duration.isNegative() && duration.compareTo(UPPER_LIMIT) < 0) {
            this.timeout = Integer.valueOf(((int) duration.toMillis()) / 100);
            return;
        }
        throw new IllegalArgumentException("timeout must be between 0 and 6553.6 seconds (exclusively)");
    }
}
