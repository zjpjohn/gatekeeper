package com.xorlev.gatekeeper;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * 2013-07-28
 *
 * @author Michael Rose <michael@fullcontact.com>
 */
public class GatekeeperApplication {
    @Parameter(names = {"--environment", "-e"}, description = "Environment config to load")
    private String environment = "production";



    private final ZkWatcher zkWatcher;

    public GatekeeperApplication() throws Exception {
        AppConfig.initializeConfiguration(environment);

        this.zkWatcher = new ZkWatcher(new ClusterHandler<Void>());

        this.zkWatcher.start();
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public static void main(String[] args) throws Exception {
        GatekeeperApplication application = new GatekeeperApplication();
        JCommander jCommander = new JCommander(application, args);

        jCommander.setProgramName("gatekeeper");
//        jCommander.usage();
    }
}