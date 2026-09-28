package j$.time;

import j$.time.zone.ZoneRules;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class v extends ZoneId {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f53459d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b, reason: collision with root package name */
    public final String f53460b;

    /* renamed from: c, reason: collision with root package name */
    public final transient ZoneRules f53461c;

    public static v Z(String str, boolean z) {
        ZoneRules zoneRulesA;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i2 == 0) && ((cCharAt < '0' || cCharAt > '9' || i2 == 0) && ((cCharAt != '~' || i2 == 0) && ((cCharAt != '.' || i2 == 0) && ((cCharAt != '_' || i2 == 0) && ((cCharAt != '+' || i2 == 0) && (cCharAt != '-' || i2 == 0))))))))) {
                    throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                zoneRulesA = j$.time.zone.h.a(str);
            } catch (j$.time.zone.f e2) {
                if (z) {
                    throw e2;
                }
                zoneRulesA = null;
            }
            return new v(str, zoneRulesA);
        }
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public v(String str, ZoneRules zoneRules) {
        this.f53460b = str;
        this.f53461c = zoneRules;
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f53460b;
    }

    @Override // j$.time.ZoneId
    public final ZoneRules getRules() {
        ZoneRules zoneRules = this.f53461c;
        return zoneRules != null ? zoneRules : j$.time.zone.h.a(this.f53460b);
    }

    private Object writeReplace() {
        return new q((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void X(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(7);
        objectOutput.writeUTF(this.f53460b);
    }
}
