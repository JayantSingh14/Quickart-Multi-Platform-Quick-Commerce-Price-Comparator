package org.xbill.DNS;

import lombok.Generated;

/* loaded from: classes5.dex */
public final class MessageSizeExceededException extends Exception {
    private final int maxSize;

    public MessageSizeExceededException(int i2) {
        super(android.support.v4.media.b.g(i2, "Message size would exceed the allowed maximum of ", " bytes"));
        this.maxSize = i2;
    }

    @Generated
    public int getMaxSize() {
        return this.maxSize;
    }
}
