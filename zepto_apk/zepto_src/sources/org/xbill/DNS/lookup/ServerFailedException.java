package org.xbill.DNS.lookup;

import lombok.Generated;
import org.xbill.DNS.ExtendedErrorCodeOption;
import org.xbill.DNS.Name;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
public class ServerFailedException extends LookupFailedException {
    private final ExtendedErrorCodeOption extendedRcode;

    public ServerFailedException() {
        this.extendedRcode = null;
    }

    @Generated
    public ExtendedErrorCodeOption getExtendedRcode() {
        return this.extendedRcode;
    }

    public ServerFailedException(Name name, int i2) {
        super(name, i2);
        this.extendedRcode = null;
    }

    public ServerFailedException(Name name, int i2, ExtendedErrorCodeOption extendedErrorCodeOption) {
        super("Lookup for " + name + "/" + Type.string(i2) + " failed with " + extendedErrorCodeOption.getText(), name, i2);
        this.extendedRcode = extendedErrorCodeOption;
    }
}
