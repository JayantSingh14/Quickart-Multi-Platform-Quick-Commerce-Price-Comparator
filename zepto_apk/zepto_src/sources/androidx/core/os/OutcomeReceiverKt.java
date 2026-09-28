package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuationImpl;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
public final class OutcomeReceiverKt {
    public static final OutcomeReceiver a(CancellableContinuationImpl cancellableContinuationImpl) {
        return a.i(new ContinuationOutcomeReceiver(cancellableContinuationImpl));
    }
}
