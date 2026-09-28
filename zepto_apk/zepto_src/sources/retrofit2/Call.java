package retrofit2;

import okhttp3.Request;

/* loaded from: classes.dex */
public interface Call<T> extends Cloneable {
    void N(Callback callback);

    void cancel();

    /* renamed from: clone */
    Call mo78clone();

    Request r();

    boolean s();
}
