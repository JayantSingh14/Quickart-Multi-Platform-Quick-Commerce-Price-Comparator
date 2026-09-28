package kotlinx.datetime.internal.format;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.formatter.ConcatenatedFormatter;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public class ConcatenatedFormatStructure<T> implements FormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f55534a;

    public ConcatenatedFormatStructure(ArrayList formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.f55534a = formats;
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure a() {
        ArrayList arrayList = this.f55534a;
        ArrayList formatters = new ArrayList(CollectionsKt.r(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            formatters.add(((NonConcatenatedFormatStructure) it.next()).a());
        }
        if (formatters.size() == 1) {
            return (FormatterStructure) CollectionsKt.T(formatters);
        }
        Intrinsics.checkNotNullParameter(formatters, "formatters");
        return new ConcatenatedFormatter();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure b() {
        ArrayList arrayList = this.f55534a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((NonConcatenatedFormatStructure) it.next()).b());
        }
        return ParserKt.a(arrayList2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ConcatenatedFormatStructure) {
            return Intrinsics.b(this.f55534a, ((ConcatenatedFormatStructure) obj).f55534a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55534a.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("ConcatenatedFormatStructure("), CollectionsKt.E(this.f55534a, ", ", null, null, null, 62), ')');
    }
}
