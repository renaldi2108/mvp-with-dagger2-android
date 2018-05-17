package id.renaldirey.daggermvp;

import android.app.Application;

import id.renaldirey.daggermvp.di.component.ApplicationComponent;
import id.renaldirey.daggermvp.di.component.DaggerApplicationComponent;
import id.renaldirey.daggermvp.di.module.ApplicationModule;


/**
 * Created by Kwikku on 13/05/2018.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
