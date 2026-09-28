package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AppendableFormatStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f55528a = new ArrayList();

    public final void a(FormatStructure format) {
        Intrinsics.checkNotNullParameter(format, "format");
        boolean z = format instanceof NonConcatenatedFormatStructure;
        ArrayList arrayList = this.f55528a;
        if (z) {
            arrayList.add(format);
        } else if (format instanceof ConcatenatedFormatStructure) {
            Iterator<T> it = ((ConcatenatedFormatStructure) format).f55534a.iterator();
            while (it.hasNext()) {
                arrayList.add((NonConcatenatedFormatStructure) it.next());
            }
        }
    }
}
