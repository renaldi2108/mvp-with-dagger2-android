package id.renaldirey.daggermvp.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import id.renaldirey.daggermvp.App;
import id.renaldirey.daggermvp.di.ApplicationContext;
import id.renaldirey.daggermvp.di.module.ApplicationModule;

/**
 * Created by Kwikku on 16/05/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

//    NetworkService getNetworkService();
}
