package org.xbill.DNS;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes5.dex */
public class LOCRecord extends Record {
    private static final NumberFormat w2;
    private static final NumberFormat w3;
    private long altitude;
    private long hPrecision;
    private long latitude;
    private long longitude;
    private long size;
    private long vPrecision;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        w2 = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        w3 = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(3);
    }

    public LOCRecord() {
    }

    private long parseDouble(Tokenizer tokenizer, String str, boolean z, long j2, long j3, long j4) throws IOException {
        Tokenizer.Token token = tokenizer.get();
        if (token.isEOL()) {
            if (!z) {
                tokenizer.unget();
                return j4;
            }
            throw tokenizer.exception("Invalid LOC " + str);
        }
        String strValue = token.value();
        if (strValue.length() > 1 && strValue.charAt(strValue.length() - 1) == 'm') {
            strValue = android.support.v4.media.a.k(1, 0, strValue);
        }
        try {
            long fixedPoint = (long) (parseFixedPoint(strValue) * 100.0d);
            if (fixedPoint >= j2 && fixedPoint <= j3) {
                return fixedPoint;
            }
            throw tokenizer.exception("Invalid LOC " + str);
        } catch (NumberFormatException unused) {
            throw tokenizer.exception("Invalid LOC " + str);
        }
    }

    private double parseFixedPoint(String str) {
        if (str.matches("^-?\\d+$")) {
            return Integer.parseInt(str);
        }
        if (!str.matches("^-?\\d+\\.\\d*$")) {
            throw new NumberFormatException();
        }
        String[] strArrSplit = str.split("\\.");
        double d2 = Integer.parseInt(strArrSplit[0]);
        double d3 = Integer.parseInt(strArrSplit[1]);
        if (d2 < 0.0d) {
            d3 *= -1.0d;
        }
        return (d3 / Math.pow(10.0d, strArrSplit[1].length())) + d2;
    }

    private static long parseLOCformat(int i2) throws WireParseException {
        long j2 = i2 >> 4;
        int i3 = i2 & 15;
        if (j2 > 9 || i3 > 9) {
            throw new WireParseException("Invalid LOC Encoding");
        }
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                return j2;
            }
            j2 *= 10;
            i3 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long parsePosition(org.xbill.DNS.Tokenizer r18, java.lang.String r19) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.LOCRecord.parsePosition(org.xbill.DNS.Tokenizer, java.lang.String):long");
    }

    private String positionToString(long j2, char c2, char c3) {
        StringBuilder sb = new StringBuilder();
        long j3 = j2 - 2147483648L;
        if (j3 < 0) {
            j3 = -j3;
            c2 = c3;
        }
        sb.append(j3 / DateUtils.MILLIS_PER_HOUR);
        long j4 = j3 % DateUtils.MILLIS_PER_HOUR;
        sb.append(StringUtils.SPACE);
        sb.append(j4 / DateUtils.MILLIS_PER_MINUTE);
        long j5 = j4 % DateUtils.MILLIS_PER_MINUTE;
        sb.append(StringUtils.SPACE);
        renderFixedPoint(sb, w3, j5, 1000L);
        return androidx.fragment.app.e.t(sb, StringUtils.SPACE, c2);
    }

    private void renderFixedPoint(StringBuilder sb, NumberFormat numberFormat, long j2, long j3) {
        sb.append(j2 / j3);
        long j4 = j2 % j3;
        if (j4 != 0) {
            sb.append(CLConstants.DOT_SALT_DELIMETER);
            sb.append(numberFormat.format(j4));
        }
    }

    private int toLOCformat(long j2) {
        byte b2 = 0;
        while (j2 > 9) {
            b2 = (byte) (b2 + 1);
            j2 /= 10;
        }
        return (int) ((j2 << 4) + (b2 & 255));
    }

    public double getAltitude() {
        return (this.altitude - 10000000) / 100.0d;
    }

    public double getHPrecision() {
        return this.hPrecision / 100.0d;
    }

    public double getLatitude() {
        return (this.latitude - 2147483648L) / 3600000.0d;
    }

    public double getLongitude() {
        return (this.longitude - 2147483648L) / 3600000.0d;
    }

    public double getSize() {
        return this.size / 100.0d;
    }

    public double getVPrecision() {
        return this.vPrecision / 100.0d;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.latitude = parsePosition(tokenizer, "latitude");
        this.longitude = parsePosition(tokenizer, "longitude");
        this.altitude = parseDouble(tokenizer, "altitude", true, -10000000L, 4284967295L, 0L) + 10000000;
        this.size = parseDouble(tokenizer, "size", false, 0L, 9000000000L, 100L);
        this.hPrecision = parseDouble(tokenizer, "horizontal precision", false, 0L, 9000000000L, 1000000L);
        this.vPrecision = parseDouble(tokenizer, "vertical precision", false, 0L, 9000000000L, 1000L);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        if (dNSInput.readU8() != 0) {
            throw new WireParseException("Invalid LOC version");
        }
        this.size = parseLOCformat(dNSInput.readU8());
        this.hPrecision = parseLOCformat(dNSInput.readU8());
        this.vPrecision = parseLOCformat(dNSInput.readU8());
        this.latitude = dNSInput.readU32();
        this.longitude = dNSInput.readU32();
        this.altitude = dNSInput.readU32();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(positionToString(this.latitude, 'N', 'S'));
        sb.append(StringUtils.SPACE);
        sb.append(positionToString(this.longitude, 'E', 'W'));
        sb.append(StringUtils.SPACE);
        NumberFormat numberFormat = w2;
        renderFixedPoint(sb, numberFormat, this.altitude - 10000000, 100L);
        sb.append("m ");
        renderFixedPoint(sb, numberFormat, this.size, 100L);
        sb.append("m ");
        renderFixedPoint(sb, numberFormat, this.hPrecision, 100L);
        sb.append("m ");
        renderFixedPoint(sb, numberFormat, this.vPrecision, 100L);
        sb.append("m");
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(0);
        dNSOutput.writeU8(toLOCformat(this.size));
        dNSOutput.writeU8(toLOCformat(this.hPrecision));
        dNSOutput.writeU8(toLOCformat(this.vPrecision));
        dNSOutput.writeU32(this.latitude);
        dNSOutput.writeU32(this.longitude);
        dNSOutput.writeU32(this.altitude);
    }

    public LOCRecord(Name name, int i2, long j2, double d2, double d3, double d4, double d5, double d6, double d7) {
        super(name, 29, i2, j2);
        this.latitude = (long) android.support.v4.media.b.a(d2, 3600.0d, 1000.0d, 2.147483648E9d);
        this.longitude = (long) android.support.v4.media.b.a(d3, 3600.0d, 1000.0d, 2.147483648E9d);
        this.altitude = (long) ((d4 + 100000.0d) * 100.0d);
        this.size = (long) (d5 * 100.0d);
        this.hPrecision = (long) (d6 * 100.0d);
        this.vPrecision = (long) (d7 * 100.0d);
    }
}
