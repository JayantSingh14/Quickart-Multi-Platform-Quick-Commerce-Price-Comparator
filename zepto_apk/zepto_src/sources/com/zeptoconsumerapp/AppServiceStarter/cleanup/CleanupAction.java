package com.zeptoconsumerapp.AppServiceStarter.cleanup;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.Call;

@Metadata
/* loaded from: classes4.dex */
public interface CleanupAction {
    Call a(Context context, String str, Map map);
}
