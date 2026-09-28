package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: classes.dex */
public final class JobSupportKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f54146a = new Symbol("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final Symbol f54147b = new Symbol("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    public static final Symbol f54148c = new Symbol("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    public static final Symbol f54149d = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    public static final Symbol f54150e = new Symbol("SEALED");

    /* renamed from: f, reason: collision with root package name */
    public static final Empty f54151f = new Empty(false);

    /* renamed from: g, reason: collision with root package name */
    public static final Empty f54152g = new Empty(true);

    public static final Object a(Object obj) {
        Incomplete incomplete;
        IncompleteStateBox incompleteStateBox = obj instanceof IncompleteStateBox ? (IncompleteStateBox) obj : null;
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.f54115a) == null) ? obj : incomplete;
    }
}
