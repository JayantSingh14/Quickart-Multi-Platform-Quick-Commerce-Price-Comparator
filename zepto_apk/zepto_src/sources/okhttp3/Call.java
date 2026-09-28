package okhttp3;

import kotlin.Metadata;
import okhttp3.internal.connection.RealCall;

@Metadata
/* loaded from: classes.dex */
public interface Call extends Cloneable {

    @Metadata
    public interface Factory {
        RealCall a(Request request);
    }

    void cancel();

    void l0(Callback callback);

    Request r();

    boolean s();
}
