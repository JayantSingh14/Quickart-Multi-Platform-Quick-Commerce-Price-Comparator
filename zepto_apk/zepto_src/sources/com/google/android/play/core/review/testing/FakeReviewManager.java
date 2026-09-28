package com.google.android.play.core.review.testing;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;

/* loaded from: classes4.dex */
public class FakeReviewManager implements ReviewManager {
    @Override // com.google.android.play.core.review.ReviewManager
    public final Task a(Activity activity, ReviewInfo reviewInfo) {
        return reviewInfo != null ? Tasks.d(new ReviewException(-2)) : Tasks.e(null);
    }
}
