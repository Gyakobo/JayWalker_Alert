/*
Copyright (C) 1999-2011 Marben Products. All rights reserved.

THIS FILE IS PROPRIETARY MATERIAL OF MARBEN PRODUCTS.
AND MAY BE USED ONLY BY DIRECT LICENSEES OF ASNSDK PRODUCT.
THIS FILE MAY NOT BE DISTRIBUTED.

===========================================================================

/home/itsrc/J2375_2016/src/asncode/dsrc/GeographicalPath.java: 

Generated by ASNSDK TCE-JAVA ASN.1 Compiler v4.0 - REF_8.55 - REF_8.39

===========================================================================
*/
package j2375.dsrc.asncode.dsrc;

/**
 * Class definition of the GeographicalPath type of the dsrc module.
 */
public class GeographicalPath extends fr.marben.asnsdk.japi.spe.ExtSequenceValue
{
  /**
   * value of the typeIndex field for this class.
   */
  public static final int ASNTYPE = 93;

  /**
   * optional field name.
   */
  public j2375.dsrc.asncode.dsrc.DescriptiveName name;

  /**
   * optional field id.
   */
  public j2375.dsrc.asncode.dsrc.RoadSegmentReferenceID id;

  /**
   * optional field anchor.
   */
  public j2375.dsrc.asncode.dsrc.Position3D anchor;

  /**
   * optional field laneWidth.
   */
  public j2375.dsrc.asncode.dsrc.LaneWidth laneWidth;

  /**
   * optional field directionality.
   */
  public j2375.dsrc.asncode.dsrc.DirectionOfUse directionality;

  /**
   * optional field closedPath.
   */
  public fr.marben.asnsdk.japi.spe.BooleanValue closedPath;

  /**
   * <BR> when true, last point closes to first
   * optional field direction.
   */
  public j2375.dsrc.asncode.dsrc.HeadingSlice direction;

  /**
   * <BR> field of view over which this applies
   * optional field description.
   */
  public Description description;

  /**
   * optional field regional.
   */
  public Regional regional;

  /**
   * class definition of the description field.
   */
  public static class Description extends fr.marben.asnsdk.japi.spe.ExtChoiceValue
  {
    /**
     * value of the fieldNumber for the field path.
     * <BR>Use {@link j2375.dsrc.asncode.dsrc.OffsetSystem j2375.dsrc.asncode.dsrc.OffsetSystem} for the values of this type.
     */
    public static final short ASN_path = 0;

    /**
     * <BR> The XYZ and LLH system of paths
     * value of the fieldNumber for the field geometry.
     * <BR>Use {@link j2375.dsrc.asncode.dsrc.GeometricProjection j2375.dsrc.asncode.dsrc.GeometricProjection} for the values of this type.
     */
    public static final short ASN_geometry = 1;

    /**
     * <BR> A projected circle from a point
     * value of the fieldNumber for the field oldRegion.
     * <BR>Use {@link j2375.dsrc.asncode.dsrc.ValidRegion j2375.dsrc.asncode.dsrc.ValidRegion} for the values of this type.
     */
    public static final short ASN_oldRegion = 2;

    /**
     *  Constructs a newly allocated Description.
     */
    public Description ()
    {
      super();
    };

    /**
     *  Create a newly allocated Description.
     *  @param fieldNumber the named type identifier of the component.
     *  @param value the value to set.
     *  @throws fr.marben.asnsdk.japi.InvalidStructureException in case of a problem
     */
     public Description(short fieldNumber,
                          fr.marben.asnsdk.japi.spe.Value value)
                          throws fr.marben.asnsdk.japi.InvalidStructureException
     {
       this.unknownExt = null;
       this.fieldNumber = fieldNumber;
       switch (fieldNumber)
       {
       case 0 :
         this.value = (j2375.dsrc.asncode.dsrc.OffsetSystem)value;
         break;
       case 1 :
         this.value = (j2375.dsrc.asncode.dsrc.GeometricProjection)value;
         break;
       case 2 :
         this.value = (j2375.dsrc.asncode.dsrc.ValidRegion)value;
         break;
       default :
         throw new fr.marben.asnsdk.japi.InvalidStructureException(fr.marben.asnsdk.japi.InvalidStructureException.INVALID_CHOICE_ALTERNATIVE);
       }
     }

    /**
     *  Sets the value of a component from this Description.
     *  @param fieldNumber the named type identifier of the component.
     *  @param value the value to set.
     *  @throws fr.marben.asnsdk.japi.InvalidStructureException in case of a problem
     */
     public void setValue(short fieldNumber,
                          fr.marben.asnsdk.japi.spe.Value value)
                          throws fr.marben.asnsdk.japi.InvalidStructureException
     {
       this.unknownExt = null;
       this.fieldNumber = fieldNumber;
       switch (fieldNumber)
       {
       case 0 :
         this.value = (j2375.dsrc.asncode.dsrc.OffsetSystem)value;
         break;
       case 1 :
         this.value = (j2375.dsrc.asncode.dsrc.GeometricProjection)value;
         break;
       case 2 :
         this.value = (j2375.dsrc.asncode.dsrc.ValidRegion)value;
         break;
       default :
         throw new fr.marben.asnsdk.japi.InvalidStructureException(fr.marben.asnsdk.japi.InvalidStructureException.INVALID_CHOICE_ALTERNATIVE);
       }
     }

    /**
     *  Creates and sets a newly allocated component value from this Description.
     *  This method is only for ASNSDK internal use.
     *  @param context a fr.marben.asnsdk.japi.Context.
     *  @param field the named type of this Description.
     *  @return a value from a class implementing the IValue interface.
     */
     public fr.marben.asnsdk.japi.vi.IValue asnSetNewChoiceValue(
                             fr.marben.asnsdk.japi.Context context,
                             fr.marben.asnsdk.japi.vi.IChoiceNamedType field)
     {
       this.fieldNumber = field.getFieldNumber(context);
       switch (this.fieldNumber)
       {
       case 0 :
         this.value = new j2375.dsrc.asncode.dsrc.OffsetSystem();
         return this.value;
       case 1 :
         this.value = new j2375.dsrc.asncode.dsrc.GeometricProjection();
         return this.value;
       case 2 :
         this.value = new j2375.dsrc.asncode.dsrc.ValidRegion();
         return this.value;
       default :
         throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
       }
     }

  }

  /**
   * class definition of the regional field.
   */
  public static class Regional extends fr.marben.asnsdk.japi.spe.SequenceOfValue
  {
    /**
     * class definition of the SEQUENCE field.
     */
    public static class SEQUENCE extends fr.marben.asnsdk.japi.spe.SequenceValue
    {
      /**
       * mandatory field regionId.
       */
      public j2375.dsrc.asncode.dsrc.RegionId regionId;

      /**
       * mandatory field regExtValue.
       */
      public fr.marben.asnsdk.japi.spe.OpenTypeValue regExtValue;

      /**
       *  Constructs a newly allocated SEQUENCE.
       */
      public SEQUENCE ()
      {
        super();
      };

      /**
       *  Gets the value of a component from this SEQUENCE.
       *  This method is only for ASNSDK internal use.
       *  @param context a fr.marben.asnsdk.japi.Context.
       *  @param field the named type identifier of the component.
       *  @return the value identified by the named type.
       */
       public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqValue(
                               fr.marben.asnsdk.japi.Context context,
                               fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
       {
         switch (field.getFieldNumber(context))
         {
         case 0 :
           return this.regionId;
         case 1 :
           return this.regExtValue;
         default :
           throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
         }
       }

      /**
       *  Creates a newly allocated component value from this SEQUENCE.
       *  this value is created for temporary use to solve atNotations
       *  This method is only for ASNSDK internal use.
       *  @param context a fr.marben.asnsdk.japi.Context.
       *  @param field the named type of this SEQUENCE.
       *  @return a value from a class implementing the IValue interface.
       */
       public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                               fr.marben.asnsdk.japi.Context context,
                               fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
       {
         switch (field.getFieldNumber(context))
         {
         case 0 :
           return new j2375.dsrc.asncode.dsrc.RegionId();
         case 1 :
           return new fr.marben.asnsdk.japi.spe.OpenTypeValue();
         default :
           throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
         }
       }

      /**
       *  Creates and sets a newly allocated component value from this SEQUENCE.
       *  This method is only for ASNSDK internal use.
       *  @param context a fr.marben.asnsdk.japi.Context.
       *  @param field the named type of this SEQUENCE.
       *  @return a value from a class implementing the IValue interface.
       */
       public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                               fr.marben.asnsdk.japi.Context context,
                               fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
       {
         switch (field.getFieldNumber(context))
         {
         case 0 :
           this.regionId = new j2375.dsrc.asncode.dsrc.RegionId();
           return this.regionId;
         case 1 :
           this.regExtValue = new fr.marben.asnsdk.japi.spe.OpenTypeValue();
           return this.regExtValue;
         default :
           throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
         }
       }

    }

    /**
     *  Constructs a newly allocated Regional.
     */
    public Regional ()
    {
      super();
    };

    /**
     *  Constructs a newly allocated Regional with the given list.
     *  @param list the list used to initialize this Regional.
     */
    public Regional (java.util.List list)
    {
      super(list);
    };
    
    /**
     *  Creates and appends a newly allocated component value from 
     *  this Regional.
     *  This method is only for ASNSDK internal use. 
     *  @param context a fr.marben.asnsdk.japi.Context.
     *  @param field the named type of this Regional.
     *  @return a value from a class implementing de IValue interface.
     */
    public fr.marben.asnsdk.japi.vi.IValue asnAddNewSetSeqOfValue(
                          fr.marben.asnsdk.japi.Context context,
                          fr.marben.asnsdk.japi.vi.ISetSeqOfNamedType field)
    {
          j2375.dsrc.asncode.dsrc.GeographicalPath.Regional.SEQUENCE value = new j2375.dsrc.asncode.dsrc.GeographicalPath.Regional.SEQUENCE();
          this.valueList.add(value);
          return value;
    }
  }

  /**
   *  Constructs a newly allocated GeographicalPath.
   */
  public GeographicalPath ()
  {
    super();
  };

  /**
   *  Gets the value of a component from this GeographicalPath.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type identifier of the component.
   *  @return the value identified by the named type.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return this.name;
     case 1 :
       return this.id;
     case 2 :
       return this.anchor;
     case 3 :
       return this.laneWidth;
     case 4 :
       return this.directionality;
     case 5 :
       return this.closedPath;
     case 6 :
       return this.direction;
     case 7 :
       return this.description;
     case 8 :
       return this.regional;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to set field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated component value from this GeographicalPath.
   *  this value is created for temporary use to solve atNotations
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this GeographicalPath.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       return new j2375.dsrc.asncode.dsrc.DescriptiveName();
     case 1 :
       return new j2375.dsrc.asncode.dsrc.RoadSegmentReferenceID();
     case 2 :
       return new j2375.dsrc.asncode.dsrc.Position3D();
     case 3 :
       return new j2375.dsrc.asncode.dsrc.LaneWidth();
     case 4 :
       return new j2375.dsrc.asncode.dsrc.DirectionOfUse();
     case 5 :
       return new fr.marben.asnsdk.japi.spe.BooleanValue();
     case 6 :
       return new j2375.dsrc.asncode.dsrc.HeadingSlice();
     case 7 :
       return new Description();
     case 8 :
       return new Regional();
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated component value from this GeographicalPath.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param field the named type of this GeographicalPath.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqValue(
                           fr.marben.asnsdk.japi.Context context,
                           fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (field.getFieldNumber(context))
     {
     case 0 :
       this.name = new j2375.dsrc.asncode.dsrc.DescriptiveName();
       return this.name;
     case 1 :
       this.id = new j2375.dsrc.asncode.dsrc.RoadSegmentReferenceID();
       return this.id;
     case 2 :
       this.anchor = new j2375.dsrc.asncode.dsrc.Position3D();
       return this.anchor;
     case 3 :
       this.laneWidth = new j2375.dsrc.asncode.dsrc.LaneWidth();
       return this.laneWidth;
     case 4 :
       this.directionality = new j2375.dsrc.asncode.dsrc.DirectionOfUse();
       return this.directionality;
     case 5 :
       this.closedPath = new fr.marben.asnsdk.japi.spe.BooleanValue();
       return this.closedPath;
     case 6 :
       this.direction = new j2375.dsrc.asncode.dsrc.HeadingSlice();
       return this.direction;
     case 7 :
       this.description = new Description();
       return this.description;
     case 8 :
       this.regional = new Regional();
       return this.regional;
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to create field number " + field.getFieldNumber(context));
     }
   }

  /**
   *  Gets a group value from the GeographicalPath.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @param field the named type of the extension group.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnGetSetSeqGroupValue(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group,
                                fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Returns whether or not this group is present among the extensions.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @return <code>true</code>: when the group is present.
   *          <code>false</code>: when the group is not present.
   */
   public boolean asnIsSetSeqGroupPresent(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Creates a newly allocated group value of the GeographicalPath.
   *  This group is created for temporary use, in order to solve atNotations.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @param field the named type of the extension group.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewTmpSetSeqGroupValue(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group,
                                fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Creates and sets a newly allocated group value of the GeographicalPath.
   *  This method is only for ASNSDK internal use.
   *  @param context a fr.marben.asnsdk.japi.Context.
   *  @param group the extension group.
   *  @param field the named type of the extension group.
   *  @return a value from a class implementing the IValue interface.
   */
   public fr.marben.asnsdk.japi.vi.IValue asnSetNewSetSeqGroupValue(fr.marben.asnsdk.japi.Context context,
                                fr.marben.asnsdk.japi.vi.ISetSeqExtensionGroup group,
                                fr.marben.asnsdk.japi.vi.ISetSeqNamedType field)
   {
     switch (group.getFieldNumber(context))
     {
     default :
       throw new fr.marben.asnsdk.japi.DysfunctionException("Unable to find the group " + group.getFieldNumber(context));
     }
   }

  /**
   *  Gets the typeIndex value for this class.
   *  This method is only for ASNSDK internal use. 
   *  @return the type index.
   */
  public int asnGetTypeIndex()
  {
    return 93;
  }

}
