package RegEx.impl;


import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.RegExFactory;
import RegEx.RegExPackage;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link RegEx.impl.DistributionFunctionImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link RegEx.impl.DistributionFunctionImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link RegEx.impl.DistributionFunctionImpl#isIsFourierTransformed <em>Is Fourier Transformed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionFunctionImpl extends EObjectImpl implements DistributionFunction {
	/**
	 * The default value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected static final double DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected double distance = DISTANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPoints() <em>Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoints()
	 * @generated
	 * @ordered
	 */
	protected EList points = null;

	/**
	 * The default value of the '{@link #isIsFourierTransformed() <em>Is Fourier Transformed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFourierTransformed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FOURIER_TRANSFORMED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsFourierTransformed() <em>Is Fourier Transformed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFourierTransformed()
	 * @generated
	 * @ordered
	 */
	protected boolean isFourierTransformed = IS_FOURIER_TRANSFORMED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RegExPackage.Literals.DISTRIBUTION_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(double newDistance) {
		double oldDistance = distance;
		distance = newDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.DISTRIBUTION_FUNCTION__DISTANCE, oldDistance, distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPoints() {
		if (points == null) {
			points = new EObjectContainmentEList(Complex.class, this, RegExPackage.DISTRIBUTION_FUNCTION__POINTS);
		}
		return points;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFourierTransformed() {
		return isFourierTransformed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFourierTransformed(boolean newIsFourierTransformed) {
		boolean oldIsFourierTransformed = isFourierTransformed;
		isFourierTransformed = newIsFourierTransformed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RegExPackage.DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED, oldIsFourierTransformed, isFourierTransformed));
	}

	public void makePow2Elements() {
		 EList points = getPoints();		 
		 int i = 0;
		 while(points.size() > java.lang.Math.pow(2, i)) { 
			 i++;
		 }
		 expandTo((int)java.lang.Math.pow(2, i));
	}
	
	public void expandTo(int length) {
		 EList points = getPoints();		 
		 for (int i=points.size(); i < length; i++){
			 points.add(RegExFactory.eINSTANCE.createComplex());
		 }		
	}
	
	public DistributionFunction add(DistributionFunction df) {
		
		Complex[] points1 = getPointArray(); 
		Complex[] points2 = getPointArray(df.getPoints());
		
		if (points1.length < points2.length){
			Complex[] temp = points1;
			points1 = points2;
			points2 = temp;
		}		

		DistributionFunction result = createDF(getDistance());		
		Complex zero = RegExFactory.eINSTANCE.createComplex();
		zero.setIm(0);
		zero.setRe(0);
		for (int i = 0; i < points1.length; i++) {
			if (i < points2.length){
				result.addPoint(points1[i].plus(points2[i]));
			} else {
				result.addPoint(points1[i]);
			}
		}
		return result;
	}

	public DistributionFunction scale(double fac) {
		Complex[] points = getPointArray();
		Complex cfac = RegExFactory.eINSTANCE.createComplex();
		cfac.setRe(fac);
		DistributionFunction result = createDF(getDistance());
		for (int i = 0; i < points.length; i++) {
			result.addPoint(points[i].times(cfac));
		}		
		return result;
	}

	public DistributionFunction multiply(DistributionFunction df2) {
		Complex[] points1 = getPointArray();
		Complex[] points2 = getPointArray(df2.getPoints());
		if (points1.length < points2.length){
			Complex[] temp = points1;
			points1 = points2;
			points2 = temp;
		}		
		DistributionFunction result = createDF(getDistance());
		Complex zero = RegExFactory.eINSTANCE.createComplex();
		zero.setIm(0);
		zero.setRe(0);
		for (int i = 0; i < points1.length; i++) {
			if (i < points2.length){
				result.addPoint(points1[i].times(points2[i]));
			} else {
				result.addPoint(points1[i].times(zero));
			}
		}
		return result;
	}
	
	
	public DistributionFunction getFFT(){
		Complex[] points = getPointArray();
		Complex[] freqPoints = FFT.fft(points);
		DistributionFunction result = createDF(freqPoints, getDistance());
		result.setIsFourierTransformed(true);
		return result;
	}
	
	public DistributionFunction getIFFT(){
		Complex[] freqPoints = getPointArray();
		Complex[] points = FFT.ifft(freqPoints);
		return createDF(points, getDistance());
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DistributionFunction max(DistributionFunction df) {
		if (isIsFourierTransformed() || df.isIsFourierTransformed())			
			return null; // TODO: throw exception
		
		DistributionFunction cdf1 = this.getCDF();
		DistributionFunction cdf2 = this.getCDF();
		DistributionFunction result = cdf1.multiply(cdf2);
		return result.getInvCDF();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DistributionFunction scaleRandomVariable(double factor) {
		DistributionFunction df = createDF(getPointArray(), getDistance() * factor);
		return df.adjustDistance(getDistance());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DistributionFunction getCDF() {
		DistributionFunction cdf = new DistributionFunctionImpl();
		
		Complex currentVal = RegExFactory.eINSTANCE.createComplex();
		for (Iterator iter = getPoints().iterator(); iter.hasNext();) {
			Complex val = (Complex) iter.next();
			currentVal = currentVal.plus(val);
			cdf.addPoint(currentVal);
		}
		return cdf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public DistributionFunction getInvCDF() {
		DistributionFunction df = new DistributionFunctionImpl();
		
		Complex lastVal = RegExFactory.eINSTANCE.createComplex();
		for (Iterator iter = getPoints().iterator(); iter.hasNext();) {
			Complex val = (Complex) iter.next();
			if (val.getRe() == lastVal.getRe()){
				df.addPoint(RegExFactory.eINSTANCE.createComplex());
			}
			else {
				df.addPoint(val.minus(lastVal));				
			}
			lastVal = val;
		}
		return df;
	}
	
	public DistributionFunction adjustDistance(double distance) {
		DistributionFunction df = RegExFactory.eINSTANCE.createDistributionFunction();
		df.setDistance(distance);
		double stepSize = distance / getDistance();
		if (stepSize < 1){
			double pos = stepSize;
			Iterator iter = getPoints().iterator();
			Complex val = (Complex) iter.next();
			boolean active = true;
			while(active){
				while(pos <= 1){
					Complex newVal = RegExFactory.eINSTANCE.createComplex();
					newVal.setRe(stepSize * val.getRe());
					df.addPoint(newVal);
					pos += stepSize;
				}
				Complex newVal = RegExFactory.eINSTANCE.createComplex();
				
				double rightPartSize = pos - 1;
				double leftPartSize = stepSize - rightPartSize;
				double res = leftPartSize * val.getRe();
				if (iter.hasNext()){
					val = (Complex)iter.next();
					res += rightPartSize * val.getRe();
				} else {
					active = false;
				}
				newVal.setRe(res);
				df.addPoint(newVal);				
				pos = rightPartSize + stepSize;
			}
		} else if (stepSize > 1){
			double mark = stepSize / 2;
			double pos = 0;
			double res = 0;
			Iterator iter = getPoints().iterator();
			boolean active = true;
			while(active){
				while((pos < mark) && active){
					if (iter.hasNext()){
						Complex val = (Complex) iter.next();
						res += val.getRe();						
						pos += 1;
					} else {
						active = false;
					}
				}
				double newRes = 0;
				if (iter.hasNext()){
					Complex val = (Complex) iter.next();
					double rightPartSize = pos - mark;
					double leftPartSize = 1 - rightPartSize;
					res += leftPartSize * val.getRe();
					newRes = rightPartSize * val.getRe();
					mark += stepSize;
					pos += 1;
				} else {
					active = false;
				}				
				Complex newVal = RegExFactory.eINSTANCE.createComplex();
				newVal.setRe(res);
				df.addPoint(newVal);
				res = newRes;
			}
		}
		return df;
	}	

	private Complex[] getPointArray(){
		return (Complex[]) getPoints().toArray();
	}
	
	private Complex[] getPointArray(EList pointList){
		return (Complex[]) pointList.toArray();
	}

	public void addPoint(Complex point){
		getPoints().add(point);	
	}
	
	private DistributionFunction createDF(double distance){
		DistributionFunction result = RegExFactory.eINSTANCE.createDistributionFunction();
		result.setDistance(getDistance());
		return result;
	}
	
	private DistributionFunction createDF(Complex[] points, double distance){
		DistributionFunction result = RegExFactory.eINSTANCE.createDistributionFunction();
		result.setDistance(distance);
		for (int i = 0; i < points.length; i++) {
			result.addPoint(points[i]);			
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RegExPackage.DISTRIBUTION_FUNCTION__POINTS:
				return ((InternalEList)getPoints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RegExPackage.DISTRIBUTION_FUNCTION__DISTANCE:
				return new Double(getDistance());
			case RegExPackage.DISTRIBUTION_FUNCTION__POINTS:
				return getPoints();
			case RegExPackage.DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED:
				return isIsFourierTransformed() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RegExPackage.DISTRIBUTION_FUNCTION__DISTANCE:
				setDistance(((Double)newValue).doubleValue());
				return;
			case RegExPackage.DISTRIBUTION_FUNCTION__POINTS:
				getPoints().clear();
				getPoints().addAll((Collection)newValue);
				return;
			case RegExPackage.DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED:
				setIsFourierTransformed(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case RegExPackage.DISTRIBUTION_FUNCTION__DISTANCE:
				setDistance(DISTANCE_EDEFAULT);
				return;
			case RegExPackage.DISTRIBUTION_FUNCTION__POINTS:
				getPoints().clear();
				return;
			case RegExPackage.DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED:
				setIsFourierTransformed(IS_FOURIER_TRANSFORMED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RegExPackage.DISTRIBUTION_FUNCTION__DISTANCE:
				return distance != DISTANCE_EDEFAULT;
			case RegExPackage.DISTRIBUTION_FUNCTION__POINTS:
				return points != null && !points.isEmpty();
			case RegExPackage.DISTRIBUTION_FUNCTION__IS_FOURIER_TRANSFORMED:
				return isFourierTransformed != IS_FOURIER_TRANSFORMED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (distance: ");
		result.append(distance);
		result.append(", isFourierTransformed: ");
		result.append(isFourierTransformed);
		result.append(')');
		return result.toString();
	}

} //DistributionFunctionImpl