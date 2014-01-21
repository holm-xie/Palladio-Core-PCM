package org.palladiosimulator.protocom.tech.rmi;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Collection;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.palladiosimulator.protocom.lang.java.IJClass;
import org.palladiosimulator.protocom.lang.java.IJField;
import org.palladiosimulator.protocom.lang.java.IJMethod;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.ConceptMapping;

/**
 * Common super type for all provider creating Java classes. Defines default values
 * for all templates.
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("all")
public abstract class PojoClass<E extends Entity> extends ConceptMapping<E> implements IJClass {
  public PojoClass(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return null;
  }
  
  public Collection<? extends IJMethod> constructors() {
    LinkedList<IJMethod> _newLinkedList = CollectionLiterals.<IJMethod>newLinkedList();
    return _newLinkedList;
  }
  
  public String packageName() {
    String _implementationPackage = JavaNames.implementationPackage(this.pcmEntity);
    return _implementationPackage;
  }
  
  public String compilationUnitName() {
    String _javaName = JavaNames.javaName(this.pcmEntity);
    return _javaName;
  }
  
  public Collection<String> interfaces() {
    LinkedList<String> _newLinkedList = CollectionLiterals.<String>newLinkedList();
    return _newLinkedList;
  }
  
  public Collection<? extends IJMethod> methods() {
    LinkedList<IJMethod> _newLinkedList = CollectionLiterals.<IJMethod>newLinkedList();
    return _newLinkedList;
  }
  
  public Collection<? extends IJField> fields() {
    LinkedList<IJField> _newLinkedList = CollectionLiterals.<IJField>newLinkedList();
    return _newLinkedList;
  }
  
  public String filePath() {
    String _fileName = JavaNames.getFileName(this.pcmEntity);
    return _fileName;
  }
}