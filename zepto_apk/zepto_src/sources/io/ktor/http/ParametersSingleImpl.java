package io.ktor.http;

import io.ktor.util.StringValuesSingleImpl;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ParametersSingleImpl extends StringValuesSingleImpl implements Parameters {
    @Override // io.ktor.util.StringValuesSingleImpl
    public final String toString() {
        return "Parameters " + d();
    }
}
