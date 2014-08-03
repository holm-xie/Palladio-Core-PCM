package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.repository.PassiveResource
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.repository.PassiveResource",
	"pcm.seff.AbstractInternalControlFlowAction",
	"pcm.seff.seff_performance.ParametricResourceDemand",
	"pcm.seff.seff_performance.ResourceCall"
])
abstract class ResourcesXpt {
	// For each resource demand load a resource
	def resourceDemands(AbstractInternalControlFlowAction aicfa) '''
		�FOR action : aicfa.resourceDemand_Action��action.resourceDemandTM��ENDFOR�
		�FOR action : aicfa.resourceCall__Action��action.resourceDemandTM��ENDFOR�
	'''
	
	// What to do with the actual demand is target dependant
	def CharSequence resourceDemandTM(ParametricResourceDemand prd)

	def CharSequence resourceDemandTM(ResourceCall rc)
	
	def CharSequence passiveResourceInitTM(PassiveResource pr)
}