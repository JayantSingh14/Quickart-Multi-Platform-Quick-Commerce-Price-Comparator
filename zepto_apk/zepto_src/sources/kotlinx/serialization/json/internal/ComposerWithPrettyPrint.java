package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ComposerWithPrettyPrint extends Composer {

    /* renamed from: c, reason: collision with root package name */
    public int f56037c;

    @Override // kotlinx.serialization.json.internal.Composer
    public final void a() {
        this.f56034b = true;
        this.f56037c++;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void b() {
        this.f56034b = false;
        h(StringUtils.LF);
        if (this.f56037c > 0) {
            throw null;
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void c() {
        if (this.f56034b) {
            this.f56034b = false;
        } else {
            b();
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void k() {
        e(' ');
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void l() {
        this.f56037c--;
    }
}
