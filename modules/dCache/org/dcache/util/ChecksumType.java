/*
 * Checksum.java
 *
 * Created on November 4, 2008, 4:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.dcache.util;
import java.io.Serializable;

/**
 *
 * @author timur
 */
public enum ChecksumType  {
    ADLER32 (1,"ADLER32"),
    MD5_TYPE (2,"MD5"),
    MD4_TYPE (3,"MD4");
        
    private final int type;
    private final String name;
    
  
    
    /** Creates a new instance of Checksum */
    private  ChecksumType(int type, String name) {
        this.type = type;
        this.name = name;
    }
    
    public static final ChecksumType getChecksumType(int type) {
        for(ChecksumType checksumtype:ChecksumType.values()) {
            if(checksumtype.type == type) {
                return checksumtype;
            }
        }
        throw new IllegalArgumentException("unknown checksum type :"+type);
    }
    
    public static final ChecksumType getChecksumType(String name) {
        for(ChecksumType checksumtype:ChecksumType.values()) {
            if(checksumtype.name.equalsIgnoreCase(name)) return checksumtype;
        }
        throw new IllegalArgumentException("unknown checksum type name :"+name);
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    
    // this is what we need to correctly implement 
    // serialization of the singleton
    public Object readResolve()
    		throws java.io.ObjectStreamException {
        return getChecksumType(type);
    }
        
}
