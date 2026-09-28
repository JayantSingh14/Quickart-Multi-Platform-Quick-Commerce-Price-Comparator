package com.google.android.gms.internal.pal;

import java.io.IOException;

/* loaded from: classes4.dex */
public class zzadi extends IOException {
    public static zzadh a() {
        return new zzadh("Protocol message tag had invalid wire type.");
    }

    public static zzadi b() {
        return new zzadi("Protocol message had invalid UTF-8.");
    }

    public static zzadi c() {
        return new zzadi("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzadi d() {
        return new zzadi("Failed to parse the message.");
    }

    public static zzadi e() {
        return new zzadi("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
