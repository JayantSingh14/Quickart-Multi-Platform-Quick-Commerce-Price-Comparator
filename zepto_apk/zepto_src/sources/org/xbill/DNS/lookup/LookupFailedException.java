package org.xbill.DNS.lookup;

import lombok.Generated;
import org.xbill.DNS.Name;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
public class LookupFailedException extends RuntimeException {
    private final boolean isAuthenticated;
    private final Name name;
    private final int type;

    public LookupFailedException() {
        this(null, null, null, 0, false);
    }

    public Name getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    @Generated
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    public LookupFailedException(String str) {
        this(str, null, null, 0, false);
    }

    public LookupFailedException(String str, Throwable th) {
        this(str, th, null, 0, false);
    }

    public LookupFailedException(Name name, int i2) {
        this("Lookup for " + name + "/" + Type.string(i2) + " failed", name, i2);
    }

    public LookupFailedException(String str, Name name, int i2) {
        this(str, null, name, i2, false);
    }

    public LookupFailedException(String str, Throwable th, Name name, int i2, boolean z) {
        super(str, th);
        this.name = name;
        this.type = i2;
        this.isAuthenticated = z;
    }
}
