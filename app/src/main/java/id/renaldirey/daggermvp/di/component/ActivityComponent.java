package id.renaldirey.daggermvp.di.component;

import dagger.Component;
import id.renaldirey.daggermvp.di.PerActivity;
import id.renaldirey.daggermvp.di.module.ActivityModule;
import id.renaldirey.daggermvp.ui.activity.MainActivity;

/**
 * Created by Kwikku on 16/05/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
