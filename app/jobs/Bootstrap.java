package jobs;

import play.jobs.Job;
import play.jobs.OnApplicationStart;
import singletones.ModelSingleton;

/**
 * Created by sancho on 17.06.15.
 */
@OnApplicationStart
public class Bootstrap extends Job {

    public void initModelApi() {
        ModelSingleton.getInstance();
    }

}