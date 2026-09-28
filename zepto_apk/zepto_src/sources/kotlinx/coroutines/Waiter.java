package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;

@Metadata
/* loaded from: classes.dex */
public interface Waiter {
    void a(Segment segment, int i2);
}
