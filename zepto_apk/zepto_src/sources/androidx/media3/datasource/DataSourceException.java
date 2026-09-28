package androidx.media3.datasource;

import java.io.IOException;

/* loaded from: classes3.dex */
public class DataSourceException extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5844b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5845a;

    public DataSourceException(int i2) {
        this.f5845a = i2;
    }

    public DataSourceException(int i2, Exception exc) {
        super(exc);
        this.f5845a = i2;
    }

    public DataSourceException(String str, int i2) {
        super(str);
        this.f5845a = i2;
    }

    public DataSourceException(String str, Exception exc, int i2) {
        super(str, exc);
        this.f5845a = i2;
    }
}
