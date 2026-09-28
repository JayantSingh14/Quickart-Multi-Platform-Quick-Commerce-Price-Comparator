package kotlinx.coroutines.slf4j;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;

@Metadata
/* loaded from: classes3.dex */
public final class MDCContext extends AbstractCoroutineContextElement implements ThreadContextElement<Map<String, ? extends String>> {

    /* renamed from: b, reason: collision with root package name */
    public static final Key f55221b = new Key();

    /* renamed from: a, reason: collision with root package name */
    public final Map f55222a;

    @Metadata
    public static final class Key implements CoroutineContext.Key<MDCContext> {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MDCContext() {
        super(f55221b);
        MDCAdapter mDCAdapter = MDC.f57876a;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        Map mapA = mDCAdapter.a();
        this.f55222a = mapA;
    }

    public static void c1(Map map) {
        if (map == null) {
            MDCAdapter mDCAdapter = MDC.f57876a;
            if (mDCAdapter == null) {
                throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            }
            mDCAdapter.clear();
            return;
        }
        MDCAdapter mDCAdapter2 = MDC.f57876a;
        if (mDCAdapter2 == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter2.b(map);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Object J1(CoroutineContext coroutineContext) {
        MDCAdapter mDCAdapter = MDC.f57876a;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        Map mapA = mDCAdapter.a();
        c1(this.f55222a);
        return mapA;
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void u0(Object obj) {
        c1((Map) obj);
    }
}
