package org.hibernate.criterion;

public final class MathProjections {

	private MathProjections() {}
	
	public static SimpleProjection add(Object... properties) {
		return new SimpleOperatorProjection(" + ", properties);
	}
	
	public static SimpleProjection sub(Object... properties) {
		return new SimpleOperatorProjection(" - ", properties);
	}
	
	public static SimpleProjection mul(Object... properties) {
		return new SimpleOperatorProjection(" * ", properties);
	}
	
	public static SimpleProjection div(Object... properties) {
		return new SimpleOperatorProjection(" / ", properties);
	}
	
	public static SimpleProjection mod(Object... properties) {
		return new SimpleOperatorProjection(" % ", properties);
	}
	
}
