/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

 
package gov.nasa.jpl.imce.oml.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.{JSExport,JSExportTopLevel}
import scala.Predef.ArrowAssoc

/**
  * @param uuid[1,1]
  * @param descriptionBoxUUID[1,1]
  * @param domainUUID[1,1]
  * @param rangeUUID[1,1]
  * @param restrictedRelationshipUUID[1,1]
  */
@JSExportTopLevel("InstanceRelationshipExistentialRangeRestriction")
case class InstanceRelationshipExistentialRangeRestriction
(
  @(JSExport @field) override val uuid: taggedTypes.InstanceRelationshipExistentialRangeRestrictionUUID,
  @(JSExport @field) val descriptionBoxUUID: taggedTypes.DescriptionBoxUUID,
  @(JSExport @field) val domainUUID: taggedTypes.ConceptualEntitySingletonInstanceUUID,
  @(JSExport @field) val rangeUUID: taggedTypes.EntityUUID,
  @(JSExport @field) val restrictedRelationshipUUID: taggedTypes.RestrictableRelationshipUUID
) extends ElementCrossReferenceTuple with TerminologyInstanceAssertion {
  // Ctor(uuidWithContainer)   
  def this(
    oug: gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator,
    descriptionBoxUUID: taggedTypes.DescriptionBoxUUID,
    domainUUID: taggedTypes.ConceptualEntitySingletonInstanceUUID,
    rangeUUID: taggedTypes.EntityUUID,
    restrictedRelationshipUUID: taggedTypes.RestrictableRelationshipUUID)
  = this(
      taggedTypes.instanceRelationshipExistentialRangeRestrictionUUID(oug.namespaceUUID(
        "InstanceRelationshipExistentialRangeRestriction",
        "descriptionBox" -> descriptionBoxUUID,
        "domain" -> domainUUID,
        "range" -> rangeUUID,
        "restrictedRelationship" -> restrictedRelationshipUUID).toString),
      descriptionBoxUUID,
      domainUUID,
      rangeUUID,
      restrictedRelationshipUUID)

val vertexId: scala.Long = uuid.hashCode.toLong

  override val hashCode
  : scala.Int 
  = (uuid, descriptionBoxUUID, domainUUID, rangeUUID, restrictedRelationshipUUID).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: InstanceRelationshipExistentialRangeRestriction =>
  	  (this.uuid == that.uuid) &&
  	  (this.descriptionBoxUUID == that.descriptionBoxUUID)  &&
  	  (this.domainUUID == that.domainUUID)  &&
  	  (this.rangeUUID == that.rangeUUID)  &&
  	  (this.restrictedRelationshipUUID == that.restrictedRelationshipUUID) 
    case _ =>
      false
  }
  
}

@JSExportTopLevel("InstanceRelationshipExistentialRangeRestrictionHelper")
object InstanceRelationshipExistentialRangeRestrictionHelper {

  import io.circe.{Decoder, Encoder, HCursor, Json}
  import io.circe.parser.parse
  import scala.Predef.String

  val TABLE_JSON_FILENAME 
  : String 
  = "InstanceRelationshipExistentialRangeRestrictions.json"

  implicit val decodeInstanceRelationshipExistentialRangeRestriction: Decoder[InstanceRelationshipExistentialRangeRestriction]
  = Decoder.instance[InstanceRelationshipExistentialRangeRestriction] { c: HCursor =>
    
    import cats.syntax.either._
  
    for {
    	  uuid <- c.downField("uuid").as[taggedTypes.InstanceRelationshipExistentialRangeRestrictionUUID]
    	  descriptionBoxUUID <- c.downField("descriptionBoxUUID").as[taggedTypes.DescriptionBoxUUID]
    	  domainUUID <- c.downField("domainUUID").as[taggedTypes.ConceptualEntitySingletonInstanceUUID]
    	  rangeUUID <- c.downField("rangeUUID").as[taggedTypes.EntityUUID]
    	  restrictedRelationshipUUID <- c.downField("restrictedRelationshipUUID").as[taggedTypes.RestrictableRelationshipUUID]
    	} yield InstanceRelationshipExistentialRangeRestriction(
    	  uuid,
    	  descriptionBoxUUID,
    	  domainUUID,
    	  rangeUUID,
    	  restrictedRelationshipUUID
    	)
  }
  
  implicit val encodeInstanceRelationshipExistentialRangeRestriction: Encoder[InstanceRelationshipExistentialRangeRestriction]
  = new Encoder[InstanceRelationshipExistentialRangeRestriction] {
    override final def apply(x: InstanceRelationshipExistentialRangeRestriction): Json 
    = Json.obj(
    	  ("uuid", taggedTypes.encodeInstanceRelationshipExistentialRangeRestrictionUUID(x.uuid)),
    	  ("descriptionBoxUUID", taggedTypes.encodeDescriptionBoxUUID(x.descriptionBoxUUID)),
    	  ("domainUUID", taggedTypes.encodeConceptualEntitySingletonInstanceUUID(x.domainUUID)),
    	  ("rangeUUID", taggedTypes.encodeEntityUUID(x.rangeUUID)),
    	  ("restrictedRelationshipUUID", taggedTypes.encodeRestrictableRelationshipUUID(x.restrictedRelationshipUUID))
    )
  }

  @JSExport
  def toJSON(c: InstanceRelationshipExistentialRangeRestriction)
  : String
  = encodeInstanceRelationshipExistentialRangeRestriction(c).noSpaces

  @JSExport
  def fromJSON(c: String)
  : InstanceRelationshipExistentialRangeRestriction
  = parse(c) match {
  	case scala.Right(json) =>
  	  decodeInstanceRelationshipExistentialRangeRestriction(json.hcursor) match {
  	    	case scala.Right(result) =>
  	    	  result
  	    	case scala.Left(failure) =>
  	    	  throw failure
  	  }
    case scala.Left(failure) =>
  	  throw failure
  }

}
