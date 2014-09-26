package com.xorlev.gatekeeper.handler;

import com.xorlev.gatekeeper.events.ClustersUpdatedEvent;

/**
 * 2014-03-01
 *
 * @author Michael Rose <michael@fullcontact.com>
 */
public interface PostConfigCallback {
    void onConfigFinished(ClustersUpdatedEvent event);
}
