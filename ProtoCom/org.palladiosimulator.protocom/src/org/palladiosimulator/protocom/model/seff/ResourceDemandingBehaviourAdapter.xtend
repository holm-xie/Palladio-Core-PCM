package org.palladiosimulator.protocom.model.seff

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour
import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.seff.StartAction

/**
 * @author Christian Klaussner
 */
class ResourceDemandingBehaviourAdapter extends ModelAdapter<ResourceDemandingBehaviour> {
	new(ResourceDemandingBehaviour entity) {
		super(entity)
	}
	
	def getStart() {
		val start = entity.steps_Behaviour.findFirst[StartAction.isInstance(it)]
		return new StartActionAdapter(start as StartAction)
	}
}
