package coil3.disk;

import android.support.v4.media.b;
import coil3.Image;
import coil3.request.ImageRequest;
import com.facebook.react.bridge.ReadableArray;
import java.io.IOException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import timber.log.Timber;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13868a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13869b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f13868a = i2;
        this.f13869b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object it) {
        switch (this.f13868a) {
            case 0:
                return DiskLruCache.newJournalWriter$lambda$4((DiskLruCache) this.f13869b, (IOException) it);
            case 1:
                return ImageRequest.Builder.placeholder$lambda$25((Image) this.f13869b, (ImageRequest) it);
            case 2:
                return Double.valueOf(((ReadableArray) this.f13869b).getDouble(((Integer) it).intValue()));
            case 3:
                String str = (String) it;
                Object objOpt = ((JSONObject) this.f13869b).opt(str);
                if (objOpt != null && !objOpt.equals(JSONObject.NULL)) {
                    return new Pair(str, objOpt);
                }
                Timber.d("AppInitializer").w(b.C("Dropping null value for key=", str), new Object[0]);
                return null;
            default:
                Intrinsics.checkNotNullParameter(it, "it");
                return ((Function0) this.f13869b).invoke();
        }
    }
}
