package com.smartx.util;
/**
 Interface similar to ByteBuffer for reading large streaming or random access data
 <p>
 Created by Anton Nashatyrev on 18.06.2015.
 */
public interface SectionReader {
    long seek(long offset, int whence /* ??? */);
    int read(byte[] dest, int destOff);
    int readAt(byte[] dest, int destOff, long readerOffset);
    long getSize();
}
