package org.slf4j.helpers;

import org.slf4j.Logger;

/* loaded from: classes5.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    @Override // org.slf4j.helpers.NamedLoggerBase, org.slf4j.Logger
    public /* bridge */ /* synthetic */ String getName() {
        return null;
    }

    public final String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }
}
