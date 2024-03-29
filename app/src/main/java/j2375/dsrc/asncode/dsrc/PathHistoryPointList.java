/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/PathHistoryPointList.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the PathHistoryPointList type of the dsrc module.
 */
public class PathHistoryPointList extends fr.marben.asnsdk.japi.spe.SequenceOfValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 119;

  /**
   *  Constructs a newly allocated PathHistoryPointList.
   */
  public PathHistoryPointList ()
  {
    super();
  };

  /**
   *  Constructs a newly allocated PathHistoryPointList with the given list.
   *  @param list the list used to initialize this PathHistoryPointList.
   */
  public PathHistoryPointList (java.util.List list)
  {
    super(list);
  };
  
  /**
   *  Creates and appends a newly allocated component value from 
   *  this PathHistoryPointList.
   *  This method is only for ASNSDK internal use. 
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this PathHistoryPointList.
   *  @return a value from a class implementing de IValue interface.
   */
  public fr.marben.asnsdk.japi.vi.IValue asnAddNewSetSeqOfValue(
                        fr.marben.asnsdk.japi.Context context,
                        fr.marben.asnsdk.japi.vi.ISetSeqOfNamedType field)
  {
        j2375.dsrc.asncode.dsrc.PathHistoryPoint value = new j2375.dsrc.asncode.dsrc.PathHistoryPoint();
        this.valueList.add(value);
        return value;
  }
  /**
   *  Gets the typeIndex value for this class.
   *  This method is only for ASNSDK internal use. 
   *  @return the type index.
   */
  public int asnGetTypeIndex()
  {
    return 119;
  }

}
