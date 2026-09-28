package org.apache.commons.lang3.time;

import android.support.v4.media.b;
import j$.time.TimeConversions;
import j$.util.DesugarTimeZone;
import j$.util.TimeZoneRetargetInterface;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes5.dex */
class GmtTimeZone extends TimeZone implements TimeZoneRetargetInterface {
    private static final int HOURS_PER_DAY = 24;
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    public GmtTimeZone(boolean z, int i2, int i3) {
        if (i2 >= 24) {
            throw new IllegalArgumentException(i2 + " hours out of range");
        }
        if (i3 >= 60) {
            throw new IllegalArgumentException(i3 + " minutes out of range");
        }
        int i4 = ((i2 * 60) + i3) * MILLISECONDS_PER_MINUTE;
        this.offset = z ? -i4 : i4;
        StringBuilder sb = new StringBuilder(9);
        sb.append(TimeZones.GMT_ID);
        sb.append(z ? Soundex.SILENT_MARKER : '+');
        StringBuilder sbTwoDigits = twoDigits(sb, i2);
        sbTwoDigits.append(':');
        this.zoneId = twoDigits(sbTwoDigits, i3).toString();
    }

    private static StringBuilder twoDigits(StringBuilder sb, int i2) {
        sb.append((char) ((i2 / 10) + 48));
        sb.append((char) ((i2 % 10) + 48));
        return sb;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GmtTimeZone) && this.zoneId == ((GmtTimeZone) obj).zoneId;
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i2, int i3, int i4, int i5, int i6, int i7) {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[GmtTimeZone id=\"");
        sb.append(this.zoneId);
        sb.append("\",offset=");
        return b.n(sb, this.offset, ']');
    }

    @Override // java.util.TimeZone
    public final /* synthetic */ ZoneId toZoneId() {
        return TimeConversions.convert(toZoneId());
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }

    @Override // java.util.TimeZone, j$.util.TimeZoneRetargetInterface
    public final /* synthetic */ j$.time.ZoneId toZoneId() {
        return DesugarTimeZone.toZoneId(this);
    }
}
