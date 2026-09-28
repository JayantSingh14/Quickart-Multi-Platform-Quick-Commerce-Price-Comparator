package kotlinx.coroutines;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata
@IgnoreJRERequirement
@PublishedApi
/* loaded from: classes.dex */
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Object J1(CoroutineContext coroutineContext) {
        String str;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f54076b);
        if (coroutineName == null || (str = coroutineName.f54077a) == null) {
            str = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iC = StringsKt.C(name, " @", 0, 6);
        if (iC < 0) {
            iC = name.length();
        }
        StringBuilder sb = new StringBuilder(e.C(iC, 10, str));
        String strSubstring = name.substring(0, iC);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append(str);
        sb.append("#0");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        threadCurrentThread.setName(string);
        return name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoroutineId)) {
            return false;
        }
        ((CoroutineId) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(0L);
    }

    public final String toString() {
        return "CoroutineId(0)";
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void u0(Object obj) {
        Thread.currentThread().setName((String) obj);
    }
}
