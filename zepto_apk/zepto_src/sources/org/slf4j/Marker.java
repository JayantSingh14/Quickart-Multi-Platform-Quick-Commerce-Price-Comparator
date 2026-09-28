package org.slf4j;

import java.io.Serializable;

/* loaded from: classes5.dex */
public interface Marker extends Serializable {
    boolean contains(String str);

    boolean equals(Object obj);

    String getName();
}
