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

package gov.nasa.jpl.imce.oml.resolver.api

/*
 * An OML TerminologyExtensionAxiom allows an extendingTerminology to
 * make references (via OML TerminologyBoxStatement(s)) to OML TerminologyThing(s)
 * declared within the transitive closure of the extendedTerminlogy.
 */
trait TerminologyExtensionAxiom
  extends TerminologyBoxAxiom
{
  override val uuid: taggedTypes.TerminologyExtensionAxiomUUID

  val extendedTerminology: gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI

  def extendingTerminology
  ()(implicit extent: Extent): scala.Option[TerminologyBox]
  /*
   * The extendingTerminology is the source
   */
  override def source
  ()(implicit extent: Extent): scala.Option[TerminologyBox]
  /*
   * The extendedTerminology is the target
   */
  override def target
  ()(implicit extent: Extent): gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI
}

object TerminologyExtensionAxiom {

  def extendingTerminology
  (t: TerminologyExtensionAxiom, ext: Extent)
  : scala.Option[TerminologyBox]
  = t.extendingTerminology()(ext)

  def source
  (t: TerminologyExtensionAxiom, ext: Extent)
  : scala.Option[TerminologyBox]
  = t.source()(ext)

  def target
  (t: TerminologyExtensionAxiom, ext: Extent)
  : gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI
  = t.target()(ext)

}
