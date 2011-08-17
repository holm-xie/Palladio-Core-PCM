/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Link Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Throughput and performance specification of linking resources
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getLinkingResource_CommunicationLinkResourceSpecification <em>Linking Resource Communication Link Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getCommunicationLinkResourceType_CommunicationLinkResourceSpecification <em>Communication Link Resource Type Communication Link Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getLatency_CommunicationLinkResourceSpecification <em>Latency Communication Link Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getThroughput_CommunicationLinkResourceSpecification <em>Throughput Communication Link Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification()
 * @model
 * @generated
 */
public interface CommunicationLinkResourceSpecification extends Identifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Linking Resource Communication Link Resource Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getCommunicationLinkResourceSpecifications_LinkingResource <em>Communication Link Resource Specifications Linking Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linking Resource Communication Link Resource Specification</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linking Resource Communication Link Resource Specification</em>' container reference.
	 * @see #setLinkingResource_CommunicationLinkResourceSpecification(LinkingResource)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification_LinkingResource_CommunicationLinkResourceSpecification()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getCommunicationLinkResourceSpecifications_LinkingResource
	 * @model opposite="communicationLinkResourceSpecifications_LinkingResource" required="true" transient="false" ordered="false"
	 * @generated
	 */
	LinkingResource getLinkingResource_CommunicationLinkResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getLinkingResource_CommunicationLinkResourceSpecification <em>Linking Resource Communication Link Resource Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linking Resource Communication Link Resource Specification</em>' container reference.
	 * @see #getLinkingResource_CommunicationLinkResourceSpecification()
	 * @generated
	 */
	void setLinkingResource_CommunicationLinkResourceSpecification(LinkingResource value);

	/**
	 * Returns the value of the '<em><b>Failure Probability</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the probability that a service call over this communication link fails. The failure could be due to message loss or overload, for example.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Failure Probability</em>' attribute.
	 * @see #setFailureProbability(double)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification_FailureProbability()
	 * @model default="0.0" required="true" ordered="false"
	 * @generated
	 */
	double getFailureProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getFailureProbability <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Probability</em>' attribute.
	 * @see #getFailureProbability()
	 * @generated
	 */
	void setFailureProbability(double value);

	/**
	 * Returns the value of the '<em><b>Communication Link Resource Type Communication Link Resource Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication Link Resource Type Communication Link Resource Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Link Resource Type Communication Link Resource Specification</em>' reference.
	 * @see #setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(CommunicationLinkResourceType)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification_CommunicationLinkResourceType_CommunicationLinkResourceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CommunicationLinkResourceType getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getCommunicationLinkResourceType_CommunicationLinkResourceSpecification <em>Communication Link Resource Type Communication Link Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication Link Resource Type Communication Link Resource Specification</em>' reference.
	 * @see #getCommunicationLinkResourceType_CommunicationLinkResourceSpecification()
	 * @generated
	 */
	void setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(CommunicationLinkResourceType value);

	/**
	 * Returns the value of the '<em><b>Latency Communication Link Resource Specification</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecification_latency_PCMRandomVariable <em>Communication Link Resource Specification latency PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latency Communication Link Resource Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the latency of this linking resource in the simulated time unit. The latency is the time that a message on this linking resource takes to receive the receiver. In synchronous communication (call and return), the latency is added twice to the duration, once for the call and once for the response. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Latency Communication Link Resource Specification</em>' containment reference.
	 * @see #setLatency_CommunicationLinkResourceSpecification(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification_Latency_CommunicationLinkResourceSpecification()
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecification_latency_PCMRandomVariable
	 * @model opposite="communicationLinkResourceSpecification_latency_PCMRandomVariable" containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getLatency_CommunicationLinkResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getLatency_CommunicationLinkResourceSpecification <em>Latency Communication Link Resource Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latency Communication Link Resource Specification</em>' containment reference.
	 * @see #getLatency_CommunicationLinkResourceSpecification()
	 * @generated
	 */
	void setLatency_CommunicationLinkResourceSpecification(PCMRandomVariable value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Throughput Communication Link Resource Specification</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable <em>Communication Link Resource Specifcation throughput PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throughput Communication Link Resource Specification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the maximum throughput of this linking resource in byte per simulated time unit. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Throughput Communication Link Resource Specification</em>' containment reference.
	 * @see #setThroughput_CommunicationLinkResourceSpecification(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getCommunicationLinkResourceSpecification_Throughput_CommunicationLinkResourceSpecification()
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getCommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable
	 * @model opposite="communicationLinkResourceSpecifcation_throughput_PCMRandomVariable" containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getThroughput_CommunicationLinkResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification#getThroughput_CommunicationLinkResourceSpecification <em>Throughput Communication Link Resource Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throughput Communication Link Resource Specification</em>' containment reference.
	 * @see #getThroughput_CommunicationLinkResourceSpecification()
	 * @generated
	 */
	void setThroughput_CommunicationLinkResourceSpecification(PCMRandomVariable value);

} // CommunicationLinkResourceSpecification
