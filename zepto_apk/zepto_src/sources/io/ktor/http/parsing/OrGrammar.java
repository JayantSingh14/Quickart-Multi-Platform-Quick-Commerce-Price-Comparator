package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OrGrammar extends Grammar implements ComplexGrammar {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f50305a;

    public OrGrammar(List sourceGrammars) {
        Intrinsics.checkNotNullParameter(sourceGrammars, "sourceGrammars");
        ArrayList arrayList = new ArrayList();
        for (Object obj : sourceGrammars) {
            if (obj instanceof OrGrammar) {
                CollectionsKt.i(arrayList, ((ComplexGrammar) obj).a());
            } else {
                arrayList.add(obj);
            }
        }
        this.f50305a = arrayList;
    }

    @Override // io.ktor.http.parsing.ComplexGrammar
    public final List a() {
        return this.f50305a;
    }
}
