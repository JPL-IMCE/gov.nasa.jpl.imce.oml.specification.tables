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
 
package gov.nasa.jpl.imce.omf.schema.resolved

/*
 * A TerminologyExtensionAxiom allows an extendingTerminology to
 * make references (via TerminologyStatements) to TerminologyThings
 * within the transitive closure of the extendedTerminlogy.
 * OMF: https://github.jpl.nasa.gov/pages/imce/gov.nasa.jpl.omf.scala.core/latest/api/index.html#gov.nasa.jpl.omf.scala.core.OMF@TerminologyGraphDirectExtensionAxiom<:OMFtbox.this.TerminologyGraphAxiom
 * OWL: https://github.jpl.nasa.gov/pages/imce/gov.nasa.jpl.omf.scala.binding.owlapi/latest/api/gov/nasa/jpl/omf/scala/binding/owlapi/types/TerminologyGraphDirectExtensionAxiom.html#inheritance-diagram
 */
trait TerminologyExtensionAxiom
  extends TerminologyAxiom
{

  val extendingTerminology: TerminologyBox
  val extendedTerminology: TerminologyBox

  /*
   * The extendingTerminology is the source
   */
  override val source: TerminologyBox
  /*
   * The extendedTerminology is the target
   */
  override val target: TerminologyBox
}