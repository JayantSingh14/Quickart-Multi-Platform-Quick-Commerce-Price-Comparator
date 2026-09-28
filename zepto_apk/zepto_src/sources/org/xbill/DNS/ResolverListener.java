package org.xbill.DNS;

import java.util.EventListener;

@Deprecated
/* loaded from: classes5.dex */
public interface ResolverListener extends EventListener {
    void handleException(Object obj, Exception exc);

    void receiveMessage(Object obj, Message message);
}
