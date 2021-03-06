/**
 Copyright (c) 2017-2018 The Smartx Developers
 <p>
 Distributed under the MIT software license, see the accompanying file
 LICENSE or https://opensource.org/licenses/mit-license.php
 */
package com.smartx.net.msg.p2p;

import com.smartx.net.msg.Message;
import com.smartx.net.msg.MessageCode;
import com.smartx.util.SimpleDecoder;
import com.smartx.util.SimpleEncoder;
import com.smartx.util.TimeUtil;

public class PingMessage extends Message {
    private final long timestamp;
    /**
     * Create a PING message.
     *
     */
    public PingMessage() {
        super(MessageCode.PING, PongMessage.class);
        this.timestamp = TimeUtil.currentTimeMillis();
        SimpleEncoder enc = new SimpleEncoder();
        enc.writeLong(timestamp);
        this.body = enc.toBytes();
    }
    /**
     * Parse a PING message from byte array.
     *
     * @param body
     */
    public PingMessage(byte[] uuid, byte[] body) {
        super(MessageCode.PING, uuid, PongMessage.class);
        SimpleDecoder dec = new SimpleDecoder(body);
        this.timestamp = dec.readLong();
        this.body = body;
    }
    @Override
    public String toString() {
        return "PingMessage [timestamp=" + timestamp + "]";
    }
}
