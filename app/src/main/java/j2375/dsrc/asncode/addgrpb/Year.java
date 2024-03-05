/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/addgrpb/Year.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.addgrpb;

/**
 * <BR> Unsigned units of 01 seconds, spanning 15 minutes, in 2 octets
 * <BR> the value 9001 shall indicate 'forever'
 * <BR> values from 9002 to 65534 shall not be sent
 * <BR> the value 65535 (0xFFFF) shall indicate an invalid value
 * Class definition of the Year type of the addgrpb module.
 */
public class Year extends fr.marben.asnsdk.japi.spe.IntIntegerValue
{
  /**
   *  Constructs a newly allocated Year.
   */
  public Year ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated Year that represents the primitive int argument.
   *  @param value the value to be represented by this Year.
   */
  public Year (int value)
  {
    super(value);
  };
}
