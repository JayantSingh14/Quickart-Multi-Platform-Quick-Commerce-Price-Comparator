package androidx.databinding;

import java.util.List;

/* loaded from: classes3.dex */
public interface ObservableList<T> extends List<T> {

    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e();
    }
}
