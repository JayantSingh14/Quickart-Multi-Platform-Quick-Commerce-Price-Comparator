package io.ktor.http;

import io.ktor.util.StringValuesSingleImpl;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class HeadersSingleImpl extends StringValuesSingleImpl implements Headers {
    @Override // io.ktor.util.StringValuesSingleImpl
    public final String toString() {
        return "Headers " + d();
    }
}
