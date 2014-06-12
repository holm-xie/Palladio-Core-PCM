package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import java.util.List
import org.palladiosimulator.protocom.lang.java.IJMethod

class ServletComposedStructurePortClass extends ServletClass<ProvidedRole> {
	new(ProvidedRole pcmEntity) {
		super(pcmEntity)
	}
	
	override packageName() {
		JavaNames::fqnPortPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::portClassName(pcmEntity)
	}
	
	override interfaces() {
		#[JavaNames::fqn((pcmEntity as OperationProvidedRole).providedInterface__OperationProvidedRole)]
	}
	
	override superClass() {
		'''«frameworkBase».common.PortServlet<«JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)»>'''
	}
	
	override annotations() {
		#[
			new JAnnotation()
				.withName("javax.servlet.annotation.WebServlet")
				.withValues(#['''urlPatterns = "/«compilationUnitName»"''', "loadOnStartup = 0"])
		]
	}
	
	override fields() {
		#[
			new JField()
				.asDefaultSerialVersionUID(), 
			
			new JField()
				.withName("compositeComponentOrSystem")
				.withType(JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)),
			
			new JField()
				.withName("innerPort")
				.withType(JavaNames::fqn((pcmEntity as OperationProvidedRole).providedInterface__OperationProvidedRole))
		]
	}
	
	override constructors() {
		#[
//			new JMethod()
//				.withParameters(JavaNames::fqn((pcmEntity as OperationProvidedRole).providedInterface__OperationProvidedRole) + " innerPort, " + JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole) + " compositeComponentOrSystem, String assemblyContext")
//				.withImplementation('''
//					this.innerPort = innerPort;
//					this.compositeComponentOrSystem = compositeComponentOrSystem;
//					
//					//«frameworkBase».registry.Registry.register();
//					
//					//org.palladiosimulator.protocom.framework.registry.RmiRegistry.registerPort(org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRemoteAddress(),
//					//org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRegistryPort(), this, "«JavaNames::portClassName(pcmEntity)»_" + assemblyContext);
//				'''), 
				
			new JMethod()
				.withImplementation('''
				''')
		]
	}
	
	override methods() {
		var String iface
		var result = newLinkedList
		
		if (pcmEntity instanceof OperationProvidedRole) {
			iface = JavaNames::fqn(pcmEntity.providedInterface__OperationProvidedRole)
		}
		
		result +=
			new JMethod()
				.withVisibilityModifier("public")
				.withParameters("String componentId, String assemblyContext")
				.withName("start")
				.withThrows('''«frameworkBase».modules.ModuleStartException''')
				.withImplementation('''
					System.out.println("Starting system port");
					this.component = («JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)») «frameworkBase».common.LocalComponentRegistry.getInstance().getComponent(assemblyContext);
					
					try {
						innerPort = («JavaNames::fqn((pcmEntity as OperationProvidedRole).providedInterface__OperationProvidedRole)») «frameworkBase».registry.Registry.lookup(componentId);
					} catch («frameworkBase».registry.RegistryException e) {
						e.printStackTrace();
					}
					
					try {
						Class<?>[] interfaces = new Class<?>[] {«iface».class, «frameworkBase».common.IPort.class};
						«frameworkBase».registry.Registry.register("«JavaNames::portClassName(pcmEntity)»", interfaces, location, "/«JavaNames::portClassName(pcmEntity)»");
					} catch («frameworkBase».registry.RegistryException e) {
						throw new «frameworkBase».modules.ModuleStartException();
					}
				''')
		
		result +=
			new JMethod()
				.withVisibilityModifier("public")
				.withParameters("Object context")
				.withName("setContext")
				.withImplementation('''
				''')
				
		result += providedRoleMethods(pcmEntity)
						
		result
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnPortPackage(pcmEntity)) + "/" + JavaNames::portClassName(pcmEntity) + ".java"
	}
	
	def dispatch providedRoleMethods(OperationProvidedRole role) {
		role.providedInterface__OperationProvidedRole.signatures__OperationInterface.map[
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType('''«frameworkBase».stubs.SimulatedStackframe<Object>''')
				.withParameters('''«frameworkBase».stubs.StackContext ctx''')
				.withImplementation("return innerPort." + JavaNames::javaSignature(it) + "(ctx);")			
		]
	}
	
	def dispatch List<JMethod> providedRoleMethods(InfrastructureProvidedRole role) {
		#[]
	}
}