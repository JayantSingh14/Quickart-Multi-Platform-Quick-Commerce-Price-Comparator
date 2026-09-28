package androidx.lifecycle;

import java.util.ArrayDeque;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class DispatchQueue {

    /* renamed from: b, reason: collision with root package name */
    public boolean f4792b;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4791a = true;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f4793c = new ArrayDeque();

    public final void a() {
        if (this.f4792b) {
            return;
        }
        try {
            this.f4792b = true;
            while (true) {
                ArrayDeque arrayDeque = this.f4793c;
                if (arrayDeque.isEmpty() || this.f4791a) {
                    break;
                }
                Runnable runnable = (Runnable) arrayDeque.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } finally {
            this.f4792b = false;
        }
    }
}
