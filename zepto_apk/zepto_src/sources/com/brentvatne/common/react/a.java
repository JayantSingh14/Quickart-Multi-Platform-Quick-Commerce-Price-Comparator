package com.brentvatne.common.react;

import com.brentvatne.common.react.VideoEventEmitter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15460a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter.EventBuilder f15461b;

    public /* synthetic */ a(VideoEventEmitter.EventBuilder eventBuilder, int i2) {
        this.f15460a = i2;
        this.f15461b = eventBuilder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f15460a) {
            case 0:
                this.f15461b.a(EventTypes.f15430c, null);
                break;
            case 1:
                this.f15461b.a(EventTypes.f15440m, null);
                break;
            case 2:
                this.f15461b.a(EventTypes.f15437j, null);
                break;
            case 3:
                this.f15461b.a(EventTypes.f15438k, null);
                break;
            case 4:
                this.f15461b.a(EventTypes.f15439l, null);
                break;
            case 5:
                this.f15461b.a(EventTypes.n, null);
                break;
            case 6:
                this.f15461b.a(EventTypes.o, null);
                break;
            case 7:
                this.f15461b.a(EventTypes.r, null);
                break;
            default:
                this.f15461b.a(EventTypes.t, null);
                break;
        }
        return Unit.f53572a;
    }
}
