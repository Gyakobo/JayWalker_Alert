/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/RuntimeConfiguration.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode;

/**
 * Runtime Configuration class definition.
 */
public class RuntimeConfiguration
{
  public static void initialize()
  {
    fr.marben.asnsdk.japi.ConfigurationManager.setService(new fr.marben.asnsdk.japi.UperDecoder());
    fr.marben.asnsdk.japi.ConfigurationManager.setService(new fr.marben.asnsdk.japi.UperEncoder());
    fr.marben.asnsdk.japi.ConfigurationManager.setService(new fr.marben.asnsdk.japi.ValueTracer());
  }
}