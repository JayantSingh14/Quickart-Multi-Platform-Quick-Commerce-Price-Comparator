package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class GPOSRecord extends Record {
    private byte[] altitude;
    private byte[] latitude;
    private byte[] longitude;

    public GPOSRecord() {
    }

    private void validate(double d2, double d3) throws IllegalArgumentException {
        if (d2 < -90.0d || d2 > 90.0d) {
            throw new IllegalArgumentException("illegal longitude " + d2);
        }
        if (d3 < -180.0d || d3 > 180.0d) {
            throw new IllegalArgumentException("illegal latitude " + d3);
        }
    }

    public double getAltitude() {
        return Double.parseDouble(getAltitudeString());
    }

    public String getAltitudeString() {
        return Record.byteArrayToString(this.altitude, false);
    }

    public double getLatitude() {
        return Double.parseDouble(getLatitudeString());
    }

    public String getLatitudeString() {
        return Record.byteArrayToString(this.latitude, false);
    }

    public double getLongitude() {
        return Double.parseDouble(getLongitudeString());
    }

    public String getLongitudeString() {
        return Record.byteArrayToString(this.longitude, false);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        try {
            this.longitude = Record.byteArrayFromString(tokenizer.getString());
            this.latitude = Record.byteArrayFromString(tokenizer.getString());
            this.altitude = Record.byteArrayFromString(tokenizer.getString());
            try {
                validate(getLongitude(), getLatitude());
            } catch (IllegalArgumentException e2) {
                throw new WireParseException(e2.getMessage());
            }
        } catch (TextParseException e3) {
            throw tokenizer.exception(e3.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.longitude = dNSInput.readCountedString();
        this.latitude = dNSInput.readCountedString();
        this.altitude = dNSInput.readCountedString();
        try {
            validate(getLongitude(), getLatitude());
        } catch (IllegalArgumentException e2) {
            throw new WireParseException(e2.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return Record.byteArrayToString(this.longitude, true) + StringUtils.SPACE + Record.byteArrayToString(this.latitude, true) + StringUtils.SPACE + Record.byteArrayToString(this.altitude, true);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.longitude);
        dNSOutput.writeCountedString(this.latitude);
        dNSOutput.writeCountedString(this.altitude);
    }

    public GPOSRecord(Name name, int i2, long j2, double d2, double d3, double d4) throws IllegalArgumentException {
        super(name, 27, i2, j2);
        validate(d2, d3);
        this.longitude = Double.toString(d2).getBytes();
        this.latitude = Double.toString(d3).getBytes();
        this.altitude = Double.toString(d4).getBytes();
    }

    public GPOSRecord(Name name, int i2, long j2, String str, String str2, String str3) throws IllegalArgumentException {
        super(name, 27, i2, j2);
        try {
            this.longitude = Record.byteArrayFromString(str);
            this.latitude = Record.byteArrayFromString(str2);
            validate(getLongitude(), getLatitude());
            this.altitude = Record.byteArrayFromString(str3);
        } catch (TextParseException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }
}
