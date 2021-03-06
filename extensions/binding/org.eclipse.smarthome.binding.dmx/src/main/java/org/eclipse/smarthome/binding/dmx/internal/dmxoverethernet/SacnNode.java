/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.binding.dmx.internal.dmxoverethernet;

/**
 * The {@link ArtnetNode} represents a sending or receiving node with address and port
 * default address is set to 5568 for sACN/E1.31
 *
 * @author Jan N. Klug - Initial contribution
 *
 */

public class SacnNode extends IpNode {
    public static final int DEFAULT_PORT = 5568;

    /**
     * constructor with address
     *
     * @param addrString address in format address[:port]
     */
    public SacnNode(String addrString) {
        super(addrString);
        if (port == 0) {
            port = DEFAULT_PORT;
        }
    }

    /**
     * create a SacnNode with a broadcast-address
     *
     * @param universeId the universe to create the node for
     * @return the multicast SacnNode
     */
    public static SacnNode getBroadcastNode(int universeId) {
        return new SacnNode(String.format("239.255.%d.%d", universeId / 256, universeId % 256));
    }
}
